package ru.electronim.instruction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.ArrayList;

public class InstructionActivity extends AppCompatActivity {

    int position = 0;
    String id;
    DataBaseAdapter dataBaseAdapter;
    TextView tvOutDataVidachiZayavki, tvOutDolzhnVidachiZayavki, tvOutRukRabot, tvOutTehKarta, tvOutDataPrikaz, tvOutSignalist1, tvOutSignalist2, tvOutSignalist3, tvOutSignalist4, tvOutMesto_km_1, tvOutMesto_pk_1, tvOutMesto_put_1, tvOutMesto_km_2, tvOutMesto_pk_2, tvOutDataPlan, tvOutSoglasovanie, tvOutDate1, tvOutData_c_chasov_1, tvOutData_min_1, tvOutDate2, tvOutData_c_chasov_2, tvOutData_min_2, tvOutFIODispName, tvOutFIOInstructName;
    Button btOutBack, btDelete;

    ArrayList<String> instruction = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", position);
        id = String.valueOf(position);

        dataBaseAdapter = new DataBaseAdapter(this);
        try {
            dataBaseAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tvOutDataVidachiZayavki = (TextView) findViewById(R.id.tvOutDataVidachiZayavki);
        tvOutDolzhnVidachiZayavki = (TextView) findViewById(R.id.tvOutDolzhnVidachiZayavki);
        tvOutRukRabot = (TextView) findViewById(R.id.tvOutRukRabot);
        tvOutTehKarta = (TextView) findViewById(R.id.tvOutTehKarta);
        tvOutDataPrikaz = (TextView) findViewById(R.id.tvOutDataPrikaz);
        tvOutSignalist1 = (TextView) findViewById(R.id.tvOutSignalist1);
        tvOutSignalist2 = (TextView) findViewById(R.id.tvOutSignalist2);
        tvOutSignalist3 = (TextView) findViewById(R.id.tvOutSignalist3);
        tvOutSignalist4 = (TextView) findViewById(R.id.tvOutSignalist4);
        tvOutMesto_km_1 = (TextView) findViewById(R.id.tvOutMesto_km_1);
        tvOutMesto_pk_1 = (TextView) findViewById(R.id.tvOutMesto_pk_1);
        tvOutMesto_put_1 = (TextView) findViewById(R.id.tvOutMesto_put_1);
        tvOutMesto_km_2 = (TextView) findViewById(R.id.tvOutMesto_km_2);
        tvOutMesto_pk_2 = (TextView) findViewById(R.id.tvOutMesto_pk_2);
        tvOutDataPlan = (TextView) findViewById(R.id.tvOutDataPlan);
        tvOutSoglasovanie = (TextView) findViewById(R.id.tvOutSoglasovanie);
        tvOutDate1 = (TextView) findViewById(R.id.tvOutDate1);
        tvOutData_c_chasov_1 = (TextView) findViewById(R.id.tvOutData_c_chasov_1);
        tvOutData_min_1 = (TextView) findViewById(R.id.tvOutData_min_1);
        tvOutDate2 = (TextView) findViewById(R.id.tvOutDate2);
        tvOutData_c_chasov_2 = (TextView) findViewById(R.id.tvOutData_c_chasov_2);
        tvOutData_min_2 = (TextView) findViewById(R.id.tvOutData_min_2);
        tvOutFIODispName = (TextView) findViewById(R.id.tvOutFIODispName);
        tvOutFIOInstructName = (TextView) findViewById(R.id.tvOutFIOInstructName);

        btOutBack = (Button) findViewById(R.id.btOutBack);
        btDelete = (Button) findViewById(R.id.btDelete);
        btOutBack.setOnClickListener(listener);
        btDelete.setOnClickListener(listener);

        display();
    }

    public void display() {
        instruction = dataBaseAdapter.getDataForInstructionActivity(id);
        tvOutDataVidachiZayavki.setText(instruction.get(0));
        tvOutDolzhnVidachiZayavki.setText(instruction.get(1));
        tvOutRukRabot.setText(instruction.get(2));
        tvOutTehKarta.setText(instruction.get(3));
        tvOutDataPrikaz.setText(instruction.get(4));
        tvOutSignalist1.setText(instruction.get(5));
        tvOutSignalist2.setText(instruction.get(6));
        tvOutSignalist3.setText(instruction.get(7));
        tvOutSignalist4.setText(instruction.get(8));
        tvOutMesto_km_1.setText(instruction.get(9));
        tvOutMesto_pk_1.setText(instruction.get(10));
        tvOutMesto_put_1.setText(instruction.get(11));
        tvOutMesto_km_2.setText(instruction.get(12));
        tvOutMesto_pk_2.setText(instruction.get(13));
        tvOutDataPlan.setText(instruction.get(14));
        tvOutSoglasovanie.setText(instruction.get(15));
        tvOutDate1.setText(instruction.get(16));
        tvOutData_c_chasov_1.setText(instruction.get(17));
        tvOutData_min_1.setText(instruction.get(18));
        tvOutDate2.setText(instruction.get(19));
        tvOutData_c_chasov_2.setText(instruction.get(20));
        tvOutData_min_2.setText(instruction.get(21));
        tvOutFIODispName.setText(instruction.get(22));
        tvOutFIOInstructName.setText(instruction.get(23));
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btOutBack:
                    Intent intent1 = new Intent(InstructionActivity.this, ChoiceActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.btDelete:
                    dataBaseAdapter.deleteRow(id);
                    Intent intent2 = new Intent(InstructionActivity.this, ChoiceActivity.class);
                    startActivity(intent2);
                    break;
            }
        }
    };
}
