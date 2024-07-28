package uk.ac.ucl.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.ucl.model.ListItemEntity;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

@WebServlet("/listsearch")
public class ListSearchServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("searchstring");
        if (keyword == null || keyword.isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/listsearch.jsp");
            return;
        }

        Model model = ModelFactory.getModel();
        List<ListItemEntity> items = model.getAllItems();
        if (items == null || items.isEmpty()) {
            request.setAttribute("errorMessage", "No items found");
            request.getRequestDispatcher("/listsearch.jsp").forward(request, response);
            return;
        }

        List<ListItemEntity> searchResults = model.searchFor(keyword, items);
        if (searchResults == null || searchResults.isEmpty()) {
            request.setAttribute("errorMessage", "No matching items found");
            request.getRequestDispatcher("/listsearch.jsp").forward(request, response);
            return;
        }

        request.setAttribute("searchResults", searchResults);
        request.getRequestDispatcher("/listsearchresult.jsp").forward(request, response);
    }
}

