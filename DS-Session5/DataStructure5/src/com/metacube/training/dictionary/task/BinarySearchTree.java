package com.metacube.training.dictionary.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * dictionary operations
 * 
 * @author Tanu Mittal
 *
 */
public class BinarySearchTree implements Dictionary {

	/**
	 * create node for tree
	 * 
	 * @author Tanu Mittal
	 *
	 */
	class Node {
		Data data;
		Node left;
		Node right;

		public Node(Data data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	private Node root;

	/**
	 * default constructor
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * add file to dictionary
	 * 
	 * @param file
	 *            is name of file to be added to dictionary
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void addFile(File file) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader(file));
		for (Object key : obj.keySet()) {
			addEntry(new Data(key.toString(), obj.get(key).toString()));
		}
	}

	/**
	 * add data entry to dictionary
	 */
	@Override
	public void addEntry(Data data) {
		root = insert(root, data);
	}

	/**
	 * function for addition of data in bst
	 * 
	 * @param root
	 *            is root of tree
	 * @param data
	 *            is data to be added to dictionary
	 * @return
	 */
	private Node insert(Node root, Data data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}

		if ((data.getKey()).compareToIgnoreCase(root.data.getKey()) > 0) {
			root.right = insert(root.right, data);
		} else {
			if ((data.getKey()).compareToIgnoreCase(root.data.getKey()) < 0) {
				root.left = insert(root.left, data);
			}
		}
		return root;

	}

	/**
	 * inorder traversal of tree
	 * 
	 * @param root
	 * @param sortedList
	 */
	private void inorder(Node root, List sortedList) {
		if (root != null) {
			inorder(root.left, sortedList);
			sortedList.add(new Data(root.data.getKey(), root.data.getValue()));
			inorder(root.right, sortedList);
		}

	}

	/**
	 * @return list of data in dictionary
	 */
	@Override
	public List<Data> getSortedList() {
		List<Data> sortedList = new ArrayList<Data>();
		inorder(root, sortedList);
		return sortedList;
	}

	/**
	 * display content of dictionary
	 */
	public void display() {
		for (Data data : getSortedList()) {
			System.out.println(data.getKey() + ":::" + data.getValue());
		}
	}

	/**
	 * helper method to find value corresponding to given key
	 * 
	 * @param root
	 * @param key
	 * @return node
	 */
	private Node findValue(Node root, String key) {
		if ((root.data.getKey()).equalsIgnoreCase(key)) {
			return root;
		}
		if ((key).compareToIgnoreCase(root.data.getKey()) > 0) {
			root.right = findValue(root.right, key);
		} else {
			if ((key).compareToIgnoreCase(root.data.getKey()) < 0) {
				root.left = findValue(root.left, key);
			}
		}
		return root;

	}

	@Override
	public String searchValueFromKey(String key) {

		Node node = findValue(root, key);
		return node.data.getValue();
	}

	@Override
	public List<Data> findBetweenKeys(String key1, String key2) {
		List<Data> listOfData = new ArrayList<Data>();
		for (Data data : getSortedList()) {
			if (((data.getKey().compareToIgnoreCase(key1)) >= 0 && ((data.getKey()).compareToIgnoreCase(key2) <= 0))) {
				listOfData.add(new Data(data.getKey(), data.getValue()));
			}
		}
		return listOfData;
	}

	@Override
	public void deleteEntry(String key) {
		root = deleteRec(root, key);
	}

	/**
	 * helper method for deletion
	 * 
	 * @param root
	 * @param key
	 * @return node that is to be deleted
	 */
	private Node deleteRec(Node root, String key) {
		if (root == null)
			return root;

		if ((root.data.getKey()).compareToIgnoreCase(key) > 0)
			root.left = deleteRec(root.left, key);
		else if ((root.data.getKey()).compareToIgnoreCase(key) < 0)
			root.right = deleteRec(root.right, key);

		else {

			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			root.data.setKey(minimumValue(root.right));

			root.right = deleteRec(root.right, root.data.getKey());
		}

		return root;
	}

	/**
	 * helper method for deletion
	 * 
	 * @param root
	 * @return minimum value
	 */
	private String minimumValue(Node root) {
		String minValue = root.data.getKey();
		while (root.left != null) {
			minValue = root.left.data.getKey();
			root = root.left;
		}
		return minValue;
	}

}
