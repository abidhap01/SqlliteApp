package pandey.abidha.sqlliteapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class FrontPageActivity extends AppCompatActivity {

    public Button buttonSignIn;
    public Button buttonMed;
    public Button buttonDbts;
    public Button buttonFr;
    public Button buttonFld;
    public Button buttonErthQk;
    public Button buttonSrch;
   // public TextView searchText;
    public EditText editTextSearchMe;
    public  String  searchTextNew;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        buttonSignIn=(Button)findViewById(R.id.buttonSign);
        buttonSignIn.setTextColor(Color.WHITE);
        //buttonSignIn.setBackgroundColor(Color.MAGENTA);

        buttonMed=(Button)findViewById(R.id.buttonMedical);
        buttonMed.setTextColor(Color.WHITE);
        //buttonMed.setBackgroundColor(Color.RED);

        buttonDbts=(Button)findViewById(R.id.buttonDiabetes);
        buttonDbts.setTextColor(Color.WHITE);
        //buttonDbts.setBackgroundColor(Color.RED);

        buttonFr=(Button)findViewById(R.id.buttonFire);
        buttonFr.setTextColor(Color.WHITE);
        //buttonFr.setBackgroundColor(Color.RED);

        buttonFld=(Button)findViewById(R.id.buttonFlood);
        buttonFld.setTextColor(Color.WHITE);
        //buttonFld.setBackgroundColor(Color.RED);

        buttonErthQk=(Button)findViewById(R.id.buttonEarth);
        buttonErthQk.setTextColor(Color.WHITE);
        //buttonErthQk.setBackgroundColor(Color.RED);

        buttonSrch=(Button)findViewById(R.id.buttonGo);
        buttonSrch.setTextColor(Color.WHITE);
        //buttonSrch.setBackgroundColor(Color.RED);
        editTextSearchMe=(EditText) findViewById(R.id.editTextSearchMed) ;
         searchTextNew=editTextSearchMe.getText().toString();

        OnButtonClick();
        OnMedicalClick();
        OnDiabetecsClick();
        onFireClick();
        onFloodClick();
        onEarthquakeClick();
        onQueryClick();
    }

    public void OnButtonClick(){
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(FrontPageActivity.this,VolunteerActivity.class);
                startActivity(i);
            }
        });
    }
    public void OnMedicalClick(){
        buttonMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(FrontPageActivity.this,MedicalActivity.class);
                startActivity(i);
            }
        });
    }
    public void OnDiabetecsClick(){
        buttonDbts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(FrontPageActivity.this,DiabeteActivity.class);
                startActivity(i);
            }
        });
    }
    public void onFireClick(){
        buttonFr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(FrontPageActivity.this,FireActivity.class);
                startActivity(i);
            }
        });
    }
    public void onFloodClick(){
        buttonFld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(FrontPageActivity.this,FloodActivity.class);
                startActivity(i);
            }
        });
    }
    public void onEarthquakeClick(){
        buttonErthQk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(FrontPageActivity.this,EarthQuakeActivity.class);
                startActivity(i);
            }
        });
    }
    public void onQueryClick(){
        buttonSrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!( editTextSearchMe.getText().toString().isEmpty())){
                    Intent i= new Intent(FrontPageActivity.this,SearchActivity.class);
                    i.putExtra ( "Search", editTextSearchMe.getText().toString() );
                    startActivity(i);
                }else{
                    Toast.makeText(FrontPageActivity.this,"Search condition can not b empty!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
