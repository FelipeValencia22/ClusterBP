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

	ArrayList <ArrayList<String>> listaTextual;
	ArrayList <ArrayList<String>> listaEstructural;

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
				analisisTextual(event);
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

	public String analisisTextual(FileUploadEvent event){
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(event.getFile().getInputstream());
			String tipoActividad;

			listaTextual = new ArrayList<ArrayList<String>>();

			doc.getDocumentElement().normalize();

			NodeList nodeListActiviti= doc.getElementsByTagName("Activity");
			for (int i = 0; i < nodeListActiviti.getLength(); ++i){

				Element elementActiviti = (Element) nodeListActiviti.item(i);
				String elementActivitiId= elementActiviti.getAttribute("Id");
				String elementActivitiName= elementActiviti.getAttribute("Name");

				tipoActividad="";

				///////////////// Event //////////////////////////////////////////////
				NodeList nodeListEvent = elementActiviti.getElementsByTagName("Event");
				for (int j = 0; j < nodeListEvent.getLength(); ++j){

					Element elementEvent = (Element) nodeListEvent.item(j);
					NodeList nodeListStarEvent = elementEvent.getElementsByTagName("StartEvent");
					NodeList nodeListIntermediateEvent = elementEvent.getElementsByTagName("IntermediateEvent");
					NodeList nodeListEndEvent = elementEvent.getElementsByTagName("EndEvent");

					for (int k = 0; k < nodeListStarEvent.getLength(); k++) {
						Element elementStarEvent = (Element) nodeListStarEvent.item(k);
						tipoActividad="StartEvent "+elementStarEvent.getAttribute("Trigger");
					}					
					for (int k = 0; k < nodeListIntermediateEvent.getLength(); k++) {
						Element elementIntermediateEvent= (Element) nodeListIntermediateEvent.item(k);
						tipoActividad="IntermediateEvent "+elementIntermediateEvent.getAttribute("Trigger");
					}					
					for (int k = 0; k < nodeListEndEvent.getLength(); k++) {
						Element elementEndEvent = (Element) nodeListEndEvent.item(k);
						tipoActividad ="EndEvent "+elementEndEvent.getAttribute("Result");
					}
				}

				/////////////// Implementation /////////////////////////////////////////////////////////
				NodeList nodeListImplementation = elementActiviti.getElementsByTagName("Implementation");
				for (int j = 0; j < nodeListImplementation.getLength(); ++j){

					Element elementEvent = (Element) nodeListImplementation.item(j);					
					NodeList nodeListTask = elementEvent.getElementsByTagName("Task");
					NodeList nodeListSubFlow = elementEvent.getElementsByTagName("SubFlow");

					for (int k = 0; k < nodeListSubFlow.getLength(); k++) {
						tipoActividad="Task SubFlow";
					}

					for (int k = 0; k < nodeListTask.getLength(); k++) {
						Element elementTask= (Element)nodeListTask.item(k);

						NodeList nodeListTaskSend = elementTask.getElementsByTagName("TaskSend");
						NodeList nodeListTaskManual = elementTask.getElementsByTagName("TaskManual");
						NodeList nodeListTaskScript = elementTask.getElementsByTagName("TaskScript");
						NodeList nodeListTaskBusinessRule = elementTask.getElementsByTagName("TaskBusinessRule");
						NodeList nodeListTaskUser = elementTask.getElementsByTagName("TaskUser");
						NodeList nodeListTaskService = elementTask.getElementsByTagName("TaskService");
						NodeList nodeListTaskReceive = elementTask.getElementsByTagName("TaskReceive");


						for (int l = 0; l < nodeListTaskSend.getLength(); l++) {
							tipoActividad="TaskSend";
						}						
						for (int l = 0; l < nodeListTaskManual.getLength(); l++) {
							tipoActividad="TaskManual";
						}						
						for (int l = 0; l < nodeListTaskScript.getLength(); l++) {
							tipoActividad="TaskScript";
						}
						for (int l = 0; l < nodeListTaskBusinessRule.getLength(); l++) {
							tipoActividad="TaskBusinessRule";
						}
						for (int l = 0; l < nodeListTaskUser.getLength(); l++) {
							tipoActividad="TaskUser";
						}
						for (int l = 0; l < nodeListTaskService.getLength(); l++) {
							tipoActividad="TaskService";
						}
						for (int l = 0; l < nodeListTaskReceive.getLength(); l++) {
							tipoActividad="TaskReceive";
						}

						if(tipoActividad.equals("")){
							tipoActividad="Task";
						}

					}
				}

				//////////////// Route ////////////////////////////////////////////////////////////////
				NodeList nodeListRoute = elementActiviti.getElementsByTagName("Route");
				for (int j = 0; j < nodeListRoute.getLength(); j++) {
					Element elementRoute= (Element)nodeListRoute.item(j);
					String valor1=elementRoute.getAttribute("GatewayType");
					String valor2=elementRoute.getAttribute("ExclusiveType");
					String valor3 =elementRoute.getAttribute("Instantiate");
					String valor4 =elementRoute.getAttribute("ParallelEventBased");

					if (!valor1.isEmpty()) {
						tipoActividad="Route GatewayType "+valor1;
					}
					if (!valor2.isEmpty()) {
						tipoActividad="Route ExclusiveType "+valor2;
					}
					if (!valor3.isEmpty() && valor4.isEmpty()) {
						tipoActividad="Route ExclusiveType based on Event";
					}
					if (!valor3.isEmpty() && !valor4.isEmpty()) {
						tipoActividad="Route GatewayType based on Event";
					}

					if(valor1.isEmpty() && valor2.isEmpty()){
						tipoActividad="Route";
					}
				}
				/////////////// BlockActivity /////////////////////////////////////////////////////////
				NodeList nodeListBlockActivity = elementActiviti.getElementsByTagName("BlockActivity");
				for (int j = 0; j < nodeListBlockActivity.getLength(); ++j){
					tipoActividad="Task BlocActivity";
				}
				
				///// Asignar los valores a una lista de listas
				listaTextual.add(new ArrayList<String>());
				listaTextual.get(i).add(elementActivitiId);
				listaTextual.get(i).add(tipoActividad);
				listaTextual.get(i).add(elementActivitiName);

			}
			
			/// Imprimir valores
//			for (int j = 0; j < listaTextual.size(); j++) {
//				for (int k = 0; k < listaTextual.get(j).size(); k++) {
//					System.out.println(listaTextual.get(j).get(k));
//					System.out.println();
//				}
//
//			}
			
			analisisEstructural(listaTextual, event);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}


	public String analisisEstructural(ArrayList<ArrayList<String>> listaTextual, FileUploadEvent event){
		try {
			System.out.println("++++++++++++++++++++++ Estructural");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(event.getFile().getInputstream());
			String fromId;
			String toId;
			String id;
			String fromString="";
			String toString="";
			
			listaEstructural = new ArrayList<ArrayList<String>>();

			doc.getDocumentElement().normalize();

			NodeList nodeListTransition= doc.getElementsByTagName("Transition");
			System.out.println("+++++++++++ Transition");
			for (int i = 0; i < nodeListTransition.getLength(); ++i){
				Element elementTransition= (Element)nodeListTransition.item(i);
				id= elementTransition.getAttribute("Id");
				fromId= elementTransition.getAttribute("From");
				toId= elementTransition.getAttribute("To");
				System.out.println("ID: "+id);
				System.out.println("fromId: "+fromId);
				System.out.println("toId: "+toId);
				
				/// Asignar los valores a la Lista
				listaEstructural.add(new ArrayList<String>());
				
				for (int j = 0; j < listaTextual.size(); j++) {
					if(listaTextual.get(j).get(0).equals(fromId)){
						fromString=listaTextual.get(j).get(1);
					}
					if(listaTextual.get(j).get(0).equals(toId)){
						toString=listaTextual.get(j).get(1);
					}
				}
				
				listaEstructural.get(i).add(id);
				listaEstructural.get(i).add(fromString+"_"+toString+(i+1));
				
				/// Imprimir valores
				for (int j = 0; j < listaEstructural.size(); j++) {
					for (int k = 0; k < listaEstructural.get(j).size(); k++) {
						System.out.println(listaEstructural.get(j).get(k));
						System.out.println();
					}

				}
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
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
