package paularanas.com.capstone_project.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import paularanas.com.capstone_project.R;
import paularanas.com.capstone_project.data.GardenContract;
import paularanas.com.capstone_project.data.GardenUtility;

/**
 * Created by Paul Aranas on 5/31/2016.
 */
public class GardenDetailsFragment extends Fragment implements
        LoaderManager.LoaderCallbacks<Cursor> {

    public static final String ARG_ITEM_ID = "item_id";
    private Cursor mCursor;
    private long mItemId;
    private View mRootView;

    private ImageView mGardenImage;

    private int mStartPosition;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */

    public GardenDetailsFragment() {
    }

    public static GardenDetailsFragment newInstance(long itemId, int startPosition) {
        Bundle arguments = new Bundle();
        arguments.putLong(ARG_ITEM_ID, itemId);
        arguments.putInt("StartPosition", startPosition);
        GardenDetailsFragment fragment = new GardenDetailsFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItemId = getArguments().getLong(ARG_ITEM_ID);
            mStartPosition = getArguments().getInt("StartPosition");

        }

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // In support library r8, calling initLoader for a fragment in a FragmentPagerAdapter in
        // the fragment's onCreate may cause the same LoaderManager to be dealt to multiple
        // fragments because their mIndex is -1 (haven't been added to the activity yet). Thus,
        // we do this in onActivityCreated.
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        mRootView = inflater.inflate(R.layout.fragment_garden_details, container, false);
        mGardenImage = (ImageView) mRootView.findViewById(R.id.garden_image);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mGardenImage.setTransitionName(toString().valueOf(mItemId) + mStartPosition);
        }


        mRootView.findViewById(R.id.share_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Intent.createChooser(ShareCompat.IntentBuilder.from(getActivity())
                        .setType("text/plain")
                        .setText("Some sample text")
                        .getIntent(), getString(R.string.action_share)));
            }
        });

        bindViews();
        return mRootView;
    }

    private void bindViews() {
        if (mRootView == null) {
            return;
        }


        Typeface corbelFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/Corbel.ttf");
        Typeface candaraFont = Typeface.createFromAsset(getContext().getAssets(), "fonts/Candara.ttf");

        TextView gardenNameView = (TextView) mRootView.findViewById(R.id.garden_name);
        TextView createdByView = (TextView) mRootView.findViewById(R.id.garden_created_by);
        TextView gardenInfoBodyView = (TextView) mRootView.findViewById(R.id.garden_info_body);

        gardenNameView.setTypeface(candaraFont);
        createdByView.setTypeface(candaraFont);
        gardenInfoBodyView.setTypeface(corbelFont);
        if (mCursor != null) {
            gardenNameView.setText(mCursor.getString(GardenUtility.GardenQuery.TITLE));
            createdByView.setText(mCursor.getString(GardenUtility.GardenQuery.CREATOR));
            gardenInfoBodyView.setText(mCursor.getString(GardenUtility.GardenQuery.BODY));
            Picasso.with(getActivity()).load(mCursor.getString(GardenUtility.GardenQuery.PHOTO)).placeholder(R.color.theme_primary).into(mGardenImage);


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                scheduleStartPostponedTransition(mGardenImage);
            }
        }

    }

    private void scheduleStartPostponedTransition(final View sharedElement) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElement.getViewTreeObserver().addOnPreDrawListener(
                    new ViewTreeObserver.OnPreDrawListener() {
                        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public boolean onPreDraw() {
                            sharedElement.getViewTreeObserver().removeOnPreDrawListener(this);
                            getActivity().startPostponedEnterTransition();
                            return true;
                        }
                    });
        }
    }

    @Nullable
    ImageView getImageView() {
        if (isViewInBounds(getActivity().getWindow().getDecorView(), mGardenImage)) {
            return mGardenImage;
        }
        return null;
    }

    private static boolean isViewInBounds(@NonNull View container, @NonNull View view) {
        Rect containerBounds = new Rect();
        container.getHitRect(containerBounds);
        return view.getLocalVisibleRect(containerBounds);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(getActivity(), GardenContract.GardenTable.buildGardensIdUri(mItemId), GardenContract.GardenTable.PROJECTION_ALL, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (!isAdded()) {
            if (data != null) {
                data.close();
            }
            return;
        }

        mCursor = data;
        if (mCursor != null && !mCursor.moveToFirst()) {

            mCursor.close();
            mCursor = null;
        }


        bindViews();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mCursor = null;
        bindViews();

    }

}



