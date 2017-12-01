package pandey.abidha.sqlliteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewUserActivity extends AppCompatActivity {

    public Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        buttonAdd = (Button) findViewById(R.id.buttonAddRecordsNew);
        onAddButtonClick();
    }

    public void onAddButtonClick() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                Intent i = new Intent(NewUserActivity.this, PopupActivity.class);
                String email = getIntent().getStringExtra("Email");
                i.putExtra("Email", email);
                startActivity(i);


            }

        });
    }
}