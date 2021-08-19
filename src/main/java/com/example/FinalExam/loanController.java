package com.example.FinalExam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping
@Controller
public class loanController {
    DataBaseImplementation service;
        @Autowired
        Connection connect;
        //a mapping when someone enters file

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String showloanPage2(ModelMap model) throws ClassNotFoundException, SQLException {
            service = new DataBaseImplementation(connect.connect());
            model.addAttribute("todos", service.display());
            List<Loan> filteredTodos = new ArrayList<Loan>();
            filteredTodos = (List) model.get("todos");
            model.put("no", filteredTodos.get(0).getClientno());
            model.put("clientname", filteredTodos.get(0).getClientname());
            model.put("loanamount", filteredTodos.get(0).getLoanamount());
            model.put("years", filteredTodos.get(0).getYears());
            model.put("loantype", filteredTodos.get(0).getLoantype());

            return "loantable";
        }

        @RequestMapping(value = "/loantable", method = RequestMethod.GET)
        public String showLoanpage(ModelMap model,@RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException {
            service = new DataBaseImplementation(connect.connect());
            model.addAttribute("todos", service.display());
            List<Loan> filteredTodos = new ArrayList<Loan>();
            filteredTodos = (List) model.get("todos");
            model.put("id", filteredTodos.get(0).getClientno());
            model.put("clientname", filteredTodos.get(0).getClientname());
            model.put("loanamount", filteredTodos.get(0).getLoanamount());
            model.put("years", filteredTodos.get(0).getYears());
            model.put("loantype", filteredTodos.get(0).getLoantype());

            return"loantable";
        }

    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String delete(ModelMap model, @RequestParam String id) throws SQLException, ClassNotFoundException {
        service.delete(id);
        model.clear();
        return "redirect:/";
    }


    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException {
        model.put("id", id);
        Loan aa = service.search(id);
        model.put("id", aa.getClientno());
        model.put("clientname",aa.getClientname());
        model.put("loanamount", aa.getLoanamount());
        model.put("years", aa.getYears());
        model.put("loantype", aa.getLoantype());
        return "loanedit";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model, @RequestParam String clientno, @RequestParam String clientname,@RequestParam double loanamount,@RequestParam int years,@RequestParam String loantype) throws SQLException, ClassNotFoundException {

        String iid = (String) model.get("id");
        Loan aa = new Loan(clientno,clientname,loanamount,years,loantype);
        service.update(aa,iid);
        return "redirect:/";
    }
    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showpage()
    {
        return "loanadd";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String add(ModelMap model, @RequestParam String clientno, @RequestParam String clientname,@RequestParam double loanamount,@RequestParam int years,@RequestParam String loantype) throws SQLException, ClassNotFoundException {
        if (!((service.search(clientno)) == null)) {
            model.put("errorMessage", "The Record you are trying to add is already existing.Choose a different customer number ");
            return "redirect/loantable";
        }
        Loan aa = new Loan(clientno,clientname,loanamount,years,loantype);
        service.add(aa);
        model.clear();
        return "redirect:/loantable";
    }
    }
