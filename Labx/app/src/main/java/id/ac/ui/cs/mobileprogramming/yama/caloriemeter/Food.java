package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

public class Food {
    private String title;
    private String info;
    private int amount;

    public Food(String title, String info, int amount) {
        this.title = title;
        this.info = info;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getAmount() {
        return amount;
    }
}
