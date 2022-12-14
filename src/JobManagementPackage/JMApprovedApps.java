/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JobManagementPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author yashaswi_b
 */
public class JMApprovedApps extends javax.swing.JPanel {

    /**
     * Creates new form JMApprovedApps
     */
    public JMApprovedApps() {
        initComponents();
        showData();
        showHRData();
    }
    
    Connection Con = null;
    Statement St = null;
    ResultSet Rs = null;

   
    @SuppressWarnings("unchecked")
    
    
    public void showData(){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            PreparedStatement show= Con.prepareStatement("select * from Applications_Dir where Uni_Status='Confirmed' and Emp_Status='Confirmed'");
            ResultSet Rs = show.executeQuery();
            ResultSetMetaData rsmd = Rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) jobApplicationsTable.getModel();
            model.setRowCount(0);
            int cols = rsmd.getColumnCount();
            String [] colName = new String[cols];
            String applicationId,applicantID, hrid;
            while (Rs.next()){
                applicationId=Rs.getString(1);
                applicantID=Rs.getString(3);
                hrid = Rs.getString(7);
                if (hrid == null){
                String[] row = {applicationId,applicantID};
                model.addRow(row);
            }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }   
        
    }
   
    public void showHRData(){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
            PreparedStatement show= Con.prepareStatement("select * from HR_Dir");
            ResultSet Rs = show.executeQuery();
            ResultSetMetaData rsmd = Rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) hrListTable.getModel();
            model.setRowCount(0);
            int cols = rsmd.getColumnCount();
            String [] colName = new String[cols];
            String hrID,hrName;
            while (Rs.next()){
                hrID=Rs.getString(1);
                hrName=Rs.getString(2);
                String[] row = {hrID,hrName};
                model.addRow(row);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }   
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jobApplicationsTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        hrListTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        applicationIDTextField = new javax.swing.JTextField();
        hrIDTextField = new javax.swing.JTextField();
        assignHRButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        empIDLabel = new javax.swing.JLabel();
        applicantIDLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jobIDLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Approved Job Applications");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setText("Job Applications");

        jobApplicationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Application ID", "Applicant ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jobApplicationsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jobApplicationsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jobApplicationsTable);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setText("HR List");

        hrListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HR ID", "HR Name"
            }
        ));
        hrListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hrListTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(hrListTable);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel4.setText("Enter Application ID:");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel5.setText("Enter HR ID:");

        applicationIDTextField.setEditable(false);
        applicationIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applicationIDTextFieldActionPerformed(evt);
            }
        });

        hrIDTextField.setEditable(false);
        hrIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrIDTextFieldActionPerformed(evt);
            }
        });

        assignHRButton.setBackground(new java.awt.Color(255, 51, 51));
        assignHRButton.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        assignHRButton.setText("Assign HR");
        assignHRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignHRButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Emp ID :");

        jLabel8.setText("Applicant ID :");

        jLabel11.setText("jobID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(assignHRButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hrIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(applicationIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(42, 42, 42)
                                .addComponent(empIDLabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jobIDLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(applicantIDLabel))))
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(empIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(applicantIDLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jobIDLabel)))
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(applicationIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(hrIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(23, 23, 23)
                .addComponent(assignHRButton)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void applicationIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applicationIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_applicationIDTextFieldActionPerformed

    private void hrIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hrIDTextFieldActionPerformed

    private void assignHRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignHRButtonActionPerformed
        // TODO add your handling code here:
            try{
                    Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");
                    PreparedStatement src1 = Con.prepareStatement("Select * from Applications_Dir where ApplicationID = ?" );
                    src1.setString(1, applicationIDTextField.getText());
                    ResultSet Rs = src1.executeQuery();
                    while (Rs.next()){
                        applicantIDLabel.setText(Rs.getString(3));
                        jobIDLabel.setText(Rs.getString(2));
                    }}
            catch(Exception e){
            e.printStackTrace();
                }
            
            try{
                Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Final_Project","root","Ankita@22");    
                PreparedStatement src2 = Con.prepareStatement("Select EmpID from Job_Dir where JobID = ?" );
                    src2.setString(1, jobIDLabel.getText());
                    ResultSet Rs1 = src2.executeQuery();
                    while (Rs1.next()){
                        empIDLabel.setText(Rs1.getString(1));
                         
                    }}
            catch(Exception e){
            e.printStackTrace();
                }
            
            try{
                        PreparedStatement add= Con.prepareStatement("Update Applications_Dir Set HR_ID = ?, App_Status = 'Scheduled for Interview' where ApplicationID = ?");
                        add.setString(1, hrIDTextField.getText());
                        add.setString(2, applicationIDTextField.getText());
                        PreparedStatement add1= Con.prepareStatement("insert into Appointments_Dir(ApplicationID,HR_ID,ApplicantID,Emp_ID) values (?,?,?,?)");
                        int row=add.executeUpdate();
                        add1.setString(1, applicationIDTextField.getText());
                        add1.setString(2, hrIDTextField.getText());
                        add1.setString(3, applicantIDLabel.getText());
                        add1.setString(4,empIDLabel.getText());
                        int row1=add1.executeUpdate();
                        
                        
                        applicationIDTextField.setText("");
                        hrIDTextField.setText("");
                      
                        JOptionPane.showMessageDialog(this, "HR Assigned Successfully");
                        showData();
                        Con.close();
            
                }
               catch(Exception e){
                e.printStackTrace();
                }
        
            
            
            
        
    }//GEN-LAST:event_assignHRButtonActionPerformed

    private void jobApplicationsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jobApplicationsTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jobApplicationsTable.getModel();
        int row = jobApplicationsTable.getSelectedRow();
        applicationIDTextField.setText((String)model.getValueAt(row, 0));
    }//GEN-LAST:event_jobApplicationsTableMouseClicked

    private void hrListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hrListTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) hrListTable.getModel();
        int row = hrListTable.getSelectedRow();
        hrIDTextField.setText((String)model.getValueAt(row, 0));
    }//GEN-LAST:event_hrListTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel applicantIDLabel;
    private javax.swing.JTextField applicationIDTextField;
    private javax.swing.JButton assignHRButton;
    private javax.swing.JLabel empIDLabel;
    private javax.swing.JTextField hrIDTextField;
    private javax.swing.JTable hrListTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jobApplicationsTable;
    private javax.swing.JLabel jobIDLabel;
    // End of variables declaration//GEN-END:variables
}
