package project;
// Java Program to find common elements
// in two ArrayLists
// Using  Stream filter method
  
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// import ArrayList package
import java.util.*;
  
public class Compare {
  
    // main method
    public static void main(String[] args) throws IOException
    {
    	//-------------------------------------------------------------------------------------
    	
        BufferedReader bufReader3 = new BufferedReader(new FileReader("Stop_Words.txt"));
        ArrayList<String>Arraylist3 = new ArrayList<String>();
        
        String line3 = bufReader3.readLine();
        while (line3 != null) { 
        	Arraylist3.add(line3);
        	line3 = bufReader3.readLine();
        	} 
        bufReader3.close();
        //-----------------------------------------------------------------------
    	
    	
    	
        // create ArrayList list1
    	FileReader Filereader = new FileReader("Txt_1.txt");
        ArrayList<String>Arraylist1 = new ArrayList<String>();
        
        String s = new String();
        char ch;
        
        while(Filereader.ready()) {
        	ch = (char)Filereader.read();
        	
        	if (ch=='\n' || ch == ' ' || ch ==',') {
        		Arraylist1.add(s.toString());
        		s = new String();
        	}
        	else {
        		s += ch;
        	}
        }
        if (s.length() > 0) {
        	Arraylist1.add(s.toString());
        }
        
        int size = Arraylist1.size();
        Arraylist1.removeAll(Arraylist3);
        
        HashMap<String, Integer> languageMap = convertArrayListToHashMap(Arraylist1);
        //System.out.println(languageMap);
        
        TreeMap<String, Integer> firstten = putFirstEntries(10, languageMap);
        //System.out.println(firstten);
        
        Set<String> setKeys = firstten.keySet();
        
        List<String> listKeys = new ArrayList<String>(setKeys);
        System.out.println(listKeys);
        // print list 1
        
        
        
        //----------------------------------------------------------------------------------
  
        
        
        // Create ArrayList list2
        FileReader Filereader2 = new FileReader("Txt_2.txt");
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
        
        Arraylist2.removeAll(Arraylist3);
        
        HashMap<String, Integer> languageMap2 = convertArrayListToHashMap(Arraylist2);
        //System.out.println(languageMap2);
        
        TreeMap<String, Integer> firstten2 = putFirstEntries(10, languageMap2);
        //System.out.println(firstten2);
        
        Set<String> setKeys2 = firstten2.keySet();
        
        List<String> listKeys2 = new ArrayList<String>(setKeys2);
        System.out.println(listKeys2);
        
        //---------------------------------------------------------------------------
        //
        // print list 2
       // System.out.println("List1: "+ Arraylist1);
       // System.out.println("List2: " + Arraylist2);
        
       // System.out.println("Size of txt file 1: " + size);
       // System.out.println("Size of txt file 2: " + size2);
        
        listKeys.retainAll(listKeys2);
  
        // Find common elements
        System.out.print("Common elements: " + listKeys2);
    }
    
private static HashMap<String, Integer>convertArrayListToHashMap(ArrayList<String> arrayList)
{

	LinkedHashMap<String, Integer> linkedHashMap= new LinkedHashMap<>();
	for(String i :arrayList) {
		Integer j = linkedHashMap.get(i);
		linkedHashMap.put(i, (j ==null) ? 1: j + 1);
	}
	return linkedHashMap;
}
public static TreeMap<String, Integer> putFirstEntries(int max, HashMap<String, Integer> source) {
	  int count = 0;
	  TreeMap<String, Integer> target = new TreeMap<String, Integer>();
	  for (Map.Entry<String, Integer> entry:source.entrySet()) {
	     if (count >= max) break;

	     target.put(entry.getKey(), entry.getValue());
	     count++;
	  }
	  return target;
	}
}