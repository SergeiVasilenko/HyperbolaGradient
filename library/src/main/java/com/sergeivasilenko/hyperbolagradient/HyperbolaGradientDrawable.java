/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sergeivasilenko.hyperbolagradient;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * Simple example how to draw hyperbola gradient. This approach works twice faster than drawing lines through Canvas
 * at first drawing and 20 times at other drawings. Also this approach gets better quality of gradient than other.
 */
public class HyperbolaGradientDrawable extends Drawable {

	private static final int ALPHA_DEFAULT = (int) (0.6f * 255);

	private int mAlpha = ALPHA_DEFAULT;
	private int mColor;
	private Rect  mBmpRect = new Rect();
	private int[] mColors  = new int[0];
	private Bitmap mBmp;

	@Override
	public void draw(Canvas canvas) {
		Rect bounds = getBounds();
		if (mColors.length != bounds.height()) {
			int alpha;
			float y, alphaRelative;
			mColors = new int[bounds.height()];
			for (int i = 0; i < bounds.height(); i++) {
				y = ((float) i) / bounds.height();
				// this function gives approximately 0.5 of the bearing alpha at 3/10ths closed to the darker end
				alphaRelative = 3 / (4 * (y + 0.5f)) - 0.5f;
				alpha = (int) (alphaRelative * mAlpha);
				mColors[i] = alpha << 24 | mColor;
			}
			mBmp = Bitmap.createBitmap(mColors, 1, bounds.height(), Bitmap.Config.ARGB_8888);
			mBmpRect.set(0, 0, 1, bounds.height());
		}
		canvas.drawBitmap(mBmp, mBmpRect, bounds, null);
	}

	public void setColor(int color) {
		// remove alpha chanel
		mColor = color & 0x00FFFFFF;
	}

	@Override
	public void setAlpha(int alpha) {
		mAlpha = alpha;
	}

	@Override
	public void setColorFilter(ColorFilter colorFilter) {

	}

	@Override
	public int getOpacity() {
		return PixelFormat.TRANSLUCENT;
	}
}
