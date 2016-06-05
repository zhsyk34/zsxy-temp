package com.cat.crg.servlet;

import com.cat.crg.dao.UserDao;
import com.cat.crg.pojo.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Archimedes on 2016/6/3.
 */
public class UserListServlet extends HttpServlet {

    public UserListServlet() {
        System.out.println("constructor");
    }

    @Override
    public void init() throws ServletException {
        String name = this.getInitParameter("name");
        System.out.println("init, name: " + name);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get method,forward");
        System.out.println(req.getParameter("address"));
        UserDao userDao = new UserDao();
        List<User> list = userDao.findList();
        req.setAttribute("list", list);

        //req.getRequestDispatcher("forward.jsp").forward(req, resp);// 当前路径为web.xml中的servlet/user/list,url=servlet/user/forward.jsp
        req.getRequestDispatcher("../../jsp/forward.jsp").forward(req, resp);

        //绝对路径
        //req.getRequestDispatcher("/jsp/forward.jsp").forward(req, resp);// 这里的/表示项目的根路径
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post method,redirect");
        UserDao userDao = new UserDao();
        List<User> list = userDao.findList();
        //req.setAttribute("list", list);//redirect不能携带信息
        req.getSession().setAttribute("list", list);

        //resp.sendRedirect("redirect.jsp");//类所在路径认为是:web.xml中的配置servlet/user/list-->url=servlet/user/redirect.jsp
        String rootPath = req.getContextPath();//项目根路径
        resp.sendRedirect(rootPath + "/jsp/redirect.jsp");
//        resp.sendRedirect("/jsp/redirect.jsp");//这里的/表示服务器根路径
    }
}
