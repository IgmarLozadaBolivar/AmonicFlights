<h1 align="center"><img width="48" height="48" src="https://img.icons8.com/fluency/48/safety-care.png" alt="Clay Security"/><b>Amonic Flights</b></h1>

<p>La empresa Amonic Flights dedicada a la prestacion de servicios de viajes en avión, esta interesada en desarrollar una aplicación de escritorio que le permita gestionar sus oficinas, usuarios y paises donde se encuentran, todo por medio de 2 roles anteriormente identificados!</p>

## Tecnologias 🧑🏻‍💻
<p align="center">
<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif"><br>

- **Back-End Development**:
  [![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white)](#)

- **Softwares & Tools**:
  [![NetBeans IDE](https://img.shields.io/badge/NetBeans%20IDE-1B6AC6.svg?logo=apache-netbeans-ide&logoColor=white)](#)
  ![GIT](https://img.shields.io/badge/Git-fc6d26?style=flat&logo=git&logoColor=white)

- **Database**:
  ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=flat&logo=mysql&logoColor=white)

</p>

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif"><br>

## Requerimientos funcionales 👻<br>
🎯 Implementar control de acceso (login). ✔ <br>
🎯 Implementar una interfaz para el registro de usuarios. ✔ <br>
🎯 Se debe listar las oficinas. ✔ <br>
🎯 Se debe listar los roles. ✔ <br>
🎯 Se debe listar los usuarios. ✔ <br>
🎯 Se debe listar los paises. ✔ <br>
🎯 Implementación de CRUD por Entidad. ✔ <br>
🎯 Aplicación gestionada por capas. ✔ <br>

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif"><br>

## Conteo de todas los requisitos a realizar 📝
<details>
  <summary>Ver progreso de los requisitos</summary>

### Requisitos Totales: `Total 10/10` ✅ <br>

</details>

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif"><br>

## Consultas requeridas 👨‍💻 <br>
 **Method**: `SELECT`

**🔰 Query 1: Listar todos los `roles` con los que cuenta `Amonic Flighst` ✅**:
```sql
    SELECT `*` FROM `roles`;

    public List<Rol> listaRoles() {
        List<Rol> roles = new ArrayList<>();
        
        String sql = "select * from roles";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                this.rol = new Rol();
                rol.setId(rs.getInt("ID"));
                rol.setNombre(rs.getString("Title"));
                roles.add(rol);
            }
            
        } catch (Exception e) {
            System.out.println("No se encontraron roles en la tabla, más detalles: " + e.getMessage());
        }
        
        return roles;
    }
```
**Method**: `SELECT`

**🔰 Query 2: Listar todas las `oficinas` con las que cuenta `Amonic Flights` ✅**:
```sql
    SELECT `*` FROM `offices`;

    public List<Oficina> listaOficinas() {
        List<Oficina> oficinas = new ArrayList<>();
        
        String sql = "select * from offices";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {                
                this.oficina = new Oficina();
                oficina.setId(rs.getInt("ID"));
                oficina.setIdPaisFK(rs.getInt("CountryID"));
                oficina.setNombre(rs.getString("Title"));
                oficina.setPhone(rs.getString("Phone"));
                oficina.setContact(rs.getString("Contact"));
                oficinas.add(oficina);
            }
            
        } catch (Exception e) {
            System.out.println("No se encontraron oficinas en la tabla, más detalles: " + e.getMessage());
        }
        
        return oficinas;
    }
```
**Method**: `SELECT`

**🔰 Query 3: Listar todos los `paises` con los que cuenta `Amonic Flights` ✅**:
```sql
    SELECT `*` FROM `countries`;

    public List<Pais> listaPaises() {
        List<Pais> paises = new ArrayList<>();
        
        String sql = "select * from countries";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {                
                this.pais = new Pais();
                pais.setId(rs.getInt("ID"));
                pais.setNombre(rs.getString("Name"));
                paises.add(pais);
            }
            
        } catch (Exception e) {
            System.out.println("No se encontraron paises en la tabla, más detalles: " + e.getMessage());
        }
        
        return paises;
    }
```
**Method**: `SELECT`

**🔰 Query 4: Listar todos los `usuarios` con los que cuenta `Amonic Flighst` ✅**:
```sql
    SELECT `*` FROM `users`;

    public List<Usuario> listaUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        
        String sql = "select * from users";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {                
                this.usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setIdRoleFK(rs.getInt("RoleID"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setPassword(rs.getString("Password"));
                usuario.setNombre(rs.getString("FirstName"));
                usuario.setLastName(rs.getString("LastName"));
                usuario.setIdOficinaFK(rs.getInt("OfficeID"));
                usuario.setFechaNacimiento(rs.getDate("Birthdate"));
                usuario.setActive(rs.getInt("Active"));
                usuarios.add(usuario);
            }
            
        } catch (Exception e) {
            System.out.println("No se encontraron usuarios en la tabla, más detalles: " + e.getMessage());
        }
        
        return usuarios;
    }
```
**Method**: `SELECT`

**🔰 Query 5: Autenticar al `usuario` que intenta iniciar sesión  en la aplicación de `Amonic Flights` retornando su `RolID` ✅**:
```sql
    SELECT `RoleID` FROM `users` WHERE `Email = ?` AND `Password = ?`;

    public int autenticarUsuario(Usuario usuario) {
        
        String sql = "select RoleID from users where Email = ? and Password = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
                        
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getPassword());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("RoleID");
            }
            
        } catch (Exception e) {
            System.out.println("No se encuentran coincidencias, más detalles: " + e.getMessage());
        }
        
        return 0;
    }
```
**Method**: `SELECT`

**🔰 Query 6: Retornar el último `usuario` que se encuentra registrado para poder conocer el último `ID` ya existente ✅**:
```sql
    SELECT `MAX(ID)` AS `ID` FROM `users`;

    public int ultimoUsuarioConID() {
        String sql = "select max(ID) as ID from users";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int idRol = rs.getInt("ID");
                return idRol;
            }
            
        } catch (Exception e) {
            System.out.println("No existen usuarios registrados: " + e.getMessage());
        }
        
        return 0;
    }
```
**Method**: `INSERT INTO`

**🔰 Query 7: Insertar un nuevo `usuario` cuyo estado es `activo` por defecto ✅**:
```sql
    INSERT INTO users`(ID, RoleID, Email, Password, FirstName, LastName, OfficeID, Birthdate, Active)` VALUES`(?, ?, ?, ?, ?, ?, ?, ?, ?)`;

    public boolean createNewUser(Usuario usuario) {
        
        String sql = "insert into users(ID, RoleID, Email, Password, FirstName, LastName, OfficeID, Birthdate, Active)" +
                " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, usuario.getId());
            ps.setInt(2, usuario.getIdRoleFK());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getPassword());
            ps.setString(5, usuario.getNombre());
            ps.setString(6, usuario.getLastName());
            ps.setInt(7, usuario.getIdOficinaFK());
            ps.setDate(8, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            ps.setInt(9, usuario.getActive());
            ps.execute();
            
            
        } catch (Exception e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
        }
        
        return false;
    }
```
**Method**: `SELECT`

**🔰 Query 8: Retornar el `nombre` del rol cuyo id se desconoce de la tabla `roles` ✅**:
```sql
    SELECT `Title` FROM `roles` WHERE `ID = ?`;

    public String roleById(Rol rol) {
        
        String sql = "select Title from roles where ID = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, rol.getId());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getString("Title");
            }
            
        } catch (Exception e) {
        }
        
        return null;
    }
```
**Method**: `SELECT`

**🔰 Query 9: Retornar el `ID` del rol cuyo nombre se desconoce de la tabla `roles` ✅**:
```sql
    SELECT `ID` FROM `roles` WHERE `Title = ?`;

    public int idRoleByNombre(Rol rol) {
        
        String sql = "select ID from roles where Title = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, rol.getNombre());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("ID");
            }
            
        } catch (Exception e) {
            System.out.println("No se encontró ninguna coincidencia: " + e.getMessage());
        }
        
        return 0;
    }
```
**Method**: `SELECT`

**🔰 Query 10: Retornar el `ID` de la oficina cuyo nombre se desconoce de la tabla `roles` ✅**:
```sql
    SELECT `ID` FROM `offices` WHERE `Title = ?`;

    public int idOfficeByNombre(Oficina oficina) {
        
        String sql = "select ID from offices where Title = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, oficina.getNombre());
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("ID");
            }
            
        } catch (Exception e) {
            System.out.println("No se encontró ninguna coincidencia: " + e.getMessage());
        }
        
        return 0;
    }
```

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif"><br>

## Authors and collaborators:
- Powered by <a href="https://github.com/IgmarLozadaBolivar">Igmar Lozada</a><br>

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif"><br>

## Thank you for reading this documentation and that you have observed this interesting project!

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif"><br>
