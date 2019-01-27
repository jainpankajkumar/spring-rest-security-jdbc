package com.learning.security.jdbc;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
public static void main(String[] args) {
	String encoded=new BCryptPasswordEncoder().encode("abc");
	System.out.println(encoded);
}
}
