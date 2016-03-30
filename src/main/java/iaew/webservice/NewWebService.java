/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iaew.webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ang_2
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "getAuto")
    public Auto getAuto(@WebParam(name = "id") int id) {
        Auto a;
        switch (id) {
            case 1:
                a = new Auto(id, "ford", "focus", "negro");
                break;
            case 2:
                a = new Auto(id, "chevrolet", "corsa", "rojo");
                break;
            default:
                a = new Auto(id, "toyota", "corolla", "azul");
                break;
        }
        return a;
    }
}
