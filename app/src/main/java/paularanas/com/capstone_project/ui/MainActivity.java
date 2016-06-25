package paularanas.com.capstone_project.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import paularanas.com.capstone_project.R;

public class MainActivity extends AppCompatActivity {
    private final static int TAB_COUNT = 3;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        initializePagerAdapter();

    }

    private void initializePagerAdapter() {
        MainPagerAdapter mPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        ViewPager mPager = (ViewPager) findViewById(R.id.main_pager);
        if (mPager != null) {
            mPager.setAdapter(mPagerAdapter);
            mPager.setClipToPadding(false);
            mPager.setPageMargin(12);
            tabLayout.setupWithViewPager(mPager);
            mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        }
    }
    public void goToMapClick(View view){

       Intent intent = new Intent(this, GardenMapActivity.class);
        startActivity(intent);
    }

    private class MainPagerAdapter extends FragmentStatePagerAdapter {
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
