struct Coordinate {
	1: double WaveLength,
	2: double Y
}

struct MetaData {
	1: string ElementName,
	2: string Phase
	3: string Spectra
	4: string WaveLength
	5: list<Coordinate> Coordinates
}

service GetJSONService{
	string getJSONFile(1: string fileName),
}
