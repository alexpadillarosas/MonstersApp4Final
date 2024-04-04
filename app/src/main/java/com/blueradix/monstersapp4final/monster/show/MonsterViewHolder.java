package com.blueradix.monstersapp4final.monster.show;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.monstersapp4final.R;
import com.blueradix.monstersapp4final.databinding.RecyclerItemViewBinding;
import com.blueradix.monstersapp4final.monster.Monster;


/**
 * We create this view holder representing the recycler_item_view.xml
 * The idea of this class is to create a class that can manipulate the view
 */
public class MonsterViewHolder extends RecyclerView.ViewHolder{

    private RecyclerItemViewBinding binding;


    public MonsterViewHolder(@NonNull RecyclerItemViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void updateMonster(Monster monster){
        this.binding.monsterNameTextView.setText(monster.getName());
        this.binding.monsterDescriptionTextView.setText(monster.getDescription());
        this.binding.monsterTotalVotesTextView.setText(monster.getVotes().toString() + " Votes");

        //let's put the average stars
        float averageRate;
        if(monster.getVotes() >0){
            averageRate = 1.0f * monster.getStars() / monster.getVotes();
        }else{
            averageRate = 0.0f;
        }
        this.binding.monsterRatingBar.setRating(averageRate);

        if(monster.getImage().isEmpty()) {
            this.binding.monsterImageView.setImageResource(R.drawable.monster_7);
        }else{
            int resID = binding.getRoot().getResources().getIdentifier(monster.getImage(), "drawable", binding.getRoot().getContext().getPackageName());
            this.binding.monsterImageView.setImageResource(resID);
        }
    }

    public void bind(Monster monster, OnItemClickListener onItemClickListener) {
        //Listening for clicks on the checkbox
        binding.monsterFavouriteCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( binding.monsterFavouriteCheckBox.isChecked() ) {
                    Log.i("ABC", "The Check box has been checked for ".concat(monster.getName()));
                }else{
                    Log.i("ABC", "The check box has been unchecked for ".concat(monster.getName()));
                }
            }
        });
        //Place here any other listeners for buttons, chips etc


        //Listening for clicks in other areas of the itemView (we apply the click listener to the root)
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(monster, view);
            }
        });
    }
}
