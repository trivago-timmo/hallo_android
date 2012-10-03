package de.mulaschnick.hallo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HalloAndroidActivity extends Activity
{
    private TextView message;
    private Button knopf;
    private EditText eingabe;
    private boolean bFirstClick;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        message = (TextView) findViewById(R.id.message);
        message.setText(R.string.willkommen);

        knopf = (Button) findViewById(R.id.knopf);
        knopf.setText(R.string.weiter);

        eingabe = (EditText) findViewById(R.id.name);
        bFirstClick = true;

        knopf.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (bFirstClick == true)
                {
                    message.setText(getString(R.string.hallo, eingabe.getText()));
                    knopf.setText(R.string.beenden);
                    bFirstClick = false;
                }
                else
                {
                    finish();
                }
            }
        });
    }
}
