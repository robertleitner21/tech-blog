package com.robertleitner.techblog.controller;


import com.robertleitner.techblog.dto.SubtechDto;
import com.robertleitner.techblog.service.SubtechService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subtech")
@AllArgsConstructor
@Slf4j
public class SubtechController {

    private final SubtechService subtechService;

    @PostMapping
    public ResponseEntity<SubtechDto> createSubtech(@RequestBody SubtechDto subtechDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subtechService.save(subtechDto));
    }

    @GetMapping
    public ResponseEntity<List<SubtechDto>> getAllSubtechs() {
        return ResponseEntity.status(HttpStatus.OK).body(subtechService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubtechDto> getSubtech(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(subtechService.getSubtech);
    }

}
