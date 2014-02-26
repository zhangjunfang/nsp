package com.mkyong.regex;
 
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
 
public class DomainNameValidatorTest {
 
	private DomainNameValidator domainNameValidator;
 
	@BeforeClass
	public void initData() {
	  domainNameValidator = new DomainNameValidator();
	}
	@DataProvider
	public Object[][] ValidDomainNameProvider() {
	  return new Object[][] { { new String[] { "yahoo.com", "facebook.com",
		"google.to.cc", "mkyong-info.com", "mkyong.com.au",
		"verdi.com.my", "google.t.co", "google.t.t.co", "abc.99.com",
		"abc.mkyong-info.com", "abc-123.mkyong-99b.com.my" } } };
	}
 
	@DataProvider
	public Object[][] InvalidDomainNameProvider() {
	  return new Object[][] { { new String[] { "123,345.com", "mkyong",
		"mkyong.com.abcdefg123", ".com.my", "gmail.a", ".com",
		"%*.com", "youtube.com/users/abc", "google.t.t.t" } } };
	}
 
	@Test(dataProvider = "ValidDomainNameProvider")
	public void ValidDomainNameTest(String[] domainName) {
 
	  for (String temp : domainName) {
		boolean valid = domainNameValidator.validate(temp);
		System.out.println("Valid domain name : " + temp);
		Assert.assertEquals(valid, true);
	  }
 
	}
 
	@Test(dataProvider = "InvalidDomainNameProvider", 
                             dependsOnMethods = "ValidDomainNameTest")
	public void InValidDomainNameTest(String[] domainName) {
 
	  for (String temp : domainName) {
		boolean valid = domainNameValidator.validate(temp);
		System.out.println("Invalid domain name : " + temp);
		Assert.assertEquals(valid, false);
	  }
	}
}