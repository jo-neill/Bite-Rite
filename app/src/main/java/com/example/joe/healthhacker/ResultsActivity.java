package com.example.joe.healthhacker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.joe.healthhacker.Utility.Score;
import com.example.joe.healthhacker.Utility.Product;
import android.icu.text.DecimalFormat;
public class ResultsActivity extends AppCompatActivity {

    public String nameTxt, scoreTxt, badTxt, fineTxt;
    DecimalFormat formatter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        formatter = new DecimalFormat("#0.0");

        Product prod = MainActivity.getInstance().getProduct();
        Score scoreIn = MainActivity.getInstance().getScore();

        nameTxt = prod.getName();
        fineTxt = prod.getIngredients();
        scoreTxt = scoreIn.getScore();

        double scoreTxtNum = Double.valueOf(scoreTxt);
        formatter.format(scoreTxtNum);

        scoreTxt = Double.toString(scoreTxtNum);
        badTxt = scoreIn.getBadIngredients();

        final TextView name = (TextView) findViewById(R.id.textName);
        name.setText(nameTxt);

        final TextView score = (TextView) findViewById(R.id.textScore);
        score.setText(scoreTxt);

        final TextView bad = (TextView) findViewById(R.id.textBad);
        bad.setText(badTxt);

        final TextView fine = (TextView) findViewById(R.id.textFine);
        fine.setText(fineTxt);

    }
}
