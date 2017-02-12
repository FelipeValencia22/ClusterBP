package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.RepositorioPluginDTO;
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
public class RepositorioPluginView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RepositorioPluginView.class);
    private InputText txtActivo;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtPluginCodigo_Plugin;
    private InputText txtRepositorioCodigo_Repositorio;
    private InputText txtRepositorioPluginCodigo;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RepositorioPluginDTO> data;
    private RepositorioPluginDTO selectedRepositorioPlugin;
    private RepositorioPlugin entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public RepositorioPluginView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            RepositorioPluginDTO repositorioPluginDTO = (RepositorioPluginDTO) e.getObject();

            if (txtActivo == null) {
                txtActivo = new InputText();
            }

            txtActivo.setValue(repositorioPluginDTO.getActivo());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(repositorioPluginDTO.getUsuCreador());

            if (txtUsuModificador == null) {
                txtUsuModificador = new InputText();
            }

            txtUsuModificador.setValue(repositorioPluginDTO.getUsuModificador());

            if (txtPluginCodigo_Plugin == null) {
                txtPluginCodigo_Plugin = new InputText();
            }

            txtPluginCodigo_Plugin.setValue(repositorioPluginDTO.getPluginCodigo_Plugin());

            if (txtRepositorioCodigo_Repositorio == null) {
                txtRepositorioCodigo_Repositorio = new InputText();
            }

            txtRepositorioCodigo_Repositorio.setValue(repositorioPluginDTO.getRepositorioCodigo_Repositorio());

            if (txtRepositorioPluginCodigo == null) {
                txtRepositorioPluginCodigo = new InputText();
            }

            txtRepositorioPluginCodigo.setValue(repositorioPluginDTO.getRepositorioPluginCodigo());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(repositorioPluginDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(repositorioPluginDTO.getFechaModificacion());

            Long repositorioPluginCodigo = FacesUtils.checkLong(txtRepositorioPluginCodigo);
            entity = businessDelegatorView.getRepositorioPlugin(repositorioPluginCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedRepositorioPlugin = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedRepositorioPlugin = null;

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

        if (txtPluginCodigo_Plugin != null) {
            txtPluginCodigo_Plugin.setValue(null);
            txtPluginCodigo_Plugin.setDisabled(true);
        }

        if (txtRepositorioCodigo_Repositorio != null) {
            txtRepositorioCodigo_Repositorio.setValue(null);
            txtRepositorioCodigo_Repositorio.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtRepositorioPluginCodigo != null) {
            txtRepositorioPluginCodigo.setValue(null);
            txtRepositorioPluginCodigo.setDisabled(false);
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
            Long repositorioPluginCodigo = FacesUtils.checkLong(txtRepositorioPluginCodigo);
            entity = (repositorioPluginCodigo != null)
                ? businessDelegatorView.getRepositorioPlugin(repositorioPluginCodigo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtPluginCodigo_Plugin.setDisabled(false);
            txtRepositorioCodigo_Repositorio.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtRepositorioPluginCodigo.setDisabled(false);
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
            txtPluginCodigo_Plugin.setValue(entity.getPlugin().getPluginCodigo());
            txtPluginCodigo_Plugin.setDisabled(false);
            txtRepositorioCodigo_Repositorio.setValue(entity.getRepositorio()
                                                            .getRepositorioCodigo());
            txtRepositorioCodigo_Repositorio.setDisabled(false);
            txtRepositorioPluginCodigo.setValue(entity.getRepositorioPluginCodigo());
            txtRepositorioPluginCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedRepositorioPlugin = (RepositorioPluginDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedRepositorioPlugin"));
        txtActivo.setValue(selectedRepositorioPlugin.getActivo());
        txtActivo.setDisabled(false);
        txtFechaCreacion.setValue(selectedRepositorioPlugin.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedRepositorioPlugin.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedRepositorioPlugin.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedRepositorioPlugin.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtPluginCodigo_Plugin.setValue(selectedRepositorioPlugin.getPluginCodigo_Plugin());
        txtPluginCodigo_Plugin.setDisabled(false);
        txtRepositorioCodigo_Repositorio.setValue(selectedRepositorioPlugin.getRepositorioCodigo_Repositorio());
        txtRepositorioCodigo_Repositorio.setDisabled(false);
        txtRepositorioPluginCodigo.setValue(selectedRepositorioPlugin.getRepositorioPluginCodigo());
        txtRepositorioPluginCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedRepositorioPlugin == null) && (entity == null)) {
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
            entity = new RepositorioPlugin();

            Long repositorioPluginCodigo = FacesUtils.checkLong(txtRepositorioPluginCodigo);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setRepositorioPluginCodigo(repositorioPluginCodigo);
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setPlugin((FacesUtils.checkLong(txtPluginCodigo_Plugin) != null)
                ? businessDelegatorView.getPlugin(FacesUtils.checkLong(
                        txtPluginCodigo_Plugin)) : null);
            entity.setRepositorio((FacesUtils.checkLong(
                    txtRepositorioCodigo_Repositorio) != null)
                ? businessDelegatorView.getRepositorio(FacesUtils.checkLong(
                        txtRepositorioCodigo_Repositorio)) : null);
            businessDelegatorView.saveRepositorioPlugin(entity);
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
                Long repositorioPluginCodigo = new Long(selectedRepositorioPlugin.getRepositorioPluginCodigo());
                entity = businessDelegatorView.getRepositorioPlugin(repositorioPluginCodigo);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setPlugin((FacesUtils.checkLong(txtPluginCodigo_Plugin) != null)
                ? businessDelegatorView.getPlugin(FacesUtils.checkLong(
                        txtPluginCodigo_Plugin)) : null);
            entity.setRepositorio((FacesUtils.checkLong(
                    txtRepositorioCodigo_Repositorio) != null)
                ? businessDelegatorView.getRepositorio(FacesUtils.checkLong(
                        txtRepositorioCodigo_Repositorio)) : null);
            businessDelegatorView.updateRepositorioPlugin(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedRepositorioPlugin = (RepositorioPluginDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedRepositorioPlugin"));

            Long repositorioPluginCodigo = new Long(selectedRepositorioPlugin.getRepositorioPluginCodigo());
            entity = businessDelegatorView.getRepositorioPlugin(repositorioPluginCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long repositorioPluginCodigo = FacesUtils.checkLong(txtRepositorioPluginCodigo);
            entity = businessDelegatorView.getRepositorioPlugin(repositorioPluginCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteRepositorioPlugin(entity);
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
            selectedRepositorioPlugin = (RepositorioPluginDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedRepositorioPlugin"));

            Long repositorioPluginCodigo = new Long(selectedRepositorioPlugin.getRepositorioPluginCodigo());
            entity = businessDelegatorView.getRepositorioPlugin(repositorioPluginCodigo);
            businessDelegatorView.deleteRepositorioPlugin(entity);
            data.remove(selectedRepositorioPlugin);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String activo, Date fechaCreacion,
        Date fechaModificacion, Long repositorioPluginCodigo, Long usuCreador,
        Long usuModificador, Long pluginCodigo_Plugin,
        Long repositorioCodigo_Repositorio) throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(usuModificador));
            businessDelegatorView.updateRepositorioPlugin(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RepositorioPluginView").requestRender();
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

    public InputText getTxtPluginCodigo_Plugin() {
        return txtPluginCodigo_Plugin;
    }

    public void setTxtPluginCodigo_Plugin(InputText txtPluginCodigo_Plugin) {
        this.txtPluginCodigo_Plugin = txtPluginCodigo_Plugin;
    }

    public InputText getTxtRepositorioCodigo_Repositorio() {
        return txtRepositorioCodigo_Repositorio;
    }

    public void setTxtRepositorioCodigo_Repositorio(
        InputText txtRepositorioCodigo_Repositorio) {
        this.txtRepositorioCodigo_Repositorio = txtRepositorioCodigo_Repositorio;
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

    public InputText getTxtRepositorioPluginCodigo() {
        return txtRepositorioPluginCodigo;
    }

    public void setTxtRepositorioPluginCodigo(
        InputText txtRepositorioPluginCodigo) {
        this.txtRepositorioPluginCodigo = txtRepositorioPluginCodigo;
    }

    public List<RepositorioPluginDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRepositorioPlugin();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RepositorioPluginDTO> repositorioPluginDTO) {
        this.data = repositorioPluginDTO;
    }

    public RepositorioPluginDTO getSelectedRepositorioPlugin() {
        return selectedRepositorioPlugin;
    }

    public void setSelectedRepositorioPlugin(
        RepositorioPluginDTO repositorioPlugin) {
        this.selectedRepositorioPlugin = repositorioPlugin;
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
