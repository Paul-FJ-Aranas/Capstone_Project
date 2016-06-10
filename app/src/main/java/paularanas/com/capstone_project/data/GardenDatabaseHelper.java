package paularanas.com.capstone_project.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Paul Aranas on 6/3/2016.
 */
public class GardenDatabaseHelper extends SQLiteOpenHelper {

    public GardenDatabaseHelper(Context context) {
        super(context, GardenContract.DATABASE_NAME, null, GardenContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(GardenContract.GardenTable.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(GardenContract.GardenTable.DELETE_TABLE);
        onCreate(db);

    }
}
