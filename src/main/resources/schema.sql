DROP TABLE if exists messages;

CREATE TABLE IF NOT EXISTS messages (
                                     id bigint AUTO_INCREMENT PRIMARY KEY,
                                     text TEXT,
                                     tag TEXT
);

INSERT INTO messages (text, tag) VALUES ('This is an initial test message', 'TestUser');
INSERT INTO messages (text, tag) VALUES ('This is first message of the first user', 'FirstUser');
INSERT INTO messages (text, tag) VALUES ('This is second message of the first user', 'FirstUser');
INSERT INTO messages (text, tag) VALUES ('This is first message of the second user', 'SecondUser');
INSERT INTO messages (text, tag) VALUES ('This is second message of the second user', 'SecondUser');
INSERT INTO messages (text, tag) VALUES ('This is first message of the third user', 'ThirdUser');
INSERT INTO messages (text, tag) VALUES ('This is second message of the third user', 'ThirdUser');