package com.example.notesbackend.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * Note domain model representing a note entity in the system.
 */
@Schema(name = "Note", description = "Represents a note with a title and content.")
public class Note {

    @Schema(description = "Unique identifier of the note", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID id;

    @Schema(description = "Title of the note", example = "Grocery list")
    private String title;

    @Schema(description = "Content/body of the note", example = "Milk, Bread, Eggs")
    private String content;

    @Schema(description = "Creation timestamp in UTC", example = "2024-01-01T12:00:00Z")
    private Instant createdAt;

    @Schema(description = "Last update timestamp in UTC", example = "2024-01-01T12:30:00Z")
    private Instant updatedAt;

    public Note() {
    }

    public Note(UUID id, String title, String content, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Note createNew(String title, String content) {
        Instant now = Instant.now();
        return new Note(UUID.randomUUID(), title, content, now, now);
    }

    public UUID getId() {
        return id;
    }

    public Note setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Note setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Note setContent(String content) {
        this.content = content;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Note setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Note setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        return Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
