package com.example.adrian.myapplication;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //Base de datos frutas
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME= "frutasdb.db";
    private static final String TABLE_NAME = "frutas";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NIVEL = "nivel";
    private static final String COLUMN_VALOR = "valor";
    //Base de datos cereales

    private static final String TABLE_NAME_CEREALES = "cereales";
    private static final String COLUMN_ID_CEREALES = "id";
    private static final String COLUMN_NIVEL_CEREALES = "nivel";
    private static final String COLUMN_VALOR_CEREALES = "valor";
    //Base de datos leguminosas
    private static final String TABLE_NAME_LEGUMINOSAS = "leguminosas";
    private static final String COLUMN_ID_LEGUMINOSAS = "id";
    private static final String COLUMN_NIVEL_LEGUMINOSAS = "nivel";
    private static final String COLUMN_VALOR_LEGUMINOSAS = "valor";
    //Base de datos proteinas
    private static final String TABLE_NAME_PROTEINAS = "proteinas";
    private static final String COLUMN_ID_PROTEINAS = "id";
    private static final String COLUMN_NIVEL_PROTEINAS = "nivel";
    private static final String COLUMN_VALOR_PROTEINAS = "valor";
    //Base de datos vegetales

    private static final String TABLE_NAME_VEGETALES = "vegetales";
    private static final String COLUMN_ID_VEGETALES = "id";
    private static final String COLUMN_NIVEL_VEGETALES = "nivel";
    private static final String COLUMN_VALOR_VEGETALES = "valor";
    //Base de datos actividad

    private static final String TABLE_NAME_ACTIVIDAD = "actividad";
    private static final String COLUMN_ID_ACTIVIDAD = "id";
    private static final String COLUMN_NIVEL_ACTIVIDAD = "nivel";
    private static final String COLUMN_VALOR_ACTIVIDAD = "valor";


    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table frutas (id integer primary  key not  null , " +
            "nivel text not null , valor text not null);";
    private static final String TABLE_CREATE_CEREALES = "create table cereales (id integer primary  key not  null , " +
            "nivel text not null , valor text not null);";
    private static final String TABLE_CREATE_LEGUMINOSAS = "create table leguminosas (id integer primary  key not  null , " +
            "nivel text not null , valor text not null);";
    private static final String TABLE_CREATE_PROTEINAS= "create table proteinas (id integer primary  key not  null , " +
            "nivel text not null , valor text not null);";
    private static final String TABLE_CREATE_VEGETALES = "create table vegetales (id integer primary  key not  null , " +
            "nivel text not null , valor text not null);";
    private static final String TABLE_CREATE_ACTIVIDAD = "create table actividad (id integer primary  key not  null , " +
            "nivel text not null , valor text not null);";

    public DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME , null , DATABASE_VERSION );

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE_CEREALES);
        db.execSQL(TABLE_CREATE_LEGUMINOSAS);
        db.execSQL(TABLE_CREATE_PROTEINAS);
        db.execSQL(TABLE_CREATE_VEGETALES);
        db.execSQL(TABLE_CREATE_ACTIVIDAD);
        this.db = db;

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CEREALES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_VEGETALES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ACTIVIDAD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_LEGUMINOSAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PROTEINAS);
        onCreate(db);

    }
    public void eliminar(SQLiteDatabase db) {
        db= this.getWritableDatabase();
        db.delete("frutas","valor=?",new String[]{"1"});
        db.delete("cereales","valor=?",new String[]{"1"});
        db.delete("leguminosas","valor=?",new String[]{"1"});
        db.delete("proteinas","valor=?",new String[]{"1"});
        db.delete("vegetales","valor=?",new String[]{"1"});
        db.delete("actividad","valor=?",new String[]{"1"});


    }
    public void insertFruta(DataCategoria f){

        db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query =" select * from frutas";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID, count);
        values.put(COLUMN_NIVEL , f.getNivel());
        values.put(COLUMN_VALOR , f.getValor());

        db.insert(TABLE_NAME , null , values);
        db.close();

    }
    public void insertCereales(DataCategoria c){

        db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query =" select * from cereales";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID_CEREALES, count);
        values.put(COLUMN_NIVEL_CEREALES , c.getNivel());
        values.put(COLUMN_VALOR_CEREALES , c.getValor());

        db.insert(TABLE_NAME_CEREALES , null , values);
        db.close();

    }
    public void insertLegu(DataCategoria l){

        db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query =" select * from leguminosas";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID_LEGUMINOSAS, count);
        values.put(COLUMN_NIVEL_LEGUMINOSAS , l.getNivel());
        values.put(COLUMN_VALOR_LEGUMINOSAS , l.getValor());

        db.insert(TABLE_NAME_LEGUMINOSAS , null , values);
        db.close();

    }
    public void insertProteinas(DataCategoria p){

        db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query =" select * from proteinas";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID_PROTEINAS, count);
        values.put(COLUMN_NIVEL_PROTEINAS , p.getNivel());
        values.put(COLUMN_VALOR_PROTEINAS , p.getValor());

        db.insert(TABLE_NAME_PROTEINAS , null , values);
        db.close();

    }
    public void insertVegetales(DataCategoria v){

        db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query =" select * from vegetales";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID_VEGETALES, count);
        values.put(COLUMN_NIVEL_VEGETALES , v.getNivel());
        values.put(COLUMN_VALOR_VEGETALES , v.getValor());

        db.insert(TABLE_NAME_VEGETALES , null , values);
        db.close();

    }
    public void insertActividad(DataCategoria a){

        db= this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query =" select * from actividad";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID_ACTIVIDAD, count);
        values.put(COLUMN_NIVEL_ACTIVIDAD , a.getNivel());
        values.put(COLUMN_VALOR_ACTIVIDAD , a.getValor());

        db.insert(TABLE_NAME_ACTIVIDAD , null , values);
        db.close();

    }
    public String searchNivel(String nivel,String tabla){
        db = this.getReadableDatabase();
        String query = "select nivel , valor from "+tabla;
        Cursor cursor = db.rawQuery(query , null);
        String a,b;
        b = "Not Found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals(nivel)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }







}
