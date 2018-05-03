package enigmastudios.fridgebuddy;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class FoodDisplayInfo  extends AppCompatActivity {
    //views
    FoodItem food;
    Button shopping;
    Button favorites;
    Button prediction;
    TextView tx;
    ImageView image;
    private SQLiteDatabase shoppingDB;
    private SQLiteDatabase favoritesDB;

    PredictionModel predict;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_food_info);

        shoppingDB = new SaveShoppingListDataBase(this.getApplicationContext()).getWritableDatabase();
        favoritesDB = new SaveFavoritesDataBase(this.getApplicationContext()).getWritableDatabase();

        food = (FoodItem) getIntent().getSerializableExtra(FoodFragment.TAG_FOOD);
        predict = new PredictionModel(food.getName());
        tx = findViewById(R.id.display_food_name);
        tx.setText(food.getName());
        image = findViewById(R.id.display_food_image);
        new DownLoadImageTask(image).execute(food.getImage());
        //Buttons
        favorites =  findViewById(R.id.save_to_favorites);
        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(FoodItem.COLUMN_NAME,food.getName());
                favoritesDB.insert(FoodItem.TABLE_NAME,null,values);
                Toast.makeText(FoodDisplayInfo.this,
                        "Added to  Favorites",
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        shopping =  findViewById(R.id.save_to_shopping);
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(FoodItem.COLUMN_NAME,food.getName());
                shoppingDB.insert(FoodItem.TABLE_NAME,null,values);

                Toast.makeText(FoodDisplayInfo.this,
                        "Added to Shopping List",
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        prediction = findViewById(R.id.prediction);
        prediction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringPrediction=PredictionModel.prediction;

                if(prediction != null){
                String result = "price " + stringPrediction;
                Toast.makeText(FoodDisplayInfo.this,
                                result,
                            Toast.LENGTH_LONG
                            ).show();
                }
                else {
                    Toast.makeText(FoodDisplayInfo.this,
                            "no model for selected food",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });
    }
}
