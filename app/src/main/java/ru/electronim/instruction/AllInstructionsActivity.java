package ru.electronim.instruction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.ArrayList;

public class AllInstructionsActivity extends AppCompatActivity {

    DataBaseAdapter dataBaseAdapter;
    private ListView listForAllInstructions;
    ListViewAdapterForInstructions adapter;
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_instructions);

        listForAllInstructions = (ListView) findViewById(R.id.ListOfInstructions);

        dataBaseAdapter = new DataBaseAdapter(this);
        try {
            dataBaseAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        displayResultList();

        listForAllInstructions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int _id = (int) id;

                Intent intent = new Intent(AllInstructionsActivity.this, InstructionActivity.class);
                intent.putExtra("position", _id);
                startActivity(intent);
                finish();
            }
        });
    }

    private void displayResultList() {
        adapter = new ListViewAdapterForInstructions(this, dataBaseAdapter.getDataForFillListInstructions(),0);
        listForAllInstructions.setAdapter(adapter);
    }
}

