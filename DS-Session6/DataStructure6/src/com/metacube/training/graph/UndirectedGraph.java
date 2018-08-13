package com.metacube.training.graph;

import com.metacube.training.stack.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * In Undirected Weighted Graph find 1 is graph connected 2 reachable vertex 3
 * minimum spanning tree
 * 
 * @author Tanu Mittal
 *
 */
public class UndirectedGraph implements IUndirectedGraph {
	private final int noOfVertex;
	private List<GraphEdge> listOfEdges;
	private int adjacencyMatrix[][];

	/**
	 * constructor
	 * 
	 * @param noOfVertex
	 *            is maximum number of vertex in graph
	 */
	public UndirectedGraph(int noOfVertex) {
		this.noOfVertex = noOfVertex;
		listOfEdges = new ArrayList<GraphEdge>();
		adjacencyMatrix = new int[noOfVertex][noOfVertex];
	}

	/**
	 * add edge to graph
	 * 
	 * @param edge
	 *            is a edge to be added in graph
	 * @return true if edge is added
	 */
	public boolean addEdge(GraphEdge edge) {
		if (edge.getWeight() > 0) {
			if (edge.getVertex1() >= 0 && edge.getVertex1() < noOfVertex
					&& edge.getVertex2() >= 0 && edge.getVertex2() < noOfVertex) {
				listOfEdges.add(edge);
				adjacencyMatrix[edge.getVertex1()][edge.getVertex2()] = edge
						.getWeight();
				adjacencyMatrix[edge.getVertex2()][edge.getVertex1()] = edge
						.getWeight();
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean isConnected() {

		Set<Integer> visitedNode = checkConnectivity(listOfEdges.get(0)
				.getVertex1());
		return this.noOfVertex == visitedNode.size();

	}

	/**
	 * find connected vertex
	 * 
	 * @param vertex
	 *            is a vertex to whom connected vertex are to be found
	 * @return set of connected vertex
	 */
	private Set<Integer> checkConnectivity(int vertex) {
		Set<Integer> visitedVertexSet = new HashSet<Integer>();
		StackUsingLinkList<Integer> stack = new StackUsingLinkList<>();
		stack.push(vertex);
		while (!(stack.isEmpty())) {
			int visitedVertex = stack.pop();
			visitedVertexSet.add(visitedVertex);
			for (int i = 0; i < noOfVertex; i++) {
				if (adjacencyMatrix[visitedVertex][i] > 0) {
					if (!(visitedVertexSet.contains(i))) {
						stack.push(i);
					}

				}
			}
		}
		return visitedVertexSet;

	}

	@Override
	public Set<Integer> reachable(int vertex) {
		Set<Integer> reachableVertex = checkConnectivity(vertex);
		return reachableVertex;
	}

	@Override
	public List<GraphEdge> minimumSpanningTree() {
		Set<Integer> visitedVertexSet = new HashSet<Integer>();
		List<GraphEdge> listOfVisitedEdge = new ArrayList<GraphEdge>();
		Collections.sort(listOfEdges);

		if (listOfEdges.size() <= 0) {
			throw new AssertionError("there are no edges in graph");
		} else {
			listOfVisitedEdge.add(listOfEdges.get(0));
			visitedVertexSet.add(listOfEdges.get(0).getVertex1());
			visitedVertexSet.add(listOfEdges.get(0).getVertex2());
			int i = 1;
			while (visitedVertexSet.size() != noOfVertex
					&& i < listOfEdges.size()) {
				GraphEdge edge = listOfEdges.get(i);
				if ((!visitedVertexSet.contains(edge.getVertex1()))
						|| (!visitedVertexSet.contains(edge.getVertex2()))) {
					listOfVisitedEdge.add(edge);
					visitedVertexSet.add(edge.getVertex1());
					visitedVertexSet.add(edge.getVertex2());

				}

				else {
					if ((visitedVertexSet.contains(edge.getVertex1()))
							&& (visitedVertexSet.contains(edge.getVertex2()))) {
						if (!(isCycle(listOfVisitedEdge, edge))) {
							listOfVisitedEdge.add(edge);
							visitedVertexSet.add(edge.getVertex1());
							visitedVertexSet.add(edge.getVertex2());

						}
					}
				}
				i++;

			}

		}

		if (visitedVertexSet.size() != noOfVertex) {
			throw new AssertionError("spanning tree not possible");
		}

		return listOfVisitedEdge;

	}

	/**
	 * check whether there is cycle in graph or not
	 * 
	 * @param visitedEdges
	 *            is a list of visited edges
	 * @param edge
	 *            is an edge
	 * @return
	 */
	private boolean isCycle(List<GraphEdge> visitedEdges, GraphEdge edge) {
		int startVertex = edge.getVertex1();
		List<GraphEdge> tempList = new ArrayList<GraphEdge>();
		for (GraphEdge graphEdge : visitedEdges) {
			tempList.add(graphEdge);
		}
		while (startVertex != edge.getVertex2()) {
			if (startVertex == -1) {
				return false;
			}
			int endVertex = findEndVertex(tempList, startVertex);
			startVertex = endVertex;
		}
		if (startVertex == edge.getVertex2()) {
			return true;
		}
		return false;
	}

	/**
	 * find vertex corresponding to start vertex
	 * 
	 * @param tempList
	 *            is a list of visited edges
	 * @param startVertex
	 *            is a vertex
	 * @return end vertex
	 */
	private int findEndVertex(List<GraphEdge> tempList, int startVertex) {
		for (int i = 0; i < tempList.size(); i++) {
			if (tempList.get(i).getVertex1() == startVertex) {
				int vertex = tempList.get(i).getVertex2();
				tempList.remove(i);
				return vertex;

			} else {
				if (tempList.get(i).getVertex2() == startVertex) {
					int vertex = tempList.get(i).getVertex1();
					tempList.remove(i);
					return vertex;
				}
			}
		}
		return -1;
	}

}