package co.edu.usb.presentation.businessDelegate;

import co.edu.usb.clusterbp.Grupo;
import co.edu.usb.clusterbp.GrupoRepositorio;
import co.edu.usb.clusterbp.GrupoUsuario;
import co.edu.usb.clusterbp.Historial;
import co.edu.usb.clusterbp.LogBusqueda;
import co.edu.usb.clusterbp.ModeloBusqueda;
import co.edu.usb.clusterbp.Plugin;
import co.edu.usb.clusterbp.PluginModeloBusqueda;
import co.edu.usb.clusterbp.Pn;
import co.edu.usb.clusterbp.Repositorio;
import co.edu.usb.clusterbp.RepositorioPlugin;
import co.edu.usb.clusterbp.RepositorioPn;
import co.edu.usb.clusterbp.Rol;
import co.edu.usb.clusterbp.TipoArchivoPn;
import co.edu.usb.clusterbp.Usuario;
import co.edu.usb.clusterbp.UsuarioRol;
import co.edu.usb.clusterbp.VersionRep;
import co.edu.usb.clusterbp.control.GrupoLogic;
import co.edu.usb.clusterbp.control.GrupoRepositorioLogic;
import co.edu.usb.clusterbp.control.GrupoUsuarioLogic;
import co.edu.usb.clusterbp.control.HistorialLogic;
import co.edu.usb.clusterbp.control.IGrupoLogic;
import co.edu.usb.clusterbp.control.IGrupoRepositorioLogic;
import co.edu.usb.clusterbp.control.IGrupoUsuarioLogic;
import co.edu.usb.clusterbp.control.IHistorialLogic;
import co.edu.usb.clusterbp.control.ILogBusquedaLogic;
import co.edu.usb.clusterbp.control.IModeloBusquedaLogic;
import co.edu.usb.clusterbp.control.IPluginLogic;
import co.edu.usb.clusterbp.control.IPluginModeloBusquedaLogic;
import co.edu.usb.clusterbp.control.IPnLogic;
import co.edu.usb.clusterbp.control.IRepositorioLogic;
import co.edu.usb.clusterbp.control.IRepositorioPluginLogic;
import co.edu.usb.clusterbp.control.IRepositorioPnLogic;
import co.edu.usb.clusterbp.control.IRolLogic;
import co.edu.usb.clusterbp.control.ITipoArchivoPnLogic;
import co.edu.usb.clusterbp.control.IUsuarioLogic;
import co.edu.usb.clusterbp.control.IUsuarioRolLogic;
import co.edu.usb.clusterbp.control.IVersionRepLogic;
import co.edu.usb.clusterbp.control.LogBusquedaLogic;
import co.edu.usb.clusterbp.control.ModeloBusquedaLogic;
import co.edu.usb.clusterbp.control.PluginLogic;
import co.edu.usb.clusterbp.control.PluginModeloBusquedaLogic;
import co.edu.usb.clusterbp.control.PnLogic;
import co.edu.usb.clusterbp.control.RepositorioLogic;
import co.edu.usb.clusterbp.control.RepositorioPluginLogic;
import co.edu.usb.clusterbp.control.RepositorioPnLogic;
import co.edu.usb.clusterbp.control.RolLogic;
import co.edu.usb.clusterbp.control.TipoArchivoPnLogic;
import co.edu.usb.clusterbp.control.UsuarioLogic;
import co.edu.usb.clusterbp.control.UsuarioRolLogic;
import co.edu.usb.clusterbp.control.VersionRepLogic;
import co.edu.usb.clusterbp.dto.GrupoDTO;
import co.edu.usb.clusterbp.dto.GrupoRepositorioDTO;
import co.edu.usb.clusterbp.dto.GrupoUsuarioDTO;
import co.edu.usb.clusterbp.dto.HistorialDTO;
import co.edu.usb.clusterbp.dto.LogBusquedaDTO;
import co.edu.usb.clusterbp.dto.ModeloBusquedaDTO;
import co.edu.usb.clusterbp.dto.PluginDTO;
import co.edu.usb.clusterbp.dto.PluginModeloBusquedaDTO;
import co.edu.usb.clusterbp.dto.PnDTO;
import co.edu.usb.clusterbp.dto.RepositorioDTO;
import co.edu.usb.clusterbp.dto.RepositorioPluginDTO;
import co.edu.usb.clusterbp.dto.RepositorioPnDTO;
import co.edu.usb.clusterbp.dto.RolDTO;
import co.edu.usb.clusterbp.dto.TipoArchivoPnDTO;
import co.edu.usb.clusterbp.dto.UsuarioDTO;
import co.edu.usb.clusterbp.dto.UsuarioRolDTO;
import co.edu.usb.clusterbp.dto.VersionRepDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Grupo> getGrupo() throws Exception;

    public void saveGrupo(Grupo entity) throws Exception;

    public void deleteGrupo(Grupo entity) throws Exception;

    public void updateGrupo(Grupo entity) throws Exception;

    public Grupo getGrupo(Long grupoCodigo) throws Exception;

    public List<Grupo> findByCriteriaInGrupo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Grupo> findPageGrupo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGrupo() throws Exception;

    public List<GrupoDTO> getDataGrupo() throws Exception;
    
    public List<GrupoDTO> getDataGrupoI() throws Exception;

    public List<GrupoRepositorio> getGrupoRepositorio()
        throws Exception;

    public void saveGrupoRepositorio(GrupoRepositorio entity)
        throws Exception;

    public void deleteGrupoRepositorio(GrupoRepositorio entity)
        throws Exception;

    public void updateGrupoRepositorio(GrupoRepositorio entity)
        throws Exception;

    public GrupoRepositorio getGrupoRepositorio(Long grupoRepositorioCodigo)
        throws Exception;

    public List<GrupoRepositorio> findByCriteriaInGrupoRepositorio(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<GrupoRepositorio> findPageGrupoRepositorio(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberGrupoRepositorio() throws Exception;

    public List<GrupoRepositorioDTO> getDataGrupoRepositorio()
        throws Exception;

    public List<GrupoUsuario> getGrupoUsuario() throws Exception;

    public void saveGrupoUsuario(GrupoUsuario entity) throws Exception;

    public void deleteGrupoUsuario(GrupoUsuario entity)
        throws Exception;

    public void updateGrupoUsuario(GrupoUsuario entity)
        throws Exception;

    public GrupoUsuario getGrupoUsuario(Long grupoUsuarioCodigo)
        throws Exception;

    public List<GrupoUsuario> findByCriteriaInGrupoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<GrupoUsuario> findPageGrupoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberGrupoUsuario() throws Exception;

    public List<GrupoUsuarioDTO> getDataGrupoUsuario() throws Exception;
    
    public List<GrupoUsuarioDTO> getDataGrupoUsuarioI() throws Exception; 

    public List<Historial> getHistorial() throws Exception;

    public void saveHistorial(Historial entity) throws Exception;

    public void deleteHistorial(Historial entity) throws Exception;

    public void updateHistorial(Historial entity) throws Exception;

    public Historial getHistorial(Long historialCodigo)
        throws Exception;

    public List<Historial> findByCriteriaInHistorial(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Historial> findPageHistorial(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberHistorial() throws Exception;

    public List<HistorialDTO> getDataHistorial() throws Exception;

    public List<LogBusqueda> getLogBusqueda() throws Exception;

    public void saveLogBusqueda(LogBusqueda entity) throws Exception;

    public void deleteLogBusqueda(LogBusqueda entity) throws Exception;

    public void updateLogBusqueda(LogBusqueda entity) throws Exception;

    public LogBusqueda getLogBusqueda(Long logBusquedaCodigo)
        throws Exception;

    public List<LogBusqueda> findByCriteriaInLogBusqueda(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<LogBusqueda> findPageLogBusqueda(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberLogBusqueda() throws Exception;

    public List<LogBusquedaDTO> getDataLogBusqueda() throws Exception;

    public List<ModeloBusqueda> getModeloBusqueda() throws Exception;

    public void saveModeloBusqueda(ModeloBusqueda entity)
        throws Exception;

    public void deleteModeloBusqueda(ModeloBusqueda entity)
        throws Exception;

    public void updateModeloBusqueda(ModeloBusqueda entity)
        throws Exception;

    public ModeloBusqueda getModeloBusqueda(Long modeloBusquedaCodigo)
        throws Exception;

    public List<ModeloBusqueda> findByCriteriaInModeloBusqueda(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<ModeloBusqueda> findPageModeloBusqueda(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberModeloBusqueda() throws Exception;

    public List<ModeloBusquedaDTO> getDataModeloBusqueda()
        throws Exception;

    public List<Plugin> getPlugin() throws Exception;

    public void savePlugin(Plugin entity) throws Exception;

    public void deletePlugin(Plugin entity) throws Exception;

    public void updatePlugin(Plugin entity) throws Exception;

    public Plugin getPlugin(Long pluginCodigo) throws Exception;

    public List<Plugin> findByCriteriaInPlugin(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Plugin> findPagePlugin(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPlugin() throws Exception;

    public List<PluginDTO> getDataPlugin() throws Exception;

    public List<PluginModeloBusqueda> getPluginModeloBusqueda()
        throws Exception;

    public void savePluginModeloBusqueda(PluginModeloBusqueda entity)
        throws Exception;

    public void deletePluginModeloBusqueda(PluginModeloBusqueda entity)
        throws Exception;

    public void updatePluginModeloBusqueda(PluginModeloBusqueda entity)
        throws Exception;

    public PluginModeloBusqueda getPluginModeloBusqueda(
        Long pluginModeloBusquedaCodigo) throws Exception;

    public List<PluginModeloBusqueda> findByCriteriaInPluginModeloBusqueda(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<PluginModeloBusqueda> findPagePluginModeloBusqueda(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPluginModeloBusqueda() throws Exception;

    public List<PluginModeloBusquedaDTO> getDataPluginModeloBusqueda()
        throws Exception;

    public List<Pn> getPn() throws Exception;

    public void savePn(Pn entity) throws Exception;

    public void deletePn(Pn entity) throws Exception;

    public void updatePn(Pn entity) throws Exception;

    public Pn getPn(Long pnCodigo) throws Exception;

    public List<Pn> findByCriteriaInPn(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Pn> findPagePn(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberPn() throws Exception;

    public List<PnDTO> getDataPn() throws Exception;

    public List<Repositorio> getRepositorio() throws Exception;

    public void saveRepositorio(Repositorio entity) throws Exception;

    public void deleteRepositorio(Repositorio entity) throws Exception;

    public void updateRepositorio(Repositorio entity) throws Exception;

    public Repositorio getRepositorio(Long repositorioCodigo)
        throws Exception;

    public List<Repositorio> findByCriteriaInRepositorio(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Repositorio> findPageRepositorio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRepositorio() throws Exception;

    public List<RepositorioDTO> getDataRepositorio() throws Exception;
    
    public List<RepositorioDTO> getDataRepositorioI() throws Exception;


    public List<RepositorioPlugin> getRepositorioPlugin()
        throws Exception;

    public void saveRepositorioPlugin(RepositorioPlugin entity)
        throws Exception;

    public void deleteRepositorioPlugin(RepositorioPlugin entity)
        throws Exception;

    public void updateRepositorioPlugin(RepositorioPlugin entity)
        throws Exception;

    public RepositorioPlugin getRepositorioPlugin(Long repositorioPluginCodigo)
        throws Exception;

    public List<RepositorioPlugin> findByCriteriaInRepositorioPlugin(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<RepositorioPlugin> findPageRepositorioPlugin(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberRepositorioPlugin() throws Exception;

    public List<RepositorioPluginDTO> getDataRepositorioPlugin()
        throws Exception;

    public List<RepositorioPn> getRepositorioPn() throws Exception;

    public void saveRepositorioPn(RepositorioPn entity)
        throws Exception;

    public void deleteRepositorioPn(RepositorioPn entity)
        throws Exception;

    public void updateRepositorioPn(RepositorioPn entity)
        throws Exception;

    public RepositorioPn getRepositorioPn(Long repositorioPnCodigo)
        throws Exception;

    public List<RepositorioPn> findByCriteriaInRepositorioPn(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<RepositorioPn> findPageRepositorioPn(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRepositorioPn() throws Exception;

    public List<RepositorioPnDTO> getDataRepositorioPn()
        throws Exception;

    public List<Rol> getRol() throws Exception;

    public void saveRol(Rol entity) throws Exception;

    public void deleteRol(Rol entity) throws Exception;

    public void updateRol(Rol entity) throws Exception;

    public Rol getRol(Long rolCodigo) throws Exception;

    public List<Rol> findByCriteriaInRol(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Rol> findPageRol(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberRol() throws Exception;

    public List<RolDTO> getDataRol() throws Exception;

    public List<TipoArchivoPn> getTipoArchivoPn() throws Exception;

    public void saveTipoArchivoPn(TipoArchivoPn entity)
        throws Exception;

    public void deleteTipoArchivoPn(TipoArchivoPn entity)
        throws Exception;

    public void updateTipoArchivoPn(TipoArchivoPn entity)
        throws Exception;

    public TipoArchivoPn getTipoArchivoPn(Long tipoArchivoPnCodigo)
        throws Exception;

    public List<TipoArchivoPn> findByCriteriaInTipoArchivoPn(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoArchivoPn> findPageTipoArchivoPn(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoArchivoPn() throws Exception;

    public List<TipoArchivoPnDTO> getDataTipoArchivoPn()
        throws Exception;

    public List<Usuario> getUsuario() throws Exception;

    public void saveUsuario(Usuario entity) throws Exception;

    public void deleteUsuario(Usuario entity) throws Exception;

    public void updateUsuario(Usuario entity) throws Exception;

    public Usuario getUsuario(Long usuarioCodigo) throws Exception;

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuario() throws Exception;

    public List<UsuarioDTO> getDataUsuario() throws Exception;

    public List<UsuarioRol> getUsuarioRol() throws Exception;

    public void saveUsuarioRol(UsuarioRol entity) throws Exception;

    public void deleteUsuarioRol(UsuarioRol entity) throws Exception;

    public void updateUsuarioRol(UsuarioRol entity) throws Exception;

    public UsuarioRol getUsuarioRol(Long usuarioRolCodigo)
        throws Exception;

    public List<UsuarioRol> findByCriteriaInUsuarioRol(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<UsuarioRol> findPageUsuarioRol(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuarioRol() throws Exception;

    public List<UsuarioRolDTO> getDataUsuarioRol() throws Exception;

    public List<VersionRep> getVersionRep() throws Exception;

    public void saveVersionRep(VersionRep entity) throws Exception;

    public void deleteVersionRep(VersionRep entity) throws Exception;

    public void updateVersionRep(VersionRep entity) throws Exception;

    public VersionRep getVersionRep(Long versionRepCodigo)
        throws Exception;

    public List<VersionRep> findByCriteriaInVersionRep(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<VersionRep> findPageVersionRep(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVersionRep() throws Exception;

    public List<VersionRepDTO> getDataVersionRep() throws Exception;
    
    
    //TODO: Metodos
    public Usuario autenticarUsuario(String correo, String clave) throws Exception;
    
    public List<UsuarioDTO> getDataVtUsuario() throws Exception;
    
    public List<UsuarioDTO> getDataVtUsuarioI() throws Exception;
    
    //TODO: Consultas
    public Usuario consultarUsuarioPorCorreo(String correo);
    
    public String consultarRolUsuarioPorCorreo(String correo);
    
    public Usuario correoDisponible(String correo);
    
    public Rol consultarIdRolPorNombre(String nombre);
    
    public String consultarGrupoPorNombre (String nombre);
    
    public Usuario consultarUsuarioPorID(Long usuarioCodigo);
}
