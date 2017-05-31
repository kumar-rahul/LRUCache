package com.zycus.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.zycus.model.Student;
import com.zycus.utility.LruUtility;

public class Service {
	
	public void init(){
		readFile();
	}
	private void createFile(){
//        System.out.println("createFile | Creating file");
		JSONArray list = new JSONArray();
        writeFile(list);
	}
	public JSONArray readFile(){
//        System.out.println("readFile | reading file");
        JSONParser parser = new JSONParser();
        JSONArray data=null;
        try {
	        	Object obj = parser.parse(new FileReader("..\\LRU\\resource\\test.json"));
	            JSONObject jsonObject = (JSONObject) obj;
//	            System.out.println(jsonObject);
	            data = (JSONArray) jsonObject.get("data");
//            Iterator<String> iterator = msg.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }

        } catch (FileNotFoundException e) {
		    System.out.println("File Not found");
		    createFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
	}
	public void writeFile(JSONArray list){
//        System.out.println("writeFile | writing to file");
        try (FileWriter file = new FileWriter("..\\LRU\\resource\\test.json")) {
    		JSONObject obj = new JSONObject();
            obj.put("data", list);
            file.write(obj.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.print(list);
	}
	public JSONObject createDataSet(Student student){
		student.setId(student.id+1);
		JSONObject obj = new JSONObject();
        obj.put("name", student.getName());
        obj.put("id", student.getId());

        JSONArray list = new JSONArray();
        for(int i=0;i<student.getClasses().size();i++){
        	JSONObject listObj = new JSONObject();
        	String[] str = student.getClasses().get(i).split(" ");
        	listObj.put("class", str[0]);
        	listObj.put("mark", str[1]);
        	list.add(listObj);
        }
//        list.add("sub1");
//        list.add("sub2");
//        list.add("sub3");

        obj.put("classes", list);
        JSONArray dataArray = readFile();
        dataArray.add(obj);
        writeFile(dataArray);
        return obj;
	}
	public void LRUCache(){
		System.out.println("Service | LRUCache");
		LruUtility lru= new LruUtility();
		 LinkedList<JSONObject> cache = lru.getLRUCache();
		for(int i=0;i<readFile().size();i++){
			System.out.println("File: "+readFile().get(i).getClass());
			if(cache.isEmpty()){
				cache.addFirst((JSONObject) readFile().get(i));
			}else{
				if(cache.getLast().equals((JSONObject) readFile().get(i))){
					cache.removeLast();
					cache.addFirst((JSONObject) readFile().get(i));
				}
				cache.addFirst((JSONObject) readFile().get(i));
			}
		}
		System.out.println("Cache: "+cache.get(0));
		System.out.println("Cache: "+cache.get(1));
		
		
	}
}
