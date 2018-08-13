package com.metacube.training.nestedJSON.task6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NestedJSON {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
List<List<Integer>> nestedList=new ArrayList<List<Integer>>();
        
        try {
            JSONParser parser=new JSONParser();
            Object object=parser.parse(new FileReader("readNestedList.json"));
            JSONObject jsonObject=(JSONObject)object;
            for(Object jsonKey:jsonObject.keySet())
            {
                int key=Integer.parseInt(jsonKey.toString());
                System.out.println(key);
                JSONArray jsonArray= (JSONArray) jsonObject.get(jsonKey);
                List<Integer> list=new ArrayList<>();
                for (Object value : jsonArray) {
                    list.add(Integer.parseInt(value.toString()));
                } 
                nestedList.add(list);
               
            }
            NestedList obj=new NestedList(nestedList);
            System.out.println(obj.sum());
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("file not found");
        }
	}

}
