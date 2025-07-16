
import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "UPDATE seller "
                    + "SET BaseSalary = BaseSalary + ? "
                    + "WHERE "
                    + "(DepartmentId = ?)"
            );

            st.setDouble(1, 200);
            st.setInt(2, 2);

            int rows = st.executeUpdate();

            System.out.println("linhas afetadas: " + rows);

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DB.closeStatment(st);
            DB.closeConnection();
        }
    }
}
