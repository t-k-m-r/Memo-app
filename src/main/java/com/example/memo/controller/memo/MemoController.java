package com.example.memo.controller.memo;

import com.example.memo.service.memo.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public String showCreationForm(MemoForm memoForm, Model model) {
        model.addAttribute("mode", "CREATE");
        return "memos/form";
    }

    @PostMapping
    public String create(@Validated MemoForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form, model);
        }
        memoService.create(form.toEntity());
        return "redirect:memos/list";
    }

    @GetMapping("/{memoId}")
    public String showDetail(@PathVariable("memoId") long memoId, Model model) {
        model.addAttribute("memo", memoService.findById(memoId));
        return "memos/detail";
    }

    @GetMapping("/{memoId}/edit")
    public String showEditForm(@PathVariable("memoId") long memoId, Model model) {
        model.addAttribute("memoForm", memoService.findById(memoId));
        model.addAttribute("mode", "EDIT");
        return "memos/form";
    }

    @PutMapping("/{memoId}")
    public String update(@PathVariable("memoId") long memoId,
                         @Validated MemoForm form,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            return showEditForm(memoId, model);
        }
        var entity = form.toEntity(memoId);
        memoService.update(entity);
        return "redirect:/memos/list";
    }

    @DeleteMapping("/{memoId}")
    public String delete(@PathVariable("memoId") long memoId) {
        memoService.delete(memoId);
        return "redirect:/memos/list";
    }
}
