package project;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;


public class Gui extends JFrame 
{
	//Declaration variables and attributes
	//-----------------------------------------------------------------------
		JTextField text1 , text2 , text3;
	    JLabel label1 , label3;
	    JTextArea jArea;
	    ButtonListener1 bl1;
	    ButtonListener2 bl2;
	    String input1 , input2 , input3;
	    Functions_Constructor Stop_words;
	    JFileChooser j;
	    JFileChooser i;
	//-----------------------------------------------------------------------
	    
	//GUI
	//-----------------------------------------------------------------------
	    public Gui()
	    {
	        //Get the container
	        Container container1 = getContentPane();
	        
	        //Set title
	        setTitle("My Project");

	        //Set absolute layout        
	        container1.setLayout(null);   


	        //Creating label for button for choosing 2 files 
	        JLabel label1=new JLabel("Please choose 2 txt files to compare");
	        label1.setSize(270,20);
	        label1.setLocation(130,60);
	        
	        //label for a button for adding a word to stop words
	        JLabel label3=new JLabel("Add Stop Word: ");
	        label3.setSize(270, 20);
	        label3.setLocation(100,100);
	        
	        //Creating TextField for input of new stop word     
	        text3 = new JTextField(10);
	        text3.setSize(120, 30);
	        text3.setLocation(275, 100);
	        
	        //adding a jArea for which to print output of functions
	        jArea = new JTextArea(5,20);
	        jArea.setSize(400,200);
	        jArea.setLocation(60,170);
	        
	        //creating button for choosing 2 files
	        JButton button1=new JButton("Pick 2 Files");
	        button1.setSize(100,20);
	        button1.setLocation(210,35);
	        bl1=new ButtonListener1();        
	        button1.addActionListener(bl1);

	        //creating button for adding stop words
	        JButton button2=new JButton("Add stop word");
	        button2.setSize(150,20);
	        button2.setLocation(210,140);
	        bl2=new ButtonListener2();
	        button2.addActionListener(bl2);
	        
	        //changes the backround color of the container   
	        container1.setBackground(Color.cyan);
	        
	        //Place the components in the panel 
	        container1.add(label1);        
	        container1.add(label3);
	        container1.add(text3);
	        container1.add(button1);
	        container1.add(button2);
	        container1.add(jArea);

	    

	        //Set the size of the window and display it
	        setSize(550,350);
	        setVisible(true);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    }
	    
	 //end GUi
	 //-----------------------------------------------------------------------------
	    
	 //Button 1 (Pick 2 Files)
	 //------------------------------------------------------------------------------
	    
	    private class ButtonListener1 implements ActionListener 
	    {
	    	//declaration of Jframes
	    	
	    	JFrame f = new JFrame();	
	    	JFrame f1 = new JFrame();
	    	
			public void actionPerformed(ActionEvent e) 
			{
				//In this process argument passed is an object of File System View
				
				//File Chooser for file 1
				//---------------------------------------------------------------------------------------------------
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				
				int r = j.showSaveDialog(null);
				
				if(r == JFileChooser.APPROVE_OPTION)
				{
					input1 = j.getSelectedFile().getAbsolutePath();
					JOptionPane.showMessageDialog(f1, input1);
				}
				else
				{
					text1.setText("User Canceled");
				}
				//File 1 Chooser Close
				//----------------------------------------------------------------------------------------------------
				
				// File Chooser for File 2
				//----------------------------------------------------------------------------------------------------
				JFileChooser i = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				
				int k = i.showSaveDialog(null);
				
				if(k == JFileChooser.APPROVE_OPTION)
				{
					input2 = i.getSelectedFile().getAbsolutePath();
					JOptionPane.showMessageDialog(f1, input2);
				}
				else
				{
					text1.setText("User Canceled");
				}
				//File 2 Chooser Close
				//----------------------------------------------------------------------------------------------------
				
				//Functions from Functions_Constructor
				//---------------------------------------------------------------------------------------------------
				
				 try {
					 //Instigates constructor of Functions_Constructor
					 //---------------------------------------------------------------------------------------------------
					 
					Functions_Constructor Stop_words =  new Functions_Constructor(input1,input2);
					
					//function to remove stop words from file1
					Stop_words.remove_stop_words_1();
					//Function to sort elements in file1 and take top 10 elements
					Stop_words.Top_10_elements_1();
					
					//function to remove stop words from file1
			        Stop_words.remove_stop_words_2();
			        //Function to sort elements in file1 and take top 10 elements
			        Stop_words.Top_10_elements_2();
			        
			        //function to find common elements of the top ten elements
			        Stop_words.common_elements();
			        //function to show the percentage chance they are similar
			        Stop_words.percentage_similar();
			        
			        //frame to show that the buttons functions has completed
					JOptionPane.showMessageDialog(f, "Files have been analysed.");
			        
			        } 
				 //catch to show if the constructor fails
				 catch (IOException e1) 
				 {
					e1.printStackTrace();
				 }
			}
	    	
	    }
	    
	    //Button 1 (Pick 2 Files) finished
	    //--------------------------------------------------------------------------------------------------------------
	    
	    
	    //Button 2(add to stop words)
	    //--------------------------------------------------------------------------------------------------------------
	    
	    private class ButtonListener2 implements ActionListener 
	    {
	    	//declaration of frames
	    	JFrame f1 = new JFrame();
	    	public void actionPerformed(ActionEvent e2) 
	    	{	
	    		//puts input in text3 into variable
				input3 = text3.getText();
				try 
				{
					//adds input into Stop_words.txt
					FileWriter out = new FileWriter("Stop_Words.txt",true);
					out.write("\n" + input3);
					out.close();
					//user prompt to show the word has been added
					JOptionPane.showMessageDialog(f1, "The word " + input3 + " has been added.");
				} 
				//catch to show if the constructor fails
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
	    	}
			
	    }
	    //Initialize the class
	    public static void main(String[] args) throws IOException
	    {
	    	//Instigates GUI
	        new Gui();
	    }
}
   
	