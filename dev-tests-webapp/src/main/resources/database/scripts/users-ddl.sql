BEGIN TRANSACTION;

DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS QUESTIONS;

CREATE TABLE USERS
(
  ID            INT NOT NULL,
  USERNAME      VARCHAR(32) NOT NULL UNIQUE,
  FIRSTNAME     VARCHAR(32) NOT NULL,
  LASTNAME      VARCHAR(32) NOT NULL,
  EMAIL         VARCHAR(256) NOT NULL,
  PASSWORD      VARCHAR(256) NOT NULL,

  PRIMARY KEY (ID)
);

CREATE TABLE QUESTIONS
(
  ID            INT NOT NULL,
  NAME          VARCHAR(1024),
  CONTENT       VARCHAR(4000) NOT NULL,

  PRIMARY KEY (ID)
);

---------------------------------------------------------------------

INSERT INTO USERS (ID, USERNAME, FIRSTNAME, LASTNAME, EMAIL, PASSWORD) VALUES (1, 'admin', 'Administrator', 'Administrator','admin@ligacentaurilor.com','passwd');

INSERT INTO QUESTIONS (ID, NAME, CONTENT) VALUES (1, 'No 1', 'Which of the following statements are true?');

COMMIT;
