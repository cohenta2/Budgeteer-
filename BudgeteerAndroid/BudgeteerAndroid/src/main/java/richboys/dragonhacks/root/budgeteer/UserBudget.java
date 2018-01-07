package richboys.dragonhacks.root.budgeteer;


/**
 * Created by Joey Woodside on 1/6/18 at Dragonhacks 2018.
 */

public class UserBudget {
    /*
    All instance variables for a user budget
    username will be recorded when submit button on home screen pressed
    All others will be initialized to 0 and updated when second activity submit button pressed
     */
    private String username;
    private double income;
    private double rent;
    private double food;
    private double transportation;
    private double recreation;
    //private double userSavings;

    /*
    @param username passed from submit button on creation of UserBudget instance

     */
    public UserBudget(String username, double income, double rent, double food,
                      double transportation, double recreation) {
        this.username = username;
        this.income = income;
        this.rent = rent;
        this.food = food;
        this.transportation = transportation;
        this.recreation = recreation;
        //this.userSavings = 0.0;
    }

    public String getUsername() {
        return this.username;
    }

    public double getIncome() {
        return this.income;
    }

    public double getRent() {
        return this.rent;
    }

    public double getFood() {
        return this.food;
    }

    public double getTransportation() {
        return this.transportation;
    }

    public double getRecreation() {
        return this.recreation;
    }

   // public double getUserSavings() {
        //return this.userSavings;
    //}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ");
        sb.append(this.getUsername());
        sb.append("\nIncome: ");
        sb.append(this.getIncome());
        sb.append("\nRent: ");
        sb.append(this.getRent());
        sb.append("\nFood: ");
        sb.append(this.getFood());
        sb.append("\nTransportation: ");
        sb.append(this.getTransportation());
        sb.append("\nRecreation: ");
        sb.append(this.getRecreation());

        return sb.toString();
    }
}
