/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package reportHere.app;

import java.sql.Connection;
import reportHere.model.ConnectionManager;

public class Main {

    public static void main(String[] args) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        
        if(conn != null){
            System.out.println("Conectou!");  
        }else{
            System.out.println("Falhou!");  
        }
            
        
    }

}
