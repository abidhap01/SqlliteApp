package pandey.abidha.sqlliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class VolunteerActivity extends AppCompatActivity {

    public RadioButton yes,no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);
        yes=(RadioButton)findViewById(R.id.radioButtonYES);
        no=(RadioButton)findViewById(R.id.radioButtonNO);

        onCLickYes();
        onCLickNo();
    }

    public void onCLickYes(){
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VolunteerActivity.this,RegisteredUserActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onCLickNo(){
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VolunteerActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
