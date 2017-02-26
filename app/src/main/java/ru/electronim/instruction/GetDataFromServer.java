package ru.electronim.instruction;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Tim on 13.06.2016.
 */
public class GetDataFromServer {
    DataBaseAdapter dataBase;

    private JSONArray data = null;
    int anchor=0;

    private static final String JSON_ARRAY ="result";
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
    private static final String JSON_URL = "http://stockcom.ru/";

    protected void getJSON(DataBaseAdapter dataBaseAdapter) {
        dataBase = dataBaseAdapter;
        BufferedReader bufferedReader = null;
        try {

            URL url = new URL(JSON_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();

            bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String json;
            while((json = bufferedReader.readLine())!= null){
                sb.append(json+"\n");
            }

            extractJSON(sb.toString().trim());

        }catch(Exception e){
            // return null;
        }
    }
    private void extractJSON(String myJSONString){
        try {
            JSONObject jsonObject = new JSONObject(myJSONString);
            data = jsonObject.getJSONArray(JSON_ARRAY);

            for (int i = 0; i < data.length(); i++) {
                insertDataToAndroidSql(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void insertDataToAndroidSql(int i) {
        try {
            JSONObject jsonObject = data.getJSONObject(i);
            String time_record_check = jsonObject.getString(KEY_INSTRUCTION_TIME_RECORD);
            if(dataBase.checkData(time_record_check)==null) {
                String data_vydachi_zayavki = jsonObject.getString(KEY_INSTRUCTION_DATA_VYDACHI_ZAYAVKI);
                String dolzhnost_vidav_zayavku = jsonObject.getString(KEY_INSTRUCTION_DOLZHNOST_VIDAV_ZAYAVKU);
                String rukovod_rabot = jsonObject.getString(KEY_INSTRUCTION_RUKOVOD_RABOT);
                String teh_karta = jsonObject.getString(KEY_INSTRUCTION_TEH_KARTA);
                String data_nomer_prikaza = jsonObject.getString(KEY_INSTRUCTION_DATA_NOMER_PRIKAZA);
                String fio_signal_1 = jsonObject.getString(KEY_INSTRUCTION_FIO_SIGNAL_1);
                String fio_signal_2 = jsonObject.getString(KEY_INSTRUCTION_FIO_SIGNAL_2);
                String fio_signal_3 = jsonObject.getString(KEY_INSTRUCTION_FIO_SIGNAL_3);
                String fio_signal_4 = jsonObject.getString(KEY_INSTRUCTION_FIO_SIGNAL_4);
                String mesto_km_1 = jsonObject.getString(KEY_INSTRUCTION_MEST_KM_1);
                String mesto_pk_1 = jsonObject.getString(KEY_INSTRUCTION_MESTO_PK_1);
                String mesto_put_1 = jsonObject.getString(KEY_INSTRUCTION_MESTO_PUT_1);
                String mesto_km_2 = jsonObject.getString(KEY_INSTRUCTION_MESTO_KM_2);
                String mesto_pk_2 = jsonObject.getString(KEY_INSTRUCTION_MESTO_PK_2);
                String plan_data_rabot = jsonObject.getString(KEY_INSTRUCTION_PLAN_DATA_RABOT);
                String po_soglasovaniyou = jsonObject.getString(KEY_INSTRUCTION_PO_SOGLASOVANIYOU);
                String date1 = jsonObject.getString(KEY_INSTRUCTION_DATE1);
                String data_c_chasov_1 = jsonObject.getString(KEY_INSTRUCTION_DATA_C_CHASOV_1);
                String data_min_1 = jsonObject.getString(KEY_INSTRUCTION_DATA_MIN_1);
                String date2 = jsonObject.getString(KEY_INSTRUCTION_DATE2);
                String data_c_chasov_2 = jsonObject.getString(KEY_INSTRUCTION_DATA_C_CHASOV_2);
                String data_min_2 = jsonObject.getString(KEY_INSTRUCTION_DATA_MIN_2);
                String fio_dispetchera = jsonObject.getString(KEY_INSTRUCTION_FIO_DISPETCHERA);
                String fio_instructirushego = jsonObject.getString(KEY_INSTRUCTION_FIO_INSTRUCTIRUSHEGO);
                String time_record = jsonObject.getString(KEY_INSTRUCTION_TIME_RECORD);

                dataBase.writeInstData(data_vydachi_zayavki, dolzhnost_vidav_zayavku, rukovod_rabot, teh_karta, data_nomer_prikaza, fio_signal_1, fio_signal_2, fio_signal_3, fio_signal_4, mesto_km_1, mesto_pk_1, mesto_put_1, mesto_km_2, mesto_pk_2, plan_data_rabot, po_soglasovaniyou, date1, data_c_chasov_1, data_min_1, date2, data_c_chasov_2, data_min_2, fio_dispetchera, fio_instructirushego, time_record);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}