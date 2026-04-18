import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "RIBERA";
        String password = "ribera";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // INSERT DEPARTAMENTOS
            String insertDept = "INSERT INTO DEPARTAMENTO2 (id, nombre) VALUES (?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertDept)) {

                ps.setInt(1, 1);
                ps.setString(2, "Recursos Humanos");
                ps.executeUpdate();

                ps.setInt(1, 2);
                ps.setString(2, "Desarrollo");
                ps.executeUpdate();

                ps.setInt(1, 3);
                ps.setString(2, "Informatico");
                ps.executeUpdate();
            }

            // INSERT EMPLEADOS (CORREGIDO)
            String emp = "INSERT INTO EMPLEADO3 (id, nombre, salario, departamento_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(emp)) {

                ps.setInt(1, 1);
                ps.setString(2, "Ana");
                ps.setDouble(3, 4000);
                ps.setInt(4, 2);
                ps.executeUpdate();

                ps.setInt(1, 2);
                ps.setString(2, "Juan");
                ps.setDouble(3, 5000);
                ps.setInt(4, 1);
                ps.executeUpdate();

                ps.setInt(1, 3);
                ps.setString(2, "Luis");
                ps.setDouble(3, 6000);
                ps.setInt(4, 3);
                ps.executeUpdate();
            }

            System.out.println("Datos insertados correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}