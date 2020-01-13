package com.example.shoppinglist_jannekankkunen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button buttonDone;
    final ArrayList<String> shoppingList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText shoplist = (EditText) findViewById(R.id.editShopText);
                if (shoplist.getText().toString().length() <= 2 || shoplist.getText().toString().length() >= 15)
                    Toast.makeText(MainActivity.this, "VIRHE!!! Tekstin pituus pitää olla yli 3 ja alle 15 merkkiä.",
                            Toast.LENGTH_LONG).show();
                else
                    shoppingList.add(shoplist.getText().toString() + "\n");
                Toast.makeText(MainActivity.this, (shoplist.getText().toString() + " lisätty listalle"),
                        Toast.LENGTH_LONG).show();
                shoplist.getText().clear();
            }

        });
        buttonDone = (Button) findViewById(R.id.buttonDone);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShowList();
                Intent myIntent = new Intent(MainActivity.this, ShowList.class);
                myIntent.putExtra("shoppingList", shoppingList);
                startActivity(myIntent);
            }
        });
    }
        public void openShowList() {
            Intent intent = new Intent(this, ShowList.class);
            startActivity(intent);
        }
    }



