package com.sergeivasilenko.smoothgradient.demo.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sergeivasilenko.smoothgradient.demo.R;
import com.sergeivasilenko.smoothgradient.demo.model.RenderingType;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "SmoothGradient";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.invalidateButton).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				invalidate();
			}
		});

		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

		RenderingTypeAdapter adapter = new RenderingTypeAdapter(RenderingType.getTypes());
		recyclerView.setAdapter(adapter);
	}

	private void invalidate() {
		Log.i(TAG, "Invalidate");
		ViewGroup viewGroup = (ViewGroup) findViewById(R.id.activity_main);
		int childCount = viewGroup.getChildCount();
		for (int i = 0; i < childCount; i++) {
			viewGroup.getChildAt(i).invalidate();
		}
	}

	private static class RenderingTypeAdapter extends RecyclerView.Adapter<TextViewHolder> {

		private SparseArray<RenderingType> mList;

		RenderingTypeAdapter(SparseArray<RenderingType> list) {
			mList = list;
		}

		@Override
		public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			View v = inflater.inflate(R.layout.recycler_view_item, parent, false);
			return new TextViewHolder(v);
		}

		@Override
		public void onBindViewHolder(TextViewHolder holder, int position) {
			final RenderingType type = mList.valueAt(position);
			holder.textView.setText(type.getName());
			holder.textView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Context context = v.getContext();
					Intent intent = new Intent(context, DemoActivity.class);
					intent.putExtra(DemoActivity.EXTRA_RENDERING_TYPE, type.getType());
					context.startActivity(intent);
				}
			});
		}

		@Override
		public int getItemCount() {
			return mList.size();
		}
	}

	private static class TextViewHolder extends RecyclerView.ViewHolder {

		TextView textView;

		public TextViewHolder(View itemView) {
			super(itemView);
			textView = (TextView) itemView;
		}
	}
}
