package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.UsuarioDTO;
import co.edu.usb.exceptions.*;
import co.edu.usb.kmeans.Cluster;
import co.edu.usb.kmeans.KMeans;
import co.edu.usb.kmeans.KMeansResultado;
import co.edu.usb.kmeans.Punto;
import co.edu.usb.presentation.businessDelegate.*;
import co.edu.usb.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.messages.Messages;
import org.primefaces.component.password.Password;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */

@ViewScoped
@ManagedBean(name = "clusterView")
public class ClusterView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ClusterView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ClusterView() {
		super();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public String datosCluster(){
		List<String[]> listaDatos = new ArrayList<String[]>();
		return "";
	}

//	public String ClusterBP(){
		//		CSVReader reader = new CSVReader(new FileReader("dato.csv"));
		//		FileWriter writer = new FileWriter("out.csv");
		//
		//		List<String[]> myEntries = reader.readAll();
		//		
		//		
		//		List<Punto> puntos = new ArrayList<Punto>();
		//
		//		for (String[] strings : myEntries) {
		//			Punto p = new Punto(strings);
		//			puntos.add(p);
		//		}
		//
		//		KMeans kmeans = new KMeans();
		//		for (int k = 1; k <= 5; k++) {
		//			KMeansResultado resultado = kmeans.calcular(puntos, k);
		//			writer.write("------- Con k=" + k + " ofv=" + resultado.getOfv()
		//			+ "-------\n");
		//			int i = 0;
		//			for (Cluster cluster : resultado.getClusters()) {
		//				i++;
		//				writer.write("-- Cluster " + i + " --\n");
		//				for (Punto punto : cluster.getPuntos()) {
		//					writer.write(punto.toString() + "\n");
		//				}
		//				writer.write("\n");
		//				writer.write(cluster.getCentroide().toString());
		//				writer.write("\n\n");
		//		}
		//		writer.close();
		//	}
//	}
}