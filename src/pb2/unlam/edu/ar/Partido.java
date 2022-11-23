package pb2.unlam.edu.ar;

public class Partido {
    private Integer idPartido;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Integer golesLocal;
    private Integer golesVisitante;
    private Resultado resultadoFinal;

    public Partido(Integer idPartido, Equipo equipoLocal, Equipo equipoVisitante) {
        this.idPartido = idPartido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public void registrarResultado(Integer golesLocal, Integer golesVisitante){
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;

        if (golesLocal > golesVisitante){
            this.resultadoFinal = Resultado.GANA_LOCAL;
        } else if (golesLocal < golesVisitante){
            this.resultadoFinal = Resultado.GANA_VISITANTE;
        } else {
            this.resultadoFinal = Resultado.EMPATE;
        }

    }

    public Integer getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Integer idPartido) {
        this.idPartido = idPartido;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Resultado getResultadoFinal() {
        return resultadoFinal;
    }
}
