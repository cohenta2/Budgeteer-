package richboys.dragonhacks.root.budgeteer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets an object to the edit text view and the submit button for the main activity
        final EditText userNameEnter = (EditText) findViewById(R.id.username_editText_view);
        Button mainActivitySubmitButton = (Button) findViewById(R.id.main_activity_submit_button);

        /*
        Sets an on click listener to the submit button
        when pressed it will check if the edit text field has data
        if not it uses a toast to let the user know
        else it uses an intent to open the budget activity and pass the username entered
         */
        mainActivitySubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userNameEnter.getText().toString().matches("")) {
                    Toast noUserNameInput = Toast.makeText(getApplicationContext(),"Please enter a username",Toast.LENGTH_SHORT);
                    noUserNameInput.show();
                } else {
                    Intent changeActivity = new Intent(MainActivity.this, BudgetActivity.class);
                    changeActivity.putExtra("userNameToPass", userNameEnter.getText().toString());
                    startActivity(changeActivity);

                }
            }
        });
    }
}
