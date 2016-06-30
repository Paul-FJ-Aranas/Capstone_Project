package paularanas.com.capstone_project.ui;

import android.content.Intent;
import android.os.Build;
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

import static paularanas.com.capstone_project.ui.MainGridFragment.START_POSITION;

/**
 * Created by Paul on 6/19/2016.
 */
public class MasterGridFragment extends Fragment implements MainGridFragment.GardenSelectedListener {
    public static Boolean sTwoPane = false;
    private View view;


    public MasterGridFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       if ( savedInstanceState == null){
            try {
                MainGridFragment gridFragment = new MainGridFragment();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.garden_grid_container, gridFragment, "grid_fragment");
                transaction.commit();
            } catch (Exception e) {
                Log.e("TAG", "Error with fragment instantiation");
            }
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_master_grid, container, false);
        establishPaneLayout();

        return view;
    }

    private void establishPaneLayout() {
        FrameLayout tabletDetailsContainer = (FrameLayout) view.findViewById(R.id.garden_details_tablet_container);

        if (tabletDetailsContainer != null) {
            sTwoPane = true;


        }
    }

    @Override
    public void onGardenSelected(Long id, int position, Bundle bundle) {

        if (sTwoPane) { // one activity, replace framelayout with new details fragment
            GardenDetailsFragment fragmentDetails = GardenDetailsFragment.newInstance(id, position);

            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.garden_details_tablet_container, fragmentDetails);
            transaction.commit();

        } else {
            // go to separate activity
            // launch detail activity using intent
            Intent intent = new Intent(Intent.ACTION_VIEW, GardenContract.GardenTable.buildGardensIdUri(id));

            if (Build.VERSION.SDK_INT >= 21) {

                intent.putExtra(START_POSITION, position);
            }
            startActivity(intent, bundle);
        }

    }

}
