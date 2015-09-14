package camel.bean;

public class HelloBean {

	public String hello(String name) {
			int i=5/0;
		return "HELLO" + name;
	}
	
	public String validate(String name){
		return "validate"+name;
	}

}
