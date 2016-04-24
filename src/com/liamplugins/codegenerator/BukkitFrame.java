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
/*     */ public class BukkitFrame extends javax.swing.JFrame
/*     */ {
/*     */   private static final long serialVersionUID = -6357582889580637741L;
/*     */   private JTextField packageField;
/*     */   private JTextField classField;
/*     */   private JRadioButton radioMainClass;
/*     */   private JRadioButton rdbtnOnDisable;
/*     */   private JRadioButton rdbtnConfig;
/*     */   private JRadioButton radioCommand;
/*     */   private JRadioButton radioPlayerOnly;
/*     */   private JRadioButton rdbtnPermission;
/*     */   private JTextField permissionField;
/*     */   private JRadioButton rdbtnEvents;
/*     */   private JLabel lblMethodName;
/*     */   private JTextField methodField;
/*     */   private JComboBox eventCombo;
/*     */   private JLabel lblEvent;
/*     */   private JLabel lblCurrentlyOnlyPlayer;
/*     */   
/*     */   public BukkitFrame()
/*     */   {
/*     */     try
/*     */     {
/*  41 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/*     */     }
/*     */     catch (Exception localException) {}
/*  44 */     setDefaultCloseOperation(3);
/*  45 */     setBounds(100, 100, 600, 500);
/*  46 */     setTitle("Code Generator v1.0");
/*  47 */     setResizable(false);
/*  48 */     getContentPane().setLayout(null);
/*     */     
/*  50 */     JLabel lblPackage = new JLabel("Package:");
/*  51 */     lblPackage.setBounds(175, 14, 46, 14);
/*  52 */     getContentPane().add(lblPackage);
/*     */     
/*  54 */     this.packageField = new JTextField();
/*  55 */     this.packageField.setToolTipText("me.<name>.<project>");
/*  56 */     this.packageField.setBounds(225, 11, 154, 20);
/*  57 */     getContentPane().add(this.packageField);
/*  58 */     this.packageField.setColumns(10);
/*     */     
/*  60 */     JLabel lblClass = new JLabel("Class:");
/*  61 */     lblClass.setBounds(175, 42, 46, 14);
/*  62 */     getContentPane().add(lblClass);
/*     */     
/*  64 */     this.classField = new JTextField();
/*  65 */     this.classField.setBounds(225, 39, 154, 20);
/*  66 */     getContentPane().add(this.classField);
/*  67 */     this.classField.setColumns(10);
/*     */     
/*  69 */     this.radioMainClass = new JRadioButton("Main Class");
/*  70 */     this.radioMainClass.setBounds(6, 91, 109, 23);
/*  71 */     this.radioMainClass.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent e) {
/*  73 */         if (BukkitFrame.this.radioMainClass.isSelected()) {
/*  74 */           BukkitFrame.this.rdbtnOnDisable.setEnabled(true);
/*  75 */           BukkitFrame.this.rdbtnConfig.setEnabled(true);
/*     */         } else {
/*  77 */           BukkitFrame.this.rdbtnOnDisable.setEnabled(false);
/*  78 */           BukkitFrame.this.rdbtnConfig.setEnabled(false);
/*     */         }
/*     */       }
/*  81 */     });
/*  82 */     getContentPane().add(this.radioMainClass);
/*     */     
/*  84 */     this.rdbtnOnDisable = new JRadioButton("onDisable");
/*  85 */     this.rdbtnOnDisable.setEnabled(false);
/*  86 */     this.rdbtnOnDisable.setBounds(16, 117, 109, 23);
/*  87 */     getContentPane().add(this.rdbtnOnDisable);
/*     */     
/*  89 */     this.rdbtnConfig = new JRadioButton("Use Config");
/*  90 */     this.rdbtnConfig.setEnabled(false);
/*  91 */     this.rdbtnConfig.setBounds(16, 142, 109, 23);
/*  92 */     getContentPane().add(this.rdbtnConfig);
/*     */     
/*  94 */     JButton btnCreate = new JButton("Create");
/*  95 */     btnCreate.setBounds(241, 430, 97, 30);
/*  96 */     getContentPane().add(btnCreate);
/*     */     
/*  98 */     getRootPane().setDefaultButton(btnCreate);
/*     */     
/* 100 */     this.radioCommand = new JRadioButton("Command");
/* 101 */     this.radioCommand.setBounds(112, 91, 109, 23);
/* 102 */     this.radioCommand.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent e) {
/* 104 */         if (BukkitFrame.this.radioCommand.isSelected()) {
/* 105 */           BukkitFrame.this.radioPlayerOnly.setEnabled(true);
/* 106 */           BukkitFrame.this.rdbtnPermission.setEnabled(true);
/* 107 */           BukkitFrame.this.permissionField.setEnabled(true);
/*     */         } else {
/* 109 */           BukkitFrame.this.radioPlayerOnly.setEnabled(false);
/* 110 */           BukkitFrame.this.rdbtnPermission.setEnabled(false);
/* 111 */           BukkitFrame.this.permissionField.setEnabled(false);
/*     */         }
/*     */       }
/* 114 */     });
/* 115 */     getContentPane().add(this.radioCommand);
/*     */     
/* 117 */     this.radioPlayerOnly = new JRadioButton("Player only");
/* 118 */     this.radioPlayerOnly.setEnabled(false);
/* 119 */     this.radioPlayerOnly.setBounds(127, 117, 109, 23);
/* 120 */     getContentPane().add(this.radioPlayerOnly);
/*     */     
/* 122 */     this.rdbtnPermission = new JRadioButton("Permission");
/* 123 */     this.rdbtnPermission.setEnabled(false);
/* 124 */     this.rdbtnPermission.setBounds(127, 142, 109, 23);
/* 125 */     getContentPane().add(this.rdbtnPermission);
/*     */     
/* 127 */     JLabel lblPermission = new JLabel("Permission");
/* 128 */     lblPermission.setBounds(137, 168, 50, 14);
/* 129 */     getContentPane().add(lblPermission);
/*     */     
/* 131 */     this.permissionField = new JTextField();
/* 132 */     this.permissionField.setEnabled(false);
/* 133 */     this.permissionField.setBounds(197, 165, 86, 20);
/* 134 */     getContentPane().add(this.permissionField);
/* 135 */     this.permissionField.setColumns(10);
/*     */     
/* 137 */     this.rdbtnEvents = new JRadioButton("Events");
/* 138 */     this.rdbtnEvents.setBounds(310, 91, 109, 23);
/* 139 */     this.rdbtnEvents.addChangeListener(new ChangeListener() {
/*     */       public void stateChanged(ChangeEvent e) {
/* 141 */         if (BukkitFrame.this.rdbtnEvents.isSelected()) {
/* 142 */           BukkitFrame.this.methodField.setEnabled(true);
/* 143 */           BukkitFrame.this.eventCombo.setEnabled(true);
/*     */         } else {
/* 145 */           BukkitFrame.this.methodField.setEnabled(false);
/* 146 */           BukkitFrame.this.eventCombo.setEnabled(false);
/*     */         }
/*     */       }
/* 149 */     });
/* 150 */     getContentPane().add(this.rdbtnEvents);
/*     */     
/* 152 */     this.lblMethodName = new JLabel("Method name");
/* 153 */     this.lblMethodName.setBounds(320, 117, 76, 14);
/* 154 */     getContentPane().add(this.lblMethodName);
/*     */     
/* 156 */     this.methodField = new JTextField();
/* 157 */     this.methodField.setEnabled(false);
/* 158 */     this.methodField.setBounds(391, 114, 86, 20);
/* 159 */     getContentPane().add(this.methodField);
/* 160 */     this.methodField.setColumns(10);
/*     */     
/* 162 */     this.eventCombo = new JComboBox();
/* 163 */     this.eventCombo.setModel(new DefaultComboBoxModel(new String[] { "AsyncPlayerChatEvent", "AsyncPlayerPreLoginEvent", "PlayerAchievementAwardedEvent", "PlayerAnimationEvent", "PlayerBedEnterEvent", "PlayerBedLeaveEvent", "PlayerBucketEmptyEvent", "PlayerBucketEvent", "PlayerBucketFillEvent", "PlayerChangedWorldEvent", "PlayerChannelEvent", "PlayerChatEvent", "PlayerChatTabCompleteEvent", "PlayerCommandPreprocessEvent", "PlayerDropItemEvent", "PlayerEditBookEvent", "PlayerEggThrowEvent", "PlayerEvent", "PlayerExpChangeEvent", "PlayerFishEvent", "PlayerGameModeChangeEvent", "PlayerInteractEntityEvent", "PlayerInteractEvent", "PlayerInventoryEvent", "PlayerItemBreakEvent", "PlayerItemConsumeEvent", "PlayerItemHeldEvent", "PlayerJoinEvent", "PlayerKickEvent", "PlayerLevelChangeEvent", "PlayerLoginEvent", "PlayerMoveEvent", "PlayerPickupItemEvent", "PlayerPortalEvent", "PlayerPreLoginEvent", "PlayerQuitEvent", "PlayerRegisterChannelEvent", "PlayerRespawnEvent", "PlayerShearEntityEvent", "PlayerStatisticIncrementEvent", "PlayerTeleportEvent", "PlayerToggleFlightEvent", "PlayerToggleSneakEvent", "PlayerToggleSprintEvent", "PlayerUnleashEntityEvent", "PlayerUnregisterChannelEvent", "PlayerVelocityEvent" }));
/* 164 */     this.eventCombo.setEnabled(false);
/* 165 */     this.eventCombo.setBounds(353, 143, 154, 20);
/* 166 */     getContentPane().add(this.eventCombo);
/*     */     
/* 168 */     this.lblEvent = new JLabel("Event");
/* 169 */     this.lblEvent.setBounds(320, 146, 35, 14);
/* 170 */     getContentPane().add(this.lblEvent);
/*     */     
/* 172 */     this.lblCurrentlyOnlyPlayer = new JLabel("Currently only player events!");
/* 173 */     this.lblCurrentlyOnlyPlayer.setForeground(UIManager.getColor("Button.disabledForeground"));
/* 174 */     this.lblCurrentlyOnlyPlayer.setBounds(363, 168, 144, 14);
/* 175 */     getContentPane().add(this.lblCurrentlyOnlyPlayer);
/*     */     
/* 177 */     btnCreate.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 179 */         if ((BukkitFrame.this.getPackage().equals("")) || (BukkitFrame.this.getClassName().equals(""))) {
/* 180 */           JOptionPane.showMessageDialog(BukkitFrame.this, "The package or class name is empty! Please fill them out before creating a class", "Error", 0);
/* 181 */           return;
/*     */         }
/* 183 */         CreateClass.create(BukkitFrame.this.getPackage(), BukkitFrame.this.getClassName(), BukkitFrame.this);
/* 184 */         JOptionPane.showMessageDialog(BukkitFrame.this, "<html>Class created<br>Saved to: " + CreateClass.getSaveLocation(BukkitFrame.this.getClassName()) + "</html>", "Class created", 1);
/* 185 */         BukkitFrame.this.packageField.setText("");
/* 186 */         BukkitFrame.this.classField.setText("");
/* 187 */         BukkitFrame.this.methodField.setText("");
/* 188 */         BukkitFrame.this.permissionField.setText("");
/* 189 */         BukkitFrame.this.radioMainClass.setSelected(false);
/* 190 */         BukkitFrame.this.rdbtnOnDisable.setSelected(false);
/* 191 */         BukkitFrame.this.rdbtnConfig.setSelected(false);
/* 192 */         BukkitFrame.this.radioCommand.setSelected(false);
/* 193 */         BukkitFrame.this.radioPlayerOnly.setSelected(false);
/* 194 */         BukkitFrame.this.rdbtnPermission.setSelected(false);
/* 195 */         BukkitFrame.this.rdbtnEvents.setSelected(false);
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public boolean onlyNums(String field) {
/* 201 */     if (field.matches("[0-9]+")) {
/* 202 */       return true;
/*     */     }
/* 204 */     return false;
/*     */   }
/*     */   
/*     */   public String getPackage() {
/* 208 */     return this.packageField.getText();
/*     */   }
/*     */   
/*     */   public String getClassName() {
/* 212 */     return this.classField.getText();
/*     */   }
/*     */   
/*     */   public JRadioButton getRadioMainClass() {
/* 216 */     return this.radioMainClass;
/*     */   }
/*     */   
/*     */   public JRadioButton getOnDisable() {
/* 220 */     return this.rdbtnOnDisable;
/*     */   }
/*     */   
/*     */   public JRadioButton getUseConfig() {
/* 224 */     return this.rdbtnConfig;
/*     */   }
/*     */   
/*     */   public JRadioButton getCommand() {
/* 228 */     return this.radioCommand;
/*     */   }
/*     */   
/*     */   public JRadioButton getPlayerOnly() {
/* 232 */     return this.radioPlayerOnly;
/*     */   }
/*     */   
/*     */   public JRadioButton getUsePermission() {
/* 236 */     return this.rdbtnPermission;
/*     */   }
/*     */   
/*     */   public JTextField getPermission() {
/* 240 */     return this.permissionField;
/*     */   }
/*     */   
/*     */   public JRadioButton getEvents() {
/* 244 */     return this.rdbtnEvents;
/*     */   }
/*     */   
/*     */   public JComboBox<?> getEventCombo() {
/* 248 */     return this.eventCombo;
/*     */   }
/*     */   
/*     */   public JTextField getMethodName() {
/* 252 */     return this.methodField;
/*     */   }
/*     */ }
