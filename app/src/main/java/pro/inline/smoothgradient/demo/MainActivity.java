package pro.inline.smoothgradient.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

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
	}

	private void invalidate() {
		Log.i(TAG, "Invalidate");
		ViewGroup viewGroup = (ViewGroup) findViewById(R.id.activity_main);
		int childCount = viewGroup.getChildCount();
		for (int i = 0; i < childCount; i++) {
			viewGroup.getChildAt(i).invalidate();
		}
	}
}
