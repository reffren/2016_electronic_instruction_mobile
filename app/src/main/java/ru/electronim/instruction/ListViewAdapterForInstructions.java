package ru.electronim.instruction;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tim on 16.06.2016.
 */
public class ListViewAdapterForInstructions extends CursorAdapter {

    ArrayList<Integer> arrayListID = new ArrayList<Integer>();
    TextView nameOfInstruction;

    public ListViewAdapterForInstructions(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fill_for_all_instructions, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        nameOfInstruction = (TextView) view.findViewById(R.id.tvNameOfInstruction);

        final String nameOfInstr = cursor.getString(cursor.getColumnIndex("data_vydachi_zayavki"));

        nameOfInstruction.setText(nameOfInstr);
    }
}
