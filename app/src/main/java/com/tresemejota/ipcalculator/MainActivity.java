package com.tresemejota.ipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.nio.file.ClosedDirectoryStreamException;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void cuentaIP (View v){

        //EditText para editar
        EditText getIP = (EditText) findViewById(R.id.editIP);
        EditText getMask = (EditText) findViewById(R.id.editMascara);
        EditText netID = (EditText) findViewById(R.id.editNetID);
        EditText broadC = (EditText) findViewById(R.id.editBroadcast);
        EditText cantH = (EditText) findViewById(R.id.editCantHost);
        EditText parteR = (EditText) findViewById(R.id.editParteRed);
        EditText parteH = (EditText) findViewById(R.id.editParteHost);

        //TextView para editar


    }
}