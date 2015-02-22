package it.dipiazza.domenico.infrastructure;

import java.sql.SQLException;

import it.dipiazza.domenico.DAO.DevoteeDAO;
import it.dipiazza.domenico.model.Devotee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.*;

public class AddDevoteeAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ActionException {
		DevoteeDAO devoteeDAO = new DevoteeDAO();
		Devotee d = new Devotee();
		if (controlEx("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", request.getParameter("email"))) {
			d.setName(request.getParameter("name"));
			d.setSurname(request.getParameter("surname"));
			d.setEmail(request.getParameter("email"));
		} else {
			return "error.jsp";
		}

		try {
			if (devoteeDAO.addDevotee(d)) {
				return "redir.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "error.jsp";
	}

	private boolean controlEx(String ex, String control) {
		Pattern p = Pattern.compile(ex);
		Matcher m = p.matcher(control);

		return m.find();
	}

}
