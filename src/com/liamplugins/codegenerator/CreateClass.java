/*     */ package com.liamplugins.codegenerator;
/*     */ 
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import javax.swing.JRadioButton;
/*     */ 
/*     */ public class CreateClass
/*     */ {
/*  10 */   private static File dir = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Generated Classes");
/*     */   
/*     */   public static void create(String packageName, String className, JavaFrame jf) {
/*  13 */     if (!dir.exists()) {
/*  14 */       dir.mkdir();
/*     */     }
/*  16 */     File generatedClass = new File(dir + File.separator + className + ".java");
/*     */     try {
/*  18 */       generatedClass.createNewFile();
/*     */     } catch (IOException e) {
/*  20 */       e.printStackTrace();
/*     */     }
/*     */     
/*  23 */     boolean jFrame = jf.getRadioJFrame().isSelected();
/*  24 */     boolean mainClass = jf.getRadioMainClass().isSelected();
/*     */     try
/*     */     {
/*  27 */       java.io.FileWriter fw = new java.io.FileWriter(generatedClass);
/*  28 */       BufferedWriter bw = new BufferedWriter(fw);
/*     */       
/*  30 */       write(bw, "package " + packageName + ";");
/*  31 */       write(bw, "");
/*  32 */       if (jFrame) {
/*  33 */         write(bw, "import javax.swing.JFrame;");
/*  34 */         write(bw, "import javax.swing.UIManager;");
/*  35 */         write(bw, "import javax.swing.UnsupportedLookAndFeelException;");
/*  36 */         write(bw, "");
/*     */       }
/*  38 */       write(bw, "public class " + className + (jFrame ? " extends JFrame " : " ") + "{");
/*  39 */       write(bw, "");
/*  40 */       if (jFrame) {
/*  41 */         write(bw, tab() + "public " + className + "(){");
/*  42 */         write(bw, tab(2) + "try {");
/*  43 */         write(bw, tab(3) + "UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());");
/*  44 */         write(bw, tab(2) + "} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {");
/*  45 */         write(bw, tab(3) + "e.printStackTrace();");
/*  46 */         write(bw, tab(2) + "}");
/*  47 */         write(bw, tab(2) + "setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);");
/*  48 */         write(bw, tab(2) + "setBounds(50, 50, " + jf.getWidthField().getText() + ", " + jf.getLengthField().getText() + ");");
/*  49 */         write(bw, tab(2) + "setTitle(\"" + jf.getTitleField().getText() + "\");");
/*  50 */         write(bw, tab(2) + "setResizable(" + jf.getRdbtnResizable().isSelected() + ");");
/*  51 */         write(bw, tab(2) + "getContentPane().setLayout(" + jf.getLayoutCombo().getModel().getSelectedItem() + ");");
/*  52 */         write(bw, tab() + "}");
/*     */       }
/*     */       
/*  55 */       if (mainClass) {
/*  56 */         write(bw, tab() + "public static void main(String[] args){");
/*  57 */         write(bw, tab(2));
/*  58 */         write(bw, tab() + "}");
/*     */       }
/*  60 */       write(bw, "}");
/*  61 */       bw.flush();
/*  62 */       bw.close();
/*     */     } catch (Exception e) {
/*  64 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void create(String packageName, String className, BukkitFrame bf)
/*     */   {
/*  71 */     long a = System.currentTimeMillis();
/*  72 */     if (!dir.exists()) {
/*  73 */       dir.mkdir();
/*     */     }
/*  75 */     File generatedClass = new File(dir + File.separator + className + ".java");
/*     */     try {
/*  77 */       generatedClass.createNewFile();
/*     */     } catch (IOException e) {
/*  79 */       e.printStackTrace();
/*     */     }
/*     */     
/*  82 */     boolean mainClass = bf.getRadioMainClass().isSelected();
/*  83 */     boolean onDisable = bf.getOnDisable().isSelected();
/*  84 */     boolean config = bf.getUseConfig().isSelected();
/*     */     
/*  86 */     boolean command = bf.getCommand().isSelected();
/*  87 */     boolean playerOnly = bf.getPlayerOnly().isSelected();
/*  88 */     boolean usePermissions = bf.getUsePermission().isSelected();
/*     */     
/*  90 */     boolean events = bf.getEvents().isSelected();
/*     */     try
/*     */     {
/*  93 */       java.io.FileWriter fw = new java.io.FileWriter(generatedClass);
/*  94 */       BufferedWriter bw = new BufferedWriter(fw);
/*     */       
/*  96 */       write(bw, "package " + packageName + ";");
/*  97 */       write(bw, "");
/*     */       
/*  99 */       if (mainClass) {
/* 100 */         write(bw, "import org.bukkit.plugin.java.JavaPlugin;");
/*     */       }
/* 102 */       if (command) {
/* 103 */         write(bw, "import org.bukkit.command.CommandExecutor;");
/* 104 */         write(bw, "import org.bukkit.command.CommandSender;");
/* 105 */         write(bw, "import org.bukkit.command.Command;");
/*     */       }
/* 107 */       if ((command) && (playerOnly)) {
/* 108 */         write(bw, "import org.bukkit.entity.Player;");
/*     */       }
/* 110 */       if (events) {
/* 111 */         write(bw, "import org.bukkit.event.Listener;");
/* 112 */         write(bw, "import org.bukkit.event.EventHandler;");
/* 113 */         write(bw, "import org.bukkit.event.player." + bf.getEventCombo().getSelectedItem() + ";");
/*     */       }
/*     */       
/* 116 */       write(bw, "");
/* 117 */       write(bw, "/*");
/* 118 */       write(bw, " * Generated using CodeGenerator " + Main.getVersion() + " made by DUFC_Liam");
/*     */       
/* 120 */       write(bw, " */");
/*     */       
/* 122 */       write(bw, "");
/* 123 */       write(bw, "public class " + className + (mainClass ? " extends JavaPlugin" : "") + (command ? " implements CommandExecutor" : "") + (events ? " implements Listener" : command ? ", Listener" : "") + " {");
/* 124 */       write(bw, "");
/* 125 */       if (mainClass) {
/* 126 */         write(bw, tab() + "@Override");
/* 127 */         write(bw, tab() + "public void onEnable(){");
/* 128 */         if (config) {
/* 129 */           write(bw, tab(2) + "saveDefaultConfig();");
/*     */         }
/* 131 */         write(bw, tab(2));
/* 132 */         write(bw, tab() + "}");
/* 133 */         write(bw, tab());
/*     */       }
/* 135 */       if (onDisable) {
/* 136 */         write(bw, tab() + "@Override");
/* 137 */         write(bw, tab() + "public void onDisable(){");
/* 138 */         write(bw, tab(2));
/* 139 */         write(bw, tab() + "}");
/* 140 */         write(bw, tab());
/*     */       }
/*     */       
/*     */ 
/* 144 */       if (command) {
/* 145 */         write(bw, tab() + "@Override");
/* 146 */         write(bw, tab() + "public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){");
/* 147 */         if (playerOnly) {
/* 148 */           write(bw, tab(2) + "if(sender instanceof Player){");
/* 149 */           write(bw, tab(3) + "Player player = (Player) sender;");
/* 150 */           if (usePermissions) {
/* 151 */             write(bw, tab(3) + "if(player.hasPermission(\"" + bf.getPermission().getText() + "\")){");
/* 152 */             write(bw, tab(4));
/* 153 */             write(bw, tab(3) + "}");
/*     */           }
/* 155 */           write(bw, tab(2) + "}");
/*     */         }
/* 157 */         write(bw, tab(2) + "return false;");
/* 158 */         write(bw, tab() + "}");
/* 159 */         write(bw, tab());
/*     */       }
/*     */       
/*     */ 
/* 163 */       if (events) {
/* 164 */         write(bw, tab() + "@EventHandler");
/* 165 */         write(bw, tab() + "public void " + bf.getMethodName().getText() + "(" + bf.getEventCombo().getSelectedItem() + " e){");
/* 166 */         write(bw, tab(2));
/* 167 */         write(bw, tab() + "}");
/*     */       }
/*     */       
/* 170 */       write(bw, "}");
/* 171 */       bw.flush();
/* 172 */       bw.close();
/* 173 */       long b = System.currentTimeMillis() - a;
/* 174 */       System.out.println("Generated in " + b + " milliseconds");
/*     */     } catch (Exception e) {
/* 176 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getSaveLocation(String className) {
/* 181 */     return dir.getAbsolutePath() + File.separator + className + ".java";
/*     */   }
/*     */   
/*     */   private static void write(BufferedWriter bw, String line) throws IOException {
/* 185 */     bw.append(line + end());
/*     */   }
/*     */   
/*     */   private static String tab() {
/* 189 */     return "    ";
/*     */   }
/*     */   
/*     */   private static String tab(int tabs) {
/* 193 */     String tab = "";
/* 194 */     for (int i = 0; i < tabs; i++) {
/* 195 */       tab = tab + "    ";
/*     */     }
/* 197 */     return tab;
/*     */   }
/*     */   
/*     */   private static String end() {
/* 201 */     return "\n";
/*     */   }
/*     */ }