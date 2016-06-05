package paularanas.com.capstone_project.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Paul on 6/3/2016.
 */
public class GardenProvider extends ContentProvider {
    private paularanas.com.capstone_project.data.GardenDatabaseHelper helper;
    private static final int GARDENS = 1;
    private static final UriMatcher sUriMatcher;

    static {
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(GardenContract.AUTHORITY, GardenContract.GardenTable.TABLE_NAME, GARDENS);
    }

    @Override
    public boolean onCreate() {
        helper = new paularanas.com.capstone_project.data.GardenDatabaseHelper(getContext());
        return null != helper;
    }

    @Nullable
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
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case GARDENS:
                return GardenContract.TYPE_GARDENS;
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase database = helper.getWritableDatabase();
        int rowsDeleted = 0;
        long id = 0;
        switch (sUriMatcher.match(uri)) {
            case GARDENS:
                database.insertWithOnConflict(GardenContract.GardenTable.TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                break;
            default:
                throw new UnsupportedOperationException("Unrecognized Uri" + uri);
        }
        Uri ur = ContentUris.withAppendedId(uri, id);
        getContext().getContentResolver().notifyChange(uri, null);
        database.close();
        return ur;

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
