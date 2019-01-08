package tr.edu.mu.ceng.gui.bodyindexcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class bmrCalculationActivity extends AppCompatActivity {

    public Bundle getGoalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_calculation);

        TextView text_basal = (TextView) findViewById(R.id.text_basal);
        TextView text_reach = (TextView) findViewById(R.id.text_reach);
        TextView text_condition = (TextView) findViewById(R.id.text_condition);
        Button home_basal = (Button)findViewById(R.id.home_button_basal) ;
        Button questionmark = (Button)findViewById(R.id.questionmark);

        getGoalData = getIntent().getExtras();
        boolean isMale = getGoalData.getBoolean("isMale");
        final String bmrHeight = getGoalData.getString("bmrHeight");
        final String bmrWeight = getGoalData.getString("bmrWeight");
        final String bmrAge = getGoalData.getString("bmrAge");
        final String bmrGoal = getGoalData.getString("bmrGoal");


        double ht = Integer.parseInt(bmrHeight);
        double wt = Integer.parseInt(bmrWeight);
        int age = Integer.parseInt(bmrAge);


        if (isMale == true) {


            double bmr_male = (int) (66 + (13.75 * wt) + (5 * ht) - (6.8 * age));


            text_basal.setText("   " + (int) (bmr_male) + " kcal   ");


            if (bmrGoal.equals("lose")) {


                text_reach.setText("   " + (int) (bmr_male - 500) + " kcal   ");

                text_condition.setText("You should take " + text_reach.getText().toString() + " per day to lose weight");


            }
            if (bmrGoal.equals("gain")) {

                text_reach.setText("   " + (int) (bmr_male + 500) + " kcal   ");

                text_condition.setText("You should take " + text_reach.getText().toString() + " per day to gain weight");


            }
            if (bmrGoal.equals("stay")) {

                text_reach.setText("   " + (int) (bmr_male) + " kcal   ");

                text_condition.setText("You should take " + text_reach.getText().toString() + " per day to stay this weight");


            }}

        else  {


            double bmr_female = (int) (655 + (9.6 * wt) + (1.7 * ht) - (4.7 * age));


            text_basal.setText("   " + (int) (bmr_female) + " kcal   ");


            if (bmrGoal.equals("lose")) {


                text_reach.setText("   " + (int) (bmr_female - 500) + " kcal   ");

                text_condition.setText("You should take " + text_reach.getText().toString() + " per day to lose weight");


            }
            if (bmrGoal.equals("gain")) {

                text_reach.setText("   " + (int) (bmr_female + 500) + " kcal   ");

                text_condition.setText("You should take " + text_reach.getText().toString() + " per day to gain weight");


            }
            if (bmrGoal.equals("stay")) {

                text_reach.setText("   " + (int) (bmr_female) + " kcal   ");

                text_condition.setText("You should take " + text_reach.getText().toString() + " per day to stay this weight");


            }


        }

        home_basal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(bmrCalculationActivity.this,MainActivity.class);

                startActivity(i);


            }
        });

        questionmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Total number of calories that your body needs to perform basic, life-sustaining functions",Toast.LENGTH_LONG).show();

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
