package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.UsuarioDTO;
import co.edu.usb.exceptions.*;
import co.edu.usb.presentation.businessDelegate.*;
import co.edu.usb.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

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
public class UsuarioView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UsuarioView.class);
	private InputText txtActivo;
	private Password txtClaveC;
	private Password txtClaveRC;
	private InputText txtCorreo;
	private InputText txtNombre;
	private InputText txtUsuCreador;
	private InputText txtUsuaModificador;
	private InputText txtUsuarioCodigo;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;

	private InputText txtActivoM;
	private Password txtClaveCM;
	private Password txtClaveRCM;
	private InputText txtCorreoM;
	private InputText txtNombreM;

	private CommandButton btnCrear;
	private CommandButton btnModificar;
	private CommandButton btnBorrar;
	private CommandButton btnLimpiar;

	private List<UsuarioDTO> data;
	private List<UsuarioDTO> dataI;

	private UsuarioDTO selectedUsuario;

	private Usuario entity;

	private boolean showDialog;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public UsuarioView() {
		super();
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

	public CommandButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(CommandButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public CommandButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(CommandButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public CommandButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(CommandButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public CommandButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(CommandButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public InputText getTxtActivo() {
		return txtActivo;
	}

	public void setTxtActivo(InputText txtActivo) {
		this.txtActivo = txtActivo;
	}



	public Password getTxtClaveC() {
		return txtClaveC;
	}

	public void setTxtClaveC(Password txtClaveC) {
		this.txtClaveC = txtClaveC;
	}

	public Password getTxtClaveRC() {
		return txtClaveRC;
	}

	public void setTxtClaveRC(Password txtClaveRC) {
		this.txtClaveRC = txtClaveRC;
	}

	public InputText getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(InputText txtCorreo) {
		this.txtCorreo = txtCorreo;
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

	public InputText getTxtUsuaModificador() {
		return txtUsuaModificador;
	}

	public void setTxtUsuaModificador(InputText txtUsuaModificador) {
		this.txtUsuaModificador = txtUsuaModificador;
	}

	public InputText getTxtUsuarioCodigo() {
		return txtUsuarioCodigo;
	}

	public void setTxtUsuarioCodigo(InputText txtUsuarioCodigo) {
		this.txtUsuarioCodigo = txtUsuarioCodigo;
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


	public List<UsuarioDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataVtUsuario(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}


	public void setData(List<UsuarioDTO> data) {
		this.data = data;
	}


	public List<UsuarioDTO> getDataI() {
		try {
			if (dataI == null) {
				dataI = businessDelegatorView.getDataVtUsuarioI();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataI;
	}

	public void setDataI(List<UsuarioDTO> dataI) {
		this.dataI = dataI;
	}

	public UsuarioDTO getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(UsuarioDTO selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

	public InputText getTxtActivoM() {
		return txtActivoM;
	}

	public void setTxtActivoM(InputText txtActivoM) {
		this.txtActivoM = txtActivoM;
	}

	public Password getTxtClaveCM() {
		return txtClaveCM;
	}

	public void setTxtClaveCM(Password txtClaveCM) {
		this.txtClaveCM = txtClaveCM;
	}

	public Password getTxtClaveRCM() {
		return txtClaveRCM;
	}

	public void setTxtClaveRCM(Password txtClaveRCM) {
		this.txtClaveRCM = txtClaveRCM;
	}

	public InputText getTxtCorreoM() {
		return txtCorreoM;
	}

	public void setTxtCorreoM(InputText txtCorreoM) {
		this.txtCorreoM = txtCorreoM;
	}

	public InputText getTxtNombreM() {
		return txtNombreM;
	}

	public void setTxtNombreM(InputText txtNombreM) {
		this.txtNombreM = txtNombreM;
	}

	public Usuario getEntity() {
		return entity;
	}

	public void setEntity(Usuario entity) {
		this.entity = entity;
	}

	//TODO: Metodos
	public String crearUsuario() throws Exception{
		try {
			log.info("Creando usuario");
			String claveR=txtClaveRC.getValue().toString().trim();
			String clave=txtClaveC.getValue().toString().trim();

			if(clave.equals(claveR)){
				String correo=txtCorreo.getValue().toString().trim();
				if(correoDisponible(correo)){

					Usuario usuario = new Usuario();
					usuario.setActivo("S");
					usuario.setClave(clave);
					usuario.setCorreo(correo);
					Date fechaCreacion= new Date();
					usuario.setFechaCreacion(fechaCreacion);
					usuario.setNombre(txtNombre.getValue().toString().trim());
					Usuario usuarioCreador=  (Usuario) FacesUtils.getfromSession("usuario");
					usuario.setUsuCreador(usuarioCreador.getUsuarioCodigo());

					businessDelegatorView.saveUsuario(usuario);
					limpiarCrearUsuario();
					FacesContext.getCurrentInstance().addMessage("", new FacesMessage("El usuario se guardo con exito"));
					data=businessDelegatorView.getDataUsuario();

				}
				else{
					FacesContext.getCurrentInstance().addMessage("", new FacesMessage("El correo ya est&#225; en uso"));
				}
			}
			else{
				FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Las contraseñas no coinciden"));
			}
		}catch (Exception e) {
			log.error(e.toString());
			log.error(e.getLocalizedMessage());
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(e.getMessage()));
		}

		return "";

	}

	public String guardarModificacion() throws Exception{

		String claveR=txtClaveRCM.getValue().toString().trim();
		String clave=txtClaveCM.getValue().toString().trim(); 

		if(clave.equals(claveR)){
			if (entity == null) {
				Long usuaCodigo = new Long(selectedUsuario.getUsuarioCodigo());
				entity = businessDelegatorView.getUsuario(usuaCodigo);
			} 
		}

		Date fechaModificacion= new Date();
		entity.setFechaModificacion(fechaModificacion);

		Usuario usuarioEnSession =  (Usuario) FacesUtils.getfromSession("usuario");
		entity.setUsuaModificador(usuarioEnSession.getUsuarioCodigo());

		String correo=txtCorreoM.getValue().toString().trim();

		if(clave.equals(claveR)){

			if(correoDisponible(correo)){

				entity.setCorreo(correo);
				entity.setNombre(txtNombreM.getValue().toString().trim());
				entity.setClave(clave);

				businessDelegatorView.updateUsuario(entity);
				FacesUtils.addInfoMessage("El usuario ha sido modificado con exito");
				data = businessDelegatorView.getDataVtUsuario();
				dataI = businessDelegatorView.getDataVtUsuarioI();

			}else{
				FacesContext.getCurrentInstance().addMessage("", new FacesMessage("El correo ya est&#225; en uso"));
			}
		}
		else{
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Las contraseñas no coinciden"));
		}

		return "";
	}


	public String cambiarEstado(ActionEvent evt){
		log.info("Cambiando estado..");
		selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes().get("selectedVtUsuario"));	

		Usuario entity=null;

		try {
			if (entity == null) {
				entity = businessDelegatorView.getUsuario(selectedUsuario.getUsuarioCodigo());
			} 

			Date fechaModificacion= new Date();
			entity.setFechaModificacion(fechaModificacion);

			Usuario usuarioEnSession =  (Usuario) FacesUtils.getfromSession("usuario");
			entity.setUsuaModificador(usuarioEnSession.getUsuarioCodigo());

			String cambio=entity.getActivo().toString().trim();
			if (cambio.equalsIgnoreCase("S")) {
				entity.setActivo("N");
			}else{
				entity.setActivo("S");
			}	

			businessDelegatorView.updateUsuario(entity); 
			FacesUtils.addInfoMessage("El usuario ha sido modificado con exito");
			data = businessDelegatorView.getDataVtUsuario();
			dataI = businessDelegatorView.getDataVtUsuarioI();

			entity=null;
			selectedUsuario=null;
			limpiarUsuarioModificacion();
		}catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}	

	public String modificarUsuario(ActionEvent evt) {

		selectedUsuario= (UsuarioDTO) evt.getComponent().getAttributes().get("selectedUsuario");	

		txtCorreoM.setValue(selectedUsuario.getCorreo());
		txtNombreM.setValue(selectedUsuario.getNombre());
		txtClaveCM.setValue(selectedUsuario.getClave());
		txtClaveRCM.setValue(selectedUsuario.getClave());

		setShowDialog(true);

		return "";
	}

	public String limpiarCrearUsuario(){
		log.info("Limpiando campos de texto de Usuario nuevo");
		txtNombre.resetValue();
		txtCorreo.resetValue();
		txtClaveC.resetValue();
		txtClaveRC.resetValue();
		btnCrear.setDisabled(true);
		return "";
	}

	public String limpiarUsuarioModificacion(){
		log.info("Limpiando campos de texto de Usuario modificado");
		txtCorreoM.resetValue();
		txtNombreM.resetValue();
		txtClaveCM.resetValue();
		txtClaveRCM.resetValue();
		btnModificar.setDisabled(true);
		return "";
	}

	public String action_closeDialog() {
		setShowDialog(false);
		limpiarUsuarioModificacion();

		return "";
	}

	public boolean correoDisponible(String correo){
		Boolean resultado;

		Usuario usuario=null;
		usuario=businessDelegatorView.correoDisponible(correo);
		if(usuario==null){
			resultado=true;
		}else{
			resultado=false;
		}
		return resultado;
	}

	public void txtLoginListener(){
		log.info("Se ejecuto el listener crear Usuario");

		Usuario usuario=null;
		String correo=txtCorreo.getValue().toString().trim();
		usuario=businessDelegatorView.consultarUsuarioPorCorreo(correo);

		if(usuario==null){
			txtNombre.resetValue();
			txtClaveC.resetValue();
			txtClaveRC.resetValue();
			btnCrear.setDisabled(false);
		}else{
			txtNombre.setValue(usuario.getNombre());
			btnCrear.setDisabled(true);
		}
	}

}
