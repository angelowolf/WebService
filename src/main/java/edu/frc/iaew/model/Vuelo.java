package edu.frc.iaew.model;

import org.joda.time.DateTime;

/**
 * Representa un vuelo entre dos aeropuertos.
 *
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.00.000 02/04/2016
 */
public class Vuelo {

    private int idVuelo;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private DateTime fechaSalida;
    private DateTime fechaRetorno;
    private Clase clase;

    public Vuelo() {
    }

    public Vuelo(int idVuelo, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, DateTime fechaSalida, DateTime fechaRetorno, Clase clase) {
        this.idVuelo = idVuelo;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.fechaSalida = fechaSalida;
        this.fechaRetorno = fechaRetorno;
        this.clase = clase;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public DateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(DateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public DateTime getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(DateTime fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idVuelo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vuelo other = (Vuelo) obj;
        return this.getIdVuelo() == other.getIdVuelo();
    }

    @Override
    public String toString() {
        return "Vuelo{" + "idVuelo=" + idVuelo + ", aeropuertoOrigen=" + aeropuertoOrigen + ", aeropuertoDestino=" + aeropuertoDestino + ", fechaSalida=" + fechaSalida + ", fechaRetorno=" + fechaRetorno + ", clase=" + clase + '}';
    }

    /**
     * Devuelve los aeropuertos que intervienen en este vuelo.
     *
     * @return
     * AeropuertoOrigen{aeropuertoOrigen.toString()}\nAeropuertoDestino{aeropuertoDestino.toString()}
     */
    public String getAeropuertos() {
        StringBuilder str = new StringBuilder();
        str.append("AeropuertoOrigen {");
        str.append(getAeropuertoOrigen().toString());
        str.append("}\n");
        str.append("AeropuertoDestino {");
        str.append(getAeropuertoDestino().toString());
        str.append("}");
        return str.toString();
    }
}
