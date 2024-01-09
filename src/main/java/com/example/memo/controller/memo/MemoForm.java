package com.example.memo.controller.memo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemoForm {
    @Size(max=50)
    private String title;

    @NotBlank
    @Size(max=1000)
    private String text;
}
