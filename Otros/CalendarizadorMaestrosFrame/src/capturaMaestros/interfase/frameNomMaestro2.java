
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capturaMaestros.interfase;

import capturaMaestros.variables.Maestro;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Alfredo Perez
 */
public class frameNomMaestro2 extends JDialog {

    
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JTextField jTextField1 = new JTextField();
    JTextField jTextField2 = new JTextField();
    JTextField jTextField3 = new JTextField();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    Maestro maestroVector;
    Maestro maestroAux;
    AbsoluteLayout layaut = new AbsoluteLayout();
    
    
    /**
     * Creates new form NewJFrame
     */
    public frameNomMaestro2(Maestro datMae) {
        maestroAux = (Maestro)(datMae.clone());
        maestroVector = datMae;
        jTextField1.setText(maestroAux.getID());
        jTextField2.setText(maestroAux.getNomPila());
        jTextField3.setText(maestroAux.getApell());
        try {
          jbInit();
        }
        catch(Exception e) {
          e.printStackTrace();
        }
        //initComponents();
    }
    
    private void jbInit() throws Exception {
    this.getContentPane().setLayout(layaut);


    this.setSize(new Dimension(420,300));
    this.setTitle("NOMBRE DE MAESTROS");

    jButton1.setText("ACEPTAR");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });


    jButton2.setText("SALIR");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    jLabel1.setText("CLAVE");
    jLabel2.setText("NOMBRE");
    jLabel3.setText("APELLIDO");
    //xYLayout1.setWidth(426);
    //xYLayout1.setHeight(300);
    this.setCursor(null);
    this.setResizable(false);
    this.setModal(true);
    this.getContentPane().add(jTextField2, new AbsoluteConstraints(135, 114, 229, 30));
    this.getContentPane().add(jTextField3, new AbsoluteConstraints(135, 158, 229, 30));
    this.getContentPane().add(jLabel2, new AbsoluteConstraints(61, 112, 76, 30));
    this.getContentPane().add(jLabel3, new AbsoluteConstraints(61, 162, 82, 30));
    this.getContentPane().add(jButton1, new AbsoluteConstraints(61, 222, 133, 43));
    this.getContentPane().add(jButton2, new AbsoluteConstraints(227, 219, 136, 46));
    this.getContentPane().add(jLabel1, new AbsoluteConstraints(61, 61, 119, 30));
    this.getContentPane().add(jTextField1, new AbsoluteConstraints(135, 62, 101, 30));
  }

  void jButton1_actionPerformed(ActionEvent e) {
    String mensajeText1= jTextField1.getText();
    int longitud = mensajeText1.length();
    try{
      maestroAux.setID(mensajeText1);
      maestroAux.setNombre(jTextField2.getText(),
                            jTextField3.getText());

     /* if(maestroAux.isMaestroOk()){
        System.out.println("si esta OK");
        this.maestroVector.copiarClavNom(maestroAux);
        this.dispose();
      }
      else{
        jTextField1.setText("");
      }*/
    }
    catch(Exception excp){
      jTextField1.setText("");
    }
    System.out.println("Sale de boton1");
  }

  void jButton2_actionPerformed(ActionEvent e) {
    this.dispose();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
