import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;
import com.jdbc.util.DBConnection;


@WebServlet("/addProductSP")
public class AddDataSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDataSPServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/sys";
		String userName = "root";
		String password = "ravi";

		PrintWriter out = response.getWriter();
		out.println("<html> <body>");
		try {
			DBConnection dbConnection = new DBConnection(url, userName, password);

			Connection connection = dbConnection.getConnection();
			/*
			connection.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_FORWARD_ONLY);*/

			CallableStatement stmt = connection.prepareCall("{call add_mine(?,?)}");

			stmt.setString(1, "Test_Nishchith_From SP");
			stmt.setBigDecimal(2, new BigDecimal(15000));
			
			stmt.executeUpdate();
			
			out.println("Data inserted successfully");
			stmt.close();
			out.println("</body></html>");
			dbConnection.closeConnection();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}