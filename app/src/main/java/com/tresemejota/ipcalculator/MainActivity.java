package com.tresemejota.ipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        char[] ip = editToChar(getIP);
        char[] mask = editToChar(getMask);

        EditText netId = (EditText) findViewById(R.id.editNetID);
        netId.setText(ip.toString() + "");

        EditText bcast = (EditText) findViewById(R.id.editBroadcast);
        netId.setText(mask.toString() + "");
    }

    public char[] editToChar (EditText ttc){

        char[] charArray;
        charArray = new char[15];

        for(int i=1;i<ttc.length()+1;i++){
            String str = ttc.getText().toString();
           charArray = str.toCharArray();
        }

        return charArray;
    }
}
