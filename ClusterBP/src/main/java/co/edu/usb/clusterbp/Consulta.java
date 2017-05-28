package co.edu.usb.clusterbp;

import java.io.Serializable;

public class Consulta implements Serializable{
	String consultaEstructural;
	String consultaTextual;
	String optionCluster;
    String minThreshold;
    String thresholdLvl;
    String k;
	String centroidStrategy;
    String firstCentroids;
    String epsilon;
    String minObjs;
	String message;
	String code;
    String iterations;

	public String getIterations() {
		return iterations;
	}
	public void setIterations(String iterations) {
		this.iterations = iterations;
	}
	public String getConsultaEstructural() {
		return consultaEstructural;
	}
	public void setConsultaEstructural(String consultaEstructural) {
		this.consultaEstructural = consultaEstructural;
	}
	public String getConsultaTextual() {
		return consultaTextual;
	}
	public void setConsultaTextual(String consultaTextual) {
		this.consultaTextual = consultaTextual;
	}
	public String getOptionCluster() {
		return optionCluster;
	}
	public void setOptionCluster(String optionCluster) {
		this.optionCluster = optionCluster;
	}
	public String getMinThreshold() {
		return minThreshold;
	}
	public void setMinThreshold(String minThreshold) {
		this.minThreshold = minThreshold;
	}
	public String getThresholdLvl() {
		return thresholdLvl;
	}
	public void setThresholdLvl(String thresholdLvl) {
		this.thresholdLvl = thresholdLvl;
	}
	public String getK() {
		return k;
	}
	public void setK(String k) {
		this.k = k;
	}

	public String getCentroidStrategy() {
		return centroidStrategy;
	}
	public void setCentroidStrategy(String centroidStrategy) {
		this.centroidStrategy = centroidStrategy;
	}
	public String getFirstCentroids() {
		return firstCentroids;
	}
	public void setFirstCentroids(String firstCentroids) {
		this.firstCentroids = firstCentroids;
	}
	public String getEpsilon() {
		return epsilon;
	}
	public void setEpsilon(String epsilon) {
		this.epsilon = epsilon;
	}
	public String getMinObjs() {
		return minObjs;
	}
	public void setMinObjs(String minObjs) {
		this.minObjs = minObjs;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
