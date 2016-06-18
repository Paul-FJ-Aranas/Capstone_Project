package paularanas.com.capstone_project.ui;

import android.app.Fragment;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.Html;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import paularanas.com.capstone_project.R;
import paularanas.com.capstone_project.data.GardenContract;

/**
 * Created by Paul Aranas on 5/31/2016.
 */
public class GardenDetailsFragment extends android.support.v4.app.Fragment implements android.app.LoaderManager.LoaderCallbacks<Cursor> {

    public static final String ARG_GARDEN_ID = "item_id";
    private int mStartPosition;
    private long mGardenId;
    private static final int CURSOR_LOADER = 0;
    private View mRootView;
    private Cursor mCursor;

    public static GardenDetailsFragment newInstance(long itemId, int startPosition) {
        Bundle arguments = new Bundle();
        arguments.putLong(ARG_GARDEN_ID, itemId);
        arguments.putInt("StartPosition", startPosition);
        GardenDetailsFragment fragment = new GardenDetailsFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_GARDEN_ID)) {
            mGardenId = getArguments().getLong(ARG_GARDEN_ID);
            mStartPosition = getArguments().getInt("StartPosition");

        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getLoaderManager().initLoader(CURSOR_LOADER, null, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_garden_details, container, false);
        return mRootView;
    }

    @Override
    public android.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case CURSOR_LOADER:
                return new android.content.CursorLoader(getActivity(), GardenContract.GardenTable.buildGardensIdUri(mGardenId), GardenContract.GardenTable.PROJECTION_ALL, null, null, null);
            default:
                return null;
        }
    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor data) {
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
    public void onLoaderReset(android.content.Loader loader) {
        mCursor = null;
        bindViews();

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
            gardenNameView.setText(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.TITLE)));
            createdByView.setText(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.CREATOR)));
            gardenInfoBodyView.setText(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.BODY)));
            Picasso.with(getActivity()).load(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.PHOTO))).placeholder(R.color.theme_primary).into(gardenImage);

        } else {
            mRootView.setVisibility(View.GONE);
            gardenNameView.setText("N/A");
            createdByView.setText("N/A");
            gardenInfoBodyView.setText("N/A");
        }

    }
}