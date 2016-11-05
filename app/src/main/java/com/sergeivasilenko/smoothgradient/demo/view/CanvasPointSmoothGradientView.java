package com.sergeivasilenko.smoothgradient.demo.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.sergeivasilenko.smoothgradient.demo.drawable.CanvasPointSmoothGradientDrawable;

/**
 * Created on 04.11.16.
 *
 * @author Sergey Vasilenko (vasilenko.sn@gmail.com)
 */

public class CanvasPointSmoothGradientView extends AbstractDrawableView {
	public CanvasPointSmoothGradientView(Context context) {
		super(context);
	}

	public CanvasPointSmoothGradientView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CanvasPointSmoothGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected Drawable createDrawable() {
		return new CanvasPointSmoothGradientDrawable();
	}
}
