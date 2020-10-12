package id.ac.ui.cs.mobileprogramming.yama.caloriemeter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.mobileprogramming.yama.caloriemeter.databinding.FragmentFoodDetailBinding;

public class FoodDetailFragment extends Fragment {
    private FragmentFoodDetailBinding binding;

    public FoodDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_detail, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.getSelected().observe(getViewLifecycleOwner(), item -> {
            String title = item.getTitle();
            String calorie = item.getFoodCalorie(title) + " calories";
            String info = item.getInfo() + " add some description";
            String page = "Food Detail";

            binding.pageTitle.setText(page);
            binding.title.setText(title);
            binding.calorie.setText(calorie);
            binding.description.setText(info);
        });
    }
}