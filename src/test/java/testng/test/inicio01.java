package testng.test;

import org.testng.annotations.Test;

public class inicio01 {

    @Test(groups = "inicio", timeOut = 400)
    public void metodo() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Hola");
    }
    @Test(groups = "medio", dependsOnMethods = "metodo")
    public void metodo2(){
        System.out.println("Hola otra vez");
    }

    @Test(groups = "final",enabled = false)
    public void metodo3(){
        System.out.println("Hasta Luego");
    }
}
