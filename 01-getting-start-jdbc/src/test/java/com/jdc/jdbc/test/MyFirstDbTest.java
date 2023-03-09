package com.jdc.jdbc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.demo.database.ConnectionManager;
import com.demo.database.MyFirstDb;

@TestMethodOrder(OrderAnnotation.class)
class MyFirstDbTest {
	
	
	@BeforeAll
	static void initTest() {
		System.out.println("Befor All :: Init Test");
	}
	
	@AfterAll
	static void afterInitTest() {
		System.out.println("After All :: After Init Test");
	}
	
	@BeforeEach
	void beforeEachTest() {
		System.out.println("Before Each Test.");
	}
	
	@AfterEach
	void afterEachTest() {
		System.out.println("After Each Test.");
	}

	@Test
	@Order(2)
	void courseCountTest() {
		var fdb = new MyFirstDb(ConnectionManager.getInstance());	
		var result = fdb.getPostCount();
		assertEquals(5, result);
		
		System.out.println("Course Count Test :: Order 2");
	}
	
	@Test
	@Order(1)
	void allCourseTest() {
		System.out.println("All Course Test :: Order 1");
	}
	
	@Test
	@Order(3)
	void deleteCourseTest() {
		System.out.println("Delete Course :: Order 3");
	}
  
}
