package enigmastudios.fridgebuddy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerry on 4/3/18.
 */

public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    FoodItemAdapter adapter;

    List<FoodItem> foodItemList;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_layout); //usincg recipe for now

        foodItemList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodItemList.add(
                new FoodItem(1,"tomato", "its a tomato", 4,1.05,R.drawable.tomato)
        );
        foodItemList.add(
                new FoodItem(2,"broccoli", "its a broccoli", 4,1.05,R.drawable.broccoli)
        );
        foodItemList.add(
                new FoodItem(3,"garlic", "its a garlic", 4,1.05,R.drawable.garlic)
        );
        adapter = new FoodItemAdapter(this, foodItemList);
        recyclerView.setAdapter(adapter);

    }
}
