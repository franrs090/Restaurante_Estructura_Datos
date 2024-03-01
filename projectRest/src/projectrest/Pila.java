package projectrest;


public class Pila {
        private NodoPila top;

    //metodo para agregar
    public void push(NodoPila elemento) {
        elemento.setAbajo(top);
        top = elemento;
    }

    //metodo para validar si la pila está vacía
    public boolean PilaVacia() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        NodoPila aux = top;            
            String nombre = null;
            String s="Clientes # \n";
            while (aux!=null){
                if(nombre != aux.getElemento().getNombre()){
                    s+= "ID: "+aux.getElemento().getClienteID()+" Nombre: " + aux.getElemento().getNombre() + "\n";
                }               
                nombre = aux.getElemento().getNombre();
                aux=aux.getAbajo();
            } 
            return s;
        }
    
}
