package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.configuracion.PATH;
import co.edu.usb.clusterbp.dto.PnDTO;
import co.edu.usb.clusterbp.index.Indexer;
import co.edu.usb.clusterbp.index.LuceneIndex;
import co.edu.usb.dataaccess.dao.*;
import co.edu.usb.exceptions.*;
import co.edu.usb.parser.Codebook;
import co.edu.usb.parser.Parser;
import co.edu.usb.utilities.Utilities;

import org.apache.lucene.queryParser.ParseException;
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

import clustering.Clustering;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
/**
 * @author Dilan Steven Mejia
 *
 */
@Scope("singleton")
@Service("PnLogic") 
public class PnLogic implements IPnLogic {
	private static final Logger log = LoggerFactory.getLogger(PnLogic.class);

	@Autowired
	private IPnDAO pNDAO;
	protected String[] checkList;
	
	int eventos;
	int actividades;
	int compuertas;
	
	DocumentBuilderFactory dbFactory; 
	DocumentBuilder dBuilder;
	
	@Transactional(readOnly = true)
	public List<Pn> getPn() throws Exception {
		log.debug("finding all Pn instances");

		List<Pn> list = new ArrayList<Pn>();

		try {
			list = pNDAO.findAll();
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

			pNDAO.save(entity);

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


		@SuppressWarnings("unused")
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

			pNDAO.update(entity);

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
			List<Pn> pn = pNDAO.findAll();

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
			List<Pn> pn = pNDAO.findAll();

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
			entity = pNDAO.findById(pnCodigo);
		} catch (Exception e) {
			log.error("get Pn failed", e);
			throw new ZMessManager().new FindingException("Pn");
		} finally {
		}

		return entity;
	}

	
	
	//TODO: DILAN	

	//Valida los archivos traidos en el repositorio
	public ArrayList<Pn> obtenerProcesos() throws Exception {
		File[] listFiles = pNDAO.obtenerProcesos();
		ArrayList<Pn> listaProcesos = new ArrayList<Pn>();

		for (int i = 0; i < listFiles.length; i++)         {
			Pn proceso = new Pn();
			if (listFiles[i].isFile() && listFiles[i].getName().contains(".xpdl")){
				proceso.setNombre(listFiles[i].getName());
				proceso.setContenido(listFiles[i].getName());
				proceso.setTamanho(listFiles[i].length());
				listaProcesos.add(proceso);
			}
		}

		return listaProcesos;
	}

	//Valido cada uno de los campos del objeto PN (Proceso de negocio)
	public String[] crearProceso(Pn[] listXPDL)  {
		int contadorCheckList = 0;
		try {
			checkList = new String[listXPDL.length];
			for (int i = 0; i < listXPDL.length; i++) {
				if(listXPDL[i].getNombre()!=null && listXPDL[i].getNombre().equals("")==false){
					if(listXPDL[i].getContenido()!=null && listXPDL[i].getNombre().equals("")==false){
						if(listXPDL[i].getTamanho()!=null && listXPDL[i].getTamanho()!=0){
							//Se crea el proceso en el servidor.
							checkList[contadorCheckList] = pNDAO.crearProceso(listXPDL[i]);
							/*Se crea el documento txt con el contenido estructural del proceso de negocio para
							 *  despues pasarlo al algoritmo de clustering*/
							if(checkList[contadorCheckList].equals("Completado")==true){
								String contenidoEstructural = construirEstructuraProceso(listXPDL[i].getNombre());
								checkList[contadorCheckList]=	pNDAO.crearDocumentoEstructura(listXPDL[i].getNombre(),
										contenidoEstructural);

								if(checkList[contadorCheckList].equals("Completado")==true){
									LuceneIndex crearIndice = new LuceneIndex();
									crearIndice.createIndex(contenidoEstructural);
								}

							}

							contadorCheckList++;
						}
					}
				}

			}

		} catch (IOException e) {
			checkList[contadorCheckList] = e.getMessage();
			contadorCheckList++;
		}
		return checkList;
	}


