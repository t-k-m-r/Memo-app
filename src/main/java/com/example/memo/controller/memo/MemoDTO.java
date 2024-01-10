package com.example.memo.controller.memo;

import com.example.memo.service.memo.MemoEntity;

import java.time.LocalDateTime;

public record MemoDTO(
        long id,
        String title,
        String text,
        LocalDateTime edit_time
) {
    public static MemoDTO toDTO(MemoEntity entity) {
        return new MemoDTO(
                entity.id(),
                entity.title(),
                entity.text(),
                entity.edit_time()
        );
    };
}
