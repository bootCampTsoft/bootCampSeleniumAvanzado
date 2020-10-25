package ppmBOT01;

import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import pageObject.pages.ppmSearchTimeSheets;

import java.util.Calendar;

/**
* Dependiendo del valor de la fecha actual se debe generar la opcion de fecha que se esperia encontrar en la lista
* desplegable "Periodo de Tiempo"
*/
public class tc01_GenerarOpcionPeriodoTiempo {

    //encuentra en la lista el periodo actual
    //no encuentra en la lista el periodo actual

    @Before
    public void Setup() throws Exception{
    }

    @After
    public void closeTest() throws Exception{
    }

    @Test
    public void generarPeriodoOctubre2020() throws InterruptedException {
        Calendar c = Calendar.getInstance();

        //se inicializa el calendario en la fecha 22 de octubre 2020 22/10/2020
        c.set(Calendar.DAY_OF_MONTH,22);
        c.set(Calendar.MONTH,9);
        c.set(Calendar.YEAR,2020);

        assertEquals("10/1/20 - 10/31/20",ppmSearchTimeSheets.generarOpcionPeriodoTiempo(c));
    }

    @Test
    public void generarPeriodo31Octubre2020() throws InterruptedException {
        Calendar c = Calendar.getInstance();

        //se inicializa el calendario en la fecha 31 de octubre 2020 31/10/2020
        c.set(Calendar.DAY_OF_MONTH,31);
        c.set(Calendar.MONTH,9);
        c.set(Calendar.YEAR,2020);

        assertEquals("10/1/20 - 10/31/20",ppmSearchTimeSheets.generarOpcionPeriodoTiempo(c));
    }

    @Test
    public void generarPeriodoEnero2014() throws InterruptedException {
        Calendar c = Calendar.getInstance();

        //se inicializa el calendario en la fecha 14 de enero 2014 = 14/01/2014
        c.set(Calendar.DAY_OF_MONTH,14);
        c.set(Calendar.MONTH,0);
        c.set(Calendar.YEAR,2014);

        assertEquals("1/1/14 - 1/31/14",ppmSearchTimeSheets.generarOpcionPeriodoTiempo(c));
    }

}
