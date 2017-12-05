package pandey.abidha.sqlliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MedicalActivity extends AppCompatActivity {

    public Button buttonSel,buttonG,buttonok;
    public EditText searchMed;
    public String searchCond,drop;
    public Spinner staticSpinner,dynamicSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        //buttonSel=(Button)findViewById(R.id.buttonSelectMed);
        searchMed=(EditText)findViewById(R.id.editTextSearchMed1);
        buttonG=    (Button)findViewById(R.id.buttonGoMed);
        buttonok=(Button)findViewById(R.id.buttonOK);
        searchCond=searchMed.getText().toString();


        //dropdown code
         staticSpinner = (Spinner) findViewById(R.id.static_spinner);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.brew_array,
                        android.R.layout.simple_spinner_item);

        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticSpinner.setAdapter(staticAdapter);



        /* dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);
        String[] items = new String[] { "Chai Latte", "Green Tea", "Black Tea" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);
        dynamicSpinner.setAdapter(adapter);*/
        clickDropDown();





        //
        //clickSelectMedical();
        clickSearchMed();
    }

   /* public void clickSelectMedical(){
       buttonSel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

                   Intent intent=new Intent(MedicalActivity.this,MedicalActivityName.class);
                   startActivity(intent);


           }
       });
    }*/
    public void clickSearchMed(){
        buttonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sea=searchCond;
                if(!(searchMed.getText().toString().isEmpty())){
                Intent i= new Intent(MedicalActivity.this,SearchMedicalActivity.class);
                i.putExtra ( "searchExtra", searchMed.getText().toString() );
                startActivity(i);
                }else{
                    Toast.makeText(MedicalActivity.this,"Search condition can not b empty!", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

     public void clickDropDown(){

         buttonok.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
                 drop=staticSpinner.getSelectedItem().toString();
                 if(drop.equals("Select Medical Emergencies")){
                     Toast.makeText(MedicalActivity.this,"select valid options", Toast.LENGTH_LONG).show();
                 }
                 if(drop.equals("Allergies")){
                     Intent intent=new Intent(MedicalActivity.this,AllergiesActivity.class);
                     startActivity(intent);
                 }
                 if(drop.equals("Bleeding")){
                     Intent intent=new Intent(MedicalActivity.this,BleedingActivity.class);
                     startActivity(intent);
                 }
                 if(drop.equals("Burns")){
                     Intent intent=new Intent(MedicalActivity.this,BurnsActivity.class);
                     startActivity(intent);
                 }
                 if(drop.equals("Choking")){
                     Intent intent=new Intent(MedicalActivity.this,ChokingActivity.class);
                     startActivity(intent);
                 }
                 if(drop.equals("Flu")){
                     Intent intent=new Intent(MedicalActivity.this,FluActivity.class);
                     startActivity(intent);
                 }
             }
         });
     }
}
