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

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.mobileprogramming.yama.caloriemeter.databinding.FragmentFoodListBinding;

public class FoodListFragment extends Fragment {
    private FragmentFoodListBinding binding;
    private FoodDetailFragment detailFragment = new FoodDetailFragment();

    public FoodListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        List<Food> list = new ArrayList<>();
        list.add(new Food("Gado-gado", "Gado-gado is an Indonesian salad of slightly boiled, blanched or steamed...", "1 Plate"));
        list.add(new Food("Mango Juice", "Mango is a very sweet fruit and hence one does not need to add sugar in it...", "100 ml"));
        list.add(new Food("Milk Chocolate", "Sweet chocolate combined with milk....", "100 gr"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list);
        binding.recyclerView.setAdapter(adapter);
        adapter.setListener((v, position) -> {
            viewModel.setSelected(adapter.getItemAt(position));
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container, detailFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}