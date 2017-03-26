package co.edu.usb.presentation.backingBeans;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.PnTxtDTO;
import co.edu.usb.exceptions.*;
import co.edu.usb.presentation.businessDelegate.*;
import co.edu.usb.utilities.*;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.util.List;
import java.util.TimeZone;

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
@ManagedBean(name = "pnTxtView")
public class PnTxtView implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(PnTxtView.class);
    private InputText txtTexto;
    private InputText txtPnCodigo_Pn;
    private InputText txtPnTxtCodigo;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<PnTxtDTO> data;
    private PnTxtDTO selectedPnTxt;
    private PnTxt entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public PnTxtView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            PnTxtDTO pnTxtDTO = (PnTxtDTO) e.getObject();

            if (txtTexto == null) {
                txtTexto = new InputText();
            }

            txtTexto.setValue(pnTxtDTO.getTexto());

            if (txtPnCodigo_Pn == null) {
                txtPnCodigo_Pn = new InputText();
            }

            txtPnCodigo_Pn.setValue(pnTxtDTO.getPnCodigo_Pn());

            if (txtPnTxtCodigo == null) {
                txtPnTxtCodigo = new InputText();
            }

            txtPnTxtCodigo.setValue(pnTxtDTO.getPnTxtCodigo());

            Long pnTxtCodigo = FacesUtils.checkLong(txtPnTxtCodigo);
            entity = businessDelegatorView.getPnTxt(pnTxtCodigo);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedPnTxt = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedPnTxt = null;

        if (txtTexto != null) {
            txtTexto.setValue(null);
            txtTexto.setDisabled(true);
        }

        if (txtPnCodigo_Pn != null) {
            txtPnCodigo_Pn.setValue(null);
            txtPnCodigo_Pn.setDisabled(true);
        }

        if (txtPnTxtCodigo != null) {
            txtPnTxtCodigo.setValue(null);
            txtPnTxtCodigo.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Long pnTxtCodigo = FacesUtils.checkLong(txtPnTxtCodigo);
            entity = (pnTxtCodigo != null)
                ? businessDelegatorView.getPnTxt(pnTxtCodigo) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtTexto.setDisabled(false);
            txtPnCodigo_Pn.setDisabled(false);
            txtPnTxtCodigo.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtTexto.setValue(entity.getTexto());
            txtTexto.setDisabled(false);
            txtPnCodigo_Pn.setValue(entity.getPn().getPnCodigo());
            txtPnCodigo_Pn.setDisabled(false);
            txtPnTxtCodigo.setValue(entity.getPnTxtCodigo());
            txtPnTxtCodigo.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedPnTxt = (PnTxtDTO) (evt.getComponent().getAttributes()
                                       .get("selectedPnTxt"));
        txtTexto.setValue(selectedPnTxt.getTexto());
        txtTexto.setDisabled(false);
        txtPnCodigo_Pn.setValue(selectedPnTxt.getPnCodigo_Pn());
        txtPnCodigo_Pn.setDisabled(false);
        txtPnTxtCodigo.setValue(selectedPnTxt.getPnTxtCodigo());
        txtPnTxtCodigo.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedPnTxt == null) && (entity == null)) {
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
            entity = new PnTxt();

            Long pnTxtCodigo = FacesUtils.checkLong(txtPnTxtCodigo);

            entity.setPnTxtCodigo(pnTxtCodigo);
            entity.setTexto(FacesUtils.checkString(txtTexto));
            entity.setPn((FacesUtils.checkLong(txtPnCodigo_Pn) != null)
                ? businessDelegatorView.getPn(FacesUtils.checkLong(
                        txtPnCodigo_Pn)) : null);
            businessDelegatorView.savePnTxt(entity);
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
                Long pnTxtCodigo = new Long(selectedPnTxt.getPnTxtCodigo());
                entity = businessDelegatorView.getPnTxt(pnTxtCodigo);
            }

            entity.setTexto(FacesUtils.checkString(txtTexto));
            entity.setPn((FacesUtils.checkLong(txtPnCodigo_Pn) != null)
                ? businessDelegatorView.getPn(FacesUtils.checkLong(
                        txtPnCodigo_Pn)) : null);
            businessDelegatorView.updatePnTxt(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedPnTxt = (PnTxtDTO) (evt.getComponent().getAttributes()
                                           .get("selectedPnTxt"));

            Long pnTxtCodigo = new Long(selectedPnTxt.getPnTxtCodigo());
            entity = businessDelegatorView.getPnTxt(pnTxtCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Long pnTxtCodigo = FacesUtils.checkLong(txtPnTxtCodigo);
            entity = businessDelegatorView.getPnTxt(pnTxtCodigo);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deletePnTxt(entity);
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
            selectedPnTxt = (PnTxtDTO) (evt.getComponent().getAttributes()
                                           .get("selectedPnTxt"));

            Long pnTxtCodigo = new Long(selectedPnTxt.getPnTxtCodigo());
            entity = businessDelegatorView.getPnTxt(pnTxtCodigo);
            businessDelegatorView.deletePnTxt(entity);
            data.remove(selectedPnTxt);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long pnTxtCodigo, String texto,
        Long pnCodigo_Pn) throws Exception {
        try {
            entity.setTexto(FacesUtils.checkString(texto));
            businessDelegatorView.updatePnTxt(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("PnTxtView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtTexto() {
        return txtTexto;
    }

    public void setTxtTexto(InputText txtTexto) {
        this.txtTexto = txtTexto;
    }

    public InputText getTxtPnCodigo_Pn() {
        return txtPnCodigo_Pn;
    }

    public void setTxtPnCodigo_Pn(InputText txtPnCodigo_Pn) {
        this.txtPnCodigo_Pn = txtPnCodigo_Pn;
    }

    public InputText getTxtPnTxtCodigo() {
        return txtPnTxtCodigo;
    }

    public void setTxtPnTxtCodigo(InputText txtPnTxtCodigo) {
        this.txtPnTxtCodigo = txtPnTxtCodigo;
    }

    public List<PnTxtDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataPnTxt();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<PnTxtDTO> pnTxtDTO) {
        this.data = pnTxtDTO;
    }

    public PnTxtDTO getSelectedPnTxt() {
        return selectedPnTxt;
    }

    public void setSelectedPnTxt(PnTxtDTO pnTxt) {
        this.selectedPnTxt = pnTxt;
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
