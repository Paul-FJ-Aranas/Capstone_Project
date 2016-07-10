package paularanas.com.capstone_project.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.List;
import java.util.Map;

import paularanas.com.capstone_project.AnalyticsApplication;
import paularanas.com.capstone_project.R;
import paularanas.com.capstone_project.data.GardenContract;
import paularanas.com.capstone_project.data.GardenUtility;

import static paularanas.com.capstone_project.ui.MainGridFragment.CURRENT_POSITION;
import static paularanas.com.capstone_project.ui.MainGridFragment.START_POSITION;

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
    private Tracker mTracker;

    //Callback to remap shared element transition
    private final SharedElementCallback mCallback = new SharedElementCallback() {
        @Override
        public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
            if (isReturning) {
                ImageView sharedElement = mGardenDetailsFragment.getImageView();
                if (sharedElement == null) {
                    names.clear();
                    sharedElements.clear();
                } else if (mStartPosition != mCurrentPosition) {

                    names.clear();
                    names.add(toString().valueOf(mSelectedItemId) + mCurrentPosition);
                    sharedElements.clear();
                    sharedElements.put(names.get(0), sharedElement);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Analytics
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        mStartPosition = getIntent().getIntExtra(START_POSITION, 0);
        if (savedInstanceState == null) {
            mCurrentPosition = mStartPosition;
        } else {
            mCurrentPosition = savedInstanceState.getInt(CURRENT_PAGE_POSITION);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            postponeEnterTransition();
            setEnterSharedElementCallback(mCallback);
            //Fade in content with imaged shared element transition
            Fade fade = new Fade();
            fade.setDuration(300);

            getWindow().setEnterTransition(fade);

            getWindow().setReturnTransition(fade);

            Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.shared_element_photo);
            getWindow().setSharedElementEnterTransition(transition);

            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }


        setContentView(R.layout.activity_garden_details);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportLoaderManager().initLoader(0, null, this);

        initializePager();
        if (savedInstanceState == null) {
            if (getIntent() != null && getIntent().getData() != null) {
                mStartId = GardenContract.GardenTable.getGardenId(getIntent().getData());
                mSelectedItemId = mStartId;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_PAGE_POSITION, mCurrentPosition);
    }

    @Override
    public void finishAfterTransition() {
        isReturning = true;
        Intent data = new Intent();
        mCursor.moveToPosition(mCurrentPosition);

        Long id = (mCursor.getLong(GardenUtility.GardenQuery._ID));
        data.putExtra("id", id);
        data.putExtra(START_POSITION, mStartPosition);
        data.putExtra(CURRENT_POSITION, mCurrentPosition);
        setResult(RESULT_OK, data);
        super.finishAfterTransition();
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
                if (mCursor != null) {
                    mSelectedItemId = mCursor.getLong(GardenUtility.GardenQuery._ID);
                }
            }
        });

        mGardenPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {


                mTracker.setScreenName("garden number: " + position);
                mTracker.send(new HitBuilders.ScreenViewBuilder().build());

            }

        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finishAfterTransition();
                return true;
        }
        return super.onOptionsItemSelected(item);
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
