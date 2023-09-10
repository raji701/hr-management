package com.hrmanagement.portal.customenumconverter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import com.hrmanagement.portal.model.PersonalDetails.MaritalStatus;

public class MaritalStatusEnumToIntegerConverter implements Converter<MaritalStatus,Integer>{

	public Integer convert(MappingContext<MaritalStatus,Integer> context)
	{
		if(context.getSource()== null)
		{
			return null;
		}
		
		// Map the MaritalStatus enum to its ordinal value (an integer)
		return context.getSource().ordinal();
	}
}
