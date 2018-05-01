package enigmastudios.fridgebuddy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SaveShoppingList extends SQLiteOpenHelper {

    public SaveShoppingList(Context context) {
        super(context, "food.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE table " + FoodItem.TABLE_NAME +"(" +
                                "_id integer primary key autoincrement, " +
                                    FoodItem.COLUMN_NAME + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
