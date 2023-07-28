package com.jtspringproject.JtSpringProject.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController{
	static String username = "";

	public static void setUsername(String username) {
		UserController.username = username;
	}
	@GetMapping("/cart")
	public String cart(){
		return "cart";
	}
	@GetMapping("/customcart")
	public String customCart(){
		return "customcart";
	}

	@GetMapping("/register")
	public String registerUser()
	{
		return "register";
	}
	@GetMapping("/contact")
	public String contact()
	{
		return "contact";
	}
	@GetMapping("/buy")
	public String buy()
	{
		return "buy";
	}
	
	@GetMapping("/user/products")
	public String getproduct(Model model) {
		return "uproduct";
	}

	// ...

	@ResponseBody
	@GetMapping("/checkUsernameAvailability")
	public Map<String, Boolean> checkUsernameAvailability(@RequestParam("username") String username) {
		Map<String, Boolean> response = new HashMap<>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject", "root", "12345678");
			PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?");
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				response.put("exists", count > 0);
			} else {
				response.put("exists", false);
			}
		} catch (Exception e) {
			System.out.println("Exception:" + e);
			response.put("exists", false);
		}
		return response;
	}

	@ResponseBody
	@GetMapping("/checkEmailAvailability")
	public Map<String, Boolean> checkEmailAvailability(@RequestParam("email") String email) {
		Map<String, Boolean> response = new HashMap<>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject", "root", "12345678");
			PreparedStatement pst = con.prepareStatement("SELECT COUNT(*) FROM users WHERE email = ?");
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				response.put("exists", count > 0);
			} else {
				response.put("exists", false);
			}
		} catch (Exception e) {
			System.out.println("Exception:" + e);
			response.put("exists", false);
		}
		return response;
	}

	@RequestMapping(value = "newuserregister", method = RequestMethod.POST)
	public String newUseRegister(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("email") String email, @RequestParam("address") String address)
	{
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject","root","12345678");
			PreparedStatement pst = con.prepareStatement("insert into users(username,password,email,address) values(?,?,?,?);");
			pst.setString(1,username);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.setString(4, address);

			//pst.setString(4, address);
			int i = pst.executeUpdate();
			System.out.println("data base updated"+i);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		return "redirect:/";
	}
	@GetMapping("clearcart")
	public String clearcart() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject","root","Swisschoc2@");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("delete from Cart where userID = (select user_id from users where username = '" + username + "');");

			if (rst.next()) {
				int userID = rst.getInt("user_id");
				stmt.executeUpdate("DELETE FROM Cart WHERE userID = " + userID + ";");
			}

		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		return "cart";
	}



	@GetMapping("moveCustomToCart")
	public String moveCustomToCart(Model model) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject", "root", "Swisschoc2@");
			Statement stmt = con.createStatement();

			// Fetch existing items and quantities from Cart
			Map<String, Integer> cartItems = new HashMap<>();
			ResultSet cartRs = stmt.executeQuery("SELECT productID, quantity FROM Cart WHERE userID = (SELECT user_id FROM users WHERE username = '" + username + "');");
			while (cartRs.next()) {
				String productID = cartRs.getString("productID");
				int quantity = cartRs.getInt("quantity");
				cartItems.put(productID, quantity);
			}

			// Fetch items and quantities from CustomCart
			ResultSet customCartRs = stmt.executeQuery("SELECT productID, quantity FROM CustomCart WHERE username = '" + username + "';");
			while (customCartRs.next()) {
				String productID = customCartRs.getString("productID");
				int quantity = customCartRs.getInt("quantity");

				// Check if the product is already in the cart
				if (cartItems.containsKey(productID)) {
					int currentQuantity = cartItems.get(productID);
					int newQuantity = currentQuantity + quantity;
					// Update the quantity in the Cart table
					stmt.executeUpdate("UPDATE Cart SET quantity = " + newQuantity + " WHERE userID = (SELECT user_id FROM users WHERE username = '" + username + "') AND productID = '" + productID + "';");
				} else {
					stmt.executeUpdate("INSERT INTO Cart (userID, productID, quantity) VALUES ((SELECT user_id FROM users WHERE username = '" + username + "'), NULL, '" + productID + "', " + quantity + ");");
				}
			}

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
		return "cart";
	}

}
