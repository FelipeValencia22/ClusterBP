package co.edu.usb.presentation.backingBeans;

import java.util.List;

import javax.annotation.PostConstruct; 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.push.annotation.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usb.clusterbp.PnTxt;
import co.edu.usb.clusterbp.Rol;
import co.edu.usb.clusterbp.Usuario;
import co.edu.usb.clusterbp.UsuarioRol;
import co.edu.usb.presentation.backingBeans.DashboardView;
import co.edu.usb.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usb.utilities.FacesUtils;

@ViewScoped
@ManagedBean(name = "dashboardView")
public class DashboardView {
	private static final Logger log = LoggerFactory.getLogger(DashboardView.class);
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

}