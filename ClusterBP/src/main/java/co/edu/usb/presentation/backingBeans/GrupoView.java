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
    
    private InputText txtNombreM;
    private InputText txtCorreoUsuarioGrupoM;
    private InputText txtNombreUsuarioGrupoM;
    
    private CommandButton btnCrear;
	private CommandButton btnModificar;
	private CommandButton btnBorrar;
	private CommandButton btnLimpiar;
    
    private List<GrupoDTO> data;
    private List<GrupoDTO> dataI;
    
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
	
	public Grupo getEntity() {
		return entity;
	}

	public void setEntity(Grupo entity) {
		this.entity = entity;
	}

	public InputText getTxtNombreUsuarioGrupo() {
		return txtNombreUsuarioGrupo;
	}

	public List<GrupoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGrupo(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public void setData(List<GrupoDTO> data) {
		this.data = data;
	}

	public List<GrupoDTO> getDataI() {
		try {
			if (dataI == null) {
				dataI = businessDelegatorView.getDataGrupoI(); 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataI;
	}

	public void setDataI(List<GrupoDTO> dataI) {
		this.dataI = dataI;
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
	public InputText getTxtNombreM() {
		return txtNombreM;
	}

	public void setTxtNombreM(InputText txtNombreM) {
		this.txtNombreM = txtNombreM;
	}

	public InputText getTxtCorreoUsuarioGrupoM() {
		return txtCorreoUsuarioGrupoM;
	}

	public void setTxtCorreoUsuarioGrupoM(InputText txtCorreoUsuarioGrupoM) {
		this.txtCorreoUsuarioGrupoM = txtCorreoUsuarioGrupoM;
	}

	public InputText getTxtNombreUsuarioGrupoM() {
		return txtNombreUsuarioGrupoM;
	}

	public void setTxtNombreUsuarioGrupoM(InputText txtNombreUsuarioGrupoM) {
		this.txtNombreUsuarioGrupoM = txtNombreUsuarioGrupoM;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
	
	/* codigoXhtmlModificar
	<p:inputText id="txtCorreoUsuarioGrupoM"
		placeholder="Correo: due&#241;o del grupo" style="width:400px"
		binding="#{grupoView.txtCorreoUsuarioGrupoM}" maxlength="50">
		<p:ajax listener="#{grupoView.txtLoginListener}"
			update="@([id$=msg), @([id$=txtNombreUsuarioGrupo), @([id$=btnCrear)" />
	</p:inputText>

	<p:inputText id="txtNombreUsuarioGrupoM"
		placeholder="Nombre Usuario" style="width:400px"
		binding="#{grupoView.txtNombreUsuarioGrupoM}" maxlength="50"
		disabled="true">
	</p:inputText>
*/
	
	public String crearGrupo() throws Exception{
		String mensaje="";
		try {
			log.info("Creando grupo..");
			Grupo grupo = new Grupo();
			Date fechaCreacion= new Date();
//			Usuario usuarioCreador= businessDelegatorView.consultarUsuarioPorCorreo
//					(txtCorreoUsuarioGrupo.getValue().toString().trim());
			String nombre=txtNombre.getValue().toString().trim();
			
			if(nombreDisponible(nombre)){				
				grupo.setActivo("S");
				grupo.setFechaCreacion(fechaCreacion);
				Usuario usuarioCreador=  (Usuario) FacesUtils.getfromSession("usuario");
				grupo.setUsuCreador(usuarioCreador.getUsuarioCodigo());
				grupo.setNombre(nombre);
				
				businessDelegatorView.saveGrupo(grupo);
				limpiarCrearGrupo();
				data=businessDelegatorView.getDataGrupo();
				dataI=businessDelegatorView.getDataGrupoI();
				FacesUtils.addInfoMessage("El grupo se creó con exito");
				
				// Crear el GrupoUsuario despues de crear el usuario 
				/*
				GrupoUsuario grupoUsuario= new GrupoUsuario();
				Usuario usuarioGrupo=businessDelegatorView.consultarUsuarioPorCorreo(correoUsuario);
				grupoUsuario.setFechaCreacion(fechaCreacion);			
				grupoUsuario.setGrupo(grupo);
				grupoUsuario.setUsuario(usuarioGrupo);
				grupoUsuario.setUsuCreador(usuarioGrupo.getUsuarioCodigo());
				
				businessDelegatorView.saveGrupoUsuario(grupoUsuario);
				
				*/
				//
			}else{
				FacesUtils.addInfoMessage("El Nombre del Grupo ya está en uso");
			}
			
			
			
		}catch (Exception e) {
			log.error(e.toString());
			log.error(e.getLocalizedMessage());
			mensaje=e.toString();
			FacesUtils.addErrorMessage(mensaje);
		}

		
		return "";
	}
	
	public String cambiarEstado(ActionEvent evt){
		log.info("Cambiando estado..");
		selectedGrupo=(GrupoDTO) (evt.getComponent().getAttributes().get("selectedGrupo"));	
		
		Grupo entity=null;
		
		try {
			if (entity == null) {
				entity=businessDelegatorView.getGrupo(selectedGrupo.getGrupoCodigo());
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
			
			businessDelegatorView.updateGrupo(entity);
			FacesUtils.addInfoMessage("El Grupo ha sido modificado con éxito");
			data=businessDelegatorView.getDataGrupo();
			dataI=businessDelegatorView.getDataGrupoI();
			
			entity=null;
			selectedGrupo=null;
			
			
		}catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return "";
	}
	
	public String limpiarCrearGrupo(){
		log.info("Limpiando campos de texto de Grupo nuevo");
		txtNombre.resetValue();
		btnCrear.setDisabled(true);
		return "";
	}
	
	public String limpiarModificarGrupo(){
		log.info("Limpiando campos de texto de Grupo nuevo");
		txtNombre.resetValue();
		btnCrear.setDisabled(true);
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
	
	public String guardarModificacion(){
		return "";
	}
	
	public String action_closeDialog() {
		setShowDialog(false);
		return "";
	}
	
   public String salirCrearGrupo(){
	   txtNombre.resetValue();
	   setShowDialog(false);
	   return "";
   }
   
   public String salirModificarGrupo(){
	   txtNombreM.resetValue();
	   setShowDialog(false);
	   return "";
   }
    
}
