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
	 	        BufferedReader reader1 = new BufferedReader(new FileReader("Txt_1.txt"));
		         
		        BufferedReader reader2 = new BufferedReader(new FileReader("Txt_2.txt"));
		         
		        String line1 = reader1.readLine();
		         
		        String line2 = reader2.readLine();
		         
		        boolean areEqual = true;
		         
		        int lineNum = 1;
		         
		        while (line1 != null || line2 != null)
		        {
		            if(line1 == null || line2 == null)
		            {
		                areEqual = false;
		                 
		                break;
		            }
		            else if(! line1.equalsIgnoreCase(line2))
		            {
		                areEqual = false;
		                 
		                break;
		            }
		             
		            line1 = reader1.readLine();
		             
		            line2 = reader2.readLine();
		             
		            lineNum++;
		        }
		         
		        if(areEqual)
		        {
		            System.out.println("Two files have same content.");
		        }
		        else
		        {
		            System.out.println("Two files have different content. They differ at line "+lineNum);
		             
		            System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
		        }
		         
		        reader1.close();
		         
		        reader2.close();
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