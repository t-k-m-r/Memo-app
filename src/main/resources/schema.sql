create table memos (
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(50),
text VARCHAR(1000) NOT NULL,
edit_time TIMESTAMP NOT NULL
);