package uk.ac.napier.mobilecoursework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InitialInfoPage extends AppCompatActivity {

    public int cals = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_info_page);

        String genderID = getIntent().getStringExtra("gender");

        // Display the appropriate calorie limit, dependant on gender or entered limit
        switch (genderID) {
            case "female":
                cals = 2000;
                break;
            case "male":
                cals = 2500;
                break;
            default:
                cals = Integer.parseInt(genderID);
                break;
        }

        // Display the calorie limit
        TextView calText = (TextView)findViewById(R.id.calorieCount);
        calText.setText(String.valueOf(cals));

        Button cont = (Button) findViewById(R.id.btnContInfo);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hub = new Intent(InitialInfoPage.this,
                        HubPage.class);
                String calsStr = String.valueOf(cals);
                // Pass the calorie limit to the next activity and set the consumed calories to 0
                hub.putExtra("calories left", calsStr);
                hub.putExtra("consumed", "0");
                startActivity(hub);
            }
        });
    }
}
