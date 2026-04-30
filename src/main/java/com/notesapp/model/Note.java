package com.notesapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subject;
    private String uploader;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String s) {
        this.subject = s;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String u) {
        this.uploader = u;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String c) {
        this.content = c;
    }
}