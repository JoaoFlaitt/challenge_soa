CREATE TABLE meals (
    id BINARY(16) NOT NULL PRIMARY KEY,
    date_time DATETIME NOT NULL,
    type VARCHAR(50) NOT NULL,
    wellness_score INT,
    user_id BINARY(16) NOT NULL,
    CONSTRAINT fk_meals_user
        FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB;

CREATE TABLE meal_items (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    food_id VARCHAR(100),
    food_name VARCHAR(255) NOT NULL,
    quantity DOUBLE,
    unit VARCHAR(50),
    calories INT,
    meal_id BINARY(16) NOT NULL,
    CONSTRAINT fk_meal_items_meals
        FOREIGN KEY (meal_id) REFERENCES meals(id)
) ENGINE=InnoDB;
