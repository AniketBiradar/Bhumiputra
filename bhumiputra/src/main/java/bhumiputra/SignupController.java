package bhumiputra;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = 1;
		try {
			id = 1 + UserCRUD.retrieveMaxIdFromDatabase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String password = req.getParameter("password");
		String role = req.getParameter("role");

		User user = new User();
		UserCRUD crud = new UserCRUD();

		user.setId(id);
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		user.setRole(role);

		 try {
	            int result = crud.signup(user);

	            if (result != 0) {
	            	req.setAttribute("message", "Sign Up Success, Please Log In");
					req.getRequestDispatcher("welcome.jsp").forward(req,resp);
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    

	}
}
