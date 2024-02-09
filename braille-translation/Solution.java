import java.util.HashMap;

public class Solution {
	
	public static void main(String[] args) {
		String t1 = solution("code");
		System.out.println(t1);
		System.out.println("100100101010100110100010".equals(t1));
		
		String t2 = solution("The quick brown fox jumps over the lazy dog");
		System.out.println(t2);
		System.out.println("000001011110110010100010000000111110101001010100100100101000000000110000111010101010010111101110000000110100101010101101000000010110101001101100111100011100000000101010111001100010111010000000011110110010100010000000111000100000101011101111000000100110101010110110".equals(t2));
		
		String t3 = solution("Braille");
		System.out.println(t3);
		System.out.println("000001110000111010100000010100111000111000100010".equals(t3));
	}
	
	public static String solution(String s) {
		HashMap<String, String> encryptMap = new HashMap<>();
		encryptMap.put("a", "100000");
		encryptMap.put("b", "110000");
		encryptMap.put("c", "100100");
		encryptMap.put("d", "100110");
		encryptMap.put("e", "100010");
		encryptMap.put("f", "110100");
		encryptMap.put("g", "110110");
		encryptMap.put("h", "110010");
		encryptMap.put("i", "010100");
		encryptMap.put("j", "010110");
		encryptMap.put("k", "101000");
		encryptMap.put("l", "111000");
		encryptMap.put("m", "101100");
		encryptMap.put("n", "101110");
		encryptMap.put("o", "101010");
		encryptMap.put("p", "111100");
		encryptMap.put("q", "111110");
		encryptMap.put("r", "111010");
		encryptMap.put("s", "011100");
		encryptMap.put("t", "011110");
		encryptMap.put("u", "101001");
		encryptMap.put("v", "111001");
		encryptMap.put("w", "010111");
		encryptMap.put("x", "101101");
		encryptMap.put("y", "101111");
		encryptMap.put("z", "101011");
		encryptMap.put(" ", "000000");
		
		StringBuilder result = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isUpperCase(c)) {
				result.append("000001");
			}
			result.append(encryptMap.get(String.valueOf(c).toLowerCase()));
		}
		return result.toString();
	}
}

