package projectrest;

import javax.swing.JOptionPane;

//esta lista clientes manejara el total de clientes que se atendieron en todo el dia del bar
//el clientID es importante unicamente para insertar en la lista ya que lo que usaremos para 
//comparar dentro de la lista seran los nombres y con ellos trabajaremos para buscar o extraer
public class listaClientes {

    NodoClientes cabeza;

    public void inserta(Cliente p) {
        if (cabeza == null) {// si la lista esta vacia
            cabeza = new NodoClientes(p);
        } else if (p.getClienteID() < cabeza.getPersona().getClienteID()) {//si el dato a la lista va antes que la cabeza
            NodoClientes aux = new NodoClientes(p);//creo un aux con los datos de 'p'
            aux.setNext(cabeza);//coloco aux a la  izq de cabeza
            cabeza = aux;//asigno la cabeza con lo que tenia el auxiliar
        } else if (cabeza.getNext() == null) {
            //cuando por fuerza el nuevo dato en la lista va despues de mi cabeza
            cabeza.setNext(new NodoClientes(p));//referencio el next directamente a 'p'
        } else {
            NodoClientes aux = cabeza; //baso a este aux es que recorremos la lista

            //mientras NO se ACABE la lista y el dato del next sea MENOR 
            //que el dato que voy a agregar avance en la lista
            while (aux.getNext() != null
                    && aux.getNext().getPersona().getClienteID() < p.getClienteID()) {
                aux = aux.getNext();
                //cuando se salga de este while es que ya encontramos 
                //la posicion donde va el nuevo dato y aux quedará con el
                //dato que está antes de donde irá nuestro nuevo dato
            }
            NodoClientes temp = new NodoClientes(p);  //creo un nodo temp con el valor de 'p'
            temp.setNext(aux.getNext()); // enlazo temp al siguiente de temp
            aux.setNext(temp); //enlazo el siguiente de aux a temp
        }
    }

    @Override
    public String toString() {
        NodoClientes aux = cabeza;
        String s = "Clientes # \n";
        while (aux != null) {
            s += aux.getPersona().getClienteID() + " Nombre: " + aux.getPersona().getNombre() + "\n";
            aux = aux.getNext();
        }

        return s;
    }

    public Cliente clienteOrdenando(String nombre) {
        Cliente c = null;
        if (cabeza != null) { //si la lista existe o hay al menos un elemento
            NodoClientes aux = cabeza;
            while (aux != null && !aux.getPersona().getNombre().contentEquals(nombre)) {//recorrera el while hasta que aux en nombre sea igual al nobmbre  
                aux = aux.getNext();
            }
            if (aux != null && aux.getPersona().getNombre().contentEquals(nombre)) {//
                c = aux.getPersona();
            }

        }
        return c;
    }

    public boolean existe(String nombre) {
        boolean esta = false;
        if (cabeza != null) { //si la lista existe o hay al menos un elemento
            NodoClientes aux = cabeza;
            while (aux != null && !aux.getPersona().getNombre().contentEquals(nombre)) {//recorrera el while hasta que aux en nombre sea igual al nobmbre  
                aux = aux.getNext();
            }
            if (aux != null && aux.getPersona().getNombre().contentEquals(nombre)) {//
                esta = true;
            }
        }
        return esta;
    }

    public void modifica(Cliente p) {
        if (cabeza != null) {
            NodoClientes aux = cabeza;
            while (aux != null && aux.getPersona().getClienteID() < p.getClienteID()) {
                aux = aux.getNext();
            }
            if (aux != null && aux.getPersona().getClienteID() == p.getClienteID()) { //realmente lo unico coherente en este caso de modificar es la cantidad de platillos
                aux.getPersona().setNombre(JOptionPane.showInputDialog("Digite el nuevo nombre del cliente."));//consulto al mesero cuantos platos seran, valores numericos
            }
        }
    }

    public void elimina(String nombreCliente) {
        if (cabeza != null) {
            if (cabeza.getPersona().getNombre().contentEquals(nombreCliente)) {  // si el valor a eliminar es la cabeza
                cabeza = cabeza.getNext();
            } else {
                NodoClientes aux = cabeza;
                while (!aux.getPersona().getNombre().contentEquals(nombreCliente)) {
                    aux = aux.getNext(); //avanzo en la lista
                }
                if (aux.getNext() != null && aux.getPersona().getNombre().contentEquals(nombreCliente)) { //si lo que contiene aux en nombre es igual al nombre
                    aux.setNext(aux.getNext().getNext());
                }
            }//que pasa si el dato a eliminar es el ultimo?
            //vuelve a correr el caso y eliminaria el valor ya que la cabeza en ese caso seria el ultimo dato
        }
    }

    public NodoClientes getCabeza() {
        return cabeza;
    }

}
