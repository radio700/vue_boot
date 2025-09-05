package vue.demo.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import vue.demo.dto.TestDto;

@Service
public class TestService {

	public Object postProduct(TestDto testDto) {
        System.out.println("service~~");
        System.out.println("testDto = " + testDto);
		return testDto;
	}
}
