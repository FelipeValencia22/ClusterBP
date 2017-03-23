package co.edu.usb.presentation.backingBeans;

import co.edu.usb.utilities.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


@ViewScoped
@ManagedBean(name = "loginView")
public class LoginView {
    private String userId;
    private String password;
    @ManagedProperty(value = "#{authenticationManager}")
    private AuthenticationManager authenticationManager = null;

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(
        AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String login() {
    	String resultado="";
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(this.getUserId(),
                    this.getPassword());
            Authentication result = authenticationManager.authenticate(request);
            if(result.isAuthenticated()){
            	SecurityContext securityContext = SecurityContextHolder.getContext();
                securityContext.setAuthentication(result);
                FacesUtils.getHttpSession(true)
                          .setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
                FacesUtils.addInfoMessage("Bienvenid@!");
                resultado="/XHTML/dashboard.xhtml";
            }else{
            	FacesUtils.addErrorMessage("Usuario o contraseña inválida");
            	resultado="/login.xhtml";
            }
        } catch (AuthenticationException e) {
            
        }
        return resultado;
    }
}
