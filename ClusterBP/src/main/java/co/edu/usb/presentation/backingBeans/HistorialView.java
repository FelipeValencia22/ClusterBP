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
import co.edu.usb.clusterbp.dto.HistorialDTO;
import co.edu.usb.presentation.businessDelegate.*;
import co.edu.usb.utilities.*;
/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 * 
 */
 

@ManagedBean
@ViewScoped
public class HistorialView implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(HistorialView.class);

public HistorialView() {
super();
}
    private InputText txtActivo;
    private InputText txtArchivo;
    private InputText txtDescripcion;
    private InputText txtTitulo;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtPnCodigo_Pn;
    private InputText txtHistorialCodigo;
            private Calendar txtFechaCreacion;
            private Calendar txtFechaModificacion;
    private CommandButton btnSave;
private CommandButton btnModify;
private CommandButton btnDelete;
private CommandButton btnClear;
private List<HistorialDTO> data;
private HistorialDTO selectedHistorial;
private Historial entity;
private boolean showDialog;
    
@ManagedProperty(value="#{BusinessDelegatorView}")
private IBusinessDelegatorView businessDelegatorView;


	      public void rowEventListener(RowEditEvent e){
			try {
			
			HistorialDTO historialDTO = (HistorialDTO) e.getObject(); 
			
							if(txtActivo == null){
					txtActivo = new InputText ();
				}
				txtActivo.setValue(historialDTO.getActivo());
								if(txtArchivo == null){
					txtArchivo = new InputText ();
				}
				txtArchivo.setValue(historialDTO.getArchivo());
								if(txtDescripcion == null){
					txtDescripcion = new InputText ();
				}
				txtDescripcion.setValue(historialDTO.getDescripcion());
								if(txtTitulo == null){
					txtTitulo = new InputText ();
				}
				txtTitulo.setValue(historialDTO.getTitulo());
								if(txtUsuCreador == null){
					txtUsuCreador = new InputText ();
				}
				txtUsuCreador.setValue(historialDTO.getUsuCreador());
								if(txtUsuModificador == null){
					txtUsuModificador = new InputText ();
				}
				txtUsuModificador.setValue(historialDTO.getUsuModificador());
								if(txtPnCodigo_Pn == null){
					txtPnCodigo_Pn = new InputText ();
				}
				txtPnCodigo_Pn.setValue(historialDTO.getPnCodigo_Pn());
											if(txtHistorialCodigo == null){
					txtHistorialCodigo = new InputText ();
				}
				txtHistorialCodigo.setValue(historialDTO.getHistorialCodigo());
														if(txtFechaCreacion == null){
					txtFechaCreacion = new Calendar ();
				}
				txtFechaCreacion.setValue(historialDTO.getFechaCreacion());
								if(txtFechaModificacion == null){
					txtFechaModificacion = new Calendar ();
				}
				txtFechaModificacion.setValue(historialDTO.getFechaModificacion());
										
						
					        Long historialCodigo = FacesUtils.checkLong(txtHistorialCodigo);
		    			entity = businessDelegatorView.getHistorial(historialCodigo);
			
			action_modify();
			
			}catch (Exception ex) {
			
			}
		
		}
		
	public String action_new(){
		action_clear();
		selectedHistorial = null;
		setShowDialog(true);
		return "";
	}

	public String action_clear() {
		
		entity = null;
		selectedHistorial = null;
		
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
                    if(txtPnCodigo_Pn != null){
			 txtPnCodigo_Pn.setValue(null);
             txtPnCodigo_Pn.setDisabled(true);
			}
                                            if(txtFechaCreacion != null){
				  txtFechaCreacion.setValue(null);
                  txtFechaCreacion.setDisabled(true);
				}
                            if(txtFechaModificacion != null){
				  txtFechaModificacion.setValue(null);
                  txtFechaModificacion.setDisabled(true);
				}
                            			    if(txtHistorialCodigo != null){
				   txtHistorialCodigo.setValue(null);
				   txtHistorialCodigo.setDisabled(false);	
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
	    	        Long historialCodigo = FacesUtils.checkLong(txtHistorialCodigo);
	    	    	entity = historialCodigo != null ? businessDelegatorView.getHistorial(historialCodigo) : null;
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
	    	        txtPnCodigo_Pn.setDisabled(false);
	    	    	        	            txtFechaCreacion.setDisabled(false);
	        	            txtFechaModificacion.setDisabled(false);
	        	    	    	        txtHistorialCodigo.setDisabled(false);
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
		    		        txtPnCodigo_Pn.setValue(entity.getPn().getPnCodigo());txtPnCodigo_Pn.setDisabled(false);
		    		    		        txtHistorialCodigo.setValue(entity.getHistorialCodigo());txtHistorialCodigo.setDisabled(true);
		    		    btnSave.setDisabled(false);
		    if(btnDelete!=null){
		    	btnDelete.setDisabled(false);
		    }
	    }
    }
        
	public String action_edit(ActionEvent evt){
    	
    	selectedHistorial = (HistorialDTO)(evt.getComponent().getAttributes().get("selectedHistorial"));		
            txtActivo.setValue(selectedHistorial.getActivo());txtActivo.setDisabled(false);
            txtArchivo.setValue(selectedHistorial.getArchivo());txtArchivo.setDisabled(false);
            txtDescripcion.setValue(selectedHistorial.getDescripcion());txtDescripcion.setDisabled(false);
            txtFechaCreacion.setValue(selectedHistorial.getFechaCreacion());txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(selectedHistorial.getFechaModificacion());txtFechaModificacion.setDisabled(false);
            txtTitulo.setValue(selectedHistorial.getTitulo());txtTitulo.setDisabled(false);
            txtUsuCreador.setValue(selectedHistorial.getUsuCreador());txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(selectedHistorial.getUsuModificador());txtUsuModificador.setDisabled(false);
            txtPnCodigo_Pn.setValue(selectedHistorial.getPnCodigo_Pn());txtPnCodigo_Pn.setDisabled(false);
                txtHistorialCodigo.setValue(selectedHistorial.getHistorialCodigo());txtHistorialCodigo.setDisabled(true);
            btnSave.setDisabled(false);
    	setShowDialog(true);

    	return "";
    }
    
    public String action_save(){    	
        try {        	
        	if(selectedHistorial == null && entity==null){
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
        	entity = new Historial();

	    	        Long historialCodigo = FacesUtils.checkLong(txtHistorialCodigo);
	    
                        entity.setActivo(FacesUtils.checkString(txtActivo));
                             
                                entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
                                entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
                                entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
                                            	            		entity.setHistorialCodigo(historialCodigo);
            	                                            entity.setTitulo(FacesUtils.checkString(txtTitulo));
                                            	            		entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
            	                                                        	            		entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
            	                                        entity.setPn(FacesUtils.checkLong(txtPnCodigo_Pn) != null ? businessDelegatorView.getPn(FacesUtils.checkLong(txtPnCodigo_Pn)) : null );
        	        businessDelegatorView.saveHistorial(entity);
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
		    		        Long historialCodigo = new Long(selectedHistorial.getHistorialCodigo());
		    	    		entity = businessDelegatorView.getHistorial(historialCodigo);
    		}
    		
        	    		entity.setActivo(FacesUtils.checkString(txtActivo));
    	        	    		entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
    	        	    		entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
    	        	    		entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
    	        	        	    		entity.setTitulo(FacesUtils.checkString(txtTitulo));
    	        	    		entity.setUsuCreador(FacesUtils.checkLong(txtUsuCreador));
    	        	    		entity.setUsuModificador(FacesUtils.checkLong(txtUsuModificador));
    	    	    	        entity.setPn(FacesUtils.checkLong(txtPnCodigo_Pn) != null ? businessDelegatorView.getPn(FacesUtils.checkLong(txtPnCodigo_Pn)) : null );
	        	        businessDelegatorView.updateHistorial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
		   data=null;
           FacesUtils.addErrorMessage(e.getMessage());
        }
        return "";
	}
	
	public String action_delete_datatable(ActionEvent evt){
		try{
        	selectedHistorial = (HistorialDTO)(evt.getComponent().getAttributes().get("selectedHistorial"));
    						Long historialCodigo = new Long(selectedHistorial.getHistorialCodigo());
						entity = businessDelegatorView.getHistorial(historialCodigo);
        	action_delete();
        }catch(Exception e ){
		 FacesUtils.addErrorMessage(e.getMessage());
		}    
        return "";
    }
	
	public String action_delete_master(){
		try{
					        Long historialCodigo = FacesUtils.checkLong(txtHistorialCodigo);
		    		    entity = businessDelegatorView.getHistorial(historialCodigo);
        	action_delete();
        }catch(Exception e ){
		 FacesUtils.addErrorMessage(e.getMessage());
		}    
        return "";
    }
    
	public void action_delete() throws Exception{
		try{
			businessDelegatorView.deleteHistorial(entity);
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
			selectedHistorial = (HistorialDTO)(evt.getComponent().getAttributes().get("selectedHistorial"));		
	    	        Long historialCodigo = new Long(selectedHistorial.getHistorialCodigo());
	        		entity = businessDelegatorView.getHistorial(historialCodigo);
			businessDelegatorView.deleteHistorial(entity);
			data.remove(selectedHistorial);
    		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
		}catch(Exception e ){
		 FacesUtils.addErrorMessage(e.getMessage());
		}  
		
		return "";
	}
		
        public String action_modifyWitDTO(String activo, String descripcion, Date fechaCreacion, Date fechaModificacion, Long historialCodigo, String titulo, Long usuCreador, Long usuModificador, Long pnCodigo_Pn) throws Exception {
        try {
        
        	    		entity.setActivo(FacesUtils.checkString(activo));
    	        	    		entity.setDescripcion(FacesUtils.checkString(descripcion));
    	        	    		entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
    	        	    		entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
    	        	        	    		entity.setTitulo(FacesUtils.checkString(titulo));
    	        	    		entity.setUsuCreador(FacesUtils.checkLong(usuCreador));
    	        	    		entity.setUsuModificador(FacesUtils.checkLong(usuModificador));
    	            businessDelegatorView.updateHistorial(entity);
		FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
        //renderManager.getOnDemandRenderer("HistorialView").requestRender();
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
                                                                                            public InputText getTxtPnCodigo_Pn() {
                                                return txtPnCodigo_Pn;
                                                }
                                                public void setTxtPnCodigo_Pn(InputText txtPnCodigo_Pn) {
                                                this.txtPnCodigo_Pn = txtPnCodigo_Pn;
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
                                                                                                                                                                                        public InputText getTxtHistorialCodigo() {
                                                return txtHistorialCodigo;
                                                }
                                                public void setTxtHistorialCodigo(InputText txtHistorialCodigo) {
                                                this.txtHistorialCodigo = txtHistorialCodigo;
                                                }
                                                                                        											
																						public List<HistorialDTO> getData() {
												try{
													if(data==null){
													data = businessDelegatorView.getDataHistorial();
													}	
												
												}catch(Exception e){
												 e.printStackTrace();
												}
												return data;
											}
																						public void setData(List<HistorialDTO> historialDTO){
												this.data=historialDTO;
											}
											
																						
											public HistorialDTO getSelectedHistorial(){
												return selectedHistorial;
											}
											
											public void setSelectedHistorial (HistorialDTO historial ){
												this.selectedHistorial = historial;
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
