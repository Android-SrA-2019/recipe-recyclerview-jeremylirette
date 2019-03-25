/**
 * Jeremy Lirette
 * March 25, 2019
 */
package com.example.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import model.DataProvider;
import model.Recipe;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");

        //Declare all necessary views
        TextView recipeName = (TextView)findViewById(R.id.recipeName2);
        ImageView recipeImage = (ImageView)findViewById(R.id.recipeImage);
        TextView recipeIngredients = (TextView)findViewById(R.id.recipeIngredients);
        TextView recipeDirections = (TextView)findViewById(R.id.recipeDirections);
        //Generate list of recipes to compare to and choose from
        List<Recipe> recipes = DataProvider.getRecipes();
        //Loop through list, find recipe matching name sent through intent, fill views
        for(Recipe r : recipes){
           if(r.name.equals(name)){
                recipeName.setText(name);
                recipeIngredients.setText(r.ingredients);
                recipeDirections.setText(r.directions);

                recipeName.setText(r.name);
                Picasso.get()
                       .load(r.image)
                       .fit()
                       .placeholder(R.drawable.ic_launcher_background)
                       .error(R.drawable.ic_launcher_background)
                       .into(recipeImage);
           }
        }






    }
}
