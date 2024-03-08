package com.bernaagdeve.backroundodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    private ArrayList<Integer> Renkler = new ArrayList<>();
    private int b_index=0;
    private boolean calistir = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Renkler.add(R.color.mavi);
        Renkler.add(R.color.pembe);
        Renkler.add(R.color.yesil);
        Renkler.add(R.color.mor);
        Renkler.add(R.color.sari);

        Button stopButton = findViewById(R.id.btVar1);
        Button startButton = findViewById(R.id.btVar2);

        relativeLayout = findViewById(R.id.rlVar1);

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calistir = false;
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calistir = true;
                    ArkaplanrenkDegistir(relativeLayout);


            }
        });
    }

    private void ArkaplanrenkDegistir(final RelativeLayout layout1) { Thread t = new Thread(new Runnable() {
        public void run() {
            while (b_index < Renkler.size()) {
                if (calistir) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            layout1.setBackgroundResource(Renkler.get(b_index));
                        }
                    });

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b_index++;
                }
            }


            b_index = 0;
        }
    });
        t.start();

    }
}
