package com.example.memo.controller.memo;

import com.example.memo.service.memo.MemoEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemoForm {
    @Size(max=50)
    private String title;

    @NotBlank
    @Size(max=1000)
    private String text;

    public MemoEntity toEntity() {
        return new MemoEntity(null, title, text, LocalDateTime.now());
    }

    public MemoEntity toEntity(long memoId) {
        return new MemoEntity(memoId, title, text, LocalDateTime.now());
    }
}
