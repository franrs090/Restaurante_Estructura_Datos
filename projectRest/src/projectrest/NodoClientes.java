package projectrest;

public class NodoClientes {
    Cliente persona;
    NodoClientes next;

    public NodoClientes(Cliente persona) {
        this.persona = persona;
    }

    public NodoClientes() {
    }

    public Cliente getPersona() {
        return persona;
    }

    public void setPersona(Cliente persona) {
        this.persona = persona;
    }

    public NodoClientes getNext() {
        return next;
    }

    public void setNext(NodoClientes next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodoClientes{" + "persona=" + persona + '}';
    }
    
    
}
