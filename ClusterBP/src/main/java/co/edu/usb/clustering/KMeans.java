package co.edu.usb.clustering;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import co.edu.usb.clustering.DistanceFunction;
import co.edu.usb.clustering.AlgoKMeans;
import co.edu.usb.clustering.ClusterWithMean;
import co.edu.usb.clustering.DoubleArray;
import co.edu.usb.clustering.DistanceEuclidian;

/**
 *  Example of how to use the KMEans algorithm, in source code.
 */
public class KMeans {
	
	public static void main(String []args) throws NumberFormatException, IOException{
		
		String input = fileToPath("inputDBScan2.txt");
		// Cantidad de Clusters "K"
		int k=3;	
		
		// Especificación del separador de las lineas. Si los conjuntos de datos estan separados por "," ";" " ".. Etc.
		String separator = ",";
		
		// Especificar algoritmo para calcular la distancia. En este caso es la distancia Euclidiana
		DistanceFunction distanceFunction = new DistanceEuclidian(); 
		
		// Llamando al metodo que contiene el algoritmo
		AlgoKMeans algoKMeans = new AlgoKMeans();  
		List<ClusterWithMean> clusters = algoKMeans.runAlgorithm(input, k, distanceFunction, separator);
		algoKMeans.printStatistics();
		
		// Print the clusters found by the algorithm
		// For each cluster:
		int i=0;
		for(ClusterWithMean cluster : clusters) {
			System.out.println("Cluster " + i++);
			// For each data point:
			for(DoubleArray dataPoint : cluster.getVectors()) {
				System.out.println("   " + dataPoint);
			}
		}
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = KMeans.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
	
	
}
