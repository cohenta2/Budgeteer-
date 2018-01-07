package richboys.dragonhacks.root.budgeteer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 1/6/18.
 */

public class BudgetActivity extends AppCompatActivity {

    private UserBudget userBudget;
    private Double[] userInputs;
    private List<EditText> editTextFields;
    private String userName;
    private JSONObject jsonToSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_input);

        //initializes array to store user inputs that will be read from editText fields
        this.userInputs = new Double[5];

        //initializes list to store the edit text fields
        this.editTextFields = new ArrayList<>();

        /*
        Creates a new intent to get the username passed from the main activity
         */
        Intent intent = getIntent();
        this.userName = intent.getExtras().getString("userNameToPass");

        final TextView testView = (TextView) findViewById(R.id.testView);

        //Assigns objects to each of the interactable views in the layout
        Button visualizeButton = (Button) findViewById(R.id.visualize_button);
        Button budgetActivitySubmitButton = (Button) findViewById(R.id.budget_submit_button);
        EditText incomeInputField = (EditText) findViewById(R.id.income_input_field);
        EditText rentInputField = (EditText) findViewById(R.id.rent_input_field);
        EditText foodInputField = (EditText) findViewById(R.id.food_input_field);
        EditText transportationInputField = (EditText) findViewById(R.id.transportation_input_field);
        EditText recreationInputField = (EditText) findViewById(R.id.recreation_input_field);

        //adds all edit text fields to list to easily parse through
        this.editTextFields.add(incomeInputField);
        this.editTextFields.add(rentInputField);
        this.editTextFields.add(foodInputField);
        this.editTextFields.add(transportationInputField);
        this.editTextFields.add(recreationInputField);

        /*
        Sets an onClickListener
        First loops through all the text fields to check if they are all filled with data
        If a text field is not empty it adds the data
         */
        budgetActivitySubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean allInputsFilled = true;
                for (int i = 0; i < editTextFields.size(); i++) {
                    String textInput = editTextFields.get(i).getText().toString();
                    if (textInput.matches("")) {
                        Toast toast = Toast.makeText(getApplicationContext(), "One or more fields is empty", Toast.LENGTH_SHORT);
                        toast.show();
                        allInputsFilled = false;
                        break;
                    } else {
                        userInputs[i] = Double.parseDouble(textInput);
                    }
                }
                if (allInputsFilled) {
                    initializeUserBudget();
                    try {
                        postJSON();
                    } catch (Exception e) {

                    }
                }

            }
        });

        /*
        Attaches an on click listener to the visualize button
        On click it launches the VR app with a username attached
        The VR app will pull the info based on the username given
         */
        visualizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = getPackageManager().getLaunchIntentForPackage("google.gvr.wa");
                    intent.putExtra("username",userName);
                    startActivity(intent);
                } catch (Exception e) {

                }
            }
        });
    }

    public void initializeUserBudget() {
        this.userBudget = new UserBudget(this.userName, userInputs[0],
                userInputs[1], userInputs[2], userInputs[3], userInputs[4]);
    }

    public void postJSON() throws Exception {
        final Gson gson = new Gson();
        String jsonToConvert = gson.toJson(this.userBudget);
        this.jsonToSend = new JSONObject(jsonToConvert);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://6kah5l5nc2.execute-api.us-east-1.amazonaws.com/dev";

// Request a string response from the provided URL.
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (JsonObjectRequest.Method.POST, url, this.jsonToSend, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Display the first 500 characters of the response string.

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
// Add the request to the RequestQueue.
        queue.add(jsObjRequest);
    }
}
