package pojo.board.step2;

public class ActionForward {
	private String  path 		= null;//페이지 이름 담기
	/*
	 * RequestDispatcher view = req.getRequestDispatcher("XXX.jsp");
	 * view.forward(req,res);//url은 그대로 인데 페이지 내용은 바뀌어 있다.
	 * 내 안에 있는 페이지의 배포위치는 어디인가? (webapp아래 , WEB-INF/views/board/XXX.jsp
	 */
	private boolean isRedirect 	= false;//true:sendRedirect("XXX.jsp"), false:view.forward(req,res);
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
