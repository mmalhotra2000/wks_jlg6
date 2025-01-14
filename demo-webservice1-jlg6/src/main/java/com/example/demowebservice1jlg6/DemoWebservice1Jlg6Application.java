package com.example.demowebservice1jlg6;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class DemoWebservice1Jlg6Application implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoWebservice1Jlg6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// seed data
		// case study please sample date for some products
		// 2 emp
		Employee employee1 = new Employee("abc", "bcd");
		Employee employee2 = new Employee("xyz", "qwe");

		//
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);

	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

}
