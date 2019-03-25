package com.example.assignment3;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import model.Recipe;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RecipeViewHolder> {
    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        public View view;
        CardView cv;
        TextView recipeName;
        TextView recipeDescription;


        RecipeViewHolder(View itemView){
            super(itemView);
            view = itemView;
            cv = (CardView)itemView.findViewById(R.id.cv);
            recipeName = (TextView)itemView.findViewById(R.id.recipeName2);
            recipeDescription = (TextView)itemView.findViewById(R.id.recipeDescription);
        }
    }

    List<Recipe> recipes;

    RVAdapter(List<Recipe> recipes){
        this.recipes = recipes;
    }

    @Override
    public int getItemCount(){
        return recipes.size();
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        RecipeViewHolder rvh = new RecipeViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(final RecipeViewHolder recipeViewHolder, final int i) {
        final String name = recipes.get(i).name;
        recipeViewHolder.recipeName.setText(recipes.get(i).name);
        recipeViewHolder.recipeDescription.setText(recipes.get(i).description);

        recipeViewHolder.view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(),Main2Activity.class);
                intent.putExtra("name",name);
                v.getContext().startActivity(intent);
            }
        });
    }
}
