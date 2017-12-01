package pandey.abidha.sqlliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public  EditText email,password, registeredUser,textViewLog;
    public Button loginButton;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new DatabaseHelper(this);
        email=(EditText)findViewById(R.id.editEmail);
        password=(EditText)findViewById(R.id.editPassword);
     //   registeredUser=(EditText)findViewById(R.id.editRegisteredUser);
        loginButton=(Button)findViewById(R.id.buttonLogin);
       // textViewLog=(EditText)findViewById(R.id.textViewLogin) ;


        addDetails();
        //alreadyLoggedUser();

    }

    public void addDetails(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((email.getText().toString().trim().isEmpty() == false) &&  (password.getText().toString().trim().isEmpty()==false)){
                    Boolean isInserted=  mydb.insertDetails(email.getText().toString().trim(), password.getText().toString().trim());
                    if(isInserted.equals(true)){
                        Intent i = new Intent(MainActivity.this, AddDetails.class);
                        i.putExtra ( "Email", email.getText().toString() );
                        startActivity(i);
                        //Toast.makeText( ç



                    }else{

                   /* int emailCheck=mydb.emailVerification(email.getText().toString().trim());
                    Boolean volExpYesORNo=mydb.volunteerExpVerification(email.getText().toString().trim());
                    if(emailCheck == 2){
                        if(volExpYesORNo){
                           // show previous record
                            Intent i1 = new Intent(MainActivity.this, TrainedUserDetails.class);
                            startActivity(i1);
                        }else{
                            Intent i2 = new Intent(MainActivity.this, UserActivity.class);
                            startActivity(i2);
                        }

                    }*/

                        Toast.makeText(MainActivity.this,"Registered user!", Toast.LENGTH_LONG).show();

                    }

                }else{
                    Toast.makeText(MainActivity.this,"email and password can not be empty!", Toast.LENGTH_LONG).show();
                }
                            }
        });

    }
   /* public void alreadyLoggedUser(){
        textViewLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this, RegisteredUserActivity.class);
                startActivity(i1);
            }
        });
    }*/


}
