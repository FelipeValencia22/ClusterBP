package co.edu.usb.clusterbp.index;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.Similarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * Esta clase se utiliza para indexar los datos en
 * bruto para que podamos facilitar 
 * las búsquedas utilizando la biblioteca de Lucene.
 */
public class Indexer {

	private IndexWriter writer;
	private IndexWriterConfig indexConfig;

	public Indexer(String indexDirectoryPath) throws IOException{
		Similarity similar = Similarity.getDefault();
		Directory indexDirectory = 
				FSDirectory.open(new File(indexDirectoryPath));
		Analyzer anilizer = new StandardAnalyzer(Version.LUCENE_36);
		indexConfig = new IndexWriterConfig(Version.LUCENE_36, anilizer);
		indexConfig.setSimilarity(similar);
		writer = new IndexWriter(indexDirectory, indexConfig);
		writer.setSimilarity(similar);

	}

	public void close() throws CorruptIndexException, IOException{
		writer.close();
	}

	private Document getDocument(File file,String content) throws IOException{
		Document document = new Document();

		//index file contents
		Field contentField = new Field(LuceneConstants.CONTENTS, 
				content,Field.Store.YES,Field.Index.ANALYZED);
		//index file name
		Field fileNameField = new Field(LuceneConstants.FILE_NAME,
				file.getName(),
				Field.Store.YES,Field.Index.NOT_ANALYZED);
		//index file path
		Field filePathField = new Field(LuceneConstants.FILE_PATH,
				file.getCanonicalPath(),
				Field.Store.YES,Field.Index.NOT_ANALYZED);
		
		
		document.add(contentField);
		document.add(fileNameField);
		document.add(filePathField);

		return document;
	}   

	private void indexFile(File file,String content) throws IOException{
		System.out.println("Indexing "+file.getCanonicalPath());
		Document document = getDocument(file, content);
		writer.addDocument(document);
	}

	public int createIndex(String dataDirPath, FileFilter filter,String content) 
			throws IOException{
		//get all files in the data directory
		File[] files = new File(dataDirPath).listFiles();

		for (File file : files) {
			if(!file.isDirectory()
					&& !file.isHidden()
					&& file.exists()
					&& file.canRead()
					&& filter.accept(file)
					){
				indexFile(file,content);
			}
		}
		return writer.numDocs();
	}
}