package dozer.service;

import org.dozer.Mapper;

public class MyDozerMapperImpl implements MyDozerMapper {

	private Mapper mapper;

	public Mapper getMapper() {
		return mapper;
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Object mapper(Object src, Object dest) {
		if (src != null) {
			return mapper.map(src, (Class) dest);
		} else {
			return null;
		}

	}
}
