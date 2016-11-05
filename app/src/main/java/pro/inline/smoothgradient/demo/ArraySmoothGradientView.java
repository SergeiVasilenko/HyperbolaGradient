package pro.inline.smoothgradient.demo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import pro.inline.hyperbolagradient.HyperbolaGradientDrawable;

/**
 * Created on 04.11.16.
 *
 * @author Sergey Vasilenko (vasilenko.sn@gmail.com)
 */

public class ArraySmoothGradientView extends AbstractDrawableView {
	public ArraySmoothGradientView(Context context) {
		super(context);
	}

	public ArraySmoothGradientView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ArraySmoothGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected Drawable createDrawable() {
		return new HyperbolaGradientDrawable();
	}
}
