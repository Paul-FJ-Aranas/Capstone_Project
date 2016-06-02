package paularanas.com.capstone_project;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

/**
 * Created by Paul on 6/2/2016.
 */
//Helper class for loading grid / list of gardens and individual gardens
public class GardenLoader extends CursorLoader {

    public GardenLoader(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        super(context, uri, Query.PROJECTION, selection, selectionArgs, sortOrder);
    }

    public static GardenLoader newAllGardensInstance(Context context) {
        return new GardenLoader(context, GardenContract.Items.buildDirUri());
    }

    public static GardenLoader newInstanceForGardenId(Context context, long itemId) {
        return new GardenLoader(context, GardenContract.Items.buildItemUri(itemId));
    }

    //TODO: Create GardenContract Class
    public interface Query {
        String[] PROJECTION = {
                GardenContract.Items._ID,
                GardenContract.Items.TITLE,
                GardenContract.Items.BODY,
                GardenContract.Items.CREATOR,
                GardenContract.Items.THUMB_URL,
                GardenContract.Items.PHOTO_URL,

        };

        int _ID = 0;
        int TITLE = 1;
        int CREATOR = 2;
        int THUMB_URL = 3;
        int PHOTO_URL = 4;
        int BODY = 5;
    }
}
