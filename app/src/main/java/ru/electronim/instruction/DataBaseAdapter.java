package ru.electronim.instruction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Tim on 24.04.2016.
 */
public class DataBaseAdapter {

    private static final String DATABASE_TABLE = "users";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    InstructionActivity instructionActivity;

    private static final String TABLE_INSTRUCTION_NAME = "instructions";
    public static final String KEY_INSTRUCTION_ID = "_id";
    public static final String KEY_INSTRUCTION_DATA_VYDACHI_ZAYAVKI = "data_vydachi_zayavki";
    public static final String KEY_INSTRUCTION_DOLZHNOST_VIDAV_ZAYAVKU = "dolzhnost_vidav_zayavku";
    public static final String KEY_INSTRUCTION_RUKOVOD_RABOT = "rukovod_rabot";
    public static final String KEY_INSTRUCTION_TEH_KARTA = "teh_karta";
    public static final String KEY_INSTRUCTION_DATA_NOMER_PRIKAZA = "data_nomer_prikaza";
    public static final String KEY_INSTRUCTION_FIO_SIGNAL_1 = "fio_signal_1";
    public static final String KEY_INSTRUCTION_FIO_SIGNAL_2 = "fio_signal_2";
    public static final String KEY_INSTRUCTION_FIO_SIGNAL_3 = "fio_signal_3";
    public static final String KEY_INSTRUCTION_FIO_SIGNAL_4 = "fio_signal_4";
    public static final String KEY_INSTRUCTION_MEST_KM_1 = "mesto_km_1";
    public static final String KEY_INSTRUCTION_MESTO_PK_1 = "mesto_pk_1";
    public static final String KEY_INSTRUCTION_MESTO_PUT_1 = "mesto_put_1";
    public static final String KEY_INSTRUCTION_MESTO_KM_2 = "mesto_km_2";
    public static final String KEY_INSTRUCTION_MESTO_PK_2 = "mesto_pk_2";
    public static final String KEY_INSTRUCTION_PLAN_DATA_RABOT = "plan_data_rabot";
    public static final String KEY_INSTRUCTION_PO_SOGLASOVANIYOU = "po_soglasovaniyou";
    public static final String KEY_INSTRUCTION_DATE1 = "date1";
    public static final String KEY_INSTRUCTION_DATA_C_CHASOV_1 = "data_c_chasov_1";
    public static final String KEY_INSTRUCTION_DATA_MIN_1 = "data_min_1";
    public static final String KEY_INSTRUCTION_DATE2 = "date2";
    public static final String KEY_INSTRUCTION_DATA_C_CHASOV_2 = "data_c_chasov_2";
    public static final String KEY_INSTRUCTION_DATA_MIN_2 = "data_min_2";
    public static final String KEY_INSTRUCTION_FIO_DISPETCHERA = "fio_dispetchera";
    public static final String KEY_INSTRUCTION_FIO_INSTRUCTIRUSHEGO = "fio_instructirushego";
    public static final String KEY_INSTRUCTION_TIME_RECORD = "time_record";


    SQLiteDatabase sqLiteDatabase;
    Context context;
    DataBaseHelper dataBaseHelper;

    ContentValues contentValues = new ContentValues();

    public DataBaseAdapter(Context context) {
        this.context = context;
    }



    public DataBaseAdapter open() throws SQLException {
        dataBaseHelper = new DataBaseHelper(context);
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        return this;
    }

    public long register(String user, String pass) {
        contentValues.put(KEY_USERNAME, user);
        contentValues.put(KEY_PASSWORD, pass);
        return sqLiteDatabase.insert(DATABASE_TABLE, null, contentValues);
    }

