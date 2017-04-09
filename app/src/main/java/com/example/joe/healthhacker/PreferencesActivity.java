package com.example.joe.healthhacker;

import android.content.ClipData.Item;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.joe.healthhacker.Utility.Restriction;
import com.example.joe.healthhacker.Utility.Score;

import java.util.ArrayList;
import java.util.List;
public class PreferencesActivity extends AppCompatActivity {

        private ListView listView;
        private ListAdapter listAdapter;
        private List<Item> itemList = new ArrayList<Item>();
        private Score editScore;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_preferences);
            editScore = MainActivity.getInstance().getScore();

            final Button button = (Button) findViewById(R.id.saveButton);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    saveChanges();
                }
            });

            Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
            Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
            Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
            ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
            Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
            ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
            Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
            ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
        }

        private void saveChanges() {
            ArrayList<Restriction> editRestrictions = editScore.getRestrictions();


        }


}
