package io.github.ruvesh.stickies.service;

import io.github.ruvesh.stickies.model.Note;

import java.util.List;

public interface NoteService {

    List<Note> getNotesByUser(String user);

    void saveNoteByUser(String content, String user);

    void deleteNoteById(Long id);

    void editNote(Long id, String newContent);

    Note getNoteById(Long id);
}
