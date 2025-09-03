package vue.demo.dto;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class LoginDTO {
    private String id;
    private String password;
    
    public String getId() {
    	return id;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setId(String id) {
    	this.id = id;
    }
    public void setPassWord(String password) {
    	this.password = password;
    }
    
}