	//Permite extraer la infomacion textual y los codebook del proceso de negocio.
	public String construirEstructuraProceso(String XPDL){

		String [][] matrizCaminosActividades  =Parser.obtenerCaminosActivities(PATH.RUTA_REPOSITORIO_XPDL+XPDL);
		String[] matrizCaminosActividadesAuxiliar = new String[matrizCaminosActividades.length];

		String [][] matrizTextual  =Parser.obtenerMatrizTextual(PATH.RUTA_REPOSITORIO_XPDL+XPDL);

		String cadenaTextual ="";
		//Concateno toda la estructura textual del proceso de negocio
		for (int i = 0; i < matrizTextual.length; i++) {
			for (int j = 0; j < 3; j++) {
				if(matrizTextual[i][j]!=null){
					cadenaTextual+=matrizTextual[i][j]+",";
				}

			}
		}

		//Codebook para cada uno de los posibles caminos del proceso de negocio y se concatena las transiciones
		Codebook codebook = new Codebook();
		String cadenaStructural ="";
		for (int i = 0; i < matrizCaminosActividades.length ; i++) {
			for (int i1 = 0; i1 < matrizCaminosActividades.length ; i1++) {
				if(matrizCaminosActividades[i][i1]!=null && codebook.obtenerCodebook(matrizCaminosActividades[i], 0, 3, matrizCaminosActividadesAuxiliar,0)[i1]!=null){
					cadenaStructural+=codebook.obtenerCodebook(matrizCaminosActividades[i], 0, 3, matrizCaminosActividadesAuxiliar,0)[i1]+",";
				}
			}
		}

		//Retorno de las concatenaciones de las transiciones y la estructura textual
		return cadenaStructural+"\n"+cadenaTextual;
	}
	
	
	
	

