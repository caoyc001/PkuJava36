import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import javax.swing.text.NumberFormatter;


public class WordTest {
	
	
	/**
	 * @param aNumber,bNumber分别表示A文档和B文档的单词数
	 * @param unionSet表示并集，retainSet表示交集
	 */
	public static void main(String[] args){
		WordTest wt=new WordTest();
		int aNumber=0;//A.txt words number
		int bNumber=0;//B.txt words number
		NumberFormat formatter=new DecimalFormat("0.000");
		Scanner sc=new Scanner(System.in);
		System.out.println("请在第一行输入第一个文档地址，第二行输入第二个文档地址");
		String filePathA=sc.nextLine();
		String filePathB=sc.nextLine();
		/*String filePathA="D:\\testWord.txt";
		String filePathB="D:\\testWord2.txt";*/
		String[] arr1=wt.readTXTFile(filePathA);
		String[] arr2=wt.readTXTFile(filePathB);
		aNumber=arr1.length;
		bNumber=arr2.length;
		HashSet<String> set1=new HashSet<String>();
		HashSet<String> set2=new HashSet<String>();
		for(String s:arr1){
			 set1.add(s);
		}
		for(String s:arr2){
			set2.add(s);
		}
		//addAll函数获取并集
		HashSet<String> unionSet=new HashSet<String>(set1);
		unionSet.addAll(set2);
		
		//retainAll函数获取交集
		HashSet<String> retainSet=new HashSet<String>(set1);
		retainSet.retainAll(set2);
		
		//获取在A不在B中单词的百分比，removeAll函数获取只存在于某一文档中的单词
		HashSet<String> aSet=new HashSet<String>(set1);
		aSet.removeAll(set2);
		String aPer="";
		if(aNumber!=0){
			aPer=formatter.format(new Double((aSet.size()*1.0)/aNumber));
		}
		 
		
		//获取在B不在A中单词的百分比
		HashSet<String> bSet=new HashSet<String>(set2);
		bSet.removeAll(set1);
		String bPer="";
		if(bNumber!=0){
			bPer=formatter.format(new Double((bSet.size()*1.0)/bNumber)); 
		}
		
		
		System.out.println("两文件单词的并集长度为:"+unionSet.size()+"\n并集单词分别为:");
		for(String s:unionSet){
			System.out.print(s+",");
		}
		System.out.println();
		
		System.out.println("两文件单词的交集长度为:"+retainSet.size()+"\n交集单词分别为:");
		for(String s:retainSet){
			System.out.print(s+",");
		}
		System.out.println();
		
		System.out.println("第一个文件中的单词数为："+aNumber);
		System.out.println("第二个文件中的单词数为："+bNumber);
		 
		System.out.println("在A不在B中的单词数占A百分比为："+aPer);
		System.out.println("在B不在A中的单词数占B百分比为："+bPer);
	}
	
	//读取文件，通过正则表达式"\\W+"获取所有单词
	public String[] readTXTFile(String filepath){
		try {
			File file=new File(filepath);
			StringBuilder sb=new StringBuilder();
			if(file.isFile() && file.exists()){
					InputStreamReader reader=new InputStreamReader(new FileInputStream(file));
					BufferedReader buffer=new BufferedReader(reader);
					String lineTxt=null;
					while((lineTxt=buffer.readLine())!=null){
						sb.append(lineTxt);
					}
					reader.close();
			}else{
				System.out.println("文件"+filepath+"不存在,请检查之后再输入~~~");
				System.exit(0);
			}
			String[] sa={};
			if(sb.length()!=0){
				sa=sb.toString().split("\\W+");
			} 
			
			HashMap<String,Integer> map=new HashMap<String,Integer>();
			for(String s:sa){
				if(map.containsKey(s)){
					int x=map.get(s);
					map.put(s,x++);
				}else{
					map.put(s, 1);
				}	
			}
			return sa;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("文件读取出错");
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	//本来想对每个问题写一个方法，后来发现写在main函数中好像更方便些，只是不利于扩展
	
	/*//使用一个set对两个文本进行过滤，获取不重复的单词，也可使用removeall函数
	public HashSet<String> getAllWord(String filePath1,String filePath2){
		String[] arr1=readTXTFile(filePath1);
		String[] arr2=readTXTFile(filePath2);
		HashSet<String> set=new HashSet<String>();
		for(String s:arr1){
			 set.add(s);
		}
		for(String s:arr2){
			set.add(s);
		}
		for(String s:set){
			System.out.println(s);
		}
		
		return set;
	}
	
	//调用retainAll函数获取交集
	public HashSet getIntersectWords(String filePath1,String filePath2){
		String[] arr1=readTXTFile(filePath1);
		String[] arr2=readTXTFile(filePath2);
		HashSet<String> set1=new HashSet<String>();
		HashSet<String> set2=new HashSet<String>();
		for(String s:arr1){
			 set1.add(s);
		}
		for(String s:arr2){
			set2.add(s);
		}
		HashSet<String> retainSet=new HashSet<String>(set1);
		retainSet.retainAll(set2);
		return retainSet;
	}
	
	public int[] countWordNumber(String filePath1,String filePath2){
		int[] wordNum=new int[2];
		String[] arr1=readTXTFile(filePath1);
		String[] arr2=readTXTFile(filePath2);
		wordNum[0]=arr1.length;
		wordNum[1]=arr2.length;
		return wordNum; 
		
	}*/
	
	
}
