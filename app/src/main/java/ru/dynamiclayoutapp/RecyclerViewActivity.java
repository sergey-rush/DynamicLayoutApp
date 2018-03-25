package ru.dynamiclayoutapp;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private Context context;
    private LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        context = getApplicationContext();
        llMain = (LinearLayout)findViewById(R.id.llMain);

        BottomNavigationView bottomNavigationAppView = (BottomNavigationView)findViewById(R.id.bottomNavigationAppView);
        bottomNavigationAppView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.action_run1:
                        runLayoutAnimation1();
                        break;
                    case R.id.action_run2:
                        runLayoutAnimation2();
                        break;
                    case R.id.action_run3:
                        runLayoutAnimation3();
                        break;
                    case R.id.action_select:
                        onSelectColumn();
                        break;
                    case R.id.action_create:
                        onCreateLayout();
                        break;
                }

                return true;
            }
        });
    }

    private void runLayoutAnimation1() {
        RecyclerView recyclerView = (RecyclerView)findViewById(3);
        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    private void runLayoutAnimation2() {
        RecyclerView recyclerView = (RecyclerView)findViewById(3);
        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_bottom);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    private void runLayoutAnimation3() {
        RecyclerView recyclerView = (RecyclerView)findViewById(3);
        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_right);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    private void onSelectColumn(){
        RecyclerView recyclerView = (RecyclerView)findViewById(3);
        recyclerView.setBackgroundColor(getResources().getColor(R.color.colorAccent));

        recyclerView.scrollToPosition(15);
        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_bottom);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    private void onCreateLayout(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        int singleWidth = width/5;
        createLayout(5, singleWidth);
    }

    private void createLayout(int count, int width){

        for (int i = 0; i < count; i++) {
            RecyclerView recyclerView = new RecyclerView(context);
            recyclerView.setId(i);
            //recyclerView.setHasFixedSize(true);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setLayoutParams(new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT));
            //layoutManager.setAutoMeasureEnabled(true);
            int resId = R.anim.layout_animation_fall_down;
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context, resId);
            recyclerView.setLayoutAnimation(animation);


            recyclerView.addItemDecoration(new DividerItemDecoration(context, LinearLayoutManager.VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            ProductList productList = new ProductList();
            List<Product> products = productList.getProductList(100, String.valueOf(i));
            ProductAdapter adapter = new ProductAdapter(products);
            recyclerView.setAdapter(adapter);
            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(context, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                TextView tvName = (TextView)view.findViewById(R.id.tvName);
                Toast.makeText(context, tvName.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
            llMain.addView(recyclerView, i);
        }
    }
}
