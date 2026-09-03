package com.generation.academia_fithub.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
// CONTROLLER TEMPORÁRIO - REMOVER DEPOIS DE USAR UMA VEZ
@RestController
@RequestMapping("/temp-fix")
public class TempFixController {
 
    @Autowired
    private JdbcTemplate jdbcTemplate;
 
    @GetMapping("/add-coluna")
    public String addColuna() {
        try {
            jdbcTemplate.execute("ALTER TABLE tb_usuarios ADD COLUMN IF NOT EXISTS tipo_usuario INTEGER");
            return "OK - coluna tipo_usuario adicionada (ou já existia).";
        } catch (Exception e) {
            return "ERRO: " + e.getClass().getSimpleName() + " - " + e.getMessage();
        }
    }
}
 