package com.Main;

import com.GUI.GUI;
import com.Service.ApplicationManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationManager applicationManager = context.getBean(ApplicationManager.class);

        java.awt.EventQueue.invokeLater(() -> {
            GUI gui = new GUI(applicationManager);
            gui.setVisible(true);
        });

        Runtime.getRuntime().addShutdownHook(new Thread(context::close));
    }
}
