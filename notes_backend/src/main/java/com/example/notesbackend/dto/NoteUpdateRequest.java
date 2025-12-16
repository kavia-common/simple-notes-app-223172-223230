package com.example.notesbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO for updating an existing note.
 */
@Schema(name = "NoteUpdateRequest", description = "Payload for updating a note")
public class NoteUpdateRequest {

    @NotBlank(message = "Title must not be empty")
    @Schema(description = "Updated title of the note", example = "New grocery list", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "Updated content/body of the note", example = "Milk, Bread, Eggs, Butter")
    private String content;

    public NoteUpdateRequest() {}

    public NoteUpdateRequest(String title, String content) {
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
