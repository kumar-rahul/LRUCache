package com.zycus.utility;

import java.util.LinkedList;

import org.json.simple.JSONObject;

public class LruUtility {

	private int queueLength;
	private LinkedList<JSONObject> LRUCache;
	
	public LruUtility(){
		this.setQueueLength(20);
		LRUCache = new LinkedList<JSONObject>();
	}

	public int getQueueLength() {
		return queueLength;
	}
	public void setQueueLength(int queueLength) {
		this.queueLength = queueLength;
	}
	public LinkedList<JSONObject> getLRUCache() {
		return LRUCache;
	}
//	public void setLRUCache(LinkedList<String> lRUCache) {
//		LRUCache = lRUCache;
//	}

}
