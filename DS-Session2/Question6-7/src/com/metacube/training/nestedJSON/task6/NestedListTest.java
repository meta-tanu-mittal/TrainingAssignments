package com.metacube.training.nestedJSON.task6;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class NestedListTest {
	NestedList nestedListInstance;

	public NestedListTest() throws IOException, ParseException {
		try {

			List<List<Integer>> nestedList = new ArrayList<List<Integer>>();
			JSONParser parser = new JSONParser();
			Object object = parser.parse(new FileReader("readNestedList.json"));
			JSONObject jsonObject = (JSONObject) object;
			for (Object jsonKey : jsonObject.keySet()) {
				int key = Integer.parseInt(jsonKey.toString());
				JSONArray jsonArray = (JSONArray) jsonObject.get(jsonKey);
				List<Integer> list = new ArrayList<>();
				for (Object value : jsonArray) {
					list.add(Integer.parseInt(value.toString()));
				}
				nestedList.add(list);

			}
			nestedListInstance = new NestedList(nestedList);

		} catch (FileNotFoundException exception) {
			System.out.println("file not found");
		}

	}

	@Test
	public void testSum() {
		assertEquals(18, nestedListInstance.sum());
	}

	@Test
	public void testLargestValue() {
		assertEquals(6, nestedListInstance.largestValue());
	}

	@Test
	public void testSearchElement() {
		assertTrue(nestedListInstance.search(6));
	}

	@Test
	public void testNegativeSearch() {
		assertFalse(nestedListInstance.search(98));
	}

}
