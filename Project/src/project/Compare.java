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
        
        HashMap<String, Integer> languageMap = convertArrayListToHashMap(Arraylist1);
        for(String str : Arraylist1)
        {
            Integer value = languageMap.get(str) == null ? 0 : languageMap.get(str).getValue();
            value++;
            // if item exists, it'll be overriden.
            languageMap.put(str, value);
        }

  
        // print list 1
        
  
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
        
        
        BufferedReader bufReader3 = new BufferedReader(new FileReader("Stop_Words.txt"));
        ArrayList<String>Arraylist3 = new ArrayList<String>();
        
        String line3 = bufReader3.readLine();
        while (line3 != null) { 
        	Arraylist3.add(line3);
        	line3 = bufReader3.readLine();
        	} 
        bufReader3.close();
        
        Arraylist1.removeAll(Arraylist3);
        Arraylist2.removeAll(Arraylist3);
        
  
        // print list 2
        System.out.println("List1: "+ Arraylist1);
        System.out.println("List2: " + Arraylist2);
        
        System.out.println("Size of txt file 1: " + size);
        System.out.println("Size of txt file 2: " + size2);
        
        Arraylist1.retainAll(Arraylist2);
  
        // Find common elements
        System.out.print("Common elements: " + Arraylist1);
    }
    
private static HashMap<String, Integer>convertArrayListToHashMap(ArrayList<String> arrayList)
{

	LinkedHashMap<String, Integer> linkedHashMap= new LinkedHashMap<>();

	for (String str : arrayList) 
	{
		int value = linkedHashMap.get(str) == null;
		linkedHashMap.get(str).getValue();

		linkedHashMap.put(str, str.length());
	}

	return linkedHashMap;
}
}