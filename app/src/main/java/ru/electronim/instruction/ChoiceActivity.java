package ru.electronim.instruction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.sql.SQLException;

public class ChoiceActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCreateInstr, btnMyInstr, btnMySync;
    ProgressDialog dialog;
    DataBaseAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        adapter = new DataBaseAdapter(this);
        try {
            adapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        btnCreateInstr = (Button) findViewById(R.id.btnCreateInstr);
        btnMyInstr = (Button) findViewById(R.id.btnMyInstr);
        btnMySync = (Button) findViewById(R.id.btnSync);

        btnCreateInstr.setOnClickListener(this);
        btnMyInstr.setOnClickListener(this);
        btnMySync.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreateInstr:
                Intent intentCreateInstr = new Intent(this, FillDataActivity.class);
                startActivity(intentCreateInstr);
                break;
            case R.id.btnMyInstr:
                Intent intentAllInstructions = new Intent(this, AllInstructionsActivity.class);
                startActivity(intentAllInstructions);
                break;
            case R.id.btnSync:
                dialog = ProgressDialog.show(ChoiceActivity.this, "", "Синхронизация с сервером...", true);
                new Thread(new Runnable() {
                    SendDataToServer sendDataToServer = new SendDataToServer();
                    GetDataFromServer getData = new GetDataFromServer();

                    public void run() {
                        try {
                            sendDataToServer.sendData(adapter);
                           // getData.getJSON(adapter);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        getData.getJSON(adapter);
                    }

                }).start();
                dialog.dismiss();
                break;
        }
    }
}
