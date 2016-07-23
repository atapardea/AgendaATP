
package ClaseUtilitare;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Validari {
    
    private long CNP;
    private static String stringDataNasterii;
    private static String zi;
    private static String luna;
    private static String an;
    final static String DATE_FORMAT = "dd-MM-yy";
    
    public static boolean validareCNP(long CNP){
        
        zi=Long.toString(CNP).substring(5, 7);
        luna=Long.toString(CNP).substring(3, 5);
        an=Long.toString(CNP).substring(1, 3);
        stringDataNasterii=(zi+"-"+luna+"-"+an);
        
        
        if ("1".equals(Long.toString(CNP).substring(0, 1)) || "2".equals(Long.toString(CNP).substring(0, 1)) ) {
            if (isDateValid(stringDataNasterii)){
                return true;
            }
        }
        return false;
    }
   
    
    public static boolean isDateValid(String date){

        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
}
    
    
}
