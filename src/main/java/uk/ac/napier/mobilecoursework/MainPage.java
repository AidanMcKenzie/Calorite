package uk.ac.napier.mobilecoursework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Button newUser = (Button) findViewById(R.id.btnBegin);
        newUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent genderPage = new Intent(MainPage.this,
                            GenderPage.class);
                    startActivity(genderPage);
                }
        });
    }
}
