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
import android.widget.CheckBox;

import com.example.joe.healthhacker.Utility.Restriction;
import com.example.joe.healthhacker.Utility.Score;

import java.util.ArrayList;
import java.util.List;

public class PreferencesActivity extends AppCompatActivity {

        private ListView listView;
        private ListAdapter listAdapter;
        private List<Item> itemList = new ArrayList<Item>();
        private Score editScore;
        private static ArrayList<Restriction> editRestrictions;

        static PreferencesActivity activityB;

        Spinner spinner1, spinner2, spinner3, spinner4, spinner5;
        ArrayAdapter adapter1, adapter2, adapter3, adapter4, adapter5;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_preferences);
            activityB = this;
            editScore = MainActivity.getInstance().getScore();

            spinner1= (Spinner) findViewById(R.id.spinner1);
            adapter1 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner1.setAdapter(adapter1);

            spinner2 = (Spinner) findViewById(R.id.spinner2);
            adapter2 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapter2);

            spinner3 = (Spinner) findViewById(R.id.spinner3);
            adapter3 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner3.setAdapter(adapter3);

            spinner4 = (Spinner) findViewById(R.id.spinner4);
            adapter4 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
            adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner4.setAdapter(adapter4);

            spinner5 = (Spinner) findViewById(R.id.spinner5);
            adapter5 = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);
            adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner5.setAdapter(adapter5);


            final Button button = (Button) findViewById(R.id.saveButton);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    saveChanges();
                }
            });

        }

    private void saveChanges() {
        editRestrictions = editScore.getRestrictions();

        //Card 1
        editRestrictions.get(0).setDesirability(spinner1.getSelectedItem().toString());
        editRestrictions.get(0).changeStatus(((CheckBox) findViewById(R.id.checkBox1)).isChecked());

        //Card 2
        editRestrictions.get(1).setDesirability(spinner2.getSelectedItem().toString());
        editRestrictions.get(1).changeStatus(((CheckBox) findViewById(R.id.checkBox2)).isChecked());

        //Card 3
        editRestrictions.get(2).setDesirability(spinner3.getSelectedItem().toString());
        editRestrictions.get(2).changeStatus(((CheckBox) findViewById(R.id.checkBox3)).isChecked());

        //Card 4
        editRestrictions.get(3).setDesirability(spinner4.getSelectedItem().toString());
        editRestrictions.get(3).changeStatus(((CheckBox) findViewById(R.id.checkBox4)).isChecked());

        //Card 5
        editRestrictions.get(4).setDesirability(spinner5.getSelectedItem().toString());
        editRestrictions.get(4).changeStatus(((CheckBox) findViewById(R.id.checkBox5)).isChecked());
    }

    public ArrayList<Restriction> getRestrictions() {
        //activityA.restrictions = editRestrictions;
        return editRestrictions;
    }

    public static PreferencesActivity getInstance(){
        return activityB;
    }


}
