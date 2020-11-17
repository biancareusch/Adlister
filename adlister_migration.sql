DROP DATABASE IF EXISTS adlister_db;
CREATE DATABASE adlister_db;
USE adlister_db;

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin`
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    email    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(95)  NOT NULL UNIQUE,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS businesses;
CREATE TABLE IF NOT EXISTS businesses
(
    id            INT UNSIGNED     NOT NULL AUTO_INCREMENT,
    business_name VARCHAR(255)     NOT NULL UNIQUE,
    address       VARCHAR(255)     NOT NULL UNIQUE,
    email         VARCHAR(255)     NOT NULL UNIQUE,
    password      VARCHAR(95)      NOT NULL,
    isAdmin       TINYINT UNSIGNED NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users
(
    id           INT UNSIGNED     NOT NULL AUTO_INCREMENT,
    listers_type TINYINT UNSIGNED NOT NULL DEFAULT 0,
    username     VARCHAR(150)     NOT NULL UNIQUE,
    first_name    VARCHAR(75)      NOT NULL,
    last_name    VARCHAR(75)      NOT NULL,
    email        VARCHAR(255)     NOT NULL UNIQUE,
    password     VARCHAR(95)      NOT NULL,
    isAdmin      TINYINT          NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS ads;
CREATE TABLE IF NOT EXISTS ads
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    title       VARCHAR(250) NOT NULL,
    description TEXT         NOT NULL,
    business_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (business_id) REFERENCES businesses (id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS timestamps;
CREATE TABLE IF NOT EXISTS timestamps
(
    create_time TIMESTAMP    NULL DEFAULT CURRENT_TIMESTAMP,
    update_time TIMESTAMP    NULL,
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS categories;
CREATE TABLE IF NOT EXISTS categories
(
    id    INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name  VARCHAR(255) NOT NULL,
    ad_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS ad_pictures;
CREATE TABLE IF NOT EXISTS ad_pictures
(
    id    INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ad_id INT UNSIGNED NOT NULL,
    url   TEXT         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (ad_id) REFERENCES ads (id)
);


DROP TABLE IF EXISTS ads_categories;
CREATE TABLE IF NOT EXISTS ads_categories
(
    category_id INT UNSIGNED NOT NULL,
    ad_id       INT UNSIGNED NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories (id),
    FOREIGN KEY (ad_id) REFERENCES ads (id)
);


DROP TABLE IF EXISTS ads_timestamps;
CREATE TABLE IF NOT EXISTS ads_timestamps
(
    ad_id         INT UNSIGNED NOT NULL,
    timestamps_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads (id),
    FOREIGN KEY (timestamps_id) REFERENCES timestamps (id)
);


DROP TABLE IF EXISTS banner_ads;
CREATE TABLE IF NOT EXISTS banner_ads
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title       VARCHAR(255) NOT NULL,
    description TEXT         NOT NULL,
    url         TEXT         NOT NULL,
    ad_id       INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (ad_id) REFERENCES ads (id)
);


DROP TABLE IF EXISTS business_emails;
CREATE TABLE IF NOT EXISTS business_emails
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    business_id INT UNSIGNED NOT NULL,
    email       VARCHAR(255) NOT NULL UNIQUE,
    username    VARCHAR(150) NOT NULL UNIQUE,
    PRIMARY KEY (id),
    FOREIGN KEY (business_id) REFERENCES businesses (id)
);


DROP TABLE IF EXISTS business_pictures;
CREATE TABLE IF NOT EXISTS business_pictures
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name        VARCHAR(150) NULL,
    title       VARCHAR(250) NULL,
    url         TEXT         NOT NULL,
    business_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (business_id) REFERENCES businesses (id)
);

DROP TABLE IF EXISTS business_profiles;
CREATE TABLE IF NOT EXISTS business_profiles
(
    id                 INT UNSIGNED     NOT NULL AUTO_INCREMENT,
    business_id        INT UNSIGNED     NOT NULL,
    about_me           TEXT             NULL,
    phone_number       VARCHAR(15)      NULL UNIQUE,
    profile_pic         TEXT             NULL,
    ad_id              INT UNSIGNED     NOT NULL,
    website_url        TEXT             NULL,
    viewing_preference TINYINT UNSIGNED NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    FOREIGN KEY (business_id) REFERENCES businesses (id),
    FOREIGN KEY (ad_id) REFERENCES ads (id)
);


DROP TABLE IF EXISTS business_timestamps;
CREATE TABLE IF NOT EXISTS business_timestamps
(
    business_id  INT UNSIGNED NOT NULL,
    timestamp_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (business_id) REFERENCES businesses (id),
    FOREIGN KEY (timestamp_id) REFERENCES timestamps (id)
);


DROP TABLE IF EXISTS listers;
CREATE TABLE IF NOT EXISTS listers
(
    user_id     INT UNSIGNED NOT NULL,
    business_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (business_id) REFERENCES businesses (id)
);


DROP TABLE IF EXISTS security_answers;
CREATE TABLE IF NOT EXISTS security_answers
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    answers     VARCHAR(150) NOT NULL UNIQUE,
    business_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (business_id) REFERENCES businesses (id)
);


DROP TABLE IF EXISTS security_questions;
CREATE TABLE IF NOT EXISTS security_questions
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    questions   VARCHAR(255) NOT NULL UNIQUE,
    business_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (business_id) REFERENCES businesses (id)
);


DROP TABLE IF EXISTS security_questions_ans;
CREATE TABLE IF NOT EXISTS security_questions_ans
(
    questions_id INT UNSIGNED NOT NULL,
    answers_id   INT UNSIGNED NOT NULL,
    FOREIGN KEY (questions_id) REFERENCES security_questions (id),
    FOREIGN KEY (answers_id) REFERENCES security_answers (id)
);


DROP TABLE IF EXISTS user_emails;
CREATE TABLE IF NOT EXISTS user_emails
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id  INT UNSIGNED NOT NULL,
    email    VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(150) NOT NULL UNIQUE,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);


DROP TABLE IF EXISTS user_pictures;
CREATE TABLE IF NOT EXISTS user_pictures
(
    id      INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name    VARCHAR(150) NULL,
    title   VARCHAR(250) NULL,
    url     TEXT         NOT NULL,
    user_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);


DROP TABLE IF EXISTS user_profiles;
CREATE TABLE IF NOT EXISTS user_profiles
(
    id                 INT UNSIGNED     NOT NULL AUTO_INCREMENT,
    user_id            INT UNSIGNED     NOT NULL,
    about_me           TEXT             NULL,
    phone_number       VARCHAR(15)      NULL UNIQUE,
    profile_pic         TEXT             NULL,
    ad_id              INT UNSIGNED     NOT NULL,
    viewing_preference TINYINT UNSIGNED NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (ad_id) REFERENCES ads (id)
);


DROP TABLE IF EXISTS users_timestamps;
CREATE TABLE IF NOT EXISTS users_timestamps
(
    user_id       INT UNSIGNED NOT NULL,
    timestamps_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (timestamps_id) REFERENCES timestamps (id)
);