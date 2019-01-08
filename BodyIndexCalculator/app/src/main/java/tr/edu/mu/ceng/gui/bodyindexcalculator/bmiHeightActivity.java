package tr.edu.mu.ceng.gui.bodyindexcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class bmiHeightActivity extends AppCompatActivity {
    public  Bundle getGenderData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_height);
        final EditText bmiHeightText = findViewById(R.id.bmi_height_editText);
        Button bmi_height_button = findViewById(R.id.bmi_height_button);

        getGenderData=getIntent().getExtras();
        final boolean isMale=getGenderData.getBoolean("isMale");

        bmi_height_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bmiHeightText.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please input your height", Toast.LENGTH_LONG).show();

                }
                else{
                    String bmiHeight=bmiHeightText.getText().toString();

                    Bundle Bundle3 = new Bundle();
                    Bundle3.putBoolean("isMale",isMale);
                    Bundle3.putString("bmiHeight",bmiHeight);


                    Intent i = new Intent(bmiHeightActivity.this,bmiWeightActivity.class);

                    i.putExtras(Bundle3);


                    startActivity(i);

                }
            }
        });


    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()== android.R.id.home){

            this.finish();
            return true;

        }
        return super.onOptionsItemSelected(item);

    }


 }
