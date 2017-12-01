package pandey.abidha.sqlliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddDetails extends AppCompatActivity {


    public EditText firstName,lastName,phoneNumber,address;
    public RadioButton volunteerExp;
    public Button updateButton;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__details);
        mydb = new DatabaseHelper(this);

        firstName=(EditText)findViewById(R.id.editFirstName);
        lastName=(EditText)findViewById(R.id.editLastName);
        phoneNumber=(EditText)findViewById(R.id.editPhoneNumber);
        address=(EditText)findViewById(R.id.editAddress);
        updateButton=(Button)findViewById(R.id.buttonAdd);
        volunteerExp=(RadioButton)findViewById(R.id.radioButton);



        updateInformation();

    }

    public Boolean updateInformation(){
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity=new MainActivity();
               // String email =mainActivity.email.getText().toString().trim();

                String value=null;
                if(volunteerExp.isChecked()){
                    value="Y";
                }else{
                    value="N";
                }
                String email=getIntent().getStringExtra("Email");




             Integer isEmailResgistered=   mydb.emailVerificationForUpdatingDetails(email);
                Boolean volunteer=  mydb.volunteerExpVerification(email);

             if(isEmailResgistered==1){

                 Boolean isInserted=mydb.updateDetails(firstName.getText().toString().trim(),lastName.getText().toString().trim(),phoneNumber.getText().toString().trim(),address.getText().toString().trim(),value,email);

                    if(volunteerExp.isChecked()){
                        Intent i1 = new Intent(AddDetails.this, TrainedUserDetails.class);
                        String emailNew=getIntent().getStringExtra("Email");
                        i1.putExtra ( "Email", emailNew );
                        startActivity(i1);

                    }else{
                        Intent intent=new Intent(AddDetails.this,TrainedUserDetails.class);
                        startActivity(intent);
                    }
                    }if (isEmailResgistered==2){
                   //show previous records
                    if(volunteer){

                    }

                }else{
                    Toast.makeText(AddDetails.this,"Welcome! "+firstName.getText().toString(), Toast.LENGTH_LONG).show();
                }
               /* if(isInserted.equals(true)){
                    if(volunteerExp.isChecked() && isEmailResgistered==1){

                    }
                    if(volunteerExp.isChecked() && isEmailResgistered==2){
                        Intent i1 = new Intent(AddDetails.this, TrainedUserDetails.class);
                        startActivity(i1);

                    }


                }else{

                    Toast.makeText(AddDetails.this,"Data Not updated", Toast.LENGTH_LONG).show();

                }
*/
            }
        });
        return false;
    }



}
