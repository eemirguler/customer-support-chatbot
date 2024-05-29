package com.witcha.customerchatbot.config;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatbotConfig {

    @Bean
    OllamaOptions ollamaOptions() {
        return new OllamaOptions()
                .withModel("llama3")
                .withTemperature(0.7F)
                .withTopK(2);
    }

    @Bean
    OllamaChatClient ollamaChatClient(OllamaOptions ollamaOptions) {
        return new OllamaChatClient(new OllamaApi("http://localhost:11434"))
                .withDefaultOptions(ollamaOptions);

    }
}
