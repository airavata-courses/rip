package com.kafka.extractor.Entities;

import java.util.ArrayList;

public class MetaData {
	
	public MetaData(String elementName, String phase, String spectra, String waveLength, ArrayList<Coordinate> coordinates)
	{
		this.ElementName = elementName;
		this.Phase = phase;
		this.Spectra = spectra;
		this.WaveLength = waveLength;
		this.Coordinates = coordinates;
	}
	
	public String ElementName;
	public String Spectra;
	public String Phase;
	public String WaveLength;
	
	public ArrayList<Coordinate> Coordinates;  
}

