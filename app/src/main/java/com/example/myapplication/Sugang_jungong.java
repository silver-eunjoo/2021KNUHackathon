package com.example.myapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sugang_jungong {

	private ArrayList<String> jungong_code;
	private ArrayList<String> jungong_name;
	
	public Sugang_jungong() {
		jungong_code = new ArrayList<String>();
		jungong_name = new ArrayList<String>();
		
		//파일 경로 조정필요
		String currentProjPath = "/Users/silver/AndroidStudioProjects";
		try {
			currentProjPath = new File(".").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String currentFilePath = currentProjPath + "/new_jungong.txt";
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
			jungong_code.add(words[0]);
			jungong_name.add(words[1]);
		}
	}
	
	public ArrayList<String> get_jungong_code() {
		return jungong_code;
	}
	
	public ArrayList<String> get_jungong_name() {
		return jungong_name;
	}

	public static void main(String[] args) {
		Sugang_jungong gy = new Sugang_jungong();
		
		for (String words : gy.get_jungong_name())
			System.out.println(words);
	}
}
