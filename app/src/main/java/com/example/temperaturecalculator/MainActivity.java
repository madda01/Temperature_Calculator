package com.example.temperaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mapping the button
        btnCalculate=findViewById(R.id.calcBtn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //event handling
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();
                //button press directs to calculate answer function
            }
        });
    } //end of onResume

    private void calculateAnswer() {
        //take the value entered
        EditText et= findViewById(R.id.etText);
        String temp=et.getText().toString();

        //check if the input value is empty
        if(temp.equals("")){
            Toast.makeText(this, "Please add a value",
                    Toast.LENGTH_LONG).show();
        }else{
            //validate the value
            Float tempNumber=0.0f;
            Boolean error= false;
            Float answer=0.0f;

            try {
                tempNumber= Float.parseFloat(temp);
            }catch (NumberFormatException e){
                Toast.makeText(this, "Invalid Entry",
                        Toast.LENGTH_LONG).show();
                error=true;
            }

            if(!error) {
                RadioGroup rg= findViewById(R.id.rgTemp);
                int id=rg.getCheckedRadioButtonId();

                TextView txt= findViewById(R.id.displayText);

                //celcuis button is checked here
                if(id==R.id.celcuisBtn){

                    // convert it into Fahrenheit and display the answer
                    answer=Calculations.convertCelciusToFahrenheit(tempNumber);
                }
                else{
                    // convert it into celcuis and display the answer
                    answer=Calculations.convertFahrenheitToCelcius(tempNumber);
                }

                txt.setText(answer+"");
            }
        }
    }
}