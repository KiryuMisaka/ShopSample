package jp.co.illmatics;


//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import jp.co.illmatics.apps.shopping.model.User;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class ShoppingController {
	
//	@Autowired
//	public User adminUseresReq;
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String getAdminLogin() {
		return "/admin/login.html";
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.POST)
	public String postAdminLogin(@RequestParam(value="name",required=false,defaultValue="test") String name,Model model) {
		model.addAttribute("name", name);
		System.out.print("abc");
		return "redirect:/admin/login.html";				
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.POST)
	public String postAdminHome() {
		return "/admin/home.html";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingController.class, args);
	}
}