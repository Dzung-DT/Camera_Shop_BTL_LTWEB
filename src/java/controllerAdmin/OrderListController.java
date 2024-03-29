package controllerAdmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;

import model.CartItem;
import service.CartItemService;
import service.CartService;
import service.impl.CartServiceImpl;
import service.impl.CartServiceItemImpl;

@WebServlet(urlPatterns= "/admin/order/list")
public class OrderListController extends HttpServlet{
	CartItemService cartItemService=new CartServiceItemImpl();
	CartService cartService=new CartServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<CartItem> listCartItem =cartItemService.getAll();
//		req.setAttribute("listCartItem", listCartItem);
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/tableOrder.jsp");
//		dispatcher.forward(req, resp);
                List<Cart> cartList = cartService.getAll();
                req.setAttribute("cartList", cartList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/tableOrder.jsp");
		dispatcher.forward(req, resp);
	}
}
