package  co.edu.usb.presentation.backingBeans;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.io.Serializable;
import java.sql.*;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.event.RowEditEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import  co.edu.usb.exceptions.*;
import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.PnDTO;
import co.edu.usb.presentation.businessDelegate.*;
import co.edu.usb.utilities.*;
/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 * 
 */
 

@ManagedBean
@ViewScoped
public class PnView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(PnView.class);

public PnView() {
super();
}
    private InputText txtActivo;
    private InputText txtArchivo;
    private InputText txtDescripcion;
    private InputText txtTitulo;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtTipoArchivoPnCodigo_TipoArchivoPn;
    private InputText txtPnCodigo;
            private Calendar txtFechaCreacion;
            private Calendar txtFechaModificacion;
    private CommandButton btnSave;
private CommandButton btnModify;
private CommandButton btnDelete;
private CommandButton btnClear;
private List<PnDTO> data;
private PnDTO selectedPn;
private Pn entity;
private boolean showDialog;
    
@ManagedProperty(value="#{BusinessDelegatorView}")
private IBusinessDelegatorView businessDelegatorView;


	      public void rowEventListener(RowEditEvent e){
			try {
			
			PnDTO pnDTO = (PnDTO) e.getObject(); 
			
							if(txtActivo == null){
					txtActivo = new InputText ();
				}
				txtActivo.setValue(pnDTO.getActivo());
								if(txtArchivo == null){
					txtArchivo = new InputText ();
				}
				txtArchivo.setValue(pnDTO.getArchivo());
								if(txtDescripcion == null){
					txtDescripcion = new InputText ();
				}
				txtDescripcion.setValue(pnDTO.getDescripcion());
								if(txtTitulo == null){
					txtTitulo = new InputText ();
				}
				txtTitulo.setValue(pnDTO.getTitulo());
								if(txtUsuCreador == null){
					txtUsuCreador = new InputText ();
				}
				txtUsuCreador.setValue(pnDTO.getUsuCreador());
								if(txtUsuModificador == null){
					txtUsuModificador = new InputText ();
				}
				txtUsuModificador.setValue(pnDTO.getUsuModificador());
								if(txtTipoArchivoPnCodigo_TipoArchivoPn == null){
					txtTipoArchivoPnCodigo_TipoArchivoPn = new InputText ();
				}
				txtTipoArchivoPnCodigo_TipoArchivoPn.setValue(pnDTO.getTipoArchivoPnCodigo_TipoArchivoPn());
											if(txtPnCodigo == null){
					txtPnCodigo = new InputText ();
				}
				txtPnCodigo.setValue(pnDTO.getPnCodigo());
														if(txtFechaCreacion == null){
					txtFechaCreacion = new Calendar ();
				}
				txtFechaCreacion.setValue(pnDTO.getFechaCreacion());
								if(txtFechaModificacion == null){
					txtFechaModificacion = new Calendar ();
				}
				txtFechaModificacion.setValue(pnDTO.getFechaModificacion());
										
						
					        Long pnCodigo = FacesUtils.checkLong(txtPnCodigo);
		    			entity = businessDelegatorView.getPn(pnCodigo);
			
			action_modify();
			
			}catch (Exception ex) {
			
			}
		
		}
		
	public String action_new(){
		action_clear();
		selectedPn = null;
		setShowDialog(true);
		return "";
	}

	public String action_clear() {
		
		entity = null;
		selectedPn = null;
		
                    if(txtActivo != null){
			 txtActivo.setValue(null);
             txtActivo.setDisabled(true);
			}
                    if(txtArchivo != null){
			 txtArchivo.setValue(null);
             txtArchivo.setDisabled(true);
			}
                    if(txtDescripcion != null){
			 txtDescripcion.setValue(null);
             txtDescripcion.setDisabled(true);
			}
                    if(txtTitulo != null){
			 txtTitulo.setValue(null);
             txtTitulo.setDisabled(true);
			}
                    if(txtUsuCreador != null){
			 txtUsuCreador.setValue(null);
             txtUsuCreador.setDisabled(true);
			}
                    if(txtUsuModificador != null){
			 txtUsuModificador.setValue(null);
             txtUsuModificador.setDisabled(true);
			}
                    if(txtTipoArchivoPnCodigo_TipoArchivoPn != null){
			 txtTipoArchivoPnCodigo_TipoArchivoPn.setValue(null);
             txtTipoArchivoPnCodigo_TipoArchivoPn.setDisabled(true);
			}
                                            if(txtFechaCreacion != null){
				  txtFechaCreacion.setValue(null);
                  txtFechaCreacion.setDisabled(true);
				}
                            if(txtFechaModificacion != null){
				  txtFechaModificacion.setValue(null);
                  txtFechaModificacion.setDisabled(true);
				}
                            			    if(txtPnCodigo != null){
				   txtPnCodigo.setValue(null);
				   txtPnCodigo.setDisabled(false);	
				}
                        if(btnSave != null){
		  btnSave.setDisabled(true);
		}
		if (btnDelete != null) {
        	btnDelete.setDisabled(true);
        }
        return "";
        }

														public void listener_txtFechaCreacion(){
			Date inputDate = (Date)txtFechaCreacion.getValue();
			DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Selected Date " +dateFormat.format(inputDate)));
			}
						public void listener_txtFechaModificacion(){
			Date inputDate = (Date)txtFechaModificacion.getValue();
			DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Selected Date " +dateFormat.format(inputDate)));
			}
							
	public void listener_txtId(){
    
	    try {
	    	        Long pnCodigo = FacesUtils.checkLong(txtPnCodigo);
	    	    	entity = pnCodigo != null ? businessDelegatorView.getPn(pnCodigo) : null;
	    } catch (Exception e) {
	    	entity = null;
	    }
	    
		if(entity==null){
	    	        txtActivo.setDisabled(false);
	    	        txtArchivo.setDisabled(false);
	    	        txtDescripcion.setDisabled(false);
	    	        txtTitulo.setDisabled(false);
	    	        txtUsuCreador.setDisabled(false);
	    	        txtUsuModificador.setDisabled(false);
	    	        txtTipoArchivoPnCodigo_TipoArchivoPn.setDisabled(false);
	    	    	        	            txtFechaCreacion.setDisabled(false);
	        	            txtFechaModificacion.setDisabled(false);
	        	    	    	        txtPnCodigo.setDisabled(false);
	    	    		    btnSave.setDisabled(false);
		    }else{
		    		        txtActivo.setValue(entity.getActivo());txtActivo.setDisabled(false);
		    		        txtArchivo.setValue(entity.getArchivo());txtArchivo.setDisabled(false);
		    		        txtDescripcion.setValue(entity.getDescripcion());txtDescripcion.setDisabled(false);
		    		        txtFechaCreacion.setValue(entity.getFechaCreacion());txtFechaCreacion.setDisabled(false);
		    		        txtFechaModificacion.setValue(entity.getFechaModificacion());txtFechaModificacion.setDisabled(false);
		    		        txtTitulo.setValue(entity.getTitulo());txtTitulo.setDisabled(false);
		    		        txtUsuCreador.setValue(entity.getUsuCreador());txtUsuCreador.setDisabled(false);
		    		        txtUsuModificador.setValue(entity.getUsuModificador());txtUsuModificador.setDisabled(false);
		    		        txtTipoArchivoPnCodigo_TipoArchivoPn.setValue(entity.getTipoArchivoPn().getTipoArchivoPnCodigo());txtTipoArchivoPnCodigo_TipoArchivoPn.setDisabled(false);
		    		    		        txtPnCodigo.setValue(entity.getPnCodigo());txtPnCodigo.setDisabled(true);
		    		    btnSave.setDisabled(false);
		    if(btnDelete!=null){
		    	btnDelete.setDisabled(false);
		    }
	    }
    }
        
	public String action_edit(ActionEvent evt){
    	
    	selectedPn = (PnDTO)(evt.getComponent().getAttributes().get("selectedPn"));		
            txtActivo.setValue(selectedPn.getActivo());txtActivo.setDisabled(false);
            txtArchivo.setValue(selectedPn.getArchivo());txtArchivo.setDisabled(false);
            txtDescripcion.setValue(selectedPn.getDescripcion());txtDescripcion.setDisabled(false);
            txtFechaCreacion.setValue(selectedPn.getFechaCreacion());txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(selectedPn.getFechaModificacion());txtFechaModificacion.setDisabled(false);
            txtTitulo.setValue(selectedPn.getTitulo());txtTitulo.setDisabled(false);
            txtUsuCreador.setValue(selectedPn.getUsuCreador());txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(selectedPn.getUsuModificador());txtUsuModificador.setDisabled(false);
            txtTipoArchivoPnCodigo_TipoArchivoPn.setValue(selectedPn.getTipoArchivoPnCodigo_TipoArchivoPn());txtTipoArchivoPnCodigo_TipoArchivoPn.setDisabled(false);
                txtPnCodigo.setValue(selectedPn.getPnCodigo());txtPnCodigo.setDisabled(true);
            btnSave.setDisabled(false);
    	setShowDialog(true);

    	return "";
    }
    
    public String action_save(){    	
        try {        	
        	if(selectedPn == null && entity==null){
        		action_create();
        	}else{
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
        	entity = new Pn();

	    	        Long pnCodigo = FacesUtils.checkLong(txtPnCodigo);
	    
                        entity.setActivo(FacesUtils.checkString(txtActivo));
                                entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
                                entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
                                entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
                                            	            		entity.setPnCodigo(pnCodigo);
            	                                            entity.setTitulo(FacesUtils.checkString(txtTitulo));
                                            	            		entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            	                                                        	            		entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            	                                        entity.setTipoArchivoPn(FacesUtils.checkLong(txtTipoArchivoPnCodigo_TipoArchivoPn) != null ? businessDelegatorView.getTipoArchivoPn(FacesUtils.checkLong(txtTipoArchivoPnCodigo_TipoArchivoPn)) : null );
        	        businessDelegatorView.savePn(entity);
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
        	if(entity==null){
		    		        Long pnCodigo = new Long(selectedPn.getPnCodigo());
		    	    		entity = businessDelegatorView.getPn(pnCodigo);
    		}
    		
        	    		entity.setActivo(FacesUtils.checkString(txtActivo));
    	        	    		entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
    	        	    		entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
    	        	    		entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
    	        	        	    		entity.setTitulo(FacesUtils.checkString(txtTitulo));
    	        	    		entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
    	        	    		entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
    	    	    	        entity.setTipoArchivoPn(FacesUtils.checkLong(txtTipoArchivoPnCodigo_TipoArchivoPn) != null ? businessDelegatorView.getTipoArchivoPn(FacesUtils.checkLong(txtTipoArchivoPnCodigo_TipoArchivoPn)) : null );
	        	        businessDelegatorView.updatePn(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
		   data=null;
           FacesUtils.addErrorMessage(e.getMessage());
        }
        return "";
	}
	
	public String action_delete_datatable(ActionEvent evt){
		try{
        	selectedPn = (PnDTO)(evt.getComponent().getAttributes().get("selectedPn"));
    						Long pnCodigo = new Long(selectedPn.getPnCodigo());
						entity = businessDelegatorView.getPn(pnCodigo);
        	action_delete();
        }catch(Exception e ){
		 FacesUtils.addErrorMessage(e.getMessage());
		}    
        return "";
    }
	
	public String action_delete_master(){
		try{
					        Long pnCodigo = FacesUtils.checkLong(txtPnCodigo);
		    		    entity = businessDelegatorView.getPn(pnCodigo);
        	action_delete();
        }catch(Exception e ){
		 FacesUtils.addErrorMessage(e.getMessage());
		}    
        return "";
    }
    
	public void action_delete() throws Exception{
		try{
			businessDelegatorView.deletePn(entity);
    		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
            data= null;
		}catch(Exception e ){
			throw e;
		}  
	}	
	
    public String action_closeDialog(){
    	setShowDialog(false);
    	action_clear();    	
    	return "";
    }	
		
		
				
	public String actionDeleteDataTableEditable(ActionEvent evt){
		
		try{
			selectedPn = (PnDTO)(evt.getComponent().getAttributes().get("selectedPn"));		
	    	        Long pnCodigo = new Long(selectedPn.getPnCodigo());
	        		entity = businessDelegatorView.getPn(pnCodigo);
			businessDelegatorView.deletePn(entity);
			data.remove(selectedPn);
    		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		}catch(Exception e ){
		 FacesUtils.addErrorMessage(e.getMessage());
		}  
		
		return "";
	}
		
        public String action_modifyWitDTO(String activo, String descripcion, Date fechaCreacion, Date fechaModificacion, Long pnCodigo, String titulo, Long usuCreador, Long usuModificador, Long tipoArchivoPnCodigo_TipoArchivoPn) throws Exception {
        try {
        
        	    		entity.setActivo(FacesUtils.checkString(activo));
    	        	    		entity.setDescripcion(FacesUtils.checkString(descripcion));
    	        	    		entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
    	        	    		entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
    	        	        	    		entity.setTitulo(FacesUtils.checkString(titulo));
    	        	    		entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
    	        	    		entity.setUsuModificador(FacesUtils.checkLong(usuModificador));
    	            businessDelegatorView.updatePn(entity);
		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
        //renderManager.getOnDemandRenderer("PnView").requestRender();
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
                                                                                            public InputText getTxtArchivo() {
                                                return txtArchivo;
                                                }
                                                public void setTxtArchivo(InputText txtArchivo) {
                                                this.txtArchivo = txtArchivo;
                                                }
                                                                                            public InputText getTxtDescripcion() {
                                                return txtDescripcion;
                                                }
                                                public void setTxtDescripcion(InputText txtDescripcion) {
                                                this.txtDescripcion = txtDescripcion;
                                                }
                                                                                            public InputText getTxtTitulo() {
                                                return txtTitulo;
                                                }
                                                public void setTxtTitulo(InputText txtTitulo) {
                                                this.txtTitulo = txtTitulo;
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
                                                                                            public InputText getTxtTipoArchivoPnCodigo_TipoArchivoPn() {
                                                return txtTipoArchivoPnCodigo_TipoArchivoPn;
                                                }
                                                public void setTxtTipoArchivoPnCodigo_TipoArchivoPn(InputText txtTipoArchivoPnCodigo_TipoArchivoPn) {
                                                this.txtTipoArchivoPnCodigo_TipoArchivoPn = txtTipoArchivoPnCodigo_TipoArchivoPn;
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
                                                                                                                                                                                        public InputText getTxtPnCodigo() {
                                                return txtPnCodigo;
                                                }
                                                public void setTxtPnCodigo(InputText txtPnCodigo) {
                                                this.txtPnCodigo = txtPnCodigo;
                                                }
                                                                                        											
																						public List<PnDTO> getData() {
												try{
													if(data==null){
													data = businessDelegatorView.getDataPn();
													}	
												
												}catch(Exception e){
												 e.printStackTrace();
												}
												return data;
											}
																						public void setData(List<PnDTO> pnDTO){
												this.data=pnDTO;
											}
											
																						
											public PnDTO getSelectedPn(){
												return selectedPn;
											}
											
											public void setSelectedPn (PnDTO pn ){
												this.selectedPn = pn;
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

											public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
											this.businessDelegatorView = businessDelegatorView;
											}
											
											public boolean isShowDialog() {
												return showDialog;
											}
										
											public void setShowDialog(boolean showDialog) {
												this.showDialog = showDialog;
											}											
                                             
									}
