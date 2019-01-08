package tr.edu.mu.ceng.gui.bodyindexcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class bmrAgeActivity extends AppCompatActivity {
 public Bundle getWeightData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_age);

        final EditText bmrAgeText = findViewById(R.id.editText_age);
        Button bmrAgeButton = findViewById(R.id.Button_age);

        getWeightData = getIntent().getExtras();


        final boolean isMale= getWeightData.getBoolean("isMale");
        final String bmrHeight = getWeightData.getString("bmrHeight");
        final String bmrWeight = getWeightData.getString("bmrWeight");

        bmrAgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bmrAgeText.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(), "Please input your age", Toast.LENGTH_SHORT).show();


                } else {


                    String bmrAge= bmrAgeText.getText().toString();

                    Bundle Bundle4 = new Bundle();
                    Bundle4.putBoolean("isMale", isMale);
                    Bundle4.putString("bmrWeight", bmrHeight);
                    Bundle4.putString("bmrHeight", bmrWeight);
                    Bundle4.putString("bmrAge", bmrAge);


                    Intent i = new Intent(bmrAgeActivity.this, bmrGoalActivity.class);

                    i.putExtras(Bundle4);


                    startActivity(i);

                }




            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()== android.R.id.home){

            this.finish();
            return true;

        }
        return super.onOptionsItemSelected(item);

    }


}


