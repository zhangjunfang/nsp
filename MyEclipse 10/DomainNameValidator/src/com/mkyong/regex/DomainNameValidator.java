package com.mkyong.regex;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class DomainNameValidator {
 
	private Pattern pattern;
	private Matcher matcher;
 
	private static final String  
	  DOMAIN_NAME_PATTERN = "^[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
 
	public DomainNameValidator() {
		pattern = Pattern.compile(DOMAIN_NAME_PATTERN);
	}
 
	public boolean validate(final String hex) {
 
		matcher = pattern.matcher(hex);
		return matcher.matches();
 
	}
}