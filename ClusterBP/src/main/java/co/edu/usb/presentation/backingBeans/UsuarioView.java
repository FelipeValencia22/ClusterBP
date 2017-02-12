package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
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
public class UsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioView.class);
    private InputText txtActivo;
    private InputText txtClave;
    private InputText txtCorreo;
    private InputText txtNombre;
    private InputText txtUsuCreador;
    private InputText txtUsuaModificador;
    private InputText txtUsuarioCodigo;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<UsuarioDTO> data;
    private UsuarioDTO selectedUsuario;
    private Usuario entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public UsuarioView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            UsuarioDTO usuarioDTO = (UsuarioDTO) e.getObject();

            if (txtActivo == null) {
                txtActivo = new InputText();
            }

            txtActivo.setValue(usuarioDTO.getActivo());

            if (txtClave == null) {
                txtClave = new InputText();
            }

            txtClave.setValue(usuarioDTO.getClave());

            if (txtCorreo == null) {
                txtCorreo = new InputText();
            }

            txtCorreo.setValue(usuarioDTO.getCorreo());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(usuarioDTO.getNombre());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(usuarioDTO.getUsuCreador());

            if (txtUsuaModificador == null) {
                txtUsuaModificador = new InputText();
            }

            txtUsuaModificador.setValue(usuarioDTO.getUsuaModificador());

            if (txtUsuarioCodigo == null) {
                txtUsuarioCodigo = new InputText();
            }

            txtUsuarioCodigo.setValue(usuarioDTO.getUsuarioCodigo());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(usuarioDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(usuarioDTO.getFechaModificacion());

            Long usuarioCodigo = FacesUtils.checkLong(txtUsuarioCodigo);
            entity = businessDelegatorView.getUsuario(usuarioCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedUsuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedUsuario = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtClave != null) {
            txtClave.setValue(null);
            txtClave.setDisabled(true);
        }

        if (txtCorreo != null) {
            txtCorreo.setValue(null);
            txtCorreo.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuaModificador != null) {
            txtUsuaModificador.setValue(null);
            txtUsuaModificador.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtUsuarioCodigo != null) {
            txtUsuarioCodigo.setValue(null);
            txtUsuarioCodigo.setDisabled(false);
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
            Long usuarioCodigo = FacesUtils.checkLong(txtUsuarioCodigo);
            entity = (usuarioCodigo != null)
                ? businessDelegatorView.getUsuario(usuarioCodigo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtClave.setDisabled(false);
            txtCorreo.setDisabled(false);
            txtNombre.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuaModificador.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtUsuarioCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtClave.setValue(entity.getClave());
            txtClave.setDisabled(false);
            txtCorreo.setValue(entity.getCorreo());
            txtCorreo.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuaModificador.setValue(entity.getUsuaModificador());
            txtUsuaModificador.setDisabled(false);
            txtUsuarioCodigo.setValue(entity.getUsuarioCodigo());
            txtUsuarioCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                           .get("selectedUsuario"));
        txtActivo.setValue(selectedUsuario.getActivo());
        txtActivo.setDisabled(false);
        txtClave.setValue(selectedUsuario.getClave());
        txtClave.setDisabled(false);
        txtCorreo.setValue(selectedUsuario.getCorreo());
        txtCorreo.setDisabled(false);
        txtFechaCreacion.setValue(selectedUsuario.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedUsuario.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtNombre.setValue(selectedUsuario.getNombre());
        txtNombre.setDisabled(false);
        txtUsuCreador.setValue(selectedUsuario.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuaModificador.setValue(selectedUsuario.getUsuaModificador());
        txtUsuaModificador.setDisabled(false);
        txtUsuarioCodigo.setValue(selectedUsuario.getUsuarioCodigo());
        txtUsuarioCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedUsuario == null) && (entity == null)) {
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
            entity = new Usuario();

            Long usuarioCodigo = FacesUtils.checkLong(txtUsuarioCodigo);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setClave(FacesUtils.checkString(txtClave));
            entity.setCorreo(FacesUtils.checkString(txtCorreo));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuaModificador(FacesUtils.checkLong(txtUsuaModificador));
            entity.setUsuarioCodigo(usuarioCodigo);
            businessDelegatorView.saveUsuario(entity);
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
                Long usuarioCodigo = new Long(selectedUsuario.getUsuarioCodigo());
                entity = businessDelegatorView.getUsuario(usuarioCodigo);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setClave(FacesUtils.checkString(txtClave));
            entity.setCorreo(FacesUtils.checkString(txtCorreo));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuaModificador(FacesUtils.checkLong(txtUsuaModificador));
            businessDelegatorView.updateUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                               .get("selectedUsuario"));

            Long usuarioCodigo = new Long(selectedUsuario.getUsuarioCodigo());
            entity = businessDelegatorView.getUsuario(usuarioCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long usuarioCodigo = FacesUtils.checkLong(txtUsuarioCodigo);
            entity = businessDelegatorView.getUsuario(usuarioCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteUsuario(entity);
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
            selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                               .get("selectedUsuario"));

            Long usuarioCodigo = new Long(selectedUsuario.getUsuarioCodigo());
            entity = businessDelegatorView.getUsuario(usuarioCodigo);
            businessDelegatorView.deleteUsuario(entity);
            data.remove(selectedUsuario);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String activo, String clave,
        String correo, Date fechaCreacion, Date fechaModificacion,
        String nombre, Long usuCreador, Long usuaModificador, Long usuarioCodigo)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setClave(FacesUtils.checkString(clave));
            entity.setCorreo(FacesUtils.checkString(correo));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
            entity.setUsuaModificador(FacesUtils.checkLong(usuaModificador));
            businessDelegatorView.updateUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("UsuarioView").requestRender();
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

    public InputText getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(InputText txtClave) {
        this.txtClave = txtClave;
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

    public InputText getTxtUsuarioCodigo() {
        return txtUsuarioCodigo;
    }

    public void setTxtUsuarioCodigo(InputText txtUsuarioCodigo) {
        this.txtUsuarioCodigo = txtUsuarioCodigo;
    }

    public List<UsuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<UsuarioDTO> usuarioDTO) {
        this.data = usuarioDTO;
    }

    public UsuarioDTO getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(UsuarioDTO usuario) {
        this.selectedUsuario = usuario;
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
}
