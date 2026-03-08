package com.algaworks.algacomments.moderation.service.api.model;

import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Data
public class ModerationInput {
    @NonNull
    private String text;

    @NonNull
    private UUID commentId;
}
