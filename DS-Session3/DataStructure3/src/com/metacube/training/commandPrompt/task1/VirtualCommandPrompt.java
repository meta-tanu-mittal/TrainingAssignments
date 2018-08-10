package com.metacube.training.commandPrompt.task1;

import java.util.List;
import java.util.Scanner;


public class VirtualCommandPrompt {
	
	private static Directory root;
	private static  Directory currentDirectory;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to cmd");
		root=new Directory("R:",null);
		currentDirectory=root;
		

		boolean flag=true;
		while(flag)
		{
			System.out.print(getFullPath(currentDirectory)+"/>");
			String command = sc.nextLine();
			String[] commandWords = command.split(" ");
			switch(commandWords[0])
			{
			case "mkdir":makeDirectory(commandWords[1],currentDirectory);
				break;
			case "cd":if(!(changeDirectory(commandWords[1])))
				  System.out.println("directory doesn't exist");
				 
				break;
			case "ls":List<Directory> subdirectory=currentDirectory.getListOfSubdirectory();
			         for(Directory dir:subdirectory)
			         {
			        	 System.out.println(dir.getDirectoryName());
			         }
				break;
			case "exit":flag=false;
				break;
				default:System.out.println("wrong command");
			}
		}
	}
	
	 public static String getFullPath(Directory dir) {
	        String prompt = dir.getDirectoryName();
	        while (dir.getParent() != null) {
	            prompt = dir.getParent().getDirectoryName() + "/" + prompt + "";
	            dir = dir.getParent();
	        }
	        return (prompt);
	    }
	 
	public static boolean changeDirectory(String name)
	{
		for(Directory directory:currentDirectory.getListOfSubdirectory())
		{
			if(name.equals(directory.getDirectoryName()))
			{  
			  currentDirectory=directory;
			  return true;	
			}
		}
		return false;
	}
	
	public static void makeDirectory(String name,Directory parent)
	{
		Directory directory = new Directory(name, parent);
        parent.addDirectory(directory);
	}

}
