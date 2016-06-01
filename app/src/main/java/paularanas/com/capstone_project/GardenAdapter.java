package paularanas.com.capstone_project;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Paul on 5/31/2016.
 */

public class GardenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private Cursor mCursor;
    View view;

    public GardenAdapter(Cursor cursor, Context ctx) {
        mCursor = cursor;
        context = ctx;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.grid_item_garden, parent, false);
        final ViewHolder vh = new ViewHolder(view);


        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnailView;
        public TextView titleView;

        public ViewHolder(View view) {
            super(view);
            thumbnailView = (ImageView) view.findViewById(R.id.thumbnail);
            titleView = (TextView) view.findViewById(R.id.garden_title);

        }


    }}
