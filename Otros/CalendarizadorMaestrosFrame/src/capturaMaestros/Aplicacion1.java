

/**
 * Title:        CapturaMaestros
 * Description:  Programa para generar archivo de datos de los maestros.
 * Nombre, apellido, tipo de maestro (planta o auxiliar), y horario disponible
 * Copyright:    Copyright (c) 2001
 * Company:      ITSON
 * @author adolfo
 * @version 1.0
 */

package capturaMaestros;

import java.io.*;
import java.util.*;
import capturaMaestros.variables.*;
import capturaMaestros.interfase.*;
import javax.swing.UIManager;
import java.awt.*;

public class Aplicacion1 {
  public Aplicacion1() {

    FrameMestros2 frameMaestros = new FrameMestros2();

    boolean packFrame = false;
    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from thelf layout
    if (packFrame) {
      frameMaestros.pack();
    }
    else {
      frameMaestros.validate();
    }
    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frameMaestros.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frameMaestros.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frameMaestros.setVisible(true);


  }

  public static void main(String[] args) {
    Aplicacion1 aplicacion11 = new Aplicacion1();
  }
}