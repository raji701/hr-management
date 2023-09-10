package com.hrmanagement.portal.customenumconverter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import com.hrmanagement.portal.model.PersonalDetails.BloodGroup;

public class BloodGroupEnumToIntegerConverter implements Converter<BloodGroup, Integer> {

	@Override
	public Integer convert(MappingContext<BloodGroup, Integer> value) {

		if (value.getSource() == null) {
			return null;
		}

		// Map the Status enum to its ordinal value (an integer)
		return value.getSource().ordinal();

	}

}
