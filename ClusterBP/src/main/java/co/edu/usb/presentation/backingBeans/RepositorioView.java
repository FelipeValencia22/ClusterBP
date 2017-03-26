package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.RepositorioDTO;
import co.edu.usb.presentation.businessDelegate.*;
import co.edu.usb.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */

@ViewScoped
@ManagedBean(name = "repositorioView")
public class RepositorioView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(RepositorioView.class);

	private InputText txtActivo;
	private InputTextarea txtDescripcion;
	private InputText txtNombre;
	private InputText txtUsuCreador;
	private InputText txtUsuModificador;
	private InputText txtRepositorioCodigo;

	private InputTextarea txtDescripcionM;
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

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public RepositorioView() {
		super();
	}

	public InputText getTxtActivo() {
		return txtActivo;
	}

	public void setTxtActivo(InputText txtActivo) {
		this.txtActivo = txtActivo;
	}

	public InputTextarea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputTextarea txtDescripcion) {
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

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public InputTextarea getTxtDescripcionM() {
		return txtDescripcionM;
	}

	public void setTxtDescripcionM(InputTextarea txtDescripcionM) {
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

	public String salirModificarRepositorio(){
		txtNombreM.resetValue();
		txtDescripcionM.resetValue();
		setShowDialog(false);

		return "";
	}
}
