package ru.dynamiclayoutapp;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class ListViewActivity extends AppCompatActivity {
private Context context;
private LinearLayout llMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        context = getApplicationContext();
         llMain = (LinearLayout)findViewById(R.id.llMain);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        int singleWidth = width/5;

        createLayout(5, singleWidth);

        ListView listView = (ListView)findViewById(3);
        listView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
    }

    private void createLayout(int count, int width){
        for (int i = 0; i < count; i++) {
            NoteList noteList = new NoteList();
            List notes = noteList.getNoteList(100, "1");
            NoteAdapter adapter = new NoteAdapter(context, notes);
            ListView listView = new ListView(context);
            listView.setId(i);
            listView.setLayoutParams(new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT));
            listView.setAdapter(adapter);
            llMain.addView(listView, i);
        }
    }
}
