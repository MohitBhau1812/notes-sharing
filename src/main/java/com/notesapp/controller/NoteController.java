package com.notesapp.controller;

import com.notesapp.model.Note;
import com.notesapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NoteController {
    @Autowired
    private NoteService service;

    @GetMapping("/")
    public String home(Model m) {
        m.addAttribute("notes", service.getAllNotes());
        return "index";
    }

    @GetMapping("/upload")
    public String uploadForm(Model m) {
        m.addAttribute("note", new Note());
        return "upload";
    }

    @PostMapping("/upload")
    public String submitNote(@ModelAttribute Note note) {
        service.saveNote(note);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteNote(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String subject, Model m) {
        m.addAttribute("notes", service.searchBySubject(subject));
        return "index";
    }
}