package datamanagement;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import java.io.FileWriter;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import java.io.IOException;
import org.jdom.JDOMException;

/**
 * Singleton to read and write an XML 'database'.
 *
 */
public class XMLManager
{
    private static XMLManager self = null;

    private Document document;

    
    public static XMLManager getInstance()
    {
        if (self == null)
        {
            self = new XMLManager();
        }
        
        return self;
    }

    
    private XMLManager()
    {
        init();
    }
    
    
    /**
     * Ensures the XML file exists, then loads it.
     */
    public void init()
    {
        String xmlFilePath = AppProperties.getInstance().getProperties()
                .getProperty(Constants.XML_FILE_PATH_KEY);

        try
        {
            SAXBuilder builder = new SAXBuilder();
            builder.setExpandEntities(true);
            document = builder.build(xmlFilePath);
        }

        catch (JDOMException e)
        {
            System.err.printf("%s",
                    "DBMD: XMLManager : init : caught JDOMException\n");
            throw new RuntimeException(
                    "DBMD: XMLManager : init : JDOMException");
        }
        catch (IOException e)
        {
            System.err.printf("%s",
                    "DBMD: XMLManager : init : caught IOException\n");

            throw new RuntimeException("DBMD: XMLManager : init : IOException");
        }
    }

    
    public Document getDocument()
    {
        return document;
    }
    
    
    /**
     * Overwrites the entire XML file with new version.
     */
    public void saveDocument()
    {
        String xmlFilePath = AppProperties.getInstance().getProperties()
                .getProperty(Constants.XML_FILE_PATH_KEY);

        try (FileWriter fout = new FileWriter(xmlFilePath))
        {
            XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
            outputter.output(document, fout);
            fout.close();
        }
        catch (IOException ioe)
        {
            System.err.printf("%s\n",
                    "DBMD : XMLManager : saveDocument : Error saving XML to "
                            + xmlFilePath);
            throw new RuntimeException(
                    "DBMD: XMLManager : saveDocument : error writing to file");
        }
    }
}
