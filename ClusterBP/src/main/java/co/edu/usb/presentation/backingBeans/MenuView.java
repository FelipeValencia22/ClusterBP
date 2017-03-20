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
import co.edu.usb.presentation.backingBeans.MenuView;
import co.edu.usb.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usb.utilities.FacesUtils;

@ViewScoped
@ManagedBean(name = "menuView")
public class MenuView {
	private static final Logger log = LoggerFactory.getLogger(MenuView.class);
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	private MenuModel model;
	private final Usuario usuarioEnSesion= (Usuario) FacesUtils.getfromSession("usuario");

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();

		try{
			String rolUsuario=businessDelegatorView.consultarRolUsuarioPorCorreo(usuarioEnSesion.getCorreo().toString());

			if(rolUsuario.equals("Admin")){
				crearMenuAdmin();
			}else{
				log.info("CrearMenuUsuario");
				crearMenuSinRol();
			}

		}catch(Exception e){
			e.printStackTrace();
			log.error(e.toString());
			log.error(e.getMessage());
		}
	}

	public void crearMenuAdmin(){
		DefaultMenuItem usuarios = new DefaultMenuItem("Usuario");
		usuarios.setOutcome("/XHTML/usuario.xhtml");
		usuarios.setIcon("icon-home-outline");
		usuarios.setId("sm_usuario");
		usuarios.setContainerStyleClass("layout-menubar-active");
		model.addElement(usuarios);

		DefaultMenuItem repositorios= new DefaultMenuItem("Repositorio");
		repositorios.setOutcome("/XHTML/repositorio.xhtml");
		repositorios.setIcon("icon-home-outline");
		repositorios.setId("sm_repositorios");
		repositorios.setContainerStyleClass("layout-menubar-active");
		model.addElement(repositorios);

		DefaultMenuItem pn= new DefaultMenuItem("Proceso de negocio");
		pn.setOutcome("/XHTML/pn.xhtml");
		pn.setIcon("icon-home-outline");
		pn.setId("sm_pns");
		pn.setContainerStyleClass("layout-menubar-active");
		model.addElement(pn);
		
		DefaultMenuItem multimodal= new DefaultMenuItem("Búsqueda Multimodal");
		multimodal.setOutcome("/XHTML/multimodal.xhtml");
		multimodal.setIcon("icon-home-outline");
		multimodal.setId("sm_multimodal");
		multimodal.setContainerStyleClass("layout-menubar-active");
		model.addElement(multimodal);
	}

	public void crearMenuSinRol(){
		DefaultMenuItem sinRol = new DefaultMenuItem("");
		sinRol.setOutcome("/XHTML/404.xhtml");
		sinRol.setIcon("icon-home-outline");
		sinRol.setId("sm_access_denied");
		sinRol.setContainerStyleClass("layout-menubar-active");
		model.addElement(sinRol);	
	}




}