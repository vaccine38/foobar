package main.java.find_the_access_codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

//	public static int solution3(int[] l) {
//		System.out.println(Arrays.toString(l));
//		int[] clone = Arrays.stream(l).toArray();
//		l = Arrays.stream(l).sorted().toArray();
//
//		Map<Integer, Set<Integer>> boisoMap = new HashMap<>();
//		for (int i = 0; i < l.length - 1; i++) {
//			int num = l[i];
//			for (int j = i + 1; j < l.length; j++) {
//				int boi = l[j];
//				if (boi % num == 0 && boi != num) {
//					if (boisoMap.containsKey(num)) {
//						boisoMap.get(num).add(boi);
//					} else {
//						Set<Integer> list = new HashSet<>();
//						list.add(boi);
//						boisoMap.put(num, list);
//					}
//				}
//			}
//		}
//		Map<Integer, Integer> countMap = new HashMap<>();
//		for (int i = 0; i < l.length; i++) {
//			int num = l[i];
//			if (countMap.containsKey(num)) {
//				countMap.put(num, countMap.get(num) + 1);
//			} else {
//				countMap.put(num, 1);
//			}
//		}
//
//		List<List<Integer>> results = new ArrayList<>();
//		for (Integer key : countMap.keySet()) {
//			if (countMap.get(key) > 2) { // 3 same numbers
//				results.add(Arrays.asList(key, key, key));
//			}
//		}
//		// 1, 1, 2, 2, 4, 4
//		// 112, 114, 122, 144, 124, 224, 244
//		for (Integer key : boisoMap.keySet()) {
//			if (boisoMap.get(key) == null) {
//				continue;
//			}
//
//			Set<Integer> boiso2 = boisoMap.get(key);
//			if (countMap.get(key) >= 2) { // 2 same number and 1 other
//				for (Integer boi : boiso2) {
//					results.add(Arrays.asList(key, key, boi));
//				}
//			}
//			for (Integer boi : boiso2) {
//				if (countMap.get(boi) >= 2) { // 1 other and 2 same number
//					results.add(Arrays.asList(key, boi, boi));
//				}
//				if (boisoMap.containsKey(boi)) { // 1 and 1 and 1
//					Set<Integer> boiso3 = boisoMap.get(boi);
//					for (Integer boi3 : boiso3) {
//						results.add(Arrays.asList(key, boi, boi3));
//					}
//				}
//			}
//		}
//
//		int count = 0;
//		for (List<Integer> result : results) {
//			// check order
//			int index = 0;
//			for (int cl : clone) {
//				if (cl == result.get(index)) {
//					index++;
//				}
//				if (index == 3) {
//					count++;
//					break;
//				}
//			}
//		}
//
//		return count;
//	}
//
//	public static int solution2(int[] l) {
//		System.out.println(Arrays.toString(l));
//		Set<String> set = new HashSet<>();
//		for (int i = 0 ; i < l.length - 1; i++) {
//			for (int j = i + 1; j < l.length; j++) {
//				if (l[j] % l[i] != 0) continue;
//				for (int k = j + 1; k < l.length; k++) {
//					String key = l[i] + "and" + l[j] + "and" + l[k];
//					if (l[k] % l[j] == 0 && !set.contains(key)) {
//						set.add(key);
//					}
//				}
//			}
//
//		}
//		return set.size();
//	}
	
	public static int solution(int[] l) {
		System.out.println(Arrays.toString(l));
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int num : l) {
			countMap.put(num, 0);
		}
		Map<Integer, String> uniqueMap = new HashMap<>();
		for (int i = 0; i < l.length; i++) {
			int countNumber = countMap.get(l[i]);
			uniqueMap.put(i, l[i] + "*" + countNumber);
			countMap.put(l[i], countNumber + 1);
		}
		
		Map<String, List<String>> boisoMap = new HashMap<>();
		for (int i = 0; i < l.length - 1; i++) {
			int num = l[i];
			for (int j = i + 1; j < l.length; j++) {
				int boi = l[j];
				if (boi % num == 0) {
					String fromKey = uniqueMap.get(i);
					String toKey = uniqueMap.get(j);
					boisoMap.computeIfAbsent(fromKey, k -> new ArrayList<>()).add(toKey);
				}
			}
		}
		
		Set<String> set = new HashSet<>();
		for (Map.Entry<String, List<String>> entry : boisoMap.entrySet()) {
			if (entry.getValue() == null || entry.getValue().isEmpty()) {
				continue;
			}
			
			for (String boi2 : entry.getValue()) {
				if (boisoMap.containsKey(boi2)) {
					List<String> boiso3 = boisoMap.get(boi2);
					for (String boi3 : boiso3) {
						String tripletString = tupleToString(entry.getKey(), boi2, boi3);
						set.add(tripletString);
					}
				}
			}
		}
		return set.size();
	}
	
	private static String tupleToString(String num, String boi2, String boi3) {
		int numInt = Integer.parseInt(num.split("\\*")[0]);
		int boi2Int = Integer.parseInt(boi2.split("\\*")[0]);
		int boi3Int = Integer.parseInt(boi3.split("\\*")[0]);
		return numInt + "and" + boi2Int + "and" + boi3Int;
	}

