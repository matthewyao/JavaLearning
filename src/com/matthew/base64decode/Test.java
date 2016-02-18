package com.matthew.base64decode;

import java.io.IOException;

import com.allyes.carpenter.CarpenterLogs;

import sun.misc.BASE64Decoder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "CIm8uLQFEAQaA2lmYyAAKhNDbGt0cjJ1a04wQlRleGIxNHREMgsyNy4xOTIuOC42MTrGAmh0dHA6Ly9pZGlnZ2VyLnF0bW9qby5jb20vbWFpbi9hZGZ0cmFjaz9sdD1pJmRiPWlmYyZhbz1ULTAwMDEzMC0wMSZ0YWc9JmVjPSZlYT0mZWw9JmV2PSZvYz0mc2U9Jmt3PSZjdGQ9JmFjdj1jb252dHlwZSU3Qztjb252YWN0aW9uJTdDO2NvbnZpZCU3Qztjb252dmFsdWUlN0MmZWNtPTYwNDUxNTMwMDAlNjAlNjAlNjAlNjAlNjAlNjAlNjAlNjAlNjAlNjAlNjAlNjAlNjAmdGt2PSZjY3Q9MTQ1MDk3MjkzNCZzYz00Jm52PTAmaG49Yy5tLnN1bmluZy5jb20mcHU9JTJGY2hhbm5lbCUyRm5pYW5odW8uaHRtbCZyZj0mZ3BhPWlqM3o4MDI2YjM1NXQmcj0xNDUyMTU0Mzc2NTM1QipodHRwOi8vYy5tLnN1bmluZy5jb20vY2hhbm5lbC9uaWFuaHVvLmh0bWxKpgFNb3ppbGxhLzUuMChMaW51eDsgVTtTTkVCVVktQVBQO1NORUJVWS1BUFAgMTEwO1NOQ0xJRU5ULVdBUDsgQW5kcm9pZCA0LjIuMjsgemg7IEhVQVdFSSBHNzUwLVQwMSkgQXBwbGVXZWJLaXQvNTMzLjAgKEtIVE1MLCBsaWtlIEdlY2tvKSBWZXJzaW9uLzQuMCBNb2JpbGUgU2FmYXJpLzUzMy4xUgx6aC1DTiwgZW4tVVNaAGIAagByATB6AIIBAIgBAJABAJoBATCgAdeMFKoBB2lEaWdnZXKyAQC4AQDCAQDKAQDSAQDYAQDiAQDqAQDyAQD6AQCiBg5kZS41LjIzLmlkLnNqY6oGOS93d3cvYWxseWVzL2RlL2xvZ3MvZGVfbG9nLmlmYy4yMDE2LTAxLTA3LjE2LjEwLjI4LjUuMjMuNLAGzKkG";
		try {
			byte[] b = new BASE64Decoder().decodeBuffer(str);
			System.out.println(b);
			CarpenterLogs.RawLog rawLog = CarpenterLogs.RawLog.parseFrom(b);
			System.out.println(rawLog.getAllyesId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
