package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.UsuarioRolDTO;
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
public class UsuarioRolView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioRolView.class);
    private InputText txtUsuCreador;
    private InputText txtUsuarioModificador;
    private InputText txtRolCodigo_Rol;
    private InputText txtUsuarioCodigo_Usuario;
    private InputText txtUsuarioRolCodigo;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<UsuarioRolDTO> data;
    private UsuarioRolDTO selectedUsuarioRol;
    private UsuarioRol entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public UsuarioRolView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            UsuarioRolDTO usuarioRolDTO = (UsuarioRolDTO) e.getObject();

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(usuarioRolDTO.getUsuCreador());

            if (txtUsuarioModificador == null) {
                txtUsuarioModificador = new InputText();
            }

            txtUsuarioModificador.setValue(usuarioRolDTO.getUsuarioModificador());

            if (txtRolCodigo_Rol == null) {
                txtRolCodigo_Rol = new InputText();
            }

            txtRolCodigo_Rol.setValue(usuarioRolDTO.getRolCodigo_Rol());

            if (txtUsuarioCodigo_Usuario == null) {
                txtUsuarioCodigo_Usuario = new InputText();
            }

            txtUsuarioCodigo_Usuario.setValue(usuarioRolDTO.getUsuarioCodigo_Usuario());

            if (txtUsuarioRolCodigo == null) {
                txtUsuarioRolCodigo = new InputText();
            }

            txtUsuarioRolCodigo.setValue(usuarioRolDTO.getUsuarioRolCodigo());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(usuarioRolDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(usuarioRolDTO.getFechaModificacion());

            Long usuarioRolCodigo = FacesUtils.checkLong(txtUsuarioRolCodigo);
            entity = businessDelegatorView.getUsuarioRol(usuarioRolCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedUsuarioRol = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedUsuarioRol = null;

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuarioModificador != null) {
            txtUsuarioModificador.setValue(null);
            txtUsuarioModificador.setDisabled(true);
        }

        if (txtRolCodigo_Rol != null) {
            txtRolCodigo_Rol.setValue(null);
            txtRolCodigo_Rol.setDisabled(true);
        }

        if (txtUsuarioCodigo_Usuario != null) {
            txtUsuarioCodigo_Usuario.setValue(null);
            txtUsuarioCodigo_Usuario.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtUsuarioRolCodigo != null) {
            txtUsuarioRolCodigo.setValue(null);
            txtUsuarioRolCodigo.setDisabled(false);
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
            Long usuarioRolCodigo = FacesUtils.checkLong(txtUsuarioRolCodigo);
            entity = (usuarioRolCodigo != null)
                ? businessDelegatorView.getUsuarioRol(usuarioRolCodigo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtUsuCreador.setDisabled(false);
            txtUsuarioModificador.setDisabled(false);
            txtRolCodigo_Rol.setDisabled(false);
            txtUsuarioCodigo_Usuario.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtUsuarioRolCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuarioModificador.setValue(entity.getUsuarioModificador());
            txtUsuarioModificador.setDisabled(false);
            txtRolCodigo_Rol.setValue(entity.getRol().getRolCodigo());
            txtRolCodigo_Rol.setDisabled(false);
            txtUsuarioCodigo_Usuario.setValue(entity.getUsuario()
                                                    .getUsuarioCodigo());
            txtUsuarioCodigo_Usuario.setDisabled(false);
            txtUsuarioRolCodigo.setValue(entity.getUsuarioRolCodigo());
            txtUsuarioRolCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedUsuarioRol = (UsuarioRolDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedUsuarioRol"));
        txtFechaCreacion.setValue(selectedUsuarioRol.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedUsuarioRol.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedUsuarioRol.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuarioModificador.setValue(selectedUsuarioRol.getUsuarioModificador());
        txtUsuarioModificador.setDisabled(false);
        txtRolCodigo_Rol.setValue(selectedUsuarioRol.getRolCodigo_Rol());
        txtRolCodigo_Rol.setDisabled(false);
        txtUsuarioCodigo_Usuario.setValue(selectedUsuarioRol.getUsuarioCodigo_Usuario());
        txtUsuarioCodigo_Usuario.setDisabled(false);
        txtUsuarioRolCodigo.setValue(selectedUsuarioRol.getUsuarioRolCodigo());
        txtUsuarioRolCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedUsuarioRol == null) && (entity == null)) {
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
            entity = new UsuarioRol();

            Long usuarioRolCodigo = FacesUtils.checkLong(txtUsuarioRolCodigo);

            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuarioModificador(FacesUtils.checkLong(
                    txtUsuarioModificador));
            entity.setUsuarioRolCodigo(usuarioRolCodigo);
            entity.setRol((FacesUtils.checkLong(txtRolCodigo_Rol) != null)
                ? businessDelegatorView.getRol(FacesUtils.checkLong(
                        txtRolCodigo_Rol)) : null);
            entity.setUsuario((FacesUtils.checkLong(txtUsuarioCodigo_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkLong(
                        txtUsuarioCodigo_Usuario)) : null);
            businessDelegatorView.saveUsuarioRol(entity);
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
                Long usuarioRolCodigo = new Long(selectedUsuarioRol.getUsuarioRolCodigo());
                entity = businessDelegatorView.getUsuarioRol(usuarioRolCodigo);
            }

            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuarioModificador(FacesUtils.checkLong(
                    txtUsuarioModificador));
            entity.setRol((FacesUtils.checkLong(txtRolCodigo_Rol) != null)
                ? businessDelegatorView.getRol(FacesUtils.checkLong(
                        txtRolCodigo_Rol)) : null);
            entity.setUsuario((FacesUtils.checkLong(txtUsuarioCodigo_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkLong(
                        txtUsuarioCodigo_Usuario)) : null);
            businessDelegatorView.updateUsuarioRol(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedUsuarioRol = (UsuarioRolDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedUsuarioRol"));

            Long usuarioRolCodigo = new Long(selectedUsuarioRol.getUsuarioRolCodigo());
            entity = businessDelegatorView.getUsuarioRol(usuarioRolCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long usuarioRolCodigo = FacesUtils.checkLong(txtUsuarioRolCodigo);
            entity = businessDelegatorView.getUsuarioRol(usuarioRolCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteUsuarioRol(entity);
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
            selectedUsuarioRol = (UsuarioRolDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedUsuarioRol"));

            Long usuarioRolCodigo = new Long(selectedUsuarioRol.getUsuarioRolCodigo());
            entity = businessDelegatorView.getUsuarioRol(usuarioRolCodigo);
            businessDelegatorView.deleteUsuarioRol(entity);
            data.remove(selectedUsuarioRol);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Date fechaCreacion,
        Date fechaModificacion, Long usuCreador, Long usuarioModificador,
        Long usuarioRolCodigo, Long rolCodigo_Rol, Long usuarioCodigo_Usuario)
        throws Exception {
        try {
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
            entity.setUsuarioModificador(FacesUtils.checkLong(
                    usuarioModificador));
            businessDelegatorView.updateUsuarioRol(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("UsuarioRolView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtUsuCreador() {
        return txtUsuCreador;
    }

    public void setTxtUsuCreador(InputText txtUsuCreador) {
        this.txtUsuCreador = txtUsuCreador;
    }

    public InputText getTxtUsuarioModificador() {
        return txtUsuarioModificador;
    }

    public void setTxtUsuarioModificador(InputText txtUsuarioModificador) {
        this.txtUsuarioModificador = txtUsuarioModificador;
    }

    public InputText getTxtRolCodigo_Rol() {
        return txtRolCodigo_Rol;
    }

    public void setTxtRolCodigo_Rol(InputText txtRolCodigo_Rol) {
        this.txtRolCodigo_Rol = txtRolCodigo_Rol;
    }

    public InputText getTxtUsuarioCodigo_Usuario() {
        return txtUsuarioCodigo_Usuario;
    }

    public void setTxtUsuarioCodigo_Usuario(InputText txtUsuarioCodigo_Usuario) {
        this.txtUsuarioCodigo_Usuario = txtUsuarioCodigo_Usuario;
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

    public InputText getTxtUsuarioRolCodigo() {
        return txtUsuarioRolCodigo;
    }

    public void setTxtUsuarioRolCodigo(InputText txtUsuarioRolCodigo) {
        this.txtUsuarioRolCodigo = txtUsuarioRolCodigo;
    }

    public List<UsuarioRolDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataUsuarioRol();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<UsuarioRolDTO> usuarioRolDTO) {
        this.data = usuarioRolDTO;
    }

    public UsuarioRolDTO getSelectedUsuarioRol() {
        return selectedUsuarioRol;
    }

    public void setSelectedUsuarioRol(UsuarioRolDTO usuarioRol) {
        this.selectedUsuarioRol = usuarioRol;
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
