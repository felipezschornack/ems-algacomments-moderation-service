package com.algaworks.algacomments.moderation.service.domain.service;

import com.algaworks.algacomments.moderation.service.api.model.ModerationInput;
import com.algaworks.algacomments.moderation.service.api.model.ModerationOutput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModerationService {

    private static final List<String> FORBIDDEN_WORDS = List.of("ódio", "xingamento");

    public ModerationOutput approve(ModerationInput input) {
        if (containsForbiddenWord(input)) {
            return ModerationOutput.builder()
                    .approved(false)
                    .reason("Comment contains forbidden words")
                    .build();
        }

        return ModerationOutput.builder()
                .approved(true)
                .build();
    }

    private static boolean containsForbiddenWord(ModerationInput input) {
        return FORBIDDEN_WORDS.stream().anyMatch(s -> input.getText().toLowerCase().contains(s));
    }

}
