package pb2.unlam.edu.ar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCases {
    Torneo mundial;
    Equipo catar;
    Equipo ecuador;
    Equipo senegal;
    Equipo paisesbajos;
    Equipo inglaterra;
    Equipo iran;
    Equipo eeuu;
    Equipo gales;
    Equipo argentina;
    Equipo arabia;
    Equipo mexico;
    Equipo polonia;
    Equipo francia;
    Equipo australia;
    Equipo dinamarca;
    Equipo tunez;
    Equipo espania;
    Equipo costarica;
    Equipo alemania;
    Equipo japon;
    Equipo belgica;
    Equipo canada;
    Equipo marruecos;
    Equipo croacia;
    Equipo brasil;
    Equipo serbia;
    Equipo suiza;
    Equipo camerun;
    Equipo portugal;
    Equipo ghana;
    Equipo uruguay;
    Equipo coreadelsur;

    @Before
    public void setUp(){
        mundial = new Torneo("Mundial Qatar 2022");
        catar = new Equipo("Catar", Grupo.A, 0);
        ecuador = new Equipo("Ecuador", Grupo.A, 0);
        senegal = new Equipo("Senegal", Grupo.A, 0);
        paisesbajos = new Equipo("Paises Bajos", Grupo.A, 0);
        inglaterra = new Equipo("Inglaterra", Grupo.B, 0);
        iran = new Equipo("Iran", Grupo.B, 0);
        eeuu = new Equipo("Estados Unidos", Grupo.B, 0);
        gales = new Equipo("Gales", Grupo.B, 0);
        argentina = new Equipo("Argentina", Grupo.C, 0);
        arabia = new Equipo("Arabia Saudita", Grupo.C, 0);
        mexico = new Equipo("Mexico", Grupo.C, 0);
        polonia = new Equipo("Polonia", Grupo.C, 0);
        francia = new Equipo("Francia", Grupo.D, 0);
        australia = new Equipo("Australia", Grupo.D, 0);
        dinamarca = new Equipo("Dinamarca", Grupo.D, 0);
        tunez = new Equipo("Tunez", Grupo.D, 0);
        espania = new Equipo("España", Grupo.E, 0);
        costarica = new Equipo("Costa Rica", Grupo.E, 0);
        alemania = new Equipo("Alemania", Grupo.E, 0);
        japon = new Equipo("Japon", Grupo.E, 0);
        belgica = new Equipo("Belgica", Grupo.F, 0);
        canada = new Equipo("Canada", Grupo.F, 0);
        marruecos = new Equipo("Marruegos", Grupo.F, 0);
        croacia = new Equipo("Croacia", Grupo.F, 0);
        brasil = new Equipo("Brasil", Grupo.G, 0);
        serbia = new Equipo("Serbia", Grupo.G, 0);
        suiza = new Equipo("Suiza", Grupo.G, 0);
        camerun = new Equipo("Camerun", Grupo.G, 0);
        portugal = new Equipo("Portugal", Grupo.H, 0);
        ghana = new Equipo("Ghana", Grupo.H, 0);
        uruguay = new Equipo("Uruguay", Grupo.H, 0);
        coreadelsur = new Equipo("Corea del Sur", Grupo.H, 0);

        mundial.agregarEquipo(catar);
        mundial.agregarEquipo(ecuador);
        mundial.agregarEquipo(senegal);
        mundial.agregarEquipo(paisesbajos);
        mundial.agregarEquipo(inglaterra);
        mundial.agregarEquipo(iran);
        mundial.agregarEquipo(eeuu);
        mundial.agregarEquipo(gales);
        mundial.agregarEquipo(argentina);
        mundial.agregarEquipo(arabia);
        mundial.agregarEquipo(mexico);
        mundial.agregarEquipo(polonia);
        mundial.agregarEquipo(francia);
        mundial.agregarEquipo(australia);
        mundial.agregarEquipo(dinamarca);
        mundial.agregarEquipo(tunez);
        mundial.agregarEquipo(espania);
        mundial.agregarEquipo(costarica);
        mundial.agregarEquipo(alemania);
        mundial.agregarEquipo(japon);
        mundial.agregarEquipo(belgica);
        mundial.agregarEquipo(canada);
        mundial.agregarEquipo(marruecos);
        mundial.agregarEquipo(croacia);
        mundial.agregarEquipo(brasil);
        mundial.agregarEquipo(serbia);
        mundial.agregarEquipo(suiza);
        mundial.agregarEquipo(camerun);
        mundial.agregarEquipo(portugal);
        mundial.agregarEquipo(ghana);
        mundial.agregarEquipo(uruguay);
        mundial.agregarEquipo(coreadelsur);
    }

    @Test
    public void queSePuedaCrearUnTorneoCon32Equipos(){
        Integer valorEsperado = 32;
        Integer valorObtenido = mundial.obtenerCantEquipos();
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    public void queSePuedaCrearUnPartidoDeGruposConDosEquiposDelMismoGrupo() throws EquipoDuplicadoException, GruposDistintosException, EquipoNoAgregadoException {
        mundial.registrarPartido(1, catar, ecuador);
        mundial.registrarPartido(2, senegal, paisesbajos);
        mundial.registrarPartido(3, inglaterra, iran);

        Integer valorEsperado = 3;
        Integer valorObtenido = mundial.obtenerCantPartidos();
        assertEquals(valorEsperado, valorObtenido);

        assertEquals(catar.getGrupo(), ecuador.getGrupo());
        assertEquals(paisesbajos.getGrupo(), senegal.getGrupo());
        assertEquals(inglaterra.getGrupo(), iran.getGrupo());

    }

    @Test
    public void queSePuedaCrearUnPartidoDeEliminatoriasConDosEquiposPertenecientesALaListaDeEquiposEnEliminatorias() throws EquipoDuplicadoException, EquipoNoAgregadoException, GruposDistintosException {
        mundial.registrarPartido(1, catar, ecuador);
        mundial.registrarPartido(2, senegal, paisesbajos);
        mundial.registrarPartido(3, inglaterra, iran);
        mundial.registrarPartido(4, eeuu, gales);
        mundial.registrarResultado(1, 0, 2);
        mundial.registrarResultado(2, 0, 2);
        mundial.registrarResultado(3, 6, 2);
        mundial.registrarResultado(4, 1, 1);

        Integer valorEsperado3 = 3;
        Integer valorEsperado1 = 1;
        Integer valorEsperado0 = 0;

        Integer puntosEcuador = mundial.encontrarEquipo(ecuador).getPuntos();
        Integer puntosCatar = mundial.encontrarEquipo(catar).getPuntos();
        Integer puntosEeuu = mundial.encontrarEquipo(eeuu).getPuntos();
        Integer puntosGales = mundial.encontrarEquipo(gales).getPuntos();

        assertEquals(valorEsperado3, puntosEcuador);
        assertEquals(valorEsperado0, puntosCatar);
        assertEquals(valorEsperado1, puntosEeuu);
        assertEquals(valorEsperado1, puntosGales);

        mundial.clasificarEquiposAEliminatorias();
        mundial.clasificacionEquipos();
    }

    @Test (expected = PartidoJugadoException.class)
    public void queAlCrearUnPartidoDondeLosEquiposYaJugaronSeLanceUnaException() throws PartidoJugadoException, EquipoDuplicadoException, EquipoNoAgregadoException, GruposDistintosException {
        mundial.registrarPartidoVerificacion(1, catar, ecuador);
        mundial.registrarPartidoVerificacion(2, ecuador, catar);
    }

    @Test (expected = EquipoDuplicadoException.class)
    public void queAlCrearUnPartidoDondeElQuipoLocalEsElMismoQueElVisitanteSeLanceUnaException() throws EquipoDuplicadoException, EquipoNoAgregadoException, GruposDistintosException {
        mundial.registrarPartido(1, catar, catar);
    }

    @Test
    public void queAlRegistrarElResultadoDeUnPartidoDeGruposSeAcumulenLosPuntosCorrespondientesACadaEquipo() throws EquipoDuplicadoException, EquipoNoAgregadoException, GruposDistintosException {
        mundial.registrarPartido(3, inglaterra, iran);
        mundial.registrarPartido(4, eeuu, gales);
        mundial.registrarResultado(3, 6, 2);
        mundial.registrarResultado(4, 1, 1);

        Integer puntosEeuu = mundial.encontrarEquipo(eeuu).getPuntos();
        Integer puntosGales = mundial.encontrarEquipo(gales).getPuntos();
        Integer puntosInglaterra = mundial.encontrarEquipo(inglaterra).getPuntos();
        Integer puntosIran = mundial.encontrarEquipo(iran).getPuntos();

        Integer valorEsperado3 = 3;
        Integer valorEsperado1 = 1;
        Integer valorEsperado0 = 0;

        assertEquals(valorEsperado1, puntosEeuu);
        assertEquals(valorEsperado1, puntosGales);
        assertEquals(valorEsperado3, puntosInglaterra);
        assertEquals(valorEsperado0, puntosIran);
    }

    @Test
    public void queAlObtenerElResultadoDeUnPartidoDeGruposSeaElEelemtoEmpateDelEnum() throws EquipoDuplicadoException, EquipoNoAgregadoException, GruposDistintosException, PartidoNoExisteException {
        mundial.registrarPartido(4, eeuu, gales);
        mundial.registrarResultado(4, 1, 1);

        Resultado valorEsperado = Resultado.EMPATE;
        Resultado valorObtenido = mundial.obtenerResultadoDelPartido(4);
        assertEquals(valorEsperado, valorObtenido);
    }




}
