package paularanas.com.capstone_project.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

/**
 * Created by Paul on 6/3/2016.
 */
public class GardenProvider extends ContentProvider {
    private paularanas.com.capstone_project.data.GardenDatabaseHelper helper;
    private static final int GARDENS = 1;
    private static final UriMatcher sUriMatcher;

    static {
        Log.d("Tag", "CPStaticCalled");
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(GardenContract.AUTHORITY, GardenContract.GardenTable.TABLE_NAME, GARDENS);
    }

    @Override
    public boolean onCreate() {
        helper = new paularanas.com.capstone_project.data.GardenDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(GardenContract.GardenTable.TABLE_NAME);
        switch (sUriMatcher.match(uri)) {

            case GARDENS:
                break;
            default:
                throw new IllegalArgumentException("Unkown Uri" + uri);
        }
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor = builder.query(database, GardenContract.GardenTable.PROJECTION_ALL, null, null, null, null, null);
        if(getContext()!=null) {
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        if (cursor != null) {
            Log.d("TAG","NOt Null" );
        }
        return cursor;
    }



    @Override
    public String getType(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case GARDENS:
                return GardenContract.TYPE_GARDENS;
            default:
                return null;
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase database = helper.getWritableDatabase();
        final long id;
        switch (sUriMatcher.match(uri)) {
            case GARDENS:
             id = database.insertWithOnConflict(GardenContract.GardenTable.TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                break;
            default:
                throw new UnsupportedOperationException("Unrecognized Uri" + uri);
        }

        if(getContext()!=null) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return GardenContract.GardenTable.buildGardensIdUri(id);


    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
