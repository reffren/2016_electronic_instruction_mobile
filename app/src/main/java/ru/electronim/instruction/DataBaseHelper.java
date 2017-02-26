package ru.electronim.instruction;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tim on 24.04.2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db_instruction";
    private static final String TABLE_USER_NAME = "users";
    private static final String TABLE_INSTRUCTION_NAME = "instructions";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_USER_CREATE = "create table "+TABLE_USER_NAME+"( " +"_id"+" integer primary key autoincrement,"+ "username varchar(20), password varchar(20));";
    private static final String DATABASE_INSTRUCTION_CREATE = "create table "+TABLE_INSTRUCTION_NAME+"( " +"_id"+" integer primary key autoincrement,"+ "data_vydachi_zayavki varchar(10), dolzhnost_vidav_zayavku varchar(10), rukovod_rabot varchar(10), teh_karta varchar(10), data_nomer_prikaza varchar(10), fio_signal_1 varchar(10), fio_signal_2 varchar(10), fio_signal_3 varchar(10), fio_signal_4 varchar(10), mesto_km_1 varchar(10), mesto_pk_1 varchar(10), mesto_put_1 varchar(10), mesto_km_2 varchar(10), mesto_pk_2 varchar(10), plan_data_rabot varchar(10), po_soglasovaniyou varchar(10), date1 varchar(10), data_c_chasov_1 varchar(10), data_min_1 varchar(10), date2 varchar(10), data_c_chasov_2 varchar(10), data_min_2 varchar(10), fio_dispetchera varchar(10), fio_instructirushego varchar(10), time_record varchar(10));";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_USER_CREATE);
        db.execSQL(DATABASE_INSTRUCTION_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
