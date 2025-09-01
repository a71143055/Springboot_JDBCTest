package kr.ac.kopo.minn.springboot_jdbctest.controller;

import kr.ac.kopo.minn.springboot_jdbctest.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/new")
    public String newMethod(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "viewPage01_new";
    }
    @PostMapping("/insert")
    public String insertMethod(@ModelAttribute("Person") Person person) {
        String sql = "INSERT INTO person (naem, age, email) VALUES (?, ?, ?)";
        int result = jdbcTemplate.update(sql, person.getName(), person.getAge(), person.getEmail());
        return "redirect:/exam01";
    }
    @GetMapping("/edit/{id}")
    public String editMethod(@PathVariable(name="id") int id, Model model) {
        String sql = "SELECT * FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Person.class), id);
        model.addAttribute("person", person);
        return "viewPage01_edit";
    }
    @PostMapping("/update")
    public String updateMethod(@ModelAttribute("Person") Person person) {
        String sql = "UPDATE person SET name=? age = ?, email = ? WHERE id = ?";
        int result = jdbcTemplate.update(sql, person.getName(), person.getAge(), person.getEmail(), person.getId());
        return "redirect:/exam01";
    }
    @GetMapping("delete/{id}")
    public String deleteMethod(@PathVariable(name="id") int id) {
        String sql = "DELETE FROM person WHERE id = ?";
        int result = jdbcTemplate.update(sql, id);
        return "redirect:/exam01";
    }
}
