package enigmastudios.fridgebuddy;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by evankardos on 3/8/18.
 */

public class FoodFragment extends Fragment {
    ListView lv;
    String s[] ={"the","and","old"};
    ArrayList<String> values = new ArrayList<String>(Arrays.asList(s));
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("List").child("userID");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.food_fragment,container,false);

        lv =  (ListView) rootView.findViewById(R.id.listThing);
        lv.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.list_content, s));

       /* myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    String food = child.getValue(String.class);
                    //food.setId(child.getKey());
                    System.out.println(food);
                    values.add(food);
                }
                mFoodAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

        return inflater.inflate(R.layout.food_fragment,
                                container, false);
    }

}
