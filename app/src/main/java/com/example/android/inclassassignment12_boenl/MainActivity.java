package com.example.android.inclassassignment12_boenl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Random;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Info> itemList;
    private MyAdapter adapter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);


        recyclerView= (RecyclerView) findViewById(R.id.my_recycler_view);

        initItemData();
        adapter=new MyAdapter(itemList,MainActivity.this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initItemData() {
        itemList = new ArrayList<>();
        itemList.add(new Info("Almond information",
                "A 1 ounce (28 grams, or small handful) serving of almonds contains:\n" +
                "Fiber: 3.5 grams.\n" +
                "Protein: 6 grams.\n" +
                "Fat: 14 grams (9 of which are monounsaturated).\n" +
                "Vitamin E: 37% of the RDA.\n" +
                "Manganese: 32% of the RDA.\n" +
                "•Magnesium: 20% of the RDA.\n",
                R.drawable.almonds));
        itemList.add(new Info("Avocado information","a single 3.5 ounce (100 gram) serving:\n" +
                "Vitamin K: 26% of the RDA.\n" +
                "Folate: 20% of the RDA.\n" +
                "Vitamin C: 17% of the RDA.\n" +
                "Potassium: 14% of the RDA.\n" +
                "Vitamin B5: 14% of the RDA.\n" +
                "Vitamin B6: 13% of the RDA.\n" +
                "Vitamin E: 10% of the RDA.\n",R.drawable.avocado));
        itemList.add(new Info("Banana information","One medium-sized banana (118 grams) \n" +
                "Potassium: 9% of the RDI.\n" +
                "Vitamin B6: 33% of the RDI.\n" +
                "Vitamin C: 11% of the RDI.\n" +
                "Magnesium: 8% of the RDI.\n" +
                "Copper: 10% of the RDI.\n" +
                "Manganese: 14% of the RDI.\n" +
                "Net carbs: 24 grams.\n" +
                "Fiber: 3.1 grams.\n" +
                "Protein: 1.3 grams.\n" +
                "Fat: 0.4 grams.\n",R.drawable.bananas));
        itemList.add(new Info("Egg information","A single large boiled egg contains (1):\n" +
                "Vitamin A: 6% of the RDA.\n" +
                "Folate: 5% of the RDA.\n" +
                "Vitamin B5: 7% of the RDA.\n" +
                "Vitamin B12: 9% of the RDA.\n" +
                "Vitamin B2: 15% of the RDA.\n" +
                "Phosphorus: 9% of the RDA.\n" +
                "Selenium: 22% of the RDA.\n",R.drawable.egg));
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add:
                itemList.add(itemList.get(new Random().nextInt(itemList.size())));
                adapter.notifyItemInserted(itemList.size() - 1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
