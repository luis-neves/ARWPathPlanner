package gui;

import ga.GASingleton;
import net.sf.jni4net.Bridge;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import javax.swing.*;

public class Main {

    final String dir = System.getProperty("user.dir");


    public Main() {

        //SERVICE BUS
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        Bridge.setVerbose(true);
        Bridge.setDebug(true);
        try {
            Bridge.init();
            File proxyAssembyFile = new File(dir +"/ClassLib.j4n.dll");
            Bridge.LoadAndRegisterAssemblyFrom(proxyAssembyFile);
        } catch (Exception e) {
            try{
                File proxyAssembyFile = new File(dir +"/lib/ClassLib.j4n.dll");
                Bridge.LoadAndRegisterAssemblyFrom(proxyAssembyFile);
            }catch (Exception e2){
                infoBox(e2.getLocalizedMessage(), "Error");
                e2.printStackTrace();
            }
        }



        //END SERVICE BUS
        MainFrame frame = new MainFrame();
        // Center the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        frame.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);

        frame.setVisible(true);
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception) {
                    exception.printStackTrace();
                }
                new Main();
            }
        });
    }
}
