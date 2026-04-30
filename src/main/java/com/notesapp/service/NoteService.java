package com.notesapp.service;

import com.notesapp.model.Note;
import com.notesapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository repo;

    public List<Note> getAllNotes() {
        return repo.findAll();
    }

    public Note saveNote(Note n) {
        return repo.save(n);
    }

    public void deleteNote(Long id) {
        repo.deleteById(id);
    }

    public List<Note> searchBySubject(String s) {
        return repo.findBySubjectContainingIgnoreCase(s);
    }
}