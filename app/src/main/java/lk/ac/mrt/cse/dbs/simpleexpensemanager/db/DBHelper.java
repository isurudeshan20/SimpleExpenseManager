package lk.ac.mrt.cse.dbs.simpleexpensemanager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "200273P.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE account_details(accountNo TEXT PRIMARY KEY,bankName TEXT, accountHolderName TEXT,balance REAL)");
        db.execSQL("CREATE TABLE transaction_details(id INTEGER PRIMARY KEY AUTOINCREMENT,date TEXT,accountNo TEXT,expenseType TEXT,amount REAL,FOREIGN KEY(accountNo) REFERENCES account_details(accountNo))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS account_details");
        db.execSQL("DROP TABLE IF EXISTS transaction_details");
    }

}
