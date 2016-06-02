package paularanas.com.capstone_project;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Paul Aranas on 5/31/2016.
 */
public class GardenDetailsFragment extends android.support.v4.app.Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final String ARG_GARDEN_ID = "item_id";
    private int mStartPosition;
    private long mGardenId;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
