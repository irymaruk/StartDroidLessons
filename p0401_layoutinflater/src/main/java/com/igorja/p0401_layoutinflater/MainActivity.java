package com.igorja.p0401_layoutinflater;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        LayoutInflater ltInflater = getLayoutInflater();
        View view = ltInflater.inflate(R.layout.text, null, false);
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        LinearLayout linLayout = (LinearLayout) findViewById(R.id.linLayout);
        linLayout.addView(view);

        Log.d(LOG_TAG, "Class of view: " + view.getClass().toString());
        Log.d(LOG_TAG, "LayoutParams of view is null: " + (lp == null));
        Log.d(LOG_TAG, "Text of view: " + ((TextView) view).getText());
    }
}