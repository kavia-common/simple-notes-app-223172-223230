package com.example.notesbackend.service;

import com.example.notesbackend.dto.NoteCreateRequest;
import com.example.notesbackend.dto.NoteUpdateRequest;
import com.example.notesbackend.exception.NotFoundException;
import com.example.notesbackend.model.Note;
import com.example.notesbackend.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * Service encapsulating business logic for Notes.
 */
@Service
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    // PUBLIC_INTERFACE
    public Note create(NoteCreateRequest req) {
        /** Create a new Note and persist it. */
        Note note = Note.createNew(req.getTitle().trim(), req.getContent());
        return repository.save(note);
    }

    // PUBLIC_INTERFACE
    public List<Note> getAll() {
        /** Retrieve all notes. */
        return repository.findAll();
    }

    // PUBLIC_INTERFACE
    public Note getById(UUID id) {
        /** Retrieve a note by ID or throw NotFoundException. */
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Note not found: " + id));
    }

    // PUBLIC_INTERFACE
    public Note update(UUID id, NoteUpdateRequest req) {
        /** Update a note by ID with new title/content. */
        Note existing = repository.findById(id).orElseThrow(() -> new NotFoundException("Note not found: " + id));
        existing.setTitle(req.getTitle().trim());
        existing.setContent(req.getContent());
        existing.setUpdatedAt(Instant.now());
        return repository.save(existing);
    }

    // PUBLIC_INTERFACE
    public void delete(UUID id) {
        /** Delete a note by ID or throw NotFoundException if missing. */
        if (!repository.existsById(id)) {
            throw new NotFoundException("Note not found: " + id);
        }
        repository.deleteById(id);
    }
}
