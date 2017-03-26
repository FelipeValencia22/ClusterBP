package co.edu.usb.clusterbp.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(UsuarioDTO.class);
    private String activo;
    private String clave;
    private String correo;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String nombre;
    private Long usuCreador;
    private Long usuaModificador;
    private Long usuarioCodigo;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getUsuCreador() {
        return usuCreador;
    }

    public void setUsuCreador(Long usuCreador) {
        this.usuCreador = usuCreador;
    }

    public Long getUsuaModificador() {
        return usuaModificador;
    }

    public void setUsuaModificador(Long usuaModificador) {
        this.usuaModificador = usuaModificador;
    }

    public Long getUsuarioCodigo() {
        return usuarioCodigo;
    }

    public void setUsuarioCodigo(Long usuarioCodigo) {
        this.usuarioCodigo = usuarioCodigo;
    }
}
