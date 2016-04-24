/*    */ package com.liamplugins.codegenerator;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.Font;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JMenu;
/*    */ import javax.swing.JMenuBar;
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.UIManager;
/*    */ 
/*    */ public class StartFrame extends JFrame
/*    */ {
/*    */   private static final long serialVersionUID = 3777522450624838381L;
/*    */   
/*    */   public StartFrame()
/*    */   {
/*    */     try
/*    */     {
/* 24 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*    */     } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException e) {
/* 26 */       e.printStackTrace();
/*    */     }
/* 28 */     setDefaultCloseOperation(3);
/* 29 */     setBounds(100, 100, 400, 300);
/* 30 */     setTitle("Code Generator v1.0");
/* 31 */     setResizable(false);
/* 32 */     getContentPane().setLayout(null);
/*    */     
/* 34 */     JMenuBar menuBar = new JMenuBar();
/* 35 */     menuBar.setBounds(0, 0, 594, 21);
/* 36 */     getContentPane().add(menuBar);
/*    */     
/* 38 */     JMenu mnMenu = new JMenu("Menu");
/* 39 */     mnMenu.setFont(new Font("Segoe UI", 0, 13));
/* 40 */     menuBar.add(mnMenu);
/*    */     
/* 42 */     final JLabel label = new JLabel("Coming soon!", 0);
/* 43 */     label.setFont(new Font("Segoe UI", 0, 18));
/*    */     
/* 45 */     JMenuItem mntmSettings = new JMenuItem("Settings");
/* 46 */     mntmSettings.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 48 */         JOptionPane.showMessageDialog(StartFrame.this, label, "Coming soon", -1);
/*    */       }
/*    */       
/* 51 */     });
/* 52 */     mnMenu.add(mntmSettings);
/*    */     
/* 54 */     JMenuItem mntmCredits = new JMenuItem("Credits");
/* 55 */     mntmCredits.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 57 */         JOptionPane.showMessageDialog(StartFrame.this, "<html>Developer: DUFC_Liam</html>", "Credits", 1);
/*    */       }
/* 59 */     });
/* 60 */     mnMenu.add(mntmCredits);
/*    */     
/* 62 */     JButton btnJava = new JButton("Java");
/* 63 */     btnJava.setFont(new Font("Tahoma", 0, 18));
/* 64 */     btnJava.setBounds(10, 69, 167, 109);
/* 65 */     btnJava.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 67 */         JavaFrame jf = new JavaFrame();
/* 68 */         jf.setVisible(true);
/* 69 */         StartFrame.this.dispose();
/*    */       }
/* 71 */     });
/* 72 */     getContentPane().add(btnJava);
/*    */     
/* 74 */     JButton btnBukkit = new JButton("Bukkit");
/* 75 */     btnBukkit.setFont(new Font("Tahoma", 0, 18));
/* 76 */     btnBukkit.setBounds(217, 69, 167, 109);
/* 77 */     btnBukkit.addActionListener(new ActionListener() {
/*    */       public void actionPerformed(ActionEvent e) {
/* 79 */         BukkitFrame bf = new BukkitFrame();
/* 80 */         bf.setVisible(true);
/* 81 */         StartFrame.this.dispose();
/*    */       }
/* 83 */     });
/* 84 */     getContentPane().add(btnBukkit);
/*    */   }
/*    */ }