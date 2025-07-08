package com.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count {

	public String execute(String book) {
		//구현하세요
		book = book.replaceAll("[^a-zA-Z]", " ").toLowerCase();
		String[] words = book.split("\\s+");
		
		Map<String, Integer> map = new HashMap<>();
		
		for (String word : words) {
			if (word.isEmpty()) continue;
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		if (map.isEmpty()) {
			return ""; 
		}
		
		int max = Collections.max(map.values());
		
		List<String> list = new ArrayList<>();
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() == max){
				list.add(entry.getKey());
			}
		}
		
		Collections.sort(list);
		
		
		return list.get(0);
	}

 public static void main(String[] args) {
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		Count c = new Count();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));

	}

}
