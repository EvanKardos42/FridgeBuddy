package enigmastudios.fridgebuddy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SaveFavoritesDataBase extends SQLiteOpenHelper {


    public SaveFavoritesDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "favorites.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table " + FoodItem.TABLE_NAME +"(" +
                "_id integer primary key autoincrement, " +
                FoodItem.COLUMN_NAME + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
