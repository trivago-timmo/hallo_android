package de.mulaschnick.hallo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

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
        json_request = (Button) findViewById(R.id.json_button);

        json_request.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String uri = json_text.getText().toString();

                try
                {
                    HttpClient client = new DefaultHttpClient();
                    HttpGet request = new HttpGet(uri);
                    HttpResponse response = client.execute(request);

                    HttpEntity entity = response.getEntity();
                    Log.d(TAG, entity.toString());
                } catch (Exception e)
                {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });
    }
}
