package views;

import core.entities.Oficina;
import core.entities.Rol;
import core.entities.Usuario;
import java.util.Date;
import javax.swing.JOptionPane;
import persistence.dao.OficinaDAO;
import persistence.dao.RolDAO;
import persistence.dao.UsuarioDAO;
import persistence.database.Conexion;

public class FormRegisterUsers extends javax.swing.JFrame {

    private OficinaDAO oficinaDAO;
    private RolDAO rolDAO;
    private UsuarioDAO usuarioDAO;
    private FormMenuAdministrador formMenuAdministrador;
    
    public FormRegisterUsers() {
        initComponents();
        var conn = Conexion.getConexion();
        oficinaDAO = new OficinaDAO(conn);
        rolDAO = new RolDAO(conn);
        usuarioDAO = new UsuarioDAO(conn);
        rellenarComboOficinas();
        rellenarComboRoles();
    }
    
    private void rellenarComboOficinas() {
        for (Oficina oficinas : oficinaDAO.listaOficinas()) {
            cmbOficinas.addItem(oficinas.getNombre());
        }
    }
    
    private void rellenarComboRoles() {
        for (Rol roles : rolDAO.listaRoles()) {
            cmbRoles.addItem(roles.getNombre());
        }
    }

    private void regresar() {
        this.setVisible(false);
        formMenuAdministrador = new FormMenuAdministrador();
        formMenuAdministrador.setVisible(true);
        formMenuAdministrador.setLocationRelativeTo(null);
    }
    
    private void registrarUsuario() {
        int ultimoId = usuarioDAO.ultimoUsuarioConID() + 1;
        String userFirstName = txtFirstName.getText();
        String userLastName = txtLastName.getText();
        String userEmail = txtEmail.getText();
        String userPassword = String.valueOf(txtPassword.getPassword());
        Date userFechaNacimiento = dtFechaNacimiento.getDate();
        int userActive = Integer.valueOf(txtActivo.getText());
        
        String oficinaSeleccionada = String.valueOf(cmbOficinas.getSelectedItem());
        Oficina oficina = new Oficina();
        oficina.setNombre(oficinaSeleccionada);
        int oficinaId = oficinaDAO.idOfficeByNombre(oficina);
        System.out.println("Id de la oficina: " + oficinaId);
        
        String rolSeleccionado = String.valueOf(cmbRoles.getSelectedItem());
        Rol rol = new Rol();
        rol.setNombre(rolSeleccionado);
        int rolId = rolDAO.idRoleByNombre(rol);
        System.out.println("Id del rol: " + rolId);
        
        Usuario usuario = new Usuario();
        usuario.setId(ultimoId);
        usuario.setIdRoleFK(rolId);
        usuario.setEmail(userEmail);
        usuario.setPassword(userPassword);
        usuario.setNombre(userFirstName);
        usuario.setLastName(userLastName);
        usuario.setIdOficinaFK(oficinaId);
        usuario.setFechaNacimiento(userFechaNacimiento);
        usuario.setActive(userActive);
        
        if (usuarioDAO.createNewUser(usuario)) {
            JOptionPane.showMessageDialog(
                    null, "Usuario registrado", "Successful", 
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null, "Error al registrar el usuario", "Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPassword = new javax.swing.JPasswordField();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblActive = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtActivo = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        lblSelectOffice = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        cmbOficinas = new javax.swing.JComboBox<>();
        lblLastName = new javax.swing.JLabel();
        lblSelectRol = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        cmbRoles = new javax.swing.JComboBox<>();
        lblEmail = new javax.swing.JLabel();
        btnRegistrarUsuario = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        dtFechaNacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFechaNacimiento.setText("Fecha de nacimiento:");

        lblActive.setText("Activo:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("REGISTRO DE USUARIOS");

        txtActivo.setText("1");
        txtActivo.setEnabled(false);

        lblSelectOffice.setText("Seleccionar oficina:");

        lblFirstName.setText("First name:");

        lblLastName.setText("Last name:");

        lblSelectRol.setText("Seleccionar rol:");

        lblEmail.setText("Email:");

        btnRegistrarUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrarUsuario.setText("Registrar");
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });

        lblPassword.setText("Password:");

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbOficinas, 0, 130, Short.MAX_VALUE)
                            .addComponent(lblFirstName)
                            .addComponent(txtFirstName)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail)
                            .addComponent(lblFechaNacimiento)
                            .addComponent(lblSelectOffice)
                            .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(dtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSelectRol)
                            .addComponent(lblLastName)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword)
                            .addComponent(txtLastName)
                            .addComponent(lblActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtActivo)
                            .addComponent(cmbRoles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(lblLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(lblActive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectOffice)
                    .addComponent(lblSelectRol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOficinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed
        registrarUsuario();
    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        regresar();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(FormRegisterUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegisterUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegisterUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegisterUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegisterUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbOficinas;
    private javax.swing.JComboBox<String> cmbRoles;
    private com.toedter.calendar.JDateChooser dtFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblActive;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSelectOffice;
    private javax.swing.JLabel lblSelectRol;
    private javax.swing.JTextField txtActivo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
