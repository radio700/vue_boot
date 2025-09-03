package vue.demo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public Object getProduct(Map<String, Object> searchMap) {
		System.out.println("Service");
		return searchMap;
	}
}
