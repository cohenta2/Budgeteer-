package richboys.dragonhacks.root.budgeteer;


import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by Joey Woodside on 1/6/18 at Dragonhacks 2018.
 */

public class UserBudget {
    /*
    All instance variables for a user budget
    userName will be recorded when submit button on home screen pressed
    All others will be initialized to 0 and updated when second activity submit button pressed
     */
    private String userName;
    private double userIncome;
    private double userRent;
    private double userFood;
    private double userTransportation;
    private double userRecreation;
    private double userSavings;

    /*
    @param userName passed from submit button on creation of UserBudget instance

     */
    public UserBudget(String userName, double userIncome, double userRent, double userFood,
    double userTransportation, double userRecreation) {
        this.userName = userName;
        this.userIncome = userIncome;
        this.userRent = userRent;
        this.userFood = userFood;
        this.userTransportation = userTransportation;
        this.userRecreation = userRecreation;
        this.userSavings = 0.0;
    }

    public void setUserIncome(double userIncome) {
        this.userIncome = userIncome;
    }

    public void setUserRent(double userRent) {
        this.userRent = userRent;
    }

    public void setUserFood(double userFood) {
        this.userFood = userFood;
    }

    public void setUserTransportation(double userTransportation) {

    }

    public void setUserRecreation(double userRecreation) {
        this.userRecreation = userRecreation;
    }

    public void setUserSavings(double userSavings) {
        this.userSavings = userSavings;
    }
}
