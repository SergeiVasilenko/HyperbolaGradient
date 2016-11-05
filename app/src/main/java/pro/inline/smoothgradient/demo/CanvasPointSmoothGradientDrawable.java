package pro.inline.smoothgradient.demo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;

/**
 * Created on 04.11.16.
 *
 * @author Sergey Vasilenko (vasilenko.sn@gmail.com)
 */

public class CanvasPointSmoothGradientDrawable extends Drawable {

	private static final String TAG = "CanvasDrawing";

	private final Paint mPaint;

	private float mBearingAlpha;

	public CanvasPointSmoothGradientDrawable() {
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setColor(Color.BLACK);
		mBearingAlpha = 0.6f;
	}

	public void setColor(int color) {
		mPaint.setColor(color);
	}

	@Override
	public void draw(Canvas canvas) {
		Rect bounds = getBounds();
		int alpha = 0;
		float y;
		long startDrawing = System.nanoTime();
		for (int i = 0; i < bounds.height(); i++) {
			y = 1f * i / bounds.height();
			float alphaRelative = 3 / (4 * (y + 0.5f)) - 0.5f;
			alpha = (int) (alphaRelative * mBearingAlpha * 255);
			mPaint.setAlpha(alpha);
			for (int j = 0; j < bounds.width(); j++) {
				canvas.drawPoint(j, i, mPaint);
			}
		}
		Log.v(TAG, "t: " + (System.nanoTime() - startDrawing) + "ns - drawing points");
	}

	@Override
	public void setAlpha(int alpha) {
		// do nothing
	}

	public void setBearingAlpha(float alpha) {
		mBearingAlpha = alpha;
	}

	@Override
	public void setColorFilter(ColorFilter colorFilter) {

	}

	@Override
	public int getOpacity() {
		return PixelFormat.TRANSLUCENT;
	}
}
