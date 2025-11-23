CREATE TABLE challenges (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    description VARCHAR(500) NOT NULL,
    duration_days INT NOT NULL,
    points_reward INT NOT NULL,
    type VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE user_challenges (
    id BINARY(16) NOT NULL PRIMARY KEY,
    user_id BINARY(16) NOT NULL,
    challenge_id BIGINT NOT NULL,
    start_date DATE,
    completed TINYINT(1) DEFAULT 0,
    CONSTRAINT fk_user_challenges_user
        FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_user_challenges_challenge
        FOREIGN KEY (challenge_id) REFERENCES challenges(id)
) ENGINE=InnoDB;
