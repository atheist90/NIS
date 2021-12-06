public class Helper {
	/** Hier k�nnen Sie ihre allgemeinen Funktionen erstellen,
	 * welche in allen L�sungen verf�gbar sind.
	 * Sie k�nnen auch statische Methoden oder Subklassen benutzen.
	 * Sie k�nnen jedoch NICHT die Signatur des Konstruktors ver�ndern.
	 */
	public Helper() {

	}
	// Initial Permutation Table
	static int[] IP = { 58, 50, 42, 34, 26, 18,
			10, 2, 60, 52, 44, 36, 28, 20,
			12, 4, 62, 54, 46, 38,
			30, 22, 14, 6, 64, 56,
			48, 40, 32, 24, 16, 8,
			57, 49, 41, 33, 25, 17,
			9, 1, 59, 51, 43, 35, 27,
			19, 11, 3, 61, 53, 45,
			37, 29, 21, 13, 5, 63, 55,
			47, 39, 31, 23, 15, 7 };

	// Inverse Initial Permutation Table
	static  int[] IP1 = { 40, 8, 48, 16, 56, 24, 64,
			32, 39, 7, 47, 15, 55,
			23, 63, 31, 38, 6, 46,
			14, 54, 22, 62, 30, 37,
			5, 45, 13, 53, 21, 61,
			29, 36, 4, 44, 12, 52,
			20, 60, 28, 35, 3, 43,
			11, 51, 19, 59, 27, 34,
			2, 42, 10, 50, 18, 58,
			26, 33, 1, 41, 9, 49,
			17, 57, 25 };

	// first key-hePermutation Table
	static int[] PC1 = { 57, 49, 41, 33, 25,
			17, 9, 1, 58, 50, 42, 34, 26,
			18, 10, 2, 59, 51, 43, 35, 27,
			19, 11, 3, 60, 52, 44, 36, 63,
			55, 47, 39, 31, 23, 15, 7, 62,
			54, 46, 38, 30, 22, 14, 6, 61,
			53, 45, 37, 29, 21, 13, 5, 28,
			20, 12, 4 };

	// second key-Permutation Table
	static int[] PC2 = { 14, 17, 11, 24, 1, 5, 3,
			28, 15, 6, 21, 10, 23, 19, 12,
			4, 26, 8, 16, 7, 27, 20, 13, 2,
			41, 52, 31, 37, 47, 55, 30, 40,
			51, 45, 33, 48, 44, 49, 39, 56,
			34, 53, 46, 42, 50, 36, 29, 32 };

	// Expansion D-box Table
	static int[] EP = { 32, 1, 2, 3, 4, 5, 4,
			5, 6, 7, 8, 9, 8, 9, 10,
			11, 12, 13, 12, 13, 14, 15,
			16, 17, 16, 17, 18, 19, 20,
			21, 20, 21, 22, 23, 24, 25,
			24, 25, 26, 27, 28, 29, 28,
			29, 30, 31, 32, 1 };

	// Straight Permutation Table
	static int[] P = { 16, 7, 20, 21, 29, 12, 28,
			17, 1, 15, 23, 26, 5, 18,
			31, 10, 2, 8, 24, 14, 32,
			27, 3, 9, 19, 13, 30, 6,
			22, 11, 4, 25 };


	// S-box Table
	static int[][][] sBox = {
			{ 		{ 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
					{ 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
					{ 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
					{ 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 } },

			{		{ 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10 },
					{ 3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5 },
					{ 0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15 },
					{ 13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 } },

			{		{ 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8 },
					{ 13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1 },
					{ 13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7 },
					{ 1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12 } },

			{		{ 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15 },
					{ 13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9 },
					{ 10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4 },
					{ 3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14 } },

			{		{ 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9 },
					{ 14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6 },
					{ 4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14 },
					{ 11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3 } },

			{		{ 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11 },
					{ 10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8 },
					{ 9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6 },
					{ 4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13 } },

			{		{ 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1 },
					{ 13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6 },
					{ 1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2 },
					{ 6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12 } },

			{		{ 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7 },
					{ 1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2 },
					{ 7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8 },
					{ 2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } }
	};

	static int[] shiftBits = { 1, 1, 2, 2, 2, 2, 2, 2,
			1, 2, 2, 2, 2, 2, 2, 1 };

	static String[][] subBytesBox = {
			{"63", "7c", "77", "7b", "f2", "6b", "6f", "c5", "30", "01", "67", "2b", "fe", "d7", "ab", "76"},
			{"ca", "82", "c9", "7d", "fa", "59", "47", "f0", "ad", "d4", "a2", "af", "9c", "a4", "72", "c0"},
			{"b7", "fd", "93", "26", "36", "3f", "f7", "cc", "34", "a5", "e5", "f1", "71", "d8", "31", "15"},
			{"04", "c7", "23", "c3", "18", "96", "05", "9a", "07", "12", "80", "e2", "eb", "27", "b2", "75"},
			{"09", "83", "2c", "1a", "1b", "6e", "5a", "a0", "52", "3b", "d6", "b3", "29", "e3", "2f", "84"},
			{"53", "d1", "00", "ed", "20", "fc", "b1", "5b", "6a", "cb", "be", "39", "4a", "4c", "58", "cf"},
			{"d0", "ef", "aa", "fb", "43", "4d", "33", "85", "45", "f9", "02", "7f", "50", "3c", "9f", "a8"},
			{"51", "a3", "40", "8f", "92", "9d", "38", "f5", "bc", "b6", "da", "21", "10", "ff", "f3", "d2"},
			{"cd", "0c", "13", "ec", "5f", "97", "44", "17", "c4", "a7", "7e", "3d", "64", "5d", "19", "73"},
			{"60", "81", "4f", "dc", "22", "2a", "90", "88", "46", "ee", "b8", "14", "de", "5e", "0b", "db"},
			{"e0", "32", "3a", "0a", "49", "06", "24", "5c", "c2", "d3", "ac", "62", "91", "95", "e4", "79"},
			{"e7", "c8", "37", "6d", "8d", "d5", "4e", "a9", "6c", "56", "f4", "ea", "65", "7a", "ae", "08"},
			{"ba", "78", "25", "2e", "1c", "a6", "b4", "c6", "e8", "dd", "74", "1f", "4b", "bd", "8b", "8a"},
			{"70", "3e", "b5", "66", "48", "03", "f6", "0e", "61", "35", "57", "b9", "86", "c1", "1d", "9e"},
			{"e1", "f8", "98", "11", "69", "d9", "8e", "94", "9b", "1e", "87", "e9", "ce", "55", "28", "df"},
			{"8c", "a1", "89", "0d", "bf", "e6", "42", "68", "41", "99", "2d", "0f", "b0", "54", "bb", "16"}};

	static String [][] rcon = {{"01", "00", "00", "00"},
			{"02", "00", "00", "00"},
			{"04", "00", "00", "00"},
			{"08", "00", "00", "00"},
			{"10", "00", "00", "00"},
			{"20", "00", "00", "00"},
			{"40", "00", "00", "00"},
			{"80", "00", "00", "00"},
			{"1b", "00", "00", "00"},
			{"36", "00", "00", "00"}};

	static String [][] matrixForMixingColumns = {
			{"02", "03", "01", "01"},
			{"01", "02", "03", "01"},
			{"01", "01", "02", "03"},
			{"03", "01", "01", "02"}};

	/**
	 * This function converts a decimal number type String to binary number type String
	 * @param decimalString - any number in String
	 * @return binary number in type String
	 */
	public static String convertDecimalString_toBinaryString(String decimalString) {
		int decimalInt = Integer.parseInt(decimalString);
		int [] binaryIntArray = convertDecimalInt_toBinaryIntArray(decimalInt);
		String binaryString = "";
		for (int i = 0; i < binaryIntArray.length; i++) {
			binaryString += Integer.toString(binaryIntArray[i]);
		}
		return binaryString;
	}

	/**
	 * This function converting a decimal integer to binary which will be saved in int array
	 * which represents a binary number.
	 * @param decimal any decimal number in integer
	 * @return an int array
	 */
	public static int [] convertDecimalInt_toBinaryIntArray(int decimal) {
		int [] temp = new int [999];
		int i = 0;
		while (decimal > 0) {
			temp[i] = decimal % 2;
			decimal = decimal / 2;
			i++;
		}

		int [] binIntArray = new int[i];
		for (int j = 0; j < binIntArray.length; j++) {
			binIntArray[j] = temp[i-1];
			i--;
		}
		return binIntArray;
	}

	/**
	 * This function converts hexadecimal number type String to binary number type String.
	 * @param hexString hexadecimal number as String
	 * @return a binary number in type String
	 */
	public static String convertHexString_toBinaryString(String hexString) {
		String binaryString = "";
		for (int i = 0; i < hexString.length(); i++) {
			binaryString += getBinaryString_fromAnElementOfHexString(hexString.charAt(i));
		}
		return binaryString;
	}

	/**
	 * This function gets a binary number of specific character in @param.
	 * The method isn't case sensitive.
	 * REMARK: return value is always in 4 bits. (half of octet)
	 * @param charOfHexString  character of hexadecimal String
	 * @return a binary number in type String.
	 */
	public static String getBinaryString_fromAnElementOfHexString(char charOfHexString) {
		switch (charOfHexString) {
			case '0' : return "0000";
			case '1' : return "0001";
			case '2' : return "0010";
			case '3' : return "0011";
			case '4' : return "0100";
			case '5' : return "0101";
			case '6' : return "0110";
			case '7' : return "0111";
			case '8' : return "1000";
			case '9' : return "1001";
			case 'A' :
			case 'a' : return "1010";
			case 'B' :
			case 'b' : return "1011";
			case 'C' :
			case 'c' : return "1100";
			case 'D' :
			case 'd' : return "1101";
			case 'E' :
			case 'e' : return "1110";
			case 'F' :
			case 'f' : return "1111";
			default: return null;
		}
	}

	/**
	 * This function takes to binary numbers, make them same size and XOR them.
	 * @param firstBinary  first binary number
	 * @param secondBinary  second binary number
	 * @return XORed result in String
	 */
	public static String binary_XOR_binary(String firstBinary, String secondBinary) {
		String binFirst = "", binSecond = "";
		if(firstBinary.length() > secondBinary.length()) {
			for (int i = 0; i <firstBinary.length() - secondBinary.length(); i++) {
				binSecond += "0";
			}
			binSecond += secondBinary;
			secondBinary = binSecond;
		}
		if(firstBinary.length() < secondBinary.length()) {
			for (int i = 0; i < secondBinary.length() - firstBinary.length(); i++) {
				binFirst += "0";
			}
			binFirst += firstBinary;
			firstBinary = binFirst;
		}
		String result = "";
		for (int i = 0; i < firstBinary.length(); i++) {
			if(firstBinary.charAt(i) == secondBinary.charAt(i)) {
				result += "0";
			}
			else result += "1";
		}
		return result;
	}

	/**
	 * This function takes a number and factorize it into prime numbers.
	 * Example: primeFactorization(30) --> 2*3*5
	 * @param number  number, which should be factorize.
	 * @return prime numbers separated by * in a String
	 */
	public static String primeFactorization(int number) {
		String result = "";
		int n = number;
		if (n == 0) return "0";
		else {
			for (int i = 2; i <= n; i++) {
				while (n % i == 0) {
					result = result + i + "*";
					n = n/i;
				}
			}
		}
		return result.substring(0,result.length()-1);
	}

	/**
	 * This function match key with cipher, so if key smaller than cipher
	 * it write key letter over till in match the size of cipher.
	 * If key length longer than cipher length, then it cuts the key, that
	 * it makes key length and cipher length same.
	 * @param cipher Cipher
	 * @param key Key
	 * @return matched key in String
	 */
	public static String makeKey_sameSizeAsCipher(String cipher, String key) {
		if (cipher.length() > key.length()) {
			String nKey = "";
			for (int i = 0; i < cipher.length(); i++) {
				nKey = nKey + key.charAt(i%key.length());
			}
			return nKey;
		}
		else if (cipher.length() < key.length()) {
			return key.substring(0, cipher.length());
		}
		else return key;
	}

	/**
	 * This function create two dimensional array filled with numbers
	 * from 0 to 26. Each dimension shifts the order of the numbers one position.
	 * This array needed for vigenere cipher decription.
	 * @return two dimensional int array
	 */
	public static int[][]  createAnAlphabet() {
		int[][] alphabet = new int[26][26];
		for (int i = 0; i < alphabet.length; i++) {
			for (int j = 0; j < alphabet[i].length; j++) {
				alphabet[i][j] = (i + j) % 26;
			}
		}
		return alphabet;
	}

	/**
	 * This function can decrypt a cipher with given key
	 * @param cipher Cipher
	 * @param key Key
	 * @return plain/clear text in String
	 */
	public static String vigenereDecryption(String cipher, String key) {
		String nKey = makeKey_sameSizeAsCipher(cipher, key.toUpperCase());
		String nCipher = cipher.toUpperCase();
		int[][] alphabet = createAnAlphabet();
		String plainText = "";
		for (int i = 0; i < nCipher.length(); i++) {
			int cipherInt = nCipher.charAt(i) - 65; // <- here I save position number of every letter of string cipher
			int keyInt = nKey.charAt(i % key.length()) - 65; // <- here I save position number of every letter of string key

			for (int j = 0; j < alphabet[keyInt].length; j++) {
				if (alphabet[keyInt][j] == cipherInt) {
					plainText = plainText + (char) (j + 65);
				}
			}
		}
		return plainText;
	}

	/**
	 * This function does expansion permutation of given 32 bit binary text to
	 * 48 bit binary text.
	 *
	 * @param binary32BitText 32 bit binary text in String
	 * @return 48 bit binary text in String
	 */
	public static String expansionPermutation(String binary32BitText) {
		String binary48BitText = "";
		for (int i = 0; i < 48; i++) {
			binary48BitText += binary32BitText.charAt(EP[i]-1);
		}
		return binary48BitText;
	}

	/**
	 * This function permute 64 bit key using PC-1 table to 56 bit key
	 * @param binary64BitKey a 64 bit binary key in String
	 * @return 56 bit binary key in String
	 */
	public static String keyPermutationPC1(String binary64BitKey) {
		String binary56BitKey = "";
		for (int i = 0; i < 56; i++) {
			binary56BitKey += binary64BitKey.charAt(PC1[i]-1);
		}
		return binary56BitKey;
	}

	/**
	 * This function takes 56 bit key and permutate it to 48 bit using PC-2 table
	 * @param binaryCDBlock56Bit the binary key from C and D blocks, length 56 bit as String
	 * @return 48 bit binary key in String
	 */
	public static String keyPermutationPC2(String binaryCDBlock56Bit) {
		String binary48BitKey = "";
		for (int i = 0; i < 48; i++) {
			binary48BitKey += binaryCDBlock56Bit.charAt(PC2[i]-1);
		}
		return binary48BitKey;
	}

	/**
	 * This function divides given 56 bit binary key to 28 bit halves,
	 * and gets left part of key. Also known as C-Block.
	 * @param binary56BitKey 56 bit binary key as String
	 * @return 28 bit binary key in String
	 */
	public static String getCBlock(String binary56BitKey) {
		return binary56BitKey.substring(0, 28);
	}

	/**
	 * This function divides given 56 bit binary key to 28 bit halves,
	 * and gets right part of key. Also known as D-Block
	 * @param binary56BitKey 56 bit binary key as String
	 * @return 28 bit binary key in String
	 */
	public static String getDBlock(String binary56BitKey) {
		return binary56BitKey.substring(28, 56);
	}

	/**
	 * This function shifting left a given 28 bit key using table shifBits
	 * @param binary28BitKey 28 bit binary key as String
	 * @param rounds number of round as integer
	 * @return 28 bit binary key in String
	 */
	public static String leftShift(String binary28BitKey, int rounds) {
		String [] shiftedKeys = new String[rounds + 1];
		shiftedKeys[0] = binary28BitKey;
		for (int i = 0; i < rounds; i++) {
			shiftedKeys[i+1] = shiftedKeys[i].substring(shiftBits[i]) + shiftedKeys[i].substring(0, shiftBits[i]);
		}
		return shiftedKeys[rounds];
	}

	/**
	 * This function does initial permutation of given 64 bit binary text.
	 * @param binary64BitPlainText 64 bit binary plain text as String
	 * @return 64 bit binary initial permuted plain text in String
	 */
	public static String initialPermutation(String binary64BitPlainText) {
		String afterInitialPermutation = "";
		for (int i = 0; i < IP.length; i++) {
			afterInitialPermutation += binary64BitPlainText.charAt(IP[i]-1);
		}
		return afterInitialPermutation;
	}

	/**
	 * This function converts a given binary number in String to decimal in Integer.
	 * @param binaryNumber binary number in String any length
	 * @return decimal integer.
	 */
	public static int convertBinaryString_toDecimalInteger(String binaryNumber) {
		int decimalInteger = 0;
		int level = 0;
		for (int i = binaryNumber.length() - 1; i >= 0; i--) {
			if(binaryNumber.charAt(i) == '1') {
				decimalInteger += Math.pow(2, level);
			}
			level++;
		}
		return decimalInteger;
	}

	/**
	 * The function takes a number and convert it to binary in String
	 * This function returns different size Strings, depends of given number
	 * For example: 5 --> 101, 15 --> 1111 etc.
	 * @param number any number
	 * @return number converted into binary in String
	 */
	public static String convertDecimalInteger_toBinaryString(int number) {
		String convertedDecimalToBinary = "";
		int [] convertedIntoArray = convertDecimalInt_toBinaryIntArray(number);
		for (int i = 0; i < convertedIntoArray.length; i++) {
			convertedDecimalToBinary += Integer.toString(convertedIntoArray[i]);
		}
		return convertedDecimalToBinary;
	}

	/**
	 * This function does all operations with S-Box, it divide given 48 bit binary text
	 * into 8 parts, each part is 6 bit. Then, using S-box, it will convert 6 bits to 4,
	 * and return one big 32-bit string.
	 *
	 * @param binary48Bit 48 bit binary text in String before manipulations with S-Box
	 * @return 32 bit binary text after manipulations with S-Box
	 */
	public static String afterSBox(String binary48Bit) {
		String [] b = new String[8];
		int j = 0;
		for (int i = 0; i < b.length; i++) {
			b[i] = binary48Bit.substring(j, j+6);
			//System.out.println("B[" + i + "]: " + b[i]);
			j += 6;
		}
		String [] c = new String[8];
		String afterSBox = "";
		for (int i = 0; i < c.length; i++) {
			String row = b[i].substring(0, 1) + b[i].substring(5);
			String column = b[i].substring(1, 5);
			//System.out.println("Row[" + i + "]: " + row + " and Column[" + i + "]: " + column);
			c[i] = alignSizeTo(convertDecimalInteger_toBinaryString(sBox[i][convertBinaryString_toDecimalInteger(row)][convertBinaryString_toDecimalInteger(column)]), 4);
			//System.out.println("gets a row: " + convertBinaryString_toDecimalInteger(row) + " and column: " + convertBinaryString_toDecimalInteger(column) + " | it gives number: " + sBox[0][convertBinaryString_toDecimalInteger(row)][convertBinaryString_toDecimalInteger(column)] + " which after converting gives: " + c[i]);
			afterSBox += c[i];
		}

		return afterSBox;
	}

	/**
	 * With this function, you can set the size to any binary number/text.
	 * It will add '0' to given binary text or number until the size is equal
	 * to the given size.
	 * @param text any binary number or text in String.
	 * @param size size in integer
	 * @return binary String in specific size
	 */
	public static String alignSizeTo(String text, int size) {
		String aligned = "";
		if (text.length() < size) {
			for (int i = 0; i < size - text.length() ; i++) {
				aligned += "0";
			}
			aligned += text;
			return aligned;
		}
		else {
			aligned += text;
			return aligned;
		}
	}

	/**
	 * This function writes all the left and right blocks to the arrays,
	 * but due to the task, only returns the right block back. The function
	 * is written according to the lecture materials in the following stages:
	 * 1. First of all it takes a given 64 bit binary plain text and initially
	 * permute it.
	 * 2. Then split the init.permuted plain text into two equal
	 * 32 bit pieces: left (L0) and right(R0)
	 *
	 * 3. After that it loops 16 times, and saves left block and right blocks
	 * in arrays.
	 *
	 * The function can be modified.
	 *
	 * @param binary64BitPlainText binary 64 bit plain text
	 * @param permuted48BitKey permuted 48 bit key
	 * @param r needed number of round
	 * @return right block 32 bit.
	 */
	public static String feistelNetwork(String binary64BitPlainText, String permuted48BitKey, int r) {
		// 0. Initial permutation of binary 64 bit plain text:
		String initialPermuted64Bit_plainText = initialPermutation(binary64BitPlainText);
		// 1. Split the plaintext block into two equal pieces, (L0 R0)
		String[] leftBlock = new String[16];
		String[] rightBlock = new String[16];
		leftBlock[0] = initialPermuted64Bit_plainText.substring(0, 32);
		rightBlock[0] = initialPermuted64Bit_plainText.substring(32, 64);

		// 2. For each round i= 0,1,...,n
		for (int i = 1; i < 16; i++) {
			// Li+1=Ri
			leftBlock[i] = rightBlock[i-1];
			// Ri+1=Li⊕F(Ri,Ki)
			rightBlock[i] = binary_XOR_binary(leftBlock[i-1], roundFunction(rightBlock[i-1], permuted48BitKey));
		}

		return rightBlock[r];
	}

	/**
	 * This function as know as "FEISTEL FUNCTION" does the following:
	 * it takes 32 bit right block, expanse it to 48 bit, then XOR it with
	 * given 48 bit permuted round key, does some manipulations with S-Box
	 * and in the end it straight permute everything.
	 * @param rightBlock32Bit  binary 32 bit right block of plain text in String
	 * @param permuted48BitRoundKey  binary 48 bit permuted round key in String
	 * @return  result of round function (aka feistel function)
	 */
	public static String roundFunction(String rightBlock32Bit, String permuted48BitRoundKey) {
		String expansionRightBlockTo48Bit = expansionPermutation(rightBlock32Bit);
		String afterXORing = binary_XOR_binary(expansionRightBlockTo48Bit, permuted48BitRoundKey);
		String afterManipulationsWithSBox = afterSBox(afterXORing);
		String afterStraightPermutation = straightPermutation(afterManipulationsWithSBox);
		return afterStraightPermutation;
	}

	/**
	 * This function permute a given 32 bit binary key using table P
	 * @param binary32Bit 32 bit binary key in String
	 * @return straight permuted 32 bit key in String
	 */
	public static String straightPermutation(String binary32Bit) {
		String afterStraightPermutation = "";
		for (int i = 0; i < P.length; i++) {
			afterStraightPermutation += binary32Bit.charAt(P[i]-1);
		}
		return afterStraightPermutation;
	}

	/**
	 * This function gets round key with given number of rounds and 64 bit long
	 * binary key.
	 * @param roundNumber round number as int.
	 * @param binary64BitKey 64 bit binary key as String
	 * @return round key of the specific round number, 48 bit
	 */
	public static String getRoundKey(int roundNumber, String binary64BitKey) {
		String permuteInto56BitKey = keyPermutationPC1(binary64BitKey);
		String leftCBlock = getCBlock(permuteInto56BitKey);
		String rightDBlock = getDBlock(permuteInto56BitKey);
		String afterShiftingCBlock = leftShift(leftCBlock, roundNumber);
		String afterShiftingDBlock = leftShift(rightDBlock, roundNumber);
		return keyPermutationPC2(afterShiftingCBlock + afterShiftingDBlock);
	}

	/**
	 * This function do binary multiplication of two binary numbers and gives result as
	 * a binary number. The function created for Multiplication AES GF 2^8 (2 power 8).
	 * It multiply and XOR everything, and gives result as String.
	 * @param binary8BitNumber1 first 8 bit binary number as String
	 * @param binary8BitNumber2 second 8 bit binary number as String
	 * @return result of binary multiplication of two numbers as String
	 */
	public static String binaryMultiplication(String binary8BitNumber1, String binary8BitNumber2) {
		String [] arrayOfBins = new String[countOnes(binary8BitNumber2)];
		int j = 0;
		for (int i = 0; i < binary8BitNumber2.length(); i++) {
			if(binary8BitNumber2.charAt(i) == '1') {
				arrayOfBins[j] = addZerosTimes(binary8BitNumber1, binary8BitNumber1.length() - (i + 1));
				//System.out.println(arrayOfBins[j]);
				j++;
			}
		}
		String result = "000000";
		for (int i = 0; i < arrayOfBins.length; i++) {
			result = binary_XOR_binary(result, arrayOfBins[i]);
		}
		return result.substring(result.indexOf('1'));
	}

	private static int countOnes(String binary8BitNumber) {
		int count = 0;
		for (int i = 0; i < binary8BitNumber.length(); i++) {
			if (binary8BitNumber.charAt(i) == '1') count++;
		}
		return count;
	}

	private static String addZerosTimes(String whereToAdd, int times) {
		for (int i = 0; i < times; i++) {
			whereToAdd += "0";
		}
		return whereToAdd;
	}

	/**
	 * This function do binary division, and as a result gives modulo of this two
	 * numbers. The function created for Multiplication AES GF 2^8 (2 power 8)
	 * @param dividend dividend in String
	 * @param divisor divisor in String
	 * @return modulo of [dividend / divisor] in String. (returning number in binary)
	 */
	public static String binaryModulo(String dividend, String divisor) {
		while (dividend.length() >= divisor.length()) {
			String re = binary_XOR_binary(dividend.substring(0, divisor.length()), divisor);
			dividend = re + dividend.substring(divisor.length());
			dividend = dividend.substring(dividend.indexOf('1'));
//            System.out.println(dividend);
		}
		return dividend;
	}

	/**
	 * This function converts binary number to hexadecimal string. Principe of
	 * the function is converting binary number to decimal, and decimal to hexa.
	 * @param binaryNumber any binary number in String
	 * @return hexadecimal number
	 */
	public static String convertBinaryString_toHexString(String binaryNumber) {
		String hexaDecimal = "";
		char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f'};
		if (binaryNumber != null && !binaryNumber.isEmpty()) {
			int decimal = convertBinaryString_toDecimalInteger(binaryNumber);
			while (decimal > 0) {
				hexaDecimal = hex[decimal % 16] + hexaDecimal;
				decimal /= 16;
			}
		}
		if (hexaDecimal.length() < 2) {
			hexaDecimal = "0" + hexaDecimal;
		}
		return hexaDecimal;
	}

	public static String [][][] keyScheduleAES128(String hexadecimal16ByteKey) {
		String [][] cipherKey = addCipherToBox(hexadecimal16ByteKey);
		String [][][] keySchedule = new String[11][4][4];
		// Step 1
		keySchedule[0] = cipherKey;
		// Step 2
		for (int i = 0; i < 10; i++) {
			String [] rotateWord = rotateWord(keySchedule[i][3]);
			String [] subBytes = subBytes(rotateWord);
			String [] afterRcon = rcon4(keySchedule[i][0], subBytes, i);
			keySchedule[i+1][0] = afterRcon;
			for (int j = 1; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					keySchedule[i+1][j][k] = hexaXORhexa(keySchedule[i][j][k],keySchedule[i+1][j-1][k]);
				}
			}
		}
		return keySchedule;
	}

	private static String [][] addCipherToBox(String hexa16ByteKey) {
		if(hexa16ByteKey.length() != 32) return new String[0][0];
		String [][] roundKey = new String[4][4];
		int counter = 2;
		for (int i = 0; i < roundKey.length; i++) {
			for (int j = 0; j < roundKey[i].length; j++) {
				roundKey[i][j] = hexa16ByteKey.substring(counter - 2, counter);
				counter += 2;
			}
		}
		return roundKey;
	}

	private static String [] rotateWord(String [] array4Bytes) {
		String [] rotatedWord = new String[4];
		for (int i = 0; i < 4; i++) {
			rotatedWord[i] = array4Bytes[(i+1)%4];
		}
		return rotatedWord;
	}

	private static String[] subBytes(String [] rotated4ByteWord) {
		String [] subByte = new String[4];
		for (int i = 0; i < subByte.length; i++) {
			subByte[i] = subBytesBox[convertHexString_toDecimalInteger(rotated4ByteWord[i].charAt(0))][convertHexString_toDecimalInteger(rotated4ByteWord[i].charAt(1))];
		}
		return subByte;
	}

	private static int convertHexString_toDecimalInteger(char hexChar) {
		switch (hexChar) {
			case '1' : return 1;
			case '2' : return 2;
			case '3' : return 3;
			case '4' : return 4;
			case '5' : return 5;
			case '6' : return 6;
			case '7' : return 7;
			case '8' : return 8;
			case '9' : return 9;
			case 'a' : return 10;
			case 'b' : return 11;
			case 'c' : return 12;
			case 'd' : return 13;
			case 'e' : return 14;
			case 'f' : return 15;
			default: return 0;
		}
	}

	public static String [] rcon4(String [] firstRoundKey, String [] arrayOfSubBytes, int rconColumnNumber) {
		String [] firstColumn = new String[4];
		for (int i = 0; i < 4; i++) {
			String firstXOR = hexaXORhexa(firstRoundKey[i], arrayOfSubBytes[i]);
			firstColumn[i] = hexaXORhexa(firstXOR, rcon[rconColumnNumber][i]);
		}
		return firstColumn;
	}

	/**
	 * This function XOR two hexadecimal numbers and returns result
	 * as hexadecimal number.
	 * Need to notice, that parameters have to be 8 bit size (1 Byte)
	 *
	 * For example:
	 * hexaXORhexa("a2", "02") --> a0;
	 *
	 * @param firstHex 8 bit size hexadecimal number as String
	 * @param secondHex 8 bit size hexadecimal number as String
	 * @return 8 bit size hexadecimal number
	 */
	public static String hexaXORhexa(String firstHex, String secondHex) {
		String firstBin = convert8BitsHex_to8BitsBinary(firstHex);
		String secondBin = convert8BitsHex_to8BitsBinary(secondHex);
		return convert8BitBinary_to8BitHex(binary_XOR_binary(firstBin, secondBin));
	}

	private static String convert8BitsHex_to8BitsBinary(String hex8Bit) {
		String result = "";
		for (int i = 0; i < 2; i++) {
			result += getBinaryString_fromAnElementOfHexString(hex8Bit.charAt(i));
		}
		return result;
	}

	private static String convert8BitBinary_to8BitHex(String binary8BitNumber) {
		String result = get4BitHex_fromAnElementOfBinString(binary8BitNumber.substring(0, 4));
		result += get4BitHex_fromAnElementOfBinString(binary8BitNumber.substring(4, 8));
		return result;
	}

	private static String get4BitHex_fromAnElementOfBinString(String binary4BitNumber) {
		switch (binary4BitNumber.toLowerCase()) {
			case "0001" : return "1";
			case "0010" : return "2";
			case "0011" : return "3";
			case "0100" : return "4";
			case "0101" : return "5";
			case "0110" : return "6";
			case "0111" : return "7";
			case "1000" : return "8";
			case "1001" : return "9";
			case "1010" : return "a";
			case "1011" : return "b";
			case "1100" : return "c";
			case "1101" : return "d";
			case "1110" : return "e";
			case "1111" : return "f";
			default: return "0";
		}
	}

	/**
	 * This function mix columns for AES128. Make sure, input is 16 byte
	 * hexadecimal String. It's important
	 *
	 * @param hex16Byte_4x4Matrix 16 byte long hexadecimal number
	 * @return matrix[4][4] with 8 bit (1 byte) String in each cell
	 */
	public static String [][] mixColumns(String [][] hex16Byte_4x4Matrix) {
		String [][] mixedColumsMatrix = new String[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				String xored = "00";
				for (int l = 0; l < 4; l++) {
					String multiplyBin = binaryMultiplication(convert8BitsHex_to8BitsBinary(matrixForMixingColumns[j][l]), convert8BitsHex_to8BitsBinary(hex16Byte_4x4Matrix[l][i]));
					xored = hexaXORhexa(xored, convertBinaryString_toHexString(binaryModulo(multiplyBin, "100011011")));
					//matrixForMixingColumns[j][l] * inputData[l][i]
				}
				mixedColumsMatrix[j][i] = xored;
			}
		}
		return mixedColumsMatrix;
	}

	public static String [][] subByteAMatrix(String [][] matrix) {
		String [][] afterSubByting = new String[4][4];
		for (int i = 0; i < matrix.length; i++) {
			afterSubByting[i] = subBytes(matrix[i]);
		}
		return afterSubByting;
	}

	public static String [][] shiftRows(String [][] matrixAfterSubByting) {
		String [][] afterShiftingRows = new String[4][4];
		afterShiftingRows[0] = matrixAfterSubByting[0];
		for (int i = 1; i < 4; i++) {
			afterShiftingRows[i] = shiftArrayToLeft(matrixAfterSubByting[i], i);
		}

		return afterShiftingRows;
	}

	private static String[] shiftArrayToLeft(String[] array, int times) {
		for (int i = times; i > 0; i--) {
			String temp = array[0];
			for (int j = 0; j < array.length - 1; j++) {
				array[j] = array[j + 1];
			}
			array[array.length - 1] = temp;
		}
		return array;
	}

	/**
	 * This function saves a given String into Matrix. There is an important
	 * condition for this function: given String have to be 16 Byte long hexadecimal
	 * data. For example:
	 * String inputData = '010203040506070809aabbccddee001a';
	 *
	 * @param hexadecimal16ByteLongData 16 Byte long hexadecimal data in String
	 * @return an [][] array, (matrix).
	 */
	public static String [][] saveStringToMatrix(String hexadecimal16ByteLongData) {
		String [][] inputData = new String[4][4];
		int k = 0;
		for (int i = 0; i < inputData.length; i++) {
			for (int j = 0; j < inputData[i].length; j++) {
				inputData[j][i] = hexadecimal16ByteLongData.substring(k, k+2);
				k += 2;
			}
		}
		return inputData;
	}

	/**
	 * This function save Matrix in String. It saves all cells in
	 * Matrix using columns. For example:
	 * 			{a00, a01, a02}
	 * Matrix:= {a10, a11, a12}
	 * 			{a20, a21, a22}
	 *
	 * Will give a String mA = 'a00a10a20a01a11a21a02a12a22'
	 * @param matrix as two dimensional String array [][]
	 * @return a String
	 */
	public static String saveMatrixIntoString(String [][] matrix) {
		String result = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				result += matrix[j][i];
			}
		}
		return result;
	}

	/**
	 * This function should convert String into Integer without parse, because
	 * parse is not allowed to use in this project. The function I took from my
	 * last 2020 year NIS1 project, because I wanted to save some time.
	 * @param str is input data in String
	 * @return output data in integer.
	 */
	public static int convertStringToIntegerWithoutParse(String str) {
		int otvet = 0, faktor = 1;
		for (int i = str.length()-1; i >= 0; i--) {
			otvet += (str.charAt(i) - '0') * faktor;
			faktor *= 10;
		}
		return otvet;
	}

	/**
	 * The function is for RC4 generation loop. It takes a table and plain text, and
	 * gives a String State Table of Loop.
	 * @param tableArray a String array
	 * @param plainText as String
	 * @return String state table of loop
	 */
	public static String rc4generationLoop(String [] tableArray, String plainText) {
		// 1. Converting String array into Integer array:
		int [] tableArrayInt = new int [tableArray.length];
		for (int k = 0; k < tableArray.length; k++) {
			tableArrayInt[k] = convertStringToIntegerWithoutParse(tableArray[k]);
		}

		// 2. Creating another int array for resulting data:
		int [] res = new int [plainText.length()];

		// 3. Using algorithm from NIS1 lectures.
		int i = 0, j = 0;
		for (int k = 0; k < plainText.length(); k++) {
			i = (i+1)%(tableArrayInt.length);
			j = (j+tableArrayInt[i])%(tableArrayInt.length);
			// 3.1. now swapping
			int temp = tableArrayInt[j];
			tableArrayInt[j] = tableArrayInt[i];
			tableArrayInt[i] = temp;
			res[k] = tableArrayInt[(tableArrayInt[i] + tableArrayInt[j])%(tableArrayInt.length)];
		}
		// 4. saving all data in String:
		String result = "";
		for (int k = 0; k < res.length; k++) {
			//System.out.print(res[k]);
			result += res[k];
		}
		return result;
	}

	/**
	 * This function do a key schedule of RC4 algorithm. This function was in
	 * my SoSe2020 project. All algorithms taken from internet and lecture materials
	 * @param keyAsStringArray an String array
	 * @return key schedule table divided with '_' symbol in String
	 */
	public static String rc4Keyschedule(String [] keyAsStringArray) {
		int [] array = new int[keyAsStringArray.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = convertStringToIntegerWithoutParse(keyAsStringArray[i]);
		}
		int [] justArray = new int[array.length];
		for (int i = 0; i <justArray.length ; i++) {
			justArray[i] = i;
		}
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			int a = i%(array.length);
			j = (j + array[a] + justArray[i])%array.length;
			int temp = justArray[i];
			justArray[i] = justArray[j];
			justArray[j] = temp;
		}
		String result = justArray[0] + "";
		for (int i = 1; i < justArray.length; i++) {
			result += "_" + justArray[i];
		}
		return result;
	}

	/**
	 * This function converts a decimal integer into 8 Bit (1 Byte)
	 * size binary String.
	 * This code was taken from my last SoSe2020 year NIS1 project.
	 * Warning! The function can convert only from 0 to 255
	 * @param n integer
	 * @return 8 bit long binary String.
	 */
	public static String convertAnIntToSingleBinary(int n) {
		String result = "";
		for (int i = 128; i > 0.5 ; i/=2) {
			if (n >= i){
				result += "1";
				n -= i;
			} else result += "0";
		}
		return result;
	}

	/**
	 * This function do rc4 encryption. The code was taken from my last year
	 * project NIS1 SoSe2020.
	 * @param key as String with '_'
	 * @param plainText as String
	 * @return after encryption as String
	 */
	public static String rc4(String key, String plainText) {
		String [] keyString = key.split("_");
		System.out.println("Key = " + key);
		System.out.println("PlainText = " + plainText);
		String keySchedule = rc4Keyschedule(keyString);
		String [] kSchedule = keySchedule.split("_");

		int [] keyArray = new int[keyString.length];

		for (int i = 0; i < keyArray.length; i++) {
			keyArray[i] = convertStringToIntegerWithoutParse(keyString[i]);
		}

		String [] generationLoop = rc4generationLoop(kSchedule, plainText).split("");
		int [] gLoop = new int[generationLoop.length];
		for (int i = 0; i < gLoop.length; i++) {
			gLoop[i] = convertStringToIntegerWithoutParse(generationLoop[i]);
		}

		String result = "";
		for (int i = 0; i < plainText.length(); i++) {
			result += binary_XOR_binary(convertAnIntToSingleBinary(gLoop[i]), convertAnIntToSingleBinary(plainText.charAt(i)));
		}
		System.out.println("Result = " + result);
		return result;
	}
}
