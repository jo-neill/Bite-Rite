package com.example.joe.healthhacker;
import android.os.Bundle;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.joe.healthhacker.Utility.Product;
import com.example.joe.healthhacker.Service.NutritionService;
import com.example.joe.healthhacker.Service.NutritionServiceCallBack;
import android.widget.EditText;
import com.example.joe.healthhacker.Utility.Score;
public class MainActivity extends AppCompatActivity implements NutritionServiceCallBack{

    private NutritionService service;
    private Product product;
    static MainActivity activityA;

    private Score appScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityA = this;

        final Button button = (Button) findViewById(R.id.buttonSearchUPC);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                runService();
            }
        });

    }

    public static MainActivity getInstance(){
        return activityA;
    }

    public void runService(){
        EditText et=(EditText)findViewById(R.id.upc_text);
        String upc = et.getText().toString();
        service = new NutritionService(this);
        service.refreshNutrition(upc);
        appScore = new Score();
    }

    public void serviceSuccess(String[] itemInfo) {

        String itemName = itemInfo[0];
        String itemDesc = itemInfo[1];
        String ingredients = itemInfo[2];

        product = new Product(itemName, itemDesc, ingredients);
        Log.d(itemName, itemDesc);
        appScore.refreshScore(product);

        launchActivity();
    }

    public Product getProduct(){
        return product;
    }

    public Score getScore(){
        return appScore;
    }

    private void launchActivity() {

        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    public void serviceFailure(Exception exception) {
        //Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}
