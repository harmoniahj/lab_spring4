package pojo.board.step2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.board.step1.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
