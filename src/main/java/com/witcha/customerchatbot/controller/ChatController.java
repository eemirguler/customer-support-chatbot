package com.witcha.customerchatbot.controller;

import com.witcha.customerchatbot.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    Mono<ResponseEntity<Map<String, Object>>> chat(@RequestBody Map<String, String> chatInfo) {
        return chatService.chat(chatInfo.get("chatId"), chatInfo.get("message"))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.internalServerError().build());
    }
}
