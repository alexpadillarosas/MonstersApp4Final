package com.blueradix.monstersapp4final.monster.add;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.blueradix.monstersapp4final.R;
import com.blueradix.monstersapp4final.databinding.AddMonsterScrollingFragmentBinding;
import com.blueradix.monstersapp4final.monster.Monster;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class AddMonsterScrollingFragment extends Fragment {

    private AddMonsterScrollingFragmentBinding binding;
    private Integer scarinessValue = 0;
    private Monster monster;

    public static AddMonsterScrollingFragment newInstance() {
        return new AddMonsterScrollingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = AddMonsterScrollingFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.addMonsterScarinessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                scarinessValue = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.addMonsterAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.addMonsterNameEditText.getText().toString();
                if(name.trim().isEmpty()){
                    Snackbar.make(view, "Name is required", Snackbar.LENGTH_SHORT).show();
                    binding.addMonsterNameEditText.getText().clear();
                    binding.addMonsterNameEditText.requestFocus();
                    return;
                }

                String description = binding.addMonsterDescriptionEditText.getText().toString();

                Random ran = new Random();
                int value = ran.nextInt(30) + 1;
                String imageName =  "monster_" + value;

                monster = new Monster();
                monster.setName(name);
                monster.setDescription(description);
                monster.setScariness(scarinessValue);
                monster.setImage(imageName);
                monster.setStars(0);
                monster.setScariness(0);
                monster.setVotes(0);

                Bundle bundle = new Bundle();
                bundle.putSerializable("ADD_MONSTER", monster);

                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_addMonsterScrollingFragment_to_showMonstersFragment, bundle);

            }
        });

        binding.addMonsterCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_addMonsterScrollingFragment_to_showMonstersFragment);
            }
        });

    }


}