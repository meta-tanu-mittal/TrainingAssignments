package com.metacube.training.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class GraphTest {

	@Test
	public void testIsConnected() {
		UndirectedGraph obj=new UndirectedGraph(4);
		assertTrue(obj.addEdge(new GraphEdge(1,2,10)));
		assertTrue(obj.addEdge(new GraphEdge(1,3,8)));
		assertTrue(obj.addEdge(new GraphEdge(3,2,6)));
		assertTrue(obj.addEdge(new GraphEdge(3,0,4)));
		assertTrue(obj.addEdge(new GraphEdge(0,2,2)));
		assertTrue(obj.isConnected());
	}
	
	
	@SuppressWarnings("serial")
	@Test
	public void testIsReachable() {
		UndirectedGraph obj=new UndirectedGraph(4);
		assertTrue(obj.addEdge(new GraphEdge(1,2,10)));
		assertTrue(obj.addEdge(new GraphEdge(1,3,8)));
		assertTrue(obj.addEdge(new GraphEdge(3,2,6)));
		assertTrue(obj.addEdge(new GraphEdge(3,0,4)));
		assertTrue(obj.addEdge(new GraphEdge(0,2,2)));
		Set<Integer> expected=new HashSet<Integer>(){{add(0);add(1);add(2);add(3);}};
		assertEquals(expected,obj.reachable(0));
	}

	
	@Test
	public void testMinimumSpanningTree() throws GraphException {
		UndirectedGraph obj=new UndirectedGraph(4);
		assertTrue(obj.addEdge(new GraphEdge(1,2,10)));
		assertTrue(obj.addEdge(new GraphEdge(1,3,8)));
		assertTrue(obj.addEdge(new GraphEdge(3,2,6)));
		assertTrue(obj.addEdge(new GraphEdge(3,0,4)));
		assertTrue(obj.addEdge(new GraphEdge(0,2,2)));
		List<GraphEdge> expected=new ArrayList<GraphEdge>();
		expected.add(new GraphEdge(0,2,2));
		expected.add(new GraphEdge(3,0,4));
		expected.add(new GraphEdge(1,3,8));
		List<GraphEdge> result=obj.minimumSpanningTree();
		for(int i=0;i<result.size();i++)
		{
			assertEquals(expected.get(i).getVertex1(),result.get(i).getVertex1());
			assertEquals(expected.get(i).getVertex2(),result.get(i).getVertex2());
			assertEquals(expected.get(i).getWeight(),result.get(i).getWeight());
		}
	
	}
	
	@Test
	public void testShortestPath() throws GraphException {
		UndirectedGraph obj=new UndirectedGraph(4);
		assertTrue(obj.addEdge(new GraphEdge(1,2,10)));
		assertTrue(obj.addEdge(new GraphEdge(1,3,8)));
		assertTrue(obj.addEdge(new GraphEdge(3,2,6)));
		assertTrue(obj.addEdge(new GraphEdge(3,0,4)));
		assertTrue(obj.addEdge(new GraphEdge(0,2,2)));
		assertEquals(12,obj.shortestPath(0, 1));
	
	}

}
