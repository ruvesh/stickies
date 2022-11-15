package io.github.ruvesh.stickies.service.impl;

import io.github.ruvesh.stickies.model.Note;
import io.github.ruvesh.stickies.repository.NoteRepository;
import io.github.ruvesh.stickies.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<Note> getNotesByUser(String userName) {
        return noteRepository.findAllByUserName(userName);
    }

    @Override
    public void saveNoteByUser(String content, String user) {
        Note note = new Note();
        note.setUserName(user);
        note.setContent(content);
        noteRepository.save(note);
    }

    @Override
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void editNote(Long id, String newContent) {
        Optional<Note> existingNoteOptional = noteRepository.findById(id);
        if(existingNoteOptional.isPresent()) {
            Note existingNote = existingNoteOptional.get();
            existingNote.setContent(newContent);
            noteRepository.save(existingNote);
        }
    }

    @Override
    public Note getNoteById(Long id) {
        Optional<Note> noteOptional = noteRepository.findById(id);

        return noteOptional.isPresent() ? noteOptional.get() : new Note();
    }
}
