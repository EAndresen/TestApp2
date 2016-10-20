package com.example.erica.testapp2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.IllegalFormatException;

import static com.example.erica.testapp2.R.id.image;

public class MainActivity extends AppCompatActivity {

    TextView totalTextView;
    EditText percentageTxt;
    EditText numberText;
    float percantage;
    float total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        totalTextView = (TextView) findViewById(R.id.totalTextView);
        percentageTxt = (EditText) findViewById(R.id.percantageTxt);
        numberText = (EditText) findViewById(R.id.numberTxt);

        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    percantage = Float.parseFloat(percentageTxt.getText().toString());
                } catch (NumberFormatException e) {
                    e.fillInStackTrace();
                    percentageTxt.setHint("Please set a valid percentage");

                }
                float decimal = percantage / 100;

                try {
                    total = decimal * Float.parseFloat(numberText.getText().toString());
                } catch (NumberFormatException e) {
                    e.fillInStackTrace();
                    numberText.setHint("Please enter a valid number");

                }
                totalTextView.setText(Float.toString(total));

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
