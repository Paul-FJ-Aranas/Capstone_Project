package paularanas.com.capstone_project.ui;

import android.app.LoaderManager;
import android.content.BroadcastReceiver;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import java.util.ArrayList;

import paularanas.com.capstone_project.R;
import paularanas.com.capstone_project.data.GardenContract;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    private MainPagerAdapter mPagerAdapter;
    private ViewPager mPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_details);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initializePagerAdapter();

    }

    private void initializePagerAdapter() {
        mPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.main_pager);
        mPager.setAdapter(mPagerAdapter);
        mPager.setClipToPadding(false);
        mPager.setPageMargin(12);
    }

    private class MainPagerAdapter extends FragmentStatePagerAdapter {
        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
           return null;
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {


        }

        @Override
        public int getCount() {
            return  0;
        }
    }
}
