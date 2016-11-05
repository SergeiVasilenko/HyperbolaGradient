package pro.inline.smoothgradient.demo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

/**
 * Created on 04.11.16.
 *
 * @author Sergey Vasilenko (vasilenko.sn@gmail.com)
 */

public class GreenDrawableView extends AbstractDrawableView {
	public GreenDrawableView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public GreenDrawableView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public GreenDrawableView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}

	@Override
	protected Drawable createDrawable() {
		return new GreenDrawable();
	}
}
