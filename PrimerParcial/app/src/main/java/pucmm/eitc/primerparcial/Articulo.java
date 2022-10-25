package pucmm.eitc.primerparcial;

public class Articulo {
    private String articulo;
    private String descripcion;
    private Integer precio;

    public Articulo(String articulo, String descripcion, Integer precio) {
        this.articulo = articulo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
