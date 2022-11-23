package pb2.unlam.edu.ar;

import com.sun.source.tree.Tree;

import java.util.*;

public class Torneo {
    private String nombreTorneo;
    private Set<Equipo> equipos;
    private Map<Integer, Partido> partidos;
    private ArrayList<Equipo> equiposEliminatorias;

    public Torneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
        this.equipos = new HashSet<>();
        this.partidos = new HashMap<>();
        this.equiposEliminatorias = new ArrayList<>();
    }

    public void agregarEquipo(Equipo equipo){ this.equipos.add(equipo);}

    public Integer obtenerCantEquipos() { return this.equipos.size();}

    public void registrarPartido(Integer idPartido, Equipo local, Equipo visitante) throws GruposDistintosException, EquipoDuplicadoException, EquipoNoAgregadoException {
        if(equipos.contains(local) && equipos.contains(visitante)){
            if (!(local.equals(visitante))){
                if (local.getGrupo().equals(visitante.getGrupo())){
                    Partido partido = new Partido(idPartido, local, visitante);
                    this.partidos.put(idPartido, partido);
                } else {
                    throw new GruposDistintosException("Los equipos no pertenecen al mismo grupo");
                }
            } else {
                throw new EquipoDuplicadoException("El equipo ingresado es el mismo");
            }
        } else {
            throw new EquipoNoAgregadoException("Se ingreso un equipo no clasificado");
        }
    }

    public void registrarPartidoVerificacion(Integer idPartido, Equipo local, Equipo visitante) throws GruposDistintosException, EquipoDuplicadoException, EquipoNoAgregadoException, PartidoJugadoException {
        if(equipos.contains(local) && equipos.contains(visitante)){
            if (!(local.equals(visitante))){
                if (local.getGrupo().equals(visitante.getGrupo())){
                    if (!(this.partidos.containsValue(local) && this.partidos.containsValue(visitante))) {
                        Partido partido = new Partido(idPartido, local, visitante);
                        this.partidos.put(idPartido, partido);
                    } else {
                        throw new PartidoJugadoException("El partido ya se habia jugado");
                    }
                } else {
                    throw new GruposDistintosException("Los equipos no pertenecen al mismo grupo");
                }
            } else {
                throw new EquipoDuplicadoException("El equipo ingresado es el mismo");
            }
        } else {
            throw new EquipoNoAgregadoException("Se ingreso un equipo no clasificado");
        }
    }

    public Integer obtenerCantPartidos() { return this.partidos.size();}

    public void registrarResultado(Integer idPartido, Integer golesLocal, Integer golesVisitante) throws EquipoNoAgregadoException {
        if (this.partidos.containsKey(idPartido)){
                Partido partido = this.partidos.get(idPartido);
                Equipo local = encontrarEquipo(partido.getEquipoLocal());
                Equipo visitante = encontrarEquipo(partido.getEquipoVisitante());

                partido.registrarResultado(golesLocal, golesVisitante);
                local.registrarGolesFavorYGolesContra(golesLocal, golesVisitante);
                visitante.registrarGolesFavorYGolesContra(golesVisitante, golesLocal);

                if (golesLocal > golesVisitante){
                    local.setPuntos(3);
                    visitante.setPuntos(0);
                } else if (golesLocal < golesVisitante){
                    local.setPuntos(0);
                    visitante.setPuntos(3);
                } else {
                    local.setPuntos(1);
                    visitante.setPuntos(1);
                }

        }
    }

    public Equipo encontrarEquipo(Equipo e) throws EquipoNoAgregadoException {
        if (this.equipos.contains(e)){
            return e;
        }
        throw new EquipoNoAgregadoException("No se encontró el equipo");
    }


    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Map<Integer, Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(Map<Integer, Partido> partidos) {
        this.partidos = partidos;
    }

    public ArrayList<Equipo> getEquiposEliminatorias() {
        return equiposEliminatorias;
    }

    public void setEquiposEliminatorias(ArrayList<Equipo> equiposEliminatorias) {
        this.equiposEliminatorias = equiposEliminatorias;
    }

    public Resultado obtenerResultadoDelPartido(Integer idPartido) throws PartidoNoExisteException {
        if(partidos.containsKey(idPartido)){
            Partido partido = this.partidos.get(idPartido);
            return partido.getResultadoFinal();
        } else {
            throw new PartidoNoExisteException("El partido no existe");
        }
    }

    public void clasificarEquiposAEliminatorias() {
        Grupo A = Grupo.A;
        Grupo B = Grupo.B;
        Grupo C = Grupo.C;
        Grupo D = Grupo.D;
        Grupo E = Grupo.E;
        Grupo F = Grupo.F;
        Grupo G = Grupo.G;
        Grupo H = Grupo.H;

        for (Equipo e: equipos) {
            switch (e.getGrupo()){
                case  A:
                    TreeSet<Equipo> grupoA = new TreeSet<>(new OrdenarEquipoPorPuntos());
                    break;
                case  B:
                    TreeSet<Equipo> grupoB = new TreeSet<>(new OrdenarEquipoPorPuntos());
                    break;
                case  C:
                    TreeSet<Equipo> grupoC = new TreeSet<>(new OrdenarEquipoPorPuntos());
                    break;
                case  D:
                    TreeSet<Equipo> grupoD = new TreeSet<>(new OrdenarEquipoPorPuntos());
                    break;
                case  E:
                    TreeSet<Equipo> grupoE = new TreeSet<>(new OrdenarEquipoPorPuntos());
                    break;
                case  F:
                    TreeSet<Equipo> grupoF = new TreeSet<>(new OrdenarEquipoPorPuntos());
                    break;
                case  G:
                    TreeSet<Equipo> grupoG = new TreeSet<>(new OrdenarEquipoPorPuntos());
                    break;
                case  H:
                    TreeSet<Equipo> grupoH = new TreeSet<>(new OrdenarEquipoPorPuntos());
                    break;
            }
        }
    }

    public void clasificacionEquipos() {
    }
}
