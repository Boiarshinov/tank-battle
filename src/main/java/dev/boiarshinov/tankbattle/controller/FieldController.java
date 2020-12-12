package dev.boiarshinov.tankbattle.controller;

import dev.boiarshinov.tankbattle.service.Field;
import dev.boiarshinov.tankbattle.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/field", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;

    @GetMapping("/{id}")
    public Field findById(@PathVariable final Integer id) {
        return fieldService.findById(id);
    }

    @GetMapping
    public List<Field> findAll(
        @RequestParam(required = false) final Integer playerCount
    ) {
        return playerCount == null
            ? fieldService.findAll()
            : fieldService.findByPlayerCount(playerCount);
    }
}
