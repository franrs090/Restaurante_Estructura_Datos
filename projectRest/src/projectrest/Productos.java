package projectrest;

public class Productos {

    int productID;
    String nombreProduct;
    double priceUnit;
    int cantidadPlatos;
    double tax = 0.13;
    int Tipo; // 1- Plato principal 2- Bebidas 3- Entradas 4- Postres

    public double getTax() {
        return tax;
    }

    public Productos() {
    }

    public Productos(int productID, String nombreProduct, double priceUnit, int cantidadPlatos, int Tipo) {
        this.productID = productID;
        this.nombreProduct = nombreProduct;
        this.priceUnit = priceUnit;
        this.cantidadPlatos = cantidadPlatos;
        this.Tipo = Tipo;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getNombreProduct() {
        return nombreProduct;
    }

    public void setNombreProduct(String nombreProduct) {
        this.nombreProduct = nombreProduct;
    }

    public int getCantidadPlatos() {
        return cantidadPlatos;
    }

    public void setCantidadPlatos(int cantidadPlatos) {
        this.cantidadPlatos = cantidadPlatos;
    }

    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    @Override
    public String toString() {
        return "Productos ID: " + productID + ". " + nombreProduct + ", precio ₡ " + priceUnit + ", unidades: " + cantidadPlatos + "\n";
    }

}
