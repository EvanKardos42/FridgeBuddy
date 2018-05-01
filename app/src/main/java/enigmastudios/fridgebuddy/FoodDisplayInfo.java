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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

class FoodDisplayInfo  extends AppCompatActivity {
    //views
    FoodItem food;
    Button shopping;
    Button favorites;
    Button prediction;
    TextView tx;
    ImageView image;
    private SQLiteDatabase mDatabase;

    PredictionModel predict;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_food_info);

        mDatabase = new SaveShoppingList(this.getApplicationContext()).getWritableDatabase();

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

            }
        });
        shopping =  findViewById(R.id.save_to_shopping);
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(FoodItem.COLUMN_NAME,food.getName());
                mDatabase.insert(FoodItem.TABLE_NAME,null,values);
            }
        });

        prediction = findViewById(R.id.prediction);
        prediction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringPrediction=PredictionModel.prediction;
                String result = "predicting prices for corn: " + stringPrediction;
                Toast.makeText(FoodDisplayInfo.this,
                                result,
                            Toast.LENGTH_LONG
                            ).show();
            }
        });
    }
}
