package main.java.elevator_maintenance;

import java.util.Arrays;

public class Solution {
	
	public static String[] solution(String[] l) {
		return Arrays.stream(l)
			.map(Version::new)
			.sorted(Version::compare)
			.map(Version::getVersion)
			.toArray(String[]::new);
	}
	
	public static class Version {
		Integer major;
		Integer minor;
		Integer revision;
		String version;
		
		public String getVersion() {
			return version;
		}
		
		public Version(String version) {
			this.version = version;
			String[] split = version.split("\\.");
			this.major = Integer.valueOf(split[0]);
			this.minor = split.length > 1 ? Integer.parseInt(split[1]) : -1;
			this.revision = split.length > 2 ? Integer.parseInt(split[2]) : -1;
		}
		
		public int compare(Version v) {
			if (this.major.compareTo(v.major) != 0) {
				return this.major.compareTo(v.major);
			} else if (this.minor.compareTo(v.minor) != 0) {
				return this.minor.compareTo(v.minor);
			} else if (this.revision.compareTo(v.revision) != 0) {
				return this.revision.compareTo(v.revision);
			}
			return 0;
		}
	}
	
	public static void main(String[] args) {
		String[] tc1 = {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"};
		System.out.println(Arrays.toString(solution(tc1)));
	}
}
