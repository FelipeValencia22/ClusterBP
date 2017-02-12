package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.GrupoUsuarioDTO;
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
public class GrupoUsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GrupoUsuarioView.class);
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtGrupoCodigo_Grupo;
    private InputText txtUsuarioCodigo_Usuario;
    private InputText txtGrupoUsuarioCodigo;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<GrupoUsuarioDTO> data;
    private GrupoUsuarioDTO selectedGrupoUsuario;
    private GrupoUsuario entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GrupoUsuarioView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            GrupoUsuarioDTO grupoUsuarioDTO = (GrupoUsuarioDTO) e.getObject();

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(grupoUsuarioDTO.getUsuCreador());

            if (txtUsuModificador == null) {
                txtUsuModificador = new InputText();
            }

            txtUsuModificador.setValue(grupoUsuarioDTO.getUsuModificador());

            if (txtGrupoCodigo_Grupo == null) {
                txtGrupoCodigo_Grupo = new InputText();
            }

            txtGrupoCodigo_Grupo.setValue(grupoUsuarioDTO.getGrupoCodigo_Grupo());

            if (txtUsuarioCodigo_Usuario == null) {
                txtUsuarioCodigo_Usuario = new InputText();
            }

            txtUsuarioCodigo_Usuario.setValue(grupoUsuarioDTO.getUsuarioCodigo_Usuario());

            if (txtGrupoUsuarioCodigo == null) {
                txtGrupoUsuarioCodigo = new InputText();
            }

            txtGrupoUsuarioCodigo.setValue(grupoUsuarioDTO.getGrupoUsuarioCodigo());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(grupoUsuarioDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(grupoUsuarioDTO.getFechaModificacion());

            Long grupoUsuarioCodigo = FacesUtils.checkLong(txtGrupoUsuarioCodigo);
            entity = businessDelegatorView.getGrupoUsuario(grupoUsuarioCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedGrupoUsuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGrupoUsuario = null;

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtGrupoCodigo_Grupo != null) {
            txtGrupoCodigo_Grupo.setValue(null);
            txtGrupoCodigo_Grupo.setDisabled(true);
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

        if (txtGrupoUsuarioCodigo != null) {
            txtGrupoUsuarioCodigo.setValue(null);
            txtGrupoUsuarioCodigo.setDisabled(false);
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
            Long grupoUsuarioCodigo = FacesUtils.checkLong(txtGrupoUsuarioCodigo);
            entity = (grupoUsuarioCodigo != null)
                ? businessDelegatorView.getGrupoUsuario(grupoUsuarioCodigo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtGrupoCodigo_Grupo.setDisabled(false);
            txtUsuarioCodigo_Usuario.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtGrupoUsuarioCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtGrupoCodigo_Grupo.setValue(entity.getGrupo().getGrupoCodigo());
            txtGrupoCodigo_Grupo.setDisabled(false);
            txtUsuarioCodigo_Usuario.setValue(entity.getUsuario()
                                                    .getUsuarioCodigo());
            txtUsuarioCodigo_Usuario.setDisabled(false);
            txtGrupoUsuarioCodigo.setValue(entity.getGrupoUsuarioCodigo());
            txtGrupoUsuarioCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedGrupoUsuario = (GrupoUsuarioDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedGrupoUsuario"));
        txtFechaCreacion.setValue(selectedGrupoUsuario.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedGrupoUsuario.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedGrupoUsuario.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedGrupoUsuario.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtGrupoCodigo_Grupo.setValue(selectedGrupoUsuario.getGrupoCodigo_Grupo());
        txtGrupoCodigo_Grupo.setDisabled(false);
        txtUsuarioCodigo_Usuario.setValue(selectedGrupoUsuario.getUsuarioCodigo_Usuario());
        txtUsuarioCodigo_Usuario.setDisabled(false);
        txtGrupoUsuarioCodigo.setValue(selectedGrupoUsuario.getGrupoUsuarioCodigo());
        txtGrupoUsuarioCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGrupoUsuario == null) && (entity == null)) {
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
            entity = new GrupoUsuario();

            Long grupoUsuarioCodigo = FacesUtils.checkLong(txtGrupoUsuarioCodigo);

            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setGrupoUsuarioCodigo(grupoUsuarioCodigo);
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setGrupo((FacesUtils.checkLong(txtGrupoCodigo_Grupo) != null)
                ? businessDelegatorView.getGrupo(FacesUtils.checkLong(
                        txtGrupoCodigo_Grupo)) : null);
            entity.setUsuario((FacesUtils.checkLong(txtUsuarioCodigo_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkLong(
                        txtUsuarioCodigo_Usuario)) : null);
            businessDelegatorView.saveGrupoUsuario(entity);
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
                Long grupoUsuarioCodigo = new Long(selectedGrupoUsuario.getGrupoUsuarioCodigo());
                entity = businessDelegatorView.getGrupoUsuario(grupoUsuarioCodigo);
            }

            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setGrupo((FacesUtils.checkLong(txtGrupoCodigo_Grupo) != null)
                ? businessDelegatorView.getGrupo(FacesUtils.checkLong(
                        txtGrupoCodigo_Grupo)) : null);
            entity.setUsuario((FacesUtils.checkLong(txtUsuarioCodigo_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkLong(
                        txtUsuarioCodigo_Usuario)) : null);
            businessDelegatorView.updateGrupoUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedGrupoUsuario = (GrupoUsuarioDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedGrupoUsuario"));

            Long grupoUsuarioCodigo = new Long(selectedGrupoUsuario.getGrupoUsuarioCodigo());
            entity = businessDelegatorView.getGrupoUsuario(grupoUsuarioCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long grupoUsuarioCodigo = FacesUtils.checkLong(txtGrupoUsuarioCodigo);
            entity = businessDelegatorView.getGrupoUsuario(grupoUsuarioCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGrupoUsuario(entity);
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
            selectedGrupoUsuario = (GrupoUsuarioDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedGrupoUsuario"));

            Long grupoUsuarioCodigo = new Long(selectedGrupoUsuario.getGrupoUsuarioCodigo());
            entity = businessDelegatorView.getGrupoUsuario(grupoUsuarioCodigo);
            businessDelegatorView.deleteGrupoUsuario(entity);
            data.remove(selectedGrupoUsuario);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Date fechaCreacion,
        Date fechaModificacion, Long grupoUsuarioCodigo, Long usuCreador,
        Long usuModificador, Long grupoCodigo_Grupo, Long usuarioCodigo_Usuario)
        throws Exception {
        try {
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(usuModificador));
            businessDelegatorView.updateGrupoUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GrupoUsuarioView").requestRender();
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

    public InputText getTxtUsuModificador() {
        return txtUsuModificador;
    }

    public void setTxtUsuModificador(InputText txtUsuModificador) {
        this.txtUsuModificador = txtUsuModificador;
    }

    public InputText getTxtGrupoCodigo_Grupo() {
        return txtGrupoCodigo_Grupo;
    }

    public void setTxtGrupoCodigo_Grupo(InputText txtGrupoCodigo_Grupo) {
        this.txtGrupoCodigo_Grupo = txtGrupoCodigo_Grupo;
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

    public InputText getTxtGrupoUsuarioCodigo() {
        return txtGrupoUsuarioCodigo;
    }

    public void setTxtGrupoUsuarioCodigo(InputText txtGrupoUsuarioCodigo) {
        this.txtGrupoUsuarioCodigo = txtGrupoUsuarioCodigo;
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

    public void setData(List<GrupoUsuarioDTO> grupoUsuarioDTO) {
        this.data = grupoUsuarioDTO;
    }

    public GrupoUsuarioDTO getSelectedGrupoUsuario() {
        return selectedGrupoUsuario;
    }

    public void setSelectedGrupoUsuario(GrupoUsuarioDTO grupoUsuario) {
        this.selectedGrupoUsuario = grupoUsuario;
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
