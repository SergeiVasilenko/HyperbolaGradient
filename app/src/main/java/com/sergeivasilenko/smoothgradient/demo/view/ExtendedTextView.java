package com.sergeivasilenko.smoothgradient.demo.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

import com.sergeivasilenko.smoothgradient.demo.R;
import com.sergeivasilenko.smoothgradient.demo.util.TypefaceHelper;


public class ExtendedTextView extends TextView {

	public ExtendedTextView(Context context) {
		super(context);
	}

	public ExtendedTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		applyAttrs(context, attrs, 0, 0);
	}

	public ExtendedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		applyAttrs(context, attrs, defStyleAttr, 0);
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public ExtendedTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		applyAttrs(context, attrs, defStyleAttr, defStyleRes);
	}

	private void applyAttrs(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		if (attrs != null) {
			TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ExtendedTextView, defStyleAttr, defStyleRes);

			try {
				int typefaceIndex = a.getInt(R.styleable.ExtendedTextView_typeface, 0);
				setTypeface(typefaceIndex);
			} finally {
				a.recycle();
			}
		}
	}

	private void setTypeface(int typefaceIndex) {
		Typeface typeface = TypefaceHelper.getTypefaceByIndex(getContext(), typefaceIndex);
		if (typeface != null) {
			setTypeface(typeface);
		}
	}
}