package com.hrmanagement.portal.customenumconverter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import com.hrmanagement.portal.model.ProjectDetails.ProjectStatus;

public class ProjectStatusEnumToIntegerConverter implements Converter<ProjectStatus,Integer> {

	@Override
	public Integer convert(MappingContext<ProjectStatus, Integer> context) {
		
		if (context.getSource() == null) {
			return null;
		}

		// Map the Status enum to its ordinal value (an integer)
		return context.getSource().ordinal();
	}

}
