package com.hrmanagement.portal.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hrmanagement.portal.customenumconverter.BloodGroupEnumToIntegerConverter;
import com.hrmanagement.portal.customenumconverter.GenderEnumToIntegerConverter;
import com.hrmanagement.portal.customenumconverter.MaritalStatusEnumToIntegerConverter;
import com.hrmanagement.portal.customenumconverter.PositionNameEnumToIntegerConverter;
import com.hrmanagement.portal.customenumconverter.StatusEnumToIntegerConverter;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        
        ModelMapper modelMapper = new ModelMapper();
        // Configure ModelMapper settings as needed
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Register custom converters
        modelMapper.addConverter(new StatusEnumToIntegerConverter());
        
        modelMapper.addConverter(new BloodGroupEnumToIntegerConverter());
        
        modelMapper.addConverter(new GenderEnumToIntegerConverter());
        
        modelMapper.addConverter(new MaritalStatusEnumToIntegerConverter());
        
        modelMapper.addConverter(new PositionNameEnumToIntegerConverter());
        
        return modelMapper;
    }
}