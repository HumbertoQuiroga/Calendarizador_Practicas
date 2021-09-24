/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capturaMaestros.interfase;

import capturaMaestros.variables.Maestro;
import capturaMaestros.variables.VectorMaestros;
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Alfredo Perez
 */
public class FrameMestros2 extends javax.swing.JFrame {

    
  private JPanel contentPane = new JPanel();
  private AbsoluteLayout layaut = new AbsoluteLayout();
  public FrameHorario frameHor1= new FrameHorario();
  JComboBox jComboBox1 = new JComboBox();
  JButton jButton1 = new JButton();

  private int seleccionado;

  // Es para que no entre jComboBox1_actionPerformed()
  // cuando elimino un elemento del jCombo1 por jButton2
  private boolean parcheBloqueador=true;

  VectorMaestros tabMaestros=new VectorMaestros();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JButton jButton4 = new JButton();
  JButton jButton5 = new JButton();
    
    /**
     * Creates new form FrameMestros2
     */
    public FrameMestros2() {
       // initComponents();
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
          jbInit();
        }
        catch(Exception e) {
          e.printStackTrace();
        }

      }
    
    void jbInit() throws Exception {
    contentPane=(JPanel)this.getContentPane();
    contentPane.setLayout(layaut);
    this.setSize(new Dimension(880, 600));
    this.setTitle("CAPTURA DE DATOS DE MAESTROS");

    jButton1.setText("EDITAR");
    jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        jButton1_mouseClicked(e);
      }
    });
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });

    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jComboBox1_actionPerformed(e);
      }
    });
    
    jComboBox1.setSize(250, 20);

    jButton2.setText("ELIMINAR");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });

    jButton3.setText("SALIR");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton3_actionPerformed(e);
      }
    });
    
    jButton5.setText("Guardar");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
           tabMaestros.almacenaTodo(new File("tabMaes.dat"));
        }
    });

    jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        jComboBox1_mouseClicked(e);
      }
      public void mousePressed(MouseEvent e) {
        jComboBox1_mousePressed(e);
      }
    });
    jButton4.setText("INSERTAR");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton4_actionPerformed(e);
      }
    });
    parcheBloqueador=true;jComboBox1.setBackground(SystemColor.textHighlightText);
    jComboBox1.setFont(new java.awt.Font("Monospaced", 0, 10));
    jComboBox1.setBorder(BorderFactory.createLineBorder(Color.black));
    jComboBox1.setMaximumRowCount(15);
    parcheBloqueador=false;
    contentPane.add(frameHor1, new AbsoluteConstraints(361, 70, 369, 327));
    contentPane.add(jComboBox1, new AbsoluteConstraints(25, 90, 315, -1));
    contentPane.add(jButton1, new AbsoluteConstraints(19, 156, 215, 43));
    contentPane.add(jButton3, new AbsoluteConstraints(45, 398, 157, 21));
    contentPane.add(jButton4, new AbsoluteConstraints(19, 211, 215, 43));
    contentPane.add(jButton5, new AbsoluteConstraints(19, 330, 210, 43));
    contentPane.add(jButton2, new AbsoluteConstraints(19, 267, 215, 43));

    /*  ******************************************************  */
    tabMaestros = new VectorMaestros(new File(".\\tabMaes.dat"));
    //tabMaestros=new VectorMaestros();
    //tabMaestros.creaEjemplo(20);

    tabMaestros=tabMaestros.sortApell();

    llenaComboBox();  // INICIALIZA SELECTOR DE MAESTROS (jComboBox1)

    //Habilita el horario con elemento "0"
    seleccionado=0;
    parcheBloqueador=true;jComboBox1.setSelectedIndex(0);parcheBloqueador=false;
    frameHor1.setHorario(((Maestro)(tabMaestros.get(0))).horario);


  }

  /**Overridden so we can exit when window is closed*/
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      ((Maestro)(tabMaestros.get(seleccionado))).horario=
          frameHor1.getHorario();
      
      tabMaestros.almacenaTodo(new File("tabMaes.dat"));
      System.exit(0);
    }
  }

  void jComboBox1_actionPerformed(ActionEvent e) {
    if (!parcheBloqueador){
      System.out.println("jComboBoxActionPerformed Event");
      //Guarda informacion del panel horario en el vector de maestros
      ((Maestro)(tabMaestros.get(seleccionado))).horario=
            frameHor1.getHorario();
      //Habilita el horario del nuevo maestro seleccionado  en el panel de horarios
      seleccionado=jComboBox1.getSelectedIndex();
      frameHor1.setHorario(
          ((Maestro)(tabMaestros.get(seleccionado))).horario);
    }
  }

  //Remueve un elemento
  void jButton2_actionPerformed(ActionEvent e) {
    parcheBloqueador = true;
    //REMUEVE DEL VECTOR (tabMaestros) AL ELEMENTO SELECCIONADO
    tabMaestros.removeElementAt(seleccionado);
    tabMaestros.trimToSize();
    //REMUVE DEL SELECTOR (jComboBox1) AL ELEMENTO SELECCIONADO
    jComboBox1.removeItemAt(seleccionado);

    //SELECCIONA EL ELEMENTO 0 (SI EXISTE) Y LO PONE EN HORARIO
    if(tabMaestros.size()!=0){
      seleccionado=0;
      jComboBox1.setSelectedIndex(0);

      frameHor1.setHorario(
        ((Maestro)(tabMaestros.get(seleccionado))).horario);
    }
    parcheBloqueador=false;
  }

  //Salir
  void jButton3_actionPerformed(ActionEvent e) {
    ((Maestro)(tabMaestros.get(seleccionado))).horario= frameHor1.getHorario();
    tabMaestros.almacenaTodo(new File("tabMaes.dat"));
    System.exit(0);
  }


  //Boton EDITAR
  void jButton1_actionPerformed(ActionEvent e) {
    frameNomMaestro2 frameEntraNom  = new frameNomMaestro2((Maestro)(tabMaestros.get(seleccionado)));
    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frameEntraNom.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frameEntraNom.setLocation((screenSize.width - frameSize.width) / 2,
                                (screenSize.height - frameSize.height) / 2);
    frameEntraNom.setVisible(true);

    // regresa de jDialog1
    llenaComboBox();
    seleccionado=0;
    parcheBloqueador=true;jComboBox1.setSelectedIndex(0);parcheBloqueador=false;
    frameHor1.setHorario(((Maestro)(tabMaestros.get(0))).horario);

    tabMaestros=tabMaestros.sortApell();
    llenaComboBox();
  }


  void jComboBox1_mouseClicked(MouseEvent e) {
          System.out.println("Mouse cliked "+jComboBox1.getSelectedIndex());
  }

  void jComboBox1_mousePressed(MouseEvent e) {
    System.out.println("Mouse press "+jComboBox1.getSelectedIndex());

  }

  void jButton1_mouseClicked(MouseEvent e) {
    System.out.println("click boton 1");
  }

  private void llenaComboBox(){
    // INICIALIZA SELECTOR DE MAESTROS (jComboBox1)
    parcheBloqueador=true;
    jComboBox1.removeAllItems();
    int longVector = tabMaestros.size();
    if(longVector!=0){
      String claveYnombre;
      for(int i=0; i<longVector; i++){
        String tipoM = new String(((Maestro)(tabMaestros.get(i))).getID()+"    ");
        tipoM=tipoM.substring(0,7);
        claveYnombre = new String(tipoM+
                            ((Maestro)(tabMaestros.get(i))).getNombre());
        jComboBox1.addItem(claveYnombre);
      }
    }
    parcheBloqueador=false;
  }

  // Boton INSERTAR
  void jButton4_actionPerformed(ActionEvent e) {
    DialogNomMaestro2 frameEntraNom  = new DialogNomMaestro2(this, parcheBloqueador, tabMaestros);
    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frameEntraNom.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frameEntraNom.setLocation((screenSize.width - frameSize.width) / 2,
                                (screenSize.height - frameSize.height) / 2);
    frameEntraNom.setVisible(true);

    // regresa de jDialog1
    tabMaestros=tabMaestros.sortApell();
    llenaComboBox();
    seleccionado=0;
    parcheBloqueador=true;jComboBox1.setSelectedIndex(0);parcheBloqueador=false;
    frameHor1.setHorario(((Maestro)(tabMaestros.get(0))).horario);

  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMestros2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMestros2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMestros2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMestros2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMestros2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
