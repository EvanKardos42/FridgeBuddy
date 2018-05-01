package enigmastudios.fridgebuddy;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry Gaines on 3/8/18.
 */

public class RecipeFragment extends Fragment {

    ListView ls;
    CustomAdapter ca;
    ArrayList<Recipe> values = new ArrayList<Recipe>();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Recipes");
    String TAG_recipe = "FRIDGE.BUDDY.RECIPE.POSITION";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recipe_list, container, false);
        ls = rootView.findViewById(R.id.recipe_list);
        ca =  new CustomAdapter(getActivity(),R.layout.recipe_layout,values);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Recipe recipe =  child.getValue(Recipe.class);
                    recipe.setId(child.getKey());
                    //Toast.makeText(getActivity(), recipe.getTag(), Toast.LENGTH_SHORT).show();
                    //change this to !(list.contains(recipe.getTag())
                    if(recipe.getTag().equals("Broccoli")) {
                        values.add(recipe);
                    }
                }
                ca.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ls.setAdapter(ca);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),RecipeDisplayInfo.class);
                intent.putExtra(TAG_recipe,position);
                startActivity(intent);
            }
        });
        return rootView;
    }

    public class CustomAdapter extends ArrayAdapter<Recipe>{
        private final List<Recipe> recipes;
        public CustomAdapter(Context context, int resource, ArrayList<Recipe> recipes) {
            super(context, resource, recipes);
            this.recipes = recipes;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            Recipe recipe = recipes.get(position);
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View row = inflater.inflate(R.layout.recipe_layout, null);
// Set the text
            TextView textView = (TextView) row.findViewById(R.id.textbox);
            textView.setText(recipe.getTitle());

// Set the image
            ImageView iv = row.findViewById(R.id.img_thumb);
            new DownLoadImageTask(iv).execute(recipe.getImage());
            return row;
        }
    }
}