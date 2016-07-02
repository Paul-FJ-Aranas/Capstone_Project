package paularanas.com.capstone_project.data;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.common.collect.Tables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 6/3/2016.
 */
public class GardenProvider extends ContentProvider {
    private paularanas.com.capstone_project.data.GardenDatabaseHelper helper;
    interface Tables {
        String GARDENS = "gardens";
    }

    private static final int GARDENS = 1;
    private static final int GARDEN = 2;
    private static final UriMatcher sUriMatcher;

    static {
        Log.d("Tag", "CPStaticCalled");
        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        sUriMatcher.addURI(GardenContract.AUTHORITY, GardenContract.GardenTable.TABLE_NAME, GARDENS);
        sUriMatcher.addURI(GardenContract.AUTHORITY, GardenContract.GardenTable.TABLE_NAME + "/#", GARDEN);
    }

    @Override
    public boolean onCreate() {
        helper = new paularanas.com.capstone_project.data.GardenDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        final SQLiteDatabase db = helper.getReadableDatabase();
        final SelectionBuilder builder = buildSelection(uri);
        Cursor cursor = builder.where(selection, selectionArgs).query(db, projection, sortOrder);
        if (cursor != null & getContext() != null) {
            cursor.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return cursor;
    }

    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case GARDENS:
                return GardenContract.TYPE_GARDENS;
            case GARDEN:
                return GardenContract.TYPE_SINGLE_GARDEN;
            default:
                return null;
        }
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        SQLiteDatabase database = helper.getWritableDatabase();
        final long id;
        switch (sUriMatcher.match(uri)) {
            case GARDENS:
                id = database.insertWithOnConflict(GardenContract.GardenTable.TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
                break;
            default:
                throw new UnsupportedOperationException("Unrecognized Uri" + uri);
        }

        if (getContext() != null) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return GardenContract.GardenTable.buildGardensIdUri(id);

    }
    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = helper.getWritableDatabase();
        final SelectionBuilder builder = buildSelection(uri);
        if(getContext() != null) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return builder.where(selection, selectionArgs).update(db, values);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = helper.getWritableDatabase();
        final SelectionBuilder builder = buildSelection(uri);
        if (getContext() != null) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return builder.where(selection, selectionArgs).delete(db);
    }
    private SelectionBuilder buildSelection(Uri uri) {
        final SelectionBuilder builder = new SelectionBuilder();
        final int match = sUriMatcher.match(uri);
        return buildSelection(uri, match, builder);
    }

    private SelectionBuilder buildSelection(Uri uri, int match, SelectionBuilder builder) {
        final List<String> paths = uri.getPathSegments();
        switch (match) {
            case GARDENS: {
                return builder.table(Tables.GARDENS);
            }
            case GARDEN: {
                final String _id = paths.get(1);
                return builder.table(Tables.GARDENS).where(GardenContract.GardenTable._ID + "=?", _id);
            }
            default: {
                throw new UnsupportedOperationException("Unknown uri: " + uri);
            }
        }
    }

    @NonNull
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> operations)
            throws OperationApplicationException {
        final SQLiteDatabase db = helper.getWritableDatabase();
        db.beginTransaction();
        try {
            final int numOperations = operations.size();
            final ContentProviderResult[] gardenResults = new ContentProviderResult[numOperations];
            for (int i = 0; i < numOperations; i++) {
                gardenResults[i] = operations.get(i).apply(this, gardenResults, i);
            }
            db.setTransactionSuccessful();
            return gardenResults;
        } finally {
            db.endTransaction();
        }
    }
}
