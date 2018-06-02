/*
 * File Name: SpecialRelativity.java
 * AUTHOR: SHAWN YANG
 * Oct 2016
 * Description: This program calculates the amount of time 
 * dilation and length contraction occurred in different Frames 
 * by using the Special Relativity theory in Physics.
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class SpecialRelativityGUI extends JFrame {

   private JPanel contentPane;
   private JTextField txtI;
   private JTextField txtI_1;
   private JTextArea txtrThisProgramCalculates;
   private final ButtonGroup buttonGroup = new ButtonGroup();
   private final ButtonGroup buttonGroup_1 = new ButtonGroup();
   private final ButtonGroup buttonGroup_2 = new ButtonGroup();
   private JTextField txtI_3;
   private double gamma;
   private double result;
   private double length;
   private double time;
   private double speed;
   private double dilation;
   private double contraction;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               SpecialRelativityGUI frame = new SpecialRelativityGUI();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public SpecialRelativityGUI() {
      setTitle("Special Relativity Calculator");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 530, 400);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      GridBagLayout gbl_contentPane = new GridBagLayout();
      gbl_contentPane.columnWidths = new int[] {52, 52, 52, 52, 52, 52, 52, 52, 52, 52, 0};
      gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
      gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
      contentPane.setLayout(gbl_contentPane);
      
      JLabel lblHi = new JLabel("1. Select concept -> 2. Pick preset values or enter your own ->3. Calculate!");
      lblHi.setFont(new Font("Lucida Grande", Font.BOLD, 13));
      GridBagConstraints gbc_lblHi = new GridBagConstraints();
      gbc_lblHi.insets = new Insets(0, 0, 5, 0);
      gbc_lblHi.gridwidth = 10;
      gbc_lblHi.gridx = 0;
      gbc_lblHi.gridy = 0;
      contentPane.add(lblHi, gbc_lblHi);
      
      final JRadioButton rdbtnI = new JRadioButton("Time Dilation");
      rdbtnI.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
           // txtrThisProgramCalculates.setText("The moving object's time only passed XXX seconds!");
            txtI_3.setEnabled(false);
            txtI.setEnabled(true);
         }
      });
      rdbtnI.setSelected(true);
      buttonGroup_1.add(rdbtnI);
      rdbtnI.setDoubleBuffered(true);
      /*rdbtnI.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            txtI_2.setText("The moving object's time only passed XXX seconds!");
            txtI_3.setEnabled(false);
            txtI.setEnabled(true);
         }
      });*/
      GridBagConstraints gbc_rdbtnI = new GridBagConstraints();
      gbc_rdbtnI.anchor = GridBagConstraints.EAST;
      gbc_rdbtnI.gridwidth = 3;
      gbc_rdbtnI.insets = new Insets(0, 0, 5, 5);
      gbc_rdbtnI.gridx = 1;
      gbc_rdbtnI.gridy = 1;
      contentPane.add(rdbtnI, gbc_rdbtnI);
      
      JRadioButton rdbtnI_1 = new JRadioButton("length contraction");
      rdbtnI_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
           // txtrThisProgramCalculates.setText("The subject apears to be XXX meters long!");
            txtI_3.setEnabled(true);
            txtI.setEnabled(false);
         }
      });
      /*
      rdbtnI_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            txtI_2.setText("The subject apears to be XXX meters long!");
            txtI_3.setEnabled(true);
            txtI.setEnabled(false);
         }
      });*/
      buttonGroup_1.add(rdbtnI_1);
      GridBagConstraints gbc_rdbtnI_1 = new GridBagConstraints();
      gbc_rdbtnI_1.anchor = GridBagConstraints.EAST;
      gbc_rdbtnI_1.insets = new Insets(0, 0, 5, 5);
      gbc_rdbtnI_1.gridwidth = 3;
      gbc_rdbtnI_1.gridx = 5;
      gbc_rdbtnI_1.gridy = 1;
      contentPane.add(rdbtnI_1, gbc_rdbtnI_1);
      
      JSeparator separator = new JSeparator();
      separator.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
      GridBagConstraints gbc_separator = new GridBagConstraints();
      gbc_separator.insets = new Insets(0, 0, 5, 0);
      gbc_separator.fill = GridBagConstraints.HORIZONTAL;
      gbc_separator.gridwidth = 10;
      gbc_separator.gridx = 0;
      gbc_separator.gridy = 2;
      contentPane.add(separator, gbc_separator);
      
      JLabel lblI_2 = new JLabel("       Preset data for demostration:");
      lblI_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
      GridBagConstraints gbc_lblI_2 = new GridBagConstraints();
      gbc_lblI_2.anchor = GridBagConstraints.WEST;
      gbc_lblI_2.gridwidth = 5;
      gbc_lblI_2.insets = new Insets(0, 0, 5, 5);
      gbc_lblI_2.gridx = 0;
      gbc_lblI_2.gridy = 3;
      contentPane.add(lblI_2, gbc_lblI_2);
      
      JLabel lblNewLabel = new JLabel("Data used for calculation:");
      lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
      GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
      gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
      gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
      gbc_lblNewLabel.gridwidth = 5;
      gbc_lblNewLabel.gridx = 5;
      gbc_lblNewLabel.gridy = 3;
      contentPane.add(lblNewLabel, gbc_lblNewLabel);
      
      JRadioButton rdbtnI_2 = new JRadioButton("Baby crawling");
      rdbtnI_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            txtI_3.setText("0.7");
            txtI.setText("60");
            txtI_1.setText("0.08");
         }
      });
      /*rdbtnI_2.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            txtI_3.setText("0.7");
            txtI.setText("60");
            txtI_1.setText("0.08");
         }
      });*/
      rdbtnI_2.setToolTipText("Babies can crawl aproximitely 3~5 meters per minute when they first learn how to crawl at 9 month, their average body length is 70 cm at 9 month old. ");
      buttonGroup_2.add(rdbtnI_2);
      GridBagConstraints gbc_rdbtnI_2 = new GridBagConstraints();
      gbc_rdbtnI_2.anchor = GridBagConstraints.WEST;
      gbc_rdbtnI_2.gridwidth = 5;
      gbc_rdbtnI_2.insets = new Insets(0, 0, 5, 5);
      gbc_rdbtnI_2.gridx = 0;
      gbc_rdbtnI_2.gridy = 4;
      contentPane.add(rdbtnI_2, gbc_rdbtnI_2);
      
      JRadioButton rdbtnI_3 = new JRadioButton("Walking");
      rdbtnI_3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            txtI_3.setText("0.15");
            txtI.setText("60");
            txtI_1.setText("1.39");
         }
      });
      /*rdbtnI_3.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            txtI_3.setText("0.15");
            txtI.setText("60");
            txtI_1.setText("1.39");
         }
      });*/
      rdbtnI_3.setToolTipText("The average human walking speed is about 5 kilometers per hour.  https://en.wikipedia.org/wiki/Walking");
      buttonGroup_2.add(rdbtnI_3);
      GridBagConstraints gbc_rdbtnI_3 = new GridBagConstraints();
      gbc_rdbtnI_3.anchor = GridBagConstraints.WEST;
      gbc_rdbtnI_3.gridwidth = 5;
      gbc_rdbtnI_3.insets = new Insets(0, 0, 5, 5);
      gbc_rdbtnI_3.gridx = 0;
      gbc_rdbtnI_3.gridy = 5;
      contentPane.add(rdbtnI_3, gbc_rdbtnI_3);
      
      JLabel lblI_3 = new JLabel("Length of the object (m):");
      lblI_3.setToolTipText("The measured length in the moving object's frame, this data is used for calculating length contraction");
      GridBagConstraints gbc_lblI_3 = new GridBagConstraints();
      gbc_lblI_3.anchor = GridBagConstraints.WEST;
      gbc_lblI_3.gridwidth = 3;
      gbc_lblI_3.insets = new Insets(0, 0, 5, 5);
      gbc_lblI_3.gridx = 5;
      gbc_lblI_3.gridy = 5;
      contentPane.add(lblI_3, gbc_lblI_3);
      
      txtI_3 = new JTextField();
      txtI_3.setEnabled(false);
      txtI_3.setText("0");
      GridBagConstraints gbc_txtI_3 = new GridBagConstraints();
      gbc_txtI_3.gridwidth = 2;
      gbc_txtI_3.insets = new Insets(0, 0, 5, 0);
      gbc_txtI_3.fill = GridBagConstraints.HORIZONTAL;
      gbc_txtI_3.gridx = 8;
      gbc_txtI_3.gridy = 5;
      contentPane.add(txtI_3, gbc_txtI_3);
      txtI_3.setColumns(10);
      
      JRadioButton rdbtnRunning = new JRadioButton("Running");
      rdbtnRunning.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            txtI_3.setText("0.15");
            txtI.setText("60");
            txtI_1.setText("12.4");
         }
      });
      /*rdbtnRunning.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            txtI_3.setText("0.15");
            txtI.setText("60");
            txtI_1.setText("12.4");
         }
      });*/
      rdbtnRunning.setToolTipText("The fastest human footspeed on record is 44.7 km/h (12.4 m/s, 27.8 mph), seen during a 100-meter sprint (average speed between the 60th and the 80th meter) by Usain Bolt. https://en.wikipedia.org/wiki/Running");
      buttonGroup_2.add(rdbtnRunning);
      GridBagConstraints gbc_rdbtnRunning = new GridBagConstraints();
      gbc_rdbtnRunning.anchor = GridBagConstraints.WEST;
      gbc_rdbtnRunning.gridwidth = 5;
      gbc_rdbtnRunning.insets = new Insets(0, 0, 5, 5);
      gbc_rdbtnRunning.gridx = 0;
      gbc_rdbtnRunning.gridy = 6;
      contentPane.add(rdbtnRunning, gbc_rdbtnRunning);
      
      JLabel lblI = new JLabel("Time object traveled (s):");
      lblI.setToolTipText("The amount of time passed in your Frame(not the moving objects Frame). this data is used for calculating Time Dilation");
      GridBagConstraints gbc_lblI = new GridBagConstraints();
      gbc_lblI.anchor = GridBagConstraints.WEST;
      gbc_lblI.gridwidth = 3;
      gbc_lblI.insets = new Insets(0, 0, 5, 5);
      gbc_lblI.gridx = 5;
      gbc_lblI.gridy = 6;
      contentPane.add(lblI, gbc_lblI);
      
      txtI = new JTextField();
      txtI.setText("0");
      GridBagConstraints gbc_txtI = new GridBagConstraints();
      gbc_txtI.gridwidth = 2;
      gbc_txtI.fill = GridBagConstraints.HORIZONTAL;
      gbc_txtI.insets = new Insets(0, 0, 5, 0);
      gbc_txtI.gridx = 8;
      gbc_txtI.gridy = 6;
      contentPane.add(txtI, gbc_txtI);
      txtI.setColumns(10);
      
      JRadioButton rdbtnDriving = new JRadioButton("Driving");
      rdbtnDriving.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            txtI_3.setText("4.87");
            txtI.setText("60");
            txtI_1.setText("22.35");
         }
      });
      /*rdbtnDriving.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            txtI_3.setText("4.87");
            txtI.setText("60");
            txtI_1.setText("22.35");
         }
      });*/
      rdbtnDriving.setToolTipText("Speed limit on I-495 NYC portion is 50 Miles/hour, or approximately 80 KM/hour, and a ford fusion is 4.87 M long.");
      buttonGroup_2.add(rdbtnDriving);
      GridBagConstraints gbc_rdbtnDriving = new GridBagConstraints();
      gbc_rdbtnDriving.anchor = GridBagConstraints.WEST;
      gbc_rdbtnDriving.gridwidth = 5;
      gbc_rdbtnDriving.insets = new Insets(0, 0, 5, 5);
      gbc_rdbtnDriving.gridx = 0;
      gbc_rdbtnDriving.gridy = 7;
      contentPane.add(rdbtnDriving, gbc_rdbtnDriving);
      
      JLabel lblI_1 = new JLabel("Speed of the object(m/s):");
      lblI_1.setToolTipText("The speed of the moving object (the moving Frame)");
      GridBagConstraints gbc_lblI_1 = new GridBagConstraints();
      gbc_lblI_1.anchor = GridBagConstraints.WEST;
      gbc_lblI_1.gridwidth = 3;
      gbc_lblI_1.insets = new Insets(0, 0, 5, 5);
      gbc_lblI_1.gridx = 5;
      gbc_lblI_1.gridy = 7;
      contentPane.add(lblI_1, gbc_lblI_1);
      
      txtI_1 = new JTextField();
      txtI_1.setText("0");
      GridBagConstraints gbc_txtI_1 = new GridBagConstraints();
      gbc_txtI_1.gridwidth = 2;
      gbc_txtI_1.insets = new Insets(0, 0, 5, 0);
      gbc_txtI_1.fill = GridBagConstraints.HORIZONTAL;
      gbc_txtI_1.gridx = 8;
      gbc_txtI_1.gridy = 7;
      contentPane.add(txtI_1, gbc_txtI_1);
      txtI_1.setColumns(10);
      
      JRadioButton rdbtnMuon = new JRadioButton("Airplane");
      rdbtnMuon.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            txtI_3.setText("73");
            txtI.setText("60");
            txtI_1.setText("318");
         }
      });
      /*rdbtnMuon.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            txtI_3.setText("73");
            txtI.setText("60");
            txtI_1.setText("318");
         }
      });*/
      rdbtnMuon.setToolTipText("The largest airliner to date A380 is 73 M long and has max design speed of Mach 0.96 (1146KM/hour).  en.wikipedia.org");
      buttonGroup_2.add(rdbtnMuon);
      GridBagConstraints gbc_rdbtnMuon = new GridBagConstraints();
      gbc_rdbtnMuon.anchor = GridBagConstraints.WEST;
      gbc_rdbtnMuon.gridwidth = 5;
      gbc_rdbtnMuon.insets = new Insets(0, 0, 5, 5);
      gbc_rdbtnMuon.gridx = 0;
      gbc_rdbtnMuon.gridy = 8;
      contentPane.add(rdbtnMuon, gbc_rdbtnMuon);
      
      JRadioButton rdbtnRocket = new JRadioButton("Rocket");
      rdbtnRocket.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            txtI_3.setText("42");
            txtI.setText("60");
            txtI_1.setText("7900");
         }
      });
      /*rdbtnRocket.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            txtI_3.setText("42");
            txtI.setText("60");
            txtI_1.setText("7900");
         }
      });*/
      rdbtnRocket.setToolTipText("If a rocket is launched from the surface of the Earth, it needs to reach a speed of at least 7.9 kilometers per second (4.9 miles per second) in order to reach space. The length of saturn V rocket is about 42 meters heigh. www.redshift-live.com");
      buttonGroup_2.add(rdbtnRocket);
      GridBagConstraints gbc_rdbtnRocket = new GridBagConstraints();
      gbc_rdbtnRocket.anchor = GridBagConstraints.WEST;
      gbc_rdbtnRocket.gridwidth = 5;
      gbc_rdbtnRocket.insets = new Insets(0, 0, 5, 5);
      gbc_rdbtnRocket.gridx = 0;
      gbc_rdbtnRocket.gridy = 9;
      contentPane.add(rdbtnRocket, gbc_rdbtnRocket);
      
      JRadioButton rdbtnSettelite = new JRadioButton("Satellite");
      rdbtnSettelite.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            txtI_3.setText("4");
            txtI.setText("60");
            txtI_1.setText("3100");
         }
      });
      /*rdbtnSettelite.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            txtI_3.setText("4");
            txtI.setText("60");
            txtI_1.setText("3100");
         }
      });  */
      rdbtnSettelite.setToolTipText("Satellite that travels on the Geostationary orbit has a speed of 3.1km/s,  en.wikipedia.org ");
      buttonGroup_2.add(rdbtnSettelite);
      GridBagConstraints gbc_rdbtnSettelite = new GridBagConstraints();
      gbc_rdbtnSettelite.anchor = GridBagConstraints.WEST;
      gbc_rdbtnSettelite.gridwidth = 5;
      gbc_rdbtnSettelite.insets = new Insets(0, 0, 5, 5);
      gbc_rdbtnSettelite.gridx = 0;
      gbc_rdbtnSettelite.gridy = 10;
      contentPane.add(rdbtnSettelite, gbc_rdbtnSettelite);
      
      JButton btnI_1 = new JButton("Calculate");
      btnI_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            length=Double.parseDouble(txtI_3.getText());
            time=Double.parseDouble(txtI.getText());
            speed=Double.parseDouble(txtI_1.getText());
            if (speed>=299792458) txtrThisProgramCalculates.setText("Please enter a valid speed which is slower than the speed of light(299792458 m/s)!");
            /*
            else if (!((Character.isDigit(txtI_3.getText().charAt(0)))&&(Character.isDigit(txtI.getText().charAt(0)))&&(Character.isDigit(txtI_1.getText().charAt(0))))) {
               txtrThisProgramCalculates.setText("Please enter number only!");
               
            }*/
            else{
               dilation = time /(1/( Math.sqrt(1-(speed/299792458)*(speed/299792458))));
               contraction = length / (1/( Math.sqrt(1-(speed/299792458)*(speed/299792458))));
               if (rdbtnI.isSelected()) txtrThisProgramCalculates.setText("When you are standing still, in "+time+" seconds of your time(in Your Frame), the moving object passed aproximately "+Double.toString(dilation)+" seconds in their time! (in the moving object's Frame)");
               else txtrThisProgramCalculates.setText("When this "+length+ " meter(s) long object is moving at a speed of "+speed+" m/s (in the Moving Frame), this object is only measured "+Double.toString(contraction)+" meter(s) long in Your Frame!");
            }
         }
      });
      /*
      btnI_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            length=Double.parseDouble(txtI_3.getText());
            time=Double.parseDouble(txtI.getText());
            speed=Double.parseDouble(txtI_1.getText());
            dilation = time /(1/( Math.sqrt(1-(speed/299792458)*(speed/299792458))));
            contraction = length / (1/( Math.sqrt(1-(speed/299792458)*(speed/299792458))));
            if (rdbtnI.isSelected()) txtI_2.setText("When you are standing still, in "+time+" seconds of time, the moving object's time passed aproximately "+Double.toString(dilation)+" seconds!");
            else txtI_2.setText(Double.toString(contraction));
            
         
         }
      });*/
      btnI_1.setForeground(new Color(60, 179, 113));
      GridBagConstraints gbc_btnI_1 = new GridBagConstraints();
      gbc_btnI_1.fill = GridBagConstraints.HORIZONTAL;
      gbc_btnI_1.gridwidth = 2;
      gbc_btnI_1.insets = new Insets(0, 0, 5, 5);
      gbc_btnI_1.gridx = 5;
      gbc_btnI_1.gridy = 10;
      contentPane.add(btnI_1, gbc_btnI_1);
      
      JButton btnI = new JButton("Reset");
      btnI.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            txtI_3.setText("0");
            txtI.setText("0");
            txtI_1.setText("0"); 
         }
      });
      /*
      btnI.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            txtI_3.setText("0");
            txtI.setText("0");
            txtI_1.setText("0"); 
         }
      });*/
      btnI.setForeground(SystemColor.controlHighlight);
      btnI.setToolTipText("Clear Data above and enter your own numbers!");
      GridBagConstraints gbc_btnI = new GridBagConstraints();
      gbc_btnI.fill = GridBagConstraints.HORIZONTAL;
      gbc_btnI.gridwidth = 2;
      gbc_btnI.insets = new Insets(0, 0, 5, 5);
      gbc_btnI.gridx = 7;
      gbc_btnI.gridy = 10;
      contentPane.add(btnI, gbc_btnI);
      
      JSeparator separator_1 = new JSeparator();
      separator_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
      GridBagConstraints gbc_separator_1 = new GridBagConstraints();
      gbc_separator_1.insets = new Insets(0, 0, 5, 0);
      gbc_separator_1.fill = GridBagConstraints.HORIZONTAL;
      gbc_separator_1.gridwidth = 10;
      gbc_separator_1.gridx = 0;
      gbc_separator_1.gridy = 11;
      contentPane.add(separator_1, gbc_separator_1);
      
      txtrThisProgramCalculates = new JTextArea();
      txtrThisProgramCalculates.setText("This program calculates the amount of time dilation and length contraction occurred in different Frames by using the Special Relativity theory in Physics.");
      txtrThisProgramCalculates.setLineWrap(true);
      txtrThisProgramCalculates.setEditable(false);
      GridBagConstraints gbc_txtrThisProgramCalculates = new GridBagConstraints();
      gbc_txtrThisProgramCalculates.gridwidth = 8;
      gbc_txtrThisProgramCalculates.insets = new Insets(0, 0, 0, 5);
      gbc_txtrThisProgramCalculates.fill = GridBagConstraints.BOTH;
      gbc_txtrThisProgramCalculates.gridx = 1;
      gbc_txtrThisProgramCalculates.gridy = 12;
      contentPane.add(txtrThisProgramCalculates, gbc_txtrThisProgramCalculates);
   }

}
