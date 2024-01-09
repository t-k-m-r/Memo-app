package com.example.memo.domain.memo;

import com.example.memo.domain.MemoEntity;

import java.sql.Timestamp;
import java.util.List;

public class MemoService {
    public List<MemoEntity> findAll() {
        return List.of(
                new MemoEntity(1, "(タイトル1)", "(本文1)", Timestamp.valueOf("2024-01-01 10:10:10")),
                new MemoEntity(2, "(タイトル2)", "(本文2)", Timestamp.valueOf("2024-01-02 10:10:10"))
        );
    }
}
