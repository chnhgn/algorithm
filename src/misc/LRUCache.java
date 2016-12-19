package misc;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(6);
		cache.add(11,"Rooney");
		cache.add(12, "Ding");
		cache.add(13, "Mark");
		cache.add(14, "John");
		cache.add(15, "Shawn");
		cache.add(16, "Liang");
		
		cache.get(16);
		cache.get(12);
		cache.add(1, "Selby");
		
		for (int key : cache.list) {
			System.out.println(key);
		}
		
	}

	private int capacity = 0;
	
	public LinkedList<Integer> list = new LinkedList<Integer>();		// Remember the cache key order
	
	private HashMap<Integer, String> map = new HashMap<Integer, String>();	// Use a map to access the element very fast
	
	public LRUCache(int initCapacity) {
		this.capacity = initCapacity;
	}
	
	public void add(int key, String value) {
		if (list.size() == capacity) {		// Cache is full
			map.remove(list.getLast());
			list.removeLast();
			list.addFirst(key);
			map.put(key, value);
		} else {
			list.addFirst(key);
			map.put(key, value);
		}
	}
	
	public String get(int key){
		if (!map.containsKey(key)) {
			return null;
		}
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == key) {
				index = i;
				break;
			}
		}
		list.remove(index);
		list.addFirst(key);
		
		return map.get(key);
	}
}
