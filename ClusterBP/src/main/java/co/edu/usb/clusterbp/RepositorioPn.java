package co.edu.usb.clusterbp;
// Generated 17/01/2017 09:07:37 PM by Hibernate Tools 4.3.1.Final


import java.util.Date;

/**
 * RepositorioPn generated by hbm2java
 */
public class RepositorioPn  implements java.io.Serializable {


     private Long repositorioPnCodigo;
     private Pn pn;
     private Repositorio repositorio;
     private Long usuCreador;
     private Date fechaCreacion;
     private Long usuarioModificador;
     private Date fechaModificacion;
     private String activo;

    public RepositorioPn() {
    }

	
    public RepositorioPn(Long repositorioPnCodigo, Pn pn, Repositorio repositorio, Long usuCreador, Date fechaCreacion, String activo) {
        this.repositorioPnCodigo = repositorioPnCodigo;
        this.pn = pn;
        this.repositorio = repositorio;
        this.usuCreador = usuCreador;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }
    public RepositorioPn(Long repositorioPnCodigo, Pn pn, Repositorio repositorio, Long usuCreador, Date fechaCreacion, Long usuarioModificador, Date fechaModificacion, String activo) {
       this.repositorioPnCodigo = repositorioPnCodigo;
       this.pn = pn;
       this.repositorio = repositorio;
       this.usuCreador = usuCreador;
       this.fechaCreacion = fechaCreacion;
       this.usuarioModificador = usuarioModificador;
       this.fechaModificacion = fechaModificacion;
       this.activo = activo;
    }
   
    public Long getRepositorioPnCodigo() {
        return this.repositorioPnCodigo;
    }
    
    public void setRepositorioPnCodigo(Long repositorioPnCodigo) {
        this.repositorioPnCodigo = repositorioPnCodigo;
    }
    public Pn getPn() {
        return this.pn;
    }
    
    public void setPn(Pn pn) {
        this.pn = pn;
    }
    public Repositorio getRepositorio() {
        return this.repositorio;
    }
    
    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }
    public Long getUsuCreador() {
        return this.usuCreador;
    }
    
    public void setUsuCreador(Long usuCreador) {
        this.usuCreador = usuCreador;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Long getUsuarioModificador() {
        return this.usuarioModificador;
    }
    
    public void setUsuarioModificador(Long usuarioModificador) {
        this.usuarioModificador = usuarioModificador;
    }
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public String getActivo() {
        return this.activo;
    }
    
    public void setActivo(String activo) {
        this.activo = activo;
    }




}


