package ru.dynamiclayoutapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 24.03.2018.
 */

public class NoteList {
    public List<Note> getNoteList(int count, String prefix) {
        List<Note> notes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Note note = new Note();
            note.Info = String.format("Note %s.%d", prefix, i);
            note.Created = new Date();
            notes.add(note);
        }
        return notes;
    }
}
