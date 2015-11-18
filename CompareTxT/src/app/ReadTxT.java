package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

public class ReadTxT {

	public static void main(String[] args) {
		String file1 = "fileA.txt";
		String file2 = "fileB.txt";
		readTwoTxT(file1, file2);
	}

	public static void getPath()  {
		File directory = new File("");
		String courseFile;
		try {
			courseFile = directory.getCanonicalPath();
			System.out.println(courseFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void readTwoTxT(String file1, String file2) {
		TxTModule txTModule = new TxTModule();
		// check whether the file exists
		if (!txTModule.checkfile(file1)) {
			System.out.println("No such file exists :" + file1);
			return;
		}
		if (!txTModule.checkfile(file2)) {
			System.out.println("No such file exists :" + file2);
			return;
		}
		// then read the file
		try {
			Hashtable<String, Integer> words1 = txTModule.GetTxTWords(file1);
			Hashtable<String, Integer> words2 = txTModule.GetTxTWords(file2);
			System.out.println("union of two files:");
			List<String> wordsunion = new ArrayList<String>();
			Enumeration e1union = words1.keys();
			while (e1union.hasMoreElements()) {
				String key = (String) e1union.nextElement();
				wordsunion.add(key);
			}
			Enumeration e2union = words2.keys();
			while (e2union.hasMoreElements()) {
				String key = (String) e2union.nextElement();
				if (!words2.containsKey(key)) {
					wordsunion.add(key);
				}
			}
			for (String string : wordsunion) {
				System.out.println(string);
			}

			System.out.println("intersection of two files:");
			List<String> wordsintersection = new ArrayList<String>();
			Enumeration e1inter = words1.keys();
			while (e1inter.hasMoreElements()) {
				String key = (String) e1inter.nextElement();
				if (words2.containsKey(key)) {
					wordsintersection.add(key);
				}
			}
			for (String string : wordsintersection) {
				System.out.println(string);
			}

			System.out.println("words in fileA:");
			txTModule.printWords(words1);
			System.out.println("words in fileB:");
			txTModule.printWords(words2);

			System.out.println("words in A not in B. OUTPUT Percent");
			Enumeration wordscount1 = words1.elements();
			float count1 = 0;
			while (wordscount1.hasMoreElements()) {
				count1 += Integer.parseInt(wordscount1.nextElement().toString());
			}
			float countintersection1 = 0;
			for (String word : wordsintersection) {
				countintersection1 += words1.get(word);
			}
			Float per1 = (count1 - countintersection1) / count1 * 100;
			DecimalFormat df = new DecimalFormat(".00");
			System.out.println(df.format(per1) + "%");

			System.out.println("words in B not in A. OUTPUT Percent");
			Enumeration wordscount2 = words2.elements();
			float count2 = 0;
			while (wordscount2.hasMoreElements()) {
				count2 += Integer.parseInt(wordscount2.nextElement().toString());
			}
			float countintersection2 = 0;
			for (String word : wordsintersection) {
				countintersection2 += words2.get(word);
			}
			Float per2 = (count2 - countintersection2) / count2 * 100;
			System.out.println(df.format(per2) + "%");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

class TxTModule {

	public TxTModule() {
	}

	public boolean checkfile(String fileName) {
		 return new File(fileName).exists();
	}

	public BufferedReader read(String fileName) throws FileNotFoundException {
		BufferedReader bufread;
		File file = new File(fileName);
		FileReader fileread = new FileReader(file);
		bufread = new BufferedReader(fileread);
		return bufread;

	}

	public Hashtable<String, Integer> GetTxTWords(String fileName) throws FileNotFoundException {
		BufferedReader reader = this.read(fileName);
		Hashtable<String, Integer> words = this.GetTxTWords(reader);
		// this.printWords(words);
		return words;

	}

	public Hashtable<String, Integer> GetTxTWords(BufferedReader bufread) {
		Hashtable<String, Integer> curwords = new Hashtable<String, Integer>();
		String sentence;
		int wordCount = 0;
		try {
			while ((sentence = bufread.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(sentence);
				while (token.hasMoreTokens()) {
					wordCount++;
					String word = token.nextToken(", ?.!:\"\"''\n");
					if (curwords.containsKey(word)) {
						int curcount = curwords.get(word);
						curwords.put(word, curcount + 1);
					} else {
						curwords.put(word, 1);
					}
				}
			}
			// System.out.println(wordCount);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return curwords;
	}

	public void printWords(Hashtable<String, Integer> words) {
		if (words != null) {
			Enumeration e = words.keys();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				System.out.println(key + ":" + words.get(key));

			}
		}
	}
}