	@Override
	public ArrayList<Cluster> obtenerClustering(Consulta consulta) {
		//Creo la clase indice  para acceder a los metodos de Lucen
		LuceneIndex indice = new LuceneIndex();
		try {
			//Valido si la consulta textual es null
			if(consulta.getConsultaTextual()==null){
				consulta.setConsultaTextual("");
			}
			//Valido si la consulta estructural es null
			if(consulta.getConsultaEstructural()==null){
				consulta.setConsultaEstructural("");
			}
			//Lista de la busqueda de lucene
			File[] listaIndex =null;
			//Si consulta textual y estructural son diferentes de "" es porque es multimodal 
			if(!consulta.getConsultaEstructural().equals("") && !consulta.getConsultaTextual().equals("")){

				listaIndex = indice.search("+"+consulta.getConsultaTextual()+" "+"+"+consulta.getConsultaEstructural());

				//Si trajo algun archivo 
				if(listaIndex.length>0){
					//Realizo el clustering
					doClustering(consulta.getOptionCluster(),listaIndex,consulta);
				}
				
				
			}	
				
				if(!consulta.getConsultaEstructural().equals("")){
					listaIndex = indice.search(consulta.getConsultaEstructural());

					if(listaIndex.length>0){
						doClustering(consulta.getOptionCluster(),listaIndex,consulta);
					}	
				
				}
				
				if(!consulta.getConsultaTextual().equals("")){
					listaIndex = indice.search(consulta.getConsultaTextual());

					if(listaIndex.length>0){
						doClustering(consulta.getOptionCluster(),listaIndex,consulta);
					}	
				
				}
				
				
				
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Guardo en un nuevo arreglo la matriz de clusters
		String [][] clusterMetodo =obtenerProcesoClustering();
		//Creo un vector de clusters para pasar la informacion de la matriz del clusterMetodo 
		//Cluster[] clusters = new Cluster[clusterMetodo.length];
		ArrayList<Cluster> clusters = new ArrayList<Cluster>();
		
		//Itero el clusterMetodo
		for (int i = 0; i < clusterMetodo.length; i++) {
			//Creo un cluster metodo por cada fila de la matriz
			Cluster cluster = new Cluster();
			//seteo el nombre del cluster
			cluster.setNombreCluster("Cluster number "+i);
			//inicializo la lista de archivos que le voy a pasar al cluster
			ArrayList<Pn> listaProces = new ArrayList<Pn>();
			
			for (int j = 0; j < clusterMetodo.length; j++) {
				//si es diferente a null se crea un archivo con la ruta de la matriz
				if(clusterMetodo[i][j]!=null){
					Pn proceso = new Pn();
					File procesoArchivo = new File(clusterMetodo[i][j]);
					String contents ="";
					try {
						 contents = new Scanner(procesoArchivo).useDelimiter("\\Z").next();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					proceso.setNombre(procesoArchivo.getName());
					proceso.setContenido(contents);
				//agrego el archivo xpdl
				listaProces.add(proceso);
				//agrego la lista de archivos
				cluster.setClusterProcesos(listaProces);
				}
			}
			//seteo la cantidad de procesos por cluster
			cluster.setNumeroProcesos(cluster.getClusterProcesos().size());
		// se agrega el cluster al vector 
			if(cluster.getNumeroProcesos()!=0){
				clusters.add(cluster);
			}
			
		}
		
		return clusters;
	}


	public String[][] obtenerProcesoClustering(){
		String fileName = PATH.WRITE_CLUSTERS;
		List<String> list = new ArrayList<String>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			//br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		int i = 0;
		int j= 0;
		int auxI = 0;
		String[][] listCluster = new String[list.size()][list.size()];

		//Para cada linea del archivo del cluster
		for (String cluster : list) {
			//si es diferente de la linea cluster size, es decir cuando empieza un cluster.
			if(!cluster.contains("Cluster size ")&&cluster!=null){
				//Agrego ese elemento del cluster i y armo la ruta
				listCluster[i][j]=PATH.RUTA_REPOSITORIO_XPDL+cluster.split(".txt")[0]+".xpdl";
				//aumento la posicion que itera el vector del cluster
				j++;
			}else{
				//si es igual a la linea de cluster size, quiere decir que inicia un cluster
				//si es el primer cluster i no aumenta, se lleva la cuenta si es el primero con auxI
				auxI++;
				i=auxI>=2?i+1:0;
				//Si es un cluster nuevo quiere decir que empieza el vector en 0
				j=0;
				//Se agrega el inicio del cluster
				//listCluster[i][j]=cluster;


			}

		}
		
		return listCluster;
	}
	
	
	private boolean doClustering(String opcionClustering,File[] listaIndex,Consulta consulta){
		Clustering cluste = new Clustering();
		
		switch (Integer.parseInt(opcionClustering)) {
		/* 0= "BestStar"
		 * 1= "Cliques"
		 * 2= "FullStars" 
		 * 3= "Stars"
		 * 4= "Kmeans"
		 * 5= "Kmedoids"
		 * 6= "DBSCAN"
		 * 7= "AgglomerativeHierarchical"
		 * */
		case 0:	cluste.reutersClustering(0, 0, Double.parseDouble(consulta.getMinThreshold()), 0, 0, 0, 1, 1, 1, 2, listaIndex );break;
		case 1:	cluste.reutersClustering(1, 0, Double.parseDouble(consulta.getMinThreshold()), 0, 0, 0, 1, 1, 1, 2, listaIndex );break;
		case 2:	cluste.reutersClustering(2, 0, Double.parseDouble(consulta.getMinThreshold()), 0, 0, 0, 1, 1, 1, 2, listaIndex );break;
		case 3:	cluste.reutersClustering(3, 0, Double.parseDouble(consulta.getMinThreshold()), 0, 0, 0, 1, 1, 1, 2, listaIndex );break;
		case 4:	cluste.reutersClustering(4, 0, 0, 0,Integer.parseInt(consulta.getK()),Integer.parseInt(consulta.getIterations()), 1, 1, 1, 2, listaIndex );break;
		case 5:	cluste.reutersClustering(5, 0, 0, 0,Integer.parseInt(consulta.getK()),Integer.parseInt(consulta.getIterations()),Integer.parseInt(consulta.getCentroidStrategy()),Integer.parseInt(consulta.getFirstCentroids()), 1, 2, listaIndex );break;
		case 6:	cluste.reutersClustering(6, 0, 0, 0, 0, 0, 1, 1, Integer.parseInt(consulta.getEpsilon()), Integer.parseInt(consulta.getMinObjs()), listaIndex );break;
		case 7:	cluste.reutersClustering(7, Double.parseDouble(consulta.getThresholdLvl()),Double.parseDouble(consulta.getMinThreshold()), 1, 0, 0, 1, 1, 1, 2, listaIndex );break;

		default:
			return false;
		}
		
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	
	// Metodos 
		@SuppressWarnings("unused")
		public String analisisTextual(FileUploadEvent event){
			String listaValores="";
			ArrayList <ArrayList<String>> listaTextual = new ArrayList<ArrayList<String>>();
			ArrayList <ArrayList<String>> listaEstructural = new ArrayList<ArrayList<String>>();
			eventos=0;
			actividades=0;
			compuertas=0;
			
			try {
				dbFactory = DocumentBuilderFactory.newInstance();
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(event.getFile().getInputstream());
				String tipoActividad;
				String StartEvent;
				String IntermediateEvent;
				String EndEvent;
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
							if(!EndEvent.equals("None")){
								tipoActividad ="EndEvent"+EndEvent;
							}else{
								tipoActividad="EndEvent";
							}
						}
						eventos++;
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
						actividades++;
					}
					/////////////// BlockActivity /////////////////////////////////////////////////////////
					NodeList nodeListBlockActivity = elementActiviti.getElementsByTagName("BlockActivity");
					for (int j = 0; j < nodeListBlockActivity.getLength(); ++j){
						tipoActividad="TaskBlocActivity";
						actividades++;
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
							tipoActividad="RouteGateway"+valor1;
						}
						if (!valor2.isEmpty()) {
							tipoActividad="RouteExclusive"+valor2;
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
						compuertas++;
					}
					///// Asignar los valores a una lista de listas
					listaTextual.add(new ArrayList<String>());
					listaTextual.get(i).add(elementActivitiId);
					listaTextual.get(i).add(tipoActividad);
					listaTextual.get(i).add(elementActivitiName);
					if(!elementActivitiName.isEmpty()){
						listaValores=listaValores+" "+elementActivitiName;
					}
					
				}
				/// Imprimir valores
				
				/*for (int j = 0; j < listaTextual.size(); j++) {
					for (int k = 0; k < listaTextual.get(j).size(); k++) {
						System.out.println(listaTextual.get(j).get(k));
					}
					System.out.println();
				}
				 */

				///////////////////////////////// Estructural //////////////////////////////////////
				Document docTransiciones = dBuilder.parse(event.getFile().getInputstream());
				String fromId;
				String toId;
				String id;
				String fromString="";
				String toString="";
				NodeList nodeListTransition= docTransiciones.getElementsByTagName("Transition");
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
					listaEstructural.get(i).add(fromString+"_"+toString);	
					listaValores=listaValores+" "+fromString+"_"+toString;
					fromString="";
					toString="";
				}
				/// Imprimir valores
				/*
				for (int j = 0; j < listaEstructural.size(); j++) {
					for (int k = 0; k < listaEstructural.get(j).size(); k++) {
						System.out.println(listaEstructural.get(j).get(k));
						System.out.println();
					}
				}
				*/
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			listaValores=listaTextual.toString()+listaEstructural.toString();
			return listaValores;
		}
		
		public String cadenaClustering(){
			String cadena=eventos+" "+actividades+" "+" "+compuertas;
			return cadena;
		}

		@Transactional(readOnly = true)
		public Pn consultarPNPorNombre(String nombre) {
			return pNDAO.consultarPNporNombre(nombre);
		}
}
