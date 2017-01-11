
public class Main {

	// Implement an algorithm to determine if a string has all unique characters
	// What if you can not use additional data structures?
	static boolean isUniqueString(String s) {

		char[] charArray = s.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			for (int j = 0; j < charArray.length; j++) {
				if (i != j && charArray[i] == charArray[j])
					return false;
			}
		}
		return true;
	}// O(n^2)

	// Write code to reverse a C-Style String (C-String means that “abcd” is
	// represented as five characters, including the null character )
	static String reverse(String s) {
		// skipping since it is C function

		return s;
	}

	// Design an algorithm and write code to remove the duplicate characters in
	// a string without using any additional bu er NOTE: One or two additional
	// variables are ne An extra copy of the array is not
	static String removeDuplicateChars(String s) {

		char[] charArray = s.toCharArray();
		int dupCount = 0;

		for (int i = 0; i < charArray.length - dupCount; i++) {

			for (int j = 0; j < charArray.length - dupCount; j++) {

				// if duplicate detected
				if (i != j && charArray[i] == charArray[j]) {

					// shift left by 1 char for all remaining characters
					for (int x = j; x < charArray.length - 1 - dupCount; x++) {
						charArray[x] = charArray[x + 1];
					}

					dupCount++;
					// return j 1 step left
					j--;
				}
			}
		}

		return String.valueOf(charArray, 0, charArray.length - dupCount);
	}// O(n^3)

	// Write a method to decide if two strings are anagrams or not
	static boolean isAnagram(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		} else {
			char[] array1 = s1.toCharArray();
			char[] array2 = s2.toCharArray();

			for (int i = 0; i < array1.length; i++) {
				boolean found = false;
				for (int j = 0; j < array2.length; j++) {

					if (array1[i] == array2[j]) {
						found = true;
						break;
					}
				}
				if (found == false) {
					return false;
				}
			}
			return true;
		}
	}// O(n*m)

	// Write a method to replace all spaces in a string with '%20'
	static String replaceAllSpacesWithPercent20(String s) {

		final char SPACE_CHAR = ' ';
		char[] charArray = s.toCharArray();

		int spacesCount = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == SPACE_CHAR) {
				spacesCount++;
			}
		}
		char[] target = new char[charArray.length + (spacesCount * 2)];

		int numSpaces = 0;
		for (int i = 0, j = 0; i < charArray.length; i++, j = i + (numSpaces * 2)) {

			if (charArray[i] != SPACE_CHAR) {
				target[j] = charArray[i];
			} else {
				target[j] = '%';
				target[j + 1] = '2';
				target[j + 2] = '0';

				numSpaces++;
			}
		}

		return String.valueOf(target);
	}// O(2n)

	public static void main(String[] args) {

		System.out.println(replaceAllSpacesWithPercent20("HELLO WORLD IN JAVA ARABIA "));
	}
}
