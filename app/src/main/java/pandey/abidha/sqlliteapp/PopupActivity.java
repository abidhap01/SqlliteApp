package pandey.abidha.sqlliteapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class PopupActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    public EditText textName,textPlace;
    String emailNew=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        mydb = new DatabaseHelper(this);
        textName=(EditText)findViewById(R.id.dialog_txt_name);
        textPlace=(EditText)findViewById(R.id.dialog_txt_place);
        emailNew=getIntent().getStringExtra("Email");
        callPopUp();
    }
    public void callPopUp(){
        String email=getIntent().getStringExtra("Email");

        final LayoutInflater factory = LayoutInflater.from(PopupActivity.this);
        final View textEntryView = factory.inflate(R.layout.activity_popup, null);




        //  input1.setText("DefaultValue", EditText.BufferType.EDITABLE);
        //  input2.setText("DefaultValue", EditText.BufferType.EDITABLE);
        final AlertDialog.Builder alert = new AlertDialog.Builder(PopupActivity.this);

        alert.setTitle("Add Details:").setView(textEntryView).setPositiveButton("Save",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                        Log.i("AlertDialog","TextEntry 1 Entered "+textName.getText().toString());
                        Log.i("AlertDialog","TextEntry 2 Entered "+textPlace.getText().toString());

                        String email=getIntent().getStringExtra("Email");
                        EditText tex=(EditText) textEntryView.findViewById(R.id.dialog_txt_name);
                        EditText texP=(EditText) textEntryView.findViewById(R.id.dialog_txt_place);
                        String eventName=tex.getText().toString();
                        String eventPlace=texP.getText().toString();
                   Boolean records=     addEmployeeRecords(eventName,eventPlace,email);
                   if(records){


                       Intent i = new Intent(PopupActivity.this, TrainedUserCancelActivity.class);
                       i.putExtra ( "EmailSave", emailNew );
                       startActivity(i);

                   }



    /* User clicked OK so do some stuff */
                    }
                }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
     /*
     * User clicked cancel so do some stuff
     */ Intent i = new Intent(PopupActivity.this, TrainedUserCancelActivity.class);

                        i.putExtra ( "EmailSave", emailNew );


                        startActivity(i);


                    }
                });
        alert.show();
    }
    public Boolean addEmployeeRecords(String input1,String input2,String email){
       Boolean records=  mydb.insertVolunteerData(input1,input2,email);

       return  records;
    }
}
