package projectrest;

import javax.swing.JOptionPane;

public class Main {

    public static listaMenu menu = new listaMenu();
    public static listaClientes miCliente = new listaClientes();
    public static ListaOrdenCliente orden = new ListaOrdenCliente();
    public static Pila pilaClientes = new Pila();
    public static colaMenu cola = new colaMenu();

    public static void main(String[] args) {

        llenarMenuC(cola);
        llenarMenu(menu);
        mostrarMenu();

    }

    public static void mostrarMenu() {
        int numeroCliente = 1;
        int opc = 0;
        try {
            while (opc != 9) {
                opc = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "*****************BIENVENIDOS A*****************\n"
                        + "**********RESTAURANTE LOS BARETICOS************\n\n"
                        + "1. Ver el menu del Restaurante.\n"
                        + "2. Realizar una orden\n"
                        + "3. Modificar una orden\n"
                        + "4. Reporte total de ordenes\n"
                        + "5. Reporte de clientes\n"
                        + "6. Pagar factura.\n"
                        + "7. Cierre de cajas.\n"
                        + "9. Salir\n\n"
                        + "Digite su opción:"));
                switch (opc) {
                    case 1: {//mostrar menu
                        System.out.println(cola.toString());
                        break;
                    }
                    case 2: { //ordenar

                        String nombre = JOptionPane.showInputDialog(null, "A nombre de quien seria la cuenta?");

                        if (miCliente.existe(nombre) == false) {

                            miCliente.inserta(new Cliente(numeroCliente, nombre)); //inserto el cliente en la listaClientes
                            pilaClientes.push(new NodoPila(new Cliente(numeroCliente, nombre)));// push clientes en la pila
                            numeroCliente++;
                            if (miCliente.existe(nombre) == true) {
                                int numPlatillo = Integer.parseInt(JOptionPane.showInputDialog("Por favor, digame que desea ordernar?"));
                                while (menu.existe(numPlatillo) == false) {
                                    JOptionPane.showMessageDialog(null, "¡Usted ingresó un platillo incorrecto, revise!",
                                            "Opción incorrecta", JOptionPane.ERROR_MESSAGE);
                                    numPlatillo = Integer.parseInt(JOptionPane.showInputDialog("Por favor, digame que desea ordernar?"));
                                }
                                if (menu.existe(numPlatillo) == true) {
                                    Cliente clienteOrdenando = miCliente.clienteOrdenando(nombre); //obtengo quien esta ordenando y lo almaceno
                                    Productos PLATO = menu.platoOrdenado(numPlatillo); //obtengo el platillo del menu

                                    //***** aqui mismo obtenemos el precio que sera el que mandaremos por parametro al MR
                                    orden.inserta(clienteOrdenando, PLATO); //creo la listaOrden con cliente y los platillos ordenados

                                    int response = JOptionPane.showConfirmDialog(null, "¿Desea agregar otra cosa a su orden?", "Agregar platillo extra", JOptionPane.YES_NO_OPTION);
                                    while (response != JOptionPane.NO_OPTION) {
                                        int platoExtra = Integer.parseInt(JOptionPane.showInputDialog(null, "Digame que más desea ordernar?"));
                                        if (menu.existe(platoExtra) == true) {
                                            Productos PLATOe = menu.platoOrdenado(platoExtra);

                                            orden.inserta(clienteOrdenando, PLATOe);
                                            response = JOptionPane.showConfirmDialog(null, "¿Desea agregar otra cosa a su orden?", "Agregar platillo extra", JOptionPane.YES_NO_OPTION);
                                        } else {
                                            System.out.println("El platillo seleccionado no existe en el menu, favor digitar otro");
                                            response = JOptionPane.showConfirmDialog(null, "¿Desea agregar otra cosa a su orden?", "Agregar platillo extra", JOptionPane.YES_NO_OPTION);
                                        }
                                    }

                                }
                            }
                        } else {
                            int response4 = JOptionPane.showConfirmDialog(null, "Cliente existente, ¿Desea agregar otra cosa a la orden?", "Agregar platillo extra", JOptionPane.YES_NO_OPTION);

                            while (response4 != JOptionPane.NO_OPTION) {
                                int numPlatillo = Integer.parseInt(JOptionPane.showInputDialog("Por favor, digame que desea ordernar?"));
                                Cliente clienteOrdenando = miCliente.clienteOrdenando(nombre); //obtengo quien esta ordenando y lo almaceno

                                Productos PLATO = menu.platoOrdenado(numPlatillo); //obtengo el platillo del menu

                                orden.inserta(clienteOrdenando, PLATO); //creo la listaOrden con cliente y los platillos ordenados
                                response4 = JOptionPane.showConfirmDialog(null, "Cliente existente, ¿Desea agregar otra cosa a la orden?", "Agregar platillo extra", JOptionPane.YES_NO_OPTION);
                            }

                        }
                        break;
                    }
                    case 3: {// modif
                        String name = JOptionPane.showInputDialog("Digite el nombre del cliente a modificar la cuenta!");
                        if (orden.existe(name) == false) {
                            JOptionPane.showInputDialog("Cliente: " + name + " parece que no existe revise bien, Por favor.");
                        } else {
                            orden.modifica(name);
                        }
                        break;
                    }
                    case 4: {//mostrar comandas actuales
                        System.out.println(orden.toString());
                        break;
                    }
                    case 5: {//mostrar clientes

                        System.out.println(pilaClientes.toString());
                        break;
                    }
                    case 6: {//pago cuenta

                        String nombre = JOptionPane.showInputDialog("Cual cuenta vamos a pagar?");
                        System.out.println("La cuenta a nombre de: " + nombre.toUpperCase()
                                + ", es la siguente: \n" + orden.imprimeCuenta(nombre));
                        System.out.println("Por un total de: " + orden.sumarVentas(orden.getCabeza(), nombre, 0.0));

                        break;
                    }
                    case 7: {//cierre cajas
                        System.out.println(orden.toString());
                        System.out.println("Por un total en las ventas de hoy de: " + orden.cierreCajas(orden.getCabeza(), 0.0));
                        break;
                    }
                    case 9: {
                        System.exit(0);
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(null,
                                "¡Usted ingresó una opción incorrecta, revise!",
                                "Opción incorrecta", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Working ...");
        }

    }

    public static void llenarMenu(listaMenu menu) {
        menu.inserta(new Productos(1, "Chifrijo", 3200.00, 1, 1));
        menu.inserta(new Productos(2, "Arroz con camarones", 3800.00, 1, 1));
        menu.inserta(new Productos(3, "Arroz con pollo", 3900.00, 1, 1));
        menu.inserta(new Productos(4, "Picadillo de papa", 1900.00, 1, 3));
        menu.inserta(new Productos(5, "Gallo de salchichon", 2000.00, 1, 3));
        menu.inserta(new Productos(6, "Gallo de chorizo", 2000.00, 1, 3));
        menu.inserta(new Productos(7, "Arroz con mariscos", 4600.00, 1, 1));
        menu.inserta(new Productos(8, "Filet empanizado", 2700.00, 1, 1));
        menu.inserta(new Productos(9, "Filet al ajillo a plancha", 2700.00, 1, 1));
        menu.inserta(new Productos(10, "Pollo a la plancha", 2700.00, 1, 1));
        menu.inserta(new Productos(11, "Pollo a la parrilla", 2600.00, 1, 1));
        menu.inserta(new Productos(12, "Carne a la parrilla", 4900.00, 1, 1));
        menu.inserta(new Productos(13, "Rib Eye", 13900.00, 1, 1));
        menu.inserta(new Productos(14, "Tomahawk", 14500.00, 1, 1));
        menu.inserta(new Productos(15, "Dedos de pollo", 3300.00, 1, 3));
        menu.inserta(new Productos(16, "Hamburguesa de pollo", 3600.00, 1, 1));
        menu.inserta(new Productos(17, "Hamburguesa 1/4 de libra", 4200.00, 1, 1));
        menu.inserta(new Productos(18, "Hamburguesa 1/2 de libra", 5000.00, 1, 1));
        menu.inserta(new Productos(19, "Doble Hamburguesa 1/4 de libra", 5900.00, 1, 1));
        menu.inserta(new Productos(20, "Fresco Natural /dia", 1100.00, 1, 2));
        menu.inserta(new Productos(21, "Botella agua", 1100.00, 1, 2));
        menu.inserta(new Productos(22, "Cerveza Nacional", 1300.00, 1, 2));
        menu.inserta(new Productos(23, "Baldazo x6 Nacional", 5800.00, 1, 2));
        menu.inserta(new Productos(24, "Vaso de Vino", 6900.00, 1, 2));
        menu.inserta(new Productos(25, "Botella de Vino", 13900.00, 1, 2));
        menu.inserta(new Productos(26, "Patacones Mixtos", 4200.00, 1, 3));
        menu.inserta(new Productos(27, "Ceviche de pescado", 2800.00, 1, 3));
        menu.inserta(new Productos(28, "Ceviche de camaron", 3000.00, 1, 3));
        menu.inserta(new Productos(29, "Ceviche Mixto", 3500.00, 1, 3));
    }

    public static void llenarMenuC(colaMenu menu) {
        cola.encola(new NodoProductos(new Productos(1, "Chifrijo", 3200.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(2, "Arroz con camarones", 3800.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(3, "Arroz con pollo", 3900.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(4, "Picadillo de papa", 1900.00, 1, 3)));
        cola.encola(new NodoProductos(new Productos(5, "Gallo de salchichon", 2000.00, 1, 3)));
        cola.encola(new NodoProductos(new Productos(6, "Gallo de chorizo", 2000.00, 1, 3)));
        cola.encola(new NodoProductos(new Productos(7, "Arroz con mariscos", 4600.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(8, "Filet empanizado", 2700.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(9, "Filet al ajillo a plancha", 2700.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(10, "Pollo a la plancha", 2700.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(11, "Pollo a la parrilla", 2600.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(12, "Carne a la parrilla", 4900.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(13, "Rib Eye", 13900.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(14, "Tomahawk", 14500.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(15, "Dedos de pollo", 3300.00, 1, 3)));
        cola.encola(new NodoProductos(new Productos(16, "Hamburguesa de pollo", 3600.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(17, "Hamburguesa 1/4 de libra", 4200.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(18, "Hamburguesa 1/2 de libra", 5000.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(19, "Doble Hamburguesa 1/4 de libra", 5900.00, 1, 1)));
        cola.encola(new NodoProductos(new Productos(20, "Fresco Natural /dia", 1100.00, 1, 2)));
        cola.encola(new NodoProductos(new Productos(21, "Botella agua", 1100.00, 1, 2)));
        cola.encola(new NodoProductos(new Productos(22, "Cerveza Nacional", 1300.00, 1, 2)));
        cola.encola(new NodoProductos(new Productos(23, "Baldazo x6 Nacional", 5800.00, 1, 2)));
        cola.encola(new NodoProductos(new Productos(24, "Vaso de Vino", 6900.00, 1, 2)));
        cola.encola(new NodoProductos(new Productos(25, "Botella de Vino", 13900.00, 1, 2)));
        cola.encola(new NodoProductos(new Productos(26, "Patacones Mixtos", 4200.00, 1, 3)));
        cola.encola(new NodoProductos(new Productos(27, "Ceviche de pescado", 2800.00, 1, 3)));
        cola.encola(new NodoProductos(new Productos(28, "Ceviche de camaron", 3000.00, 1, 3)));
        cola.encola(new NodoProductos(new Productos(29, "Ceviche Mixto", 3500.00, 1, 3)));
    }

}
