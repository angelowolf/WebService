
package edu.frc.iaew.model;

/**
 *
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.00.000 02/04/2016
 */
public enum Clase {
    
    TURISTA, EJECUTIVA, PRIMERA_CLASE;
    
    @Override
    public String toString() {
        switch(this) {
            case TURISTA: return "Turista";
            case EJECUTIVA: return "Ejecutiva";
            case PRIMERA_CLASE: return "Primera Clase";
            default: throw new IllegalArgumentException();
        }
    }
}
