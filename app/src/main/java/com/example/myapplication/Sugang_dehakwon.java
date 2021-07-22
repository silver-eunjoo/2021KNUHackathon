package com.example.myapplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sugang_dehakwon {

	private ArrayList<String> dehakwon_code;
	private ArrayList<String> dehakwon_name;


	public Sugang_dehakwon() {
		dehakwon_code = new ArrayList<String>();
		dehakwon_name = new ArrayList<String>();
		
		//파일 경로 조정필요
		String currentProjPath = "";
		try {
			currentProjPath = new File(".").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String currentFilePath = currentProjPath + "/app/sugang/new_dehakwon.txt";
		///Users/silver/AndroidStudioProjects/new_dehakwon.txt
		
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
			dehakwon_code.add(words[0]);
			dehakwon_name.add(words[1]);
		}
	}
	
	public ArrayList<String> get_dehakwon_code() {
		return dehakwon_code;
	}
	
	public ArrayList<String> get_dehakwon_name() {
		return dehakwon_name;
	}

	public String get_dehakwon_code(int count) {
		return dehakwon_code.get(count);
	}

	public String get_dehakwon_name(int count) {
		return dehakwon_name.get(count);
	}

	public static void main(String[] args) {
		Sugang_dehakwon gy = new Sugang_dehakwon();
		
		for (String words : gy.get_dehakwon_name())
			System.out.println(words);
	}

}
