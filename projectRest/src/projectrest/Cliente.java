package projectrest;


public class Cliente {
    int clienteID;
    String nombre; //nuevo dato que sera el identificador de la factura 
    

    public Cliente() {
    }

    public Cliente(int clienteID, String nombre) {
        this.clienteID = clienteID;
        this.nombre = nombre;
        
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clienteID=" + clienteID + ", nombre=" + nombre + '}';
    }

    
    
    
}
