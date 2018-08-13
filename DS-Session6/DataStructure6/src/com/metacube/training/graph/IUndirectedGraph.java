package com.metacube.training.graph;

import java.util.List;
import java.util.Set;

/**
 * interface for undirected weighted graph
 * 
 * @author Tanu Mittal
 *
 */
public interface IUndirectedGraph {
	/**
	 * check whether graph is connected or not
	 * 
	 * @return true if graph is connected
	 */
	boolean isConnected();

	/**
	 * find set of vertex that are reachable from a particular vertex
	 * 
	 * @param vertex
	 *            whose reachable edges are to find
	 * @return reachability vertex
	 */
	Set<Integer> reachable(int vertex);

	/**
	 * find minimum spanning tree
	 * 
	 * @return list of graph edges that form minimum spanning tree
	 */
	List<GraphEdge> minimumSpanningTree();

}
