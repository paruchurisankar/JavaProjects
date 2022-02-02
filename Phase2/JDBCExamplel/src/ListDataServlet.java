import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.util.DBConnection;


@WebServlet("/listProducts")
public class ListDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListDataServlet() {
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
			
			Statement stmt = connection.createStatement();
			
			
			ResultSet rs = stmt.executeQuery("select * from mine");
			
			while(rs.next()) {
				String productName = rs.getString("name");
				BigDecimal price = rs.getBigDecimal("price");
				Date dateAdded = rs.getDate("date_added");
				
				out.println(productName+" "+price+" "+dateAdded +"<br/>");
			}

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