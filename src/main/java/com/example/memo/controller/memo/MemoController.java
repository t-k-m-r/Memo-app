package com.example.memo.controller.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemoController {
    @GetMapping("/memo/list")
    public String list() {
        return "/memos/list";
    }
}
