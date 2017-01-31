package mydemoapp.com.mydemoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;



public class HomeActivity extends Activity {

    private String[] arraySpinner;
    Button next;
    String selectedItemText;
    boolean isSelected=false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        this.arraySpinner = new String[] {
                "Select","RH.35", "RH.37"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner);
        next = (Button)findViewById(R.id.button4);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // If user change the default selection
                // First item is disable and it is used for hint
                 String selectedItemText1 = (String) parent.getItemAtPosition(position);


                if(selectedItemText1.equalsIgnoreCase("select")){
                    isSelected =false;
                }
                else{
                    isSelected =true;
                }

                if(position > 0){

                    selectedItemText = (String) parent.getItemAtPosition(position);
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                isSelected =false;
            }
        });



    }

    @Override
    public void onResume() {
        super.onResume();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isSelected) {

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("apartment", selectedItemText);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText
                            (getApplicationContext(), "Please select the apartment to proceed", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });




    }

}
