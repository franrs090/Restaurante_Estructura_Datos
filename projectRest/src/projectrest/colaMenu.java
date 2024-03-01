package projectrest;

public class colaMenu {

    NodoProductos frente;
    NodoProductos ultimo;

    public void encola(NodoProductos ordenNueva) {
        /*logica para agregar al elemento nuevo dentro de la cola 
            el elemento nuevo debe ir de ultimo*/
        if (frente == null) {
            frente = ordenNueva;
            ultimo = ordenNueva;
        } else {
            ultimo.setNext(ordenNueva);
            ultimo = ordenNueva;
        }
    }

    public NodoProductos atiente() {
        NodoProductos aux = frente;
        if (colaVacia()) {
            System.out.println("La cola está vacia");
        } else {
            if (frente != null) {
                frente = frente.getNext();
                aux.setNext(null);
            }
        }
        return aux;
    }

    public boolean colaVacia() {
        if (frente == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean existe(int id) {
        boolean esta = false;
        if (frente != null) { //si la lista existe o hay al menos un elemento
            NodoProductos aux = frente;
            while (aux != null && aux.getPlatillo().getProductID() < id) {// no es necesario igualarlo al ID ya que con solo que se salga  
                aux = aux.getNext();                           //del if ya tenemos el mismo id que el que estamos buscando
            }
            if (aux != null && aux.getPlatillo().getProductID() == id) {
                esta = true;
            }
        }
        return esta;
    }

    public NodoProductos getFrente() {
        return frente;
    }

    @Override
    public String toString() {
        NodoProductos aux = frente;
        String s = "*************************BIENVENIDOS AL RESTAURANTE******************************\n"
                + "*******************************LOS BARETICOS*************************************\n"
                + "Platillos disponibles: \n";
        while (aux != null) {
            s += aux.getPlatillo().getProductID() + "  " + aux.getPlatillo().getNombreProduct() + ",     precio: ₡ " + aux.getPlatillo().getPriceUnit() + "    Unidades: " + aux.getPlatillo().getCantidadPlatos() + "\n";
            aux = aux.getNext();
        }

        return s;
    }
}
