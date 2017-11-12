package controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.Item;
import data.WalletDAO;


@SessionAttributes("yourWallet")
@Controller
public class WalletController {

	@Autowired
	WalletDAO dao;

	@ModelAttribute("yourWallet")
	public Item newItem() {
		return new Item();
	}

	// @RequestMapping(path="home.do", method=RequestMethod.GET)
	public String home() {
		return "index"; // jsp file
	}

	@RequestMapping(path = "info.do")
	public ModelAndView getItemById(@RequestParam("id") Integer id /*
																		 * ,
																		 * 
																		 * @ModelAttribute("bestGiraffe") Giraffe best
																		 */) {
		ModelAndView mv = new ModelAndView("info");
		Item best = dao.getItemById(id);
		mv.addObject("item", best);
		return mv;

	}

	@RequestMapping(path = "delete.do")
	public ModelAndView delete(@RequestParam("id") Integer id /*
																 * ,
																 * 
																 * @ModelAttribute("bestGiraffe") Giraffe best
																 */) {
		ModelAndView mv = new ModelAndView("deleted");

		Item best = dao.getItemById(id);
		mv.addObject("type", best.getType());
		dao.deleteItem(best);

		return mv;

	}

	@RequestMapping(path = "edit.do", params = "id")
	public ModelAndView edit(@RequestParam("id") Integer id /*
															 * ,
															 * 
															 * @ModelAttribute("bestGiraffe") Giraffe best
															 */) {
		ModelAndView mv = new ModelAndView("edit");

		Item best = dao.getItemById(id);
		mv.addObject("item", best);

		return mv;

	}

	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public ModelAndView homeWithValidation() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		ItemIdForm f = new ItemIdForm();
		mv.addObject("itemIdForm", f);

		List<Item> allItems = dao.getAllItems();
		mv.addObject("list", allItems);

		return mv;

	}

	@RequestMapping(path = "getItem.do", method = RequestMethod.POST)
	public ModelAndView getItemByIdForm(@Valid @ModelAttribute("itemIdForm") ItemIdForm f, Errors e) {
		// @ModelAttribute("bestGiraffe")Giraffe best
		ModelAndView mv = new ModelAndView("index");
		if (e.hasErrors()) {
			mv.setViewName("index");
			return mv;
		}
		mv.setViewName("info");

		// Giraffe g = dao.getGiraffeById(id);
		Item best = dao.getItemById(f.getId());
		mv.addObject("item", best);
		return mv;
	}

	@RequestMapping(path = "add.do", method = RequestMethod.GET)
	public String addGiraffe(Model model) {
		Item i = new Item();
		model.addAttribute("item", i);

		return "add";
	}

	@RequestMapping(path="addItem.do", method=RequestMethod.POST)
	public ModelAndView doAdd(@Valid Item item, Errors e) {
		ModelAndView mv = new ModelAndView();
		if(e.hasErrors()) {
			mv.setViewName("add");
			return mv;
		}
		dao.addItem(item);
		mv.setViewName("added");
		return mv;
	}

	@RequestMapping(path = "editItem.do", method = RequestMethod.POST)
	public ModelAndView doEdit(@Valid Item item, Errors e) {
		ModelAndView mv = new ModelAndView();
		if (e.hasErrors()) {
			mv.setViewName("edit");
			return mv;
		}
		dao.editItem(item);

		mv.setViewName("added");
		return mv;
	}
}
