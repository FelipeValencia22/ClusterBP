package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.PnDTO;
import co.edu.usb.dataaccess.dao.*;
import co.edu.usb.exceptions.*;
import co.edu.usb.utilities.Utilities;

import org.primefaces.event.FileUploadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("PnLogic")
public class PnLogic implements IPnLogic {
	private static final Logger log = LoggerFactory.getLogger(PnLogic.class);

	/**
	 * DAO injected by Spring that manages Pn entities
	 *
	 */
	@Autowired
	private IPnDAO pnDAO;


	/**
	 * DAO injected by Spring that manages RepositorioPn entities
	 *
	 */
	@Autowired
	private IRepositorioPnDAO repositorioPnDAO;

	/**
	 * Logic injected by Spring that manages TipoArchivoPn entities
	 *
	 */
	@Autowired
	ITipoArchivoPnLogic logicTipoArchivoPn1;

	DocumentBuilderFactory dbFactory; 
	DocumentBuilder dBuilder;

	@Transactional(readOnly = true)
	public List<Pn> getPn() throws Exception {
		log.debug("finding all Pn instances");

		List<Pn> list = new ArrayList<Pn>();

		try {
			list = pnDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Pn failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL +
					"Pn");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePn(Pn entity) throws Exception {
		log.debug("saving Pn instance");

		try {
			if (entity.getTipoArchivoPn() == null) {
				throw new ZMessManager().new ForeignException("tipoArchivoPn");
			}

			if (entity.getActivo() == null) {
				throw new ZMessManager().new EmptyFieldException("activo");
			}

			if ((entity.getActivo() != null) &&
					(Utilities.checkWordAndCheckWithlength(entity.getActivo(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("activo");
			}

			if (entity.getArchivo() == null) {
				throw new ZMessManager().new EmptyFieldException("archivo");
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

			if (entity.getTitulo() == null) {
				throw new ZMessManager().new EmptyFieldException("titulo");
			}

			if ((entity.getTitulo() != null) &&
					(Utilities.checkWordAndCheckWithlength(entity.getTitulo(),
							255) == false)) {
				throw new ZMessManager().new NotValidFormatException("titulo");
			}

			if (entity.getUsuCreador() == null) {
				throw new ZMessManager().new EmptyFieldException("usuCreador");
			}

			if (entity.getTipoArchivoPn().getTipoArchivoPnCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"tipoArchivoPnCodigo_TipoArchivoPn");
			}

			pnDAO.save(entity);

			log.debug("save Pn successful");
		} catch (Exception e) {
			log.error("save Pn failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePn(Pn entity) throws Exception {
		log.debug("deleting Pn instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Pn");
		}

		if (entity.getPnCodigo() == null) {
			throw new ZMessManager().new EmptyFieldException("pnCodigo");
		}

		
		List<RepositorioPn> repositorioPns = null;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePn(Pn entity) throws Exception {
		log.debug("updating Pn instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Pn");
			}

			if (entity.getTipoArchivoPn() == null) {
				throw new ZMessManager().new ForeignException("tipoArchivoPn");
			}

			if (entity.getActivo() == null) {
				throw new ZMessManager().new EmptyFieldException("activo");
			}

			if ((entity.getActivo() != null) &&
					(Utilities.checkWordAndCheckWithlength(entity.getActivo(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("activo");
			}

			if (entity.getArchivo() == null) {
				throw new ZMessManager().new EmptyFieldException("archivo");
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

			if (entity.getPnCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("pnCodigo");
			}

			if (entity.getTitulo() == null) {
				throw new ZMessManager().new EmptyFieldException("titulo");
			}

			if ((entity.getTitulo() != null) &&
					(Utilities.checkWordAndCheckWithlength(entity.getTitulo(),
							255) == false)) {
				throw new ZMessManager().new NotValidFormatException("titulo");
			}

			if (entity.getUsuCreador() == null) {
				throw new ZMessManager().new EmptyFieldException("usuCreador");
			}

			if (entity.getTipoArchivoPn().getTipoArchivoPnCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"tipoArchivoPnCodigo_TipoArchivoPn");
			}

			pnDAO.update(entity);

			log.debug("update Pn successful");
		} catch (Exception e) {
			log.error("update Pn failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<PnDTO> getDataPn() throws Exception {
		try {
			List<Pn> pn = pnDAO.findAll();

			List<PnDTO> pnDTO = new ArrayList<PnDTO>();

			for (Pn pnTmp : pn) {
				PnDTO pnDTO2 = new PnDTO();
				if(pnTmp.getActivo().toString().trim().equalsIgnoreCase("S")){
					pnDTO2.setPnCodigo(pnTmp.getPnCodigo());
					pnDTO2.setActivo((pnTmp.getActivo() != null)
							? pnTmp.getActivo() : null);
					pnDTO2.setArchivo((pnTmp.getArchivo() != null)
							? pnTmp.getArchivo() : null);
					pnDTO2.setDescripcion((pnTmp.getDescripcion() != null)
							? pnTmp.getDescripcion() : null);
					pnDTO2.setFechaCreacion(pnTmp.getFechaCreacion());
					pnDTO2.setFechaModificacion(pnTmp.getFechaModificacion());
					pnDTO2.setTitulo((pnTmp.getTitulo() != null)
							? pnTmp.getTitulo() : null);
					pnDTO2.setUsuCreador((pnTmp.getUsuCreador() != null)
							? pnTmp.getUsuCreador() : null);
					pnDTO2.setUsuModificador((pnTmp.getUsuModificador() != null)
							? pnTmp.getUsuModificador() : null);
					pnDTO2.setTipoArchivoPnCodigo_TipoArchivoPn((pnTmp.getTipoArchivoPn()
							.getTipoArchivoPnCodigo() != null)
							? pnTmp.getTipoArchivoPn().getTipoArchivoPnCodigo() : null);
					pnDTO.add(pnDTO2);
				}
			}

			return pnDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<PnDTO> getDataPnI() throws Exception {
		try {
			List<Pn> pn = pnDAO.findAll();

			List<PnDTO> pnDTO = new ArrayList<PnDTO>();

			for (Pn pnTmp : pn) {
				PnDTO pnDTO2 = new PnDTO();
				if(pnTmp.getActivo().toString().trim().equalsIgnoreCase("N")){
					pnDTO2.setPnCodigo(pnTmp.getPnCodigo());
					pnDTO2.setActivo((pnTmp.getActivo() != null)
							? pnTmp.getActivo() : null);
					pnDTO2.setArchivo((pnTmp.getArchivo() != null)
							? pnTmp.getArchivo() : null);
					pnDTO2.setDescripcion((pnTmp.getDescripcion() != null)
							? pnTmp.getDescripcion() : null);
					pnDTO2.setFechaCreacion(pnTmp.getFechaCreacion());
					pnDTO2.setFechaModificacion(pnTmp.getFechaModificacion());
					pnDTO2.setTitulo((pnTmp.getTitulo() != null)
							? pnTmp.getTitulo() : null);
					pnDTO2.setUsuCreador((pnTmp.getUsuCreador() != null)
							? pnTmp.getUsuCreador() : null);
					pnDTO2.setUsuModificador((pnTmp.getUsuModificador() != null)
							? pnTmp.getUsuModificador() : null);
					pnDTO2.setTipoArchivoPnCodigo_TipoArchivoPn((pnTmp.getTipoArchivoPn()
							.getTipoArchivoPnCodigo() != null)
							? pnTmp.getTipoArchivoPn().getTipoArchivoPnCodigo() : null);
					pnDTO.add(pnDTO2);
				}
			}

			return pnDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Pn getPn(Long pnCodigo) throws Exception {
		log.debug("getting Pn instance");

		Pn entity = null;
 
		try {
			entity = pnDAO.findById(pnCodigo);
		} catch (Exception e) {
			log.error("get Pn failed", e);
			throw new ZMessManager().new FindingException("Pn");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Pn> findPagePn(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<Pn> entity = null;

		try {
			entity = pnDAO.findPage(sortColumnName, sortAscending, startRow,
					maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Pn Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberPn() throws Exception {
		Long entity = null;

		try {
			entity = pnDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Pn Count");
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
	public List<Pn> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		List<Pn> list = new ArrayList<Pn>();
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
			list = pnDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = true)
	public Pn consultarPNPorNombre(String nombre) {
		return pnDAO.consultarPNporNombre(nombre);
	}
	
	public DocumentBuilderFactory getDbFactory() {
		return dbFactory;
	}

	public void setDbFactory(DocumentBuilderFactory dbFactory) {
		this.dbFactory = dbFactory;
	}

	public DocumentBuilder getdBuilder() {
		return dBuilder;
	}

	public void setdBuilder(DocumentBuilder dBuilder) {
		this.dBuilder = dBuilder;
	}

	// Metodos
	public String analisisTextual(FileUploadEvent event){
		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(event.getFile().getInputstream());
			String tipoActividad;
			String StartEvent;
			String IntermediateEvent;
			String EndEvent;

			ArrayList <ArrayList<String>> listaTextual = new ArrayList<ArrayList<String>>();

			doc.getDocumentElement().normalize();

			NodeList nodeListActiviti= doc.getElementsByTagName("Activity");
			for (int i = 0; i < nodeListActiviti.getLength(); i++){

				Element elementActiviti = (Element) nodeListActiviti.item(i);
				String elementActivitiId= elementActiviti.getAttribute("Id");
				String elementActivitiName= elementActiviti.getAttribute("Name");

				tipoActividad="";

				///////////////// Event //////////////////////////////////////////////
				NodeList nodeListEvent = elementActiviti.getElementsByTagName("Event");
				for (int j = 0; j < nodeListEvent.getLength(); ++j){

					StartEvent="";
					IntermediateEvent="";
					EndEvent="";

					Element elementEvent = (Element) nodeListEvent.item(j);
					NodeList nodeListStarEvent = elementEvent.getElementsByTagName("StartEvent");
					NodeList nodeListIntermediateEvent = elementEvent.getElementsByTagName("IntermediateEvent");
					NodeList nodeListEndEvent = elementEvent.getElementsByTagName("EndEvent");

					for (int k = 0; k < nodeListStarEvent.getLength(); k++) {
						Element elementStarEvent = (Element) nodeListStarEvent.item(k);
						StartEvent=elementStarEvent.getAttribute("Trigger");
						if(!StartEvent.equals("None")){
							tipoActividad="StartEvent"+StartEvent;
						}else{
							tipoActividad="StartEvent";
						}

					}					
					for (int k = 0; k < nodeListIntermediateEvent.getLength(); k++) {
						Element elementIntermediateEvent= (Element) nodeListIntermediateEvent.item(k);
						IntermediateEvent=elementIntermediateEvent.getAttribute("Trigger");
						if(!IntermediateEvent.equals("None")){
							tipoActividad="IntermediateEvent"+IntermediateEvent;
						}else{
							tipoActividad="IntermediateEvent";
						}
					}					
					for (int k = 0; k < nodeListEndEvent.getLength(); k++) {
						Element elementEndEvent = (Element) nodeListEndEvent.item(k);
						EndEvent=elementEndEvent.getAttribute("Result");
						if(!IntermediateEvent.equals("EndEvent")){
							tipoActividad ="EndEvent"+EndEvent;
						}else{
							tipoActividad="EndEvent";
						}
					}
				}

				/////////////// Implementation /////////////////////////////////////////////////////////
				NodeList nodeListImplementation = elementActiviti.getElementsByTagName("Implementation");
				for (int j = 0; j < nodeListImplementation.getLength(); ++j){

					Element elementEvent = (Element) nodeListImplementation.item(j);					
					NodeList nodeListTask = elementEvent.getElementsByTagName("Task");
					NodeList nodeListSubFlow = elementEvent.getElementsByTagName("SubFlow");

					for (int k = 0; k < nodeListSubFlow.getLength(); k++) {
						tipoActividad="TaskSubFlow";
					}

					for (int k = 0; k < nodeListTask.getLength(); k++) {
						Element elementTask= (Element)nodeListTask.item(k);

						NodeList nodeListTaskSend = elementTask.getElementsByTagName("TaskSend");
						NodeList nodeListTaskManual = elementTask.getElementsByTagName("TaskManual");
						NodeList nodeListTaskScript = elementTask.getElementsByTagName("TaskScript");
						NodeList nodeListTaskBusinessRule = elementTask.getElementsByTagName("TaskBusinessRule");
						NodeList nodeListTaskUser = elementTask.getElementsByTagName("TaskUser");
						NodeList nodeListTaskService = elementTask.getElementsByTagName("TaskService");
						NodeList nodeListTaskReceive = elementTask.getElementsByTagName("TaskReceive");


						for (int l = 0; l < nodeListTaskSend.getLength(); l++) {
							tipoActividad="TaskSend";
						}						
						for (int l = 0; l < nodeListTaskManual.getLength(); l++) {
							tipoActividad="TaskManual";
						}						
						for (int l = 0; l < nodeListTaskScript.getLength(); l++) {
							tipoActividad="TaskScript";
						}
						for (int l = 0; l < nodeListTaskBusinessRule.getLength(); l++) {
							tipoActividad="TaskBusinessRule";
						}
						for (int l = 0; l < nodeListTaskUser.getLength(); l++) {
							tipoActividad="TaskUser";
						}
						for (int l = 0; l < nodeListTaskService.getLength(); l++) {
							tipoActividad="TaskService";
						}
						for (int l = 0; l < nodeListTaskReceive.getLength(); l++) {
							tipoActividad="TaskReceive";
						}

						if(tipoActividad.equals("")){
							tipoActividad="Task";
						}

					}
				}

				/////////////// BlockActivity /////////////////////////////////////////////////////////
				NodeList nodeListBlockActivity = elementActiviti.getElementsByTagName("BlockActivity");
				for (int j = 0; j < nodeListBlockActivity.getLength(); ++j){
					tipoActividad="TaskBlocActivity";
				}

				//////////////// Route ////////////////////////////////////////////////////////////////
				NodeList nodeListRoute = elementActiviti.getElementsByTagName("Route");
				for (int j = 0; j < nodeListRoute.getLength(); j++) {
					Element elementRoute= (Element)nodeListRoute.item(j);
					String valor1=elementRoute.getAttribute("GatewayType");
					String valor2=elementRoute.getAttribute("ExclusiveType");
					String valor3 =elementRoute.getAttribute("Instantiate");
					String valor4 =elementRoute.getAttribute("ParallelEventBased");

					if (!valor1.isEmpty()) {
						tipoActividad="RouteGatewayType"+valor1;
					}
					if (!valor2.isEmpty()) {
						tipoActividad="RouteExclusiveType"+valor2;
					}
					if (!valor3.isEmpty() && valor4.isEmpty()) {
						tipoActividad="RouteExclusiveTypeBasedEvent";
					}
					if (!valor3.isEmpty() && !valor4.isEmpty()) {
						tipoActividad="RouteGatewayTypeBasedEvent";
					}

					if(valor1.isEmpty() && valor2.isEmpty()){
						tipoActividad="Route";
					}
				}


				///// Asignar los valores a una lista de listas
				listaTextual.add(new ArrayList<String>());
				listaTextual.get(i).add(elementActivitiId);
				listaTextual.get(i).add(tipoActividad);
				listaTextual.get(i).add(elementActivitiName);
			}

			/// Imprimir valores
			
			for (int j = 0; j < listaTextual.size(); j++) {
				for (int k = 0; k < listaTextual.get(j).size(); k++) {
					System.out.println(listaTextual.get(j).get(k));
				}
				System.out.println();

			}
			 

			analisisEstructural(listaTextual, event);

		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}


	public String analisisEstructural(ArrayList<ArrayList<String>> listaTextual, FileUploadEvent event){
		
		ArrayList <ArrayList<String>> listaEstructural = new ArrayList<ArrayList<String>>();
		
		try {
			Document docTransiciones = dBuilder.parse(event.getFile().getInputstream());

			String fromId;
			String toId;
			String id;
			String fromString="";
			String toString="";

			NodeList nodeListTransition= docTransiciones.getElementsByTagName("Transition");
			System.out.println("+++++++++++ Transition");
			System.out.println(nodeListTransition.getLength());
			for (int i = 0; i < nodeListTransition.getLength(); ++i){
				Element elementTransition= (Element)nodeListTransition.item(i);
				id= elementTransition.getAttribute("Id");
				fromId= elementTransition.getAttribute("From");
				toId= elementTransition.getAttribute("To");

				/// Asignar los valores a la Lista
				listaEstructural.add(new ArrayList<String>());

				for (int j = 0; j < listaTextual.size(); j++) {
					if(listaTextual.get(j).get(0).equals(fromId)){
						fromString=listaTextual.get(j).get(1);
					}
				}

				for (int j = 0; j < listaTextual.size(); j++) {
					if(listaTextual.get(j).get(0).equals(toId)){
						toString=listaTextual.get(j).get(1);
					}
				}

				listaEstructural.get(i).add(fromString+"_"+toString+(i+1));	
				fromString="";
				toString="";

			}

			/// Imprimir valores
			for (int j = 0; j < listaEstructural.size(); j++) {
				for (int k = 0; k < listaEstructural.get(j).size(); k++) {
					System.out.println(listaEstructural.get(j).get(k));
					System.out.println();
				}

			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		String nombreArchivo=event.getFile().getFileName();
		crearTxt(listaTextual,listaEstructural,nombreArchivo);
		return "";
	}
	
	public void crearTxt(ArrayList<ArrayList<String>> listaTextual, ArrayList<ArrayList<String>> listaEstructural, String nombreArchivo){
		String ruta="/Data/";
		try{
		    PrintWriter writer = new PrintWriter(ruta+nombreArchivo+".txt", "UTF-8");
		    writer.println(listaTextual);
		    writer.println(listaEstructural);
		    writer.close();
		} catch (IOException e) {
		  e.printStackTrace();
		}
	}



}
