package com.metacube.training.commandPrompt.task1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory {
	private String directoryName;
	private Date creationDate;
	private Directory parent;
	private List<Directory> listOfSubdirectory;
    
	
	public Directory(String name,Directory parent)
	{
		this.directoryName=name;;
		this.parent=parent;
		creationDate=new Date();
		listOfSubdirectory=new ArrayList<Directory>();
	}
	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String name) {
		this.directoryName = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public List<Directory> getListOfSubdirectory() {
		return listOfSubdirectory;
	}

	public void addDirectory(Directory directory) {
		listOfSubdirectory.add(directory);
	}

}
