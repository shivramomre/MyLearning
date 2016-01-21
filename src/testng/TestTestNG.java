package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestTestNG {
	
	@DataProvider(name = "dp", parallel = false) //indices
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	      new Object[] { 3, "c" },
	      new Object[] { 4, "d" },
	    };
	  }
	
	@DataProvider()
	public Iterator<Object[]> dp1()
	{
		
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[]{"Hello"});
		list.add(new Object[]{"World"});
		list.add(new Object[]{"Sachin"});
		return list.iterator();
	}
	
  @Test(dataProvider = "dp")
  public void f1(Integer n, String s) {
	  
  }
  
  @Test(dataProvider = "dp1")
  public void f2(String in)
  {
	  System.out.println(in);
  }
  
  @Test
  public void f3()
  {
	  
  }
  @BeforeGroups
  public void beforeGroups()
  {
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Executing before method.");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Executing after method.");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Executing before class.");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Executing after class.");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Executing before test.");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Executing after test.");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Executing before suite.");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Executing after suite.");
  }

}
