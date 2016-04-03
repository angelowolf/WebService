package edu.frc.iaew.services;

import edu.frc.iaew.model.Aeropuerto;
import edu.frc.iaew.model.Clase;
import edu.frc.iaew.model.Vuelo;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
                add(new Vuelo(1, aeropuertos.get(0), aeropuertos.get(1), new DateTime(2016, 04, 16, 0, 0), new DateTime(2016, 04, 17, 0, 0), Clase.PRIMERA_CLASE));
                add(new Vuelo(2, aeropuertos.get(0), aeropuertos.get(2), new DateTime(2016, 04, 17, 0, 0), new DateTime(2016, 04, 19, 0, 0), Clase.TURISTA));
                add(new Vuelo(3, aeropuertos.get(0), aeropuertos.get(3), new DateTime(2016, 04, 16, 0, 0), new DateTime(2016, 04, 20, 0, 0), Clase.EJECUTIVA));
                add(new Vuelo(4, aeropuertos.get(0), aeropuertos.get(4), new DateTime(2016, 04, 16, 0, 0), new DateTime(2016, 04, 22, 0, 0), Clase.TURISTA));
                add(new Vuelo(5, aeropuertos.get(0), aeropuertos.get(5), new DateTime(2016, 04, 18, 0, 0), new DateTime(2016, 04, 21, 0, 0), Clase.PRIMERA_CLASE));
                add(new Vuelo(6, aeropuertos.get(0), aeropuertos.get(6), new DateTime(2016, 04, 17, 0, 0), new DateTime(2016, 04, 25, 0, 0), Clase.EJECUTIVA));
                add(new Vuelo(7, aeropuertos.get(0), aeropuertos.get(7), new DateTime(2016, 04, 18, 0, 0), new DateTime(2016, 04, 27, 0, 0), Clase.TURISTA));
                add(new Vuelo(8, aeropuertos.get(0), aeropuertos.get(8), new DateTime(2016, 04, 16, 0, 0), new DateTime(2016, 04, 22, 0, 0), Clase.PRIMERA_CLASE));
                add(new Vuelo(9, aeropuertos.get(0), aeropuertos.get(9), new DateTime(2016, 04, 18, 0, 0), new DateTime(2016, 04, 26, 0, 0), Clase.TURISTA));
                add(new Vuelo(10, aeropuertos.get(0), aeropuertos.get(7), new DateTime(2016, 04, 18, 0, 0), new DateTime(2016, 04, 28, 0, 0), Clase.PRIMERA_CLASE));
            }
        };

    }

    @WebMethod(operationName = "consultarVuelosPorFechaSalida")
    public String consultarVuelosPorFechaSalida(@WebParam(name = "fechaSalida") String fechaSalida) {
        DateTimeFormatter formaterr = DateTimeFormat.forPattern("dd-MM-yyyy");
        DateTime salida2;
        StringBuilder str = new StringBuilder();
        boolean flag = true;
        salida2 = formaterr.parseDateTime(fechaSalida);
        for (Vuelo cadaVuelo : vuelos) {
            if (sonIguales(cadaVuelo.getFechaSalida(), salida2)) {
                str.append(cadaVuelo.toString()).append("\n");
                flag = false;
            }
        }
        if (!flag) {
            str.append("{Sin datos}");
        }
        return str.toString();
    }

    private boolean sonIguales(DateTime salida, DateTime salida2) {
        if (salida.getYear() == salida2.getYear()) {
            if (salida.getDayOfYear() == salida2.getDayOfYear()) {
                return true;
            }
        }
        return false;
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
