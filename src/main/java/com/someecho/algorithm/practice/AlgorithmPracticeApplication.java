package com.someecho.algorithm.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmPracticeApplication {

	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		obj.wait();
		obj.notify();
		obj.notifyAll();
		System.gc();
	}
	
	
	//	SpringApplication.run(AlgorithmPracticeApplication.class, args);

}
