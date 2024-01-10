package com.example.memo.service.memo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record MemoEntity(
        Long id,
        String title,
        String text,
        LocalDateTime edit_time
) {
}
