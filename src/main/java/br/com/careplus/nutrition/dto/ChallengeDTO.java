package br.com.careplus.nutrition.dto;

import br.com.careplus.nutrition.domain.entity.Challenge;

public class ChallengeDTO {

    private Long id;
    private String title;
    private String description;
    private Integer durationDays;
    private Integer pointsReward;
    private String type;

    public ChallengeDTO() {
    }

    public ChallengeDTO(Challenge c) {
        this.id = c.getId();
        this.title = c.getTitle();
        this.description = c.getDescription();
        this.durationDays = c.getDurationDays();
        this.pointsReward = c.getPointsReward();
        this.type = c.getType();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public Integer getPointsReward() {
        return pointsReward;
    }

    public String getType() {
        return type;
    }
}