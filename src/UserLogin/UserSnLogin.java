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
    }
    Connection Con = null;
//    Statement St = null;
//    ResultSet Rs = null;
   
    
    public void insertSignUpDetails(){
        String username = signUsername.getText();
        String password = signPass.getText();
        String email = signEmail.getText();
        String contact = signContact.getText();
        String university = uniCombo.getSelectedItem().toString();
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            String sql = "insert into Applicant_Dir(ApplicantName,Email,Contact,UniName,Password) values(?,?,?,?,?)"; 
            PreparedStatement St = Con.prepareStatement(sql);
            St.setString(1, username);
            St.setString(2, email);
            St.setString(3, contact);
            St.setString(4, university);
            St.setString(5, password);
            int RowCount=St.executeUpdate();
            
            if(RowCount>0){
                JOptionPane.showMessageDialog(this, "Record Inserted Successfully!");
                signUsername.setText(" ");
                signPass.setText(" ");
                signEmail.setText(" ");
                signContact.setText(" ");
                uniCombo.setSelectedItem("Select");
               
            }else{
                JOptionPane.showMessageDialog(this, "Record Insertion Failed");
            }
            Con.close();
        }catch(Exception e){
            e.printStackTrace();
            }
    }
    
    public boolean validationofSignup(){
        String username = signUsername.getText();
        String password = signPass.getText();
        String email = signEmail.getText();
        String contact = signContact.getText();
        String university = uniCombo.getSelectedItem().toString();
        
        if (username.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Username");
            return false;
        }
        if (password.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Password");
            return false;
        }
        if (email.equals("") || !email.matches("^[a-zA-Z0-9]{0,30}[@][a-zA-Z]{0,10}[.][a-zA-Z]{0,4}$")){
            JOptionPane.showMessageDialog(this, "Please Enter valid Email");
            return false;
        }
        if (contact.equals("")){
            JOptionPane.showMessageDialog(this, "Please Enter Contact Number");
            return false;
        }
        if (university.equals("Select")){
            JOptionPane.showMessageDialog(this, "Please Select University");
            return false;
        }
        return true;
    }
    
    public boolean checkDuplicateUser(){
        String email = signEmail.getText();;
        boolean isExist = false;
        try{
               Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
               PreparedStatement St= Con.prepareStatement("Select * from Applicant_Dir where Email= ?");
               St.setString(1, email);
              
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        signUsername = new javax.swing.JTextField();
        signPass = new javax.swing.JTextField();
        signContact = new javax.swing.JTextField();
        signEmail = new javax.swing.JTextField();
        uniCombo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnSignup = new javax.swing.JButton();
        signReset = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        loginUserEmail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        loginPass = new javax.swing.JPasswordField();
        btnUserLogin = new javax.swing.JButton();
        userForget = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("STIXIntegralsSm", 1, 18)); // NOI18N
        jLabel1.setText("New here? Sign up below");

        jLabel2.setFont(new java.awt.Font("STIXIntegralsUp", 0, 14)); // NOI18N
        jLabel2.setText("Username");

        jLabel4.setFont(new java.awt.Font("STIXIntegralsUp", 0, 14)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("STIXIntegralsUp", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("STIXIntegralsUp", 0, 14)); // NOI18N
        jLabel6.setText("Contact");

        jLabel7.setFont(new java.awt.Font("STIXIntegralsUp", 0, 14)); // NOI18N
        jLabel7.setText("University Name");

        jLabel3.setIcon(new javax.swing.ImageIcon("/Users/anamikaverma/Desktop/Images/icons8_Account_50px.png")); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon("/Users/anamikaverma/Desktop/Images/icons8_Secure_50px.png")); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon("/Users/anamikaverma/Desktop/Images/icons8_Secured_Letter_50px.png")); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon("/Users/anamikaverma/Desktop/Images/icons8_Google_Mobile_50px.png")); // NOI18N

        signUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                signUsernameFocusLost(evt);
            }
        });
        signUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUsernameActionPerformed(evt);
            }
        });

        signEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                signEmailFocusLost(evt);
            }
        });
        signEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signEmailActionPerformed(evt);
            }
        });

        uniCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Item 1", "Item 2", "Item 3", "Item 4" }));
        uniCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uniComboActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon("/Users/anamikaverma/Desktop/Images/university-building-flat-icon-white-isolated-background-eps-file-available-94530948.jpeg")); // NOI18N

        btnSignup.setFont(new java.awt.Font("STIXIntegralsUp", 1, 14)); // NOI18N
        btnSignup.setText("Sign Up");
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });

        signReset.setFont(new java.awt.Font("STIXIntegralsUp", 1, 14)); // NOI18N
        signReset.setText("Reset");

        jLabel12.setIcon(new javax.swing.ImageIcon("/Users/anamikaverma/Downloads/login page photo.jpeg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(signPass)
                                .addGap(4, 4, 4))
                            .addComponent(signUsername)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSignup)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(uniCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(8, 8, 8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(signContact)
                                        .addGap(4, 4, 4))
                                    .addComponent(signEmail)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(signReset)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(signUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(signPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(signEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(signContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel10)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(uniCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel11)))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSignup)
                    .addComponent(signReset))
                .addContainerGap(89, Short.MAX_VALUE))
        );

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

        userForget.setFont(new java.awt.Font("Palatino", 0, 12)); // NOI18N
        userForget.setText("Forgot Password?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(loginUserEmail)
                            .addComponent(loginPass, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btnUserLogin))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(userForget, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel13)
                .addGap(46, 46, 46)
                .addComponent(jLabel14)
                .addGap(29, 29, 29)
                .addComponent(loginUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel15)
                .addGap(32, 32, 32)
                .addComponent(loginPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnUserLogin)
                .addGap(18, 18, 18)
                .addComponent(userForget)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(589, 589, 589)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_signEmailActionPerformed

    private void uniComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uniComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uniComboActionPerformed

    private void loginUserEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginUserEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginUserEmailActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        if(validationofSignup()==true){
            if(checkDuplicateUser()==false){
                insertSignUpDetails();
            }else{
            JOptionPane.showMessageDialog(this, "User already exists");
            }
        
        }
    }//GEN-LAST:event_btnSignupActionPerformed

    private void btnUserLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserLoginActionPerformed
            if(validateLogin()){
                login();
            }    
    }//GEN-LAST:event_btnUserLoginActionPerformed

    private void signUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUsernameActionPerformed
 
    }//GEN-LAST:event_signUsernameActionPerformed

    private void signUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_signUsernameFocusLost
        
    }//GEN-LAST:event_signUsernameFocusLost

    private void signEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_signEmailFocusLost
        if(checkDuplicateUser()==true){
        JOptionPane.showMessageDialog(this, "User already exists");
        }
    }//GEN-LAST:event_signEmailFocusLost

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
    private javax.swing.JButton btnSignup;
    private javax.swing.JButton btnUserLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField loginPass;
    private javax.swing.JTextField loginUserEmail;
    private javax.swing.JTextField signContact;
    private javax.swing.JTextField signEmail;
    private javax.swing.JTextField signPass;
    private javax.swing.JButton signReset;
    private javax.swing.JTextField signUsername;
    private javax.swing.JComboBox<String> uniCombo;
    private javax.swing.JButton userForget;
    // End of variables declaration//GEN-END:variables
}
