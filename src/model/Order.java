package model;

// Bestellung modellieren;
public class Order {
    private String mealName;
    private int numberOfMeals;

    public Order(String mealName, int numberOfMeals) {
        this.mealName = mealName;
        this.numberOfMeals = numberOfMeals;
    }

    public String getMealName() {
        return mealName;
    }

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

}
