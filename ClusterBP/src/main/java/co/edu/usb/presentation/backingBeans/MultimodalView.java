package  co.edu.usb.presentation.backingBeans;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.io.IOException;
import java.io.Serializable;
import java.sql.*;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.fileupload.FileUpload;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import  co.edu.usb.exceptions.*;
import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.PnDTO;
import co.edu.usb.presentation.businessDelegate.*;
import co.edu.usb.utilities.*;
/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 * 
 */


@ManagedBean
@ViewScoped
public class MultimodalView implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(MultimodalView.class);

	private InputTextarea txtBusqueda;
	private InputTextarea txtQuery;
	private InputTextarea txtResultado;
	private SelectOneMenu somListaEventos;
	private List<SelectItem> listTiposEventosItems;
	private CommandButton btnAddTexto;
	private CommandButton btnAddLista;
	private CommandButton btnBuscar;
	private CommandButton btnLimpiar;
	private SelectOneRadio rdTipoBusqueda;

	private List<TipoActividad> listaActividades;
	private List<TipoActividad> listaActividades2;

	private String query;
	private String transiciones;

	private String from;
	private String to;

	public SelectOneRadio getRdTipoBusqueda() {
		return rdTipoBusqueda;
	}

	public void setRdTipoBusqueda(SelectOneRadio rdTipoBusqueda) {
		this.rdTipoBusqueda = rdTipoBusqueda;
	}

	private SelectOneMenu somListaEventos2;
	private List<SelectItem> listTiposEventosItems2;
	String resultado;

	public MultimodalView() {
		super();
		setQuery("");
		setTransiciones("");
	}

	@ManagedProperty(value="#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public InputTextarea getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(InputTextarea txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public SelectOneMenu getSomListaEventos() {
		return somListaEventos;
	}

	public void setSomListaEventos(SelectOneMenu somListaEventos) {
		this.somListaEventos = somListaEventos;
	}

	public List<SelectItem> getListTiposEventosItems() {
		try{
			if(listTiposEventosItems==null){
				List<TipoActividad> listaActividades=businessDelegatorView.getTipoActividad();
				listTiposEventosItems=new ArrayList<SelectItem>();
				for(TipoActividad tipoActividad: listaActividades){
					listTiposEventosItems.add(new SelectItem(tipoActividad.getNombre()));
				}
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
		}
		return listTiposEventosItems;
	}

	public List<TipoActividad> getListaActividades() {
		try {
			if(listaActividades==null){
				listaActividades=businessDelegatorView.getTipoActividad();
			}
		} catch (Exception e) {
			log.error("ListaActividades 1 - Error:" +e.toString());
		}
		return listaActividades;
	}

	public void setListaActividades(List<TipoActividad> listaActividades) {
		this.listaActividades = listaActividades;
	}

	public List<TipoActividad> getListaActividades2() {
		try {
			if(listaActividades2==null){
				listaActividades2=businessDelegatorView.getTipoActividad();
			} 
		}catch (Exception e) {
			log.error("ListaActividades 2 - Error:" +e.toString());
		}

		return listaActividades2;
	}

	public void setListaActividades2(List<TipoActividad> listaActividades2) {
		this.listaActividades2 = listaActividades2;
	}

	public void setListTiposEventosItems(List<SelectItem> listTiposEventosItems) {
		this.listTiposEventosItems = listTiposEventosItems;
	}

	public SelectOneMenu getSomListaEventos2() {
		return somListaEventos2;
	}

	public void setSomListaEventos2(SelectOneMenu somListaEventos2) {
		this.somListaEventos2 = somListaEventos2;
	}

	public List<SelectItem> getListTiposEventosItems2() {
		try{
			if(listTiposEventosItems2==null){
				List<TipoActividad> listaActividades2=businessDelegatorView.getTipoActividad();
				listTiposEventosItems2=new ArrayList<SelectItem>();
				for(TipoActividad tipoActividad2: listaActividades2){
					listTiposEventosItems2.add(new SelectItem(tipoActividad2.getNombre()));
				}
			}
		}
		catch (Exception e) {
			log.error(e.getMessage());
		}
		return listTiposEventosItems2;
	}

	public void setListTiposEventosItems2(List<SelectItem> listTiposEventosItems2) {
		this.listTiposEventosItems2 = listTiposEventosItems2;
	}

	public InputTextarea getTxtQuery() {
		return txtQuery;
	}

	public void setTxtQuery(InputTextarea txtQuery) {
		this.txtQuery = txtQuery;
	}

	public CommandButton getBtnAddTexto() {
		return btnAddTexto;
	}

	public void setBtnAddTexto(CommandButton btnAddTexto) {
		this.btnAddTexto = btnAddTexto;
	}

	public CommandButton getBtnAddLista() {
		return btnAddLista;
	}

	public void setBtnAddLista(CommandButton btnAddLista) {
		this.btnAddLista = btnAddLista;
	}

	public CommandButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(CommandButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public CommandButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(CommandButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public InputTextarea getTxtResultado() {
		return txtResultado;
	}

	public void setTxtResultado(InputTextarea txtResultado) {
		this.txtResultado = txtResultado;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getTransiciones() {
		return transiciones;
	}

	public void setTransiciones(String transiciones) {
		this.transiciones = transiciones;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	//TODO: Metodos	
	public String search(){
		String busqueda= getQuery()+getTransiciones();
		System.out.println(busqueda);
		//		setResultado(businessDelegatorView.search());
		//		System.out.println(getResultado());
		return "";
	}

	public String tipoBusqueda(){
		String tipoBusqueda=rdTipoBusqueda.getValue().toString();
		if(tipoBusqueda.equals("Textual")){
			textual();
		}else{
			if(tipoBusqueda.equals("Estructural")){
				estructural();
			}else{
				if(tipoBusqueda.equals("Multimodal")){
					multimodal();
				}
			}
		}
		return "";
	}

	public String textual(){
		txtBusqueda.setDisabled(false);
		btnAddTexto.setDisabled(false);
		btnBuscar.setDisabled(false);
		//
		somListaEventos.setDisabled(true);
		somListaEventos2.setDisabled(true);
		btnAddLista.setDisabled(true);
		return "";
	}

	public String estructural(){
		somListaEventos.setDisabled(false);
		somListaEventos2.setDisabled(false);
		btnAddLista.setDisabled(false);
		btnBuscar.setDisabled(false);
		//
		txtBusqueda.setDisabled(true);
		btnAddTexto.setDisabled(true);	
		return "";
	}

	public String multimodal(){
		somListaEventos.setDisabled(false);
		somListaEventos2.setDisabled(false);
		btnAddLista.setDisabled(false);
		btnBuscar.setDisabled(false);
		txtBusqueda.setDisabled(false);
		btnAddTexto.setDisabled(false);
		return "";
	}

	public String limpiar(){
		somListaEventos.setDisabled(true);
		somListaEventos.resetValue();
		somListaEventos2.setDisabled(true);
		somListaEventos2.resetValue();
		btnAddLista.setDisabled(true);
		btnBuscar.setDisabled(true);
		txtBusqueda.setDisabled(true);
		txtBusqueda.resetValue();
		btnAddTexto.setDisabled(true);
		rdTipoBusqueda.resetValue();
		return "";
	}

	public String addTexto(){
		if(getQuery().equals("")){
			setQuery(txtBusqueda.getValue().toString().trim());
		}else{
			setQuery(getQuery()+", "+txtBusqueda.getValue().toString().trim());
		}
		return "";
	}

	public String addTransiciones(){
		if(getTransiciones().equals("")){
			setTransiciones(getFrom()+"_"+getTo());
		}else{
			setTransiciones(getTransiciones()+", "+getFrom()+"_"+getTo());
		}
		
		return "";
	}

}
