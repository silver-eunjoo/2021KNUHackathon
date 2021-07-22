package com.example.myapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sugang_wongyuk {

	private ArrayList<String> wongyuk_code;
	private ArrayList<String> wongyuk_name;
	
	public Sugang_wongyuk() {
		wongyuk_code = new ArrayList<String>();
		wongyuk_name = new ArrayList<String>();
		
		//파일 경로 조정필요
		String currentProjPath = "/Users/silver/AndroidStudioProjects";
		try {
			currentProjPath = new File(".").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String currentFilePath = currentProjPath + "/new_wongyuk.txt";
		//
		
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(currentFilePath));
		} catch (FileNotFoundException e){
			e.printStackTrace();
			System.exit(0);
		}
		
		while(inputStream.hasNext()) {
			String sentence = inputStream.nextLine();
			String[] words = sentence.split(" ", 2);
			wongyuk_code.add(words[0]);
			wongyuk_name.add(words[1]);
		}
	}
	
	public ArrayList<String> get_wongyuk_code() {
		return wongyuk_code;
	}
	
	public ArrayList<String> get_wongyuk_name() {
		return wongyuk_name;
	}
	
	public static void main(String[] args) {
		Sugang_wongyuk gy = new Sugang_wongyuk();
		
		for (String words : gy.get_wongyuk_name())
			System.out.println(words);
	}

}
