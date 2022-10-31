package com.example.congress_front;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

import com.example.congress_front.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    DrawerLayout drawerLayout;
    View drawerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.search1.bringToFront();
        binding.search2.bringToFront();
        binding.searchText.bringToFront();
        binding.location.bringToFront();

        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        drawerView = (View)findViewById(R.id.drawer);

        binding.menuBar.setOnClickListener(view -> drawerLayout.openDrawer(drawerView));

    }

}

