package com.example.Forum_V1.web.ressource;



import com.example.Forum_V1.service.MessageService;
import com.example.Forum_V1.service.dto.MessageDTO;
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
@RequestMapping("/api/messages")
public class MessageResource {
    private final MessageService messageService;

    @PostMapping("/subject/{subjectId}")
    @ApiResponse(responseCode = "201", description = "Request to save message")
    @Operation(summary = "Create a new message", description = "This endpoint allows to create a new message")
    public ResponseEntity<MessageDTO> createMessage(@PathVariable Long subjectId, @RequestBody MessageDTO messageDTO) {
        log.debug("REST Request to save Message : {}", messageDTO);
        return new ResponseEntity<>(messageService.createMessage(subjectId, messageDTO), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Find all messages", description = "This endpoint allows to get all messages")
    public List<MessageDTO> getAllMessages() {
        log.debug("REST Request to get all Messages");
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request to get message by id"),
            @ApiResponse(responseCode = "404", description = "Message not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "Get message by id", description = "This endpoint allows to get message by id")
    public ResponseEntity<?> getMessageById(@PathVariable Long id) {
        log.debug("REST Request to get Message by id : {}", id);
        Optional<MessageDTO> messageDTO = Optional.ofNullable(messageService.getMessageById(id));
        if (messageDTO.isPresent()) {
            return new ResponseEntity<>(messageDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Message not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/slug/{slug}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Request to get message by slug"),
            @ApiResponse(responseCode = "404", description = "Message not found", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @Operation(summary = "Get message by slug", description = "This endpoint allows to get message by slug")
    public ResponseEntity<?> getMessageBySlug(@PathVariable String slug) {
        log.debug("REST Request to get Message by slug : {}", slug);
        Optional<MessageDTO> messageDTO = Optional.ofNullable(messageService.getMessageBySlug(slug));
        if (messageDTO.isPresent()) {
            return new ResponseEntity<>(messageDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Message not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/subject/{subjectId}")
    @Operation(summary = "Find messages by subject id", description = "This endpoint allows to find messages by subject id")
    public List<MessageDTO> getMessagesBySubjectId(@PathVariable Long subjectId) {
        log.debug("REST Request to get all Messages by subject id : {}", subjectId);
        return messageService.getAllMessagesBySubjectId(subjectId);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "Request to delete message")
    @Operation(summary = "Delete message by id", description = "This endpoint allows to delete message by id")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        log.debug("REST Request to delete Message by id : {}", id);
        messageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
