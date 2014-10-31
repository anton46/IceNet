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
public class JsonObjectActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_object);

        final TextView id = (TextView) findViewById(R.id.tv_id);
        final TextView title = (TextView) findViewById(R.id.tv_title);

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        IceNet.connect()
                .createRequest()
                .get()
                .pathUrl("/notes/1")
                .fromJsonObject()
                .mappingInto(Note.class)
                .execute("request_string", new RequestCallback<Note>() {
                    @Override
                    public void onRequestSuccess(Note note) {
                        dialog.dismiss();
                        id.setText(note.getId());
                        title.setText(note.getTitle());
                    }

                    @Override
                    public void onRequestError(RequestError error) {
                        dialog.dismiss();
                    }
                });

    }
}
