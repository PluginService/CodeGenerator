/*     */ package com.liamplugins.codegenerator;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.DefaultComboBoxModel;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JRootPane;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ import javax.swing.event.ChangeListener;
/*     */ 
/*     */ public class JavaFrame extends javax.swing.JFrame
/*     */ {
/*     */   private static final long serialVersionUID = -2667842294036910305L;
/*     */   private JTextField packageField;
/*     */   private JTextField classField;
/*     */   private JRadioButton radioMainClass;
/*     */   private JRadioButton radioJFrame;
/*     */   private JComboBox layoutCombo;
/*     */   private JLabel lblLayout;
/*     */   private JLabel lblTitle;
/*     */   private JTextField titleField;
/*     */   private JLabel lblWidth;
/*     */   private JTextField widthField;
/*     */   private JLabel lblLength;
/*     */   private JTextField lengthField;
/*     */   private JRadioButton rdbtnResizable;
/*     */   
/*     */   public JavaFrame()
/*     */   {
/*     */     try
/*     */     {
/*  39 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */     }
/*     */     catch (Exception localException) {}
/*  42 */     setDefaultCloseOperation(3);
/*  43 */     setBounds(100, 100, 600, 500);
/*  44 */     setTitle("Code Generator v1.0");
/*  45 */     setResizable(false);
/*  46 */     getContentPane().setLayout(null);
/*     */     
/*  48 */     JLabel lblPackage = new JLabel("Package:");
/*  49 */     lblPackage.setBounds(175, 14, 46, 14);
/*  50 */     getContentPane().add(lblPackage);
/*     */     
/*  52 */     this.packageField = new JTextField();
/*  53 */     this.packageField.setToolTipText("me.<name>.<project>");
/*  54 */     this.packageField.setBounds(225, 11, 154, 20);
/*  55 */     getContentPane().add(this.packageField);
/*  56 */     this.packageField.setColumns(10);
/*     */     
/*  58 */     JLabel lblClass = new JLabel("Class:");
/*  59 */     lblClass.setBounds(175, 42, 46, 14);
/*  60 */     getContentPane().add(lblClass);
/*     */     
/*  62 */     this.classField = new JTextField();
/*  63 */     this.classField.setBounds(225, 39, 154, 20);
/*  64 */     getContentPane().add(this.classField);
/*  65 */     this.classField.setColumns(10);
/*     */     
/*  67 */     this.radioMainClass = new JRadioButton("Main Class");
/*  68 */     this.radioMainClass.setBounds(6, 91, 109, 23);
/*  69 */     getContentPane().add(this.radioMainClass);
/*     */     
/*  71 */     this.radioJFrame = new JRadioButton("JFrame");
/*  72 */     this.radioJFrame.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent e) {
/*  74 */         if (JavaFrame.this.radioJFrame.isSelected()) {
/*  75 */           JavaFrame.this.layoutCombo.setEnabled(true);
/*  76 */           JavaFrame.this.titleField.setEnabled(true);
/*  77 */           JavaFrame.this.widthField.setEnabled(true);
/*  78 */           JavaFrame.this.rdbtnResizable.setEnabled(true);
/*  79 */           JavaFrame.this.lengthField.setEnabled(true);
/*     */         } else {
/*  81 */           JavaFrame.this.layoutCombo.setEnabled(false);
/*  82 */           JavaFrame.this.titleField.setEnabled(false);
/*  83 */           JavaFrame.this.widthField.setEnabled(false);
/*  84 */           JavaFrame.this.rdbtnResizable.setEnabled(false);
/*  85 */           JavaFrame.this.lengthField.setEnabled(false);
/*     */         }
/*     */       }
/*  88 */     });
/*  89 */     this.radioJFrame.setBounds(117, 91, 109, 23);
/*  90 */     getContentPane().add(this.radioJFrame);
/*     */     
/*  92 */     this.layoutCombo = new JComboBox();
/*  93 */     this.layoutCombo.setEnabled(false);
/*  94 */     this.layoutCombo.setModel(new DefaultComboBoxModel(new String[] { "null" }));
/*  95 */     this.layoutCombo.setBounds(165, 246, 61, 20);
/*  96 */     getContentPane().add(this.layoutCombo);
/*     */     
/*  98 */     this.lblLayout = new JLabel("Layout ");
/*  99 */     this.lblLayout.setBounds(124, 249, 46, 14);
/* 100 */     getContentPane().add(this.lblLayout);
/*     */     
/* 102 */     this.lblTitle = new JLabel("Title ");
/* 103 */     this.lblTitle.setBounds(124, 131, 30, 14);
/* 104 */     getContentPane().add(this.lblTitle);
/*     */     
/* 106 */     this.titleField = new JTextField();
/* 107 */     this.titleField.setEnabled(false);
/* 108 */     this.titleField.setBounds(151, 128, 77, 20);
/* 109 */     getContentPane().add(this.titleField);
/* 110 */     this.titleField.setColumns(10);
/*     */     
/* 112 */     this.lblWidth = new JLabel("Width");
/* 113 */     this.lblWidth.setBounds(124, 162, 35, 14);
/* 114 */     getContentPane().add(this.lblWidth);
/*     */     
/* 116 */     this.widthField = new JTextField();
/* 117 */     this.widthField.setEnabled(false);
/* 118 */     this.widthField.setBounds(159, 156, 69, 20);
/* 119 */     getContentPane().add(this.widthField);
/* 120 */     this.widthField.setColumns(10);
/*     */     
/* 122 */     this.lblLength = new JLabel("Length");
/* 123 */     this.lblLength.setBounds(122, 193, 35, 14);
/* 124 */     getContentPane().add(this.lblLength);
/*     */     
/* 126 */     this.lengthField = new JTextField();
/* 127 */     this.lengthField.setEnabled(false);
/* 128 */     this.lengthField.setColumns(10);
/* 129 */     this.lengthField.setBounds(157, 187, 69, 20);
/* 130 */     getContentPane().add(this.lengthField);
/*     */     
/* 132 */     this.rdbtnResizable = new JRadioButton("Resizable");
/* 133 */     this.rdbtnResizable.setEnabled(false);
/* 134 */     this.rdbtnResizable.setBounds(117, 214, 109, 23);
/* 135 */     getContentPane().add(this.rdbtnResizable);
/*     */     
/* 137 */     JButton btnCreate = new JButton("Create");
/* 138 */     btnCreate.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 140 */         if ((JavaFrame.this.getPackage().equals("")) || (JavaFrame.this.getClassName().equals(""))) {
/* 141 */           JOptionPane.showMessageDialog(JavaFrame.this, "The package or class name is empty! Please fill them out before creating a class", "Error", 0);
/* 142 */           return;
/*     */         }
/* 144 */         if ((JavaFrame.this.radioJFrame.isSelected()) && (
/* 145 */           (!JavaFrame.this.onlyNums(JavaFrame.this.widthField.getText())) || (!JavaFrame.this.onlyNums(JavaFrame.this.lengthField.getText())))) {
/* 146 */           JOptionPane.showMessageDialog(JavaFrame.this, "<html>Width or length is not an integer!</html>", "Error", 0);
/* 147 */           return;
/*     */         }
/*     */         
/* 150 */         CreateClass.create(JavaFrame.this.getPackage(), JavaFrame.this.getClassName(), JavaFrame.this);
/* 151 */         JOptionPane.showMessageDialog(JavaFrame.this, "<html>Class created<br>Saved to: " + CreateClass.getSaveLocation(JavaFrame.this.getClassName()) + "</html>", "Class created", 1);
/* 152 */         JavaFrame.this.packageField.setText("");
/* 153 */         JavaFrame.this.classField.setText("");
/* 154 */         JavaFrame.this.radioMainClass.setSelected(false);
/* 155 */         JavaFrame.this.radioJFrame.setSelected(false);
/*     */       }
/* 157 */     });
/* 158 */     btnCreate.setBounds(241, 430, 97, 30);
/* 159 */     getContentPane().add(btnCreate);
/*     */     
/* 161 */     getRootPane().setDefaultButton(btnCreate);
/*     */   }
/*     */   
/*     */   public boolean onlyNums(String field) {
/* 165 */     if (field.matches("[0-9]+")) {
/* 166 */       return true;
/*     */     }
/* 168 */     return false;
/*     */   }
/*     */   
/*     */   public String getPackage() {
/* 172 */     return this.packageField.getText();
/*     */   }
/*     */   
/*     */   public String getClassName() {
/* 176 */     return this.classField.getText();
/*     */   }
/*     */   
/*     */   public JRadioButton getRadioMainClass() {
/* 180 */     return this.radioMainClass;
/*     */   }
/*     */   
/*     */   public JRadioButton getRadioJFrame() {
/* 184 */     return this.radioJFrame;
/*     */   }
/*     */   
/*     */   public JComboBox<?> getLayoutCombo() {
/* 188 */     return this.layoutCombo;
/*     */   }
/*     */   
/*     */   public JTextField getTitleField() {
/* 192 */     return this.titleField;
/*     */   }
/*     */   
/*     */   public JTextField getWidthField() {
/* 196 */     return this.widthField;
/*     */   }
/*     */   
/*     */   public JTextField getLengthField() {
/* 200 */     return this.lengthField;
/*     */   }
/*     */   
/*     */   public JRadioButton getRdbtnResizable() {
/* 204 */     return this.rdbtnResizable;
/*     */   }
/*     */ }
