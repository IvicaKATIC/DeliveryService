package model;

// Bestellung modellieren;
public class Order {
    private String orderName;
    private int numberOfMeals;

    public Order(String orderName, int numberOfMeals) {
        this.orderName = orderName;
        this.numberOfMeals = numberOfMeals;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

}
