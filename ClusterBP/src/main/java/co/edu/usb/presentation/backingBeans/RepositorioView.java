package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.RepositorioDTO;
import co.edu.usb.exceptions.*;
import co.edu.usb.presentation.businessDelegate.*;
import co.edu.usb.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@ManagedBean
@ViewScoped
public class RepositorioView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(RepositorioView.class);

	private InputText txtActivo;
	private InputText txtDescripcion;
	private InputText txtNombre;
	private InputText txtUsuCreador;
	private InputText txtUsuModificador;
	private InputText txtRepositorioCodigo;

	private InputText txtDescripcionM;
	private InputText txtNombreM;

	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	
	private CommandButton btnSave;
	private CommandButton btnCrear;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private CommandButton btnModificar;
	private List<RepositorioDTO> data;
	private List<RepositorioDTO> dataI;
	private RepositorioDTO selectedRepositorio;
	private Repositorio entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public RepositorioView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			RepositorioDTO repositorioDTO = (RepositorioDTO) e.getObject();

			if (txtActivo == null) {
				txtActivo = new InputText();
			}

			txtActivo.setValue(repositorioDTO.getActivo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputText();
			}

			txtDescripcion.setValue(repositorioDTO.getDescripcion());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(repositorioDTO.getNombre());

			if (txtUsuCreador == null) {
				txtUsuCreador = new InputText();
			}

			txtUsuCreador.setValue(repositorioDTO.getUsuCreador());

			if (txtUsuModificador == null) {
				txtUsuModificador = new InputText();
			}

			txtUsuModificador.setValue(repositorioDTO.getUsuModificador());

			if (txtRepositorioCodigo == null) {
				txtRepositorioCodigo = new InputText();
			}

			txtRepositorioCodigo.setValue(repositorioDTO.getRepositorioCodigo());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(repositorioDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(repositorioDTO.getFechaModificacion());

			Long repositorioCodigo = FacesUtils.checkLong(txtRepositorioCodigo);
			entity = businessDelegatorView.getRepositorio(repositorioCodigo);

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedRepositorio = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedRepositorio = null;

		if (txtActivo != null) {
			txtActivo.setValue(null);
			txtActivo.setDisabled(true);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			txtDescripcion.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtUsuCreador != null) {
			txtUsuCreador.setValue(null);
			txtUsuCreador.setDisabled(true);
		}

		if (txtUsuModificador != null) {
			txtUsuModificador.setValue(null);
			txtUsuModificador.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtRepositorioCodigo != null) {
			txtRepositorioCodigo.setValue(null);
			txtRepositorioCodigo.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		if (btnDelete != null) {
			btnDelete.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance()
		.addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance()
		.addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long repositorioCodigo = FacesUtils.checkLong(txtRepositorioCodigo);
			entity = (repositorioCodigo != null)
					? businessDelegatorView.getRepositorio(repositorioCodigo) : null;
		} catch (Exception e) {
			entity = null;
		}

		if (entity == null) {
			txtActivo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtNombre.setDisabled(false);
			txtUsuCreador.setDisabled(false);
			txtUsuModificador.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtRepositorioCodigo.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtActivo.setValue(entity.getActivo());
			txtActivo.setDisabled(false);
			txtDescripcion.setValue(entity.getDescripcion());
			txtDescripcion.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtUsuCreador.setValue(entity.getUsuCreador());
			txtUsuCreador.setDisabled(false);
			txtUsuModificador.setValue(entity.getUsuModificador());
			txtUsuModificador.setDisabled(false);
			txtRepositorioCodigo.setValue(entity.getRepositorioCodigo());
			txtRepositorioCodigo.setDisabled(true);
			btnSave.setDisabled(false);

			if (btnDelete != null) {
				btnDelete.setDisabled(false);
			}
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedRepositorio = (RepositorioDTO) (evt.getComponent()
				.getAttributes()
				.get("selectedRepositorio"));
		txtActivo.setValue(selectedRepositorio.getActivo());
		txtActivo.setDisabled(false);
		txtDescripcion.setValue(selectedRepositorio.getDescripcion());
		txtDescripcion.setDisabled(false);
		txtFechaCreacion.setValue(selectedRepositorio.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedRepositorio.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNombre.setValue(selectedRepositorio.getNombre());
		txtNombre.setDisabled(false);
		txtUsuCreador.setValue(selectedRepositorio.getUsuCreador());
		txtUsuCreador.setDisabled(false);
		txtUsuModificador.setValue(selectedRepositorio.getUsuModificador());
		txtUsuModificador.setDisabled(false);
		txtRepositorioCodigo.setValue(selectedRepositorio.getRepositorioCodigo());
		txtRepositorioCodigo.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedRepositorio == null) && (entity == null)) {
				action_create();
			} else {
				action_modify();
			}

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_create() {
		try {
			entity = new Repositorio();

			Long repositorioCodigo = FacesUtils.checkLong(txtRepositorioCodigo);

			entity.setActivo(FacesUtils.checkString(txtActivo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(
					txtFechaModificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setRepositorioCodigo(repositorioCodigo);
			entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
			entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
			businessDelegatorView.saveRepositorio(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			entity = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long repositorioCodigo = new Long(selectedRepositorio.getRepositorioCodigo());
				entity = businessDelegatorView.getRepositorio(repositorioCodigo);
			}

			entity.setActivo(FacesUtils.checkString(txtActivo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(
					txtFechaModificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
			entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
			businessDelegatorView.updateRepositorio(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_datatable(ActionEvent evt) {
		try {
			selectedRepositorio = (RepositorioDTO) (evt.getComponent()
					.getAttributes()
					.get("selectedRepositorio"));

			Long repositorioCodigo = new Long(selectedRepositorio.getRepositorioCodigo());
			entity = businessDelegatorView.getRepositorio(repositorioCodigo);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete_master() {
		try {
			Long repositorioCodigo = FacesUtils.checkLong(txtRepositorioCodigo);
			entity = businessDelegatorView.getRepositorio(repositorioCodigo);
			action_delete();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public void action_delete() throws Exception {
		try {
			businessDelegatorView.deleteRepositorio(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			throw e;
		}
	}

	public String action_closeDialog() {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedRepositorio = (RepositorioDTO) (evt.getComponent()
					.getAttributes()
					.get("selectedRepositorio"));

			Long repositorioCodigo = new Long(selectedRepositorio.getRepositorioCodigo());
			entity = businessDelegatorView.getRepositorio(repositorioCodigo);
			businessDelegatorView.deleteRepositorio(entity);
			data.remove(selectedRepositorio);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String activo, String descripcion,
			Date fechaCreacion, Date fechaModificacion, String nombre,
			Long repositorioCodigo, Long usuCreador, Long usuModificador)
					throws Exception {
		try {
			entity.setActivo(FacesUtils.checkString(activo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
			entity.setUsuModificador(FacesUtils.checkLong(usuModificador));
			businessDelegatorView.updateRepositorio(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			//renderManager.getOnDemandRenderer("RepositorioView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtActivo() {
		return txtActivo;
	}

	public void setTxtActivo(InputText txtActivo) {
		this.txtActivo = txtActivo;
	}

	public InputText getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputText txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
	}

	public InputText getTxtUsuCreador() {
		return txtUsuCreador;
	}

	public void setTxtUsuCreador(InputText txtUsuCreador) {
		this.txtUsuCreador = txtUsuCreador;
	}

	public InputText getTxtUsuModificador() {
		return txtUsuModificador;
	}

	public void setTxtUsuModificador(InputText txtUsuModificador) {
		this.txtUsuModificador = txtUsuModificador;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtRepositorioCodigo() {
		return txtRepositorioCodigo;
	}

	public void setTxtRepositorioCodigo(InputText txtRepositorioCodigo) {
		this.txtRepositorioCodigo = txtRepositorioCodigo;
	}

	public List<RepositorioDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataRepositorio();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<RepositorioDTO> repositorioDTO) {
		this.data = repositorioDTO;
	}

	public List<RepositorioDTO> getDataI() {

		try {
			if (dataI == null) {
				dataI = businessDelegatorView.getDataRepositorioI();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataI;
	}

	public void setDataI(List<RepositorioDTO> dataI) {
		this.dataI = dataI;
	}

	public RepositorioDTO getSelectedRepositorio() {
		return selectedRepositorio;
	}

	public void setSelectedRepositorio(RepositorioDTO repositorio) {
		this.selectedRepositorio = repositorio;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public CommandButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(CommandButton btnModify) {
		this.btnModify = btnModify;
	}

	public CommandButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public CommandButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public InputText getTxtDescripcionM() {
		return txtDescripcionM;
	}

	public void setTxtDescripcionM(InputText txtDescripcionM) {
		this.txtDescripcionM = txtDescripcionM;
	}

	public InputText getTxtNombreM() {
		return txtNombreM;
	}

	public void setTxtNombreM(InputText txtNombreM) {
		this.txtNombreM = txtNombreM;
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
	public String crearRepositorio(){
		try {
			log.info("Creando repositorio..");
			Repositorio repositorio=new Repositorio();
			Date fechaCreacion= new Date();
			Usuario usuarioCreador=  (Usuario) FacesUtils.getfromSession("usuario");
			String nombre=txtNombre.getValue().toString().trim();
			String descripcion=txtDescripcion.getValue().toString().trim();
			
			if(validarCampos(nombre, descripcion)){
				if(nombreDisponible(nombre)){
					repositorio.setActivo("S");
					repositorio.setDescripcion(descripcion);
					repositorio.setFechaCreacion(fechaCreacion);
					repositorio.setNombre(nombre);
					repositorio.setUsuCreador(usuarioCreador.getUsuarioCodigo());
					
					businessDelegatorView.saveRepositorio(repositorio);
					FacesUtils.addInfoMessage("El Repositorio ha sido creado con exito");
					data=businessDelegatorView.getDataRepositorio();
					dataI=businessDelegatorView.getDataRepositorioI();
					limpiarCamposCrear();
				}else{
					FacesUtils.addErrorMessage("El Nombre del Repositorio ya está en uso");
				}
				
			}else{
				FacesUtils.addErrorMessage("Todos los campos son obligatorios");
			}
			
		}catch (Exception e) {
			FacesUtils.addErrorMessage("Error! No se creó el repositorio");
			log.error(e.toString());
			log.error(e.getLocalizedMessage());
		}
		return "";
	}
	
	public String modificarRepositorio(ActionEvent evt){
		selectedRepositorio= (RepositorioDTO) evt.getComponent().getAttributes().get("selectedRepositorio");
		txtNombreM.setValue(selectedRepositorio.getNombre());
		txtDescripcionM.setValue(selectedRepositorio.getDescripcion());
		setShowDialog(true);
		return "";
	}

	public String guardarModificacion() throws Exception{
		try{
			String nombre=txtNombreM.getValue().toString().trim();
			String descripcion=txtDescripcionM.getValue().toString().trim();

			if(validarCampos(nombre, descripcion)){

				if (entity == null) {
					Long repositorioCodigo = new Long(selectedRepositorio.getRepositorioCodigo());
					entity = businessDelegatorView.getRepositorio(repositorioCodigo);

				} 
				String nombreAntiguo=entity.getNombre();

				if(nombreAntiguo.equals(nombre)){
					Date fechaModificacion= new Date();
					entity.setFechaModificacion(fechaModificacion);

					Usuario usuarioEnSession =  (Usuario) FacesUtils.getfromSession("usuario");
					entity.setUsuModificador(usuarioEnSession.getUsuarioCodigo());

					entity.setDescripcion(descripcion);

					businessDelegatorView.updateRepositorio(entity);
					FacesUtils.addInfoMessage("El Repositorio ha sido modificado con exito");
					data=businessDelegatorView.getDataRepositorio();
					dataI=businessDelegatorView.getDataRepositorioI();

				}else{

					if(nombreDisponible(nombre)){

						Date fechaModificacion= new Date();
						entity.setFechaModificacion(fechaModificacion);

						Usuario usuarioEnSession =  (Usuario) FacesUtils.getfromSession("usuario");
						entity.setUsuModificador(usuarioEnSession.getUsuarioCodigo());

						entity.setNombre(nombre);
						entity.setDescripcion(descripcion);

						businessDelegatorView.updateRepositorio(entity);
						FacesUtils.addInfoMessage("El Repositorio ha sido modificado con exito");
						data=businessDelegatorView.getDataRepositorio();
						dataI=businessDelegatorView.getDataRepositorioI();
						limpiarCamposModificar();
					}else{
						FacesUtils.addErrorMessage("El Nombre del Repositorio ya está en uso");
					}
				}
			}else{
				FacesUtils.addErrorMessage("Todos los campos son obligatorios");
			}


		}catch (Exception e) {
			log.error("Error! No se pudo modificar:"+e.toString());
			log.error("Error! No se pudo modificar:"+e.getLocalizedMessage());
			FacesUtils.addErrorMessage("Error! No se pudo modificar:"+e.toString());
		}


		return "";
	}
	
	public String cambiarEstado(ActionEvent evt){
		selectedRepositorio= (RepositorioDTO) (evt.getComponent().getAttributes().get("selectedRepositorio"));	
		try {
			log.info("codigo:"+selectedRepositorio.getRepositorioCodigo());
			if (entity == null) {
				entity = businessDelegatorView.getRepositorio(selectedRepositorio.getRepositorioCodigo());
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

			businessDelegatorView.updateRepositorio(entity);
			FacesUtils.addInfoMessage("El estado del Repositorio ha sido cambiado con exito");
			data=businessDelegatorView.getDataRepositorio();
			dataI=businessDelegatorView.getDataRepositorioI();

			entity=null;
			selectedRepositorio=null;

		}catch (Exception e) {
			FacesUtils.addErrorMessage("Error! No se cambió el estado del repositorio");
			log.error(e.toString());
			log.error(e.getLocalizedMessage());
		}

		return "";
	}
	
	public void txtCrearListener(){
		log.info("Se ejecuto el listener crear Repositorio");
		
		String nombre=txtNombre.getValue().toString().trim();
		
		if(nombreDisponible(nombre)){
			btnCrear.setDisabled(false);
		}else{
			FacesUtils.addInfoMessage("El nombre del Repositorio ya existe");
			btnCrear.setDisabled(true);
		}
	}

	public boolean validarCampos(String nombre, String descripcion){
		boolean resultado=true;;

		if(nombre.isEmpty() || descripcion.isEmpty()){
			resultado=false;
		}

		return resultado;
	}
	
	public String limpiarCamposModificar(){
		txtNombreM.resetValue();
		txtDescripcionM.resetValue();
		return "";
	}

	public boolean nombreDisponible(String nombre){
		Boolean resultado;

		String nombreRepositorio=businessDelegatorView.consultarRepositorioPorNombre(nombre);

		if(nombreRepositorio==null){
			resultado=true;
		}else{
			resultado=false;
		}

		return resultado;
	}	
	
	public String limpiarCamposCrear(){
		txtNombre.resetValue();
		txtDescripcion.resetValue();
		btnCrear.setDisabled(true);
		return "";
	}
	
	public String salirCrearRepositorio(){
		txtNombre.resetValue();
		txtDescripcion.resetValue();
		btnCrear.setDisabled(true);
		setShowDialog(false);		
		return "";
	}
}
