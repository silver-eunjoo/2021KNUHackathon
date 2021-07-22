package com.example.myapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sugang_won_a {

	private ArrayList<String> won_a_code;
	private ArrayList<String> won_a_name;
	
	public Sugang_won_a() {
		won_a_code = new ArrayList<String>();
		won_a_name = new ArrayList<String>();
		
		//파일 경로 조정필요
		String currentProjPath = "/Users/silver/AndroidStudioProjects";
		try {
			currentProjPath = new File(".").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String currentFilePath = currentProjPath + "/new_won_a.txt";
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
			won_a_code.add(words[0]);
			won_a_name.add(words[1]);
		}
	}
	
	public ArrayList<String> get_won_a_code() {
		return won_a_code;
	}
	
	public ArrayList<String> get_won_a_name() {
		return won_a_name;
	}
	
	public static void main(String[] args) {
		Sugang_won_a gy = new Sugang_won_a();
		
		for (String words : gy.get_won_a_name())
			System.out.println(words);
	}

}
