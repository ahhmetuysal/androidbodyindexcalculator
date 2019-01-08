package tr.edu.mu.ceng.gui.bodyindexcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class bmiCalculationActivity extends AppCompatActivity {
 public Bundle getWeightData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculation);
        final TextView textView_ideal = findViewById(R.id.textView_ideal);
        final TextView textView_condition = findViewById(R.id.textView_condition);
        Button home = findViewById(R.id.homebutton);

        update();



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView_ideal.clearComposingText();
                textView_condition.clearComposingText();

                Intent i = new Intent(bmiCalculationActivity.this,MainActivity.class);

                startActivity(i);

                update();


            }
        });




    }

    private void update() {


        getWeightData = getIntent().getExtras();
        Boolean isMale = getWeightData.getBoolean("isMale");
        final String height_text = getWeightData.getString("bmiHeight");
        final String weight_text = getWeightData.getString("bmiWeight");


        float ideal_weight_male = (float) (50 + 2.3 * (Float.parseFloat(height_text) * 0.4 - 60));
        float ideal_weight_female = (float) (45.5 + 2.3 * (Float.parseFloat(String.valueOf(height_text)) * 0.4 - 60));


        double ht = (Integer.parseInt(height_text));
        double weight = Integer.parseInt(weight_text);
        double vki = (weight/(((ht*0.01))*(ht*0.01)));

        final TextView textView_ideal = findViewById(R.id.textView_ideal);
        final TextView textView_condition = findViewById(R.id.textView_condition);



        if (isMale == true) {

            textView_ideal.setText(String.valueOf(ideal_weight_male) + " kg");

            if (vki <= 20.7) {

                //textView_condition.setBackgroundResource(R.color.thin);
                textView_condition.setBackgroundResource(R.drawable.thin);
                textView_condition.setText(R.string.thin);
                //textView_condition.setText(String.valueOf(vki) + " " + (String.valueOf((ht*0.01))+ " " + (String.valueOf(weight))));


            } else if (20.7 < vki && vki <= 26.4) {

                //textView_condition.setBackgroundResource(R.color.ideal);
                textView_condition.setBackgroundResource(R.drawable.my_button);
                textView_condition.setText(R.string.ideal);


            } else if (26.4 < vki && vki <= 27.8) {

                //textView_condition.setBackgroundResource(R.color.surplusweight);
                textView_condition.setBackgroundResource(R.drawable.surplus);
                textView_condition.setText(R.string.surplusweight);


            } else if (27.8 < vki && vki <= 31.1) {

                //textView_condition.setBackgroundResource(R.color.overweight);
                textView_condition.setBackgroundResource(R.drawable.overweight);
                textView_condition.setText(R.string.overweight);


            } else if (31.1 < vki) {

                //textView_condition.setBackgroundResource(R.color.obese);
                textView_condition.setBackgroundResource(R.drawable.obese);
                textView_condition.setText(R.string.obese);


            }
        } else if (isMale == false) {

            textView_ideal.setText(String.valueOf(ideal_weight_female)+" kg");

            if (vki <= 19.1) {
                //textView_condition.setBackgroundResource(R.color.thin);
                textView_condition.setBackgroundResource(R.drawable.thin);
                textView_condition.setText(R.string.thin);


            } else if (19.1 < vki && vki <= 25.8) {

                //textView_condition.setBackgroundResource(R.color.ideal);
                textView_condition.setBackgroundResource(R.drawable.my_button);
                textView_condition.setText(R.string.ideal);


            } else if (25.8 < vki && vki <= 27.3) {

                //textView_condition.setBackgroundResource(R.color.surplusweight);
                textView_condition.setBackgroundResource(R.drawable.surplus);
                textView_condition.setText(R.string.surplusweight);


            } else if (27.3 < vki && vki <= 32.3) {

                //textView_condition.setBackgroundResource(R.color.overweight);
                textView_condition.setBackgroundResource(R.drawable.overweight);
                textView_condition.setText(R.string.overweight);


            } else if (32.3 < vki) {

                //textView_condition.setBackgroundResource(R.color.obese);
                textView_condition.setBackgroundResource(R.drawable.obese);
                textView_condition.setText(R.string.obese);


            }




        }



    }


    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()== android.R.id.home){

            this.finish();
            return true;

        }
        return super.onOptionsItemSelected(item);

    }


}


