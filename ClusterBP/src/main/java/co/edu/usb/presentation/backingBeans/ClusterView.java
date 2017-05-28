package co.edu.usb.presentation.backingBeans;

import co.edu.usb.presentation.businessDelegate.*;
import co.edu.usb.utilities.FacesUtils;
import co.edu.usb.utilities.Utilities;

import org.primefaces.component.inputtext.InputText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */

@ViewScoped
@ManagedBean(name = "clusterView")
public class ClusterView implements Serializable {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ClusterView.class);

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private InputText txtK;

	public ClusterView() {
		super();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public InputText getTxtK() {
		return txtK;
	}

	public void setTxtK(InputText txtK) {
		this.txtK = txtK;
	}

	//TODO: Metodos	
	public String clustering(){
		String clusters=txtK.getValue().toString().trim();
		if(!clusters.isEmpty()){
			if(Utilities.isNumeric(clusters)){
				int k=Integer.parseInt(clusters);
				if(k>0){
					businessDelegatorView.clustering(k);
				}else{
					FacesUtils.addErrorMessage("El número tiene que ser mayor o igual que 1");
				}
			}else{
				FacesUtils.addErrorMessage("El valor introducido no es númerico");	
			}
		}else{
			FacesUtils.addErrorMessage("Introduzca la cantidad de Clusters K");
		}
		return "";
	}

}