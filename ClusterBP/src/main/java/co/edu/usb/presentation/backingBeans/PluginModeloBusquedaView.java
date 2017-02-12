package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.PluginModeloBusquedaDTO;
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
public class PluginModeloBusquedaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PluginModeloBusquedaView.class);
    private InputText txtActivo;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtModeloBusquedaCodigo_ModeloBusqueda;
    private InputText txtPluginCodigo_Plugin;
    private InputText txtPluginModeloBusquedaCodigo;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<PluginModeloBusquedaDTO> data;
    private PluginModeloBusquedaDTO selectedPluginModeloBusqueda;
    private PluginModeloBusqueda entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public PluginModeloBusquedaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            PluginModeloBusquedaDTO pluginModeloBusquedaDTO = (PluginModeloBusquedaDTO) e.getObject();

            if (txtActivo == null) {
                txtActivo = new InputText();
            }

            txtActivo.setValue(pluginModeloBusquedaDTO.getActivo());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(pluginModeloBusquedaDTO.getUsuCreador());

            if (txtUsuModificador == null) {
                txtUsuModificador = new InputText();
            }

            txtUsuModificador.setValue(pluginModeloBusquedaDTO.getUsuModificador());

            if (txtModeloBusquedaCodigo_ModeloBusqueda == null) {
                txtModeloBusquedaCodigo_ModeloBusqueda = new InputText();
            }

            txtModeloBusquedaCodigo_ModeloBusqueda.setValue(pluginModeloBusquedaDTO.getModeloBusquedaCodigo_ModeloBusqueda());

            if (txtPluginCodigo_Plugin == null) {
                txtPluginCodigo_Plugin = new InputText();
            }

            txtPluginCodigo_Plugin.setValue(pluginModeloBusquedaDTO.getPluginCodigo_Plugin());

            if (txtPluginModeloBusquedaCodigo == null) {
                txtPluginModeloBusquedaCodigo = new InputText();
            }

            txtPluginModeloBusquedaCodigo.setValue(pluginModeloBusquedaDTO.getPluginModeloBusquedaCodigo());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(pluginModeloBusquedaDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(pluginModeloBusquedaDTO.getFechaModificacion());

            Long pluginModeloBusquedaCodigo = FacesUtils.checkLong(txtPluginModeloBusquedaCodigo);
            entity = businessDelegatorView.getPluginModeloBusqueda(pluginModeloBusquedaCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedPluginModeloBusqueda = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedPluginModeloBusqueda = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtModeloBusquedaCodigo_ModeloBusqueda != null) {
            txtModeloBusquedaCodigo_ModeloBusqueda.setValue(null);
            txtModeloBusquedaCodigo_ModeloBusqueda.setDisabled(true);
        }

        if (txtPluginCodigo_Plugin != null) {
            txtPluginCodigo_Plugin.setValue(null);
            txtPluginCodigo_Plugin.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtPluginModeloBusquedaCodigo != null) {
            txtPluginModeloBusquedaCodigo.setValue(null);
            txtPluginModeloBusquedaCodigo.setDisabled(false);
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
            Long pluginModeloBusquedaCodigo = FacesUtils.checkLong(txtPluginModeloBusquedaCodigo);
            entity = (pluginModeloBusquedaCodigo != null)
                ? businessDelegatorView.getPluginModeloBusqueda(pluginModeloBusquedaCodigo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtModeloBusquedaCodigo_ModeloBusqueda.setDisabled(false);
            txtPluginCodigo_Plugin.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtPluginModeloBusquedaCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtModeloBusquedaCodigo_ModeloBusqueda.setValue(entity.getModeloBusqueda()
                                                                  .getModeloBusquedaCodigo());
            txtModeloBusquedaCodigo_ModeloBusqueda.setDisabled(false);
            txtPluginCodigo_Plugin.setValue(entity.getPlugin().getPluginCodigo());
            txtPluginCodigo_Plugin.setDisabled(false);
            txtPluginModeloBusquedaCodigo.setValue(entity.getPluginModeloBusquedaCodigo());
            txtPluginModeloBusquedaCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedPluginModeloBusqueda = (PluginModeloBusquedaDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedPluginModeloBusqueda"));
        txtActivo.setValue(selectedPluginModeloBusqueda.getActivo());
        txtActivo.setDisabled(false);
        txtFechaCreacion.setValue(selectedPluginModeloBusqueda.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedPluginModeloBusqueda.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedPluginModeloBusqueda.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedPluginModeloBusqueda.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtModeloBusquedaCodigo_ModeloBusqueda.setValue(selectedPluginModeloBusqueda.getModeloBusquedaCodigo_ModeloBusqueda());
        txtModeloBusquedaCodigo_ModeloBusqueda.setDisabled(false);
        txtPluginCodigo_Plugin.setValue(selectedPluginModeloBusqueda.getPluginCodigo_Plugin());
        txtPluginCodigo_Plugin.setDisabled(false);
        txtPluginModeloBusquedaCodigo.setValue(selectedPluginModeloBusqueda.getPluginModeloBusquedaCodigo());
        txtPluginModeloBusquedaCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedPluginModeloBusqueda == null) && (entity == null)) {
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
            entity = new PluginModeloBusqueda();

            Long pluginModeloBusquedaCodigo = FacesUtils.checkLong(txtPluginModeloBusquedaCodigo);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setPluginModeloBusquedaCodigo(pluginModeloBusquedaCodigo);
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setModeloBusqueda((FacesUtils.checkLong(
                    txtModeloBusquedaCodigo_ModeloBusqueda) != null)
                ? businessDelegatorView.getModeloBusqueda(FacesUtils.checkLong(
                        txtModeloBusquedaCodigo_ModeloBusqueda)) : null);
            entity.setPlugin((FacesUtils.checkLong(txtPluginCodigo_Plugin) != null)
                ? businessDelegatorView.getPlugin(FacesUtils.checkLong(
                        txtPluginCodigo_Plugin)) : null);
            businessDelegatorView.savePluginModeloBusqueda(entity);
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
                Long pluginModeloBusquedaCodigo = new Long(selectedPluginModeloBusqueda.getPluginModeloBusquedaCodigo());
                entity = businessDelegatorView.getPluginModeloBusqueda(pluginModeloBusquedaCodigo);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setModeloBusqueda((FacesUtils.checkLong(
                    txtModeloBusquedaCodigo_ModeloBusqueda) != null)
                ? businessDelegatorView.getModeloBusqueda(FacesUtils.checkLong(
                        txtModeloBusquedaCodigo_ModeloBusqueda)) : null);
            entity.setPlugin((FacesUtils.checkLong(txtPluginCodigo_Plugin) != null)
                ? businessDelegatorView.getPlugin(FacesUtils.checkLong(
                        txtPluginCodigo_Plugin)) : null);
            businessDelegatorView.updatePluginModeloBusqueda(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedPluginModeloBusqueda = (PluginModeloBusquedaDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedPluginModeloBusqueda"));

            Long pluginModeloBusquedaCodigo = new Long(selectedPluginModeloBusqueda.getPluginModeloBusquedaCodigo());
            entity = businessDelegatorView.getPluginModeloBusqueda(pluginModeloBusquedaCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long pluginModeloBusquedaCodigo = FacesUtils.checkLong(txtPluginModeloBusquedaCodigo);
            entity = businessDelegatorView.getPluginModeloBusqueda(pluginModeloBusquedaCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deletePluginModeloBusqueda(entity);
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
            selectedPluginModeloBusqueda = (PluginModeloBusquedaDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedPluginModeloBusqueda"));

            Long pluginModeloBusquedaCodigo = new Long(selectedPluginModeloBusqueda.getPluginModeloBusquedaCodigo());
            entity = businessDelegatorView.getPluginModeloBusqueda(pluginModeloBusquedaCodigo);
            businessDelegatorView.deletePluginModeloBusqueda(entity);
            data.remove(selectedPluginModeloBusqueda);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String activo, Date fechaCreacion,
        Date fechaModificacion, Long pluginModeloBusquedaCodigo,
        Long usuCreador, Long usuModificador,
        Long modeloBusquedaCodigo_ModeloBusqueda, Long pluginCodigo_Plugin)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(usuModificador));
            businessDelegatorView.updatePluginModeloBusqueda(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("PluginModeloBusquedaView").requestRender();
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

    public InputText getTxtModeloBusquedaCodigo_ModeloBusqueda() {
        return txtModeloBusquedaCodigo_ModeloBusqueda;
    }

    public void setTxtModeloBusquedaCodigo_ModeloBusqueda(
        InputText txtModeloBusquedaCodigo_ModeloBusqueda) {
        this.txtModeloBusquedaCodigo_ModeloBusqueda = txtModeloBusquedaCodigo_ModeloBusqueda;
    }

    public InputText getTxtPluginCodigo_Plugin() {
        return txtPluginCodigo_Plugin;
    }

    public void setTxtPluginCodigo_Plugin(InputText txtPluginCodigo_Plugin) {
        this.txtPluginCodigo_Plugin = txtPluginCodigo_Plugin;
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

    public InputText getTxtPluginModeloBusquedaCodigo() {
        return txtPluginModeloBusquedaCodigo;
    }

    public void setTxtPluginModeloBusquedaCodigo(
        InputText txtPluginModeloBusquedaCodigo) {
        this.txtPluginModeloBusquedaCodigo = txtPluginModeloBusquedaCodigo;
    }

    public List<PluginModeloBusquedaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataPluginModeloBusqueda();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<PluginModeloBusquedaDTO> pluginModeloBusquedaDTO) {
        this.data = pluginModeloBusquedaDTO;
    }

    public PluginModeloBusquedaDTO getSelectedPluginModeloBusqueda() {
        return selectedPluginModeloBusqueda;
    }

    public void setSelectedPluginModeloBusqueda(
        PluginModeloBusquedaDTO pluginModeloBusqueda) {
        this.selectedPluginModeloBusqueda = pluginModeloBusqueda;
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
