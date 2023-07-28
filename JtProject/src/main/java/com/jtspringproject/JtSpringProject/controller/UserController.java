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
	public String clearcart(Model model) {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject","root","12345678");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("delete from Cart where userID = (select user_id from users where username = '" + username + "';");

		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		return "cart";
	}
}
