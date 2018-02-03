package com.rajeshpatkar;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "QuestionServlet", urlPatterns = {"/QuestionServlet"})
public class QuestionServlet extends HttpServlet
{
   
    /**
     *
     * @param sc
     */
    @Override
    public void init()
    {
        System.out.println("Init Called");
        ServletContext s = getServletConfig().getServletContext();
        
        s.setAttribute("index", 0);
        ArrayList<Question> q = new ArrayList<>();
        s.setAttribute("q", q);
        //Loading Data in arrays
            
        for (int i = 0; i < 10; i++)
        {
            Question ques = new Question(); 
            ques.setText("This is Question " + (i+1) + "?"); 
            ques.setOpt1("A" + (i+1) + "");
            ques.setOpt2("B" + (i+1) + "");
            ques.setOpt3("C" + (i+1) + "");
            ques.setOpt4("D" + (i+1) + "");
            ques.setAns(i+1);
            q.add(ques);

        }

    }

    
  @Override
    public void service(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException
    {
        
        System.out.println("Service method called");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> RPIAN Exam System </title>");
            out.println("<style> div.question { padding:25px } </style>");
            out.println(
                "<style> " +
                "button { " +
                "background-color:cyan;" +
                "border-width:0px;" +
                "border-radius:20px " +
                "} " +
                "</style>"
            );
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome to the RPIAN Exam System</h1>");    
            out.println("<h2>Using ServletContext Object</h2>");
            ArrayList<Question> q;
            q = (ArrayList<Question>)getServletContext().getAttribute("q");
            int index = (Integer)getServletContext().getAttribute("index");
            out.println("<div class='question'>");
            out.println("<b>" + q.get(index).getText()+ "</b><br>");
            out.println(
                "<input type='checkbox' name='a' value='2'>" + 
                q.get(index).getOpt1() + "</input><br>"
            );
            out.println(
                "<input type='checkbox' name='a' value='4'>" + 
                q.get(index).getOpt2() + "</input><br>"
            );
            out.println(
                "<input type='checkbox' name='a' value='8'>" + 
                q.get(index).getOpt3() + "</input><br>"
            );
            out.println(
                "<input type='checkbox' name='a' value='16'>" + 
                q.get(index).getOpt4() + "</input><br>"
            );
            out.println("<label>Answer : " + 
                q.get(index).getAns() + "</label><br>"
            );
            
            index= (index + 1) % 10;
            getServletContext().setAttribute("index",index);
            out.println("</div>");
            out.println("<br/><button><a href=''>Refresh</a></button>");
            out.println("</body>");
            out.println("</html>");
        }

    }
}

