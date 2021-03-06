BEGIN TRANSACTION;

DROP TABLE IF EXISTS ROLE;
DROP TABLE IF EXISTS TEST_RESPONSES;
DROP TABLE IF EXISTS TEST_QUESTIONS;
DROP TABLE IF EXISTS TESTS;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS ANSWERS;
DROP TABLE IF EXISTS QUESTIONS;

DROP SEQUENCE IF EXISTS user_seq;

CREATE SEQUENCE user_seq START 10;
CREATE TABLE USERS
(
  ID        INT          NOT NULL DEFAULT nextval('user_seq'),
  USERNAME  VARCHAR(32)  NOT NULL UNIQUE,
  FIRSTNAME VARCHAR(32)  NOT NULL,
  LASTNAME  VARCHAR(32)  NOT NULL,
  EMAIL     VARCHAR(256) NOT NULL,
  PASSWORD  VARCHAR(256) NOT NULL,
  ISACTIVE  BOOLEAN      NOT NULL DEFAULT TRUE,

  PRIMARY KEY (ID)
);

CREATE TABLE ROLE
(
  USERID    INT         NOT NULL,
  AUTHORITY VARCHAR(15) NOT NULL,

  PRIMARY KEY (USERID, AUTHORITY),

  FOREIGN KEY (USERID) REFERENCES USERS (ID)
);

CREATE TABLE QUESTIONS
(
  ID      INT           NOT NULL,
  NAME    VARCHAR(1024),
  CONTENT VARCHAR(4000) NOT NULL,

  PRIMARY KEY (ID)
);

CREATE TABLE ANSWERS
(
  ANSWER_NR   INT           NOT NULL,
  QUESTION_ID INT           NOT NULL,
  CONTENT     VARCHAR(4000) NOT NULL,
  IS_CORRECT  NUMERIC(1, 0) NOT NULL,

  PRIMARY KEY (ANSWER_NR, QUESTION_ID),
  FOREIGN KEY (QUESTION_ID) REFERENCES QUESTIONS (ID)
);

CREATE TABLE TESTS
(
  ID      INT           NOT NULL,
  USER_ID INT           NOT NULL,
  NAME    VARCHAR(4000) NOT NULL,
  TYPE    VARCHAR(4000) NOT NULL,

  PRIMARY KEY (ID),
  FOREIGN KEY (USER_ID) REFERENCES USERS (ID)
);

CREATE TABLE TEST_QUESTIONS
(
  NUMBER      INT          NOT NULL,
  TEST_ID     INT          NOT NULL,
  QUESTION_ID INT          NOT NULL,
  STATUS      VARCHAR(100) NOT NULL,

  PRIMARY KEY (NUMBER, TEST_ID, QUESTION_ID),
  FOREIGN KEY (TEST_ID) REFERENCES TESTS (ID),
  FOREIGN KEY (QUESTION_ID) REFERENCES QUESTIONS (ID)
);

CREATE TABLE TEST_RESPONSES
(
  TEST_ID              INT NOT NULL,
  TEST_QUESTION_NUMBER INT NOT NULL,
  QUESTION_ID          INT NOT NULL,
  ANSWER_NR            INT NOT NULL,

  PRIMARY KEY (TEST_ID, TEST_QUESTION_NUMBER, QUESTION_ID, ANSWER_NR),
  FOREIGN KEY (TEST_QUESTION_NUMBER, TEST_ID, QUESTION_ID) REFERENCES TEST_QUESTIONS (NUMBER, TEST_ID, QUESTION_ID),
  FOREIGN KEY (ANSWER_NR, QUESTION_ID) REFERENCES ANSWERS (ANSWER_NR, QUESTION_ID)
);

---------------------------------------------------------------------

INSERT INTO USERS (ID, USERNAME, FIRSTNAME, LASTNAME, EMAIL, PASSWORD, ISACTIVE)
VALUES (1, 'admin', 'Administrator', 'Administrator', 'admin@ligacentaurilor.com',
        '$2a$10$FEcoeljLlk.EROcDwddpiOHh8oM.BgaWCm7npddgdjNItMX4L3oeC', TRUE);

INSERT INTO ROLE (USERID, AUTHORITY) VALUES (1, 'ROLE_ADMIN');

INSERT INTO QUESTIONS (ID, NAME, CONTENT) VALUES (1, 'No 1', 'Which of the following statements are true?');

INSERT INTO ANSWERS (ANSWER_NR, QUESTION_ID, CONTENT, IS_CORRECT)
VALUES (1, 1, 'Abstract classes can implement interfaces', 1);

INSERT INTO ANSWERS (ANSWER_NR, QUESTION_ID, CONTENT, IS_CORRECT)
VALUES (2, 1, 'Final classes can be extended.', 0);

INSERT INTO TESTS (ID, USER_ID, NAME, TYPE)
VALUES (1, 1, 'Demo-Test', 'Standard');

INSERT INTO TEST_QUESTIONS (NUMBER, TEST_ID, QUESTION_ID, STATUS) VALUES (1, 1, 1, 'NOT_ANSWERED');

INSERT INTO TEST_RESPONSES (TEST_ID, TEST_QUESTION_NUMBER, QUESTION_ID, ANSWER_NR) VALUES (1, 1, 1, 2);

COMMIT;
