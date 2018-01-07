package richboys.dragonhacks.root.budgeteer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private UserBudget userBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userNameEnter = (EditText) findViewById(R.id.username_editText_view);
        Button mainActivitySubmitButton = (Button) findViewById(R.id.main_activity_submit_button);

        mainActivitySubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userNameEnter.getText().toString().matches("")) {
                    Toast noUserNameInput = Toast.makeText(getApplicationContext(),"Please enter a username",Toast.LENGTH_SHORT);
                    noUserNameInput.show();
                }
                    userBudget = new UserBudget(userNameEnter.getText().toString());

            }
        });
    }
}
