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
	public static void main(String[] args) {
		String s = "";
		if (args.length > 0) {
			try {
				FileInputStream fstream = new FileInputStream(args[0]);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				while ((strLine = br.readLine()) != null) {
					s += strLine;
				}
				in.close();
			} catch (IOException e) {
				System.out.println("File does not exist");
				System.exit(0);
			}
		} else {
			System.out.println("You must give me name of the file");
			System.exit(0);
		}

		// ***Deleting comments from code

		String[] split1 = s.split("//");
		s = "";
		for (int i = 0; i < split1.length; i++) {
			if (i % 2 == 0) {
				s += split1[i];
			}
		}

		// Comments deleted
	}
}
