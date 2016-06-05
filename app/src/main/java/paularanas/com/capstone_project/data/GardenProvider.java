package paularanas.com.capstone_project.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Paul on 6/3/2016.
 */
public class GardenProvider extends ContentProvider {
    private paularanas.com.capstone_project.data.GardenDatabaseHelper helper;
    private static final int GARDENS =1;
    private static final UriMatcher sUriMatcher;

    static{
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
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
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
