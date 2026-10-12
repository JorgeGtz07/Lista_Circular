package linkedlist;

public class LinkedList {

    public static void main(String[] args) {

        Alumnito alumn1 = new Alumnito("Jorge", 20, "001", 9.5);
        Alumnito alumn2 = new Alumnito("Alicia", 21, "002", 10.0);
        Alumnito alumn3 = new Alumnito("Karin", 19, "003", 9.0);
        Alumnito alumn4 = new Alumnito("Miguel", 22, "004", 8.5);

        ListaEnlazada<Alumnito> lista = new ListaEnlazada<>();

        lista.append(alumn1);
        lista.append(alumn2);
        lista.append(alumn3);
        lista.append(alumn4);

        System.out.println("Lista de alumnos:");
        System.out.println(lista);

        System.out.println("Ir al inicio:");
        lista.irInicio();
        System.out.println(lista.getActual());

        System.out.println("Anterior al inicio:");
        lista.previous();
        System.out.println(lista.getActual());

        System.out.println("Ir al final:");
        lista.irFinal();
        System.out.println(lista.getActual());

        System.out.println("Siguiente al final:");
        lista.next();
        System.out.println(lista.getActual());

        System.out.println("Recorrido hacia adelante:");
        lista.irInicio();

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.getActual());
            lista.next();
        }

        System.out.println("Recorrido hacia atras:");
        lista.irFinal();

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.getActual());
            lista.previous();
        }
    }
}

