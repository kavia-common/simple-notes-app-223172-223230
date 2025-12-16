package com.example.notesbackend.repository;

import com.example.notesbackend.model.Note;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for Note data access. Implemented in-memory for now.
 */
public interface NoteRepository {
    // PUBLIC_INTERFACE
    Note save(Note note);
    // PUBLIC_INTERFACE
    Optional<Note> findById(UUID id);
    // PUBLIC_INTERFACE
    List<Note> findAll();
    // PUBLIC_INTERFACE
    void deleteById(UUID id);
    // PUBLIC_INTERFACE
    boolean existsById(UUID id);
}
