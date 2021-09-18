package com.robertleitner.techblog.service;

import com.robertleitner.techblog.dto.SubtechDto;
import com.robertleitner.techblog.exceptions.SpringTechException;
import com.robertleitner.techblog.mapper.SubtechMapper;
import com.robertleitner.techblog.model.Subtech;
import com.robertleitner.techblog.repository.SubtechRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.*;

@Service
@AllArgsConstructor
@Slf4j
public class SubtechService {

    private final SubtechRepository subtechRepository;
    private final SubtechMapper subtechMapper;

    @Transactional
    public SubtechDto save(SubtechDto subtechDto) {
        Subtech save = subtechRepository.save(subtechMapper.mapDtoToSubtech(subtechDto));
        subtechDto.setId(save.getId());
        return subtechDto;
    }

    @Transactional(readOnly = true)
    public List<SubtechDto> getAll() {
        return subtechRepository.findAll()
                .stream()
                .map(subtechMapper::mapSubtechToDto)
                .collect(toList());
    }

    public SubtechDto getSubtech(Long id) {
        Subtech subtech = subtechRepository.findById(id)
                .orElseThrow(() -> new SpringTechException()
    }

    /*private SubtechDto mapToDto(Subtech subtech) {
        return SubtechDto.builder().name(subtech.getName())
                .id(subtech.getId())
                .numberOfPosts(subtech.getPosts().size())
                .build();
    }*/

    /*private Subtech mapSubtechDto(SubtechDto subtechDto) {
        return Subtech.builder().name(subtechDto.getName())
                .description(subtechDto.getDescription())
                .build();
    }*/
}
