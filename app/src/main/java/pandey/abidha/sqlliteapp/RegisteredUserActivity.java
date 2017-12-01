package pandey.abidha.sqlliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisteredUserActivity extends AppCompatActivity {

    public  EditText registserEml,registerPass;
    public Button logIn;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_user);
        registserEml= (EditText)findViewById(R.id.editRegisterEmail) ;
                registerPass=(EditText)findViewById(R.id.editRegisterPassword) ;
                logIn=(Button)findViewById(R.id.buttonRegisterLogin) ;
        mydb = new DatabaseHelper(this);
                onButtonClick();
    }

    public void onButtonClick(){
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((registserEml.getText().toString().trim().isEmpty() == false) &&  (registerPass.getText().toString().trim().isEmpty()==false)){
                    int emailCheck=mydb.emailVerification(registserEml.getText().toString().trim());
                    Boolean volExpYesORNo=mydb.volunteerExpVerification(registserEml.getText().toString().trim());

                    if(emailCheck == 2){
                        if(volExpYesORNo){
                            // show previous record

                            Intent i1 = new Intent(RegisteredUserActivity.this, TrainedUserDetails.class);
                            i1.putExtra ( "Email", registserEml.getText().toString() );
                            startActivity(i1);
                        }else{
                            Intent i2 = new Intent(RegisteredUserActivity.this, TrainedUserDetails.class);
                            i2.putExtra ( "Email", registserEml.getText().toString() );
                            startActivity(i2);
                        }
                    }else{
                        Toast.makeText(RegisteredUserActivity.this,"Not Registered user!", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(RegisteredUserActivity.this,"email and password can not be empty!", Toast.LENGTH_LONG).show();
                }


            }
        });
        }
}
