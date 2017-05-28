package co.edu.usb.clusterbp.control;

import java.io.IOException;
import java.math.BigDecimal;

import java.util.*;

import org.primefaces.event.FileUploadEvent;

import co.edu.usb.clusterbp.Cluster;
import co.edu.usb.clusterbp.Consulta;
import co.edu.usb.clusterbp.Pn;
import co.edu.usb.clusterbp.dto.PnDTO;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
public interface IPnLogic {
	public ArrayList<Pn> obtenerProcesos() throws Exception;
	public String[] crearProceso(Pn[] listXPDL);
	public String construirEstructuraProceso(String XPDL);
	public ArrayList<Cluster> obtenerClustering(Consulta consulta);
	
	public List<Pn> getPn() throws Exception;

	/**
	 * Save an new Pn entity
	 */
	public void savePn(Pn entity) throws Exception;

	/**
	 * Delete an existing Pn entity
	 *
	 */
	public void deletePn(Pn entity) throws Exception;

	/**
	 * Update an existing Pn entity
	 *
	 */
	public void updatePn(Pn entity) throws Exception;
	
	public List<PnDTO> getDataPn() throws Exception;

	public List<PnDTO> getDataPnI() throws Exception;
	
	public Pn getPn(Long pnCodigo) throws Exception;
	
	//TODO: Metodos;

	public String analisisTextual(FileUploadEvent event);
	
	public String cadenaClustering();

	//TODO: Consultas
	public Pn consultarPNPorNombre (String nombre);

}
