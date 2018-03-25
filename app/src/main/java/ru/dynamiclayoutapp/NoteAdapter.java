package ru.dynamiclayoutapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class NoteAdapter extends ArrayAdapter<String> {

    Context context;
    List<Note> noteList;

    public NoteAdapter(Context context, List<Note> noteList) {
        super(context, R.layout.note_item);
        this.context = context;
        this.noteList = noteList;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {
            view = inflater.inflate(R.layout.note_item, parent, false);
            holder.tvInfo = (TextView) view.findViewById(R.id.tvInfo);
            holder.tvCreated = (TextView) view.findViewById(R.id.tvCreated);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Note note = noteList.get(position);
        holder.tvInfo.setText(note.Info);
        //DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        DateFormat dateFormat = DateFormat.getDateInstance(SimpleDateFormat.LONG, new Locale("ru"));
        holder.tvCreated.setText(dateFormat.format(note.Created));

        return view;
    }

    static class ViewHolder {
        TextView tvInfo;
        TextView tvCreated;
    }
}

