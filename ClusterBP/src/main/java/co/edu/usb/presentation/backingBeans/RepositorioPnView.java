package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.RepositorioPnDTO;
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
public class RepositorioPnView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RepositorioPnView.class);
    private InputText txtActivo;
    private InputText txtUsuCreador;
    private InputText txtUsuarioModificador;
    private InputText txtPnCodigo_Pn;
    private InputText txtRepositorioCodigo_Repositorio;
    private InputText txtRepositorioPnCodigo;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RepositorioPnDTO> data;
    private RepositorioPnDTO selectedRepositorioPn;
    private RepositorioPn entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public RepositorioPnView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            RepositorioPnDTO repositorioPnDTO = (RepositorioPnDTO) e.getObject();

            if (txtActivo == null) {
                txtActivo = new InputText();
            }

            txtActivo.setValue(repositorioPnDTO.getActivo());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(repositorioPnDTO.getUsuCreador());

            if (txtUsuarioModificador == null) {
                txtUsuarioModificador = new InputText();
            }

            txtUsuarioModificador.setValue(repositorioPnDTO.getUsuarioModificador());

            if (txtPnCodigo_Pn == null) {
                txtPnCodigo_Pn = new InputText();
            }

            txtPnCodigo_Pn.setValue(repositorioPnDTO.getPnCodigo_Pn());

            if (txtRepositorioCodigo_Repositorio == null) {
                txtRepositorioCodigo_Repositorio = new InputText();
            }

            txtRepositorioCodigo_Repositorio.setValue(repositorioPnDTO.getRepositorioCodigo_Repositorio());

            if (txtRepositorioPnCodigo == null) {
                txtRepositorioPnCodigo = new InputText();
            }

            txtRepositorioPnCodigo.setValue(repositorioPnDTO.getRepositorioPnCodigo());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(repositorioPnDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(repositorioPnDTO.getFechaModificacion());

            Long repositorioPnCodigo = FacesUtils.checkLong(txtRepositorioPnCodigo);
            entity = businessDelegatorView.getRepositorioPn(repositorioPnCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedRepositorioPn = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedRepositorioPn = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuarioModificador != null) {
            txtUsuarioModificador.setValue(null);
            txtUsuarioModificador.setDisabled(true);
        }

        if (txtPnCodigo_Pn != null) {
            txtPnCodigo_Pn.setValue(null);
            txtPnCodigo_Pn.setDisabled(true);
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

        if (txtRepositorioPnCodigo != null) {
            txtRepositorioPnCodigo.setValue(null);
            txtRepositorioPnCodigo.setDisabled(false);
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
            Long repositorioPnCodigo = FacesUtils.checkLong(txtRepositorioPnCodigo);
            entity = (repositorioPnCodigo != null)
                ? businessDelegatorView.getRepositorioPn(repositorioPnCodigo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuarioModificador.setDisabled(false);
            txtPnCodigo_Pn.setDisabled(false);
            txtRepositorioCodigo_Repositorio.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtRepositorioPnCodigo.setDisabled(false);
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
            txtUsuarioModificador.setValue(entity.getUsuarioModificador());
            txtUsuarioModificador.setDisabled(false);
            txtPnCodigo_Pn.setValue(entity.getPn().getPnCodigo());
            txtPnCodigo_Pn.setDisabled(false);
            txtRepositorioCodigo_Repositorio.setValue(entity.getRepositorio()
                                                            .getRepositorioCodigo());
            txtRepositorioCodigo_Repositorio.setDisabled(false);
            txtRepositorioPnCodigo.setValue(entity.getRepositorioPnCodigo());
            txtRepositorioPnCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedRepositorioPn = (RepositorioPnDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedRepositorioPn"));
        txtActivo.setValue(selectedRepositorioPn.getActivo());
        txtActivo.setDisabled(false);
        txtFechaCreacion.setValue(selectedRepositorioPn.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedRepositorioPn.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedRepositorioPn.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuarioModificador.setValue(selectedRepositorioPn.getUsuarioModificador());
        txtUsuarioModificador.setDisabled(false);
        txtPnCodigo_Pn.setValue(selectedRepositorioPn.getPnCodigo_Pn());
        txtPnCodigo_Pn.setDisabled(false);
        txtRepositorioCodigo_Repositorio.setValue(selectedRepositorioPn.getRepositorioCodigo_Repositorio());
        txtRepositorioCodigo_Repositorio.setDisabled(false);
        txtRepositorioPnCodigo.setValue(selectedRepositorioPn.getRepositorioPnCodigo());
        txtRepositorioPnCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedRepositorioPn == null) && (entity == null)) {
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
            entity = new RepositorioPn();

            Long repositorioPnCodigo = FacesUtils.checkLong(txtRepositorioPnCodigo);

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setRepositorioPnCodigo(repositorioPnCodigo);
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuarioModificador(FacesUtils.checkLong(
                    txtUsuarioModificador));
            entity.setPn((FacesUtils.checkLong(txtPnCodigo_Pn) != null)
                ? businessDelegatorView.getPn(FacesUtils.checkLong(
                        txtPnCodigo_Pn)) : null);
            entity.setRepositorio((FacesUtils.checkLong(
                    txtRepositorioCodigo_Repositorio) != null)
                ? businessDelegatorView.getRepositorio(FacesUtils.checkLong(
                        txtRepositorioCodigo_Repositorio)) : null);
            businessDelegatorView.saveRepositorioPn(entity);
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
                Long repositorioPnCodigo = new Long(selectedRepositorioPn.getRepositorioPnCodigo());
                entity = businessDelegatorView.getRepositorioPn(repositorioPnCodigo);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuarioModificador(FacesUtils.checkLong(
                    txtUsuarioModificador));
            entity.setPn((FacesUtils.checkLong(txtPnCodigo_Pn) != null)
                ? businessDelegatorView.getPn(FacesUtils.checkLong(
                        txtPnCodigo_Pn)) : null);
            entity.setRepositorio((FacesUtils.checkLong(
                    txtRepositorioCodigo_Repositorio) != null)
                ? businessDelegatorView.getRepositorio(FacesUtils.checkLong(
                        txtRepositorioCodigo_Repositorio)) : null);
            businessDelegatorView.updateRepositorioPn(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedRepositorioPn = (RepositorioPnDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedRepositorioPn"));

            Long repositorioPnCodigo = new Long(selectedRepositorioPn.getRepositorioPnCodigo());
            entity = businessDelegatorView.getRepositorioPn(repositorioPnCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long repositorioPnCodigo = FacesUtils.checkLong(txtRepositorioPnCodigo);
            entity = businessDelegatorView.getRepositorioPn(repositorioPnCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteRepositorioPn(entity);
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
            selectedRepositorioPn = (RepositorioPnDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedRepositorioPn"));

            Long repositorioPnCodigo = new Long(selectedRepositorioPn.getRepositorioPnCodigo());
            entity = businessDelegatorView.getRepositorioPn(repositorioPnCodigo);
            businessDelegatorView.deleteRepositorioPn(entity);
            data.remove(selectedRepositorioPn);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String activo, Date fechaCreacion,
        Date fechaModificacion, Long repositorioPnCodigo, Long usuCreador,
        Long usuarioModificador, Long pnCodigo_Pn,
        Long repositorioCodigo_Repositorio) throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
            entity.setUsuarioModificador(FacesUtils.checkLong(
                    usuarioModificador));
            businessDelegatorView.updateRepositorioPn(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RepositorioPnView").requestRender();
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

    public InputText getTxtUsuarioModificador() {
        return txtUsuarioModificador;
    }

    public void setTxtUsuarioModificador(InputText txtUsuarioModificador) {
        this.txtUsuarioModificador = txtUsuarioModificador;
    }

    public InputText getTxtPnCodigo_Pn() {
        return txtPnCodigo_Pn;
    }

    public void setTxtPnCodigo_Pn(InputText txtPnCodigo_Pn) {
        this.txtPnCodigo_Pn = txtPnCodigo_Pn;
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

    public InputText getTxtRepositorioPnCodigo() {
        return txtRepositorioPnCodigo;
    }

    public void setTxtRepositorioPnCodigo(InputText txtRepositorioPnCodigo) {
        this.txtRepositorioPnCodigo = txtRepositorioPnCodigo;
    }

    public List<RepositorioPnDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRepositorioPn();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RepositorioPnDTO> repositorioPnDTO) {
        this.data = repositorioPnDTO;
    }

    public RepositorioPnDTO getSelectedRepositorioPn() {
        return selectedRepositorioPn;
    }

    public void setSelectedRepositorioPn(RepositorioPnDTO repositorioPn) {
        this.selectedRepositorioPn = repositorioPn;
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
