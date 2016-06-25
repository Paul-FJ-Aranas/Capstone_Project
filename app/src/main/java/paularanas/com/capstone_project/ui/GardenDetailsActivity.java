package paularanas.com.capstone_project.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import paularanas.com.capstone_project.R;
import paularanas.com.capstone_project.data.GardenContract;
import paularanas.com.capstone_project.data.GardenUtility;

/**
 * Created by Paul Aranas on 5/31/2016.
 */
public class GardenDetailsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private int mStartPosition;
    private boolean isReturning;
    private Cursor mCursor;
    private long mStartId;
    private long mSelectedItemId;
    private ViewPager mGardenPager;
    private int mCurrentPosition;
    private GardenPagerAdapter mPagerAdapter;
    private GardenDetailsFragment mGardenDetailsFragment;

    private static final String CURRENT_PAGE_POSITION = "current_page_position";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            mCurrentPosition = mStartPosition;
        } else {
            mCurrentPosition = savedInstanceState.getInt(CURRENT_PAGE_POSITION);
        }

        setContentView(R.layout.activity_garden_details);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if(getSupportActionBar()!= null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        getSupportLoaderManager().initLoader(0, null, this);

        initializePager();
        if (savedInstanceState == null) {
            if (getIntent() != null && getIntent().getData() != null) {
                mStartId = GardenContract.GardenTable.getGardenId(getIntent().getData());
                mSelectedItemId = mStartId;
            }
        }
    }

    public void initializePager() {
        mPagerAdapter = new GardenPagerAdapter(getSupportFragmentManager());
        mGardenPager = (ViewPager) findViewById(R.id.pager);
        mGardenPager.setAdapter(mPagerAdapter);

        mGardenPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);

            }

            @Override
            public void onPageSelected(int position) {
                if (mCursor != null) {
                    mCursor.moveToPosition(position);
                }

                mCurrentPosition = position;
                if(mCursor != null) {
                    mSelectedItemId = mCursor.getLong(GardenUtility.GardenQuery._ID);
                }
            }
        });

    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, GardenContract.URI_GARDENS, GardenContract.GardenTable.PROJECTION_ALL, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mCursor = data;
        mPagerAdapter.notifyDataSetChanged();

        // Select the start ID
        if (mStartId > 0) {
            mCursor.moveToFirst();
            // TODO: optimize
            while (!mCursor.isAfterLast()) {
                if (mCursor.getLong(GardenUtility.GardenQuery._ID) == mStartId) {
                    final int position = mCursor.getPosition();
                    mGardenPager.setCurrentItem(position, false);
                    break;
                }
                mCursor.moveToNext();
            }
            mStartId = 0;
        }
    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mCursor = null;
        mPagerAdapter.notifyDataSetChanged();
    }


    private class GardenPagerAdapter extends FragmentStatePagerAdapter {
        public GardenPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
            mGardenDetailsFragment = (GardenDetailsFragment) object;

        }

        @Override
        public Fragment getItem(int position) {
            mCursor.moveToPosition(position);
            return GardenDetailsFragment.newInstance(mCursor.getLong(GardenUtility.GardenQuery._ID), mStartPosition);
        }

        @Override
        public int getCount() {
            return (mCursor != null) ? mCursor.getCount() : 0;
        }
    }

}
