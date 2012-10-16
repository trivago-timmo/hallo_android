package de.mulaschnick.hallo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created with IntelliJ IDEA.
 * User: iluvatar
 * Date: 16.10.12
 * Time: 23:47
 * To change this template use File | Settings | File Templates.
 */
public class JsonRequestActivity extends Activity
{
    private final static String TAG = JsonRequestActivity.class.getSimpleName();
    private Button json_request;
    private EditText json_text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
        setContentView(R.layout.test_json);

        json_text = (EditText) findViewById(R.id.json_url);

        json_request.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String uri = json_text.getText().toString();

                HttpClient httpClient = new DefaultHttpClient();
                HttpUriRequest httpGet = new HttpGet(uri);
            }
        });
    }
}
