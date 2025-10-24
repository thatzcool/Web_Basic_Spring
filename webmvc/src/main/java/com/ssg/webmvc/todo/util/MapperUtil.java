package com.ssg.webmvc.todo.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

public enum MapperUtil {
    INSTANCE;

    private ModelMapper modelMapper;

    MapperUtil() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }
    public ModelMapper get() {
        return modelMapper;
    }


}
