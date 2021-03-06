/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
/**
 *
 * @author biapt
 */
public class input_output extends javax.swing.JFrame {

    boolean is_file;
    String name;
    String age;
    String id;
    String filename;
    String output;
    /**
     * Creates new form input_output
     */
    public input_output() {
        initComponents();
    }
    
    //Check if the string is a number or not
    public boolean is_number(String number) {
	try {
                double d = Double.parseDouble(number);
        } 
	catch (NumberFormatException | NullPointerException nfe) {
            return false;
	}
	return true;
    }
    
    // Write the output to the given file_name, if already exist will overwrite
    public void write_to_file(String file_name,String output) {
	PrintWriter writer = null;
	try {
		writer = new PrintWriter(file_name, "UTF-8");
		writer.write(output);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	writer.close();
    }
    
    // Format the input from the user into a 
    public String formatter(String name,String age,String id) {
	String formatted_output = "";
	formatted_output = "Your name is " + name + ", you are " + age +" years old and your username is " + id + "."; 
	return formatted_output;
    }
    
	// Gather input from the user
	// The prompt is used as the first message
	public boolean error_checker() {
		boolean is_valid = false;
		boolean is_valid_name = false;
		boolean is_valid_age = false;
		boolean is_valid_id = false;
		boolean is_valid_filename = false;
                name = name_text_field.getText();
		age = age_text_field.getText();
		id = id_text_field.getText();
                filename = filename_text_field.getText();
                
                is_valid_name = !is_number(name);
                is_valid_age = is_number(age);
                is_valid_id = !is_number(id);
                if(is_file == true){
                    is_valid_filename = !is_number(filename) & !filename.equals("");
                }else{
                    is_valid_filename = true;
                }
                is_valid = is_valid_name & is_valid_age & is_valid_id & is_valid_filename;
		output = formatter(name,age,id);
                return is_valid;

        }
	    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        launch_button = new javax.swing.JButton();
        name_label = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        age_label = new javax.swing.JLabel();
        name_text_field = new javax.swing.JTextField();
        age_text_field = new javax.swing.JTextField();
        id_text_field = new javax.swing.JTextField();
        filename_text_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        feedback_area = new javax.swing.JTextArea();
        feedback_button = new javax.swing.JRadioButton();
        file_button = new javax.swing.JRadioButton();
        output_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        launch_button.setText("Launch!");
        launch_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launch_buttonActionPerformed(evt);
            }
        });

        name_label.setText("Name");

        id_label.setText("ID");

        age_label.setText("Age  ");

        name_text_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_text_fieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Filename");

        feedback_area.setEditable(false);
        feedback_area.setColumns(20);
        feedback_area.setRows(5);
        jScrollPane1.setViewportView(feedback_area);

        buttonGroup1.add(feedback_button);
        feedback_button.setText("feedback");
        feedback_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feedback_buttonActionPerformed(evt);
            }
        });

        buttonGroup1.add(file_button);
        file_button.setSelected(true);
        file_button.setText("file");
        file_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_buttonActionPerformed(evt);
            }
        });

        output_label.setText("output");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(output_label))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(feedback_button)
                                        .addGap(18, 18, 18)
                                        .addComponent(file_button)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(filename_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(age_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(id_label))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(name_text_field, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                                        .addComponent(age_text_field))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(launch_button, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_label)
                    .addComponent(name_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(age_label)
                    .addComponent(age_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_label)
                    .addComponent(id_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(feedback_button)
                    .addComponent(file_button)
                    .addComponent(output_label))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(filename_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(launch_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 464, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 5, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 5, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void name_text_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_text_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_text_fieldActionPerformed

    private void feedback_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feedback_buttonActionPerformed
        // TODO add your handling code here:
        filename_text_field.setEditable(false);
        filename_text_field.setText("");
        is_file = false;
    }//GEN-LAST:event_feedback_buttonActionPerformed

    private void file_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_buttonActionPerformed
        // TODO add your handling code here:
        filename_text_field.setEditable(true);
        is_file = true;
    }//GEN-LAST:event_file_buttonActionPerformed

    private void launch_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launch_buttonActionPerformed
        // TODO add your handling code here:
        
        // Do some errors checking
        boolean is_good = error_checker();
        // If everything is fine run the program
        if(is_good == true){
            if(is_file){
                write_to_file(filename,output);
                feedback_area.setText("Written to file : " + filename);
            }else{
                feedback_area.setText(output);
            }
        }else{
            feedback_area.setText("Input not valid!");
        }
        
        // Output to feedback
        
    }//GEN-LAST:event_launch_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(input_output.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(input_output.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(input_output.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(input_output.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new input_output().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age_label;
    private javax.swing.JTextField age_text_field;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea feedback_area;
    private javax.swing.JRadioButton feedback_button;
    private javax.swing.JRadioButton file_button;
    private javax.swing.JTextField filename_text_field;
    private javax.swing.JLabel id_label;
    private javax.swing.JTextField id_text_field;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton launch_button;
    private javax.swing.JLabel name_label;
    private javax.swing.JTextField name_text_field;
    private javax.swing.JLabel output_label;
    // End of variables declaration//GEN-END:variables
}
