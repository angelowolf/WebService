
package edu.frc.iaew.model;

/**
 *
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.00.000 02/04/2016
 */
public class Aeropuerto {
    
    private int idAeropuerto;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String pais;

    public Aeropuerto() {}

    public Aeropuerto(int idAeropuerto, String nombre, String direccion, String ciudad, String pais) {
        this.idAeropuerto = idAeropuerto;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
    }        

    public int getId() {
        return idAeropuerto;
    }

    public void setId(int id) {
        this.idAeropuerto = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idAeropuerto;
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
        final Aeropuerto other = (Aeropuerto) obj;
        if (this.idAeropuerto != other.idAeropuerto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aeropuerto {" + "idAeropuerto=" + idAeropuerto + ", nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad + ", pais=" + pais + '}';
    }      
    
}
