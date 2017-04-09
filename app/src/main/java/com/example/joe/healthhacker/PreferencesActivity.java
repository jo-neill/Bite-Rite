package com.example.joe.healthhacker;

import android.content.ClipData.Item;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

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
        }

        private void saveChanges() {
            ArrayList<Restriction> editRestrictions = editScore.getRestrictions();


        }


}
