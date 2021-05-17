package model;

// JunkFood modellieren;
public class CreateJunkFood {
    private String mealName;
    private double basePrice;
    private int ingredientNumber;
    private double pricePerIngredient;

    public CreateJunkFood(String mealName, double basePrice, int ingredientNumber, double pricePerIngredient) {
        this.mealName = mealName;
        this.basePrice = basePrice;
        this.ingredientNumber = ingredientNumber;
        this.pricePerIngredient = pricePerIngredient;
    }

    public String getMealName() {
        return mealName;
    }

    public double getBasePrice() {
        return basePrice;
    }


    public int getIngredientNumber() {
        return ingredientNumber;
    }


    public double getPricePerIngredient() {
        return pricePerIngredient;
    }


    public  double getTotalPrice() {
        return (getBasePrice() + (getIngredientNumber() * getPricePerIngredient()));
    }

}
