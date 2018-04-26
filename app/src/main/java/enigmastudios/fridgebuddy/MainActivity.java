package enigmastudios.fridgebuddy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerry on 4/3/18.
 */

public class MainActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    FoodItemAdapter adapter;

    List<FoodItem> foodItemList;

    public String url="https://images-na.ssl-images-amazon.com/images/I/71gI-IUNUkL._SL1500_.jpg";
    ImageView imageView;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_layout); //usincg recipe for now

        foodItemList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foodItemList.add(
                new FoodItem(1,"butter", "its butter", 4,1.05,url)//R.drawable.tomato)
        );
        foodItemList.add(
                new FoodItem(2,"broccoli", "its broccoli", 4,1.05,url)//R.drawable.brocolli)
        );
        foodItemList.add(
                new FoodItem(3,"corn", "its corn", 4,1.05,url)//R.drawable.apple)
        );
        adapter = new FoodItemAdapter(this, foodItemList);
        recyclerView.setAdapter(adapter);
        loadImageFromUrl(url);

    }

    private void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView, new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                    }
                });
    }

}
