package uk.ac.napier.mobilecoursework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HubPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub_page);

        // Obtain the values passed from the previous activity
        final String consumed = getIntent().getStringExtra("consumed");
        final String calories = getIntent().getStringExtra("calories left");

        // Display the number of total calories consumed
        final TextView calsCons = (TextView)findViewById(R.id.CalsConsumed);
        calsCons.setText(String.valueOf(consumed));

        // If the calorie count is equal to or less than 0, inform the user that they have consumed
        // all of their calories for the day, else display the calories left to consume
        if (Integer.parseInt(calories) <= 0) {
            Toast.makeText(HubPage.this, "You've consumed all your calories for today!",
                    Toast.LENGTH_SHORT).show();
            TextView calsLeft = (TextView) findViewById(R.id.calsLeft);
            calsLeft.setText("no more");
        }
        else{
            TextView calsLeft = (TextView) findViewById(R.id.calsLeft);
            calsLeft.setText(String.valueOf(calories));
        }

        Button cont = (Button) findViewById(R.id.btnToInput);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent input = new Intent(HubPage.this,
                        InputPage.class);
                // Pass the values for the consumed and total calories to the next activity
                input.putExtra("consumedCalories", consumed);
                input.putExtra("baseCalories", calories);
                startActivity(input);
            }
        });
    }
}
