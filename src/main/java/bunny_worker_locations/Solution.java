package main.java.bunny_worker_locations;

public class Solution {
	
	public static String solution(long x, long y) {
		long diagonal = x + y - 1;
		long start = 0;
		int index = 0, finalIndex = 0;
		for (long i = 1; i <= diagonal; i++) {
			if (i != diagonal) {
				start += i;
			} else {
				start++;
			}
			long yIndex = diagonal - i + 1;
			if (i == x && yIndex == y) {
				finalIndex = index;
			}
			index++;
		}
		return String.valueOf(start + finalIndex);
	}
	
	public static void main(String[] args) {
		System.out.println(solution(3, 2));
		System.out.println(solution(5, 10));
	}
}
