package com.zycus.model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Student {
	public static int id = new Integer(0);
	private String name;
	private String className;
	private String classMarks;
	private ArrayList<String> classes;


	public Student(){
		this.classes = new ArrayList<String>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassMarks() {
		return classMarks;
	}
	public void setClassMarks(String classMarks) {
		this.classMarks = classMarks;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public ArrayList<String> getClasses() {
		return classes;
	}
	public void setClasses(ArrayList<String> classes) {
		this.classes = classes;
	}
}
