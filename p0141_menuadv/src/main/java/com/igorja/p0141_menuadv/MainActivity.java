package com.igorja.p0141_menuadv;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends Activity {

    // Элементы экрана
    TextView tv;
    CheckBox chb;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // находим эдементы
        tv = (TextView) findViewById(R.id.textView);
        chb = (CheckBox) findViewById(R.id.chbExtMenu);

    }

    // создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // обновление меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
        menu.setGroupVisible(R.id.group1, chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }



    // обработка нажатий
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        // Выведем в TextView информацию о нажатом пункте меню
        tv.setText("Item Menu" + "\r\n groupId: " + String.valueOf(item.getGroupId()) + "\r\n itemId: " + String.valueOf(item.getItemId()) + "\r\n order: " + String.valueOf(item.getOrder()) + "\r\n title: " + item.getTitle());

        return super.onOptionsItemSelected(item);
    }
}