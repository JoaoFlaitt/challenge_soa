package br.com.careplus.nutrition.dto;

import br.com.careplus.nutrition.domain.entity.Content;

public class ContentDTO {

    private Long id;
    private String title;
    private String body;
    private String category;

    public ContentDTO() {
    }

    public ContentDTO(Content c) {
        this.id = c.getId();
        this.title = c.getTitle();
        this.body = c.getBody();
        this.category = c.getCategory();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getCategory() {
        return category;
    }
}