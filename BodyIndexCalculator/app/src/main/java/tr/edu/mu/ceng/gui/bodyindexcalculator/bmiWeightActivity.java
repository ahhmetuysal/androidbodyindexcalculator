package tr.edu.mu.ceng.gui.bodyindexcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class bmiWeightActivity extends AppCompatActivity {
    public Bundle getHeightData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_weight);

        final EditText bmiWeightText = findViewById(R.id.bmi_weight_editText);
        final Button bmi_weight_button = findViewById(R.id.bmi_weight_button);

        getHeightData = getIntent().getExtras();
        final boolean isMale = getHeightData.getBoolean("isMale");
        final String bmiHeight = getHeightData.getString("bmiHeight");


        bmi_weight_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bmiWeightText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input your weight", Toast.LENGTH_LONG).show();
                }
                else{
                    String bmiWeight = bmiWeightText.getText().toString();
                    Bundle  Bundle4=new Bundle();
                    Bundle4.putBoolean("isMale", isMale);
                    Bundle4.putString("bmiHeight", bmiHeight);
                    Bundle4.putString("bmiWeight", bmiWeight);

                    Intent i = new Intent(bmiWeightActivity.this, bmiCalculationActivity.class);
                    i.putExtras(Bundle4);
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



