package paularanas.com.capstone_project.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import paularanas.com.capstone_project.R;
import paularanas.com.capstone_project.data.GardenContract;

/**
 * Created by Paul Aranas on 5/31/2016.
 */
public class GardenDetailsActivity extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<Cursor> {
    private GardenPagerAdapter mPagerAdapter;
    private ViewPager mPager;
    private paularanas.com.capstone_project.ui.GardenDetailsFragment mGardenDetailsFragment;
    private Cursor mCursor;
    private final static int CURSOR_LOADER = 1;
    private int mStartPosition;
    private long mSelectedItemId;
    private long mStartId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_details);
        getLoaderManager().initLoader(CURSOR_LOADER, null, this);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initializePagerAdapter();
        if (savedInstanceState == null) {
            if (getIntent() != null && getIntent().getData() != null) {
                mStartId = GardenContract.GardenTable.getGardenId(getIntent().getData());
                mSelectedItemId = mStartId;
            }
        }
    }
    private void initializePagerAdapter() {
        mPagerAdapter = new GardenPagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mPagerAdapter);
        mPager.setClipToPadding(false);
        mPager.setPageMargin(12);
    }

    @Override
    public android.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case CURSOR_LOADER:
                return new android.content.CursorLoader(this, GardenContract.URI_GARDENS, GardenContract.GardenTable.PROJECTION_ALL,
                        null, null, null);
            default:
                return null;

        }

    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor data) {
        mCursor = data;
        mPagerAdapter.notifyDataSetChanged();

        // Select the start ID
        if (mStartId > 0) {
            mCursor.moveToFirst();

            while (!mCursor.isAfterLast()) {
                if (mCursor.getLong(mCursor.getColumnIndex(GardenContract.GardenTable._ID)) == mStartId) {
                    final int position = mCursor.getPosition();
                    mPager.setCurrentItem(position, false);
                    break;
                }
                mCursor.moveToNext();
            }
            mStartId = 0;
        }
    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {
        mCursor = null;
        mPagerAdapter.notifyDataSetChanged();
    }


    private class GardenPagerAdapter extends FragmentStatePagerAdapter {
        public GardenPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            mCursor.moveToPosition(position);
            return GardenDetailsFragment.newInstance(mCursor.getLong(0), mStartPosition);
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
            mGardenDetailsFragment = (GardenDetailsFragment) object;

        }

        @Override
        public int getCount() {
            return (mCursor != null) ? mCursor.getCount() : 0;
        }
    }
}