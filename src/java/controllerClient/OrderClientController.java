package controllerClient;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.CartItem;
import model.Person;
import model.Product;
import service.CartItemService;
import service.CartService;
import service.PersonService;
import service.ProductService;
import service.impl.CartServiceImpl;
import service.impl.CartServiceItemImpl;
import service.impl.PersonServiceImpl;
import service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/client/order/add")
public class OrderClientController extends HttpServlet{
        ProductService productService = new ProductServiceImpl();
	CartService cartService = new CartServiceImpl();
	CartItemService cartItemService = new CartServiceItemImpl();
	PersonService personService = new PersonServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
                String fullname = req.getParameter("fullname");              	
		String phone = req.getParameter("phoneOrder");               	
		String address = req.getParameter("deliveryAddress");
               
                 
		HttpSession session = req.getSession();
		Object objP = session.getAttribute("user");
		Person buyer = (Person) objP;
		int buyerId = buyer.getId();
		Cart cart = new Cart();	
		cart.setBuyDate(new Date());
		buyer = personService.get(buyerId);
		cart.setBuyer(buyer);
                cart.setNameOrder(fullname);
                cart.setPhoneOrder(phone);
                cart.setAddressOrder(address);              
		cartService.insert(cart);
		Object obj = session.getAttribute("cart");
		if( obj != null) {	
			Map<Integer,CartItem> mapCartItem = (Map<Integer,CartItem>)obj;
			Set<Integer> keys = mapCartItem.keySet();
			for(Integer k : keys) {
				CartItem cartItem = mapCartItem.get(k);
                                int productID = cartItem.getProduct().getId();
                                int buyQuantity = cartItem.getBuyQuantity();
                                Product product = productService.get(productID);
                                int oldQuantity = product.getQuantity();
                                int newQuantity = oldQuantity - buyQuantity;
                                productService.updateProductQuantity(productID,newQuantity);
				cartItem.setCart(cart);
				cartItemService.insert(cartItem);
			}
		}
		resp.sendRedirect(req.getContextPath() + "/client/view/product-list");
	}
}
