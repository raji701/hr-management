package com.hrmanagement.portal.customenumconverter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import com.hrmanagement.portal.model.Position.PositionName;

public class PositionNameEnumToIntegerConverter implements Converter<PositionName ,Integer>{

	public Integer convert(MappingContext<PositionName,Integer> context)
	{
		if(context.getSource()== null)
		{
			return null;
		}
		
		return context.getSource().ordinal();
	}
}
