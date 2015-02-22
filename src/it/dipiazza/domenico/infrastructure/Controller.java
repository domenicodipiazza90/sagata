package it.dipiazza.domenico.infrastructure;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Controller extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String urlController = url.substring(url.lastIndexOf("/") + 1,
				url.indexOf(".do"));
		Action action = null;
		switch (urlController) {
		case "list":
			action = new ListAllDevoteeAction();
			break;
		case "add":
			action = new AddDevoteeAction();
			break;
		}

		String pageDestination;
		try {
			pageDestination = action.execute(request, response);
		} catch (ActionException e) {
			pageDestination = "error.jsp";
			e.printStackTrace();
		}

		RequestDispatcher disp = request.getRequestDispatcher(pageDestination);
		disp.forward(request, response);
	}

}
