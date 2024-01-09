package com.example.memo.controller.memo;

import com.example.memo.domain.MemoEntity;
import com.example.memo.domain.memo.MemoService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;
    @GetMapping("/memo/list")
    public String showList(Model model) {
        model.addAttribute("memoList", memoService.findAll());
        return "memos/list";
    }

    @GetMapping("/memo/create")
    public String creationForm() {
        return "memos/form";
    }
}
