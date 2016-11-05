package com.sergeivasilenko.smoothgradient.demo.ui;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.sergeivasilenko.hyperbolagradient.HyperbolaGradientDrawable;
import com.sergeivasilenko.smoothgradient.demo.R;
import com.sergeivasilenko.smoothgradient.demo.drawable.CanvasLineSmoothGradientDrawable;
import com.sergeivasilenko.smoothgradient.demo.drawable.CanvasPictureSmoothGradientDrawable;
import com.sergeivasilenko.smoothgradient.demo.drawable.CanvasPointSmoothGradientDrawable;
import com.sergeivasilenko.smoothgradient.demo.model.RenderingType;

/**
 * Created on 05.11.16.
 *
 * @author Sergey Vasilenko (vasilenko.sn@gmail.com)
 */

public class DemoActivity extends AppCompatActivity {

	public static final String EXTRA_RENDERING_TYPE = "EXTRA_RENDERING_TYPE";

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);

		int renderingType = getIntent().getIntExtra(EXTRA_RENDERING_TYPE, RenderingType.TYPE_CANVAS_POINT);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
		setupActionBar(appBarLayout, toolbar, RenderingType.getTypes().get(renderingType));
	}

	private void setupActionBar(AppBarLayout appBarLayout, Toolbar toolbar, RenderingType type) {
		setSupportActionBar(toolbar);

		Drawable drawable = createDrawable(type.getType());
		appBarLayout.setBackground(drawable);

		ActionBar ab = getSupportActionBar();
		assert ab != null;
		ab.setDisplayHomeAsUpEnabled(true);
		ab.setDefaultDisplayHomeAsUpEnabled(true);
		ab.setDisplayShowTitleEnabled(true);
		ab.setTitle(type.getName());

		Drawable homeAsUpIndication = getDrawable(R.drawable.abc_ic_ab_back_material);
		homeAsUpIndication.setTint(Color.WHITE);
		homeAsUpIndication.setTintMode(PorterDuff.Mode.MULTIPLY);
		ab.setHomeAsUpIndicator(homeAsUpIndication);
	}

	private Drawable createDrawable(int renderingType) {
		switch (renderingType) {
			case RenderingType.TYPE_CANVAS_POINT:
				return new CanvasPointSmoothGradientDrawable();
			case RenderingType.TYPE_CANVAS_LINE:
				return new CanvasLineSmoothGradientDrawable();
			case RenderingType.TYPE_CANVAS_PICTURE:
				return new CanvasPictureSmoothGradientDrawable();
			case RenderingType.TYPE_CANVAS_BITMAP:
				return new HyperbolaGradientDrawable();
			default:
				throw new IllegalArgumentException("Unknown rendering type: " + renderingType);
		}
	}
}
