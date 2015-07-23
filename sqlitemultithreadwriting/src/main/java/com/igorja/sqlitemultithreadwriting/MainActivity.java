package com.igorja.sqlitemultithreadwriting;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainActivity extends Activity {

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /******************* Intialize Database *************/
        DBAdapter.init(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // clear table
        DBAdapter.deleteAllUserData();
        Log.d(LOG_TAG, "All user data deleted");
    }

    public void onclickInsert(View v) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    Long thread_id = Thread.currentThread().getId();
                    Log.d(LOG_TAG, "Start inserting contacts from thread id = " + thread_id);
                    DBAdapter.init(MainActivity.this.getApplicationContext());
                    // waiting after obtain adapter
                    TimeUnit.SECONDS.sleep(10);
                    // Inserting Contacts
                    DBAdapter.addUserData(new UserData("thread_" + thread_id, "0"));
                    Log.d(LOG_TAG, "Stop inserting contacts from thread id = " + thread_id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public void onclickRead(View v) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    Long thread_id = Thread.currentThread().getId();
                    Log.d(LOG_TAG, "Reading all contacts from thread id = " + thread_id);
                    DBAdapter.init(MainActivity.this.getApplicationContext());
                    // Reading all contacts
                    List<UserData> data = DBAdapter.getAllUserData();
                    for (UserData dt : data) {
                        String log = "Id: " + dt.getID() + " ,Name: " + dt.getName() + " ,Phone: " + dt.getEmail();
                        // Writing Contacts to log
                        Log.d(LOG_TAG, log);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}