package com.metacube.training.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigration {
	
	@Bean
	public CollectionExample collectionExample()
	{
		CollectionExample collection=new CollectionExample();
		List<String> nameList=new ArrayList<String>();
		nameList.add("tanu");
		nameList.add("richa");
		nameList.add("tanu");
		
		Set<String> nameSet=new HashSet<String>();
		nameSet.add("tanu");
		nameSet.add("richa");
		nameSet.add("tanu");
		
		Map<Integer,String> nameMap=new HashMap<Integer,String>();
		nameMap.put(1,"tanu");
		nameMap.put(2, "richa");
		nameMap.put(3, "tanu");
		
		collection.setNameList(nameList);
		collection.setNameSet(nameSet);
		collection.setNameMap(nameMap);
		return collection;
	}

}