//	public static int solution(int[] l) {
//		System.out.println(Arrays.toString(l));
//		l = Arrays.stream(l).sorted().toArray();
//
//		List<Integer> clone = new ArrayList<>();
//		Map<Integer, Integer> countMap = new HashMap<>();
//		Set<Integer> cloneSet = new HashSet<>();
//		for (int num : l) {
//			countMap.compute(num, (k, v) -> (v == null) ? 1 : v + 1);
//			if (!cloneSet.contains(num)) {
//				clone.add(num);
//				cloneSet.add(num);
//			}
//		}
//
//		Map<Integer, List<Integer>> boisoMap = new HashMap<>();
//		for (int i = 0; i < clone.size() - 1; i++) {
//			int num = clone.get(i);
//			for (int j = i + 1; j < clone.size(); j++) {
//				int boi = clone.get(j);
//				if (boi % num == 0) {
//					boisoMap.computeIfAbsent(num, k -> new ArrayList<>()).add(boi);
//				}
//			}
//		}
//
//		int count = 0;
//		for (Integer key : countMap.keySet()) {
//			if (countMap.get(key) > 2) { // 3 same numbers
//				count++;
//			}
//		}
//
//		for (Integer key : boisoMap.keySet()) {
//			if (boisoMap.get(key) == null) {
//				continue;
//			}
//
//			List<Integer> boiso2 = boisoMap.get(key);
//			if (countMap.get(key) >= 2) { // 2 same number and 1 other
//				count += boiso2.size();
//			}
//			for (Integer boi2 : boiso2) {
//				if (countMap.get(boi2) >= 2) { // 1 other and 2 same number
//					count++;
//				}
//				if (boisoMap.containsKey(boi2)) { // 1 and 1 and 1
//					List<Integer> boiso3 = boisoMap.get(boi2);
//					count += boiso3.size();
//				}
//			}
//		}
//		return count;
//	}

//	public static int solution(int[] l) {
//		int[] c = new int[l.length];
//		for (int i = 0; i < l.length; i++) {
//			c[i] = 0;
//		}
//
//		int nbTriples = 0;
//		for (int k = 0; k < l.length - 1; k++) {
//			for (int j = 0; j < k - 1; j++) {
//				if (l[k] % l[j] == 0) {
//					c[k]++;
//					nbTriples += c[j];
//				}
//			}
//		}
//
//		return nbTriples;
//	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(solution(new int[] {1, 1, 1, 2, 2, 2, 2}));
		System.out.println(solution(new int[] {1, 2}));
		System.out.println(solution(new int[] {1, 2, 3, 5, 7}));
		System.out.println(solution(new int[] {1, 2, 4, 6, 12}));
		System.out.println(solution(new int[] {1, 1, 2}));
		System.out.println(solution(new int[] {1, 2, 3, 4, 5, 6}));
		System.out.println(solution(new int[] {1, 1, 2, 2, 4, 4}));
		System.out.println(solution(new int[] {2, 1, 1}));
		System.out.println(solution(new int[] {2, 2, 2, 3, 4, 4}));
		System.out.println(solution(new int[] {4, 5, 2, 8, 5, 9, 2, 2, 7, 1}));
		System.out.println(solution(new int[] {1, 2, 4, 8}));
		System.out.println(
			solution(new int[] {7, 4, 2, 15, 14, 11, 10, 1, 13, 3, 6, 4, 12, 15, 5, 11}));
		int[] l = new int[2000];
		for (int i = 0; i < 2000; i++) {
			l[i] = i == 0 ? 1 : i;
		}
		System.out.println(solution(l));
		System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
	}
}

