package pageObject.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.base.botBase;

import java.time.format.SignStyle;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/*
 * URL: https://ppm.tsoftglobal.com/itg/tm/SearchTimeSheets.do
 * */
public class ppmSearchTimeSheets extends botBase {

    //Definicion de Objetos
    By listaTipoPeriodosBusqueda = By.xpath("//select[@id='criteria(tsPeriodType)_id']");
    By opcionTipoPeriodoMensual = By.xpath("//select[@id='criteria(tsPeriodType)_id']/option[@value='4']");


    public ppmSearchTimeSheets(WebDriver driver) {
        super(driver);
    }

    //selecciona de la lista Tipo de Periodo la opcion: Mensual
    public void seleccionarPeriodoMensual() throws InterruptedException {
        click(listaTipoPeriodosBusqueda);
        Thread.sleep(2000);
        click(opcionTipoPeriodoMensual);
    }

    /**
     * Genera el periodo de tiempo segun el formato Mes/Primer Dia/A;o  - Mes/Ultimo Dia/A;o
     * @param c es un Calendario que deberia inicializarse en la fecha actual
     * @return
     */
    public static String generarOpcionPeriodoTiempo(Calendar c)
    {
        Date first_date, last_date;
        SimpleDateFormat f = new SimpleDateFormat("M/d/YY");
        c.set(Calendar.DAY_OF_MONTH,1);

        //Se inicializa first_date como la fecha del primer dia del mes
        first_date = c.getTime();

        //Se inicializa last_date como la fecha del ultimo dia del mes
        c.set(Calendar.DAY_OF_MONTH,c.getActualMaximum(Calendar.DAY_OF_MONTH));
        last_date = c.getTime();

        return f.format(first_date) + " - " + f.format(last_date);
    }

    /**
     * Devuelve el periodo de tiempo segun la fecha actual
     */
    public static String getPeriodoActual()
    {
        Calendar c = Calendar.getInstance();
        return ppmSearchTimeSheets.generarOpcionPeriodoTiempo(c);
    }

    /**
     * Devuelve un string vacio si no encuentra el periodo de tiempo en la lista (select).
     * En caso de que lo encuentre devuelve el valor de la opcion
     *
     */
    public static String buscarPeriodoActual(String periodo_de_tiempo)
    {
        return "";
    }
}
