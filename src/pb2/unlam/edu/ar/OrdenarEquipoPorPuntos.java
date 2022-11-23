package pb2.unlam.edu.ar;

import java.util.Comparator;

public class OrdenarEquipoPorPuntos implements Comparator<Equipo> {
    @Override
    public int compare(Equipo o1, Equipo o2) {
        return o1.getPuntos().compareTo(o2.getPuntos());
    }
}
