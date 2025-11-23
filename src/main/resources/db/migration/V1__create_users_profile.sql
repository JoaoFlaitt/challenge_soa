CREATE TABLE users (
    id BINARY(16) PRIMARY KEY,
    email VARCHAR(150) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    password_hash VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE user_profile (
    id BINARY(16) PRIMARY KEY,
    user_id BINARY(16) NOT NULL UNIQUE,
    age INT,CREATE TABLE users (
    id BINARY(16) NOT NULL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password_hash VARCHAR(200) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE user_profiles (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    age INT,
    height DOUBLE,
    weight DOUBLE,
    preferences VARCHAR(255),
    goals VARCHAR(255),
    user_id BINARY(16),
    CONSTRAINT fk_user_profiles_user
        FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB;

    height DECIMAL(5,2),
    weight DECIMAL(5,2),
    preferences VARCHAR(255),
    goals VARCHAR(255),
    CONSTRAINT fk_user_profile_user FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB;