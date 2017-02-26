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
			
		} catch (Exception e) {
			log.info(e.getMessage());
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

}
