package com.example.memo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
public class MemoEntity {
    private long id;
    private String title;
    private String text;
    private Timestamp edit_time;
}
