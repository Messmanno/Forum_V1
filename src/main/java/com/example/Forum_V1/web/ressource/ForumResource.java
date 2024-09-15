package com.example.Forum_V1.web.ressource;


import com.example.Forum_V1.service.ForumService;
import com.example.Forum_V1.service.dto.ForumDTO;
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
@RequestMapping("/api/forums")
public class ForumResource {
    private final ForumService forumService;

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Request to save forum")
    @Operation(summary = "Create a new forum", description = "This endpoint allows to create a new forum")
    public ResponseEntity<ForumDTO> createForum(@RequestBody ForumDTO forumDTO) {
        log.debug("REST Request to save Forum : {}", forumDTO);
        return new ResponseEntity<>(forumService.createForum(forumDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Find all forums", description = "This endpoint allows to get all forums")
    public List<ForumDTO> getAllForums() {
        log.debug("REST Request to get all Forums");
        return forumService.getAllForums();
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request to get forum by id"),
            @ApiResponse(responseCode = "404", description = "Forum not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "Get forum by id", description = "This endpoint allows to get forum by id")
    public ResponseEntity<?> getForumById(@PathVariable Long id) {
        log.debug("REST Request to get Forum by id : {}", id);
        Optional<ForumDTO> forumDTO = Optional.ofNullable(forumService.getForumById(id));
        if (forumDTO.isPresent()) {
            return new ResponseEntity<>(forumDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forum not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/slug/{slug}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request to get forum by slug"),
            @ApiResponse(responseCode = "404", description = "Forum not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "Get forum by slug", description = "This endpoint allows to get forum by slug")
    public ResponseEntity<?> getForumBySlug(@PathVariable String slug) {
        log.debug("REST Request to get Forum by slug : {}", slug);
        Optional<ForumDTO> forumDTO = Optional.ofNullable(forumService.getForumBySlug(slug));
        if (forumDTO.isPresent()) {
            return new ResponseEntity<>(forumDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forum not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "Request to delete forum")
    @Operation(summary = "Delete forum by id", description = "This endpoint allows to delete forum by id")
    public ResponseEntity<Void> deleteForum(@PathVariable Long id) {
        log.debug("REST Request to delete Forum by id : {}", id);
        forumService.deleteForum(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
