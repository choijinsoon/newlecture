package webPrj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Servlet");  
//		response.getOutputStream(); //문자 형식의 출력
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        response.setContentType("image/png;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();//=printStream 클라이언트로 전송 //문자열 형식의 출력
		
		String c = request.getParameter("c");
		int count = Integer.parseInt(c);
		for(int i=0; i<count; i++)
			out.printf("<b>안녕ㅎ</b> Client%d<br>", i+1); //어떤 문서인지 전달 //웹문서
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
        // 출력 도구
//        String realPath = request.getServletContext().getRealPath("/");
//        System.out.println(realPath);
//        
//		FileInputStream fis = new FileInputStream(realPath+"pic1.png");
//		OutputStream os = response.getOutputStream();
//		
//		byte[] buf = new byte[1024];
//		int len = 0;
//		while((len=fis.read(buf)) > 0) {
//			os.write(buf, 0, len);
//			System.out.println(len);
//		}
//		
//		fis.close();
	}
}
