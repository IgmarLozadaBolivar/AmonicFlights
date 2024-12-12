package views;

import javax.swing.table.DefaultTableModel;
import core.entities.Oficina;
import persistence.dao.OficinaDAO;
import core.entities.Rol;
import persistence.dao.RolDAO;
import core.entities.Usuario;
import java.time.LocalDate;
import java.time.Period;
import persistence.dao.UsuarioDAO;
import persistence.database.Conexion;

public class FormMenuAdministrador extends javax.swing.JFrame {

    //private UsuarioDAO usuarioDAO;
    //private RolDAO rolDAO;
    //private OficinaDAO oficinaDAO;
    private FormLogin formLogin;
    private FormRegisterUsers formRegisterUsers;
    DefaultTableModel modelTable = new DefaultTableModel();

    public FormMenuAdministrador() {
        initComponents();
        modelarTabla();
        rellenarComboOficinas();
//        var conn = Conexion.getConexion();
//        if (conn != null) {
//            System.out.println("Conectó");
//        }
//        usuarioDAO = new UsuarioDAO(conn);
//        rolDAO = new RolDAO(conn);
////        oficinaDAO = new OficinaDAO(conn);
    }

    private void cerrarSesion() {
        this.setVisible(false);
        formLogin = new FormLogin();
        formLogin.setVisible(true);
        formLogin.setLocationRelativeTo(null);
    }

    private void formUsersNew() {
        this.setVisible(false);
        formRegisterUsers = new FormRegisterUsers();
        formRegisterUsers.setVisible(true);
        formRegisterUsers.setLocationRelativeTo(null);
    }

    private void modelarTabla() {
        String[] columnTable = {"Name", "Last Name", "Age", "User Role", "Email Address", "Office"};
        modelTable.setColumnIdentifiers(columnTable);
        tblUsers.setModel(modelTable);
        rellenarTabla();
    }
    
    private void rellenarComboOficinas() {
        var conn = Conexion.getConexion();
        OficinaDAO oficinaDAO = new OficinaDAO(conn);
        cmbOficinas.addItem("All offices");
        for (Oficina oficinas : oficinaDAO.listaOficinas()) {
            cmbOficinas.addItem(oficinas.getNombre());
        }
    }
    
    private void listarUsuariosPorOficina() {
        limpiarTabla();
        String nombreOficina = String.valueOf(cmbOficinas.getSelectedItem());
        var conn = Conexion.getConexion();
        Oficina oficina = new Oficina();
        OficinaDAO oficinaDAO = new OficinaDAO(conn);
        oficina.setNombre(nombreOficina);
        int idOficinaFK = oficinaDAO.idOfficeByNombre(oficina);
        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        RolDAO rolDAO = new RolDAO(conn);
        usuario.setIdOficinaFK(idOficinaFK);
        if (usuarioDAO.listaUsuariosPorOficina(usuario).isEmpty()&& !nombreOficina.equals("All offices")) {
            System.out.println("No hay usuarios en esa oficina");
        } else {
            for (Usuario usuarios : usuarioDAO.listaUsuariosPorOficina(usuario)) {
                // Calcular la edad actual
                LocalDate fechaActual = LocalDate.now();
                java.sql.Date fechaNacimiento = (java.sql.Date) usuarios.getFechaNacimiento();
                LocalDate fechaNacimientoLocalDate = fechaNacimiento.toLocalDate();
                Period edadActual = Period.between(fechaNacimientoLocalDate, fechaActual);

                // Retornar el nombre del rol por su ID
                Rol rol = new Rol();
                rol.setId(usuarios.getIdRoleFK());
                String nombreRole = rolDAO.roleById(rol);

                // Retornar el nombre de la oficina por su ID
                oficina.setId(usuarios.getIdOficinaFK());
                String nombreOffice = oficinaDAO.officeById(oficina);

                // Almacenar los datos recuperados de un solo usuario e irlos almacenando en el Object
                Object[] dataUsuarios = {usuarios.getNombre(), usuarios.getLastName(),
                    edadActual.getYears(), nombreRole, usuarios.getEmail(), nombreOffice};
                modelTable.addRow(dataUsuarios);
            }
        }
    }

    private void rellenarTabla() {
        var conn = Conexion.getConexion();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        RolDAO rolDAO = new RolDAO(conn);
        OficinaDAO oficinaDAO = new OficinaDAO(conn);
        for (Usuario usuarios : usuarioDAO.listaUsuarios()) {
            // Calcular la edad actual
            LocalDate fechaActual = LocalDate.now();
            java.sql.Date fechaNacimiento = (java.sql.Date) usuarios.getFechaNacimiento();
            LocalDate fechaNacimientoLocalDate = fechaNacimiento.toLocalDate();
            Period edadActual = Period.between(fechaNacimientoLocalDate, fechaActual);

            // Retornar el nombre del rol por su ID
            Rol rol = new Rol();
            rol.setId(usuarios.getIdRoleFK());
            String nombreRole = rolDAO.roleById(rol);

            // Retornar el nombre de la oficina por su ID
            Oficina oficina = new Oficina();
            oficina.setId(usuarios.getIdOficinaFK());
            String nombreOffice = oficinaDAO.officeById(oficina);

            // Almacenar los datos recuperados de un solo usuario e irlos almacenando en el Object
            Object[] dataUsuarios = {usuarios.getNombre(), usuarios.getLastName(),
                edadActual.getYears(), nombreRole, usuarios.getEmail(), nombreOffice};
            modelTable.addRow(dataUsuarios);
            
        }
    }

    private void limpiarTabla() {
        DefaultTableModel temp = (DefaultTableModel) tblUsers.getModel();
        int filas = tblUsers.getRowCount();

        for (int a = 0; filas > a; a++) {
            temp.removeRow(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbOficinas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        mbOptions = new javax.swing.JMenuBar();
        mAddUser = new javax.swing.JMenu();
        mExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AMONIC Airlines Automation System");

        cmbOficinas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbOficinasItemStateChanged(evt);
            }
        });

        jLabel1.setText("Office:");

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblUsers);

        mAddUser.setText("Add User");
        mAddUser.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mAddUserMenuSelected(evt);
            }
        });
        mbOptions.add(mAddUser);

        mExit.setText("Exit");
        mExit.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mExitMenuSelected(evt);
            }
        });
        mbOptions.add(mExit);

        setJMenuBar(mbOptions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbOficinas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbOficinas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mAddUserMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mAddUserMenuSelected
        formUsersNew();
    }//GEN-LAST:event_mAddUserMenuSelected

    private void mExitMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mExitMenuSelected
        cerrarSesion();
    }//GEN-LAST:event_mExitMenuSelected

    private void cmbOficinasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbOficinasItemStateChanged
        listarUsuariosPorOficina();
    }//GEN-LAST:event_cmbOficinasItemStateChanged

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
            java.util.logging.Logger.getLogger(FormMenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenuAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbOficinas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu mAddUser;
    private javax.swing.JMenu mExit;
    private javax.swing.JMenuBar mbOptions;
    private javax.swing.JTable tblUsers;
    // End of variables declaration//GEN-END:variables
}
