package uk.ac.napier.mobilecoursework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InputPage extends AppCompatActivity {

    String calsInputted = "";
    int totalCalsInputted = 0;
    int newCalsLeft = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_page);

        Button add = (Button) findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputCals = (EditText) findViewById(R.id.edtInputCals);
                calsInputted = inputCals.getText().toString();

                // If the input box is left empty, inform the user to enter something
                if (calsInputted.equals("")){
                    Toast.makeText(InputPage.this, "Please enter your calories.", Toast.LENGTH_SHORT).show();
                }
                // Else if the total calories inputted is larger than 20000, inform the user that
                // they cannot enter any more calories
                else {
                    if (totalCalsInputted + Integer.parseInt(calsInputted) > 20000) {
                        Toast.makeText(InputPage.this, "You cannot enter any more calories", Toast.LENGTH_SHORT).show();
                    }
                    // Else obtain the value for the calories from the previous activity
                    else {
                        String hubCalsStr = getIntent().getStringExtra("baseCalories");
                        int hubCals = Integer.parseInt(hubCalsStr);

                        // Update the total number of calories inputted with the calories just
                        // inputted by the user
                        totalCalsInputted = totalCalsInputted + Integer.parseInt(calsInputted);
                        // Update the number of calories that the user has left to consume
                        newCalsLeft = hubCals - totalCalsInputted;

                        // Display the calories added
                        TextView calsAdd = (TextView) findViewById(R.id.txtCalsAdded);
                        calsAdd.setText(String.valueOf(totalCalsInputted));

                        // Clear EditText box
                        inputCals.setText("");
                    }
                }
            }
        });


        Button cont = (Button) findViewById(R.id.btnReturn);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the user entered no calories, prompt them to enter calories
                if (totalCalsInputted == 0){
                    Toast.makeText(InputPage.this, "Please enter your calories.", Toast.LENGTH_SHORT).show();
                }
                // Else update the total calories for use in the hub page and pass the values for
                // total calories inputted and the calories the user has left to consume
                else {
                    Intent updateHub = new Intent(InputPage.this,
                            HubPage.class);
                    totalCalsInputted = totalCalsInputted + Integer.parseInt(getIntent().getStringExtra("consumedCalories"));
                    updateHub.putExtra("consumed", String.valueOf(totalCalsInputted));
                    updateHub.putExtra("calories left", String.valueOf(newCalsLeft));
                    startActivity(updateHub);
                }
            }
        });
    }
}
