package projectrest;

import javax.swing.JOptionPane;

public class ListaOrdenCliente {

    NodoOrden cabeza;

    public void inserta(Cliente cl, Productos p) {
        if (cabeza == null) {// si la lista esta vacia
            cabeza = new NodoOrden(cl, p);
        } else if (cl.getClienteID() < cabeza.getDatosClientes().getClienteID()) {//si el dato a la lista va antes que la cabeza
            NodoOrden aux = new NodoOrden(cl, p);//creo un aux con los datos de 'p'
            aux.setNext(cabeza);//coloco aux a la  izq de cabeza
            cabeza = aux;//asigno la cabeza con lo que tenia el auxiliar
        } else if (cabeza.getNext() == null) {
            //cuando por fuerza el nuevo dato en la lista va despues de mi cabeza
            cabeza.setNext(new NodoOrden(cl, p));//referencio el next directamente a 'p'
        } else {
            NodoOrden aux = cabeza; //baso a este aux es que recorremos la lista

            //mientras NO se ACABE la lista y el dato del next sea MENOR 
            //que el dato que voy a agregar avance en la lista
            while (aux.getNext() != null
                    && aux.getNext().getDatosClientes().getClienteID() < cl.getClienteID()) {
                aux = aux.getNext();
                //cuando se salga de este while es que ya encontramos 
                //la posicion donde va el nuevo dato y aux quedará con el
                //dato que está antes de donde irá nuestro nuevo dato
            }
            NodoOrden temp = new NodoOrden(cl, p);  //creo un nodo temp con el valor de 'p'
            temp.setNext(aux.getNext()); // enlazo temp al siguiente de temp
            aux.setNext(temp); //enlazo el siguiente de aux a temp
        }
    }

    public NodoOrden getCabeza() {
        return cabeza;
    }

    @Override
    public String toString() {
        NodoOrden aux = cabeza;
        String nombre = null;
        String s = "Ordenes # \n";
        while (aux != null) {
            if (nombre != aux.datosClientes.getNombre()) {
                s += "Cliente: " + aux.getDatosClientes().getNombre() + "\n";
            }
            s += aux.getCuenta();
            nombre = aux.datosClientes.getNombre();
            aux = aux.getNext();
        }
        return s;
    }

    public String imprimeCuenta(String cliente) {// acomodar toString
        NodoOrden aux = cabeza;
        String s = "Cliente: " + cliente.toUpperCase() + " \n";
        while (aux != null) {
            if (aux.datosClientes.getNombre().equals(cliente)) {
                s += "ID: " + aux.getCuenta().getProductID() + " "
                        + "Producto: " + aux.getCuenta().getNombreProduct() + " "
                        + "Precio: " + aux.getCuenta().getPriceUnit() + " "
                        + "cant " + aux.getCuenta().getCantidadPlatos() + "\n";
            }
            aux = aux.getNext();
        }
        return s;
    }

    public boolean existe(String nombreCliente) {
        boolean esta = false;
        if (cabeza != null) { //si la lista existe o hay al menos un elemento
            NodoOrden aux = cabeza;
            while (aux != null && !aux.getDatosClientes().getNombre().equals(nombreCliente)) {// no es necesario igualarlo al ID ya que con solo que se salga  
                aux = aux.getNext();                           //del if ya tenemos el mismo id que el que estamos buscando
            }
            esta = true;
        }
        return esta;
    }

    public void modifica(String cliente) {
        if (cabeza != null) {
            NodoOrden aux = cabeza;
            String cuenta = null;
            while (aux != null && !aux.getDatosClientes().getNombre().equals(cliente)) {
                aux = aux.getNext();
            }
            if (aux != null && aux.getDatosClientes().getNombre().equals(cliente)) { //realmente lo unico coherente en este caso de modificar es la cantidad de platillos

                int response = JOptionPane.showConfirmDialog(null, "Nombre actual: " + aux.getDatosClientes().getNombre()
                        + "\n¿Desea cambiar el nombre del Cliente?", "Modificar Cliente", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    aux.getDatosClientes().setNombre(JOptionPane.showInputDialog(null, "Nombre actual: " + aux.getDatosClientes().getNombre()
                            + "\nDigite nuevo nombre:", "Modificar Cliente", JOptionPane.QUESTION_MESSAGE));
                }

                int response3 = JOptionPane.showConfirmDialog(null, imprimeCuenta(cliente)
                        + "\n¿Desea eliminar algún producto de la orden?", "Modificar Cuenta", JOptionPane.YES_NO_OPTION);
                if (response3 == JOptionPane.YES_OPTION) {
                    int plato = Integer.parseInt(JOptionPane.showInputDialog(null, imprimeCuenta(cliente)
                            + "\nDigite el platillo a eliminar:", "Modificar Cuenta", JOptionPane.QUESTION_MESSAGE));
                    eliminaPRODUCTO(plato, cliente);
                }
            }
        }
    }

    public void eliminaPRODUCTO(int prodID, String nombre) {
        if (cabeza != null) {
            if (cabeza.getDatosClientes().getNombre().equals(nombre) && cabeza.getCuenta().getProductID() == prodID) {
                cabeza = cabeza.getNext();
            } else {
                NodoOrden aux = cabeza;
                while (aux != null) {
                    if (aux.getNext().getDatosClientes().getNombre().equals(nombre)
                            && aux.getNext().getCuenta().getProductID() == prodID) {
                        aux.setNext(aux.getNext().getNext());
                        break;
                    }
                    aux = aux.getNext();
                }
            }
        }
    }

    public double sumarVentas(NodoOrden h, String nombre, double total) {
        if (h.getNext() == null) {
            if (h.getDatosClientes().getNombre().equals(nombre)) {
                total += h.getCuenta().getPriceUnit() + (h.getCuenta().getPriceUnit() * h.getCuenta().getTax());
            }
            return total;
        } else {
            if (h.getDatosClientes().getNombre().equals(nombre)) {
                total += h.getCuenta().getPriceUnit() + (h.getCuenta().getPriceUnit() * h.getCuenta().getTax());
            }
            return sumarVentas(h.getNext(), nombre, total);
        }
    }

    public double cierreCajas(NodoOrden h, double total) {
        if (h.getNext() == null) {
            return total + h.getCuenta().getPriceUnit() + (h.getCuenta().getPriceUnit() * h.getCuenta().getTax());
        } else {
            total += h.getCuenta().getPriceUnit() + (h.getCuenta().getPriceUnit() * h.getCuenta().getTax());
            return cierreCajas(h.getNext(), total);
        }
    }

}
