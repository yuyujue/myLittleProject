CREATE TABLE IF NOT EXISTS clothes
(
    id        UUID PRIMARY KEY,
    name      VARCHAR(128) NOT NULL,
    season    VARCHAR(64),
    color     VARCHAR(64),
    thickness INTEGER
);
