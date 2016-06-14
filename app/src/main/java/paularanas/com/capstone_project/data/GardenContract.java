package paularanas.com.capstone_project.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Paul Aranas on 6/3/2016.
 */
public class GardenContract {

    private GardenContract() {
    }

    public static final String DATABASE_NAME = "garden_database";
    public static final int DATABASE_VERSION = 1;
    public static final String AUTHORITY = "com.paularanas.capstone_project.gardenprovider";
    public static final Uri URI_BASE = new Uri.Builder()
            .scheme(ContentResolver.SCHEME_CONTENT)
            .authority(AUTHORITY).build();
    public static final Uri URI_GARDENS = URI_BASE.buildUpon()
            .appendPath(GardenTable.TABLE_NAME).build();

    public static final String TYPE_GARDENS = ContentResolver.CURSOR_DIR_BASE_TYPE
            + "/vnd." + AUTHORITY + GardenTable.TABLE_NAME;
    private static final String COMMA = ",";
    private static final String TEXT = " TEXT";
    private static final String INTEGER = " INTEGER";

    public static abstract class GardenTable implements BaseColumns {
        public static final String TABLE_NAME = "gardens";
        public static final String _ID = "_id";
        public static final String PHOTO = "photoPath";
        public static final String TITLE = "title";
        public static final String CREATOR = "creator";
        public static final String THUMBNAIL_PATH = "thumbnail";
        public static final String BODY = "body";

        public static Uri buildGardensIdUri(long id) {
            return URI_GARDENS.buildUpon().appendPath(Long.toString(id)).build();
        }

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + "(" + _ID + INTEGER + " PRIMARY KEY AUTOINCREMENT " + COMMA +
                PHOTO + TEXT + " UNIQUE " + COMMA +
                TITLE + TEXT + COMMA +
                CREATOR + TEXT + COMMA +
                THUMBNAIL_PATH + TEXT + COMMA +
                BODY + TEXT + ")";

        public static final String[] PROJECTION_ALL =
                {_ID, PHOTO, TITLE,
                        CREATOR, THUMBNAIL_PATH,
                        BODY
                };

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


    }
}
