package de.mulaschnick.hallo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.EventListener;

public class InstanceStateDemo extends Activity {

	private static final String TAG = InstanceStateDemo.class.getSimpleName();
    private Bundle extras;
    private TextView message;
    private Button back;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.state);

        extras = getIntent().getExtras();
        message = (TextView) findViewById(R.id.message2);
        message.setText(getString(R.string.hallo, extras.getCharSequence("message")));

        back = (Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });

        Log.d(TAG, extras.getCharSequence("message").toString());

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