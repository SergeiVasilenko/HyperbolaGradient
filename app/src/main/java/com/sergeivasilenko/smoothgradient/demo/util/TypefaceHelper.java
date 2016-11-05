package com.sergeivasilenko.smoothgradient.demo.util;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;

import java.util.Locale;

public class TypefaceHelper {

	private static final String TAG = "TypefaceHelper";

	private static final SparseArray<String>   mTypefacesPaths = new SparseArray<>();
	private static final SparseArray<Typeface> mTypefacesCache = new SparseArray<>();

	private static final String BASE_PATH = "fonts/";

	static {
		mTypefacesPaths.append(0, "RobotoBlack.ttf");
		mTypefacesPaths.append(1, "RobotoBold.ttf");
		mTypefacesPaths.append(2, "RobotoLight.ttf");
		mTypefacesPaths.append(3, "RobotoMedium.ttf");
		mTypefacesPaths.append(4, "RobotoRegular.ttf");
		mTypefacesPaths.append(5, "RobotoThin.ttf");
	}

	@Nullable
	public static Typeface getTypefaceByIndex(@NonNull Context context, int typefaceIndex) {
		Typeface typeface = mTypefacesCache.get(typefaceIndex);

		if (typeface == null) {
			try {
				String typefacePath = mTypefacesPaths.get(typefaceIndex);
				if (TextUtils.isEmpty(typefacePath)) {
					Log.e(TAG, String.format(Locale.US, "Can\'t find typeface path for index = %d", typefaceIndex));
					return null;
				}

				typeface = Typeface.createFromAsset(context.getAssets(), BASE_PATH + typefacePath);
			} catch (Exception e) {
				Log.e(TAG, String.format(Locale.US, "Can\'t find typeface for index = %d", typefaceIndex), e);
				return null;
			}

			mTypefacesCache.put(typefaceIndex, typeface);
		}

		return typeface;
	}
}