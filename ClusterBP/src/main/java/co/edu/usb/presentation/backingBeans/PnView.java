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
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
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
public class PnView implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(PnView.class);

	public PnView() {
		super();
	}
	private InputText txtActivo;
	private InputText txtArchivo;
	private InputText txtDescripcion;
	private InputText txtTitulo;

	private SelectOneMenu somTipoArchivoPn;
	private List<SelectItem> listTiposArchivoItems;
	
	private CommandButton btnSubir;

	private List<PnDTO> data;
	private PnDTO selectedPn;
	private Pn entity;
	private boolean showDialog;
	
	File fXmlFile;

	@ManagedProperty(value="#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public String action_closeDialog(){
		setShowDialog(false);
		return "";
	}	
	public InputText getTxtActivo() {
		return txtActivo;
	}
	public void setTxtActivo(InputText txtActivo) {
		this.txtActivo = txtActivo;
	}
	public InputText getTxtArchivo() {
		return txtArchivo;
	}
	public void setTxtArchivo(InputText txtArchivo) {
		this.txtArchivo = txtArchivo;
	}
	public InputText getTxtDescripcion() {
		return txtDescripcion;
	}
	public void setTxtDescripcion(InputText txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}
	public InputText getTxtTitulo() {
		return txtTitulo;
	}
	public void setTxtTitulo(InputText txtTitulo) {
		this.txtTitulo = txtTitulo;
	}
	public List<PnDTO> getData() {
		try{
			if(data==null){
				data = businessDelegatorView.getDataPn();
			}	

		}catch(Exception e){
			e.printStackTrace();
		}
		return data;
	}
	public void setData(List<PnDTO> pnDTO){
		this.data=pnDTO;
	}
	public PnDTO getSelectedPn(){
		return selectedPn;
	}
	public void setSelectedPn (PnDTO pn ){
		this.selectedPn = pn;
	}
	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}											

	public CommandButton getBtnSubir() {
		return btnSubir;
	}
	public void setBtnSubir(CommandButton btnSubir) {
		this.btnSubir = btnSubir;
	}
	
	public SelectOneMenu getSomTipoArchivoPn() {
		return somTipoArchivoPn;
	}
	public void setSomTipoArchivoPn(SelectOneMenu somTipoArchivoPn) {
		this.somTipoArchivoPn = somTipoArchivoPn;
	}
	
	public List<SelectItem> getListTiposArchivoItems() {
		try {
			if(listTiposArchivoItems==null){
				List<TipoArchivoPn> listaArchivos=businessDelegatorView.getTipoArchivoPn();
				listTiposArchivoItems=new ArrayList<SelectItem>();
				for(TipoArchivoPn tipoArchivoPn: listaArchivos){
					log.info(tipoArchivoPn.getNombre());
					listTiposArchivoItems.add(new SelectItem(tipoArchivoPn.getTipoArchivoPnCodigo(),tipoArchivoPn.getNombre()));
					
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return listTiposArchivoItems;
	}
	public void setListTiposArchivoItems(List<SelectItem> listTiposArchivoItems) {
		this.listTiposArchivoItems = listTiposArchivoItems;
	}
	//TODO: Metodos
	public String handleFileUpload(FileUploadEvent event) throws IOException {
		log.info("Subiendo archivos..");
		try {
			String titulo= "titulo";
			System.out.println(titulo);
			String descripcion= "descripcion";
			System.out.println(descripcion);
			//String tipoArchivo= somTipoArchivoPn.getValue().toString().trim();
			Date fechaCreacion= new Date();
			System.out.println(fechaCreacion);
			//Long codigo= Long.parseLong(tipoArchivo);
			TipoArchivoPn tipoArchivoPn=businessDelegatorView.getTipoArchivoPn(1L);
			System.out.println(tipoArchivoPn);
			try {
				Pn pn = new Pn();
				pn.setActivo("S");
				pn.setArchivo(event.getFile().getContents());
				validarTipoArchivo(event);
				pn.setDescripcion(descripcion);
				pn.setFechaCreacion(fechaCreacion);
				pn.setTipoArchivoPn(tipoArchivoPn);
				pn.setTitulo(titulo);
				Usuario usuarioCreador=  (Usuario) FacesUtils.getfromSession("usuario");
				pn.setUsuCreador(usuarioCreador.getUsuarioCodigo());
				
				businessDelegatorView.savePn(pn);
				FacesContext.getCurrentInstance().addMessage("", new FacesMessage("El PN se guardo con exito"));
				
				
			}catch (Exception e) {
				FacesUtils.addErrorMessage("Error! No se subió el PN");
				log.error(e.toString());
				log.error(e.getLocalizedMessage());
			}
		} catch (Exception e) {
			log.info(e.getMessage());
			log.error(e.toString());
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
			FacesUtils.addInfoMessage(e.getMessage());
		}
		return "";
	}
	
	public String subirPn(){
		
		
		
		return "";
	}
	
	public String limpiarSubirPn(){
		
		return "";
	}
	
	public String validarTipoArchivo(FileUploadEvent event){
		try {

			//File fXmlFile = new File();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(event.getFile().getInputstream());

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("staff");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;

					System.out.println("Staff id : " + eElement.getAttribute("id"));
					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).toString());
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).toString());
					System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).toString());
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).toString());

				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		
		return "";
	}

}
