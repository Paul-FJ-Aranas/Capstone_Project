package paularanas.com.capstone_project.data;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import paularanas.com.capstone_project.R;

/**
 * Created by Paul Aranas  on 5/31/2016.
 */

public class GardenAdapter extends RecyclerView.Adapter<GardenAdapter.GardenViewHolder> {
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
        return 0;
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
