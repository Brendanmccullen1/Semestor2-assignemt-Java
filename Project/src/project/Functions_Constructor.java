package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Functions_Constructor extends Gui {
	
	//Declaration of variables and lists
	//-------------------------------------------------------------------------------------
	
	static ArrayList<String>Stopwords;
	static ArrayList<String>File1;
	static ArrayList<String>File2;
	static ArrayList<String>File1_edited;
	static ArrayList<String>File2_edited;
	int size_1;
	int size_2;
	JFrame f1 = new JFrame();
	JFrame f2 = new JFrame();
	JFrame f3 = new JFrame();
	
	//------------------------------------------------------------------------------------
	
	
	//Constructor
	//------------------------------------------------------------------------------------
	
	Functions_Constructor(String i, String j) throws IOException
	{
		//Reading the Stop words file into an Arraylist
		//-----------------------------------------------------------------------------------
		
        BufferedReader bufReader3 = new BufferedReader(new FileReader("Stop_Words.txt"));
        ArrayList<String>arraylist3 = new ArrayList<String>();
        
        String line3 = bufReader3.readLine();
        while (line3 != null) { 
        	arraylist3.add(line3);
        	line3 = bufReader3.readLine();
        	} 
        bufReader3.close();
        
        //------------------------------------------------------------------------------------
        
        //Reading the first file chosen into a Arraylist
        //-------------------------------------------------------------------------------------
    	FileReader Filereader = new FileReader(i);
        ArrayList<String>Arraylist1 = new ArrayList<String>();
        
        String s = new String();
        char ch;
        
        while(Filereader.ready()) 
        {
        	ch = (char)Filereader.read();
        	
        	if (ch=='\n' || ch == ' ' || ch ==',') 
        	{
        		Arraylist1.add(s.toString());
        		s = new String();
        	}
        	else 
        	{
        		s += ch;
        	}
        }
        if (s.length() > 0) 
        {
        	Arraylist1.add(s.toString());
        }
        
        int size = Arraylist1.size();
        //--------------------------------------------------------------------------------------
        
        //Reading the second file chosen into a Arraylist
        //--------------------------------------------------------------------------------------
        
        FileReader Filereader2 = new FileReader(j);
        ArrayList<String>Arraylist2 = new ArrayList<String>();
        
        String s2 = new String();
        char ch2;
        
        while(Filereader2.ready()) {
        	ch2 = (char)Filereader2.read();
        	
        	if (ch2=='\n' || ch2 == ' ' || ch2 ==',') {
        		Arraylist2.add(s2.toString());
        		s2 = new String();
        	}
        	else {
        		s2 += ch2;
        	}
        }
        if (s2.length() > 0) {
        	Arraylist2.add(s2.toString());
        }
        
        int size2 = Arraylist2.size();
        //-------------------------------------------------------------------------------------------
        
        //saving variables to global variables to use in functions
        //-------------------------------------------------------------------------------------------
        
        File2 = Arraylist2;
        File1 = Arraylist1;
        Stopwords = arraylist3;
	}
	
	//---------------------------------------------------------------------------------------
	
	//function to print the elements of stop words
	//--------------------------------------------------------------------------------------
	
	public void print_stop_words()
	{
		Iterator<String> itr = Stopwords.iterator();
		while(itr.hasNext())
		{
		System.out.println(itr.next());
		}
	}
	
	//---------------------------------------------------------------------------------------
	
	
	//Function to remove the stop words from file1
	//--------------------------------------------------------------------------------------
	public void remove_stop_words_1()
	{
		File1.removeAll(Stopwords);
	}
	
	//---------------------------------------------------------------------------------------
	
	
	//Function to remove the stop words from file1
	//--------------------------------------------------------------------------------------
	public void remove_stop_words_2()
	{
		File2.removeAll(Stopwords);
	}
	
	//--------------------------------------------------------------------------------------
	
	
	//Sorts elements in File 1 and finds the 10 most common elements in the file
	//--------------------------------------------------------------------------------------
	public void Top_10_elements_1()
	{
		HashMap<String, Integer> languageMap = convertArrayListToHashMap(File1);
		HashMap<String, Integer> sorted =  sortedhashmap(languageMap);
		TreeMap<String, Integer> firstten = putFirstEntries(10, sorted);
        Set<String> setKeys = firstten.keySet();
        ArrayList<String> listKeys = new ArrayList<String>(setKeys);
        System.out.println(listKeys);
        File1_edited = listKeys;
        size_1 = listKeys.size();
		jArea.append("The top 10 elements in File 2 is \n" + File1_edited + "\n");
	}
	
	//--------------------------------------------------------------------------------------
	
	//Sorts elements in File 2 and finds the 10 most common elements in the file
	//--------------------------------------------------------------------------------------
	public void Top_10_elements_2()
	{
        HashMap<String, Integer> languageMap2 = convertArrayListToHashMap(File2);
        HashMap<String, Integer> sorted2 =  sortedhashmap(languageMap2);
        TreeMap<String, Integer> firstten2 = putFirstEntries(10, sorted2);
        Set<String> setKeys2 = firstten2.keySet();
        ArrayList<String> listKeys2 = new ArrayList<String>(setKeys2);
        System.out.println(listKeys2);
        File2_edited = listKeys2;
		jArea.append("The top 10 elements in File 1 is \n" + File2_edited +"\n\n" );
	}
	
	//-------------------------------------------------------------------------------------
	
	//Function to add words to stop words
	//--------------------------------------------------------------------------------------
	public void add_to_stop_words(String i) throws FileNotFoundException
	{
		PrintWriter out = new PrintWriter("Stop_Words.txt");
		out.print(input3);
		out.close();
		
	}
	
	//-------------------------------------------------------------------------------------
	
	
	//Function to find the common elements in the 2 top ten words arraylists
	//-------------------------------------------------------------------------------------
	public void common_elements()
	{
		File1_edited.retainAll(File2_edited);
        jArea.append("Common elements: " + File1_edited + "\n\n");
        size_2 = File1_edited.size();
	}
	
	//-------------------------------------------------------------------------------------
	
	//Function to about how likely the files are related
	//-------------------------------------------------------------------------------------
	public void percentage_similar()
	{
		double percentage;
		percentage = size_2 * 10;
		
		System.out.println(size_2);
		jArea.append("The percentage chance of the 2 articles are related is " + percentage +"%\n");
	}
	
	//-------------------------------------------------------------------------------------------
	
	//Function to convert arraylist to Hashmap
	//-------------------------------------------------------------------------------------------
	private static HashMap<String, Integer>convertArrayListToHashMap(ArrayList<String> arrayList)
	{

		LinkedHashMap<String, Integer> linkedHashMap= new LinkedHashMap<>();
		for(String i :arrayList) 
		{
			Integer j = linkedHashMap.get(i);
			linkedHashMap.put(i, (j ==null) ? 1: j + 1);
		}
		return linkedHashMap;
	}
	
	//--------------------------------------------------------------------------------------------
	
	//Function to put hashmap into tree map
	//--------------------------------------------------------------------------------------------
	public static TreeMap<String, Integer> putFirstEntries(int max, HashMap<String, Integer> source) 
	{
		  int count = 0;
		  TreeMap<String, Integer> target = new TreeMap<String, Integer>();
		  for (Map.Entry<String, Integer> entry:source.entrySet()) 
		  {
		     if (count >= max) break;

		     target.put(entry.getKey(), entry.getValue());
		     count++;
		  }
		  return target;
	}
	
	//---------------------------------------------------------------------------------------------
	
	//Function to sort the elements by how many times they appear in the article
	//---------------------------------------------------------------------------------------------
	public static HashMap<String, Integer> sortedhashmap(HashMap<String, Integer> Map)
	{
		LinkedHashMap<String, Integer> sortedmap = new LinkedHashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		for (Entry<String, Integer> entry : Map.entrySet()) 
		{
			list.add(entry.getValue());
		}
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(int num : list) 
		{
			for(Entry<String, Integer> entry : Map.entrySet())
			{
				if (entry.getValue().equals(num)) 
				{
					sortedmap.put(entry.getKey(), num);
				}
			}
		}
		return sortedmap;
		
	}
	
	//----------------------------------------------------------------------------------------------
}

