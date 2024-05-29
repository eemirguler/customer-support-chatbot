package com.witcha.customerchatbot.service;

import reactor.core.publisher.Mono;

import java.util.Map;

public interface ChatService {
    String establishChat();
    Mono<Map<String, Object>> chat(String chatId, String message);
}
