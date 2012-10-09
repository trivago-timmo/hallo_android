package de.mulaschnick.hallo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class InstanceStateDemo extends Activity {

	private static final String TAG = InstanceStateDemo.class.getSimpleName();
    private Bundle extras;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        extras = getIntent().getExtras();

        Log.d(TAG, extras.getString("test"));

		if (savedInstanceState == null) {
			Log.d(TAG, "savedInstanceState war null");
		} else {
			Log.d(TAG,
					"wurde vor "
							+ (System.currentTimeMillis() - savedInstanceState
									.getLong(TAG)) + " Millisekunden beendet");
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putLong(TAG, System.currentTimeMillis());
	}
}