package ru.electronim.instruction;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FillDataActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10, spinner11;
    Button btnSendData;
    EditText etMesto_km_1, etMesto_pk_1, etMesto_put_1, etMesto_km_2, etMesto_pk_2, etData_c_chasov_1, etData_min_1, etData_c_chasov_2, etData_min_2;
    int DIALOG_DATE = 1;
    int myYear;
    int myMonth;
    int myDay;

    String data_vydachi_zayavki, dolzhnost_vidav_zayavku, rukovod_rabot, teh_karta, data_nomer_prikaza, fio_signal_1, fio_signal_2, fio_signal_3, fio_signal_4, mesto_km_1, mesto_pk_1, mesto_put_1, mesto_km_2, mesto_pk_2, plan_data_rabot, po_soglasovaniyou, date1, data_c_chasov_1, data_min_1, date2, data_c_chasov_2, data_min_2, fio_dispetchera, fio_instructirushego;

    String proverka_dolzhnost_vidav_zayavku = "Должность выдавшего заявку на \"окно\"";
    String proverka_rukovod_rabot = "Руководитель работ";
    String proverka_teh_karta = "Tex.карта";
    String proverka_data_nomer_prikaza = "Дата, № приказа";
    String proverka_fio_signal_1 = "Выбрать ФИО сигналиста №1";
    String proverka_fio_signal_2 = "Выбрать ФИО сигналиста №2";
    String proverka_fio_signal_3 = "Выбрать ФИО сигналиста №3";
    String proverka_fio_signal_4 = "Выбрать ФИО сигналиста №4";
    String proverka_po_soglasovaniyou = "По согласованию";
    String proverka_fio_dispetchera = "Выбрать ФИО диспетчера";
    String proverka_fio_instructirushego = "Выбрать ФИО инструктирующего";

    TextView tvDataVidachiZayavki, tvDataPlan, tvDate1, tvDate2, tv, tvDate_1, tvDate_2, tvDatePlan;
    DatePickerDialog.OnDateSetListener myCallBack;

    DataBaseAdapter dataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_data);

        dataBaseAdapter = new DataBaseAdapter(this);
        try {
            dataBaseAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
        SimpleDateFormat mm = new SimpleDateFormat("MM");
        SimpleDateFormat dd = new SimpleDateFormat("dd");
        String year = yyyy.format(new Date());
        String month = mm.format(new Date());
        String day = dd.format(new Date());
        myYear = Integer.parseInt(year);
        int mMonth = Integer.parseInt(month);
        myDay = Integer.parseInt(day);
        myMonth= mMonth-1;

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        spinner7 = (Spinner) findViewById(R.id.spinner7);
        spinner8 = (Spinner) findViewById(R.id.spinner8);
        spinner9 = (Spinner) findViewById(R.id.spinner9);
        spinner10 = (Spinner) findViewById(R.id.spinner10);
        spinner11 = (Spinner) findViewById(R.id.spinner11);

        tvDataVidachiZayavki = (TextView) findViewById(R.id.tvDataVidachiZayavki);
        tvDataPlan = (TextView) findViewById(R.id.tvDataPlan);
        tvDate1 = (TextView) findViewById(R.id.tvDate1);
        tvDate2 = (TextView) findViewById(R.id.tvDate2);
        btnSendData = (Button) findViewById(R.id.button);

        etMesto_km_1 = (EditText) findViewById(R.id.etMesto_km_1);
        etMesto_pk_1 = (EditText) findViewById(R.id.etMesto_pk_1);
        etMesto_put_1 = (EditText) findViewById(R.id.etMesto_put_1);
        etMesto_km_2 = (EditText) findViewById(R.id.etMesto_km_2);
        etMesto_pk_2 = (EditText) findViewById(R.id.etMesto_pk_2);
        etData_c_chasov_1 = (EditText) findViewById(R.id.etData_c_chasov_1);
        etData_min_1 = (EditText) findViewById(R.id.etData_min_1);
        etData_c_chasov_2 = (EditText) findViewById(R.id.etData_c_chasov_2);
        etData_min_2 = (EditText) findViewById(R.id.etData_min_2);

        btnSendData.setOnClickListener(this);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.zayavka_na_okno, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.rucovoditel_rabot, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.teh_karta, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.data_prikaz, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.signalist1, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this,
                R.array.signalist2, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this,
                R.array.signalist3, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this,
                R.array.signalist4, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this,
                R.array.soglasovanie, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this,
                R.array.fioDispetcher, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this,
                R.array.fioInstructir, android.R.layout.simple_spinner_item);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);
        spinner4.setAdapter(adapter4);
        spinner5.setAdapter(adapter5);
        spinner6.setAdapter(adapter6);
        spinner7.setAdapter(adapter7);
        spinner8.setAdapter(adapter8);
        spinner9.setAdapter(adapter9);
        spinner10.setAdapter(adapter10);
        spinner11.setAdapter(adapter11);

        tvDataPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDatePlan = tvDataPlan;
                setDate();
                showDialog(DIALOG_DATE);
            }
        });

        tvDataVidachiZayavki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  showDialog(DIALOG_DATE);
                tv=tvDataVidachiZayavki;
                setDate();
                showDialog(DIALOG_DATE);
            }
        });

        tvDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDate_1 = tvDate1;
                setDate();
                showDialog(DIALOG_DATE);
            }
        });

        tvDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDate_2 = tvDate2;
                setDate();
                showDialog(DIALOG_DATE);
            }
        });
    }


    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, myYear, myMonth, myDay);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    public void setDate() {

        myCallBack = new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myYear = year;
                myMonth = monthOfYear;
                myDay = dayOfMonth;
                if(tv != null) {
                    tv.setText("Дата выдачи заявки: " + myDay + "." + myMonth + "." + myYear);
                    data_vydachi_zayavki = myDay + "." + myMonth + "." + myYear;
                    tv=null;
                }
                if(tvDatePlan != null) {
                    tvDatePlan.setText("Планируемая дата проведения работ: " + myDay + "." + myMonth + "." + myYear);
                    plan_data_rabot = myDay + "." + myMonth + "." + myYear;
                    tvDatePlan=null;
                }
                if(tvDate_1 != null) {
                    tvDate_1.setText("Дата: " + myDay + "." + myMonth + "." + myYear);
                    date1 = myDay + "." + myMonth + "." + myYear;
                    tvDate_1=null;
                }
                if(tvDate_2 != null) {
                    tvDate_2.setText("Дата: " + myDay + "." + myMonth + "." + myYear);
                    date2 = myDay + "." + myMonth + "." + myYear;
                    tvDate_2=null;
                }
            }
        };
    }

    public String currentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String time = dateFormat.format(date);
        return time;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                //data_vydachi_zayavki = tvDataVidachiZayavki.getText().toString();
                dolzhnost_vidav_zayavku = spinner.getSelectedItem().toString();
                rukovod_rabot = spinner2.getSelectedItem().toString();
                teh_karta = spinner3.getSelectedItem().toString();
                data_nomer_prikaza = spinner4.getSelectedItem().toString();
                fio_signal_1 = spinner5.getSelectedItem().toString();
                if(fio_signal_1.equals(proverka_fio_signal_1))
                    fio_signal_1="";
                fio_signal_2 = spinner6.getSelectedItem().toString();
                if(fio_signal_2.equals(proverka_fio_signal_2))
                    fio_signal_2="";
                fio_signal_3 = spinner7.getSelectedItem().toString();
                if(fio_signal_3.equals(proverka_fio_signal_3))
                    fio_signal_3="";
                fio_signal_4 = spinner8.getSelectedItem().toString();
                if(fio_signal_4.equals(proverka_fio_signal_4))
                    fio_signal_4="";
                mesto_km_1 = etMesto_km_1.getText().toString();
                mesto_pk_1 = etMesto_pk_1.getText().toString();
                mesto_put_1 = etMesto_put_1.getText().toString();
                mesto_km_2 = etMesto_km_2.getText().toString();
                mesto_pk_2 = etMesto_pk_2.getText().toString();
              //  plan_data_rabot = tvDataPlan.getText().toString();
                po_soglasovaniyou = spinner9.getSelectedItem().toString();
               // date1 = tvDate1.getText().toString();
                data_c_chasov_1 = etData_c_chasov_1.getText().toString();
                data_min_1 = etData_min_1.getText().toString();
               // date2 = tvDate2.getText().toString();
                data_c_chasov_2 = etData_c_chasov_2.getText().toString();
                data_min_2 = etData_min_2.getText().toString();
                fio_dispetchera = spinner10.getSelectedItem().toString();
                fio_instructirushego = spinner11.getSelectedItem().toString();

                dataBaseAdapter.writeInstData(data_vydachi_zayavki, dolzhnost_vidav_zayavku, rukovod_rabot, teh_karta, data_nomer_prikaza, fio_signal_1, fio_signal_2, fio_signal_3, fio_signal_4, mesto_km_1, mesto_pk_1, mesto_put_1, mesto_km_2, mesto_pk_2, plan_data_rabot, po_soglasovaniyou, date1, data_c_chasov_1, data_min_1, date2, data_c_chasov_2, data_min_2, fio_dispetchera, fio_instructirushego, currentTime());

                Intent intent = new Intent(this, ChoiceActivity.class);
                startActivity(intent);
        }
    }
}

