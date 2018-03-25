package ru.dynamiclayoutapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        Button btnListView = (Button)findViewById(R.id.btnListView);
        btnListView.setOnClickListener(this);
        Button btnRecyclerView = (Button)findViewById(R.id.btnRecyclerView);
        btnRecyclerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnListView:
                onOpenDynamicListView(view);
                break;
            case R.id.btnRecyclerView:
                onOpenRecyclerView(view);
                break;
        }
    }

    private void onOpenDynamicListView(View view) {
        Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
        startActivity(intent);
    }

    private void onOpenRecyclerView(View view) {
        Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
        startActivity(intent);
    }
}
