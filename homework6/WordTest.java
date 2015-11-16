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
	 * @param aNumber,bNumber�ֱ��ʾA�ĵ���B�ĵ��ĵ�����
	 * @param unionSet��ʾ������retainSet��ʾ����
	 */
	public static void main(String[] args){
		WordTest wt=new WordTest();
		int aNumber=0;//A.txt words number
		int bNumber=0;//B.txt words number
		NumberFormat formatter=new DecimalFormat("0.000");
		Scanner sc=new Scanner(System.in);
		System.out.println("���ڵ�һ�������һ���ĵ���ַ���ڶ�������ڶ����ĵ���ַ");
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
		//addAll������ȡ����
		HashSet<String> unionSet=new HashSet<String>(set1);
		unionSet.addAll(set2);
		
		//retainAll������ȡ����
		HashSet<String> retainSet=new HashSet<String>(set1);
		retainSet.retainAll(set2);
		
		//��ȡ��A����B�е��ʵİٷֱȣ�removeAll������ȡֻ������ĳһ�ĵ��еĵ���
		HashSet<String> aSet=new HashSet<String>(set1);
		aSet.removeAll(set2);
		String aPer="";
		if(aNumber!=0){
			aPer=formatter.format(new Double((aSet.size()*1.0)/aNumber));
		}
		 
		
		//��ȡ��B����A�е��ʵİٷֱ�
		HashSet<String> bSet=new HashSet<String>(set2);
		bSet.removeAll(set1);
		String bPer="";
		if(bNumber!=0){
			bPer=formatter.format(new Double((bSet.size()*1.0)/bNumber)); 
		}
		
		
		System.out.println("���ļ����ʵĲ�������Ϊ:"+unionSet.size()+"\n�������ʷֱ�Ϊ:");
		for(String s:unionSet){
			System.out.print(s+",");
		}
		System.out.println();
		
		System.out.println("���ļ����ʵĽ�������Ϊ:"+retainSet.size()+"\n�������ʷֱ�Ϊ:");
		for(String s:retainSet){
			System.out.print(s+",");
		}
		System.out.println();
		
		System.out.println("��һ���ļ��еĵ�����Ϊ��"+aNumber);
		System.out.println("�ڶ����ļ��еĵ�����Ϊ��"+bNumber);
		 
		System.out.println("��A����B�еĵ�����ռA�ٷֱ�Ϊ��"+aPer);
		System.out.println("��B����A�еĵ�����ռB�ٷֱ�Ϊ��"+bPer);
	}
	
	//��ȡ�ļ���ͨ��������ʽ"\\W+"��ȡ���е���
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
				System.out.println("�ļ�"+filepath+"������,����֮��������~~~");
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
			System.out.println("�ļ���ȡ����");
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	//�������ÿ������дһ����������������д��main�����к��������Щ��ֻ�ǲ�������չ
	
	/*//ʹ��һ��set�������ı����й��ˣ���ȡ���ظ��ĵ��ʣ�Ҳ��ʹ��removeall����
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
	
	//����retainAll������ȡ����
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
