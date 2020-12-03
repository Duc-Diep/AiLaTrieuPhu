package com.dumv.ailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

import java.util.Random;

public class DialogKhanGiaTraLoi extends Dialog {
    public DialogKhanGiaTraLoi(Context context,int vtD) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dilog_tro_giup_khan_gia);
        TextView txvChonA,txvChonB,txvChonC,txvChonD;
        txvChonA = findViewById(R.id.txvChonA);
        txvChonB = findViewById(R.id.txvChonB);
        txvChonC = findViewById(R.id.txvChonC);
        txvChonD = findViewById(R.id.txvChonD);

        // 3
        int arrdrom[] = new int[]{0,0,0,0};
        int can = 25;
        for(int i=0;i<arrdrom.length;i++){
            arrdrom[i]=arrdrom[i]+can;// 25 50 100 125
            if(i==vtD-1){
                arrdrom[i]=arrdrom[i]+25; // 25 50 100
                can = can+25;//100
            }
            can = can+25;//can 125
        }

        int tong = 125;
        int arrPhanTramTl[] = new int[]{0,0,0,0}; // a  b  c d
        int soKhanGia = 200;
        Random r = new Random();
        for(int i=0;i<soKhanGia;i++){
            int chon = r.nextInt(tong);// 0 25 75 100 125
            if(chon>=0 && chon<arrdrom[0]){
                arrPhanTramTl[0]++;
            }else if(chon>= arrdrom[0] && chon<arrdrom[1]){
                arrPhanTramTl[1]++;
            }else if(chon>= arrdrom[1] && chon<arrdrom[2]){
                arrPhanTramTl[2]++;
            }else {
                arrPhanTramTl[3]++;
            }
        }
        txvChonA.setText("A : "+(int)(arrPhanTramTl[0]*100.0f/soKhanGia)+" %");
        txvChonB.setText("B : "+(int)(arrPhanTramTl[1]*100.0f/soKhanGia)+" %");
        txvChonC.setText("C : "+(int)(arrPhanTramTl[2]*100.0f/soKhanGia)+" %");
        txvChonD.setText("D : "+(int)(arrPhanTramTl[3]*100.0f/soKhanGia)+" %");

    }
}
