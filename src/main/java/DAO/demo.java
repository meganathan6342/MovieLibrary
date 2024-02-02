package DAO;

import java.util.Properties;

public class demo {

	public static void main(String[] args) {
		Properties p = new Properties();
        p.put("a", "mega");
        p.put("b", "nathan");
        
        System.out.println(p.getProperty("a"));
        System.out.println(p.getProperty("b"));
	}
}
