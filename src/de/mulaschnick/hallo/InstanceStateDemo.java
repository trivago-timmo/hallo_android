package de.mulaschnick.hallo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;

public class InstanceStateDemo extends Activity {

	private static final String TAG = InstanceStateDemo.class.getSimpleName();
    private Bundle extras;
    private TextView message;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.state);

        extras = getIntent().getExtras();
        message = (TextView) findViewById(R.id.message2);
        message.setText(getString(R.string.hallo, extras.getCharSequence("test")));

        Log.d(TAG, extras.getCharSequence("test").toString());

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