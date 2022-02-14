package servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ThreadLocalData;
import service.TestSerice;

@WebServlet("/servlet/thread")
public class ThreadServlet extends HttpServlet  {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(request.getRequestURI());
        
		ThreadLocalData vo = ThreadLocalData.tl.get();
		vo.add("P : " + Thread.currentThread().getName());
		System.out.println("vo: " + vo);
		if (vo != null) {
			vo.print();
		}

		int loopCnt = 10;
		final Integer[] resultCnt = {0};

		for (int i = 0; i < loopCnt; i++) {
			int finalI = i;
			Runnable runnable = new Runnable() {
				public void run() {//                    System.out.println(Thread.currentThread().getName() + " - run");
					int result = new TestSerice().test1(finalI + "");
					resultCnt[0] += result;
				}
			};
			new Thread(runnable).start();
		}

		if (vo != null) {
			vo.print();
		}
		response.getWriter().print("hello");
    }
}
