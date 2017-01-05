package com.example.alexanderberezovsky.basiccalculator;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {


    double num1, num2;
    String sign = "";
    String total = "";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;




    public void OnClick(View v) {
        Button button = (Button) v;
        String str = button.getText().toString();
        total += str;
        EditText edit = (EditText) findViewById(R.id.editText);
        edit.setText(total);
    }

    public void OnAdd(View v) {
        num1 = Double.parseDouble(total);
        total = "";
        Button button = (Button) v;
        String str = button.getText().toString();
        sign = str;
        EditText edit = (EditText) findViewById(R.id.editText);
        edit.setText("");


    }

    public void OnCalculate(View v) {
        EditText edit = (EditText) findViewById(R.id.editText);
        String str2 = edit.getText().toString();
        num2 = Double.parseDouble(total);
        double grand_total = 0;

        if (sign.equals("+")) {
            grand_total = num1 + num2;
        } else if (sign.equals("-")) {
            grand_total = num1 - num2;
        } else if (sign.equals("*")) {
            grand_total = num1 * num2;
        } else if (sign.equals("/")) {
            grand_total = num1 / num2;
        }
        edit.setText(grand_total + "");


    }

    public void OnClear(View v) {
        EditText edit = (EditText) findViewById(R.id.editText);
        edit.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
