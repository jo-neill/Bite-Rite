package com.example.joe.healthhacker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.content.ClipData.Item;
import java.util.ArrayList;
import java.util.List;
import android.widget.ListAdapter;
import android.widget.Spinner;
public class PreferencesActivity extends AppCompatActivity {

        private List<Item> itemList = new ArrayList<Item>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_preferences);

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


}
