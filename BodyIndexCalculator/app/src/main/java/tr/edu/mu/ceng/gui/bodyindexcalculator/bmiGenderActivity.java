package tr.edu.mu.ceng.gui.bodyindexcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class bmiGenderActivity extends AppCompatActivity {
 public Bundle getMainData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_gender);
        final ImageButton bmimale = findViewById(R.id.bmimale);
        final ImageButton bmifemale = findViewById(R.id.bmifemale);

        getMainData=getIntent().getExtras();
        bmimale.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Boolean isMale = true;
                Bundle Bundle2 = new Bundle();
                Bundle2.putBoolean("isMale", isMale);


                Intent i = new Intent(bmiGenderActivity.this, bmiHeightActivity.class);
                i.putExtras(Bundle2);
                startActivity(i);
            }
        });


        bmifemale.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Boolean isMale = false;

                Bundle Bundle2 = new Bundle();
                Bundle2.putBoolean("isMale", isMale);

                Intent i = new Intent(bmiGenderActivity.this, bmiHeightActivity.class);
                i.putExtras(Bundle2);
                startActivity(i);
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

