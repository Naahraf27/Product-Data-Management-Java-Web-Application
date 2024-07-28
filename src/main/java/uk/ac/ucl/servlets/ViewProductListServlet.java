package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ListItemEntity;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/productList")
public class ViewProductListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = ModelFactory.getModel();
        List<ListItemEntity> products = model.getItems();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/productList.jsp").forward(request, response);
    }
}
