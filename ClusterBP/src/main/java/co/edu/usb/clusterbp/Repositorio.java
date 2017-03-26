package co.edu.usb.clusterbp;
// Generated 17/01/2017 09:07:37 PM by Hibernate Tools 4.3.1.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Repositorio generated by hbm2java
 */
public class Repositorio  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long repositorioCodigo;
     private String nombre;
     private String descripcion;
     private Long usuCreador;
     private Date fechaCreacion;
     private Long usuModificador;
     private Date fechaModificacion;
     private String activo;
     private Set<RepositorioPn> repositorioPns = new HashSet<RepositorioPn>(0);

    public Repositorio() {
    }

	
    public Repositorio(Long repositorioCodigo, String nombre, String descripcion, Long usuCreador, Date fechaCreacion, String activo) {
        this.repositorioCodigo = repositorioCodigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuCreador = usuCreador;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }
    public Repositorio(Long repositorioCodigo, String nombre, String descripcion, Long usuCreador, Date fechaCreacion, Long usuModificador, Date fechaModificacion, String activo, Set<RepositorioPn> repositorioPns) {
       this.repositorioCodigo = repositorioCodigo;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.usuCreador = usuCreador;
       this.fechaCreacion = fechaCreacion;
       this.usuModificador = usuModificador;
       this.fechaModificacion = fechaModificacion;
       this.activo = activo;
       this.repositorioPns = repositorioPns;
    }
   
    public Long getRepositorioCodigo() {
        return this.repositorioCodigo;
    }
    
    public void setRepositorioCodigo(Long repositorioCodigo) {
        this.repositorioCodigo = repositorioCodigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public Long getUsuModificador() {
        return this.usuModificador;
    }
    
    public void setUsuModificador(Long usuModificador) {
        this.usuModificador = usuModificador;
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
    public Set<RepositorioPn> getRepositorioPns() {
        return this.repositorioPns;
    }
    
    public void setRepositorioPns(Set<RepositorioPn> repositorioPns) {
        this.repositorioPns = repositorioPns;
    }
}


