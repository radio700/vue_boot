package vue.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import vue.demo.dto.TestDto;
import vue.demo.service.TestService;
import vue.demo.dto.LoginDTO;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class TestController {
	
	@Autowired
	TestService service;
	
    @GetMapping("/test")
    public Map<String, String> testConnection() {
    	System.out.println("@@@@@@@@@@@@@test@@@@@@@@@@@@@@@@@@@");
        Map<String, String> response = new HashMap<>(); 
        response.put("message", "Hello from Spring Boot!");
        return response;
    }
    
//    @PostMapping("path")
//    public String postMethodName(@RequestBody String entity) {
//        //TODO: process POST request
//        
//        return entity;
//    }


    @PostMapping(value = "/postProducts", consumes = "application/json")
    public ResponseEntity<?> postProducts (@RequestBody TestDto searchMap) throws Exception{
        System.out.println("dasf");
    	try {
    		System.out.println((searchMap.getColor()));
        	return ResponseEntity.ok(searchMap.getColor());
    	} catch(Exception e) {
    		System.out.println("에러"+e.getMessage());
    		return ResponseEntity.badRequest().body(Map.of("message","검색중오류")+e.getMessage());
    	}
    }

    
    @GetMapping("/getProducts")
    public ResponseEntity<?> getProducts (@RequestBody HashMap<String,Object> searchMap, HttpServletRequest request) throws Exception{
        Map<String, String> response = new HashMap<>(); 
        response.put("message", "Hello from Spring Boot!");
        System.out.println("searchMap 내용 " +(searchMap));
        System.out.println("@@@@@@@@@GET products@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return ResponseEntity.ok("테스트");
    }
    
    @GetMapping("/prjid")
    public String getPrjid() {
        Map<String, String> response = new HashMap<>(); 
        response.put("message", "Hello from Spring Boot!");
        System.out.println("@@@@@@@@@prjid@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    	return "List of productsqwer";
    }
    
    @PostMapping("/login")
    public String test(@RequestBody LoginDTO loginDTO) {
        System.out.println("id = " + loginDTO.getId());
        System.out.println("password = " + loginDTO.getPassword());
        return "Hello World";
    }
    
}
