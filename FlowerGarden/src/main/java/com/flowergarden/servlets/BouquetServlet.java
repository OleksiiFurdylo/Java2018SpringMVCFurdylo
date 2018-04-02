package com.flowergarden.servlets;

import com.flowergarden.services.BouquetJSONService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by OleksiiF on 30.03.2018.
 */
public class BouquetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()){
            writer.append("<!DOCTYPE html>")
                    .append("<html>")
                    .append("<head>")
                    .append("<title>Form input</title>")
                    .append("</head>")
                    .append("<body>")
                    .append("<form action=\"one\" method=\"POST\">")
                    .append("Enter bouquet ID: ")
                    .append("<input type=\"text\" name=\"bouquetId\" />")
                    .append("<input type=\"submit\" value=\"Submit\" />")
                    .append("</form>")
                    .append("</body>")
                    .append("</html>");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String user = request.getParameter("bouquetId");
        int bouquetId = Integer.parseInt(request.getParameter("bouquetId"));

        BouquetJSONService bouquetJSONService1 =(BouquetJSONService) getServletContext().getAttribute("bouquetJSONService");
        //ServletContext context = getServletContext();
        //WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        //BouquetJSONService bouquetJSONService = ctx.getBean("bouquetJSONService", com.flowergarden.services.BouquetJSONService.class);//null pointer

        System.out.println(bouquetJSONService1.readBouquetService(1).getName());




        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>")
                .append("<body>");
        if (user != null && !user.trim().isEmpty()) {
            writer.append("	Bouquet: " + " ");
            writer.append("	");
        } else {
            writer.append("	You did not entered valid bouquet ID");
        }
        writer.append("</body>")
                .append("</html>");
    }
}
