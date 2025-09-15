package kr.ac.kopo.minn.springboot_jdbctest.controller;

import kr.ac.kopo.minn.springboot_jdbctest.domain.Member;
import kr.ac.kopo.minn.springboot_jdbctest.repository.MemberRepository04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class Example04Controller {
    @Autowired
    MemberRepository04 repository;
    @GetMapping
    public String viewHomePage(Model model) {
        List<Member> memberList = repository.selectMethod();
        model.addAttribute("memberList", memberList);
        return "viewPage04";
    }
    @GetMapping("/new")
    public String newMethod(Model model) {
        Member member = new Member();
        model.addAttribute("member", member);
        return "viewPage04_new";
    }
    @GetMapping("/insert")
    public String insertMethod(@ModelAttribute("member") Member member) {
        repository.insertMethod(member);
        return "redirect:/exam04";
    }
    @GetMapping("/edit/{id}")
    public String editMethod(@PathVariable(name = "id") int id, Model model) {
        Member member = repository.selectMemberById(id);
        model.addAttribute("member", member);
        return "viewPage04_edit";
    }
    @PostMapping("/update")
    public String updateMethod(@ModelAttribute("member") Member member) {
        repository.updateMethod(member);
        return "redirect:/exam04";
    }
    @GetMapping("/delete/{id}")
    public String deleteMethod(@PathVariable(name = "id") int id) {
        repository.deleteMethod(id);
        return "redirect:/exam04";
    }
}
