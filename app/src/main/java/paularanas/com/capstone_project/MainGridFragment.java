package paularanas.com.capstone_project;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Paul Aranas on 5/30/2016.
 */
public class MainGridFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        //connect the RecyclerView and instantiate the GardenAdapter, set the LayoutManager
        //on the RecyclerView
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        GardenAdapter adapter = new GardenAdapter(getActivity());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }


}
