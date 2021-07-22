package com.example.myapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sugang_gyoyang {
	
	private ArrayList<String> gyoyang_code;
	private ArrayList<String> gyoyang_name;
	
	public Sugang_gyoyang() {
		gyoyang_code = new ArrayList<String>();
		gyoyang_name = new ArrayList<String>();
		
		//파일 경로 조정필요
		String currentProjPath = "";
		try {
			currentProjPath = new File(".").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String currentFilePath = currentProjPath + "/app/sugang/new_gyoyang.txt";
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
			gyoyang_code.add(words[0]);
			gyoyang_name.add(words[1]);
		}
	}
	
	public ArrayList<String> get_gyoyang_code() {
		return gyoyang_code;
	}
	
	public ArrayList<String> get_gyoyang_name() {
		return gyoyang_name;
	}
	
	public static void main(String[] args) {
		Sugang_gyoyang gy = new Sugang_gyoyang();
		
		for (String words : gy.get_gyoyang_name())
			System.out.println(words);
	}
}
