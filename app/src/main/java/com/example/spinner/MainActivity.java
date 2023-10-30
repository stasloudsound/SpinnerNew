package com.example.spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button button;
    boolean[] selected_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button = findViewById(R.id.spinnerClick);
        spinner = findViewById(R.id.spinner);


        String[] items =  {"diamond", "ruby", "sapphire", "topaz ", "emerald"};
        selected_items = new boolean[items.length];
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);



        button.setOnClickListener(view -> {
            spin(items);
        });

    }
    public void spin (String[] items){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter City");
        builder.setMultiChoiceItems(items, selected_items, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                selected_items[i] = b;

            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                StringBuilder selectedItemText = new StringBuilder();
                for (int j = 0; j < items.length; j++) {
                    if(selected_items[j] == true){
                        selectedItemText.append(items[j]);
                        selectedItemText.append(", ");
                    }
                }
                if(selectedItemText.length() > 0) {
                    selectedItemText.setLength(selectedItemText.length() - 2);
                }
                Toast.makeText(MainActivity.this, selectedItemText, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Otmena", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
//class Spinners extends ArrayAdapter <String>{
//
//    public Spinners(@NonNull Context context, int resource, ArrayList<String> textViewResourceId) {
//        super(context, resource, textViewResourceId);
//    }
//
//    @Override
//    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View view = super.getDropDownView(position, convertView, parent);
//
//        if(position == 0){
//            view.setEnabled(false);
//        }
//        return view;
//    }
//}