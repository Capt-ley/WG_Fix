package mydemoapp.com.mydemoapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class FeedbackActivity extends Activity {


    Button submit;
    EditText feedback;
    TextView category;
    String feedbackText;
    String categoryname;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedbacklayout);
        feedback = (EditText)findViewById(R.id.editTextFeedback);
        category = (TextView) findViewById(R.id.textViewCat);
        submit = (Button) findViewById(R.id.submit);
        Intent intent = getIntent();
        categoryname = intent.getExtras().getString("rooms");


    }

    @Override
    public void onResume() {
        super.onResume();

        category.setText(categoryname);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedbackText = feedback.getText().toString();
             if(!feedbackText.isEmpty()) {
                 Intent intent = new Intent(getApplicationContext(), SummaryActivity.class);
                 intent.putExtra("feedback", feedbackText);
                 startActivity(intent);
                 finish();
             }
             else{
                 Toast.makeText(FeedbackActivity.this, "Please enter the feedback to continue",Toast.LENGTH_LONG).show();
             }

            }
        });




    }

}
