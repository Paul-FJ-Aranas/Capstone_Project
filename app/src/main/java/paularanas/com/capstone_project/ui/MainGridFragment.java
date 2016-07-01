package paularanas.com.capstone_project.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import paularanas.com.capstone_project.R;
import paularanas.com.capstone_project.data.FetchGardensService;
import paularanas.com.capstone_project.data.GardenContract;
import paularanas.com.capstone_project.data.GardenUtility;

/**
 * Created by Paul Aranas on 5/30/2016.
 */
public class MainGridFragment extends android.support.v4.app.Fragment implements LoaderManager.LoaderCallbacks {
    private RecyclerView mRecyclerView;
    private final static String ACTION_GARDEN_DATA = "paularanas.com.capstone_project.data.ACTION_GARDEN_DATA";
    GardenAdapter mAdapter;
    private GardenSelectedListener mGardenListener;
    private int mActivatedPos = 0;
    private int currentPosition;
    static final String START_POSITION = "extra_start_position";
    static final String CURRENT_POSITION = "extra_current_position";
    private Cursor mCursor;
    private View view;
    public static RecyclerView theRecyclerView;
    GridLayoutManager glm;
    private Bundle state;

    public interface GardenSelectedListener {

        public void onGardenSelected(Long id, int position, Bundle bundle);
    }

    public static RecyclerView transitionDataPasser() {

        return theRecyclerView;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        state = savedInstanceState;
        getLoaderManager().initLoader(0, null, this);

        if (savedInstanceState == null) {
            getActivity().startService(new Intent(getActivity(), FetchGardensService.class));
        }

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        //connect the RecyclerView and instantiate the GardenAdapter, set the LayoutManager
        //on the RecyclerView

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        int columnCount = getResources().getInteger(R.integer.grid_columns);
        glm = new GridLayoutManager(getActivity(), columnCount, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(glm);
        mRecyclerView.setHasFixedSize(true);

        theRecyclerView = mRecyclerView;
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("currentScrollPos", 0);
            mRecyclerView.scrollToPosition(currentPosition);
        }

        onAttachFragment(getParentFragment());


        return view;
    }


    public void onAttachFragment(android.support.v4.app.Fragment fragment) {

        mGardenListener = (GardenSelectedListener) fragment;


    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Restore previously activated item position.
        if (savedInstanceState != null && MasterGridFragment.sTwoPane && savedInstanceState.containsKey("ACTIVATED_POS")) {
            setActivatedPosition(savedInstanceState.getInt("ACTIVATED_POS", mActivatedPos));
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (MasterGridFragment.sTwoPane) {
            outState.putInt("ACTIVATED_POS", mActivatedPos);
            outState.putInt("currentScrollPos", currentPosition);
        }
    }


    private void setActivatedPosition(int position) {
        mActivatedPos = position;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        //  switch (id) {
        //    case CURSOR_LOADER:
        return new CursorLoader(getActivity(), GardenContract.URI_GARDENS, GardenContract.GardenTable.PROJECTION_ALL,
                null, null, null);
        //  default:
        //      return null;
//
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onLoadFinished(Loader loader, Object data) {
        mCursor = (Cursor) data;

        mAdapter = new GardenAdapter(getActivity(), (Cursor) data, mGardenListener);
        mRecyclerView.setAdapter(mAdapter);

        if (MasterGridFragment.sTwoPane) {

            if (state == null) {
                mRecyclerView.post(new Runnable() {

                    @Override
                    public void run() {
                        if (mRecyclerView != null) {
                            mRecyclerView.findViewHolderForAdapterPosition(0).itemView.performClick();
                        }
                    }
                });
            }
        }

    }

    @Override
    public void onLoaderReset(Loader loader) {
        mRecyclerView.setAdapter(null);

    }


    private class GardenAdapter extends RecyclerView.Adapter<MainGridFragment.GardenViewHolder> {
        private Context mContext;
        private Cursor mCursor;
        int mCurrentPosition;
        View view;
        MainGridFragment.GardenSelectedListener mGardenSelectedListener;


        public GardenAdapter(Context context, Cursor cursor, MainGridFragment.GardenSelectedListener listener) {
            mContext = context;
            mCursor = cursor;
            mGardenSelectedListener = listener;

        }

        @Override
        public long getItemId(int position) {
            mCursor.moveToPosition(position);
            return mCursor.getLong(GardenUtility.GardenQuery._ID);
        }


        @Override
        public MainGridFragment.GardenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_garden, parent, false);
            final GardenViewHolder vh = new GardenViewHolder(view);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (Build.VERSION.SDK_INT >= 21) {
                        currentPosition = vh.getAdapterPosition();
                        mRecyclerView.getLayoutManager().findViewByPosition(currentPosition).setTag("garden_photo" + currentPosition);


                        view.findViewById(R.id.thumbnail).setTransitionName(toString().valueOf(getItemId(vh.getAdapterPosition())) + vh.getAdapterPosition());
                        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, view.findViewById(R.id.thumbnail),
                                view.findViewById(R.id.thumbnail).getTransitionName());


                        mGardenSelectedListener.onGardenSelected(getItemId(vh.getAdapterPosition()), vh.getAdapterPosition(), options.toBundle());
                    }
                }
            });
            return vh;
        }

        @Override
        public void onBindViewHolder(final MainGridFragment.GardenViewHolder holder, final int position) {


            mCursor.moveToPosition(position);
            mCurrentPosition = position;
            Typeface candaraFont = Typeface.createFromAsset(mContext.getAssets(), "fonts/Candara.ttf");


            holder.titleView.setText(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.TITLE)));
            holder.titleView.setTextSize(mContext.getResources().getDimension(R.dimen.grid_item_text_size));
            holder.titleView.setTypeface(candaraFont);


            double density = mContext.getResources().getDisplayMetrics().density;
            Log.d("Density", toString().valueOf(density));
            if (density >= 4.0) {
                //"xxxhdpi";

                Picasso.with(mContext)
                        .load(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.THUMBNAIL_PATH))).placeholder(R.color.theme_primary).resize(1000, 1000)
                        .into(holder.thumbnailView);


            } else if (density >= 3.0 && density < 4.0) {
                //xxhdpi

                Picasso.with(mContext)
                        .load(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.THUMBNAIL_PATH))).placeholder(R.color.theme_primary).resize(1000, 1000)
                        .into(holder.thumbnailView);


            } else if (density >= 2.0) {
                //xhdpi

                Picasso.with(mContext)
                        .load(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.THUMBNAIL_PATH))).placeholder(R.color.theme_primary).resize(500, 700)
                        .into(holder.thumbnailView);


            } else if (density >= 1.5 && density < 2.0) {
                //hdpi
                Picasso.with(mContext)
                        .load(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.THUMBNAIL_PATH))).placeholder(R.color.theme_primary)
                        .into(holder.thumbnailView);


            } else if (density >= 1.0 && density < 1.5) {
                //mdpi

                Picasso.with(mContext)
                        .load(mCursor.getString(mCursor.getColumnIndex(GardenContract.GardenTable.THUMBNAIL_PATH))).placeholder(R.color.theme_primary)
                        .into(holder.thumbnailView);

            }

        }


        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @Override
        public int getItemCount() {

            return mCursor.getCount();
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






