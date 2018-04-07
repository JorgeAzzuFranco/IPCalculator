package com.tresemejota.ipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText getIP,getMask,netID,broadC,cantH,parteR,parteH;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText para modificar
        getIP = (EditText) findViewById(R.id.editIP);
        getMask = (EditText) findViewById(R.id.editMascara);
        netID = (EditText) findViewById(R.id.editNetID);
        broadC = (EditText) findViewById(R.id.editBroadcast);
        cantH = (EditText) findViewById(R.id.editCantHost);
        parteR = (EditText) findViewById(R.id.editParteRed);
        parteH = (EditText) findViewById(R.id.editParteHost);

    }

    public void cuentaIP (View v) {

        //Partiendo octetos de la IP
        String[] strIP = getIP.getText().toString().split("\\.");

        //Variables que contendran la IP, mascara, mascara invertida y el valor del numero de la mascara
        long numIP = 0;
        long numMask = 0;
        long invertMask = 0;
        int maskInt = Integer.parseInt(getMask.getText().toString());

        if (strIP.length != 4) return;

        //Obteniendo la IP transformada a binario
        for (int i = 3; i >= 0; i--) {
            numIP |= (Long.parseLong(strIP[3 - i])) << (i * 8);
        }

        //Obteniendo la Mascara de red transformada a binario
        for (int i = 1; i <= maskInt; i++) {
            numMask |= 1L << (32 - i);
        }

        //Invirtiendo bits de la mascara
        invertMask = ~numMask;

        //Asignando a los EditText
        netID.setText(longToIP(numIP & numMask));
        broadC.setText(longToIP(numIP | invertMask));
        cantH.setText((int)(Math.pow(2, (double)(32-maskInt))) -2 + "");
        parteR.setText(maskInt + "");
        parteH.setText((32-maskInt) + "");

    }

    //Convierte de tipo Long a String
    public String longToIP(long numIP){
        String strIP="";
        for(int i=3; i>=0; i--) {
            strIP += (0b1111_1111 & (numIP >> (i*8) )) + (i!=0? ".": "");
        }
        return strIP;
    }
}
