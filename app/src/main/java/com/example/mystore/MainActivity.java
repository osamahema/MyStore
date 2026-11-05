package com.example.mystore;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        productList = new ArrayList<>();

        productList.add(new Product("Bitzwolf B-CC1 Camera 1080P HD Webcam", "US$48.89", R.drawable.camera1));
        productList.add(new Product("Bitzwolf B-CC1 Camera 1080P HD Webcam", "US$55.89", R.drawable.camera2));
        productList.add(new Product("Bitzwolf B-CC1 Camera 1080P HD Webcam", "US$78.89", R.drawable.camera3));
        productList.add(new Product("Bitzwolf B-CC1 Camera 1080P HD Webcam", "US$88.55", R.drawable.camera4));
        productList.add(new Product("Bitzwolf B-CC1 Camera 1080P HD Webcam", "US$23.67", R.drawable.camera5));
        productList.add(new Product("Bitzwolf B-CC1 Camera 1080P HD Webcam", "US$44.89", R.drawable.camera6));

        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);
    }
}
