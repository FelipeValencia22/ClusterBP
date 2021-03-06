package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.RepositorioDTO;
import co.edu.usb.dataaccess.dao.*;
import co.edu.usb.exceptions.*;
import co.edu.usb.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("RepositorioLogic")
public class RepositorioLogic implements IRepositorioLogic {
	private static final Logger log = LoggerFactory.getLogger(RepositorioLogic.class);

	/**
	 * DAO injected by Spring that manages Repositorio entities
	 *
	 */
	@Autowired
	private IRepositorioDAO repositorioDAO;

	/**
	 * DAO injected by Spring that manages RepositorioPn entities
	 *
	 */
	@Autowired
	private IRepositorioPnDAO repositorioPnDAO;

	@Transactional(readOnly = true)
	public List<Repositorio> getRepositorio() throws Exception {
		log.debug("finding all Repositorio instances");

		List<Repositorio> list = new ArrayList<Repositorio>();

		try {
			list = repositorioDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Repositorio failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL +
					"Repositorio");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveRepositorio(Repositorio entity) throws Exception {
		log.debug("saving Repositorio instance");

		try {
			if (entity.getActivo() == null) {
				throw new ZMessManager().new EmptyFieldException("activo");
			}

			if ((entity.getActivo() != null) &&
					(Utilities.checkWordAndCheckWithlength(entity.getActivo(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("activo");
			}

			if (entity.getDescripcion() == null) {
				throw new ZMessManager().new EmptyFieldException("descripcion");
			}

			if ((entity.getDescripcion() != null) &&
					(Utilities.checkWordAndCheckWithlength(
							entity.getDescripcion(), 255) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcion");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("nombre");
			}

			if ((entity.getNombre() != null) &&
					(Utilities.checkWordAndCheckWithlength(entity.getNombre(),
							255) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}


			if (entity.getUsuCreador() == null) {
				throw new ZMessManager().new EmptyFieldException("usuCreador");
			}


			repositorioDAO.save(entity);

			log.debug("save Repositorio successful");
		} catch (Exception e) {
			log.error("save Repositorio failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteRepositorio(Repositorio entity) throws Exception {
		log.debug("deleting Repositorio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Repositorio");
		}

		if (entity.getRepositorioCodigo() == null) {
			throw new ZMessManager().new EmptyFieldException(
					"repositorioCodigo");
		}

		List<RepositorioPn> repositorioPns = null;

		try {

			repositorioPns = repositorioPnDAO.findByProperty("repositorio.repositorioCodigo",
					entity.getRepositorioCodigo());

			if (Utilities.validationsList(repositorioPns) == true) {
				throw new ZMessManager().new DeletingException("repositorioPns");
			}

			repositorioDAO.delete(entity);

			log.debug("delete Repositorio successful");
		} catch (Exception e) {
			log.error("delete Repositorio failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateRepositorio(Repositorio entity) throws Exception {
		log.debug("updating Repositorio instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Repositorio");
			}

			if (entity.getActivo() == null) {
				throw new ZMessManager().new EmptyFieldException("activo");
			}

			if ((entity.getActivo() != null) &&
					(Utilities.checkWordAndCheckWithlength(entity.getActivo(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("activo");
			}

			if (entity.getDescripcion() == null) {
				throw new ZMessManager().new EmptyFieldException("descripcion");
			}

			if ((entity.getDescripcion() != null) &&
					(Utilities.checkWordAndCheckWithlength(
							entity.getDescripcion(), 255) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcion");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("nombre");
			}

			if ((entity.getNombre() != null) &&
					(Utilities.checkWordAndCheckWithlength(entity.getNombre(),
							255) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getRepositorioCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"repositorioCodigo");
			}

			if (entity.getUsuCreador() == null) {
				throw new ZMessManager().new EmptyFieldException("usuCreador");
			}

			repositorioDAO.update(entity);

			log.debug("update Repositorio successful");
		} catch (Exception e) {
			log.error("update Repositorio failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public Repositorio getRepositorio(Long repositorioCodigo)
			throws Exception {
		log.debug("getting Repositorio instance");

		Repositorio entity = null;

		try {
			entity = repositorioDAO.findById(repositorioCodigo);
		} catch (Exception e) {
			log.error("get Repositorio failed", e);
			throw new ZMessManager().new FindingException("Repositorio");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Repositorio> findPageRepositorio(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		List<Repositorio> entity = null;

		try {
			entity = repositorioDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Repositorio Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberRepositorio() throws Exception {
		Long entity = null;

		try {
			entity = repositorioDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Repositorio Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 * [0] = String variable = (String) varibles[i]; representa como se llama la
	 * variable en el pojo
	 *
	 * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
	 * valor necesita o no ''(comillas simples)usado para campos de tipo string
	 *
	 * [2] = Object value = varibles[i + 2]; representa el valor que se va a
	 * buscar en la BD
	 *
	 * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
	 * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
	 * en este campo iria el tipo de comparador que quiero si es = o <>
	 *
	 * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
	 * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
	 * que se le ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 * la diferencia son estas dos posiciones
	 *
	 * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
	 * a ser buscada en un rango
	 *
	 * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
	 *
	 * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
	 * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
	 *
	 * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
	 * ejemplo: a comparator1 1 and a < 5
	 *
	 * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
	 * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
	 * 5) *
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql)
	 *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
	 *            una fecha
	 *
	 * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
	 * dates)
	 *
	 * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
	 * dates)
	 *
	 * esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<Repositorio> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		List<Repositorio> list = new ArrayList<Repositorio>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null) &&
						(variables[i + 2] != null) &&
						(variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " \'" +
										value + "\' )")
										: (tempWhere + " AND (model." + variable + " " +
												comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " " +
										value + " )")
										: (tempWhere + " AND (model." + variable + " " +
												comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null) &&
						(variablesBetween[j + 1] != null) &&
						(variablesBetween[j + 2] != null) &&
						(variablesBetween[j + 3] != null) &&
						(variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0)
							? ("(" + value + " " + comparator1 + " " + variable +
									" and " + variable + " " + comparator2 + " " + value2 +
									" )")
									: (tempWhere + " AND (" + value + " " + comparator1 +
											" " + variable + " and " + variable + " " +
											comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null) &&
						(variablesBetweenDates[k + 1] != null) &&
						(variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0)
							? ("(model." + variable + " between \'" + value +
									"\' and \'" + value2 + "\')")
									: (tempWhere + " AND (model." + variable +
											" between \'" + value + "\' and \'" + value2 + "\')");
				}

				k = k + 2;
			}
		}

		if (tempWhere.length() == 0) {
			where = null;
		} else {
			where = "(" + tempWhere + ")";
		}

		try {
			list = repositorioDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = true)
	public List<RepositorioDTO> getDataRepositorio() throws Exception {
		try {
			List<Repositorio> repositorio = repositorioDAO.findAll();

			List<RepositorioDTO> repositorioDTO = new ArrayList<RepositorioDTO>();

			for (Repositorio repositorioTmp : repositorio) {
				RepositorioDTO repositorioDTO2 = new RepositorioDTO();

				if(repositorioTmp.getActivo().equalsIgnoreCase("S")){

					repositorioDTO2.setRepositorioCodigo(repositorioTmp.getRepositorioCodigo());
					repositorioDTO2.setActivo((repositorioTmp.getActivo() != null)
							? repositorioTmp.getActivo() : null);
					repositorioDTO2.setDescripcion((repositorioTmp.getDescripcion() != null)
							? repositorioTmp.getDescripcion() : null);
					repositorioDTO2.setFechaCreacion(repositorioTmp.getFechaCreacion());
					repositorioDTO2.setFechaModificacion(repositorioTmp.getFechaModificacion());
					repositorioDTO2.setNombre((repositorioTmp.getNombre() != null)
							? repositorioTmp.getNombre() : null);
					repositorioDTO2.setUsuCreador((repositorioTmp.getUsuCreador() != null)
							? repositorioTmp.getUsuCreador() : null);
					repositorioDTO2.setUsuModificador((repositorioTmp.getUsuModificador() != null)
							? repositorioTmp.getUsuModificador() : null);
					repositorioDTO.add(repositorioDTO2);
				}
			}

			return repositorioDTO;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly = true)
	public List<RepositorioDTO> getDataRepositorioI() throws Exception {
		try {
			List<Repositorio> repositorio = repositorioDAO.findAll();

			List<RepositorioDTO> repositorioDTO = new ArrayList<RepositorioDTO>();

			for (Repositorio repositorioTmp : repositorio) {
				RepositorioDTO repositorioDTO2 = new RepositorioDTO();

				if(repositorioTmp.getActivo().equalsIgnoreCase("N")){

					repositorioDTO2.setRepositorioCodigo(repositorioTmp.getRepositorioCodigo());
					repositorioDTO2.setActivo((repositorioTmp.getActivo() != null)
							? repositorioTmp.getActivo() : null);
					repositorioDTO2.setDescripcion((repositorioTmp.getDescripcion() != null)
							? repositorioTmp.getDescripcion() : null);
					repositorioDTO2.setFechaCreacion(repositorioTmp.getFechaCreacion());
					repositorioDTO2.setFechaModificacion(repositorioTmp.getFechaModificacion());
					repositorioDTO2.setNombre((repositorioTmp.getNombre() != null)
							? repositorioTmp.getNombre() : null);
					repositorioDTO2.setUsuCreador((repositorioTmp.getUsuCreador() != null)
							? repositorioTmp.getUsuCreador() : null);
					repositorioDTO2.setUsuModificador((repositorioTmp.getUsuModificador() != null)
							? repositorioTmp.getUsuModificador() : null);
					repositorioDTO.add(repositorioDTO2);
				}
			}

			return repositorioDTO;
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Transactional(readOnly = true)
	public String consultarRepositorioPorNombre (String nombre){
		return repositorioDAO.consultarRepositorioPorNombre(nombre);
	}

}
