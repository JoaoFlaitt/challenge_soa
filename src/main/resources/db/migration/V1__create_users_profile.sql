DROP TABLE IF EXISTS user_profiles;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id BINARY(16) NOT NULL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE user_profiles (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BINARY(16) NOT NULL UNIQUE,
    age INT,
    height DECIMAL(5,2),
    weight DECIMAL(5,2),
    preferences VARCHAR(255),
    goals VARCHAR(255),
    CONSTRAINT fk_user_profiles_user
        FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB;