package testng.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class inicio02 {

    @Test(groups = "inicio", timeOut = 400)
    public void metodo() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("Hola");
    }
    @Parameters({"parametro1"})
    @Test(groups = "medio")
    public void metodo2(String par1){
        System.out.println("Hola otra vez");
        System.out.println(par1);
    }

    @Test(groups = "final",enabled = false)
    public void metodo3(){
        System.out.println("Hasta Luego");
    }
}
