package com.example.dialogboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private MaterialAlertDialogBuilder dialogBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogBox = new MaterialAlertDialogBuilder(this);
    }

    public void showAlertDialogButtonClicked(View view) {

        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Name");

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.custom_layout, null);

        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // send data from the
                                // AlertDialog to the Activity
                                EditText editText = customLayout.findViewById(R.id.editTextTextPersonName);

                                sendDialogDataToActivity(editText.getText().toString());


                            }
                        });

        // create and show
        // the alert dialog
        AlertDialog dialog = builder.create();

        dialog.show();
    }

    private void sendDialogDataToActivity(String toString) {

        Toast.makeText(this, "Name "+toString, Toast.LENGTH_SHORT).show();
    }

    public void onBtnNormalDialogBox(View view) {

        dialogBox.setTitle("Title Name");

        dialogBox.setMessage("Message");

        dialogBox.setCancelable(false);

        dialogBox.setIcon(R.drawable.ic_android_black_24dp);

        dialogBox.setView(getLayoutInflater().inflate(R.layout.custom_layout, null));


        dialogBox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
            }
        });

        dialogBox.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Neutral", Toast.LENGTH_SHORT).show();
            }
        });

        dialogBox.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });


        dialogBox.show();


    }

    public void onBtnItemsShow(View view) {

        String[] items = new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};


        dialogBox.setTitle("List Of Items");

        dialogBox.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "Choice Item Is " + items[i], Toast.LENGTH_SHORT).show();
            }
        }).show();

    }

    public void onBtnSelectebleItems(View view) {

        String[] items = new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

        boolean[] itemsResults = new boolean[]{true, false, false, false, false};

        dialogBox.setTitle("Selecteble Items");

        dialogBox.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "Choice Item Is " + items[i], Toast.LENGTH_SHORT).show();

            }
        });

        dialogBox.setMultiChoiceItems(items, itemsResults, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {


                Toast.makeText(MainActivity.this, "( Multiple Choice ) Item Is " + items[i], Toast.LENGTH_SHORT).show();


            }
        });

        dialogBox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();

            }
        });

        dialogBox.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "Neutral", Toast.LENGTH_SHORT).show();

            }
        });

        dialogBox.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();

            }
        });

        dialogBox.show();

    }

}