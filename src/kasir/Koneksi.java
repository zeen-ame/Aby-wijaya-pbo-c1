
package kasir;
import java.sql.*;

public class Koneksi{

public static Connection conn(){

try{

return DriverManager.getConnection(
"jdbc:mysql://localhost/kasir",
"root",
"");

}catch(Exception e){

return null;

}

}

}
