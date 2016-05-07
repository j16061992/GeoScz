package jc.com.geoscz.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by PERSONAL on 07/05/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper{

    private SQLiteDatabase db;

    private static final String DATABASE_NAME = "DoneDB";
    private static final int DATABASE_VERSION = 1;

    public SQLiteHelper(Context contexto, SQLiteDatabase.CursorFactory factory) {
        super(contexto, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DALCategoria.CREATE_TABLA);
        db.execSQL(DALActEco.CREATE_TABLA);
        db.execSQL(DALPredio.CREATE_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS "+DALCategoria.TABLA);
        db.execSQL("DROP TABLE IF EXISTS "+DALActEco.TABLA);
        db.execSQL("DROP TABLE IF EXISTS "+ DALPredio.TABLA);

        db.execSQL(DALCategoria.CREATE_TABLA);
        db.execSQL(DALActEco.CREATE_TABLA);
        db.execSQL(DALPredio.CREATE_TABLA);
    }

    public SQLiteDatabase beginTransaction(){
        db = this.getWritableDatabase();
        db.beginTransaction();
        return db;
    }

    public void commit() {
        db.setTransactionSuccessful();
    }

    public void endTransaction() {
        db.endTransaction();
        db.close();
    }

}