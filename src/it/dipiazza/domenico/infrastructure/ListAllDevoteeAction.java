package it.dipiazza.domenico.infrastructure;

import java.sql.SQLException;
import java.util.List;

import it.dipiazza.domenico.DAO.DevoteeDAO;
import it.dipiazza.domenico.model.Devotee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAllDevoteeAction implements Action {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ActionException{
		DevoteeDAO devoteeDAO = new DevoteeDAO();
		try {
			List<Devotee> listDevotee = devoteeDAO.allDevotee();
			request.setAttribute("listDevotee", listDevotee);
			return "listDevotee.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			return "error.jsp";
		}
	}

}
