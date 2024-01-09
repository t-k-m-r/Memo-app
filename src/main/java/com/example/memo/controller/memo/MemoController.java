package com.example.memo.controller.memo;

import com.example.memo.domain.MemoEntity;
import com.example.memo.domain.memo.MemoService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/memos")
public class MemoController {

    private final MemoService memoService;
    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("memoList", memoService.findAll());
        return "memos/list";
    }

    @GetMapping("/create")
    public String showCreationForm(MemoForm memoForm) {
        return "memos/form";
    }

    @PostMapping
    public String create(@Validated MemoForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }
        memoService.create(form.getTitle(), form.getText());
        return "redirect:memos/list";
    }

    @GetMapping("/{memoId}")
    public String showDetail(@PathVariable("memoId") long memoId, Model model) {

        model.addAttribute("memo", memoService.findById(memoId));
        return "memos/detail";

    }
}
