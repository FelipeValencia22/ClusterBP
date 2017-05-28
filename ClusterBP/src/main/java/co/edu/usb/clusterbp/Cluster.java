package co.edu.usb.clusterbp;

import java.io.File;
import java.util.ArrayList;

public class Cluster implements java.io.Serializable {
	
	private String nombreCluster;
	private ArrayList<Pn> clusterProcesos = new ArrayList<Pn>();
	private int numeroProcesos;
	public String getNombreCluster() {
		return nombreCluster;
	}
	public void setNombreCluster(String nombreCluster) {
		this.nombreCluster = nombreCluster;
	}

	public int getNumeroProcesos() {
		return numeroProcesos;
	}
	public void setNumeroProcesos(int numeroProcesos) {
		this.numeroProcesos = numeroProcesos;
	}
	public ArrayList<Pn> getClusterProcesos() {
		return clusterProcesos;
	}
	public void setClusterProcesos(ArrayList<Pn> listaProces) {
		this.clusterProcesos = listaProces;
	}
}
