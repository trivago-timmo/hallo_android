package de.mulaschnick.hallo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HalloAndroidActivity extends Activity
{
    private static final String TAG = Activity.class.getSimpleName();

    private TextView message;
    private EditText eingabe;

    private Button end_button;
    private Button save_button;
    private Button list_button;
    private Button json_response;

    private Bundle data = new Bundle();
    private DatabaseHelper dbHelper;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        dbHelper = new DatabaseHelper(this);
        message = (TextView) findViewById(R.id.message);
        message.setText(R.string.willkommen);

        end_button = (Button) findViewById(R.id.end_button);
        save_button = (Button) findViewById(R.id.save_button);
        list_button = (Button) findViewById(R.id.list_button);
        json_response = (Button) findViewById(R.id.json_button);

        eingabe = (EditText) findViewById(R.id.name);

        eingabe.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                if (eingabe.length() > 0)
                {
                    save_button.setVisibility(View.VISIBLE);
                }
                else
                {
                    save_button.setVisibility(View.INVISIBLE);
                }
            }
        });

        list_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (eingabe.getText().length() > 0)
                {
                    dbHelper.insert(eingabe.getText().toString());
                }

                Intent i = new Intent(view.getContext(), HelloNameList.class);
//                data.putCharSequence("message", eingabe.getText());
//                i.putExtras(data);
                startActivity(i);
            }
        });

        save_button.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(view.getContext(), InstanceStateDemo.class);
                data.putCharSequence("message", eingabe.getText());
                i.putExtras(data);
                startActivity(i);
            }
        });

        json_response.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(view.getContext(), JsonRequestActivity.class);
                startActivity(i);
            }
        });

        end_button.setOnClickListener(new View.OnClickListener()
        {
           public void onClick(View view)
           {
                finish();
           }
        });
    }
}
