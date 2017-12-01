package pandey.abidha.sqlliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MedicalActivityName extends AppCompatActivity {

    public Button buttonAlg;
    public Button buttonBrn;
    public Button buttonChok;
    public Button buttonFl;
    public Button buttonBld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_name);

        buttonAlg=(Button)findViewById(R.id.buttonAllergies);
        buttonBrn=(Button)findViewById(R.id.buttonBurns);
        buttonChok=(Button)findViewById(R.id.buttonChoking);
        buttonFl=(Button)findViewById(R.id.buttonFlu);
        buttonBld=(Button)findViewById(R.id.buttonBleeding);

        clickAllergies();
        clickBleeding();
        clickBurns();
        clickChoking();
        clickFlu();
    }

    public void clickAllergies(){
        buttonAlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MedicalActivityName.this,AllergiesActivity.class);
                startActivity(intent);
            }
        });
    }
    public void clickBleeding(){
        buttonBld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MedicalActivityName.this,BleedingActivity.class);
                startActivity(intent);
            }
        });

    }
    public void clickBurns(){
        buttonBrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MedicalActivityName.this,BurnsActivity.class);
                startActivity(intent);
            }
        });

    }
    public void clickChoking(){
        buttonChok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MedicalActivityName.this,ChokingActivity.class);
                startActivity(intent);
            }
        });
    }

    public void clickFlu(){
        buttonFl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MedicalActivityName.this,FluActivity.class);
                startActivity(intent);
            }
        });

    }

}
