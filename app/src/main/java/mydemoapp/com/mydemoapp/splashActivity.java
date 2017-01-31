package mydemoapp.com.mydemoapp;


import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;



public class splashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }


        Intent intent = new Intent(this, LoginActivity.class);
           startActivity(intent);
           finish();


    }
}
