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
import co.edu.usb.clusterbp.control.ISeguridadLogica;
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
import co.edu.usb.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private IGrupoLogic grupoLogic;
    @Autowired
    private IGrupoRepositorioLogic grupoRepositorioLogic;
    @Autowired
    private IGrupoUsuarioLogic grupoUsuarioLogic;
    @Autowired
    private IHistorialLogic historialLogic;
    @Autowired
    private ILogBusquedaLogic logBusquedaLogic;
    @Autowired
    private IModeloBusquedaLogic modeloBusquedaLogic;
    @Autowired
    private IPluginLogic pluginLogic;
    @Autowired
    private IPluginModeloBusquedaLogic pluginModeloBusquedaLogic;
    @Autowired
    private IPnLogic pnLogic;
    @Autowired
    private IRepositorioLogic repositorioLogic;
    @Autowired
    private IRepositorioPluginLogic repositorioPluginLogic;
    @Autowired
    private IRepositorioPnLogic repositorioPnLogic;
    @Autowired
    private IRolLogic rolLogic;
    @Autowired
    private ITipoArchivoPnLogic tipoArchivoPnLogic;
    @Autowired
    private IUsuarioLogic usuarioLogic;
    @Autowired
    private IUsuarioRolLogic usuarioRolLogic;
    @Autowired
    private IVersionRepLogic versionRepLogic;
    @Autowired
    private ISeguridadLogica seguridadLogica;

    public List<Grupo> getGrupo() throws Exception {
        return grupoLogic.getGrupo();
    }

    public void saveGrupo(Grupo entity) throws Exception {
        grupoLogic.saveGrupo(entity);
    }

    public void deleteGrupo(Grupo entity) throws Exception {
        grupoLogic.deleteGrupo(entity);
    }

    public void updateGrupo(Grupo entity) throws Exception {
        grupoLogic.updateGrupo(entity);
    }

    public Grupo getGrupo(Long grupoCodigo) throws Exception {
        Grupo grupo = null;

        try {
            grupo = grupoLogic.getGrupo(grupoCodigo);
        } catch (Exception e) {
            throw e;
        }

        return grupo;
    }

    public List<Grupo> findByCriteriaInGrupo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return grupoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Grupo> findPageGrupo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return grupoLogic.findPageGrupo(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberGrupo() throws Exception {
        return grupoLogic.findTotalNumberGrupo();
    }

    public List<GrupoDTO> getDataGrupo() throws Exception {
        return grupoLogic.getDataGrupo();
    }

    public List<GrupoRepositorio> getGrupoRepositorio()
        throws Exception {
        return grupoRepositorioLogic.getGrupoRepositorio();
    }

    public void saveGrupoRepositorio(GrupoRepositorio entity)
        throws Exception {
        grupoRepositorioLogic.saveGrupoRepositorio(entity);
    }

    public void deleteGrupoRepositorio(GrupoRepositorio entity)
        throws Exception {
        grupoRepositorioLogic.deleteGrupoRepositorio(entity);
    }

    public void updateGrupoRepositorio(GrupoRepositorio entity)
        throws Exception {
        grupoRepositorioLogic.updateGrupoRepositorio(entity);
    }

    public GrupoRepositorio getGrupoRepositorio(Long grupoRepositorioCodigo)
        throws Exception {
        GrupoRepositorio grupoRepositorio = null;

        try {
            grupoRepositorio = grupoRepositorioLogic.getGrupoRepositorio(grupoRepositorioCodigo);
        } catch (Exception e) {
            throw e;
        }

        return grupoRepositorio;
    }

    public List<GrupoRepositorio> findByCriteriaInGrupoRepositorio(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return grupoRepositorioLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<GrupoRepositorio> findPageGrupoRepositorio(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return grupoRepositorioLogic.findPageGrupoRepositorio(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGrupoRepositorio() throws Exception {
        return grupoRepositorioLogic.findTotalNumberGrupoRepositorio();
    }

    public List<GrupoRepositorioDTO> getDataGrupoRepositorio()
        throws Exception {
        return grupoRepositorioLogic.getDataGrupoRepositorio();
    }

    public List<GrupoUsuario> getGrupoUsuario() throws Exception {
        return grupoUsuarioLogic.getGrupoUsuario();
    }

    public void saveGrupoUsuario(GrupoUsuario entity) throws Exception {
        grupoUsuarioLogic.saveGrupoUsuario(entity);
    }

    public void deleteGrupoUsuario(GrupoUsuario entity)
        throws Exception {
        grupoUsuarioLogic.deleteGrupoUsuario(entity);
    }

    public void updateGrupoUsuario(GrupoUsuario entity)
        throws Exception {
        grupoUsuarioLogic.updateGrupoUsuario(entity);
    }

    public GrupoUsuario getGrupoUsuario(Long grupoUsuarioCodigo)
        throws Exception {
        GrupoUsuario grupoUsuario = null;

        try {
            grupoUsuario = grupoUsuarioLogic.getGrupoUsuario(grupoUsuarioCodigo);
        } catch (Exception e) {
            throw e;
        }

        return grupoUsuario;
    }

    public List<GrupoUsuario> findByCriteriaInGrupoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return grupoUsuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<GrupoUsuario> findPageGrupoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return grupoUsuarioLogic.findPageGrupoUsuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberGrupoUsuario() throws Exception {
        return grupoUsuarioLogic.findTotalNumberGrupoUsuario();
    }

    public List<GrupoUsuarioDTO> getDataGrupoUsuario()
        throws Exception {
        return grupoUsuarioLogic.getDataGrupoUsuario();
    }

    public List<Historial> getHistorial() throws Exception {
        return historialLogic.getHistorial();
    }

    public void saveHistorial(Historial entity) throws Exception {
        historialLogic.saveHistorial(entity);
    }

    public void deleteHistorial(Historial entity) throws Exception {
        historialLogic.deleteHistorial(entity);
    }

    public void updateHistorial(Historial entity) throws Exception {
        historialLogic.updateHistorial(entity);
    }

    public Historial getHistorial(Long historialCodigo)
        throws Exception {
        Historial historial = null;

        try {
            historial = historialLogic.getHistorial(historialCodigo);
        } catch (Exception e) {
            throw e;
        }

        return historial;
    }

    public List<Historial> findByCriteriaInHistorial(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return historialLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Historial> findPageHistorial(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return historialLogic.findPageHistorial(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberHistorial() throws Exception {
        return historialLogic.findTotalNumberHistorial();
    }

    public List<HistorialDTO> getDataHistorial() throws Exception {
        return historialLogic.getDataHistorial();
    }

    public List<LogBusqueda> getLogBusqueda() throws Exception {
        return logBusquedaLogic.getLogBusqueda();
    }

    public void saveLogBusqueda(LogBusqueda entity) throws Exception {
        logBusquedaLogic.saveLogBusqueda(entity);
    }

    public void deleteLogBusqueda(LogBusqueda entity) throws Exception {
        logBusquedaLogic.deleteLogBusqueda(entity);
    }

    public void updateLogBusqueda(LogBusqueda entity) throws Exception {
        logBusquedaLogic.updateLogBusqueda(entity);
    }

    public LogBusqueda getLogBusqueda(Long logBusquedaCodigo)
        throws Exception {
        LogBusqueda logBusqueda = null;

        try {
            logBusqueda = logBusquedaLogic.getLogBusqueda(logBusquedaCodigo);
        } catch (Exception e) {
            throw e;
        }

        return logBusqueda;
    }

    public List<LogBusqueda> findByCriteriaInLogBusqueda(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return logBusquedaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<LogBusqueda> findPageLogBusqueda(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return logBusquedaLogic.findPageLogBusqueda(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberLogBusqueda() throws Exception {
        return logBusquedaLogic.findTotalNumberLogBusqueda();
    }

    public List<LogBusquedaDTO> getDataLogBusqueda() throws Exception {
        return logBusquedaLogic.getDataLogBusqueda();
    }

    public List<ModeloBusqueda> getModeloBusqueda() throws Exception {
        return modeloBusquedaLogic.getModeloBusqueda();
    }

    public void saveModeloBusqueda(ModeloBusqueda entity)
        throws Exception {
        modeloBusquedaLogic.saveModeloBusqueda(entity);
    }

    public void deleteModeloBusqueda(ModeloBusqueda entity)
        throws Exception {
        modeloBusquedaLogic.deleteModeloBusqueda(entity);
    }

    public void updateModeloBusqueda(ModeloBusqueda entity)
        throws Exception {
        modeloBusquedaLogic.updateModeloBusqueda(entity);
    }

    public ModeloBusqueda getModeloBusqueda(Long modeloBusquedaCodigo)
        throws Exception {
        ModeloBusqueda modeloBusqueda = null;

        try {
            modeloBusqueda = modeloBusquedaLogic.getModeloBusqueda(modeloBusquedaCodigo);
        } catch (Exception e) {
            throw e;
        }

        return modeloBusqueda;
    }

    public List<ModeloBusqueda> findByCriteriaInModeloBusqueda(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return modeloBusquedaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<ModeloBusqueda> findPageModeloBusqueda(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return modeloBusquedaLogic.findPageModeloBusqueda(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberModeloBusqueda() throws Exception {
        return modeloBusquedaLogic.findTotalNumberModeloBusqueda();
    }

    public List<ModeloBusquedaDTO> getDataModeloBusqueda()
        throws Exception {
        return modeloBusquedaLogic.getDataModeloBusqueda();
    }

    public List<Plugin> getPlugin() throws Exception {
        return pluginLogic.getPlugin();
    }

    public void savePlugin(Plugin entity) throws Exception {
        pluginLogic.savePlugin(entity);
    }

    public void deletePlugin(Plugin entity) throws Exception {
        pluginLogic.deletePlugin(entity);
    }

    public void updatePlugin(Plugin entity) throws Exception {
        pluginLogic.updatePlugin(entity);
    }

    public Plugin getPlugin(Long pluginCodigo) throws Exception {
        Plugin plugin = null;

        try {
            plugin = pluginLogic.getPlugin(pluginCodigo);
        } catch (Exception e) {
            throw e;
        }

        return plugin;
    }

    public List<Plugin> findByCriteriaInPlugin(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return pluginLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Plugin> findPagePlugin(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return pluginLogic.findPagePlugin(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberPlugin() throws Exception {
        return pluginLogic.findTotalNumberPlugin();
    }

    public List<PluginDTO> getDataPlugin() throws Exception {
        return pluginLogic.getDataPlugin();
    }

    public List<PluginModeloBusqueda> getPluginModeloBusqueda()
        throws Exception {
        return pluginModeloBusquedaLogic.getPluginModeloBusqueda();
    }

    public void savePluginModeloBusqueda(PluginModeloBusqueda entity)
        throws Exception {
        pluginModeloBusquedaLogic.savePluginModeloBusqueda(entity);
    }

    public void deletePluginModeloBusqueda(PluginModeloBusqueda entity)
        throws Exception {
        pluginModeloBusquedaLogic.deletePluginModeloBusqueda(entity);
    }

    public void updatePluginModeloBusqueda(PluginModeloBusqueda entity)
        throws Exception {
        pluginModeloBusquedaLogic.updatePluginModeloBusqueda(entity);
    }

    public PluginModeloBusqueda getPluginModeloBusqueda(
        Long pluginModeloBusquedaCodigo) throws Exception {
        PluginModeloBusqueda pluginModeloBusqueda = null;

        try {
            pluginModeloBusqueda = pluginModeloBusquedaLogic.getPluginModeloBusqueda(pluginModeloBusquedaCodigo);
        } catch (Exception e) {
            throw e;
        }

        return pluginModeloBusqueda;
    }

    public List<PluginModeloBusqueda> findByCriteriaInPluginModeloBusqueda(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return pluginModeloBusquedaLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<PluginModeloBusqueda> findPagePluginModeloBusqueda(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return pluginModeloBusquedaLogic.findPagePluginModeloBusqueda(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberPluginModeloBusqueda() throws Exception {
        return pluginModeloBusquedaLogic.findTotalNumberPluginModeloBusqueda();
    }

    public List<PluginModeloBusquedaDTO> getDataPluginModeloBusqueda()
        throws Exception {
        return pluginModeloBusquedaLogic.getDataPluginModeloBusqueda();
    }

    public List<Pn> getPn() throws Exception {
        return pnLogic.getPn();
    }

    public void savePn(Pn entity) throws Exception {
        pnLogic.savePn(entity);
    }

    public void deletePn(Pn entity) throws Exception {
        pnLogic.deletePn(entity);
    }

    public void updatePn(Pn entity) throws Exception {
        pnLogic.updatePn(entity);
    }

    public Pn getPn(Long pnCodigo) throws Exception {
        Pn pn = null;

        try {
            pn = pnLogic.getPn(pnCodigo);
        } catch (Exception e) {
            throw e;
        }

        return pn;
    }

    public List<Pn> findByCriteriaInPn(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return pnLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Pn> findPagePn(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception {
        return pnLogic.findPagePn(sortColumnName, sortAscending, startRow,
            maxResults);
    }

    public Long findTotalNumberPn() throws Exception {
        return pnLogic.findTotalNumberPn();
    }

    public List<PnDTO> getDataPn() throws Exception {
        return pnLogic.getDataPn();
    }

    public List<Repositorio> getRepositorio() throws Exception {
        return repositorioLogic.getRepositorio();
    }

    public void saveRepositorio(Repositorio entity) throws Exception {
        repositorioLogic.saveRepositorio(entity);
    }

    public void deleteRepositorio(Repositorio entity) throws Exception {
        repositorioLogic.deleteRepositorio(entity);
    }

    public void updateRepositorio(Repositorio entity) throws Exception {
        repositorioLogic.updateRepositorio(entity);
    }

    public Repositorio getRepositorio(Long repositorioCodigo)
        throws Exception {
        Repositorio repositorio = null;

        try {
            repositorio = repositorioLogic.getRepositorio(repositorioCodigo);
        } catch (Exception e) {
            throw e;
        }

        return repositorio;
    }

    public List<Repositorio> findByCriteriaInRepositorio(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return repositorioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Repositorio> findPageRepositorio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return repositorioLogic.findPageRepositorio(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberRepositorio() throws Exception {
        return repositorioLogic.findTotalNumberRepositorio();
    }

    public List<RepositorioDTO> getDataRepositorio() throws Exception {
        return repositorioLogic.getDataRepositorio();
    }

    public List<RepositorioPlugin> getRepositorioPlugin()
        throws Exception {
        return repositorioPluginLogic.getRepositorioPlugin();
    }

    public void saveRepositorioPlugin(RepositorioPlugin entity)
        throws Exception {
        repositorioPluginLogic.saveRepositorioPlugin(entity);
    }

    public void deleteRepositorioPlugin(RepositorioPlugin entity)
        throws Exception {
        repositorioPluginLogic.deleteRepositorioPlugin(entity);
    }

    public void updateRepositorioPlugin(RepositorioPlugin entity)
        throws Exception {
        repositorioPluginLogic.updateRepositorioPlugin(entity);
    }

    public RepositorioPlugin getRepositorioPlugin(Long repositorioPluginCodigo)
        throws Exception {
        RepositorioPlugin repositorioPlugin = null;

        try {
            repositorioPlugin = repositorioPluginLogic.getRepositorioPlugin(repositorioPluginCodigo);
        } catch (Exception e) {
            throw e;
        }

        return repositorioPlugin;
    }

    public List<RepositorioPlugin> findByCriteriaInRepositorioPlugin(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return repositorioPluginLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<RepositorioPlugin> findPageRepositorioPlugin(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return repositorioPluginLogic.findPageRepositorioPlugin(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberRepositorioPlugin() throws Exception {
        return repositorioPluginLogic.findTotalNumberRepositorioPlugin();
    }

    public List<RepositorioPluginDTO> getDataRepositorioPlugin()
        throws Exception {
        return repositorioPluginLogic.getDataRepositorioPlugin();
    }

    public List<RepositorioPn> getRepositorioPn() throws Exception {
        return repositorioPnLogic.getRepositorioPn();
    }

    public void saveRepositorioPn(RepositorioPn entity)
        throws Exception {
        repositorioPnLogic.saveRepositorioPn(entity);
    }

    public void deleteRepositorioPn(RepositorioPn entity)
        throws Exception {
        repositorioPnLogic.deleteRepositorioPn(entity);
    }

    public void updateRepositorioPn(RepositorioPn entity)
        throws Exception {
        repositorioPnLogic.updateRepositorioPn(entity);
    }

    public RepositorioPn getRepositorioPn(Long repositorioPnCodigo)
        throws Exception {
        RepositorioPn repositorioPn = null;

        try {
            repositorioPn = repositorioPnLogic.getRepositorioPn(repositorioPnCodigo);
        } catch (Exception e) {
            throw e;
        }

        return repositorioPn;
    }

    public List<RepositorioPn> findByCriteriaInRepositorioPn(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return repositorioPnLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<RepositorioPn> findPageRepositorioPn(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return repositorioPnLogic.findPageRepositorioPn(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberRepositorioPn() throws Exception {
        return repositorioPnLogic.findTotalNumberRepositorioPn();
    }

    public List<RepositorioPnDTO> getDataRepositorioPn()
        throws Exception {
        return repositorioPnLogic.getDataRepositorioPn();
    }

    public List<Rol> getRol() throws Exception {
        return rolLogic.getRol();
    }

    public void saveRol(Rol entity) throws Exception {
        rolLogic.saveRol(entity);
    }

    public void deleteRol(Rol entity) throws Exception {
        rolLogic.deleteRol(entity);
    }

    public void updateRol(Rol entity) throws Exception {
        rolLogic.updateRol(entity);
    }

    public Rol getRol(Long rolCodigo) throws Exception {
        Rol rol = null;

        try {
            rol = rolLogic.getRol(rolCodigo);
        } catch (Exception e) {
            throw e;
        }

        return rol;
    }

    public List<Rol> findByCriteriaInRol(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return rolLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Rol> findPageRol(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception {
        return rolLogic.findPageRol(sortColumnName, sortAscending, startRow,
            maxResults);
    }

    public Long findTotalNumberRol() throws Exception {
        return rolLogic.findTotalNumberRol();
    }

    public List<RolDTO> getDataRol() throws Exception {
        return rolLogic.getDataRol();
    }

    public List<TipoArchivoPn> getTipoArchivoPn() throws Exception {
        return tipoArchivoPnLogic.getTipoArchivoPn();
    }

    public void saveTipoArchivoPn(TipoArchivoPn entity)
        throws Exception {
        tipoArchivoPnLogic.saveTipoArchivoPn(entity);
    }

    public void deleteTipoArchivoPn(TipoArchivoPn entity)
        throws Exception {
        tipoArchivoPnLogic.deleteTipoArchivoPn(entity);
    }

    public void updateTipoArchivoPn(TipoArchivoPn entity)
        throws Exception {
        tipoArchivoPnLogic.updateTipoArchivoPn(entity);
    }

    public TipoArchivoPn getTipoArchivoPn(Long tipoArchivoPnCodigo)
        throws Exception {
        TipoArchivoPn tipoArchivoPn = null;

        try {
            tipoArchivoPn = tipoArchivoPnLogic.getTipoArchivoPn(tipoArchivoPnCodigo);
        } catch (Exception e) {
            throw e;
        }

        return tipoArchivoPn;
    }

    public List<TipoArchivoPn> findByCriteriaInTipoArchivoPn(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoArchivoPnLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoArchivoPn> findPageTipoArchivoPn(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoArchivoPnLogic.findPageTipoArchivoPn(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoArchivoPn() throws Exception {
        return tipoArchivoPnLogic.findTotalNumberTipoArchivoPn();
    }

    public List<TipoArchivoPnDTO> getDataTipoArchivoPn()
        throws Exception {
        return tipoArchivoPnLogic.getDataTipoArchivoPn();
    }

    public List<Usuario> getUsuario() throws Exception {
        return usuarioLogic.getUsuario();
    }

    public void saveUsuario(Usuario entity) throws Exception {
        usuarioLogic.saveUsuario(entity);
    }

    public void deleteUsuario(Usuario entity) throws Exception {
        usuarioLogic.deleteUsuario(entity);
    }

    public void updateUsuario(Usuario entity) throws Exception {
        usuarioLogic.updateUsuario(entity);
    }

    public Usuario getUsuario(Long usuarioCodigo) throws Exception {
        Usuario usuario = null;

        try {
            usuario = usuarioLogic.getUsuario(usuarioCodigo);
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioLogic.findPageUsuario(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberUsuario() throws Exception {
        return usuarioLogic.findTotalNumberUsuario();
    }

    public List<UsuarioDTO> getDataUsuario() throws Exception {
        return usuarioLogic.getDataUsuario();
    }

    public List<UsuarioRol> getUsuarioRol() throws Exception {
        return usuarioRolLogic.getUsuarioRol();
    }

    public void saveUsuarioRol(UsuarioRol entity) throws Exception {
        usuarioRolLogic.saveUsuarioRol(entity);
    }

    public void deleteUsuarioRol(UsuarioRol entity) throws Exception {
        usuarioRolLogic.deleteUsuarioRol(entity);
    }

    public void updateUsuarioRol(UsuarioRol entity) throws Exception {
        usuarioRolLogic.updateUsuarioRol(entity);
    }

    public UsuarioRol getUsuarioRol(Long usuarioRolCodigo)
        throws Exception {
        UsuarioRol usuarioRol = null;

        try {
            usuarioRol = usuarioRolLogic.getUsuarioRol(usuarioRolCodigo);
        } catch (Exception e) {
            throw e;
        }

        return usuarioRol;
    }

    public List<UsuarioRol> findByCriteriaInUsuarioRol(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuarioRolLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<UsuarioRol> findPageUsuarioRol(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioRolLogic.findPageUsuarioRol(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberUsuarioRol() throws Exception {
        return usuarioRolLogic.findTotalNumberUsuarioRol();
    }

    public List<UsuarioRolDTO> getDataUsuarioRol() throws Exception {
        return usuarioRolLogic.getDataUsuarioRol();
    }

    public List<VersionRep> getVersionRep() throws Exception {
        return versionRepLogic.getVersionRep();
    }

    public void saveVersionRep(VersionRep entity) throws Exception {
        versionRepLogic.saveVersionRep(entity);
    }

    public void deleteVersionRep(VersionRep entity) throws Exception {
        versionRepLogic.deleteVersionRep(entity);
    }

    public void updateVersionRep(VersionRep entity) throws Exception {
        versionRepLogic.updateVersionRep(entity);
    }

    public VersionRep getVersionRep(Long versionRepCodigo)
        throws Exception {
        VersionRep versionRep = null;

        try {
            versionRep = versionRepLogic.getVersionRep(versionRepCodigo);
        } catch (Exception e) {
            throw e;
        }

        return versionRep;
    }

    public List<VersionRep> findByCriteriaInVersionRep(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return versionRepLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<VersionRep> findPageVersionRep(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return versionRepLogic.findPageVersionRep(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberVersionRep() throws Exception {
        return versionRepLogic.findTotalNumberVersionRep();
    }

    public List<VersionRepDTO> getDataVersionRep() throws Exception {
        return versionRepLogic.getDataVersionRep();
    }

	
    //TODO: Consultas
    @Override
	public Usuario consultarUsuarioPorCorreo(String correo) {
		return usuarioLogic.consultarUsuarioPorCorreo(correo);
	}
    
    @Override
    public String consultarRolUsuarioPorCorreo(String correo) {
		return rolLogic.consultarRolUsuarioPorCorreo(correo);
	}

	@Override
	public Usuario autenticarUsuario(String correo, String clave) throws Exception {
		return seguridadLogica.autenticarUsuario(correo, clave);
	}

	@Override
	public Usuario correoDisponible(String correo) {
		return usuarioLogic.consultarCorreoDisponible(correo);
	}

	@Override
	public List<UsuarioDTO> getDataVtUsuario() throws Exception {
		return usuarioLogic.getDataUsuario();
	}

	@Override
	public List<UsuarioDTO> getDataVtUsuarioI() throws Exception{
		return usuarioLogic.getDataUsuarioI();
	}
    
}
