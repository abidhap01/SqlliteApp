package pandey.abidha.sqlliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TrainedUserCancelActivity extends AppCompatActivity {

    public Button buttonadd;
    public TableLayout tabLay;
    String emailGet,emailGetS,emailFinal,emailR,emailNew=null;


    public RadioButton radY,radN;
    DatabaseHelper mydb;
    public TextView tabDate,tabName,tabPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trained_user_cancel);

        mydb = new DatabaseHelper(this);
        buttonadd = (Button) findViewById(R.id.buttonAddRecordsCancel);
        radY=(RadioButton)findViewById(R.id.radioButtonYESCancel);
        radN=(RadioButton)findViewById(R.id.radioButtonNOCancel);
        tabDate=(TextView) findViewById(R.id.rowDateCancel2);
        tabName=(TextView) findViewById(R.id.rowEventNameCancel2);
        tabPlace=(TextView) findViewById(R.id.rowEventPlaceCancel2);
     //   tabLay=(TableLayout)findViewById(R.id.tlTable01);

        emailGetS=getIntent().getStringExtra("EmailSave");







        onClickRecords();
        onRadioClickNo();
        getAllrecords(emailGetS);


    }

    public void onClickRecords() {
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                Intent i = new Intent(TrainedUserCancelActivity.this, PopupActivity.class);
                String email=getIntent().getStringExtra("Email");
                i.putExtra ( "Email", emailGetS );
                startActivity(i);


            }

                /*final EditText input = new EditText(TrainedUserDetails.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                final EditText input2 = new EditText(TrainedUserDetails.this);
                LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input2.setLayoutParams(lp2);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(TrainedUserDetails.this);
                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(TrainedUserDetails.this);
                alertDialog.setView(input);
                alertDialog2.setView(input2);
                alertDialog.setTitle("Add Records");
                alertDialog.setMessage("Enter Event Name");
                alertDialog2.setMessage("Enter Event Place");
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                // Write your code here to execute after dialog
                                //Editable YouEditTextValue = edittext.getText();
                                //OR
                               // String YouEditTextValue = edittext.getText().toString();
                                Toast.makeText(getApplicationContext(),"Password Matched", Toast.LENGTH_SHORT).show();
                                Intent myIntent1 = new Intent(v.getContext(), PopupActivity.class);
                                startActivityForResult(myIntent1, 0);
                            }
                        });
                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });
                alertDialog.show();*/

        });
    }
    public void onRadioClickNo() {
        radN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TrainedUserCancelActivity.this, FrontPageActivity.class);
                startActivity(i);
            }
        });

    }
    public void getAllrecords(String email){
        String date=null;
        String name=null;
        String place=null;
        String emailArg=null;
        if(mydb ==null){
            mydb = new DatabaseHelper(this);
        }
        ArrayList<PopulateTable> populateList = null;

        try{
            populateList =mydb.getAllVolunteerRecords(email);
            if(populateList!=null){
                for(int i = 0 ; i < populateList.size() ; i++){
                    PopulateTable foo = (PopulateTable) populateList.get(i);
                    date=foo.getDate();
                    name=foo.getEventName();
                    place=foo.getEventPlace();

                }
                tabDate.setText(date);
                tabName.setText(name);
                tabPlace.setText(place);
            }else{
                tabDate.setText("NA");
                tabName.setText("NA");
                tabPlace.setText("NA");
                Toast.makeText(TrainedUserCancelActivity.this,"Not Record Found!", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }





    }

}
