package com.sergeivasilenko.smoothgradient.demo.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created on 04.11.16.
 *
 * @author Sergey Vasilenko (vasilenko.sn@gmail.com)
 */

public abstract class AbstractDrawableView extends ImageView {
	public AbstractDrawableView(Context context) {
		super(context);
		init();
	}

	public AbstractDrawableView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public AbstractDrawableView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public AbstractDrawableView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init();
	}

	private void init() {
		setScaleType(ScaleType.FIT_CENTER);
		Drawable drawable = createDrawable();
		setBackground(drawable);
	}

	protected abstract Drawable createDrawable();
}
