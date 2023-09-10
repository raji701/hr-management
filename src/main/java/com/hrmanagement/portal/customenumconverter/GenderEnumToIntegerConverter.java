package com.hrmanagement.portal.customenumconverter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import com.hrmanagement.portal.model.PersonalDetails.Gender;

public class GenderEnumToIntegerConverter implements Converter<Gender,Integer> {
	
	public Integer convert(MappingContext<Gender,Integer> context)
	{
		if(context.getSource()== null)
		{
			return null;
		}
		
		// Map the Gender enum to its ordinal value (an integer)
		return context.getSource().ordinal();
	}

}
