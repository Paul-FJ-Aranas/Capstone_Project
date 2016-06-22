package paularanas.com.capstone_project.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import paularanas.com.capstone_project.R;
import paularanas.com.capstone_project.data.GardenContract;

/**
 * Created by Paul on 6/19/2016.
 */
public class MasterGridFragment extends Fragment implements MainGridFragment.GardenSelectedListener {
    public static Boolean sTwoPane = false;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_master_grid, container, false);
        establishPaneLayout();
        MainGridFragment gridFragment = new MainGridFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.garden_grid_container, gridFragment, "grid_fragment");
        transaction.commit();

        return view;
    }

    private void establishPaneLayout() {
        FrameLayout tabletDetailsContainer = (FrameLayout) view.findViewById(R.id.garden_details_tablet_container);

        if (tabletDetailsContainer != null) {
            sTwoPane = true;
            MainGridFragment gridFragment =
                    (MainGridFragment) getFragmentManager().findFragmentByTag("grid_fragment");

        }
    }

    @Override
    public void onGardenSelected(Long id) {

        if (sTwoPane) { // one activity, replace framelayout with new details fragment

           GardenDetailsFragment fragmentDetails = GardenDetailsFragment.newInstance( id,0);

            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.garden_details_tablet_container, fragmentDetails);
            transaction.commit();

        } else {
            // go to separate activity
            // launch detail activity using intent
            Log.d("TAG2","position: "+ toString().valueOf(id));
            Intent intent = new Intent(Intent.ACTION_VIEW, GardenContract.GardenTable.buildGardensIdUri(id));
            startActivity(intent);
        }

    }

}
