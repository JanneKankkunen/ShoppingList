package com.example.shoppinglist_jannekankkunen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowList extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);

        textView = findViewById(R.id.textView);
        ArrayList<String> shoppingList = (ArrayList<String>) getIntent().getSerializableExtra("shoppingList");
        textView.setText(String.valueOf(shoppingList));

        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
  //              showMain();
                
                /*finish() aiheuttaa ShowListissä sen että ensimmäisellä painalluksella lista näkyy tyhjänä (null) ja
                vasta toisella painalluksella palataan etusivulle. Ostoslista jää kuitenkin muistiin ja siihen voi täydentää,
                tai/ja palata uudestaan.

                showMain palauttaa kerralla etusivulle, mutta lista häviää.

                Mielestäni listan säilyvyys ja muokattavuus on parempi vaihtoehto.
                * */

            }
        });
    }
    /*public void showMain()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
*/
}
