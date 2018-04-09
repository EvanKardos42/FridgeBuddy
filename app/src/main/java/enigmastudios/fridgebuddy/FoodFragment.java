package enigmastudios.fridgebuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

/**
 * Created by evankardos on 3/8/18.
 */

public class FoodFragment extends Fragment {
    RecyclerView rc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.frag_food_display,container,false);
        rc = (RecyclerView) v.findViewById(R.id.rv_food);
        // Inflate the layout for this fragment
        rc.setLayoutManager(new GridLayoutManager(getActivity(),4));
        return inflater.inflate(R.layout.frag_food_display,
                                container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.top_menu_bar,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
