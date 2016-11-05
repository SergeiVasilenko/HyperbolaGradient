package com.sergeivasilenko.smoothgradient.demo.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.sergeivasilenko.hyperbolagradient.HyperbolaGradientDrawable;

/**
 * Created on 04.11.16.
 *
 * @author Sergey Vasilenko (vasilenko.sn@gmail.com)
 */

public class BitmapGradientView extends AbstractDrawableView {
	public BitmapGradientView(Context context) {
		super(context);
	}

	public BitmapGradientView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public BitmapGradientView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected Drawable createDrawable() {
		return new HyperbolaGradientDrawable();
	}
}
