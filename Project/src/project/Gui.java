package project;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Gui extends JFrame
{
JTextField text1 , text2 , text3;
	    JLabel label1 , label2 , label3;
	    JTextArea jArea;
	    ButtonListener bl1;
	    ButtonListener2 bl2;
	    ButtonListener3 bl3;

	    int rand;
	    int count=0;
	    String input1 , input2 , input3;
	    public Gui()
	    {
	        //Get the container
	        Container container1 = getContentPane();
	        
	        //Set title
	        setTitle("My gui");

	        //Set absolute layout        
	        container1.setLayout(null);   

	        //creating a generate random button
	        JButton button2=new JButton("Search");    
	        button2.setSize(100,20);
	        button2.setLocation(100,35);    
	        bl2=new ButtonListener2();        
	        button2.addActionListener(bl2);
	        
	        //creating a generate random button
	        JButton button3=new JButton("Delete");    
	        button3.setSize(210,20);
	        button3.setLocation(100,140);    
	        bl3=new ButtonListener3();        
	        button3.addActionListener(bl3);


	        //Creating label Enter a number..... 
	        JLabel label1=new JLabel("First File : ");
	        label1.setSize(270,20);
	        label1.setLocation(100,60);
	        
	        JLabel label2=new JLabel("Second File : ");
	        label2.setSize(270,20);
	        label2.setLocation(100,80);

	        //Creating TextField for input guess
	        text1=new JTextField(10);
	        text1.setSize(120,30);
	        text1.setLocation(275,60);
	        
	        
	        text2=new JTextField(10);
	        text2.setSize(120,30);
	        text2.setLocation(275,80);


	        //creating button for guess
	        JButton button1=new JButton("Save");
	        button1.setSize(100,20);
	        button1.setLocation(210,35);
	        bl1=new ButtonListener();        
	        button1.addActionListener(bl1);


	        //Place the components in the panel          
	        container1.add(label1);
	        container1.add(label2);
	        container1.add(text1);
	        container1.add(text2);
	        container1.add(button1);    
	        container1.add(button2);
	        container1.add(button3);
	    

	        //Set the size of the window and display it
	        setSize(550,350);
	        setVisible(true);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }

	    private class ButtonListener implements ActionListener 
	    {
	        public void actionPerformed(ActionEvent e)
	        {

	        }
	    }
	     
	    //generate a random number
	    private class ButtonListener2 implements ActionListener
	    {
	    	 public void actionPerformed(ActionEvent e)
	    	 {
	    		 File f1 = new File("Txt_1.txt");
	    	      String[] words=null;  //Intialize the word Array
	    	      FileReader fr = new FileReader(f1);  //Creation of File Reader object
	    	      BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
	    	      String s;     
	    	      String input="Java";   // Input word to be searched
	    	      int count=0;   //Intialize the word to zero
	    	      while((s=br.readLine())!=null)   //Reading Content from the file
	    	      {
	    	         words=s.split(" ");  //Split the word using space
	    	          for (String word : words) 
	    	          {
	    	                 if (word.equals(input))   //Search for the given word
	    	                 {
	    	                   count++;    //If Present increase the count by one
	    	                 }
	    	          }
	    	      }
	    	      if(count!=0)  //Check for count not equal to zero
	    	      {
	    	         System.out.println("The given word is present for "+count+ " Times in the file");
	    	      }
	    	      else
	    	      {
	    	         System.out.println("The given word is not present in the file");
	    	      }
	    			
	    	      fr.close();
	    	 }
	    }
	    private class ButtonListener3 implements ActionListener
	    {
			public void actionPerformed(ActionEvent e) 
			{
				
				
			}
	    	
	    }
	    //Initialize the class
	    public static void main(String[] args)
	    {
	        new Gui();
	    }
	}