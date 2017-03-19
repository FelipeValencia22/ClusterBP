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
	
	private InputText txtBusqueda;
	
	String resultado;

	public MultimodalView() {
		super();
	}
	
	@ManagedProperty(value="#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	public InputText getTxtBusqueda() {
		return txtBusqueda;
	}

	public void setTxtBusqueda(InputText txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	//TODO: Metodos	
	public String search(){
		setResultado(businessDelegatorView.search(txtBusqueda.getValue().toString().trim()));
		System.out.println(getResultado());
		return "";
	}
	
}
