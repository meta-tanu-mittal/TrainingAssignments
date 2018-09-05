package com.metacube.training;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionExample {
	private List nameList;
	private Set nameSet;
	private Map nameMap;

	public void setNameList(List nameList) {
		this.nameList = nameList;
	}

	public List getNameList() {
		System.out.println("List Elements :" + nameList);
		return nameList;
	}

	public Set getNameSet() {
		System.out.println("Set Elements :" + nameSet);
		return nameSet;
	}

	public void setNameSet(Set nameSet) {
		this.nameSet = nameSet;
	}

	public Map getNameMap() {
		System.out.println("Hash Elements:" + nameMap);
		return nameMap;
	}

	public void setNameMap(Map nameMap) {
		this.nameMap = nameMap;
	}

}
