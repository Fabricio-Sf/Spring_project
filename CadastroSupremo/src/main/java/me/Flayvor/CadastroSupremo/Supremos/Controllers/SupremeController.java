package me.Flayvor.CadastroSupremo.Supremos.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SupremeController {
    @GetMapping
    public String hello() {
        return "Ni HOWDY!";
    }
}
