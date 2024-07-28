package uk.ac.ucl.servlets;

import uk.ac.ucl.model.ListItemEntity;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.dao.CSVFileHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String productCode = request.getParameter("productCode");
        double price = Double.parseDouble(request.getParameter("price"));

        ListItemEntity newProduct = new ListItemEntity(name, type, productCode, price);

        Model model = ModelFactory.getModel();
        model.addItem(newProduct);
        CSVFileHandler.writeItems(model.getItems());

        response.sendRedirect("productList");
    }
}

