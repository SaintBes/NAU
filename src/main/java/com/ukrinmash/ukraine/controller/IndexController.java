package com.ukrinmash.ukraine.controller;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.ukrinmash.ukraine.domain.*;
import com.ukrinmash.ukraine.service.DocumentsService;
import com.ukrinmash.ukraine.service.UserService;
import com.ukrinmash.ukraine.service.VoteCacheService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("user")
public class IndexController {
    public static final Logger log = Logger.getLogger(IndexController.class);
    @Autowired
    private UserService userService;

    @Autowired
    DocumentsService documentsService;

    @Autowired
    VoteCacheService voteCacheService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD, RequestMethod.POST})
    public String index(HttpServletRequest request, Model model, HttpSession session) {


        model.addAttribute("sessionProperties", new SessionProperties("session id_" + session.getId()));
        model.addAttribute("user", new User());


        List<Images> imagesList = documentsService.getAllImages();
        List<Document> docsList;
        List<DocumentForJSTL> documentForJSTLs = new ArrayList<DocumentForJSTL>();


        if (request.getParameter("section") == null) {
            if (request.getParameter("id") == null) {
                docsList = documentsService.getAllDocs();
            } else {
                docsList = new ArrayList<Document>();
                docsList.add(documentsService.getDocById(Long.valueOf(request.getParameter("id"))));
            }
        } else {
            docsList = documentsService.getBySection(DocumentSection.valueOf(request.getParameter("section")));
        }

        for (Document document : docsList) {
            List<String> imagesString = new ArrayList<String>();
            DocumentForJSTL documentForJSTL = new DocumentForJSTL();
            documentForJSTL.setDoc(document.getHtml());
            documentForJSTL.setDocName(document.getDocumentName());
            documentForJSTL.setDocId(document.getDocId());
            int i = 0;
            for (Images images : documentsService.getImages(document)) {
                imagesString.add(Base64.encode(images.getBinaryImage()));
            }
            documentForJSTL.setImages(imagesString);
            documentForJSTL.setDocRating(document.getDocRating());
            documentForJSTLs.add(documentForJSTL);

            model.addAttribute("docs", documentForJSTLs);
        }
        log.info("/index controller");
        return "index";
    }

    @RequestMapping(value = "rating", method = RequestMethod.GET)
    public @ResponseBody VoteStatus rating( @CookieValue("JSESSIONID") String cookie,
                         HttpServletRequest request,
                        Model model,
                         HttpSession session
                        ) {

        //response.setContentType("application/json");
        VoteStatus voteStatus = new VoteStatus();



        long docRatingId = Long.parseLong(request.getParameter("id"));
        double rating = Double.valueOf(request.getParameter("score"));

        List<VotesCache> votesCacheList = voteCacheService.findByDocRatingId(docRatingId);
        for (VotesCache votesCache : votesCacheList) {
            if (votesCache.getSesscionId().equals(cookie)) {
                voteStatus.setStatus("Err");
                voteStatus.setMsg("Раніше ві голосували за цей об`экт");
                return voteStatus;


            }

        }

        DocRating docRating = new DocRating();



        if (documentsService.getRatingById(docRatingId)!=null) {
            int newVoters;
            docRating=documentsService.getRatingById(docRatingId);
            newVoters = docRating.getVoters()+1;
            docRating.setRating((docRating.getRating()*docRating.getVoters()+rating)/newVoters);
            docRating.setVoters(newVoters);
            documentsService.updateRating(docRating);
        }
        else {
            docRating.setRating(rating);
            docRating.setVoters(1);
            documentsService.saveRating(docRating);
        }




        voteCacheService.addVoteCache(new VotesCache(cookie,docRatingId));

        voteStatus.setStatus("OK");
        voteStatus.setMsg("Ваш голос прийнято");

        log.info("/rating controller");
        
        return voteStatus;
    }

    @RequestMapping(value = "register.html", method = RequestMethod.POST)
    public String register(@RequestParam("password") String password,
                           @RequestParam("email") String email, Model model) {

        if (userService.registerNewUserAccount(email, password).getId() > 0) {
            model.addAttribute("message", "Registration was successful");
        }

        log.info("/registration controller");
        return "index";
    }


}