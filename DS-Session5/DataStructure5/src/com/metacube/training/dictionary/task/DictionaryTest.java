package com.metacube.training.dictionary.task;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Test;

public class DictionaryTest {

	@Test
	public void testAddEntry() throws FileNotFoundException, IOException, ParseException {
		BinarySearchTree obj = new BinarySearchTree();
		obj.addFile(new File("dictionary.json"));
		obj.addEntry(new Data("apple", "fruit"));
		List<Data> expected = new ArrayList<Data>();
		expected.add(new Data("apple", "fruit"));
		expected.add(new Data("namrata", "agarwal"));
		expected.add(new Data("richa", "jain"));
		expected.add(new Data("tanu", "mittal"));
		expected.add(new Data("twinkle", "garg"));
		List<Data> result = obj.getSortedList();
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expected.get(i).getKey(), result.get(i).getKey());
		}

	}

	@Test
	public void testDeleteEntry() throws FileNotFoundException, IOException, ParseException {
		BinarySearchTree obj = new BinarySearchTree();
		obj.addFile(new File("dictionary.json"));
		obj.addEntry(new Data("apple", "fruit"));
		obj.deleteEntry("namrata");
		List<Data> expected = new ArrayList<Data>();
		expected.add(new Data("apple", "fruit"));
		expected.add(new Data("richa", "jain"));
		expected.add(new Data("tanu", "mittal"));
		expected.add(new Data("twinkle", "garg"));
		List<Data> result = obj.getSortedList();
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expected.get(i).getKey(), result.get(i).getKey());
		}

	}

	@Test
	public void testFindValue() throws FileNotFoundException, IOException, ParseException {
		BinarySearchTree obj = new BinarySearchTree();
		obj.addFile(new File("dictionary.json"));
		assertEquals("mittal", obj.searchValueFromKey("tanu"));

	}

	@Test
	public void testBetweenKeys() throws FileNotFoundException, IOException, ParseException {
		BinarySearchTree obj = new BinarySearchTree();
		obj.addFile(new File("dictionary.json"));
		obj.addEntry(new Data("apple", "fruit"));
		List<Data> expected = new ArrayList<Data>();
		expected.add(new Data("namrata", "agarwal"));
		expected.add(new Data("richa", "jain"));
		List<Data> result = obj.findBetweenKeys("n", "t");
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expected.get(i).getKey(), result.get(i).getKey());
		}
	}
}
