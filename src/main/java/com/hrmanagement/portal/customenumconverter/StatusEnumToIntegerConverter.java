package com.hrmanagement.portal.customenumconverter;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import com.hrmanagement.portal.model.User.Status;

public class StatusEnumToIntegerConverter implements Converter<Status, Integer> {

    @Override
    public Integer convert(MappingContext<Status, Integer> context) {
        
    	if (context.getSource() == null) {
            return null;
        }

        // Map the Status enum to its ordinal value (an integer)
        return context.getSource().ordinal();
    }
}
