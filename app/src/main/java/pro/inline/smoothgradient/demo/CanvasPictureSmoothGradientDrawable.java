package pro.inline.smoothgradient.demo;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created on 04.11.16.
 *
 * @author Sergey Vasilenko (vasilenko.sn@gmail.com)
 */

public class CanvasPictureSmoothGradientDrawable extends Drawable {

	private static final String TAG = "CanvasDrawing";

	private final Paint mPaint;

	private Picture mPicture;

	private float mBearingAlpha;

	public CanvasPictureSmoothGradientDrawable() {
		mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		mPaint.setColor(Color.BLACK);
		mBearingAlpha = 0.6f;
		mPicture = new Picture();
	}

	public void setColor(int color) {
		mPaint.setColor(color);
	}

	@Override
	public void draw(@NonNull Canvas canvas) {
		Rect bounds = getBounds();
		int alpha;
		float y;
		long startDrawing = System.nanoTime();
		Canvas tmp = mPicture.beginRecording(bounds.width(), bounds.height());
		for (int i = 0; i < bounds.height(); i++) {
			y = 1f * i / bounds.height();
			float alphaRelative = 3 / (4 * (y + 0.5f)) - 0.5f;
			alpha = (int) (alphaRelative * mBearingAlpha * 255);
			mPaint.setAlpha(alpha);
			tmp.drawLine(0, i, bounds.width(), i, mPaint);
		}
		mPicture.endRecording();
		mPicture.draw(canvas);
		Log.v(TAG, "t: " + (System.nanoTime() - startDrawing) + "ns - drawing picture");
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
