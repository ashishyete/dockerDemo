package com.app.microservice;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DockerDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void add() {
		int x =10;
		int y =10;
		System.out.println("Running test for add");
		assertTrue(x==y);
	}
}
