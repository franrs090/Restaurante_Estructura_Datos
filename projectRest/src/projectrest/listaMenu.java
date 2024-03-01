package projectrest;

import javax.swing.JOptionPane;

public class listaMenu {

    NodoProductos cabeza;

    public void inserta(Productos p) {
        if (cabeza == null) {// si la lista esta vacia
            cabeza = new NodoProductos(p);
        } else if (p.getProductID() < cabeza.getPlatillo().getProductID()) {//si el dato a la lista va antes que la cabeza
            NodoProductos aux = new NodoProductos(p);//creo un aux con los datos de 'p'
            aux.setNext(cabeza);//coloco aux a la  izq de cabeza
            cabeza = aux;//asigno la cabeza con lo que tenia el auxiliar
        } else if (cabeza.getNext() == null) {
            //cuando por fuerza el nuevo dato en la lista va despues de mi cabeza
            cabeza.setNext(new NodoProductos(p));//referencio el next directamente a 'p'
        } else {
            NodoProductos aux = cabeza; //baso a este aux es que recorremos la lista

            //mientras NO se ACABE la lista y el dato del next sea MENOR 
            //que el dato que voy a agregar avance en la lista
            while (aux.getNext() != null
                    && aux.getNext().getPlatillo().getProductID() < p.getProductID()) {
                aux = aux.getNext();
                //cuando se salga de este while es que ya encontramos 
                //la posicion donde va el nuevo dato y aux quedará con el
                //dato que está antes de donde irá nuestro nuevo dato
            }
            NodoProductos temp = new NodoProductos(p);  //creo un nodo temp con el valor de 'p'
            temp.setNext(aux.getNext()); // enlazo temp al siguiente de temp
            aux.setNext(temp); //enlazo el siguiente de aux a temp
        }
    }

    @Override
    public String toString() {
        NodoProductos aux = cabeza;
        String s = "Platos # \n";
        while (aux != null) {
            s += aux.getPlatillo().getProductID() + "  " + aux.getPlatillo().getNombreProduct() + ",     precio: ₡ " + aux.getPlatillo().getPriceUnit() + "    Unidades: " + aux.getPlatillo().getCantidadPlatos() + "\n";
            aux = aux.getNext();
        }

        return s;
    }

    public Productos platoOrdenado(int id) {
        Productos platillo = null;
        if (cabeza != null) { //si la lista existe o hay al menos un elemento
            NodoProductos aux = cabeza;
            while (aux != null && aux.getPlatillo().getProductID() < id) {// no es necesario igualarlo al ID ya que con solo que se salga  
                aux = aux.getNext();                           //del if ya tenemos el mismo id que el que estamos buscando
            }
            if (aux != null && aux.getPlatillo().getProductID() == id) {
                platillo = aux.getPlatillo();
            }

        }
        return platillo;
    }

    public boolean existe(int id) {
        boolean esta = false;
        if (cabeza != null) { //si la lista existe o hay al menos un elemento
            NodoProductos aux = cabeza;
            while (aux != null && aux.getPlatillo().getProductID() < id) {// no es necesario igualarlo al ID ya que con solo que se salga  
                aux = aux.getNext();                           //del if ya tenemos el mismo id que el que estamos buscando
            }
            if (aux != null && aux.getPlatillo().getProductID() == id) {
                esta = true;
            }
        }
        return esta;
    }

    public void modifica(Productos p) {
        if (cabeza != null) {
            NodoProductos aux = cabeza;
            while (aux != null && aux.getPlatillo().getProductID() < p.getProductID()) {
                aux = aux.getNext();
            }
            if (aux != null && aux.getPlatillo().getProductID() == p.getProductID()) { //realmente lo unico coherente en este caso de modificar es la cantidad de platillos
                aux.getPlatillo().setCantidadPlatos(Integer.parseInt(JOptionPane.showInputDialog("Digite cuantos platillos de: " + aux.getPlatillo().getNombreProduct() + " va a querer:")));//consulto al mesero cuantos platos seran, valores numericos
            }
        }
    }

    public void elimina(int id) {
        if (cabeza != null) {
            if (cabeza.getPlatillo().getProductID() == id) {  // si el valor a eliminar es la cabeza
                cabeza = cabeza.getNext();
            } else {
                NodoProductos aux = cabeza;
                while (aux.getPlatillo().getProductID() < id) {
                    aux = aux.getNext(); //avanzo en la lista
                }
                if (aux.getNext() != null && aux.getPlatillo().getProductID() == id) { //se podra usar aux solamente?
                    aux.setNext(aux.getNext().getNext());
                }
            }//que pasa si el dato a eliminar es el ultimo?
            //vuelve a correr el caso y eliminaria el valor ya que la cabeza en ese caso seria el ultimo dato
        }
    }

    public NodoProductos getCabeza() {
        return cabeza;
    }

}
