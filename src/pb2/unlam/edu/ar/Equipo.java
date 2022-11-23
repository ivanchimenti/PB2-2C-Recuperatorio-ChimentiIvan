package pb2.unlam.edu.ar;

import java.util.Objects;

public class Equipo extends OrdenarEquipoPorPuntos{
    private String nombreEq;
    private Grupo grupo;
    private Integer puntos;
    private Integer golesFavor;
    private Integer golesContra;
    private Integer difGol;

    public Equipo(String nombreEq, Grupo grupo, Integer puntos) {
        this.nombreEq = nombreEq;
        this.grupo = grupo;
        this.puntos = puntos;
    }

    public String getNombreEq() {
        return nombreEq;
    }

    public void setNombreEq(String nombreEq) {
        this.nombreEq = nombreEq;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos += puntos;
    }

    public Integer getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(Integer golesFavor) {
        this.golesFavor = golesFavor;
    }

    public Integer getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(Integer golesContra) {
        this.golesContra = golesContra;
    }

    public Integer getDifGol() {
        return difGol = this.golesFavor - this.golesContra;
    }

    public void setDifGol() {
        this.difGol = this.golesFavor - this.golesContra;
    }

    public void registrarGolesFavorYGolesContra(Integer golesFavor, Integer golesContra){
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo)) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombreEq, equipo.nombreEq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreEq);
    }

}
