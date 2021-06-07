package model;

// JunkFood modellieren;
public class CreateJunkFood {
    private String mealName;
    private double basePrice;
    private int ingredientsNumber;
    private double pricePerIngredient;

    public CreateJunkFood(String mealName, double basePrice, int ingredientsNumber, double pricePerIngredient) {
        this.mealName = mealName;
        this.basePrice = basePrice;
        this.ingredientsNumber = ingredientsNumber;
        this.pricePerIngredient = pricePerIngredient;
    }

    public String getMealName() {
        return mealName;
    }

    public double getBasePrice() {
        return basePrice;
    }


    public int getIngredientsNumber() {
        return ingredientsNumber;
    }


    public double getPricePerIngredient() {
        return pricePerIngredient;
    }


    public double getTotalPrice() {
        return (getBasePrice() + (getIngredientsNumber() * getPricePerIngredient()));
    }

}
