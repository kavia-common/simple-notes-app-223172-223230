package com.example.notesbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO for creating a new note.
 */
@Schema(name = "NoteCreateRequest", description = "Payload for creating a note")
public class NoteCreateRequest {

    @NotBlank(message = "Title must not be empty")
    @Schema(description = "Title of the note", example = "Grocery list", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "Content/body of the note", example = "Milk, Bread, Eggs")
    private String content;

    public NoteCreateRequest() {}

    public NoteCreateRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // PUBLIC_INTERFACE
    public String getTitle() {
        /** Title accessor. */
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // PUBLIC_INTERFACE
    public String getContent() {
        /** Content accessor. */
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
