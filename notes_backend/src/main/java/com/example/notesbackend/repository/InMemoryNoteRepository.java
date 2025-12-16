package com.example.notesbackend.repository;

import com.example.notesbackend.model.Note;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory Note repository, suitable for development and preview environments.
 */
@Repository
public class InMemoryNoteRepository implements NoteRepository {

    private final Map<UUID, Note> store = new ConcurrentHashMap<>();

    @Override
    public Note save(Note note) {
        store.put(note.getId(), note);
        return note;
    }

    @Override
    public Optional<Note> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Note> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }

    @Override
    public boolean existsById(UUID id) {
        return store.containsKey(id);
    }
}
