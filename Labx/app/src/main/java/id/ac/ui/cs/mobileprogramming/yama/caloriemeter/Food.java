package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

public class Food {
    private String title;
    private String info;
    private String amount;

    public Food(String title, String info, String amount) {
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

    public String getAmount() {
        return amount;
    }
}
