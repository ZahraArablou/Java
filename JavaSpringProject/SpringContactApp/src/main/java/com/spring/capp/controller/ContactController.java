package com.spring.capp.controller;

import com.spring.capp.domain.Contact;
import com.spring.capp.service.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/user/contact_form")
    public String contactForm(Model m) { // you need to bind your command then it is accessible in jsp page.
        Contact contact = new Contact();
        m.addAttribute("command", contact);
        return "contact_form"; //JSP form view
    }

    @RequestMapping(value = "/user/edit_contact")
    public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId) {
        session.setAttribute("aContactId", contactId);
        Contact c = contactService.findById(contactId);
        m.addAttribute("command", c);
        return "contact_form"; //JSP form view
    }

    @RequestMapping(value = "/user/save_contact")
    public String saveOrUpdateContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
 //session.setAttribute("aContactId", c.getContactId());
        Integer contactId = (Integer) session.getAttribute("aContactId");
        if (contactId == null) {
            //save task
            try {
                Integer userId = (Integer) session.getAttribute("userId");
                c.setUserId(userId);//FK ;logged in userIdcontactId
                contactService.save(c);
                return "redirect:clist?act=sv"; //redirect user to contact list url
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to Save contact");
                return "contact_form";
            }
        }else{
            //update task
           try {
               c.setContactId(contactId);//pk
                contactService.update(c);
                session.removeAttribute("aContactId"); // FIXED HERE
                return "redirect:clist?act=ed"; //redirect user to contact list url
            } catch (Exception e) {
                e.printStackTrace();
                m.addAttribute("err", "Failed to Edit contact");
                return "contact_form";
            } 
        }
    }

    @RequestMapping(value = "/user/clist")
    public String contactList(Model m, HttpSession session) {//we get recently user from the session
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId));
        return "clist"; //JSP 
    }
    
     @RequestMapping(value = "/user/contact_search")
    public String contactSearch(Model m, HttpSession session,@RequestParam("freeText") String freeText ) {//we get recently user from the session
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contactService.findUserContact(userId,freeText));
        return "clist"; //JSP 
    }

    @RequestMapping(value = "/user/del_contact")
    public String deleteContact(@RequestParam("cid") Integer contactId) {//we get recently user from the session
        contactService.delete(contactId);
        return "redirect:clist?act=del"; //JSP 
    }
    
    @RequestMapping(value = "/user/bulk_cdelete")
    public String deleteContact(@RequestParam("cid") Integer[] contactIds) {//we get recently user from the session
        contactService.delete(contactIds);
        return "redirect:clist?act=del"; //JSP 
    }
}
