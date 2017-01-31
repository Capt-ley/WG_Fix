package mydemoapp.com.mydemoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;




public class SummaryActivity extends Activity {


    Button close;

    TextView summary;
    String feedbackText;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summarylayout);

        summary = (TextView) findViewById(R.id.summary);
        close = (Button) findViewById(R.id.close);

        Intent intent = getIntent();
        feedbackText = intent.getExtras().getString("feedback");

    }

    @Override
    public void onResume() {
        super.onResume();

        summary.setText(feedbackText);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             finish();

            }
        });




    }

}
