package com.robertleitner.techblog.mapper;

import com.robertleitner.techblog.dto.SubtechDto;
import com.robertleitner.techblog.model.Post;
import com.robertleitner.techblog.model.Subtech;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubtechMapper {

    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subtech.getPosts()))")
    SubtechDto mapSubtechToDto(Subtech subtech);

    default Integer mapPosts(List<Post> numberOfPosts) {return numberOfPosts.size(); }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subtech mapDtoToSubtech(SubtechDto subtechDto);
}
