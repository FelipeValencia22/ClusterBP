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


@ViewScoped
@ManagedBean(name = "pnView")
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
	private CommandButton btnCrear;

	private List<PnDTO> data;
	private List<PnDTO> dataI;
	private PnDTO selectedPn;
	private Pn entity;
	private boolean showDialog;

	Long codigoPn;

	String titulo;
	String nombreArchivo;

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
	public CommandButton getBtnCrear() {
		return btnCrear;
	}
	public void setBtnCrear(CommandButton btnCrear) {
		this.btnCrear = btnCrear;
	}
	//TODO: Metodos


	public String handleFileUpload(FileUploadEvent event) throws IOException {
		log.info("Subiendo archivos..");

		try {
			titulo= event.getFile().getFileName();
			String ext = FilenameUtils.getExtension(titulo); 
			if(ext.equals("xpdl")){
				nombreArchivo=FilenameUtils.removeExtension(titulo);
				System.out.println(nombreArchivo);
				
				Pn pnExiste=businessDelegatorView.consultarPNPorNombre(titulo);

				if(pnExiste==null){
					String descripcion= "prueba";
					Date fechaCreacion= new Date();
					TipoArchivoPn tipoArchivoPn=businessDelegatorView.getTipoArchivoPn(1L);

					Pn pn = new Pn();
					pn.setActivo("S");
					pn.setArchivo(event.getFile().getContents());
					pn.setDescripcion(descripcion);
					pn.setFechaCreacion(fechaCreacion);
					pn.setTipoArchivoPn(tipoArchivoPn);
					pn.setTitulo(titulo);
					Usuario usuarioCreador=  (Usuario) FacesUtils.getfromSession("usuario");
					pn.setUsuCreador(usuarioCreador.getUsuarioCodigo());

					businessDelegatorView.savePn(pn);
					String texto=businessDelegatorView.parserXPDL(event);
					System.out.println("texto"+texto);
					businessDelegatorView.crearTxt(texto, pn);
					data=businessDelegatorView.getDataPn();
					dataI=businessDelegatorView.getDataPnI();
					setShowDialog(false);
					FacesContext.getCurrentInstance().addMessage("", new FacesMessage("El PN se guardo con exito"));
					
				}else{
					FacesUtils.addErrorMessage("El Pn ya existe");
				}
			}else{
				FacesUtils.addErrorMessage("El formato del archivo es incorrecto");
			}
		}catch (Exception e) {
			FacesUtils.addErrorMessage("Error! No se subió el PN");
			log.error(e.toString());
			e.printStackTrace();
			log.error(e.getLocalizedMessage());
		}

		return "";
	}


	public String salirCrearPN(){
		txtDescripcion.resetValue();
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
