package pandey.abidha.sqlliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    public TextView tVSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        String searchText=getIntent().getStringExtra("Search");

        //String searchdata=getIntent().getStringExtra("SearchData");
        mydb = new DatabaseHelper(this);

        tVSearch=(TextView)findViewById(R.id.textViewSearch) ;

       String data= mydb.getQueryResult(searchText);

            tVSearch.setText(data);





    }

}
