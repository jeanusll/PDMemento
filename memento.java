import java.util.ArrayList;
class Memento{
    private String estado;
    public Memento (String estado){
        this.estado=estado;
    }
    public String getSavedState(){
        return estado;
    }
}

class Persona{
    private String nombre;
    public Memento saveToMemento(){
        System.out.println("Guardando Memento...");
        return new Memento (nombre);
    }
    public void restoreFromMemento (Memento m){
        nombre = m.getSavedState();
    }
    public String getNombre (){
        return nombre;
    }
   public void setNombre(String nombre){
        this.nombre = nombre;
    }
}

class Caretaker{
    private ArrayList<Memento> estados = new ArrayList<Memento>();
    public void addMemento (Memento m){
        estados.add(m);
    }
    public Memento getMemento (int index){
        return estados.get(index);
    }


    public static void main(String[] args){

        Caretaker caretaker=new Caretaker();
        Persona p=new Persona();
        p.setNombre("Maxi");
        p.setNombre("Juan");
        caretaker.addMemento (p.saveToMemento());
        p.setNombre("Pedro");
        caretaker.addMemento (p.saveToMemento());
        p.setNombre("Diego");
        System.out.println("Nombre actual de la persona: " + p.getNombre());
        Memento ml=caretaker.getMemento (0);
        Memento m2=caretaker.getMemento (1);
        System.out.println("Memento 1 ... "+ ml.getSavedState());
        System.out.println("Memento 2 ...  "+ m2.getSavedState());
     
    }
}