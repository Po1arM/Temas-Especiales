package pucmm.eitc.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private TextView text1, text2, text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        text1 = (TextView) findViewById(R.id.presentationName);
        text2 = (TextView) findViewById(R.id.presentation2);
        text3 = (TextView) findViewById(R.id.langPresentation);

        Intent intent = getIntent();

        String presentacion1 = intent.getStringExtra("PRESENTACION_1");
        text1.setText(presentacion1);
        String presentacion2 = intent.getStringExtra("PRESENTACION_2");
        text2.setText(presentacion2);
        String presentacion3 = intent.getStringExtra("PRESENTACION_3");
        text3.setText(presentacion3);
    }
}