package bhumiputra;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserCRUD crud = new UserCRUD();

		try {
			String dbpassword = crud.login(email);
			String role = crud.getUserRole(email);

			if (dbpassword != null) {
				if (password.equals(dbpassword)) {

					if ("buyer".equals(role)) {
						resp.sendRedirect("BuyerHome.jsp");
					} else if ("seller".equals(role)) {
						resp.sendRedirect("FarmerHome.jsp");
					} else {
						// Handle other roles or redirect to a default page
						resp.sendRedirect("defaultHome.jsp");
					}

				} else {
					req.setAttribute("message", "Login Failed Invalid Password");
					req.getRequestDispatcher("welcome.jsp").forward(req, resp);
				}
			} else {
				req.setAttribute("message", "User not resiter ,Plesse Register");
				req.getRequestDispatcher("welcome.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
