package cn.joiner.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Validate {

	public static boolean mail(String mail){
		boolean isMatched=false;
		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,15}$";    
		Pattern regex = Pattern.compile(check);    
		Matcher matcher = regex.matcher(mail);    
	    isMatched = matcher.matches();    
		return isMatched;
		
	}
	
	public static boolean password(String password){
		boolean isMatched=false;
		String check = "^[a-z0-9_A-Z]{4,26}$";    
		Pattern regex = Pattern.compile(check);    
		Matcher matcher = regex.matcher(password);    
	    isMatched = matcher.matches();    
		return isMatched;
		
	}
	
	public static boolean username(String username){
		boolean isMatched=false;
		String check = "^[a-z0-9_A-Z]{2,26}$";    
		Pattern regex = Pattern.compile(check);    
		Matcher matcher = regex.matcher(username);    
	    isMatched = matcher.matches();    
		return isMatched;
	}
	
	public static boolean textLength(String text,int length){
		boolean flag=false;
		int txtLength = text.length();
		return length>=txtLength?true:false;
	}
	
	@Test
	public void test(){
		boolean mail = textLength("lishang@sina.coma",16);
		System.out.println(mail);
	}

}
