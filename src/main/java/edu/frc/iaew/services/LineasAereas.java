
package edu.frc.iaew.services;

import edu.frc.iaew.model.Aeropuerto;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.00.000 02/04/2016
 */
@WebService(serviceName = "LineasAereas")
public class LineasAereas {
    
    private List<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>() {{
        add(new Aeropuerto(1, "Ministro Pistarini", "Av. Voz del interior 2038", "Cordoba", "Argentina"));
        add(new Aeropuerto(2, "Guarulhos", "Av. do Libertador 4124", "Sao Paolo", "Brasil"));
        add(new Aeropuerto(3, "Flughafen Frankfurt am Main", "Querspange Kelsterbach", "Frankfurt", "Alemania"));
        add(new Aeropuerto(4, "Aeropuerto Internacional Ezeiza", "Au. Tte. Gral. Pablo Ricchieri", "Buenos Aires", "Argentina"));
        add(new Aeropuerto(5, "Aeroparque Jorge Newbery", "Av. Int. Cantilo", "Buenos Aires", "Argentina"));
        add(new Aeropuerto(6, "Charles De Gaulle Airport", "Autoroute du Nord", "Paris", "Francia"));
        add(new Aeropuerto(7, "Orly", "Avenue de l'Aeroport", "Paris", "Francia"));
        add(new Aeropuerto(8, "John F Kennedy International Airport", "JFK Expressway", "New York", "Estados Unidos"));
        add(new Aeropuerto(9, "LaGuardia Airport", "Grand Central Parkway", "New York", "Estados Unidos"));
        add(new Aeropuerto(10, "LLong Island MacArthur Airport", "Arrival Ave", "New York", "Estados Unidos"));
    }};

    @WebMethod(operationName = "consultarAeropuertosEnUnaCiudad")
    public String consultarAeropuertosEnUnaCiudad(@WebParam(name = "ciudad") String ciudad) {
        ArrayList<Aeropuerto> aerosEnCiudad = new ArrayList<>();
        for(Aeropuerto aero : aeropuertos) {
            if(aero.getCiudad().equalsIgnoreCase(ciudad)) 
                aerosEnCiudad.add(aero);
        }
        
        StringBuilder str = new StringBuilder();
        for(Aeropuerto aero : aerosEnCiudad)
            str.append(aero.toString() + "\n");
        return str.toString();
    }
      
}
