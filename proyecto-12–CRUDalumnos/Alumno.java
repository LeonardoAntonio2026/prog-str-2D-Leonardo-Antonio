public class Alumno {

    private int id;
    private String name;
    private boolean isActive;
    private double promedio;

    public Alumno(){}

    public Alumno(int id, String name, double promedio){
        this.id=id;
        this.name=name;
        this.promedio=promedio;
        this.isActive=true; 

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getPromedio() {
        return promedio;
    }
    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Alumno [id=" + id + ", name=" + name + ", isActive=" + isActive + "]";
    }



}
