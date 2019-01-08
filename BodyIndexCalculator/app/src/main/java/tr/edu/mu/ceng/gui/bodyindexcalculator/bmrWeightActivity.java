package tr.edu.mu.ceng.gui.bodyindexcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class bmrWeightActivity extends AppCompatActivity {
    public Bundle getHeightData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_weight);

        final EditText bmrWeightText = findViewById(R.id.bmr_weight_editText);
        final Button bmr_weight_button = findViewById(R.id.bmr_weight_button);

        getHeightData = getIntent().getExtras();
        final boolean isMale = getHeightData.getBoolean("isMale");
        final String bmrHeight = getHeightData.getString("bmrHeight");


        bmr_weight_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bmrWeightText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please input your weight", Toast.LENGTH_LONG).show();
                }
                else{
                    String bmrWeight = bmrWeightText.getText().toString();
                    Bundle  Bundle4=new Bundle();
                    Bundle4.putBoolean("isMale", isMale);
                    Bundle4.putString("bmrHeight", bmrHeight);
                    Bundle4.putString("bmrWeight", bmrWeight);

                    Intent i = new Intent(bmrWeightActivity.this, bmrAgeActivity.class);
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


