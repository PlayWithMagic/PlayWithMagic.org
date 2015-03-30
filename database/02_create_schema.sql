CREATE TABLE country
(
    country_uid SERIAL PRIMARY KEY NOT NULL,
    country_name VARCHAR(100) NOT NULL,
    country_order INT NOT NULL
);
CREATE TABLE country_country_uid_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE effect
(
    effect_uid SERIAL PRIMARY KEY NOT NULL,
    effect_name VARCHAR(45) NOT NULL,
    effect_order INT NOT NULL,
    effect_description VARCHAR(2000)
);
CREATE TABLE effect_effect_uid_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE magician
(
    magician_uid SERIAL PRIMARY KEY NOT NULL,
    first_name VARCHAR(25),
    last_name VARCHAR(25) NOT NULL,
    city VARCHAR(45),
    state VARCHAR(45),
    country_uid INT,
    estimate_birthdate DATE,
    biography VARCHAR(2000),
    postal_code VARCHAR(25),
    photo VARCHAR(255),
    influences VARCHAR(2000),
    library_books VARCHAR(2000),
    library_videos VARCHAR(2000),
    magician_type_uid INT NOT NULL,
    estimate_start_date DATE,
    crowning_moment VARCHAR(2000),
    share_details_yn BOOL NOT NULL,
    contact_yn BOOL NOT NULL,
    collection VARCHAR(2000),
    reference_facebook VARCHAR(255),
    reference_google VARCHAR(255),
    reference_twitter VARCHAR(255),
    reference_weibo VARCHAR(255),
    personal_website VARCHAR(255)
);
CREATE TABLE magician_magician_uid_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE magician_routine_type
(
    magician_uid INT NOT NULL,
    routine_type_uid INT NOT NULL,
    PRIMARY KEY (magician_uid, routine_type_uid)
);
CREATE TABLE magician_type
(
    magician_type_uid SERIAL PRIMARY KEY NOT NULL,
    magician_type_name VARCHAR(45) NOT NULL,
    magician_type_order INT NOT NULL,
    magician_type_description VARCHAR(2000)
);
CREATE TABLE magician_type_magician_type_uid_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE position
(
    position_uid SERIAL PRIMARY KEY NOT NULL,
    position_name VARCHAR(45) NOT NULL,
    position_description VARCHAR(2000),
    position_order INT NOT NULL
);
CREATE TABLE position_position_uid_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE routine
(
    routine_uid SERIAL PRIMARY KEY NOT NULL,
    routine_name VARCHAR(45) NOT NULL,
    routine_description VARCHAR(2000) NOT NULL,
    min_duration_in_seconds INT NOT NULL,
    reset_time_in_seconds INT,
    share_routine_yn BOOL NOT NULL,
    magician_uid INT NOT NULL,
    routine_type_uid INT NOT NULL,
    skill_level_uid INT NOT NULL,
    max_duration_in_seconds INT NOT NULL,
    method VARCHAR(2000),
    handling VARCHAR(2000),
    prep_time_in_seconds INT,
    image VARCHAR(255)
);
CREATE TABLE routine_effect
(
    routine_uid INT NOT NULL,
    effect_uid INT NOT NULL,
    PRIMARY KEY (routine_uid, effect_uid)
);
CREATE TABLE routine_item
(
    routine_item_uid SERIAL PRIMARY KEY NOT NULL,
    routine_uid INT NOT NULL,
    item_name VARCHAR(45) NOT NULL,
    item_order INT NOT NULL,
    inspect_yn BOOL NOT NULL,
    takeaway_yn BOOL NOT NULL,
    consumed_yn BOOL NOT NULL,
    cost_amount INT NOT NULL,
    cost_currency INT NOT NULL
);
CREATE TABLE routine_item_routine_item_uid_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE routine_position
(
    routine_uid INT NOT NULL,
    position_uid INT NOT NULL,
    PRIMARY KEY (routine_uid, position_uid)
);
CREATE TABLE routine_routine_uid_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE routine_type
(
    routine_type_uid SERIAL PRIMARY KEY NOT NULL,
    routine_type_name VARCHAR(45) NOT NULL,
    routine_type_description VARCHAR(2000),
    routine_type_order INT NOT NULL
);
CREATE TABLE routine_type_routine_type_uid_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE routine_venue
(
    routine_uid INT NOT NULL,
    venue_uid INT NOT NULL
);
CREATE TABLE set
(
    set_uid SERIAL PRIMARY KEY NOT NULL,
    set_name VARCHAR(45) NOT NULL,
    magician_uid INT NOT NULL,
    storyline VARCHAR(2000),
    skill_level_uid INT NOT NULL,
    share_set_yn BOOL NOT NULL,
    venue_uid INT NOT NULL
);
CREATE TABLE set_set_uid_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE skill_level
(
    skill_level_uid SERIAL PRIMARY KEY NOT NULL,
    skill_level_name VARCHAR(45) NOT NULL,
    skill_level_description VARCHAR(2000),
    skill_level_order INT NOT NULL
);
CREATE TABLE skill_level_map
(
    skill_level_uid INT NOT NULL,
    magician_type_uid INT NOT NULL,
    distance INT NOT NULL
);
CREATE TABLE skill_level_skill_level_uid_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE TABLE venue
(
    venue_uid SERIAL PRIMARY KEY NOT NULL,
    venue_name VARCHAR(45) NOT NULL,
    venue_description VARCHAR(2000),
    venue_order INT NOT NULL
);
CREATE TABLE venue_venue_uid_seq
(
    sequence_name VARCHAR NOT NULL,
    last_value BIGINT NOT NULL,
    start_value BIGINT NOT NULL,
    increment_by BIGINT NOT NULL,
    max_value BIGINT NOT NULL,
    min_value BIGINT NOT NULL,
    cache_value BIGINT NOT NULL,
    log_cnt BIGINT NOT NULL,
    is_cycled BOOL NOT NULL,
    is_called BOOL NOT NULL
);
CREATE UNIQUE INDEX unique_country ON country (country_name);
CREATE UNIQUE INDEX unique_country_order ON country (country_order);
CREATE UNIQUE INDEX unique_country_uid ON country (country_uid);
CREATE UNIQUE INDEX unique_effect_name ON effect (effect_name);
CREATE UNIQUE INDEX unique_effect_uid ON effect (effect_uid);
ALTER TABLE magician ADD FOREIGN KEY (country_uid) REFERENCES country (country_uid);
ALTER TABLE magician ADD FOREIGN KEY (magician_type_uid) REFERENCES magician_type (magician_type_uid);
CREATE UNIQUE INDEX unique_magician_uid ON magician (magician_uid);
ALTER TABLE magician_routine_type ADD FOREIGN KEY (magician_uid) REFERENCES magician (magician_uid);
ALTER TABLE magician_routine_type ADD FOREIGN KEY (routine_type_uid) REFERENCES routine_type (routine_type_uid);
CREATE UNIQUE INDEX unique_magician_type_name ON magician_type (magician_type_name);
CREATE UNIQUE INDEX unique_magician_type_order ON magician_type (magician_type_order);
CREATE UNIQUE INDEX unique_magician_type_uid ON magician_type (magician_type_uid);
CREATE UNIQUE INDEX unique_position_name ON position (position_name);
CREATE UNIQUE INDEX unique_position_order ON position (position_order);
CREATE UNIQUE INDEX unique_position_uid ON position (position_uid);
ALTER TABLE routine ADD FOREIGN KEY (magician_uid) REFERENCES magician (magician_uid);
ALTER TABLE routine ADD FOREIGN KEY (routine_type_uid) REFERENCES routine_type (routine_type_uid);
ALTER TABLE routine ADD FOREIGN KEY (skill_level_uid) REFERENCES skill_level (skill_level_uid);
CREATE UNIQUE INDEX unique_routine_uid ON routine (routine_uid);
ALTER TABLE routine_effect ADD FOREIGN KEY (effect_uid) REFERENCES effect (effect_uid);
ALTER TABLE routine_effect ADD FOREIGN KEY (routine_uid) REFERENCES routine (routine_uid);
ALTER TABLE routine_item ADD FOREIGN KEY (routine_uid) REFERENCES routine (routine_uid);
CREATE UNIQUE INDEX unique_routine_item_uid ON routine_item (routine_item_uid);
ALTER TABLE routine_position ADD FOREIGN KEY (position_uid) REFERENCES position (position_uid);
ALTER TABLE routine_position ADD FOREIGN KEY (routine_uid) REFERENCES routine (routine_uid);
CREATE UNIQUE INDEX unique_routine_type_name ON routine_type (routine_type_name);
CREATE UNIQUE INDEX unique_routine_type_order ON routine_type (routine_type_order);
CREATE UNIQUE INDEX unique_routine_type_uid ON routine_type (routine_type_uid);
ALTER TABLE routine_venue ADD FOREIGN KEY (routine_uid) REFERENCES routine (routine_uid);
ALTER TABLE routine_venue ADD FOREIGN KEY (venue_uid) REFERENCES venue (venue_uid);
ALTER TABLE set ADD FOREIGN KEY (magician_uid) REFERENCES magician (magician_uid);
ALTER TABLE set ADD FOREIGN KEY (skill_level_uid) REFERENCES skill_level (skill_level_uid);
ALTER TABLE set ADD FOREIGN KEY (venue_uid) REFERENCES venue (venue_uid);
CREATE UNIQUE INDEX unique_set_uid ON set (set_uid);
CREATE UNIQUE INDEX unique_skill_level_name ON skill_level (skill_level_name);
CREATE UNIQUE INDEX unique_skill_level_order ON skill_level (skill_level_order);
CREATE UNIQUE INDEX unique_skill_level_uid ON skill_level (skill_level_uid);
ALTER TABLE skill_level_map ADD FOREIGN KEY (magician_type_uid) REFERENCES magician_type (magician_type_uid);
ALTER TABLE skill_level_map ADD FOREIGN KEY (skill_level_uid) REFERENCES skill_level (skill_level_uid);
CREATE UNIQUE INDEX unique_venue_name ON venue (venue_name);
CREATE UNIQUE INDEX unique_venue_order ON venue (venue_order);
CREATE UNIQUE INDEX unique_venue_uid ON venue (venue_uid);
