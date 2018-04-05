package com.flowergarden.servlets;

import com.flowergarden.flowers.FlowerWrapper;
import com.flowergarden.services.BouquetJSONService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by OleksiiF on 30.03.2018.
 */
public class BouquetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ApplicationContext atx;

    @Override
    public void init (ServletConfig config) throws ServletException {
        super.init(config);
        atx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        try (PrintWriter writer = response.getWriter()){
            writer.append("<!DOCTYPE html>")
                    .append("<html>")
                    .append("<head>")
                    .append("<title>Form input</title>")
                    .append("</head>")
                    .append("<body>")
                    .append("<form action=\"bouquet\" method=\"POST\">")
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
        int bouquetId = Integer.parseInt(request.getParameter("bouquetId"));

        BouquetJSONService bouquetJSONService = (BouquetJSONService) atx.getBean("bouquetJSONService");
        bouquetJSONService.saveBouquetService(1);

        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>")
                .append("<body>");

        if (bouquetId > 0 && bouquetJSONService.readBouquetService(bouquetId).getId() == bouquetId) {
            writer.append("	Bouquet name: " + bouquetJSONService.readBouquetService(1).getName() + "<br/>");
            writer.append("	Assembly price: " + bouquetJSONService.readBouquetService(1).getAssemblyPrice() + "<br/>");

            for(FlowerWrapper f: bouquetJSONService.readBouquetService(1).getFlowerWrappers()){
                writer.append("" + "<br/>");
                writer.append("flower name: " + f.getName() + "<br/>");
                writer.append("flower id: "+f.getId() + "<br/>");
                writer.append("freshness: " + f.getFreshness().getFreshness() + "<br/>");
                writer.append("length: " + f.getLenght() + "<br/>");
                writer.append("price: " + f.getPrice() + "<br/>");
                if(f.getName().equals("rose")) {writer.append("spikes: " + f.getSpike() + "<br/>");}
                if(f.getName().equals("chamomile")) {writer.append("petals: " + f.getPetals() + "<br/>");}

            }
        } else {
            writer.append("	You did not entered existing bouquet ID");
        }
        writer.append("</body>")
                .append("</html>");
    }
}
