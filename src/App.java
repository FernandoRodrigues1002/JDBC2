
import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller"
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + "VALUES"
                    + "(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, "Nando");
            st.setString(2, "Nando@mail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("25/03/2004").getTime()));
            st.setDouble(4, 3000.00);
            st.setInt(5, 3);

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ParseException e) {
            e.printStackTrace();

        } finally {
            DB.closeStatment(st);
            DB.closeConnection();
        }
    }
}
