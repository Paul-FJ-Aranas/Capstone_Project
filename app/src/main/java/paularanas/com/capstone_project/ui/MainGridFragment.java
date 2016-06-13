package paularanas.com.capstone_project.ui;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import paularanas.com.capstone_project.R;
import paularanas.com.capstone_project.data.FetchGardensService;
import paularanas.com.capstone_project.data.GardenContract;

/**
 * Created by Paul Aranas on 5/30/2016.
 */
public class MainGridFragment extends Fragment implements android.app.LoaderManager.LoaderCallbacks<Cursor> {

    private RecyclerView mRecyclerView;
    private final static String ACTION_GARDEN_DATA = "paularanas.com.capstone_project.data.ACTION_GARDEN_DATA";
    private BroadcastReceiver mLocalReceiver;
    private ArrayList<String> mGardenData = new ArrayList();
    private final static int CURSOR_LOADER = 1;
    GardenAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        getLoaderManager().initLoader(CURSOR_LOADER, null, this);

        if (savedInstanceState == null) {
            getActivity().startService(new Intent(getActivity(), FetchGardensService.class));
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        //connect the RecyclerView and instantiate the GardenAdapter, set the LayoutManager
        //on the RecyclerView
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);


        return view;
    }


    @Override
    public android.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case CURSOR_LOADER:
                return new android.content.CursorLoader(getActivity(), GardenContract.URI_GARDENS, GardenContract.GardenTable.PROJECTION_ALL,
                        null, null, null);
            default:
                return null;

        }
    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor data) {

        mAdapter = new GardenAdapter(getActivity(), data);
        mAdapter.setHasStableIds(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {
        mRecyclerView.setAdapter(null);
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}

class GardenAdapter extends RecyclerView.Adapter<GardenAdapter.GardenViewHolder> {
    private Context mContext;
    private Cursor mCursor;
    int mCurrentPosition;
    View view;


    public GardenAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public GardenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.grid_item_garden, parent, false);
        final GardenViewHolder vh = new GardenViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {


                                    }
                                }
        );

        return vh;
    }

    @Override
    public void onBindViewHolder(GardenViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        mCurrentPosition = position;

        holder.titleView.setText(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.TITLE)));
        Picasso.with(mContext)
                .load(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.THUMBNAIL_PATH))).placeholder(R.color.theme_primary)
                .into(holder.thumbnailView);

    }


    @Override
    public int getItemCount() {
        if (mCursor != null) {
            return mCursor.getCount();
        } else {
            return 0;
        }
    }

    public static class GardenViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnailView;
        public TextView titleView;

        public GardenViewHolder(View view) {
            super(view);
            thumbnailView = (ImageView) view.findViewById(R.id.thumbnail);
            titleView = (TextView) view.findViewById(R.id.garden_title);

        }


    }
}




