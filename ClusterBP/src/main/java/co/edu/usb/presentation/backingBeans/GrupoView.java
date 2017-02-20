package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.GrupoDTO;
import co.edu.usb.clusterbp.dto.GrupoUsuarioDTO;
import co.edu.usb.clusterbp.dto.UsuarioDTO;
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
public class GrupoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GrupoView.class);
    private InputText txtActivo;
    private InputText txtNombre;
    private InputText txtUsuCreador;
    private InputText txtCorreoUsuarioGrupo;
    private InputText txtNombreUsuarioGrupo;
    
    private CommandButton btnCrear;
	private CommandButton btnModificar;
	private CommandButton btnBorrar;
	private CommandButton btnLimpiar;
    
    private List<GrupoUsuarioDTO> data;
    private List<GrupoUsuarioDTO> dataI;
    
    private GrupoDTO selectedGrupo;
    private Grupo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GrupoView() {
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

	public InputText getTxtActivo() {
		return txtActivo;
	}

	public void setTxtActivo(InputText txtActivo) {
		this.txtActivo = txtActivo;
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

	public InputText getTxtCorreoUsuarioGrupo() {
		return txtCorreoUsuarioGrupo;
	}

	public void setTxtCorreoUsuarioGrupo(InputText txtCorreoUsuarioGrupo) {
		this.txtCorreoUsuarioGrupo = txtCorreoUsuarioGrupo;
	}
	
	public List<GrupoUsuarioDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGrupoUsuario(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public void setData(List<GrupoUsuarioDTO> data) {
		this.data = data;
	}

	public List<GrupoUsuarioDTO> getDataI() {
		try {
			if (dataI == null) {
				dataI = businessDelegatorView.getDataGrupoUsuarioI(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataI;
	}

	public void setDataI(List<GrupoUsuarioDTO> dataI) {
		this.dataI = dataI;
	}

	public GrupoDTO getSelectedGrupo() {
		return selectedGrupo;
	}

	public void setSelectedGrupo(GrupoDTO selectedGrupo) {
		this.selectedGrupo = selectedGrupo;
	}

	public Grupo getEntity() {
		return entity;
	}

	public void setEntity(Grupo entity) {
		this.entity = entity;
	}

	public InputText getTxtNombreUsuarioGrupo() {
		return txtNombreUsuarioGrupo;
	}

	public void setTxtNombreUsuarioGrupo(InputText txtNombreUsuarioGrupo) {
		this.txtNombreUsuarioGrupo = txtNombreUsuarioGrupo;
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

	//TODO: Metodos
	
	public void txtLoginListener(){
		log.info("Se ejecuto el listener crear Usuario");

		Usuario usuario=null;
		String correo=txtCorreoUsuarioGrupo.getValue().toString().trim();
		usuario=businessDelegatorView.consultarUsuarioPorCorreo(correo);

		if(usuario==null){
			btnCrear.setDisabled(true);
			FacesUtils.addErrorMessage("El usuario no existe");
		}else{
			FacesUtils.addInfoMessage("El usuario existe!");
			txtNombreUsuarioGrupo.setValue(usuario.getNombre());
			btnCrear.setDisabled(false);
		}
	}
	
	public String limpiarCrearGrupo(){
		log.info("Limpiando campos de texto de Grupo nuevo");
		txtNombre.resetValue();
		txtCorreoUsuarioGrupo.resetValue();
		txtNombreUsuarioGrupo.resetValue();
		btnCrear.setDisabled(true);
		return "";
	}
	
	public String crearGrupo() throws Exception{
		String mensaje="";
		try {
			log.info("Creando grupo..");
			Grupo grupo = new Grupo();
			Date fechaCreacion= new Date();
			Usuario usuarioCreador=  (Usuario) FacesUtils.getfromSession("usuario");
			String nombre=txtNombre.getValue().toString().trim();
			String correoUsuario=txtCorreoUsuarioGrupo.getValue().toString().trim();
			
			if(nombreDisponible(nombre)){				
				grupo.setActivo("S");
				grupo.setFechaCreacion(fechaCreacion);
				grupo.setUsuCreador(usuarioCreador.getUsuarioCodigo());
				grupo.setNombre(nombre);
				
				businessDelegatorView.saveGrupo(grupo);
				limpiarCrearGrupo();
				FacesUtils.addInfoMessage("El grupo se creó con exito");
			}else{
				FacesUtils.addInfoMessage("El correo ya está en uso");
			}
			
			// Crear el GrupoUsuario despues de crear el usuario 
			GrupoUsuario grupoUsuario= new GrupoUsuario();
			Usuario usuarioGrupo=businessDelegatorView.consultarUsuarioPorCorreo(correoUsuario);
			grupoUsuario.setFechaCreacion(fechaCreacion);			
			grupoUsuario.setGrupo(grupo);
			grupoUsuario.setUsuario(usuarioGrupo);
			grupoUsuario.setUsuCreador(usuarioGrupo.getUsuarioCodigo());
			
			businessDelegatorView.saveGrupoUsuario(grupoUsuario);
			//
			
		}catch (Exception e) {
			log.error(e.toString());
			log.error(e.getLocalizedMessage());
			mensaje=e.toString();
			FacesUtils.addErrorMessage(mensaje);
		}

		
		return "";
	}

	
	public boolean nombreDisponible(String nombre){
		Boolean resultado;
		
		String nombreGrupo=businessDelegatorView.consultarGrupoPorNombre(nombre);
		
		if(nombreGrupo==null){
			resultado=true;
		}else{
			resultado=false;
		}
		
		return resultado;
	}
	
	public String modificarGrupo(ActionEvent evt){
		selectedGrupo=(GrupoDTO) evt.getComponent().getAttributes().get("selectedGrupo");
		
		
		setShowDialog(true);

		return "";
	}
	
	public String cambiarEstado(){
		log.info("Estado cambiado");
		return "";
	}    
    
}
