package capturaMaestros.interfase;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import capturaMaestros.variables.Horario;
//import javax.swing.JPanel;

public class FrameHorario extends JPanel {
  private GridBagLayout gridBagLayout1 =new GridBagLayout();
  private JButton[] botonesDias;
  private JButton[] botonesHoras;
  final private String nomDias[] = {"   ","LUN","MAR","MIE","JUE","VIE" };
  final private String nomHoras[] = {"7:00","8:00","9:00","10:00","11:00","12:00",
                            "13:00","14:00","15:00","16:00","17:00",
                            "18:00","19:00","20:00"};
  private Selector2d casillasH= new Selector2d(28,5);

  private TitledBorder titledBorder1;

  public FrameHorario() {
    botonesDias = new JButton[5+1];
    botonesHoras = new JButton[14+1];

    try{
      jbInit();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception{
    GridBagConstraints constraints = new GridBagConstraints();
    titledBorder1 = new TitledBorder("");
    this.setLayout(gridBagLayout1);

    //Dias de la Semana
    for(int dia=0; dia<6;dia++){
      buildConstraints(constraints,dia,0,1,1,10,10);
      constraints.fill = GridBagConstraints.BOTH;
      botonesDias[dia]= new JButton(nomDias[dia]);
      botonesDias[dia].setFocusPainted(false);
      botonesDias[dia].setDefaultCapable(false);
      gridBagLayout1.setConstraints(botonesDias[dia], constraints);
      add(botonesDias[dia]);
    }

    for(int hor=0; hor<14; hor++){
      buildConstraints(constraints,0,hor+1,1,1,0,10);
      constraints.fill = GridBagConstraints.BOTH;
      botonesHoras[hor] = new JButton(nomHoras[hor]);
      botonesHoras[hor].setFocusPainted(false);
      botonesHoras[hor].setDefaultCapable(false);
      gridBagLayout1.setConstraints(botonesHoras[hor], constraints);
      add(botonesHoras[hor]);
    }

    //Agrega el desplegador de horario
    buildConstraints(constraints,1,1,0,0,0,0);
    constraints.fill = GridBagConstraints.BOTH;
    gridBagLayout1.setConstraints(casillasH, constraints);
    add(casillasH);

    constraints.fill = GridBagConstraints.BOTH;
  }

  private void buildConstraints(GridBagConstraints gbc, int gx, int gy,
                                    int gw, int gh, int wx, int wy){
    gbc.gridx=gx;
    gbc.gridy=gy;
    gbc.gridwidth=gw;
    gbc.gridheight=gh;
    gbc.weightx=wx;
    gbc.weighty=wy;
  }

 public void setHorario(Horario hor){
    int i, j;
    int [][] edoCasillas = new int [28][5];
    for(i=0; i<28; i++)for(j=0; j<5; j++)
      edoCasillas[i][j] = hor.leeCasilla(i,j);
    casillasH.setEstados(edoCasillas);
  }

  public Horario getHorario(){
    Horario bufferHorario= new Horario();
    int[][] bufferCasillas = casillasH.getEstados();
    int i, j;
    for(i=0; i<28; i++)for(j=0; j<5; j++){
      bufferHorario.escribeEnCasilla(i,j,bufferCasillas[i][j]);
    }
    return bufferHorario;
  }

  public Insets insets(){
    return new Insets( 3,3,3,3 );
  }
}