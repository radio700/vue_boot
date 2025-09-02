package vue.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;

@RestController
public class TestController {

    @GetMapping("/test")
    public Map<String, String> testConnection() {
    	System.out.println("@@@@@@@@@@@@@test@@@@@@@@@@@@@@@@@@@");
        Map<String, String> response = new HashMap<>(); 
        response.put("message", "Hello from Spring Boot!");
        return response;
    }
    
    
    
    
    @GetMapping("/products")
    public String getProducts() {
        Map<String, String> response = new HashMap<>(); 
        response.put("message", "Hello from Spring Boot!");
        System.out.println("@@@@@@@@@products@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    	return "List of products";
    }
    
    @GetMapping("/prjid")
    public String getPrjid() {
        Map<String, String> response = new HashMap<>(); 
        response.put("message", "Hello from Spring Boot!");
        System.out.println("@@@@@@@@@prjid@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    	return "List of productsqwer";
    }
    
}
