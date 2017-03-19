package co.edu.usb.clusterbp.control;

import co.edu.usb.clusterbp.*;
import co.edu.usb.clusterbp.dto.PnTxtDTO;
import co.edu.usb.dataaccess.api.DaoException;
import co.edu.usb.dataaccess.dao.*;
import co.edu.usb.exceptions.*;
import co.edu.usb.utilities.Utilities;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("PnTxtLogic")
public class PnTxtLogic implements IPnTxtLogic {
	private static final Logger log = LoggerFactory.getLogger(PnTxtLogic.class);

	/**
	 * DAO injected by Spring that manages PnTxt entities
	 *
	 */
	@Autowired
	private IPnTxtDAO pnTxtDAO;

	/**
	 * Logic injected by Spring that manages Pn entities
	 *
	 */
	@Autowired
	IPnLogic logicPn1;

	@Transactional(readOnly = true)
	public List<PnTxt> getPnTxt() throws Exception {
		log.debug("finding all PnTxt instances");

		List<PnTxt> list = new ArrayList<PnTxt>();

		try {
			list = pnTxtDAO.findAll();
		} catch (Exception e) {
			log.error("finding all PnTxt failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL +
					"PnTxt");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePnTxt(PnTxt entity) throws Exception {
		log.debug("saving PnTxt instance");

		try {
			if (entity.getPn() == null) {
				throw new ZMessManager().new ForeignException("pn");
			}


			if (entity.getPn().getPnCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("pnCodigo_Pn");
			}


			pnTxtDAO.save(entity);

			log.debug("save PnTxt successful");
		} catch (Exception e) {
			log.error("save PnTxt failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePnTxt(PnTxt entity) throws Exception {
		log.debug("deleting PnTxt instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("PnTxt");
		}

		if (entity.getPnTxtCodigo() == null) {
			throw new ZMessManager().new EmptyFieldException("pnTxtCodigo");
		}

		try {
			pnTxtDAO.delete(entity);

			log.debug("delete PnTxt successful");
		} catch (Exception e) {
			log.error("delete PnTxt failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePnTxt(PnTxt entity) throws Exception {
		log.debug("updating PnTxt instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("PnTxt");
			}

			if (entity.getPn() == null) {
				throw new ZMessManager().new ForeignException("pn");
			}

			if (entity.getPnTxtCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("pnTxtCodigo");
			}

			if ((entity.getTexto() != null) &&
					(Utilities.checkWordAndCheckWithlength(entity.getTexto(),
							255) == false)) {
				throw new ZMessManager().new NotValidFormatException("texto");
			}

			if (entity.getPn().getPnCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("pnCodigo_Pn");
			}

			pnTxtDAO.update(entity);

			log.debug("update PnTxt successful");
		} catch (Exception e) {
			log.error("update PnTxt failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<PnTxtDTO> getDataPnTxt() throws Exception {
		try {
			List<PnTxt> pnTxt = pnTxtDAO.findAll();

			List<PnTxtDTO> pnTxtDTO = new ArrayList<PnTxtDTO>();

			for (PnTxt pnTxtTmp : pnTxt) {
				PnTxtDTO pnTxtDTO2 = new PnTxtDTO();

				pnTxtDTO2.setPnTxtCodigo(pnTxtTmp.getPnTxtCodigo());
				pnTxtDTO2.setTexto((pnTxtTmp.getTexto() != null)
						? pnTxtTmp.getTexto() : null);
				pnTxtDTO2.setPnCodigo_Pn((pnTxtTmp.getPn().getPnCodigo() != null)
						? pnTxtTmp.getPn().getPnCodigo() : null);
				pnTxtDTO.add(pnTxtDTO2);
			}

			return pnTxtDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public PnTxt getPnTxt(Long pnTxtCodigo) throws Exception {
		log.debug("getting PnTxt instance");

		PnTxt entity = null;

		try {
			entity = pnTxtDAO.findById(pnTxtCodigo);
		} catch (Exception e) {
			log.error("get PnTxt failed", e);
			throw new ZMessManager().new FindingException("PnTxt");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<PnTxt> findPagePnTxt(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		List<PnTxt> entity = null;

		try {
			entity = pnTxtDAO.findPage(sortColumnName, sortAscending, startRow,
					maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PnTxt Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberPnTxt() throws Exception {
		Long entity = null;

		try {
			entity = pnTxtDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PnTxt Count");
		} finally {
		}

		return entity;
	}


	@Transactional(readOnly = true)
	public List<PnTxt> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		List<PnTxt> list = new ArrayList<PnTxt>();
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
			list = pnTxtDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	//TODO: Metodos

	@Transactional(readOnly = true)
	public String crearTxt(String texto, Pn pn) throws Exception{       
		try {
			PnTxt pnTxt = new PnTxt();
			pnTxt.setPn(pn);
			pnTxt.setTexto(texto);
			savePnTxt(pnTxt);
		} catch (DaoException e) {
			log.error(e.toString());
		}
		/*
		String ruta="C:/Users/Felipe/Desktop/"+nombreArchivo+".txt";
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
		    writer.write(listaTextual.toString());
		    writer.write(listaEstructural.toString());
		    writer.close();
		} catch (IOException e) {
		  e.printStackTrace();
		}
		 */
		return "";
	}
	
	@Transactional(readOnly = true)
	public String createDirectory(){
		// Construct a RAMDirectory to hold the in-memory representation
		// of the index.
		RAMDirectory idx = new RAMDirectory();

		try {
			// Make an writer to create the index
			IndexWriter writer =
					new IndexWriter(idx, 
							new StandardAnalyzer(Version.LUCENE_30), 
							IndexWriter.MaxFieldLength.LIMITED);

			addDocument(writer);

			// Optimize and close the writer to finish building the index
			writer.optimize();
			writer.close();

			// Build an IndexSearcher using the in-memory index
			Searcher searcher = new IndexSearcher(idx);

			// Run some queries
			search(searcher, "Pizza");

			searcher.close();
		}
		catch (IOException ioe) {
			// In this example we aren't really doing an I/O, so this
			// exception should never actually be thrown.
			ioe.printStackTrace();
		}
		catch (ParseException pe) {
			pe.printStackTrace();
		}
		return "";
	}
	
	@Transactional(readOnly = true)
	public String addDocument(IndexWriter writer){

		long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
		TInicio = System.currentTimeMillis(); //Tomamos la hora en que inicio el algoritmo y la almacenamos en la variable inicio

		try {
			List <PnTxt> pnTxtList= getPnTxt();
			for(PnTxt pnTxt: pnTxtList){
				writer.addDocument(createDocument( pnTxt.getPn().getTitulo(),pnTxt.getTexto()));
			}

			// Add some Document objects containing quotes
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
		tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
		System.out.println("Tiempo de ejecución en milisegundos: " + tiempo); //Mostramos en pantalla el tiempo de ejecución en milisegundos

		return "";
	}
	
	@Transactional(readOnly = true)
	private static Document createDocument(String title, String content) {
		Document doc = new Document();

		// Add the title as an unindexed field...

		doc.add(new Field("title", title, Field.Store.YES, Field.Index.NO));


		// ...and the content as an indexed field. Note that indexed
		// Text fields are constructed using a Reader. Lucene can read
		// and index very large chunks of text, without storing the
		// entire content verbatim in the index. In this example we
		// can just wrap the content string in a StringReader.
		doc.add(new Field("content", content, Field.Store.YES, Field.Index.ANALYZED));

		return doc;
	}
	
	@Transactional (readOnly = false, propagation = Propagation.REQUIRED)
	private static void search(Searcher searcher, String queryString)
			throws ParseException, IOException {

		// Build a Query object
		QueryParser parser = new QueryParser(Version.LUCENE_30, 
				"content", 
				new StandardAnalyzer(Version.LUCENE_30));
		Query query = parser.parse(queryString);


		int hitsPerPage = 10;
		// Search for the query
		TopScoreDocCollector collector = TopScoreDocCollector.create(5 * hitsPerPage, false);
		searcher.search(query, collector);

		ScoreDoc[] hits = collector.topDocs().scoreDocs;

		int hitCount = collector.getTotalHits();
		System.out.println(hitCount + " total matching documents");

		// Examine the Hits object to see if there were any matches

		if (hitCount == 0) {
			System.out.println(
					"No matches were found for \"" + queryString + "\"");
		} else {
			System.out.println("Hits for \"" +
					queryString + "\" were found in quotes by:");

			// Iterate over the Documents in the Hits object
			for (int i = 0; i<hitCount; i++) {
				ScoreDoc scoreDoc = hits[i];
				int docId = scoreDoc.doc;
				float docScore = scoreDoc.score;
				System.out.println("docId: " + docId + "\t" + "docScore: " + docScore);

				Document doc = searcher.doc(docId);

				// Print the value that we stored in the "title" field. Note
				// that this Field was not indexed, but (unlike the
				// "contents" field) was stored verbatim and can be
				// retrieved.
				System.out.println("  " + (i + 1) + ". " + doc.get("title"));
				System.out.println("Content: " + doc.get("content"));            
			}
		}
		System.out.println();
	}
}
