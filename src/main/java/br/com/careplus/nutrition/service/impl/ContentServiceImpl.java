package br.com.careplus.nutrition.service.impl;

import br.com.careplus.nutrition.domain.repository.ContentRepository;
import br.com.careplus.nutrition.dto.ContentDTO;
import br.com.careplus.nutrition.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

    @Override
    public List<ContentDTO> listAll() {
        return contentRepository.findAll().stream()
                .map(ContentDTO::new)
                .toList();
    }
}