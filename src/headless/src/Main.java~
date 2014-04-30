/*
 * Written by Janek Wójcicki (10headless)
 */

package headless.src;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int[] vari = new int[300];
	public static String[] namei = new String[300];
	public static String[] vars = new String[300];
	public static String[] names = new String[300];
	public static String[] keyWords = new String[300];
	public static String[] keyWordsType = new String[300];
	public static String[] keyWordsMeaning = new String[300];

	public static void main(String[] args) {
		String s = "";
		if (args.length > 0) {
			try {
				if (args[0].contains(":")) {
					FileInputStream fstream = new FileInputStream(args[0]);
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String strLine;
					while ((strLine = br.readLine()) != null) {
						s += strLine;
					}
					in.close();
				} else {
					FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "/" + args[0]);
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					String strLine;
					while ((strLine = br.readLine()) != null) {
						s += strLine;
					}
					in.close();
				}
			} catch (IOException e) {
				System.out.println("File does not exist");
				System.exit(0);
			}
		} else {
			System.out.println("You must give me name of the file");
			System.exit(0);
		}
		
		vars[0] = "hello";
		names[0] = "janek";
		
		// ***Deleting comments from code

		String[] split1 = s.split("//");
		s = "";
		for (int i = 0; i < split1.length; i++) {
			if (i % 2 == 0) {
				s += split1[i];
			}
		}

		// Comments deleted

		// ***Looking for commands

		String[] split2 = s.split(";");
		s = "";
		String[] cmds = new String[200];
		for (int i = 0; i < split2.length; i++) {
			split2[i] = split2[i].trim();
			int[] varPlaces = findAll(split2[i], '>');
			if (varPlaces != null) {
				for (int j = 0; j < varPlaces.length; j++) {
					int beginIndex = varPlaces[j];
					int endIndex = 0;
					int k = 1;
					int l = varPlaces[j];
					boolean endExists = true;
					while (true) {
						if (split2[i].length() != l + k) {
							if (split2[i].charAt(l + k) == " ".charAt(0) || split2[i].charAt(l + k) == ']') {
								endIndex = l + k;
								break;
							}
						} else {
							endExists = false;
							break;
						}
						k++;
					}
					String y;
					if (endExists) {
						y = split2[i].substring(beginIndex+1, endIndex);
					} else {
						y = split2[i].substring(beginIndex+1);
					}
					String v = findVar(y);
					split2[i] = split2[i].replaceAll(">"+y, v);
				}
			}
			if(split2[i].contains("(")){
				
			}
		}
	}

	public static int[] findAll(String s, char l) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == l) {
				count++;
			}
		}
		if (count > 0) {
			int[] a = new int[count];
			count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == l) {
					a[count] = i;
					count++;
				}
			}
			return a;
		} else {
			return null;
		}
	}
	
	public static String findVar(String s){
		for (int l = 0; l < namei.length; l++) {
			if (s != null) {
				if (s.equals(
						"" + namei[l])) {
					s = "" + vari[l];
					break;
				}
			}
		}
		for (int l = 0; l < names.length; l++) {
			if (s != null) {
				if (s.equals(
						"" + names[l])) {
					s = "" + vars[l];
					break;
				}
			}
		}
		return s;
	}
}
