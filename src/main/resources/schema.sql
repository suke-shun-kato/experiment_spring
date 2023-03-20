create table "recipes"
(
    "id"          INTEGER auto_increment primary key,
    "description" CHARACTER VARYING(255) NOT NULL,
    "image_url"   CHARACTER VARYING(255),
    "title"       CHARACTER VARYING(255) NOT NULL
);