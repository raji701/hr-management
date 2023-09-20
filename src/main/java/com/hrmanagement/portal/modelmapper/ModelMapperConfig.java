package com.hrmanagement.portal.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hrmanagement.portal.customenumconverter.BloodGroupEnumToIntegerConverter;
import com.hrmanagement.portal.customenumconverter.GenderEnumToIntegerConverter;
import com.hrmanagement.portal.customenumconverter.MaritalStatusEnumToIntegerConverter;
<<<<<<< HEAD
import com.hrmanagement.portal.customenumconverter.ProjectStatusEnumToIntegerConverter;
=======

>>>>>>> abbe14ff11cf9c3feb8937e9cc5d3c05104a3279
import com.hrmanagement.portal.customenumconverter.StatusEnumToIntegerConverter;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        
        ModelMapper modelMapper = new ModelMapper();
        // Configure ModelMapper settings as needed
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        // Register custom converters
        
        modelMapper.addConverter(new ProjectStatusEnumToIntegerConverter());
        
        modelMapper.addConverter(new StatusEnumToIntegerConverter());
        
        modelMapper.addConverter(new BloodGroupEnumToIntegerConverter());
        
        modelMapper.addConverter(new GenderEnumToIntegerConverter());
        
        modelMapper.addConverter(new MaritalStatusEnumToIntegerConverter());
        
        
        
        return modelMapper;
    }
}