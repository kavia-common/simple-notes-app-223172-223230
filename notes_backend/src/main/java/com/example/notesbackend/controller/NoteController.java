package com.example.notesbackend.controller;

import com.example.notesbackend.dto.NoteCreateRequest;
import com.example.notesbackend.dto.NoteUpdateRequest;
import com.example.notesbackend.model.Note;
import com.example.notesbackend.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * REST Controller exposing CRUD endpoints for Notes.
 */
@RestController
@RequestMapping(path = "/api/notes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Notes", description = "CRUD operations for notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    // PUBLIC_INTERFACE
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create note", description = "Create a new note",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created",
                            content = @Content(schema = @Schema(implementation = Note.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request",
                            content = @Content)
            })
    public Note create(@Valid @RequestBody NoteCreateRequest request) {
        /** Create note endpoint. */
        return service.create(request);
    }

    // PUBLIC_INTERFACE
    @GetMapping
    @Operation(summary = "List notes", description = "Get all notes",
            responses = @ApiResponse(responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = Note.class))))
    public List<Note> list() {
        /** List all notes endpoint. */
        return service.getAll();
    }

    // PUBLIC_INTERFACE
    @GetMapping("/{id}")
    @Operation(summary = "Get note", description = "Get a note by its ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK",
                            content = @Content(schema = @Schema(implementation = Note.class))),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            })
    public Note get(@PathVariable("id") UUID id) {
        /** Get a single note endpoint. */
        return service.getById(id);
    }

    // PUBLIC_INTERFACE
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update note", description = "Update a note by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Updated",
                            content = @Content(schema = @Schema(implementation = Note.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            })
    public Note update(@PathVariable("id") UUID id, @Valid @RequestBody NoteUpdateRequest request) {
        /** Update note endpoint. */
        return service.update(id, request);
    }

    // PUBLIC_INTERFACE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete note", description = "Delete a note by ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Deleted"),
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content)
            })
    public void delete(@PathVariable("id") UUID id) {
        /** Delete note endpoint. */
        service.delete(id);
    }
}
