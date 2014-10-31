package com.anton46.icenet.sample;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import labs.anton.icenet.IceNet;
import labs.anton.icenet.RequestCallback;
import labs.anton.icenet.RequestError;

/**
 * Created by anton on 10/31/14.
 */
public class StringActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        final TextView result = (TextView) findViewById(R.id.tv_result);
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
        IceNet.connect()
                .createRequest()
                .get()
                .pathUrl("/string")
                .fromString()
                .execute("request_string", new RequestCallback<String>() {
                    @Override
                    public void onRequestSuccess(String str) {
                        dialog.dismiss();
                        result.setText(str);
                    }

                    @Override
                    public void onRequestError(RequestError error) {
                        dialog.dismiss();
                    }
                });

    }
}
