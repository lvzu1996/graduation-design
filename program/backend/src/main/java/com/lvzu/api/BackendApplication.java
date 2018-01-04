package com.lvzu.api;

import com.lvzu.mapper.ClassMapper;
import com.lvzu.tables.Class;
import com.sun.tools.javac.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.neo.mapper")
public class BackendApplication {
	private ClassMapper classMapper;

	public static void main(String[] args)
	{
		SpringApplication.run(BackendApplication.class, args);
	}

	@RequestMapping(value = "/",produces = "text/plain;charset=UTF-8")
	String index(){
		List<Class> classed = classMapper.getAll();

		return String.valueOf(classed.size());
	}

}
