create table memos (
id SERIAL PRIMARY KEY,
title VARCHAR(50),
text TEXT NOT NULL,
edit_time TIMESTAMP NOT NULL
);