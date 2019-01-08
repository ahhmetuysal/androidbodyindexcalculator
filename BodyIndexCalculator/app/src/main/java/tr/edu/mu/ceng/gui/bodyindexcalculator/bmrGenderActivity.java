package tr.edu.mu.ceng.gui.bodyindexcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.nio.BufferUnderflowException;

public class bmrGenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_gender);
        final ImageButton bmrmale = findViewById(R.id.bmrmale);
        final ImageButton bmrfemale = findViewById(R.id.bmrfemale);
        bmrmale.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Boolean isMale = true;
                Bundle Bundle2 = new Bundle();
                Bundle2.putBoolean("isMale", isMale);


                Intent i = new Intent(bmrGenderActivity.this, bmrHeightActivity.class);
                i.putExtras(Bundle2);
                startActivity(i);
            }
        });


        bmrfemale.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Boolean isMale = false;

                Bundle Bundle2 = new Bundle();
                Bundle2.putBoolean("isMale", isMale);

                Intent i = new Intent(bmrGenderActivity.this, bmrHeightActivity.class);
                i.putExtras(Bundle2);
                startActivity(i);
            }
        });
    }
}

