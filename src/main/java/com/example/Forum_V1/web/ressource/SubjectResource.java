package com.example.Forum_V1.web.ressource;



import com.example.Forum_V1.service.SubjectService;
import com.example.Forum_V1.service.dto.SubjectDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/subjects")
public class SubjectResource {
    private final SubjectService subjectService;

    @PostMapping("/forum/{forumId}")
    @ApiResponse(responseCode = "201", description = "Request to save subject")
    @Operation(summary = "Create a new subject", description = "This endpoint allows to create a new subject")
    public ResponseEntity<SubjectDTO> createSubject(@PathVariable Long forumId, @RequestBody SubjectDTO subjectDTO) {
        log.debug("REST Request to save Subject : {}", subjectDTO);
        return new ResponseEntity<>(subjectService.createSubject(forumId, subjectDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Find all subjects", description = "This endpoint allows to get all subjects")
    public List<SubjectDTO> getAllSubjects() {
        log.debug("REST Request to get all Subjects");
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request to get subject by id"),
            @ApiResponse(responseCode = "404", description = "Subject not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "Get subject by id", description = "This endpoint allows to get subject by id")
    public ResponseEntity<?> getSubjectById(@PathVariable Long id) {
        log.debug("REST Request to get Subject by id : {}", id);
        Optional<SubjectDTO> subjectDTO = Optional.ofNullable(subjectService.getSubjectById(id));
        if (subjectDTO.isPresent()) {
            return new ResponseEntity<>(subjectDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Subject not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/slug/{slug}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request to get subject by slug"),
            @ApiResponse(responseCode = "404", description = "Subject not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "Get subject by slug", description = "This endpoint allows to get subject by slug")
    public ResponseEntity<?> getSubjectBySlug(@PathVariable String slug) {
        log.debug("REST Request to get Subject by slug : {}", slug);
        Optional<SubjectDTO> subjectDTO = Optional.ofNullable(subjectService.getSubjectBySlug(slug));
        if (subjectDTO.isPresent()) {
            return new ResponseEntity<>(subjectDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Subject not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/forum/{forumId}")
    @Operation(summary = "Find subjects by forum id", description = "This endpoint allows to find subjects by forum id")
    public List<SubjectDTO> getSubjectsByForumId(@PathVariable Long forumId) {
        log.debug("REST Request to get all Subjects by forum id : {}", forumId);
        return subjectService.getAllSubjectsByForumId(forumId);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "Request to delete subject")
    @Operation(summary = "Delete subject by id", description = "This endpoint allows to delete subject by id")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        log.debug("REST Request to delete Subject by id : {}", id);
        subjectService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
