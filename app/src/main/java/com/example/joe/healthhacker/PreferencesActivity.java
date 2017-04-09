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
public class PreferencesActivity extends AppCompatActivity {

       private ListView listView;
        private ListAdapter listAdapter;
        private List<Item> itemList = new ArrayList<Item>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_preferences);


        }


}
