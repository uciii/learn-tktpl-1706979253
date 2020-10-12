package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

import java.util.HashMap;

public class Food {
    private String title;
    private String info;
    private String amount;
    private HashMap<String, Integer> foodCalorie = new HashMap<String, Integer>();

    public Food(String title, String info, String amount) {
        this.title = title;
        this.info = info;
        this.amount = amount;

        foodCalorie.put("Gado-gado", 132);
        foodCalorie.put("Mango Juice", 54);
        foodCalorie.put("Milk Chocolate", 535);
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public String getAmount() {
        return amount;
    }

    public Integer getFoodCalorie(String food){
        return foodCalorie.get(food);
    }
}
