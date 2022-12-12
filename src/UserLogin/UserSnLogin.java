/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UserLogin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anamikaverma
 */
public class UserSnLogin extends javax.swing.JFrame {

    /**
     * Creates new form UserSnLogin
     */
    public UserSnLogin() {
        initComponents();
        showdata();
    }
    Connection Con = null;
//    Statement St = null;
//    ResultSet Rs = null;
   
    public void showdata(){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            PreparedStatement show= Con.prepareStatement("select * from Uni_Dir");
            ResultSet Rs = show.executeQuery();
            ResultSetMetaData rsmd = Rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            int cols = rsmd.getColumnCount();
            String [] colName = new String[cols];
            String id,name;
            while (Rs.next()){
                id=Rs.getString(1);
                name=Rs.getString(2);
                String[] row = {id,name};
                model.addRow(row);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }   
        
    }
    
    public void insertSignUpDetails(){
        String name = AppName.getText();
        String pwd = password.getText();
        String Email = email.getText();
        String Contact = contact.getText();
        String university = Uni_ID.getText();
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            String sql = "insert into Applicant_Dir(ApplicantName,Email,Contact,Password,UniID) values(?,?,?,?,?)"; 
            PreparedStatement St = Con.prepareStatement(sql);
            St.setString(1, name);
            St.setString(2, Email);
            St.setString(3, Contact);
            St.setString(4, pwd);
            St.setString(5, university);
            int RowCount=St.executeUpdate();
            
            if(RowCount>0){
                JOptionPane.showMessageDialog(this, "Signed up Successfully!");
                AppName.setText("");
                password.setText("");
                email.setText("");
                contact.setText("");
                Uni_ID.setText("");
               
            }else{
                JOptionPane.showMessageDialog(this, "Record Insertion Failed");
            }
            Con.close();
        }catch(Exception e){
            e.printStackTrace();
            }
    }
    
    public boolean validationofSignup(){
        String name = AppName.getText();
        String pwd = password.getText();
        String Email = email.getText();
        String Contact = contact.getText();
        String university = Uni_ID.getText();
        
        if (name.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Applicant name");
            return false;
        }
        if (pwd.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Password");
            return false;
        }
        if (Email.equals("") || !Email.matches("^[a-zA-Z0-9]{0,30}[@][a-zA-Z]{0,10}[.][a-zA-Z]{0,4}$")){
            JOptionPane.showMessageDialog(this, "Please Enter valid Email");
            return false;
        }
        if (Contact.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Contact Number");
            return false;
        }
        if (university.equals("Please Select from below table :") || university.equals("")){
            JOptionPane.showMessageDialog(this, "Please Select University");
            return false;
        }
        return true;
    }
    
    public boolean checkDuplicateUser(){
        String Email = email.getText();
        boolean isExist = false;
        try{
               Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
               PreparedStatement St= Con.prepareStatement("Select * from Applicant_Dir where Email= ?");
               St.setString(1, Email);
              
               ResultSet Rs=St.executeQuery();
               if(Rs.next()){
                   isExist =true; 
               }else{
               isExist =false;
               }
        }catch(Exception e){
            e.printStackTrace();
            }
        return isExist;
    }
    
    public boolean validateLogin(){
        String usernameL = loginUserEmail.getText();
        String passwordL = loginPass.getText();
        
        if (usernameL.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter User Email");
            return false;
        }
        if (passwordL.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Password");
            return false;
        }
        return true;
    }
    
    public void login(){
        String usernameL = loginUserEmail.getText();
        String passwordL = loginPass.getText();
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
               PreparedStatement St= Con.prepareStatement("Select * from Applicant_Dir where Email = ? and Password = ?");
               St.setString(1, usernameL);
               St.setString(2, passwordL);
              
               ResultSet Rs=St.executeQuery();
               if(Rs.next()){
                   JOptionPane.showMessageDialog(this, "Login Successful!"); 
                   UserLandingP ulp =new UserLandingP();
                   ulp.setVisible(true);
                   ulp.store_email(usernameL);
                   this.dispose();
               }else{
               JOptionPane.showMessageDialog(this, "Invalid Credentials"); 
               }
        }catch(Exception e){
            e.printStackTrace();
         }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        loginUserEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        loginPass = new javax.swing.JPasswordField();
        btnUserLogin = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AppName = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        Uni_ID = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel13.setFont(new java.awt.Font("STIXIntegralsUp", 1, 18)); // NOI18N
        jLabel13.setText("Welcome! Login Here..");

        jLabel14.setFont(new java.awt.Font("STIXIntegralsUp", 0, 14)); // NOI18N
        jLabel14.setText("User Email");

        loginUserEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginUserEmailActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("STIXIntegralsUp", 0, 14)); // NOI18N
        jLabel15.setText("Password");

        btnUserLogin.setFont(new java.awt.Font("STIXIntegralsUp", 1, 14)); // NOI18N
        btnUserLogin.setText("Login");
        btnUserLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(loginPass, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(loginUserEmail)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(btnUserLogin))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel13)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel13)
                .addGap(52, 52, 52)
                .addComponent(jLabel14)
                .addGap(29, 29, 29)
                .addComponent(loginUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel15)
                .addGap(32, 32, 32)
                .addComponent(loginPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnUserLogin)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel16.setText("New User? Sign up here");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "University ID", "University Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Name :");

        jLabel3.setText("Email ID :");

        jLabel4.setText("Password");

        jLabel5.setText("Contact :");

        jLabel6.setText("University ID :");

        Uni_ID.setText("Please Select from below table :");

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton1.setText("Sign Up");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton3.setText("<<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jLabel16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Uni_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AppName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email)
                                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jButton1)
                        .addGap(142, 142, 142)
                        .addComponent(jButton2)))
                .addGap(77, 77, 77)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel16))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(AppName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Uni_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginUserEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUserEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserEmailActionPerformed

    private void btnUserLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserLoginActionPerformed
            if(validateLogin()){
                login();
            }    
    }//GEN-LAST:event_btnUserLoginActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        Uni_ID.setText((String)model.getValueAt(row, 0));
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            AppName.setText("");
            password.setText("");
            email.setText("");
            contact.setText("");
            Uni_ID.setText("Please Select from below table :");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (validationofSignup()){
            if (checkDuplicateUser() == false){
                insertSignUpDetails();
            }else{
                JOptionPane.showMessageDialog(this, "User already exists");
            }
        }else{
                JOptionPane.showMessageDialog(this, "Record Insertion Failed");
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(UserSnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserSnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserSnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserSnLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserSnLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AppName;
    private javax.swing.JTextField Uni_ID;
    private javax.swing.JButton btnUserLogin;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPasswordField loginPass;
    private javax.swing.JTextField loginUserEmail;
    private javax.swing.JTextField password;
    // End of variables declaration//GEN-END:variables
}
