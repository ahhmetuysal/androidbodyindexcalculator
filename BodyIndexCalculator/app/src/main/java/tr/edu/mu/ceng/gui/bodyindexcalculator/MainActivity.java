package tr.edu.mu.ceng.gui.bodyindexcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button bmibutton= findViewById(R.id.button1);
        final Button bmrbutton = findViewById(R.id.button2);




        bmibutton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {


                Intent i = new Intent(MainActivity.this,bmiGenderActivity.class);

                startActivity(i);
            }
        });

        bmrbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(MainActivity.this,bmrGenderActivity.class);

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

