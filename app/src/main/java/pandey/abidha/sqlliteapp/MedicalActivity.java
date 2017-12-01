package pandey.abidha.sqlliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MedicalActivity extends AppCompatActivity {

    public Button buttonSel,buttonG;
    public EditText searchMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);

        buttonSel=(Button)findViewById(R.id.buttonSelectMed);
        searchMed=(EditText)findViewById(R.id.editTextSearchMed);
        buttonG=    (Button)findViewById(R.id.buttonGoMed);

        clickSelectMedical();
        clickSearchMed();
    }

    public void clickSelectMedical(){
       buttonSel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MedicalActivity.this,MedicalActivityName.class);
               startActivity(intent);
           }
       });
    }
    public void clickSearchMed(){
        buttonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MedicalActivity.this,SearchMedicalActivity.class);
                i.putExtra ( "searchExtra", searchMed.getText().toString() );
                startActivity(i);
            }
        });
    }
}
