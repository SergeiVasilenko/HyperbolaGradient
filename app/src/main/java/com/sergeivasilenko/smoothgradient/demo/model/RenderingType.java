package com.sergeivasilenko.smoothgradient.demo.model;

import android.util.SparseArray;

/**
 * Created on 05.11.16.
 *
 * @author Sergey Vasilenko (vasilenko.sn@gmail.com)
 */

public class RenderingType {

	public static final int TYPE_CANVAS_POINT   = 0;
	public static final int TYPE_CANVAS_LINE    = 1;
	public static final int TYPE_CANVAS_PICTURE = 2;
	public static final int TYPE_CANVAS_BITMAP  = 3;

	private static final SparseArray<RenderingType> sTypes;

	static {
		SparseArray<RenderingType> types = new SparseArray<>();
		types.append(TYPE_CANVAS_POINT, new RenderingType("Canvas point (very slow)", TYPE_CANVAS_POINT));
		types.append(TYPE_CANVAS_LINE, new RenderingType("Canvas line", TYPE_CANVAS_LINE));
		types.append(TYPE_CANVAS_PICTURE, new RenderingType("Canvas picture", TYPE_CANVAS_PICTURE));
		types.append(TYPE_CANVAS_BITMAP, new RenderingType("Canvas bitmap (HyperbolaGradient library)", TYPE_CANVAS_BITMAP));
		sTypes = types;
	}

	public static SparseArray<RenderingType> getTypes() {
		return sTypes;
	}

	private String mName;
	private int    mType;

	private RenderingType(String name, int type) {
		mName = name;
		mType = type;
	}

	public String getName() {
		return mName;
	}

	public int getType() {
		return mType;
	}
}
