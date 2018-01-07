package richboys.dragonhacks.root.budgeteer;

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
    private double userRecreation;
    private double userSavings;

    /*
    @param userName passed from submit button on creation of UserBudget instance
    all other instance variables initialized to 0.0;
     */

    public UserBudget(String userName) {
        this.userName = userName;
        this.userIncome = 0.0;
        this.userRent = 0.0;
        this.userFood = 0.0;
        this.userRecreation = 0.0;
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

    public void setUserRecreation(double userRecreation) {
        this.userRecreation = userRecreation;
    }

    public void setUserSavings(double userSavings) {
        this.userSavings = userSavings;
    }







}
