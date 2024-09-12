package model;


public class ItemList {
    private String titulo;
    private String descripcion;
    private int imgResource;
    private String slogan;

    public ItemList(String titulo, String descripcion, int imgResource, String slogan){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgResource = imgResource;
        this.slogan = slogan;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
