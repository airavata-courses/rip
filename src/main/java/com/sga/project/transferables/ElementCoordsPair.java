package com.sga.project.transferables;

import java.util.List;

public class ElementCoordsPair {
	String fileName;
	List<Coordinate> data;
	
	public ElementCoordsPair(String fileName, List<Coordinate> data)
	{
		this.fileName = fileName;
		this.data = data;
	}
	
}
