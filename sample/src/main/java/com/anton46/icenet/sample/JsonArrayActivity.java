package com.anton46.icenet.sample;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import labs.anton.icenet.IceNet;
import labs.anton.icenet.RequestCallback;
import labs.anton.icenet.RequestError;

/**
 * Created by anton on 10/31/14.
 */
public class JsonArrayActivity extends Activity {
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.list);

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        IceNet.connect()
                .createRequest()
                .get()
                .pathUrl("/notes")
                .fromJsonArray()
                .mappingInto(Notes.class)
                .execute("request_string", new RequestCallback<Notes>() {
                    @Override
                    public void onRequestSuccess(Notes notes) {
                        dialog.dismiss();
                        String[] values = new String[notes.size()];
                        for (int i = 0 ; i < notes.size(); i++)
                            values[i] = notes.get(i).getTitle();

                        adapter = new ArrayAdapter<String>(JsonArrayActivity.this,
                                android.R.layout.simple_list_item_1, android.R.id.text1, values);

                        listView.setAdapter(adapter);
                    }

                    @Override
                    public void onRequestError(RequestError error) {
                        dialog.dismiss();
                    }
                });

    }
}
