import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
	

	@GetMapping({"", "/"})
		public String main () {
			return "home";
		}
	
}