    public boolean Login(String username, String password) throws SQLException {
        Cursor mCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + DATABASE_TABLE + " WHERE " + KEY_USERNAME + "=? AND " + KEY_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public void writeInstData(String data_vydachi_zayavki, String dolzhnost_vidav_zayavku, String rukovod_rabot, String teh_karta, String data_nomer_prikaza, String fio_signal_1, String fio_signal_2, String fio_signal_3, String fio_signal_4, String mesto_km_1, String mesto_pk_1, String mesto_put_1, String mesto_km_2, String mesto_pk_2, String plan_data_rabot, String po_soglasovaniyou, String date1, String data_c_chasov_1, String data_min_1, String date2, String data_c_chasov_2, String data_min_2, String fio_dispetchera, String fio_instructirushego, String time_record) {
        contentValues.put(KEY_INSTRUCTION_DATA_VYDACHI_ZAYAVKI, data_vydachi_zayavki);
        contentValues.put(KEY_INSTRUCTION_DOLZHNOST_VIDAV_ZAYAVKU, dolzhnost_vidav_zayavku);
        contentValues.put(KEY_INSTRUCTION_RUKOVOD_RABOT, rukovod_rabot);
        contentValues.put(KEY_INSTRUCTION_TEH_KARTA, teh_karta);
        contentValues.put(KEY_INSTRUCTION_DATA_NOMER_PRIKAZA, data_nomer_prikaza);
        contentValues.put(KEY_INSTRUCTION_FIO_SIGNAL_1, fio_signal_1);
        contentValues.put(KEY_INSTRUCTION_FIO_SIGNAL_2, fio_signal_2);
        contentValues.put(KEY_INSTRUCTION_FIO_SIGNAL_3, fio_signal_3);
        contentValues.put(KEY_INSTRUCTION_FIO_SIGNAL_4, fio_signal_4);
        contentValues.put(KEY_INSTRUCTION_MEST_KM_1, mesto_km_1);
        contentValues.put(KEY_INSTRUCTION_MESTO_PK_1, mesto_pk_1);
        contentValues.put(KEY_INSTRUCTION_MESTO_PUT_1, mesto_put_1);
        contentValues.put(KEY_INSTRUCTION_MESTO_KM_2, mesto_km_2);
        contentValues.put(KEY_INSTRUCTION_MESTO_PK_2, mesto_pk_2);
        contentValues.put(KEY_INSTRUCTION_PLAN_DATA_RABOT, plan_data_rabot);
        contentValues.put(KEY_INSTRUCTION_PO_SOGLASOVANIYOU, po_soglasovaniyou);
        contentValues.put(KEY_INSTRUCTION_DATE1, date1);
        contentValues.put(KEY_INSTRUCTION_DATA_C_CHASOV_1, data_c_chasov_1);
        contentValues.put(KEY_INSTRUCTION_DATA_MIN_1, data_min_1);
        contentValues.put(KEY_INSTRUCTION_DATE2, date2);
        contentValues.put(KEY_INSTRUCTION_DATA_C_CHASOV_2, data_c_chasov_2);
        contentValues.put(KEY_INSTRUCTION_DATA_MIN_2, data_min_2);
        contentValues.put(KEY_INSTRUCTION_FIO_DISPETCHERA, fio_dispetchera);
        contentValues.put(KEY_INSTRUCTION_FIO_INSTRUCTIRUSHEGO, fio_instructirushego);
        contentValues.put(KEY_INSTRUCTION_TIME_RECORD, time_record);

        sqLiteDatabase.insert(TABLE_INSTRUCTION_NAME, null, contentValues);
    }

    public Cursor getDataForFillListInstructions() {
        return sqLiteDatabase.rawQuery("SELECT " + KEY_INSTRUCTION_ID + ", " + KEY_INSTRUCTION_DATA_VYDACHI_ZAYAVKI + " FROM " + TABLE_INSTRUCTION_NAME, null);
    }

    public ArrayList getDataForInstructionActivity(String _id) {
        ArrayList<String> instruction = new ArrayList<String>();
        instructionActivity = new InstructionActivity();
        String id = _id;
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_INSTRUCTION_NAME + " WHERE _id =" + id, null);
        if (query.moveToFirst()) {
            do {
                String tvOutDataVidachiZayavki = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_VYDACHI_ZAYAVKI));
                instruction.add(tvOutDataVidachiZayavki);
                String tvOutDolzhnVidachiZayavki = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DOLZHNOST_VIDAV_ZAYAVKU));
                instruction.add(tvOutDolzhnVidachiZayavki);
                String tvOutRukRabot = query.getString(query.getColumnIndex(KEY_INSTRUCTION_RUKOVOD_RABOT));
                instruction.add(tvOutRukRabot);
                String tvOutTehKarta = query.getString(query.getColumnIndex(KEY_INSTRUCTION_TEH_KARTA));
                instruction.add(tvOutTehKarta);
                String tvOutDataPrikaz = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_NOMER_PRIKAZA));
                instruction.add(tvOutDataPrikaz);
                String tvOutSignalist1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_SIGNAL_1));
                instruction.add(tvOutSignalist1);
                String tvOutSignalist2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_SIGNAL_2));
                instruction.add(tvOutSignalist2);
                String tvOutSignalist3 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_SIGNAL_3));
                instruction.add(tvOutSignalist3);
                String tvOutSignalist4 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_SIGNAL_4));
                instruction.add(tvOutSignalist4);
                String tvOutMesto_km_1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_MEST_KM_1));
                instruction.add(tvOutMesto_km_1);
                String tvOutMesto_pk_1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_MESTO_PK_1));
                instruction.add(tvOutMesto_pk_1);
                String tvOutMesto_put_1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_MESTO_PUT_1));
                instruction.add(tvOutMesto_put_1);
                String tvOutMesto_km_2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_MESTO_KM_2));
                instruction.add(tvOutMesto_km_2);
                String tvOutMesto_pk_2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_MESTO_PK_2));
                instruction.add(tvOutMesto_pk_2);
                String tvOutDataPlan = query.getString(query.getColumnIndex(KEY_INSTRUCTION_PLAN_DATA_RABOT));
                instruction.add(tvOutDataPlan);
                String tvOutSoglasovanie = query.getString(query.getColumnIndex(KEY_INSTRUCTION_PO_SOGLASOVANIYOU));
                instruction.add(tvOutSoglasovanie);
                String tvOutDate1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATE1));
                instruction.add(tvOutDate1);
                String tvOutData_c_chasov_1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_C_CHASOV_1));
                instruction.add(tvOutData_c_chasov_1);
                String tvOutData_min_1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_MIN_1));
                instruction.add(tvOutData_min_1);
                String tvOutDate2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATE2));
                instruction.add(tvOutDate2);
                String tvOutData_c_chasov_2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_C_CHASOV_2));
                instruction.add(tvOutData_c_chasov_2);
                String tvOutData_min_2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_MIN_2));
                instruction.add(tvOutData_min_2);
                String tvOutFIODispName = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_DISPETCHERA));
                instruction.add(tvOutFIODispName);
                String tvOutFIOInstructName = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_INSTRUCTIRUSHEGO));
                instruction.add(tvOutFIOInstructName);

            } while (query.moveToNext());
        }
        return instruction;
    }

    public ArrayList getDataForUpdate() {
        ArrayList<String> updateServer = new ArrayList<>();
        Cursor query = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_INSTRUCTION_NAME, null);
        if (query.moveToFirst()) {
            do {
                String tvOutDataVidachiZayavki = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_VYDACHI_ZAYAVKI));
                updateServer.add(tvOutDataVidachiZayavki);
                String tvOutDolzhnVidachiZayavki = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DOLZHNOST_VIDAV_ZAYAVKU));
                updateServer.add(tvOutDolzhnVidachiZayavki);
                String tvOutRukRabot = query.getString(query.getColumnIndex(KEY_INSTRUCTION_RUKOVOD_RABOT));
                updateServer.add(tvOutRukRabot);
                String tvOutTehKarta = query.getString(query.getColumnIndex(KEY_INSTRUCTION_TEH_KARTA));
                updateServer.add(tvOutTehKarta);
                String tvOutDataPrikaz = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_NOMER_PRIKAZA));
                updateServer.add(tvOutDataPrikaz);
                String tvOutSignalist1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_SIGNAL_1));
                updateServer.add(tvOutSignalist1);
                String tvOutSignalist2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_SIGNAL_2));
                updateServer.add(tvOutSignalist2);
                String tvOutSignalist3 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_SIGNAL_3));
                updateServer.add(tvOutSignalist3);
                String tvOutSignalist4 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_SIGNAL_4));
                updateServer.add(tvOutSignalist4);
                String tvOutMesto_km_1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_MEST_KM_1));
                updateServer.add(tvOutMesto_km_1);
                String tvOutMesto_pk_1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_MESTO_PK_1));
                updateServer.add(tvOutMesto_pk_1);
                String tvOutMesto_put_1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_MESTO_PUT_1));
                updateServer.add(tvOutMesto_put_1);
                String tvOutMesto_km_2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_MESTO_KM_2));
                updateServer.add(tvOutMesto_km_2);
                String tvOutMesto_pk_2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_MESTO_PK_2));
                updateServer.add(tvOutMesto_pk_2);
                String tvOutDataPlan = query.getString(query.getColumnIndex(KEY_INSTRUCTION_PLAN_DATA_RABOT));
                updateServer.add(tvOutDataPlan);
                String tvOutSoglasovanie = query.getString(query.getColumnIndex(KEY_INSTRUCTION_PO_SOGLASOVANIYOU));
                updateServer.add(tvOutSoglasovanie);
                String tvOutDate1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATE1));
                updateServer.add(tvOutDate1);
                String tvOutData_c_chasov_1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_C_CHASOV_1));
                updateServer.add(tvOutData_c_chasov_1);
                String tvOutData_min_1 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_MIN_1));
                updateServer.add(tvOutData_min_1);
                String tvOutDate2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATE2));
                updateServer.add(tvOutDate2);
                String tvOutData_c_chasov_2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_C_CHASOV_2));
                updateServer.add(tvOutData_c_chasov_2);
                String tvOutData_min_2 = query.getString(query.getColumnIndex(KEY_INSTRUCTION_DATA_MIN_2));
                updateServer.add(tvOutData_min_2);
                String tvOutFIODispName = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_DISPETCHERA));
                updateServer.add(tvOutFIODispName);
                String tvOutFIOInstructName = query.getString(query.getColumnIndex(KEY_INSTRUCTION_FIO_INSTRUCTIRUSHEGO));
                updateServer.add(tvOutFIOInstructName);
                String timeRecord = query.getString(query.getColumnIndex(KEY_INSTRUCTION_TIME_RECORD));
                updateServer.add(timeRecord);

            } while (query.moveToNext());
        }
        return updateServer;
    }

    public void deleteRow(String id) {
        sqLiteDatabase.delete(TABLE_INSTRUCTION_NAME, KEY_INSTRUCTION_ID + "=" +id, null);
    }

    public String checkData(String check_time_record) {
        Cursor query = sqLiteDatabase.rawQuery("SELECT time_record FROM " + TABLE_INSTRUCTION_NAME + " WHERE time_record ='" + check_time_record + "'", null);
        if(query.getCount()>0) {
            return "rowFound";
        }
      return null;
    }
}
