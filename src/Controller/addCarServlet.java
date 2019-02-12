package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Car;

/**
 * Servlet implementation class addCarServlet
 */
@WebServlet("/addCarServlet")
public class addCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//grab properties from the form
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		int year = Integer.parseInt(request.getParameter("year"));
		
		//create new car and use helper to add the car into the database
		Car c = new Car(make,model,year);
		CarHelper ch = new CarHelper();
		ch.insertCar(c);
		
		//send user to a page after car is added
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
