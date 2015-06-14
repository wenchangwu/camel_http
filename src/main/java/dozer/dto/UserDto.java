package dozer.dto;

public class UserDto {

	private int id;
	private String name;
	private String password;
	private InfoDto info;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public InfoDto getInfo() {
		return info;
	}
	public void setInfo(InfoDto info) {
		this.info = info;
	}
	
	
}
