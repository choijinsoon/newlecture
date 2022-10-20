package webPrj;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/save")
public class SaveServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		PrintWriter out = response.getWriter();
		
		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");

		int x = Integer.parseInt(x_);
		int y = Integer.parseInt(y_);

		out.print(x+y);
		
		//파일 만들어서 저장하기 /data/score.dat /:webapp
		//json : {"x":3, "y":4}
		
		String rootPath = request.getServletContext().getRealPath("/");
		System.out.println(rootPath);
		System.out.println(String.format("x:%d, y:%d", x, y));
		//FileInputStream fos = new FileInputStream(rootPath+"data"+File.separator+"score.dat");
		
	}

}
