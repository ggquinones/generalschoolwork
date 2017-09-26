// General Imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
// Import For all the Lucene Stuff used
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

/**
 * This class contains all the keyword searching capabilities used in the "Reading in the Ether" Project.
 * Essentially using an "index" file made by the accompanying class in this project (IndexFiles.java), the 
 * program takes a string from the command-line and searches for it within the repository of books, library, that we have.
 * Lucene is very complex, but in layman's terms, "Indexing" takes the documents you want to search through and gets rid of stop words,
 * common words like 'the', 'and' etc as well as does other Lucene stuff in order to come up with a file which is much easier to look through
 * than just a straight word by word search of a set of documents. Analyzers are then used to "score" documents, which is basically Lucene's
 * way of scaling how relevant a document is to the keyword that is being searched for.
 * 
 * Only the top 40 books are returned because that equals a full book shelf in our project.
 * @author Gabriel Quinones-Sanchez Spring 2017
 *
 */
public class SearchFiles2 {

  private SearchFiles2(){} // private constructor (not used really)

  /**
   *  Simple Command Line Interface for Keyword Searching.
   *  Project is extracted as an executable JAR File : 
   *  -Right Click Project
   *  -Select export then Java then Runnable JAR File
   *  -Set the Launch Configuration to SearchFiles2 (or whatever you want the main class to be)
   *  -Set where you want it to extract to (this is where you name your JAR file, DONT FORGET .jar extension)
   *  
   *  After you have the executable JAR File, open up command line terminal.
   *  Go to directory where the jar file is located.
   *  Run Command:
   *  java -jar <JAR_FILE_NAME>.jar "<keyword input>" 
   *  And it will do its thing!
   * @param String keyword, only takes first input from command line i.e. args[0]
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    
	  String term = inputValidation(args);
      
	  String index = "c:\\users\\gabriel\\desktop\\index"; // path to index folder 
	  String field = "contents"; // what part of the Document you are reading, has several fields. example: path, contents, title
	  int hitsPerPage = 40;   
    
      // Lucene Stuff!
      IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(index))); 
      IndexSearcher searcher = new IndexSearcher(reader); 
      Analyzer analyzer = new StandardAnalyzer();
      QueryParser parser = new QueryParser(field, analyzer);
      Query query = parser.parse(term); // builds a query object for IndexSearcher to use
      //System.out.println("Searching for: " + query.toString(field));
      
      showTop40(hitsPerPage,query,searcher);
      reader.close();
    }

  /**
   * Returns the top 40 most relevant books based on the keyword given.
   *  
   * @param MAXHITS = max number of hits you want which is 40 in our case
   * @param query = query used in the searcher
   * @param searcher = searches Index file based on the query given
   * @throws IOException 
   */
  public static void showTop40(int MAXHITS, Query query, IndexSearcher searcher)throws IOException
  {
	  TopDocs results = searcher.search(query, MAXHITS); // Top MAXHITS results based on query
	  ScoreDoc[] hits = results.scoreDocs; // scores of matching documents	    
	  	  
	  for(int i=0;i<hits.length;i++)
	  {
		  Document doc = searcher.doc(hits[i].doc);
		  // The path of the file has the BookID we used in our DB
		  // SO, here I am extracting the last bit of the path which
		  // is the BookID. i.e. whatever is between the last "\\" in the path and
		  // before ".txt"
		  String path = doc.get("path"); 
		  String fileName = path.substring(path.lastIndexOf("\\") + 1);
		  String BookID = fileName.substring(0,fileName.length()-4);
		  System.out.println(BookID);
	  }
  }
  
  /**
   * Does all the input validation for keyword input from command line.
   * 
   * @param String [] input, which is args array from main method
   * @return Either prints out error message, and exits OR if keyword input is
   * permissible it returns that keyword as a String.
   */
  public static String inputValidation(String [] args)
  {
	  
	  if(args.length ==0)// breaks when no input is given
	    {
	    	System.out.println("No input received!");
	    	System.exit(0);
	    }
	  
	  String term = args[0];
	  term = term.trim(); // takes away excess blank spaces
	  
      if (term.length() == 0)// breaks when blank spaces are used as input
      {
    	System.out.println("Blank Spaces Cannot be a Search term! Program Terminates");
        System.exit(0); 
      }
      
      return term;
  }

}









