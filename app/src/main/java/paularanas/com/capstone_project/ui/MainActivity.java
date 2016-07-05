package paularanas.com.capstone_project.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

import paularanas.com.capstone_project.R;

public class MainActivity extends AppCompatActivity {
    private final static int TAB_COUNT = 4;
    private TabLayout tabLayout;
    int currentPosition;
    static final String START_POSITION = "extra_start_position";
    static final String CURRENT_POSITION = "extra_current_position";
    int startPosition;
    Bundle mReenterPositions;
    Long id;
    RecyclerView mRecyclerView;

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        mRecyclerView = MainGridFragment.transitionDataPasser();
        mReenterPositions = data.getExtras();
        currentPosition = mReenterPositions.getInt(CURRENT_POSITION);
        int startPosition = mReenterPositions.getInt(START_POSITION);
        id = mReenterPositions.getLong("id");
        if (startPosition != currentPosition) {
            mRecyclerView.scrollToPosition(currentPosition);
        }

    }

    /*Good Shared Element Callback information available at
      http://www.androiddesignpatterns.com/2014/12/activity-fragment-transitions-in-android-lollipop-part1.html
      and slidenerd.com -- https://www.youtube.com/watch?v=K3yMV5am-Xo */
    //Callback to remap shared element transition
    private final SharedElementCallback mCallbackExit = new SharedElementCallback() {
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            if (mReenterPositions != null) {
                startPosition = mReenterPositions.getInt(START_POSITION);
                currentPosition = mReenterPositions.getInt(CURRENT_POSITION);
                if (startPosition != currentPosition) {
                    String transitionNewName = toString().valueOf(id) + currentPosition;
                    View newSharedElement = mRecyclerView.getLayoutManager().getChildAt(currentPosition);

                    if (newSharedElement != null) {
                        names.clear();
                        names.add(transitionNewName);
                        sharedElements.clear();
                        sharedElements.put(transitionNewName, newSharedElement);
                    }

                    mReenterPositions = null;
                }
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (Build.VERSION.SDK_INT >= 21) {
                        Transition transition = TransitionInflater.from(MainActivity.this).inflateTransition(R.transition.shared_element_photo);
                        getWindow().setSharedElementEnterTransition(transition);
                        setExitSharedElementCallback(mCallbackExit);
                    }

                }
            }).start();



        setContentView(R.layout.activity_main);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        initializePagerAdapter();
       changeTabsFont();

    }


    private void initializePagerAdapter() {
        MainPagerAdapter mPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        ViewPager mPager = (ViewPager) findViewById(R.id.main_pager);
        if (mPager != null) {
            mPager.setAdapter(mPagerAdapter);
            mPager.setClipToPadding(false);
            mPager.setPageMargin(12);
            mPager.setOffscreenPageLimit(TAB_COUNT - 1);
            tabLayout.setupWithViewPager(mPager);
            mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        }
    }

    private void changeTabsFont() {

        Typeface candaraFont = Typeface.createFromAsset(getAssets(), "fonts/Candara.ttf");

        ViewGroup viewGroup = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = viewGroup.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup tab = (ViewGroup) viewGroup.getChildAt(j);
            int tabCount = tab.getChildCount();
            for (int i = 0; i < tabCount; i++) {
                View tabChild = tab.getChildAt(i);
                if (tabChild instanceof TextView) {
                    ((TextView) tabChild).setTypeface(candaraFont);
                }
            }
        }
    }

    private class MainPagerAdapter extends FragmentPagerAdapter {
        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {


            Fragment fragment = null;

            switch (position) {

                case 0:

                    fragment = new MasterGridFragment();

                    break;

                case 1:
                    fragment = new InfoFragment();

                    break;
                case 2:

                    fragment = new GardenMapFragment();

                    break;

                case 3:

                    fragment = new SpaceViewFragment();

                    break;
            }
            return fragment;

        }


        @Override
        public CharSequence getPageTitle(int position) {
            String[] tabTitles = getResources().getStringArray(R.array.tabTitles);
            return tabTitles[position];
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }
    }


}
