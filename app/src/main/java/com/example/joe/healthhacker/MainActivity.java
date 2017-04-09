package com.example.joe.healthhacker;
import android.os.Bundle;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.example.joe.healthhacker.data.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import com.example.joe.healthhacker.Utility.Product;
import com.example.joe.healthhacker.Service.NutritionService;
import com.example.joe.healthhacker.Service.NutritionServiceCallBack;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements NutritionServiceCallBack{

    private NutritionService service;
    private Product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        final Button button = (Button) findViewById(R.id.buttonSearchUPC);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                runService();
            }
        });

    }

    public void runService(){
        EditText et=(EditText)findViewById(R.id.upc_text);
        String upc = et.getText().toString();
        service = new NutritionService(this);
        service.refreshNutrition(upc);
    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
    public void serviceSuccess(String[] itemInfo) {

        String itemName = itemInfo[0];
        String itemDesc = itemInfo[1];
        String ingredients = itemInfo[2];

        product = new Product(itemName, itemDesc, ingredients);
        Log.d(itemName, itemDesc);
    }

    public Product getProduct(){
        return product;
    }

    public void serviceFailure(Exception exception) {
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
