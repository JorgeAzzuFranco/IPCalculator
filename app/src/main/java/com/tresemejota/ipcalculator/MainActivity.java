package com.tresemejota.ipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void cuentaIPs (View v){
        EditText getIP = (EditText) findViewById(R.id.editIP);
        EditText getMask = (EditText) findViewById(R.id.editMascara);

        String strIP = Integer.toBinaryString(Integer.parseInt(getIP.getText().toString()));
        String strMask = Integer.toBinaryString(Integer.parseInt(getMask.getText().toString()));

        String  res = strIP || !strMask;
    }
}
