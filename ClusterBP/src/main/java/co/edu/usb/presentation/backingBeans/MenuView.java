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
			
			log.info("rolUsuario:"+rolUsuario);
			
			if(rolUsuario.equals("Admin")){
				log.info("CrearMenuAdmin");
				crearMenuAdmin();
			}else{
				log.info("CrearMenuUsuario");
				crearMenuUsuario();
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
			
		DefaultMenuItem grupos= new DefaultMenuItem("Grupo");
		grupos.setOutcome("/XHTML/grupo.xhtml");
		grupos.setIcon("icon-home-outline");
		grupos.setId("sm_grupos");
		grupos.setContainerStyleClass("layout-menubar-active");
		model.addElement(grupos);
		
		DefaultMenuItem repositorios= new DefaultMenuItem("Repositorio");
		repositorios.setOutcome("/XHTML/repositorio.xhtml");
		repositorios.setIcon("icon-home-outline");
		repositorios.setId("sm_repositorios");
		repositorios.setContainerStyleClass("layout-menubar-active");
		model.addElement(repositorios);
		
		DefaultMenuItem plugins= new DefaultMenuItem("PlugIn");
		plugins.setOutcome("/XHTML/plugin.xhtml");
		plugins.setIcon("icon-home-outline");
		plugins.setId("sm_plugins");
		plugins.setContainerStyleClass("layout-menubar-active");
		model.addElement(plugins);
	}
	
	public void crearMenuUsuario(){
		DefaultMenuItem charts = new DefaultMenuItem("Charts");
		charts.setOutcome("/XHTML/dashboard.xhtml");
		charts.setIcon("icon-home-outline");
		charts.setId("sm_charts");
		charts.setContainerStyleClass("layout-menubar-active");
		model.addElement(charts);	
	}
	
	public void crearMenuSinRol(){
		DefaultMenuItem sinRol = new DefaultMenuItem("");
		sinRol.setOutcome("/XHTML/access-denied.xhtml");
		sinRol.setIcon("icon-home-outline");
		sinRol.setId("sm_access_denied");
		sinRol.setContainerStyleClass("layout-menubar-active");
		model.addElement(sinRol);	
	}
	
	
	

}