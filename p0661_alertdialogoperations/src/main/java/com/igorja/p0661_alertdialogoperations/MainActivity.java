package com.igorja.p0661_alertdialogoperations;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";
    final int DIALOG = 1;

    Dialog dialog;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG) {
            Log.d(LOG_TAG, "Create");
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Title");
            adb.setMessage("Message");
            adb.setPositiveButton("OK", null);
            dialog = adb.create();

            // обработчик отображения
            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialog) {
                    Log.d(LOG_TAG, "Show");
                }
            });

            // обработчик отмены
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    Log.d(LOG_TAG, "Cancel");
                }
            });

            // обработчик закрытия
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialog) {
                    Log.d(LOG_TAG, "Dismiss");
                }
            });
            return dialog;
        }
        return super.onCreateDialog(id);
    }

    public void onclick(View v) {
        showDialog(DIALOG);
    }
}