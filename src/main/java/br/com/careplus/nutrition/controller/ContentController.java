package br.com.careplus.nutrition.controller;

import br.com.careplus.nutrition.dto.ContentDTO;
import br.com.careplus.nutrition.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping
    public ResponseEntity<List<ContentDTO>> listContent() {
        return ResponseEntity.ok(contentService.listAll());
    }
}