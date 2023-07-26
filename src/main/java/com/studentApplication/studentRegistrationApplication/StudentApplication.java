package com.studentApplication.studentRegistrationApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("asdasd");
		TimeUnit.SECONDS.sleep(30);
		SpringApplication.run(StudentApplication.class, args);

    }


}
