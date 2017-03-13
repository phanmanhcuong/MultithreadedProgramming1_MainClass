package com.example.cuongphan.multithreadedprogramming_mainactivity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FlipCoinActivity extends Activity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip_coin);
    }

    public void flipCoin(View view){
        for(int i=0; i<5; i++){
            //Thread t = new Thread();
            //t.start();
            ExecutorService taskList = Executors.newFixedThreadPool(5);
            taskList.execute(this); //thread 1
            taskList.execute(this); // thread 2
            //Thread.sleep(1000);
        }
    }
    @Override
    public void run() {
        int coin_sum = 0;
        int coin;
        Random rd = new Random();
        for (int i=0; i<1000; i++){
            coin = rd.nextInt(2);
            if(coin_sum == (coin_sum + coin)){
                coin_sum = 0;
            }
            else {
                coin_sum += coin;
                if(coin_sum >= 3){
                    System.out.println(""+ Thread.currentThread().getName() +" i: "+i );
                }

            }
        }
    }
}
