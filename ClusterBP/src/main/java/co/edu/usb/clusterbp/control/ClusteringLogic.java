package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.PnTxt;
import co.edu.usb.clustering.AlgoKMeans;
import co.edu.usb.clustering.ClusterWithMean;
import co.edu.usb.clustering.DistanceEuclidian;
import co.edu.usb.clustering.DistanceFunction;
import co.edu.usb.clustering.DoubleArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;

@Scope("singleton")
@Service("ClusteringLogic")
public class ClusteringLogic implements IClusteringLogic {
	private static final Logger log = LoggerFactory.getLogger(ClusteringLogic.class);

	@Autowired
	IPnTxtLogic pnTxtLogic;

	String archivoTxt="cluster.txt";
	
	File fichero;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String clustering(int k) {
		try {
			String input = fileToPath("inputDBScan2.txt");

			// Especificación del separador de las lineas. Si los conjuntos de datos estan separados por "," ";" " ".. Etc.
			String separator = ",";

			// Especificar algoritmo para calcular la distancia. En este caso es la distancia Euclidiana
			DistanceFunction distanceFunction = new DistanceEuclidian(); 

			// Llamando al metodo que contiene el algoritmo
			AlgoKMeans algoKMeans = new AlgoKMeans();  
			List<ClusterWithMean> clusters = algoKMeans.runAlgorithm(input, 3, distanceFunction, separator);
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
		} catch (UnsupportedEncodingException e) {
			log.error("Error! ClusteringLogic: No se pudo leer el archivo");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			log.error("Error!ClusteringLogic: El formato es incorrecto");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("Error! ClusteringLogic");
			e.printStackTrace();
		}
		return "";
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = ClusteringLogic.class.getResource(filename);
		return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}

	public File crearTxt(){
		List<PnTxt> texto;
		fichero= new File(archivoTxt);
		BufferedWriter bw = null ;
		FileWriter w =null;
		try {
			w=new FileWriter(fichero);
			bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			wr.write("@NAME=Pizza Colaboration.bpmn\n1,1,3,19,83,0.4,1,12,92,31");
			//texto=pnTxtLogic.getPnTxt();
			//for(PnTxt tipoArchivoPn: texto){
				//bw.write("@NAME="+tipoArchivoPn.getPn().getTitulo());
				wr.append("@NAME=Felipe\n1,1,3,19,83,0.4,1,12,92,31");
				//bw.write(tipoArchivoPn.getClustering());
				//bw.newLine();
			//}
			wr.close();
			bw.close();
		} catch (IOException e) {
			log.error("Error! No se puede escribir en el archivo");
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Error! No se puede obtener la lista de PN Txt");
			e.printStackTrace();
		}
		
		
		Scanner s;
		try {
			s = new Scanner(fichero);
			while (s.hasNextLine()) {
				String linea = s.nextLine(); 	// Guardamos la linea en un String
				System.out.println(linea);      // Imprimimos la linea
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return fichero;
	}

}
