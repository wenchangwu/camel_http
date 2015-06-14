package dozer.util;

import org.dozer.CustomConverter;

import dozer.dto.Gender;

public class EnumIntConverter implements CustomConverter{

	@Override
	public Object convert(Object dest, Object source, Class<?> class1,
			Class<?> class2) {
		if (source == null) {
			return null;
		}else{
			Integer i=(Integer)source;
			if(i==0){
				return Gender.male;
			}else if(i==1){
				return Gender.female;
			}else{
				return null;
			}
		}
		
	}

}
