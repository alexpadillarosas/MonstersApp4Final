package com.blueradix.monstersapp4final.monster.rate;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import com.blueradix.monstersapp4final.R;
import com.blueradix.monstersapp4final.databinding.RateMonsterScrollingFragmentBinding;
import com.blueradix.monstersapp4final.monster.Monster;

public class RateMonsterScrollingFragment extends Fragment {

    private RateMonsterScrollingFragmentBinding binding;
    private Integer rate = 0;
    private Monster monster;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = RateMonsterScrollingFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //check for the Bundle that arrives

        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("RATE_MONSTER")){
            monster = (Monster) getArguments().getSerializable("RATE_MONSTER");
            binding.rateMonsterNameTextView.setText(monster.getName());

            int resID = binding.getRoot().getResources().getIdentifier(monster.getImage(), "drawable", binding.getRoot().getContext().getPackageName());
            binding.rateMonsterImageView.setImageResource(resID);
            binding.rateMonsterRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                    rate = (int) ratingBar.getRating();
                }
            });

            binding.rateMonsterCancelButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.action_rateMonsterScrollingFragment_to_showMonstersFragment);
                }
            });

            binding.rateMonsterSaveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle modifiedBundle = new Bundle();
                    monster.setStars(monster.getStars() + rate);
                    monster.setVotes(monster.getVotes() + 1);
                    modifiedBundle.putSerializable("RATE_MONSTER", monster);
                    NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.action_rateMonsterScrollingFragment_to_showMonstersFragment, modifiedBundle);
                }
            });
        }
    }
}