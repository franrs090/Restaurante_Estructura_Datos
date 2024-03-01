package projectrest;

public class NodoPila {

    Cliente elemento;
    NodoPila abajo;

    public NodoPila(Cliente elemento) {
        this.elemento = elemento;
    }

    public NodoPila() {

    }

    public NodoPila getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoPila abajo) {
        this.abajo = abajo;
    }

    public Cliente getElemento() {
        return elemento;
    }

    public void setElemento(Cliente elemento) {
        this.elemento = elemento;
    }

}
