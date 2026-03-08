package com.algaworks.algacomments.moderation.service.api.controller;

import com.algaworks.algacomments.moderation.service.api.model.ModerationInput;
import com.algaworks.algacomments.moderation.service.api.model.ModerationOutput;
import com.algaworks.algacomments.moderation.service.domain.service.ModerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/moderate")
@RequiredArgsConstructor
public class ModerationController {

    private final ModerationService moderationService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ModerationOutput moderate(@RequestBody ModerationInput input) {
        return moderationService.approve(input);
    }

}
