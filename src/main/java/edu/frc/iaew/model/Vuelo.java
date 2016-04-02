
package edu.frc.iaew.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.00.000 02/04/2016
 */
public class Vuelo {
    
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private Date fechaSalida;
    private Date fechaRetorno;
    private Clase clase;

    public Vuelo() {}

    public Vuelo(Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, Date fechaSalida, Date fechaRetorno, Clase clase) {
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.fechaSalida = fechaSalida;
        this.fechaRetorno = fechaRetorno;
        this.clase = clase;
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

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(Date fechaRetorno) {
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
        hash = 97 * hash + Objects.hashCode(this.aeropuertoOrigen);
        hash = 97 * hash + Objects.hashCode(this.aeropuertoDestino);
        hash = 97 * hash + Objects.hashCode(this.fechaSalida);
        hash = 97 * hash + Objects.hashCode(this.fechaRetorno);
        hash = 97 * hash + Objects.hashCode(this.clase);
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
        if (!Objects.equals(this.aeropuertoOrigen, other.aeropuertoOrigen)) {
            return false;
        }
        if (!Objects.equals(this.aeropuertoDestino, other.aeropuertoDestino)) {
            return false;
        }
        if (!Objects.equals(this.fechaSalida, other.fechaSalida)) {
            return false;
        }
        if (!Objects.equals(this.fechaRetorno, other.fechaRetorno)) {
            return false;
        }
        if (this.clase != other.clase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vuelo {" + "aeropuertoOrigen=" + aeropuertoOrigen + ", aeropuertoDestino=" + aeropuertoDestino + ", fechaSalida=" + fechaSalida + ", fechaRetorno=" + fechaRetorno + ", clase=" + clase + '}';
    }
    
    
    
}
