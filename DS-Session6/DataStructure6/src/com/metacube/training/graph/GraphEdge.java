package com.metacube.training.graph;

/**
 * Graph Edge
 * 
 * @author Tanu Mittal
 *
 */
public class GraphEdge implements Comparable<GraphEdge> {
	private int vertex1;
	private int vertex2;
	private int weight;

	/**
	 * constructor
	 * 
	 * @param vertex1
	 *            is source vertex
	 * @param vertex2
	 *            is destination vertex
	 * @param weight
	 *            is distance between vertex
	 */
	public GraphEdge(int vertex1, int vertex2, int weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	public int getVertex1() {
		return vertex1;
	}

	public void setVertex1(int vertex1) {
		this.vertex1 = vertex1;
	}

	public int getVertex2() {
		return vertex2;
	}

	public void setVertex2(int vertex2) {
		this.vertex2 = vertex2;
	}

	@Override
	public String toString() {
		return "GraphEdge [vertex1=" + vertex1 + ", vertex2=" + vertex2
				+ ", weight=" + weight + "]";
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(GraphEdge edge) {
		// TODO Auto-generated method stub
		return this.getWeight() - edge.getWeight();
	}

}
