package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.LogBusquedaDTO;
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
public class LogBusquedaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LogBusquedaView.class);
    private InputText txtActivo;
    private InputText txtDescLog;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtRepositorioCodigo_Repositorio;
    private InputText txtLogBusquedaCodigo;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<LogBusquedaDTO> data;
    private LogBusquedaDTO selectedLogBusqueda;
    private LogBusqueda entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public LogBusquedaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            LogBusquedaDTO logBusquedaDTO = (LogBusquedaDTO) e.getObject();

            if (txtActivo == null) {
                txtActivo = new InputText();
            }

            txtActivo.setValue(logBusquedaDTO.getActivo());

            if (txtDescLog == null) {
                txtDescLog = new InputText();
            }

            txtDescLog.setValue(logBusquedaDTO.getDescLog());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(logBusquedaDTO.getUsuCreador());

            if (txtUsuModificador == null) {
                txtUsuModificador = new InputText();
            }

            txtUsuModificador.setValue(logBusquedaDTO.getUsuModificador());

            if (txtRepositorioCodigo_Repositorio == null) {
                txtRepositorioCodigo_Repositorio = new InputText();
            }

            txtRepositorioCodigo_Repositorio.setValue(logBusquedaDTO.getRepositorioCodigo_Repositorio());

            if (txtLogBusquedaCodigo == null) {
                txtLogBusquedaCodigo = new InputText();
            }

            txtLogBusquedaCodigo.setValue(logBusquedaDTO.getLogBusquedaCodigo());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(logBusquedaDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(logBusquedaDTO.getFechaModificacion());

            Long logBusquedaCodigo = FacesUtils.checkLong(txtLogBusquedaCodigo);
            entity = businessDelegatorView.getLogBusqueda(logBusquedaCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedLogBusqueda = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedLogBusqueda = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtDescLog != null) {
            txtDescLog.setValue(null);
            txtDescLog.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
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

        if (txtLogBusquedaCodigo != null) {
            txtLogBusquedaCodigo.setValue(null);
            txtLogBusquedaCodigo.setDisabled(false);
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
            Long logBusquedaCodigo = FacesUtils.checkLong(txtLogBusquedaCodigo);
            entity = (logBusquedaCodigo != null)
                ? businessDelegatorView.getLogBusqueda(logBusquedaCodigo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtDescLog.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtRepositorioCodigo_Repositorio.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtLogBusquedaCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtDescLog.setValue(entity.getDescLog());
            txtDescLog.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtRepositorioCodigo_Repositorio.setValue(entity.getRepositorio()
                                                            .getRepositorioCodigo());
            txtRepositorioCodigo_Repositorio.setDisabled(false);
            txtLogBusquedaCodigo.setValue(entity.getLogBusquedaCodigo());
            txtLogBusquedaCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedLogBusqueda = (LogBusquedaDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedLogBusqueda"));
        txtActivo.setValue(selectedLogBusqueda.getActivo());
        txtActivo.setDisabled(false);
        txtDescLog.setValue(selectedLogBusqueda.getDescLog());
        txtDescLog.setDisabled(false);
        txtFechaCreacion.setValue(selectedLogBusqueda.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedLogBusqueda.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedLogBusqueda.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedLogBusqueda.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtRepositorioCodigo_Repositorio.setValue(selectedLogBusqueda.getRepositorioCodigo_Repositorio());
        txtRepositorioCodigo_Repositorio.setDisabled(false);
        txtLogBusquedaCodigo.setValue(selectedLogBusqueda.getLogBusquedaCodigo());
        txtLogBusquedaCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedLogBusqueda == null) && (entity == null)) {
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
            entity = new LogBusqueda();

            Long logBusquedaCodigo = FacesUtils.checkLong(txtLogBusquedaCodigo);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setDescLog(FacesUtils.checkString(txtDescLog));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setLogBusquedaCodigo(logBusquedaCodigo);
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setRepositorio((FacesUtils.checkLong(
                    txtRepositorioCodigo_Repositorio) != null)
                ? businessDelegatorView.getRepositorio(FacesUtils.checkLong(
                        txtRepositorioCodigo_Repositorio)) : null);
            businessDelegatorView.saveLogBusqueda(entity);
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
                Long logBusquedaCodigo = new Long(selectedLogBusqueda.getLogBusquedaCodigo());
                entity = businessDelegatorView.getLogBusqueda(logBusquedaCodigo);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setDescLog(FacesUtils.checkString(txtDescLog));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setRepositorio((FacesUtils.checkLong(
                    txtRepositorioCodigo_Repositorio) != null)
                ? businessDelegatorView.getRepositorio(FacesUtils.checkLong(
                        txtRepositorioCodigo_Repositorio)) : null);
            businessDelegatorView.updateLogBusqueda(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedLogBusqueda = (LogBusquedaDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedLogBusqueda"));

            Long logBusquedaCodigo = new Long(selectedLogBusqueda.getLogBusquedaCodigo());
            entity = businessDelegatorView.getLogBusqueda(logBusquedaCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long logBusquedaCodigo = FacesUtils.checkLong(txtLogBusquedaCodigo);
            entity = businessDelegatorView.getLogBusqueda(logBusquedaCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteLogBusqueda(entity);
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
            selectedLogBusqueda = (LogBusquedaDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedLogBusqueda"));

            Long logBusquedaCodigo = new Long(selectedLogBusqueda.getLogBusquedaCodigo());
            entity = businessDelegatorView.getLogBusqueda(logBusquedaCodigo);
            businessDelegatorView.deleteLogBusqueda(entity);
            data.remove(selectedLogBusqueda);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String activo, String descLog,
        Date fechaCreacion, Date fechaModificacion, Long logBusquedaCodigo,
        Long usuCreador, Long usuModificador, Long repositorioCodigo_Repositorio)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setDescLog(FacesUtils.checkString(descLog));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(usuModificador));
            businessDelegatorView.updateLogBusqueda(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("LogBusquedaView").requestRender();
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

    public InputText getTxtDescLog() {
        return txtDescLog;
    }

    public void setTxtDescLog(InputText txtDescLog) {
        this.txtDescLog = txtDescLog;
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

    public InputText getTxtLogBusquedaCodigo() {
        return txtLogBusquedaCodigo;
    }

    public void setTxtLogBusquedaCodigo(InputText txtLogBusquedaCodigo) {
        this.txtLogBusquedaCodigo = txtLogBusquedaCodigo;
    }

    public List<LogBusquedaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataLogBusqueda();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<LogBusquedaDTO> logBusquedaDTO) {
        this.data = logBusquedaDTO;
    }

    public LogBusquedaDTO getSelectedLogBusqueda() {
        return selectedLogBusqueda;
    }

    public void setSelectedLogBusqueda(LogBusquedaDTO logBusqueda) {
        this.selectedLogBusqueda = logBusqueda;
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
