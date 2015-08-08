package jp.co.smart.app.welcome;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory
            .getLogger(HelloController.class);

/*
    @Inject
    PasswordEqualsValidator passwordEqualsValidator; // (1)

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    		binder.addValidators(validators);
    }
*/

    @ModelAttribute
    public HelloForm setUpHelloForm() {
    	HelloForm form = new HelloForm();
    	return form;
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "welcome/home";
    }

    @RequestMapping("hello")
    public String hello(RedirectAttributes redirectAttrs) {
    	redirectAttrs.addAttribute("id", "testId");

    	return "redirect:/sample/hello?complete";
    }

    @RequestMapping("hello1")
    public String hello1(RedirectAttributes redirectAttrs) {
    	redirectAttrs.addAttribute("id", "testId");

    	return "redirect:/sample/hello/{id}?complete";
    }

    @RequestMapping("readCookie")
    public String readCookie(@CookieValue("JSESSIONID") String sessionId, Model model) {

    	return "sample/readCookie";
    }

    @RequestMapping("writeCookie")
    public String writeCookie(Model model, HttpServletResponse response) {

    	Cookie cookie = new Cookie("foo", "hello world");
    	response.addCookie(cookie);

    	return "sample/writeCookie";
    }

    @RequestMapping("hello2")
    public String hello2(HelloForm form, BindingResult result, Model model) {

    	if (result.hasErrors()) {
    		return "sample/input";
    	}
    	return "sample/hello2";
    }
    
    @RequestMapping(value = "save", params = "complete", method = RequestMethod.GET)
    public String saveComplete(SessionStatus sessionStatus) {
    	sessionStatus.setComplete();
    	return "wizard/complete";
    }

    @RequestMapping(value = "save", params = "cancel", method = RequestMethod.POST)
    public String saveCancel(SessionStatus sessionStatus) {
    	sessionStatus.setComplete();
    	return "redirect:/wizard/menu";
    }

    @RequestMapping(value = "create",method = RequestMethod.GET)
    public String initializeWizardForm(SessionStatus sessionStatus) {
    	sessionStatus.setComplete();
    	return "redirect:/wizard/create?form1";
    }

    @RequestMapping(value = "create", params = "form1")
    public String createForm1() {
    	return "wizard/form1";
    }
}
