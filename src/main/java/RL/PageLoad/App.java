package RL.PageLoad;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

		Fillo fillo = new Fillo();
		try {
		Connection connection=fillo.getConnection(System.getProperty("user.dir")+"\\TestData.xls");
		String strQuery = "Select * from CC_URLs";
		Recordset recordset = connection.executeQuery(strQuery);
		
		
		while (recordset.next()) {
		System.out.println(recordset.getField("URL"));
		//driver.get(recordset.getField("URL"));
		//String pageTitle=driver.getTitle();
		//System.out.println(pageTitle);
		}

		recordset.close();
		connection.close();
		
		
		} catch (FilloException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
    }
}
