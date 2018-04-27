package enigmastudios.fridgebuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

class FoodDisplayInfo  extends AppCompatActivity {
    FoodItem food;
    Button shopping;
    Button favorites;
    Button prediction;
    TextView tx;
    ImageView image;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Produce");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_food_info);

        food = (FoodItem) getIntent().getSerializableExtra(FoodFragment.TAG_FOOD);
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

            }
        });
        prediction = findViewById(R.id.prediction);
        prediction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
