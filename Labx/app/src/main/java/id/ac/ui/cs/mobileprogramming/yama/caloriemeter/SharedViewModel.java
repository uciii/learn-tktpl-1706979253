package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Food> selected = new MutableLiveData<>();

    public void setSelected(Food food) {
        selected.setValue(food);
    }

    public MutableLiveData<Food> getSelected() {
        return selected;
    }
}
