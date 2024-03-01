
package projectrest;


public class NodoProductos {
    Productos platillo;
    NodoProductos next;
    
    public NodoProductos(Productos platillo) {
        this.platillo = platillo;
    }

    public NodoProductos() {
    }

    public Productos getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Productos platillo) {
        this.platillo = platillo;
    }

    public NodoProductos getNext() {
        return next;
    }

    public void setNext(NodoProductos next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodoProductos{" + "platillo=" + platillo + '}';
    }
    
    
}
