package tr.edu.mu.ceng.gui.bodyindexcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class bmrGoalActivity extends AppCompatActivity {

    public  Bundle getAgeData;
    public  String bmrGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_goal);

        final RadioButton rd_lose = findViewById(R.id.lose);
        final RadioButton rd_gain = findViewById(R.id.gain);
        final RadioButton rd_stay = findViewById(R.id.stay);
        final Button calculate_basal = findViewById(R.id.calculate_basal);



        getAgeData= getIntent().getExtras();
        final boolean isMale = getAgeData.getBoolean("isMale");
        final String bmrHeight = getAgeData.getString("bmrHeight");
        final String bmrWeight = getAgeData.getString("bmrWeight");
        final String bmrAge = getAgeData.getString("bmrAge");

        calculate_basal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!rd_lose.isChecked() & !rd_gain.isChecked() & !rd_stay.isChecked()) {

                    Toast.makeText(getApplicationContext(), "Please choose your goal", Toast.LENGTH_SHORT).show();

                }
                else{

                    if (rd_lose.isChecked()){

                        bmrGoal="lose";
                        Bundle Bundle5 = new Bundle();
                        Bundle5.putBoolean("isMale", isMale);
                        Bundle5.putString("bmrHeight", bmrHeight);
                        Bundle5.putString("bmrWeight", bmrWeight);
                        Bundle5.putString("bmrAge", bmrAge);
                        Bundle5.putString("bmrGoal", bmrGoal);


                        Intent i = new Intent(bmrGoalActivity.this, bmrCalculationActivity.class);

                        i.putExtras(Bundle5);

                        startActivity(i);


                    }
                    if (rd_gain.isChecked()){

                        bmrGoal="gain";
                        Bundle Bundle5 = new Bundle();
                        Bundle5.putBoolean("isMale", isMale);
                        Bundle5.putString("bmrHeight", bmrHeight);
                        Bundle5.putString("bmrWeight", bmrWeight);
                        Bundle5.putString("bmrAge", bmrAge);
                        Bundle5.putString("bmrGoal", bmrGoal);


                        Intent i = new Intent(bmrGoalActivity.this, bmrCalculationActivity.class);

                        i.putExtras(Bundle5);

                        startActivity(i);


                    }
                    if (rd_stay.isChecked()){

                        bmrGoal="stay";
                        Bundle Bundle5 = new Bundle();
                        Bundle5.putBoolean("isMale", isMale);
                        Bundle5.putString("bmrHeight", bmrHeight);
                        Bundle5.putString("bmrWeight", bmrWeight);
                        Bundle5.putString("bmrAge", bmrAge);
                        Bundle5.putString("bmrGoal", bmrGoal);


                        Intent i = new Intent(bmrGoalActivity.this, bmrCalculationActivity.class);

                        i.putExtras(Bundle5);

                        startActivity(i);


                    }



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