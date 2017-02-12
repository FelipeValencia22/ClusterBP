package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.VersionRepDTO;
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
public class VersionRepView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(VersionRepView.class);
    private InputText txtDescripcionCambio;
    private InputText txtNombre;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtRepositorioCodigo_Repositorio;
    private InputText txtVersionRepCodigo;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<VersionRepDTO> data;
    private VersionRepDTO selectedVersionRep;
    private VersionRep entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public VersionRepView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            VersionRepDTO versionRepDTO = (VersionRepDTO) e.getObject();

            if (txtDescripcionCambio == null) {
                txtDescripcionCambio = new InputText();
            }

            txtDescripcionCambio.setValue(versionRepDTO.getDescripcionCambio());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(versionRepDTO.getNombre());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(versionRepDTO.getUsuCreador());

            if (txtUsuModificador == null) {
                txtUsuModificador = new InputText();
            }

            txtUsuModificador.setValue(versionRepDTO.getUsuModificador());

            if (txtRepositorioCodigo_Repositorio == null) {
                txtRepositorioCodigo_Repositorio = new InputText();
            }

            txtRepositorioCodigo_Repositorio.setValue(versionRepDTO.getRepositorioCodigo_Repositorio());

            if (txtVersionRepCodigo == null) {
                txtVersionRepCodigo = new InputText();
            }

            txtVersionRepCodigo.setValue(versionRepDTO.getVersionRepCodigo());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(versionRepDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(versionRepDTO.getFechaModificacion());

            Long versionRepCodigo = FacesUtils.checkLong(txtVersionRepCodigo);
            entity = businessDelegatorView.getVersionRep(versionRepCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedVersionRep = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedVersionRep = null;

        if (txtDescripcionCambio != null) {
            txtDescripcionCambio.setValue(null);
            txtDescripcionCambio.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
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

        if (txtVersionRepCodigo != null) {
            txtVersionRepCodigo.setValue(null);
            txtVersionRepCodigo.setDisabled(false);
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
            Long versionRepCodigo = FacesUtils.checkLong(txtVersionRepCodigo);
            entity = (versionRepCodigo != null)
                ? businessDelegatorView.getVersionRep(versionRepCodigo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtDescripcionCambio.setDisabled(false);
            txtNombre.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtRepositorioCodigo_Repositorio.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtVersionRepCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDescripcionCambio.setValue(entity.getDescripcionCambio());
            txtDescripcionCambio.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtRepositorioCodigo_Repositorio.setValue(entity.getRepositorio()
                                                            .getRepositorioCodigo());
            txtRepositorioCodigo_Repositorio.setDisabled(false);
            txtVersionRepCodigo.setValue(entity.getVersionRepCodigo());
            txtVersionRepCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedVersionRep = (VersionRepDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedVersionRep"));
        txtDescripcionCambio.setValue(selectedVersionRep.getDescripcionCambio());
        txtDescripcionCambio.setDisabled(false);
        txtFechaCreacion.setValue(selectedVersionRep.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedVersionRep.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtNombre.setValue(selectedVersionRep.getNombre());
        txtNombre.setDisabled(false);
        txtUsuCreador.setValue(selectedVersionRep.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedVersionRep.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtRepositorioCodigo_Repositorio.setValue(selectedVersionRep.getRepositorioCodigo_Repositorio());
        txtRepositorioCodigo_Repositorio.setDisabled(false);
        txtVersionRepCodigo.setValue(selectedVersionRep.getVersionRepCodigo());
        txtVersionRepCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedVersionRep == null) && (entity == null)) {
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
            entity = new VersionRep();

            Long versionRepCodigo = FacesUtils.checkLong(txtVersionRepCodigo);

            entity.setDescripcionCambio(FacesUtils.checkString(
                    txtDescripcionCambio));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setVersionRepCodigo(versionRepCodigo);
            entity.setRepositorio((FacesUtils.checkLong(
                    txtRepositorioCodigo_Repositorio) != null)
                ? businessDelegatorView.getRepositorio(FacesUtils.checkLong(
                        txtRepositorioCodigo_Repositorio)) : null);
            businessDelegatorView.saveVersionRep(entity);
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
                Long versionRepCodigo = new Long(selectedVersionRep.getVersionRepCodigo());
                entity = businessDelegatorView.getVersionRep(versionRepCodigo);
            }

            entity.setDescripcionCambio(FacesUtils.checkString(
                    txtDescripcionCambio));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setRepositorio((FacesUtils.checkLong(
                    txtRepositorioCodigo_Repositorio) != null)
                ? businessDelegatorView.getRepositorio(FacesUtils.checkLong(
                        txtRepositorioCodigo_Repositorio)) : null);
            businessDelegatorView.updateVersionRep(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedVersionRep = (VersionRepDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedVersionRep"));

            Long versionRepCodigo = new Long(selectedVersionRep.getVersionRepCodigo());
            entity = businessDelegatorView.getVersionRep(versionRepCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long versionRepCodigo = FacesUtils.checkLong(txtVersionRepCodigo);
            entity = businessDelegatorView.getVersionRep(versionRepCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteVersionRep(entity);
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
            selectedVersionRep = (VersionRepDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedVersionRep"));

            Long versionRepCodigo = new Long(selectedVersionRep.getVersionRepCodigo());
            entity = businessDelegatorView.getVersionRep(versionRepCodigo);
            businessDelegatorView.deleteVersionRep(entity);
            data.remove(selectedVersionRep);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String descripcionCambio,
        Date fechaCreacion, Date fechaModificacion, String nombre,
        Long usuCreador, Long usuModificador, Long versionRepCodigo,
        Long repositorioCodigo_Repositorio) throws Exception {
        try {
            entity.setDescripcionCambio(FacesUtils.checkString(
                    descripcionCambio));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(usuModificador));
            businessDelegatorView.updateVersionRep(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("VersionRepView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDescripcionCambio() {
        return txtDescripcionCambio;
    }

    public void setTxtDescripcionCambio(InputText txtDescripcionCambio) {
        this.txtDescripcionCambio = txtDescripcionCambio;
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

    public InputText getTxtVersionRepCodigo() {
        return txtVersionRepCodigo;
    }

    public void setTxtVersionRepCodigo(InputText txtVersionRepCodigo) {
        this.txtVersionRepCodigo = txtVersionRepCodigo;
    }

    public List<VersionRepDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataVersionRep();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<VersionRepDTO> versionRepDTO) {
        this.data = versionRepDTO;
    }

    public VersionRepDTO getSelectedVersionRep() {
        return selectedVersionRep;
    }

    public void setSelectedVersionRep(VersionRepDTO versionRep) {
        this.selectedVersionRep = versionRep;
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
