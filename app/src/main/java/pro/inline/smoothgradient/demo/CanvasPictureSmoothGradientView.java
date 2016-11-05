package pro.inline.smoothgradient.demo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/**
 * Created on 04.11.16.
 *
 * @author Sergey Vasilenko (vasilenko.sn@gmail.com)
 */

public class CanvasPictureSmoothGradientView extends AbstractDrawableView {
	public CanvasPictureSmoothGradientView(Context context) {
		super(context);
	}

	public CanvasPictureSmoothGradientView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CanvasPictureSmoothGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected Drawable createDrawable() {
		return new CanvasPictureSmoothGradientDrawable();
	}
}
