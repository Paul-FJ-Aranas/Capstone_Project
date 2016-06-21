package paularanas.com.capstone_project.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    private ImageView mPhotoView;

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
        mPhotoView = (ImageView) mRootView.findViewById(R.id.garden_image);

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

        TextView gardenNameView = (TextView) mRootView.findViewById(R.id.garden_name);
        TextView createdByView = (TextView) mRootView.findViewById(R.id.garden_created_by);
        TextView gardenInfoBodyView = (TextView) mRootView.findViewById(R.id.garden_info_body);
        ImageView gardenImage = (ImageView) mRootView.findViewById(R.id.garden_image);

        if (mCursor != null) {
            mRootView.setAlpha(0);
            mRootView.setVisibility(View.VISIBLE);
            mRootView.animate().alpha(1);

            gardenNameView.setText(mCursor.getString(GardenUtility.GardenQuery.TITLE));
            createdByView.setText(mCursor.getString(GardenUtility.GardenQuery.CREATOR));
            gardenInfoBodyView.setText(mCursor.getString(GardenUtility.GardenQuery.BODY));
            Picasso.with(getActivity()).load(mCursor.getString(GardenUtility.GardenQuery.PHOTO)).placeholder(R.color.theme_primary).into(gardenImage);

        } else {
            mRootView.setVisibility(View.GONE);
            gardenNameView.setText("N/A");
            createdByView.setText("N/A");
            gardenInfoBodyView.setText("N/A");
        }

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








































































