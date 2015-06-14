package dozer.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dozer.dto.UserDto;
import dozer.vo.Info;
import dozer.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring/ctx_component_test.xml" })
public class DozerTest {

	@Resource
	private MyDozerMapper myDozerMapper;

	@Test
	public void testDozer() {

		User user =new User();
		user.setId(1);
		user.setPassword("wwc5201314");
		user.setUserName("xiao_dingo");
		
		Info info=new Info();
		info.setDate("2012-03-22");
		info.setId(1);
		info.setGender(0);
		user.setInfo(info);
		
		
		UserDto userDto=(UserDto) myDozerMapper.mapper(user, UserDto.class);
		System.out.println(userDto);
		
		
		User user2=(User)myDozerMapper.mapper(userDto, User.class);
		System.out.println(user2);
	}
	
	@Test
	public void test(){
	}
	
	
	private String test2() throws Exception{
		 String s="222";
		 
		throw new Exception();
		 
	}

}
