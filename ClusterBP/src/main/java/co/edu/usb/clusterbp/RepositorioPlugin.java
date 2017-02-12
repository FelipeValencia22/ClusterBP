package co.edu.usb.clusterbp;
// Generated 17/01/2017 09:07:37 PM by Hibernate Tools 4.3.1.Final


import java.util.Date;

/**
 * RepositorioPlugin generated by hbm2java
 */
public class RepositorioPlugin  implements java.io.Serializable {


     private Long repositorioPluginCodigo;
     private Plugin plugin;
     private Repositorio repositorio;
     private Long usuCreador;
     private Date fechaCreacion;
     private String activo;
     private Long usuModificador;
     private Date fechaModificacion;

    public RepositorioPlugin() {
    }

	
    public RepositorioPlugin(Long repositorioPluginCodigo, Plugin plugin, Repositorio repositorio, Long usuCreador, Date fechaCreacion, String activo) {
        this.repositorioPluginCodigo = repositorioPluginCodigo;
        this.plugin = plugin;
        this.repositorio = repositorio;
        this.usuCreador = usuCreador;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }
    public RepositorioPlugin(Long repositorioPluginCodigo, Plugin plugin, Repositorio repositorio, Long usuCreador, Date fechaCreacion, String activo, Long usuModificador, Date fechaModificacion) {
       this.repositorioPluginCodigo = repositorioPluginCodigo;
       this.plugin = plugin;
       this.repositorio = repositorio;
       this.usuCreador = usuCreador;
       this.fechaCreacion = fechaCreacion;
       this.activo = activo;
       this.usuModificador = usuModificador;
       this.fechaModificacion = fechaModificacion;
    }
   
    public Long getRepositorioPluginCodigo() {
        return this.repositorioPluginCodigo;
    }
    
    public void setRepositorioPluginCodigo(Long repositorioPluginCodigo) {
        this.repositorioPluginCodigo = repositorioPluginCodigo;
    }
    public Plugin getPlugin() {
        return this.plugin;
    }
    
    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
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
    public String getActivo() {
        return this.activo;
    }
    
    public void setActivo(String activo) {
        this.activo = activo;
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




}


