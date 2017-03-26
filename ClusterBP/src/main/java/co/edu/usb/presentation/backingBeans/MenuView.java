package co.edu.usb.presentation.backingBeans;

import javax.annotation.PostConstruct; 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usb.clusterbp.Usuario;
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
		
		DefaultMenuItem dashboard = new DefaultMenuItem("Dashboard");
		dashboard.setOutcome("/XHTML/dashboard.xhtml");
		dashboard.setIcon("fa fa-home");
		dashboard.setId("sm_usuario");
		dashboard.setContainerStyleClass("layout-menubar-active");
		model.addElement(dashboard);
		
		DefaultMenuItem usuarios = new DefaultMenuItem("Usuario");
		usuarios.setOutcome("/XHTML/usuario.xhtml");
		usuarios.setIcon("fa fa-users");
		usuarios.setId("sm_usuario");
		usuarios.setContainerStyleClass("layout-menubar-active");
		model.addElement(usuarios);

		DefaultMenuItem repositorios= new DefaultMenuItem("Repositorio");
		repositorios.setOutcome("/XHTML/repositorio.xhtml");
		repositorios.setIcon("fa fa-database");
		repositorios.setId("sm_repositorios");
		repositorios.setContainerStyleClass("layout-menubar-active");
		model.addElement(repositorios);

		DefaultMenuItem pn= new DefaultMenuItem("Proceso de negocio");
		pn.setOutcome("/XHTML/pn.xhtml");
		pn.setIcon("fa fa-gears");
		pn.setId("sm_pns");
		pn.setContainerStyleClass("layout-menubar-active");
		model.addElement(pn);
		
		DefaultMenuItem multimodal= new DefaultMenuItem("Búsquedas");
		multimodal.setOutcome("/XHTML/multimodal.xhtml");
		multimodal.setIcon("fa fa-search");
		multimodal.setId("sm_multimodal");
		multimodal.setContainerStyleClass("layout-menubar-active");
		model.addElement(multimodal);
		
		DefaultMenuItem clustering= new DefaultMenuItem("Clustering");
		clustering.setOutcome("/XHTML/clustering.xhtml");
		clustering.setIcon("fa fa-code");
		clustering.setId("sm_clustering");
		clustering.setContainerStyleClass("layout-menubar-active");
		model.addElement(clustering);
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