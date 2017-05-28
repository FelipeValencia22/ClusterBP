package co.edu.usb.clusterbp.index;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import com.sun.faces.facelets.util.Path;

import co.edu.usb.clusterbp.configuracion.PATH;

/**Esta clase se utiliza para probar la capacidad de indexación 
 * y búsqueda de biblioteca de Lucene.*/
public class LuceneIndex {
	
   String indexDir = PATH.RUTA_INDEX;
   String dataDir = PATH.RUTA_REPOSITORIO_TXT;
   Indexer indexer;
   Searcher searcher;
   
   
  public void createIndex(String contenidoProceso) throws IOException{
      indexer = new Indexer(indexDir);
      int numIndexed;
      long startTime = System.currentTimeMillis();	
      numIndexed = indexer.createIndex(dataDir, new TextFileFilter(),contenidoProceso);
      long endTime = System.currentTimeMillis();
      indexer.close();
      System.out.println(numIndexed+" File indexed, time taken: "
         +(endTime-startTime)+" ms");		
   }

  public  File[] search(String searchQuery) throws IOException, ParseException{
	  searcher = new Searcher(indexDir);
      long startTime = System.currentTimeMillis();
      TopDocs hits = searcher.search(searchQuery);
      long endTime = System.currentTimeMillis();
      System.out.println(hits.totalHits +
         " documents found. Time :" + (endTime - startTime));
      File[] listIndex = new File[hits.totalHits];
      int i = 0;
      for(ScoreDoc scoreDoc : hits.scoreDocs) {
         Document doc = searcher.getDocument(scoreDoc);
            System.out.println("File: "
            + doc.get(LuceneConstants.FILE_PATH));
            listIndex[i] = new File(doc.get(LuceneConstants.FILE_PATH));
            i++;
      }
      searcher.close();
      return listIndex;
  }
}