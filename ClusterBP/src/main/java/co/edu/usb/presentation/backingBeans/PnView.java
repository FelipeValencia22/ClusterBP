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
public class PnView implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(PnView.class);

	public PnView() {
		super();
	}
	private InputText txtActivo;
	private InputText txtArchivo;
	private InputTextarea txtDescripcion;
	private InputText txtTitulo;

	private InputTextarea txtDescripcionM;
	private InputText txtTituloM;

	private SelectOneMenu somTipoArchivoPn;
	private List<SelectItem> listTiposArchivoItems;

	private CommandButton btnSubir;
	private CommandButton btnModificar;

	private FileUpload fileUpload;

	private List<PnDTO> data;
	private List<PnDTO> dataI;
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
	public InputTextarea getTxtDescripcion() {
		return txtDescripcion;
	}
	public void setTxtDescripcion(InputTextarea txtDescripcion) {
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
	public List<PnDTO> getDataI() {
		try{
			if(dataI==null){
				dataI = businessDelegatorView.getDataPnI();
			}	

		}catch(Exception e){
			e.printStackTrace();
		}
		return dataI;
	}
	public void setDataI(List<PnDTO> pnDTO){
		this.dataI=pnDTO;
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
	public FileUpload getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(FileUpload fileUpload) {
		this.fileUpload = fileUpload;
	}
	public InputTextarea getTxtDescripcionM() {
		return txtDescripcionM;
	}
	public void setTxtDescripcionM(InputTextarea txtDescripcionM) {
		this.txtDescripcionM = txtDescripcionM;
	}
	public InputText getTxtTituloM() {
		return txtTituloM;
	}
	public void setTxtTituloM(InputText txtTituloM) {
		this.txtTituloM = txtTituloM;
	}
	public CommandButton getBtnModificar() {
		return btnModificar;
	}
	public void setBtnModificar(CommandButton btnModificar) {
		this.btnModificar = btnModificar;
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
				//validarTipoArchivo(event);
				//otroMetodo(event);
				//analisisTextual(event);
				analisisTextualMejorado(event);
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
					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getFirstChild().getNodeValue());
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getFirstChild().getNodeValue());									
					System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getFirstChild().getNodeValue());
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getFirstChild().getNodeValue());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}


	public String otroMetodo(FileUploadEvent event){
		try {
			System.out.println("+++++++++++++++++++++++++");
			System.out.println("OTRO METODO");
			System.out.println("+++++++++++++++++++++++++");
			//File fXmlFile = new File();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(event.getFile().getInputstream());

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("Activity");
			NodeList nSubListEvent = doc.getElementsByTagName("Event");
			NodeList nSubListImplementation = doc.getElementsByTagName("Implementation");


			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				Node nSubNodeEvent= nSubListEvent.item(temp);
				Node nSubNodeImplementation= nSubListImplementation.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("ID Actividad: " + eElement.getAttribute("Id"));
					System.out.println("Nombre Actividad: " + eElement.getAttribute("Name"));


				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public String analisisTextual(FileUploadEvent event){
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(event.getFile().getInputstream());

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("Activity");
			NodeList nListEvent = doc.getElementsByTagName("Event");

			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				Node nNodeEvent = nListEvent.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					Element eElementEvent = (Element) nNodeEvent;

					System.out.println("ID: " + eElement.getAttribute("Id"));
					if(eElement.getAttribute("Name").length()>0){
						System.out.println("Nombre: " + eElement.getAttribute("Name"));
					}					
					if(eElement.getElementsByTagName("Descripcion").getLength()>0){
						System.out.println("Descripcion: " + eElement.getElementsByTagName("Description").item(0).getFirstChild().getNodeValue());
					}
					if(eElement.getElementsByTagName("Event").getLength()>0){
						System.out.println("Event");
						System.out.println("FirstChild: "+eElement.getElementsByTagName("Event").item(0).getFirstChild().getFirstChild());
						System.out.println("LocalName: "+eElement.getElementsByTagName("Event").item(0).getLocalName());
						System.out.println("NamespaceURI: "+eElement.getElementsByTagName("Event").item(0).getNamespaceURI());
						System.out.println("NodeName: "+eElement.getElementsByTagName("Event").item(0).getNodeName());
						System.out.println("NodeValue: "+eElement.getElementsByTagName("Event").item(0).getNodeValue());
						System.out.println("Prefix: "+eElement.getElementsByTagName("Event").item(0).getPrefix());
					}
					if(eElement.getElementsByTagName("Implementation").getLength()>0){
						System.out.println("Implementation");
					}
					if(eElement.getElementsByTagName("Route").getLength()>0){
						System.out.println("Route");
					}
					if(eElement.getElementsByTagName("BlockActivity").getLength()>0){
						System.out.println("BlockActivity");
					}

				}
			}


		}catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public String analisisTextualMejorado(FileUploadEvent event){
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(event.getFile().getInputstream());

			doc.getDocumentElement().normalize();

			NodeList nodeListActiviti= doc.getElementsByTagName("Activity");
			for (int i = 0; i < nodeListActiviti.getLength(); ++i){

				Element elementActiviti = (Element) nodeListActiviti.item(i);
				String elementActivitiId= elementActiviti.getAttribute("Id");
				String elementActivitiName= elementActiviti.getAttribute("Name");
				System.out.println("ID: "+elementActivitiId);
				System.out.println("Name: "+elementActivitiName);

				///////////////// EVENT //////////////////////////////////////////////
				NodeList nodeListEvent = elementActiviti.getElementsByTagName("Event");
				for (int j = 0; j < nodeListEvent.getLength(); ++j){

					Element elementEvent = (Element) nodeListEvent.item(j);
					NodeList nodeListStarEvent = elementEvent.getElementsByTagName("StartEvent");
					NodeList nodeListIntermediateEvent = elementEvent.getElementsByTagName("IntermediateEvent");
					NodeList nodeListEndEvent = elementEvent.getElementsByTagName("EndEvent");

					for (int k = 0; k < nodeListStarEvent.getLength(); k++) {
						Element elementStarEvent = (Element) nodeListStarEvent.item(k);
						String valor=elementStarEvent.getAttribute("Trigger");
						System.out.println("Event - Star Event - Trigger: "+valor);
						System.out.println();
					}					
					for (int k = 0; k < nodeListIntermediateEvent.getLength(); k++) {
						Element elementIntermediateEvent= (Element) nodeListIntermediateEvent.item(k);
						String valor=elementIntermediateEvent.getAttribute("Trigger");
						System.out.println("Event - Intermediate Event - Trigger: "+valor);
						System.out.println();
					}					
					for (int k = 0; k < nodeListEndEvent.getLength(); k++) {
						Element elementEndEvent = (Element) nodeListEndEvent.item(k);
						String valor=elementEndEvent.getAttribute("Result");
						System.out.println("Event - End Event - Result: "+valor);
						System.out.println();
					}
				}

				/////////////// IMPLEMENTATION /////////////////////////////////////////////////////////
				NodeList nodeListImplementation = elementActiviti.getElementsByTagName("Implementation");
				for (int j = 0; j < nodeListImplementation.getLength(); ++j){

					Element elementEvent = (Element) nodeListImplementation.item(j);					
					NodeList nodeListTask = elementEvent.getElementsByTagName("Task");
					NodeList nodeListSubFlow = elementEvent.getElementsByTagName("SubFlow");

					for (int k = 0; k < nodeListSubFlow.getLength(); k++) {
						System.out.println("Implementation - SubFlow");
					}

					for (int k = 0; k < nodeListTask.getLength(); k++) {
						System.out.println("Implementation - Task");
						Element elementTask= (Element)nodeListTask.item(k);

						NodeList nodeListTaskSend = elementTask.getElementsByTagName("TaskSend");
						NodeList nodeListTaskManual = elementTask.getElementsByTagName("TaskManual");
						NodeList nodeListTaskScript = elementTask.getElementsByTagName("TaskScript");
						NodeList nodeListTaskBusinessRule = elementTask.getElementsByTagName("TaskBusinessRule");
						NodeList nodeListTaskUser = elementTask.getElementsByTagName("TaskUser");
						NodeList nodeListTaskService = elementTask.getElementsByTagName("TaskService");
						NodeList nodeListTaskReceive = elementTask.getElementsByTagName("TaskReceive");

						for (int l = 0; l < nodeListTaskSend.getLength(); l++) {
							System.out.println("Task: TaskSend");
							System.out.println();
						}						
						for (int l = 0; l < nodeListTaskManual.getLength(); l++) {
							System.out.println("Task: TaskManual");
							System.out.println();
						}						
						for (int l = 0; l < nodeListTaskScript.getLength(); l++) {
							System.out.println("Task: TaskScript");
							System.out.println();
						}
						for (int l = 0; l < nodeListTaskBusinessRule.getLength(); l++) {
							System.out.println("Task: TaskBusinessRule");
							System.out.println();
						}
						for (int l = 0; l < nodeListTaskUser.getLength(); l++) {
							System.out.println("Task: TaskUser");
							System.out.println();
						}
						for (int l = 0; l < nodeListTaskService.getLength(); l++) {
							System.out.println("Task: TaskService");
							System.out.println();
						}
						for (int l = 0; l < nodeListTaskReceive.getLength(); l++) {
							System.out.println("Task: TaskReceive");
							System.out.println();
						}						
					}
				}

				/////////////// BlockActivity /////////////////////////////////////////////////////////
				NodeList nodeListBlockActivity = elementActiviti.getElementsByTagName("BlockActivity");
				for (int j = 0; j < nodeListBlockActivity.getLength(); ++j){
					System.out.println("Implementation: BlocActivity");
					System.out.println();
				}

			}
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}


	public String partirDescripcion(String cadena){
		String descripcion="";
		String[] cadenaTemporal;
		String inicio;

		return descripcion;
	}



	public String salirCrearPN(){
		txtTitulo.resetValue();
		txtDescripcion.resetValue();
		somTipoArchivoPn.resetValue();
		setShowDialog(false);

		return "";
	}

	public String modificarPN(ActionEvent evt) {

		selectedPn=(PnDTO) evt.getComponent().getAttributes().get("selectedPN");

		txtTituloM.setValue(selectedPn.getTitulo());
		txtDescripcionM.setValue(selectedPn.getDescripcion());

		setShowDialog(true);

		return "";
	}

	public String guardarModificacion()throws Exception{
		try{

			if (entity == null) {
				entity=businessDelegatorView.getPn(selectedPn.getPnCodigo());
			}

			Date fechaModificacion= new Date();
			entity.setFechaModificacion(fechaModificacion);

			Usuario usuarioEnSession =  (Usuario) FacesUtils.getfromSession("usuario");
			entity.setUsuModificador(usuarioEnSession.getUsuarioCodigo());

			entity.setTitulo(txtTituloM.getValue().toString().trim());
			entity.setDescripcion(txtDescripcionM.getValue().toString().trim());

			businessDelegatorView.updatePn(entity);
			FacesUtils.addInfoMessage("El PN ha sido modificado con exito");
			data= businessDelegatorView.getDataPn();
			dataI=businessDelegatorView.getDataPnI();

		}catch(Exception e){
			FacesUtils.addErrorMessage("Error! No se modificó el PN");
			log.error(e.toString());
			e.printStackTrace();			
		}
		return "";
	}

	public String salirModificarPN(){
		txtTituloM.resetValue();
		txtDescripcionM.resetValue();
		setShowDialog(false);
		return "";
	}

	public String cambiarEstado(ActionEvent evt){
		log.info("Cambiando estado..");
		selectedPn=(PnDTO) evt.getComponent().getAttributes().get("selectedPN");

		Pn entity=null;

		try {
			if (entity == null) {
				entity= businessDelegatorView.getPn(selectedPn.getPnCodigo());
			}

			Date fechaModificacion= new Date();
			entity.setFechaModificacion(fechaModificacion);

			Usuario usuarioEnSession =  (Usuario) FacesUtils.getfromSession("usuario");
			entity.setUsuModificador(usuarioEnSession.getUsuarioCodigo());

			String cambio=entity.getActivo().toString().trim();
			if (cambio.equalsIgnoreCase("S")) {
				entity.setActivo("N");
			}else{
				entity.setActivo("S");
			}

			businessDelegatorView.updatePn(entity);
			FacesUtils.addInfoMessage("El PN ha sido modificado con éxito");
			data= businessDelegatorView.getDataPn();
			dataI=businessDelegatorView.getDataPnI();

			entity=null;
			selectedPn=null;		

			limpiarPNModificacion();

		}catch (Exception e) {
			FacesUtils.addErrorMessage("Error! No se cambió el estado del PN");
			log.error(e.toString());

		}

		return "";
	}

	public String limpiarPNModificacion(){
		log.info("Limpiando campos de texto de PN modificado");
		txtTituloM.resetValue();
		txtDescripcionM.resetValue();		
		return "";
	}

}
