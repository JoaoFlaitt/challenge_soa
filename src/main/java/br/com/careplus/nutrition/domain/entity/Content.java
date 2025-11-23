package br.com.careplus.nutrition.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "content")
@Data
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;
    private String category;
}