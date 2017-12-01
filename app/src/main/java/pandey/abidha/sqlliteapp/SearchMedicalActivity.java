package pandey.abidha.sqlliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SearchMedicalActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    public TextView tVSearchnew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_medical);

        String searchText=getIntent().getStringExtra("searchExtra");
        //String searchdata=getIntent().getStringExtra("SearchData");
        mydb = new DatabaseHelper(this);
        tVSearchnew=(TextView)findViewById(R.id.textViewSearchMed) ;

        String data= mydb.getQueryResult(searchText);

        if(searchText.isEmpty()){
            tVSearchnew.setText("No Data Found!");
        }else{
            tVSearchnew.setText(data);
        }

    }
}
