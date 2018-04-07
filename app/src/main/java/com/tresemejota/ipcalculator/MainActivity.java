package com.tresemejota.ipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.file.ClosedDirectoryStreamException;
import java.util.StringTokenizer;

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
        TextView estadolIP = (TextView) findViewById(R.id.controlIp);
        TextView estadoMask = (TextView) findViewById(R.id.controlMask);

        //Strings de IP y Mascara
        String strIP = getIP.getText().toString();
        String strMask = getMask.getText().toString();

        //Split de Octetos
        StringTokenizer octetos = new StringTokenizer(strIP,".");

        String soct1 = octetos.nextToken();
        String soct2 = octetos.nextToken();
        String soct3 = octetos.nextToken();
        String soct4 = octetos.nextToken();

        //Split de Mascara
        StringTokenizer mascara = new StringTokenizer(strMask,".");

        String smask1 = mascara.nextToken();
        String smask2 = mascara.nextToken();
        String smask3 = mascara.nextToken();
        String smask4 = mascara.nextToken();

        //Pasando a octetos a enteros
        int oct1 = Integer.parseInt(soct1);
        int oct2 = Integer.parseInt(soct2);
        int oct3 = Integer.parseInt(soct3);
        int oct4 = Integer.parseInt(soct4);

        //Pasando mascara a entero
        int mask1 = Integer.parseInt(smask1);
        int mask2 = Integer.parseInt(smask2);
        int mask3 = Integer.parseInt(smask3);
        int mask4 = Integer.parseInt(smask4);

        Log.d("valores mascara: ", String.valueOf(mask1)+"."+String.valueOf(mask2)+"."+String.valueOf(mask3)+"."+String.valueOf(mask4));

        if(oct1 <= 255 && oct2 <= 255 && oct3 <= 255 && oct4 <= 255 &&
           mask1 <= 255 && mask2 <= 255 && mask3 <= 255 && mask4 <= 255){
            estadolIP.setText("IP correcta");
            estadoMask.setText("Mascara correcta");

            //Trabajo de negro

            //NetID
            //No se si funciona

            if(mask4 == 0){
                netID.setText(soct1+"."+soct2+"."+soct3+".0");
            }
            if (mask3 == 0 && mask4 ==0){
                netID.setText(soct1+"."+soct2+".0.0");
            }
            else if (mask2 == 0 && mask3 == 0 && mask4 == 0){
                netID.setText(soct1+".0.0.0");
            }

            Log.d("valores IP NoProc: ", String.valueOf(oct1)+"."+String.valueOf(oct2)+"."+String.valueOf(oct3)+"."+String.valueOf(oct4));
            Log.d("valores mask NoProc: ", String.valueOf(mask1)+"."+String.valueOf(mask2)+"."+String.valueOf(mask3)+"."+String.valueOf(mask4));

            //Broadcast Hace el calculo pero al imprmir dan negativo
            int bcip1 = oct1 | ~mask1;
            int bcip2 = oct1 | ~mask2;
            int bcip3 = oct1 | ~mask3;
            int bcip4 = oct1 | ~mask4;

            Log.d("valores OR: ", String.valueOf(bcip1)+"."+String.valueOf(bcip2)+"."+String.valueOf(bcip1)+"."+String.valueOf(bcip1));

            //Prueba
            /*int bcip1a = -bcip1;
            int bcip2a = -bcip2;
            int bcip3a = -bcip3;
            int bcip4a = -bcip4;*/

            //Pasando a string Para mostrar
            String strbcip1 = String.valueOf(bcip1);
            String strbcip2 = String.valueOf(bcip2);
            String strbcip3 = String.valueOf(bcip3);
            String strbcip4 = String.valueOf(bcip4);

            Log.d("Final: ", strbcip1+"."+strbcip2+"."+strbcip3+"."+strbcip4);

            broadC.setText(strbcip1+"."+strbcip2+"."+strbcip3+"."+strbcip4);



        }
        else{
            estadolIP.setText("IP incorrecta");
            estadoMask.setText("Mascara incorrecta");
        }

    }
}