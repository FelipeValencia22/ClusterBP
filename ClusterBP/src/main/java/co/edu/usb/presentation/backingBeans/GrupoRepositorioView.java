package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.GrupoRepositorioDTO;
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
public class GrupoRepositorioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(GrupoRepositorioView.class);
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtGrupoCodigo_Grupo;
    private InputText txtRepositorioCodigo_Repositorio;
    private InputText txtGrupoRepositorioCodigo;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<GrupoRepositorioDTO> data;
    private GrupoRepositorioDTO selectedGrupoRepositorio;
    private GrupoRepositorio entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public GrupoRepositorioView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            GrupoRepositorioDTO grupoRepositorioDTO = (GrupoRepositorioDTO) e.getObject();

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(grupoRepositorioDTO.getUsuCreador());

            if (txtUsuModificador == null) {
                txtUsuModificador = new InputText();
            }

            txtUsuModificador.setValue(grupoRepositorioDTO.getUsuModificador());

            if (txtGrupoCodigo_Grupo == null) {
                txtGrupoCodigo_Grupo = new InputText();
            }

            txtGrupoCodigo_Grupo.setValue(grupoRepositorioDTO.getGrupoCodigo_Grupo());

            if (txtRepositorioCodigo_Repositorio == null) {
                txtRepositorioCodigo_Repositorio = new InputText();
            }

            txtRepositorioCodigo_Repositorio.setValue(grupoRepositorioDTO.getRepositorioCodigo_Repositorio());

            if (txtGrupoRepositorioCodigo == null) {
                txtGrupoRepositorioCodigo = new InputText();
            }

            txtGrupoRepositorioCodigo.setValue(grupoRepositorioDTO.getGrupoRepositorioCodigo());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(grupoRepositorioDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(grupoRepositorioDTO.getFechaModificacion());

            Long grupoRepositorioCodigo = FacesUtils.checkLong(txtGrupoRepositorioCodigo);
            entity = businessDelegatorView.getGrupoRepositorio(grupoRepositorioCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedGrupoRepositorio = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedGrupoRepositorio = null;

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

        if (txtGrupoRepositorioCodigo != null) {
            txtGrupoRepositorioCodigo.setValue(null);
            txtGrupoRepositorioCodigo.setDisabled(false);
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
            Long grupoRepositorioCodigo = FacesUtils.checkLong(txtGrupoRepositorioCodigo);
            entity = (grupoRepositorioCodigo != null)
                ? businessDelegatorView.getGrupoRepositorio(grupoRepositorioCodigo)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtGrupoCodigo_Grupo.setDisabled(false);
            txtRepositorioCodigo_Repositorio.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtGrupoRepositorioCodigo.setDisabled(false);
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
            txtRepositorioCodigo_Repositorio.setValue(entity.getRepositorio()
                                                            .getRepositorioCodigo());
            txtRepositorioCodigo_Repositorio.setDisabled(false);
            txtGrupoRepositorioCodigo.setValue(entity.getGrupoRepositorioCodigo());
            txtGrupoRepositorioCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedGrupoRepositorio = (GrupoRepositorioDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedGrupoRepositorio"));
        txtFechaCreacion.setValue(selectedGrupoRepositorio.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedGrupoRepositorio.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedGrupoRepositorio.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedGrupoRepositorio.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtGrupoCodigo_Grupo.setValue(selectedGrupoRepositorio.getGrupoCodigo_Grupo());
        txtGrupoCodigo_Grupo.setDisabled(false);
        txtRepositorioCodigo_Repositorio.setValue(selectedGrupoRepositorio.getRepositorioCodigo_Repositorio());
        txtRepositorioCodigo_Repositorio.setDisabled(false);
        txtGrupoRepositorioCodigo.setValue(selectedGrupoRepositorio.getGrupoRepositorioCodigo());
        txtGrupoRepositorioCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedGrupoRepositorio == null) && (entity == null)) {
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
            entity = new GrupoRepositorio();

            Long grupoRepositorioCodigo = FacesUtils.checkLong(txtGrupoRepositorioCodigo);

            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setGrupoRepositorioCodigo(grupoRepositorioCodigo);
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setGrupo((FacesUtils.checkLong(txtGrupoCodigo_Grupo) != null)
                ? businessDelegatorView.getGrupo(FacesUtils.checkLong(
                        txtGrupoCodigo_Grupo)) : null);
            entity.setRepositorio((FacesUtils.checkLong(
                    txtRepositorioCodigo_Repositorio) != null)
                ? businessDelegatorView.getRepositorio(FacesUtils.checkLong(
                        txtRepositorioCodigo_Repositorio)) : null);
            businessDelegatorView.saveGrupoRepositorio(entity);
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
                Long grupoRepositorioCodigo = new Long(selectedGrupoRepositorio.getGrupoRepositorioCodigo());
                entity = businessDelegatorView.getGrupoRepositorio(grupoRepositorioCodigo);
            }

            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            entity.setGrupo((FacesUtils.checkLong(txtGrupoCodigo_Grupo) != null)
                ? businessDelegatorView.getGrupo(FacesUtils.checkLong(
                        txtGrupoCodigo_Grupo)) : null);
            entity.setRepositorio((FacesUtils.checkLong(
                    txtRepositorioCodigo_Repositorio) != null)
                ? businessDelegatorView.getRepositorio(FacesUtils.checkLong(
                        txtRepositorioCodigo_Repositorio)) : null);
            businessDelegatorView.updateGrupoRepositorio(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedGrupoRepositorio = (GrupoRepositorioDTO) (evt.getComponent()
                                                                 .getAttributes()
                                                                 .get("selectedGrupoRepositorio"));

            Long grupoRepositorioCodigo = new Long(selectedGrupoRepositorio.getGrupoRepositorioCodigo());
            entity = businessDelegatorView.getGrupoRepositorio(grupoRepositorioCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long grupoRepositorioCodigo = FacesUtils.checkLong(txtGrupoRepositorioCodigo);
            entity = businessDelegatorView.getGrupoRepositorio(grupoRepositorioCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteGrupoRepositorio(entity);
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
            selectedGrupoRepositorio = (GrupoRepositorioDTO) (evt.getComponent()
                                                                 .getAttributes()
                                                                 .get("selectedGrupoRepositorio"));

            Long grupoRepositorioCodigo = new Long(selectedGrupoRepositorio.getGrupoRepositorioCodigo());
            entity = businessDelegatorView.getGrupoRepositorio(grupoRepositorioCodigo);
            businessDelegatorView.deleteGrupoRepositorio(entity);
            data.remove(selectedGrupoRepositorio);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Date fechaCreacion,
        Date fechaModificacion, Long grupoRepositorioCodigo, Long usuCreador,
        Long usuModificador, Long grupoCodigo_Grupo,
        Long repositorioCodigo_Repositorio) throws Exception {
        try {
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
            entity.setUsuModificador(FacesUtils.checkLong(usuModificador));
            businessDelegatorView.updateGrupoRepositorio(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("GrupoRepositorioView").requestRender();
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

    public InputText getTxtGrupoRepositorioCodigo() {
        return txtGrupoRepositorioCodigo;
    }

    public void setTxtGrupoRepositorioCodigo(
        InputText txtGrupoRepositorioCodigo) {
        this.txtGrupoRepositorioCodigo = txtGrupoRepositorioCodigo;
    }

    public List<GrupoRepositorioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataGrupoRepositorio();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<GrupoRepositorioDTO> grupoRepositorioDTO) {
        this.data = grupoRepositorioDTO;
    }

    public GrupoRepositorioDTO getSelectedGrupoRepositorio() {
        return selectedGrupoRepositorio;
    }

    public void setSelectedGrupoRepositorio(
        GrupoRepositorioDTO grupoRepositorio) {
        this.selectedGrupoRepositorio = grupoRepositorio;
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
