package kr.ac.kopo.minn.springboot_jdbctest.controller;

import kr.ac.kopo.minn.springboot_jdbctest.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam01")
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping
    public String requestMethod(Model model) {
        String sql = "select * from person";
        List<Person> personList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person.class));
        model.addAttribute("personList", personList);
        return "viewPage01";
    }
}
