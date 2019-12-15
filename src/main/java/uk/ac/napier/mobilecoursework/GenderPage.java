package uk.ac.napier.mobilecoursework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static uk.ac.napier.mobilecoursework.R.id.txtLimitInput;

public class GenderPage extends AppCompatActivity {

    String genderID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_page);

        Button female = (Button) findViewById(R.id.btnFemale);
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent initFemale = new Intent(GenderPage.this,
                        InitialInfoPage.class);
                // Set genderID to female and pass this to the next activity
                genderID = "female";
                initFemale.putExtra("gender", genderID);
                startActivity(initFemale);
            }
        });

        Button male = (Button) findViewById(R.id.btnMale);
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent initMale = new Intent(GenderPage.this,
                        InitialInfoPage.class);
                // Set genderID to male and pass this to the next activity
                genderID = "male";
                initMale.putExtra("gender", genderID);
                startActivity(initMale);
            }
        });

        Button OK = (Button) findViewById(R.id.btnOK);
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent initLimit = new Intent(GenderPage.this,
                        InitialInfoPage.class);
                // EditText box for entering a calorie intake limit
                EditText limit = (EditText) findViewById(R.id.txtLimitInput);
                // Set genderID to what was entered in the EditText box
                genderID = limit.getText().toString();
                // If the EditText box is left empty, inform the user
                if (genderID.equals("")){
                    Toast.makeText(GenderPage.this, "Please enter a calorie intake limit.", Toast.LENGTH_SHORT).show();
                }
                else {
                    // Put the calorie limit entered into an int
                    int limitNo = Integer.parseInt(genderID);
                    // If the number entered is not large or small enough, inform the user
                    if (limitNo < 1000) {
                        Toast.makeText(GenderPage.this, "Please choose a higher calorie intake.", Toast.LENGTH_SHORT).show();
                    } else if (limitNo > 10000) {
                        Toast.makeText(GenderPage.this, "Please choose a lower calorie intake.", Toast.LENGTH_SHORT).show();
                    } else {
                        // Pass the number entered to the next activity
                        initLimit.putExtra("gender", genderID);
                        startActivity(initLimit);
                    }
                }
            }
        });
    }
}
