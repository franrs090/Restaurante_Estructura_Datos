package projectrest;


public class NodoOrden {
    Cliente datosClientes;  //sera el cliente que extreremos de la  listaClientes
    Productos cuenta;  ////sera el platillo que extreremos de la  listaMenu
    NodoOrden next;

    public NodoOrden( Cliente datosClientes, Productos cuenta) {
        this.datosClientes = datosClientes;
        this.cuenta = cuenta;
    }

    public NodoOrden() {
    }

    public Cliente getDatosClientes() {
        return datosClientes;
    }

    public void setDatosClientes(Cliente datosClientes) {
        this.datosClientes = datosClientes;
    }

    public NodoOrden getNext() {
        return next;
    }

    public void setNext(NodoOrden next) {
        this.next = next;
    }

    public Productos getCuenta() {
        return cuenta;
    }

    public void setCuenta(Productos cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "NodoOrden{" + "datosClientes=" + datosClientes + ", cuenta=" + cuenta + '}';
    }
    
    


}
