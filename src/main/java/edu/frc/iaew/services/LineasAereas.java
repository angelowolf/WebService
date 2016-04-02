package edu.frc.iaew.services;

import edu.frc.iaew.model.Aeropuerto;
import edu.frc.iaew.model.Clase;
import edu.frc.iaew.model.Vuelo;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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

    private final List<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>() {
        {
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
        }
    };

    private List<Vuelo> vuelos = null;
    GregorianCalendar fechaSalida = new GregorianCalendar();
    GregorianCalendar fechaRetorno = new GregorianCalendar();

    public LineasAereas() {
        vuelos = new ArrayList<Vuelo>() {
            {
                fechaSalida.set(2016, 04, 16);
                fechaRetorno.set(2016, 04, 17);
                add(crearVuelo(1, fechaSalida.getTime(), fechaRetorno.getTime(), 0, 1, Clase.PRIMERA_CLASE));
                fechaSalida.set(2016, 04, 17);
                fechaRetorno.set(2016, 04, 19);
                add(crearVuelo(2, fechaSalida.getTime(), fechaRetorno.getTime(), 0, 2, Clase.TURISTA));
                fechaSalida.set(2016, 04, 16);
                fechaRetorno.set(2016, 04, 20);
                add(crearVuelo(3, fechaSalida.getTime(), fechaRetorno.getTime(), 0, 3, Clase.EJECUTIVA));
                fechaSalida.set(2016, 04, 16);
                fechaRetorno.set(2016, 04, 22);
                add(crearVuelo(4, fechaSalida.getTime(), fechaRetorno.getTime(), 0, 4, Clase.TURISTA));
                fechaSalida.set(2016, 04, 18);
                fechaRetorno.set(2016, 04, 21);
                add(crearVuelo(5, fechaSalida.getTime(), fechaRetorno.getTime(), 0, 5, Clase.PRIMERA_CLASE));
                fechaSalida.set(2016, 04, 17);
                fechaRetorno.set(2016, 04, 25);
                add(crearVuelo(6, fechaSalida.getTime(), fechaRetorno.getTime(), 0, 6, Clase.EJECUTIVA));
                fechaSalida.set(2016, 04, 17);
                fechaRetorno.set(2016, 04, 27);
                add(crearVuelo(7, fechaSalida.getTime(), fechaRetorno.getTime(), 0, 7, Clase.TURISTA));
                fechaSalida.set(2016, 04, 18);
                fechaRetorno.set(2016, 04, 22);
                add(crearVuelo(8, fechaSalida.getTime(), fechaRetorno.getTime(), 0, 8, Clase.PRIMERA_CLASE));
                fechaSalida.set(2016, 04, 18);
                fechaRetorno.set(2016, 04, 26);
                add(crearVuelo(9, fechaSalida.getTime(), fechaRetorno.getTime(), 0, 9, Clase.TURISTA));
                fechaSalida.set(2016, 04, 18);
                fechaRetorno.set(2016, 04, 28);
                add(crearVuelo(10, fechaSalida.getTime(), fechaRetorno.getTime(), 0, 7, Clase.PRIMERA_CLASE));

            }
        };

    }

    private Vuelo crearVuelo(int id, Date fechaSalida, Date fechaRetorno, int aeropuertoOrigen, int aeropuertoDestino, Clase clase) {
        return new Vuelo(id, aeropuertos.get(aeropuertoOrigen), aeropuertos.get(aeropuertoDestino), fechaSalida, fechaRetorno, clase);
    }

    @WebMethod(operationName = "consultarVuelosPorFechaSalida")
    public String consultarVuelosPorFechaSalida(@WebParam(name = "fechaSalida") Date fechaSalida) {
        StringBuilder str = new StringBuilder();
        boolean flag = true;
        for (Vuelo cadaVuelo : vuelos) {
            if (cadaVuelo.getFechaSalida().equals(fechaSalida)) {
                str.append(cadaVuelo.toString()).append("\n");
                flag = false;
            }
        }
        if (!flag) {
            str.append("{Sin datos}");
        }
        return str.toString();
    }

    @WebMethod(operationName = "consultarAeropuertosPorVuelo")
    public String consultarAeropuertosPorVuelo(@WebParam(name = "idVuelo") int idVuelo) {
        StringBuilder str = new StringBuilder();
        boolean flag = true;
        for (Vuelo cadaVuelo : vuelos) {
            if (cadaVuelo.getIdVuelo() == idVuelo) {
                str.append(cadaVuelo.getAeropuertos());
                flag = false;
                break;
            }
        }
        if (!flag) {
            str.append("{Sin datos}");
        }
        return str.toString();
    }

    @WebMethod(operationName = "consultarAeropuertosEnUnaCiudad")
    public String consultarAeropuertosEnUnaCiudad(@WebParam(name = "ciudad") String ciudad) {
        StringBuilder str = new StringBuilder();
        for (Aeropuerto aero : aeropuertos) {
            if (aero.getCiudad().equalsIgnoreCase(ciudad)) {
                str.append(aero.toString()).append("\n");
            }
        }
        return str.toString();
    }

}
