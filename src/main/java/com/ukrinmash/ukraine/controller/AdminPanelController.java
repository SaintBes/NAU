package com.ukrinmash.ukraine.controller;

import com.ukrinmash.ukraine.domain.*;
import com.ukrinmash.ukraine.service.DocumentsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("user")
public class AdminPanelController {
    public static final Logger log = Logger.getLogger(AdminPanelController.class);


    @Autowired
    DocumentsService documentsService;


    @RequestMapping(value = "/adminpanel", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String adminpanel(Model model, HttpSession session) {

        List<Document> docsList = documentsService.getAllDocs();
        List<DocumentForJSTL> documentForJSTLs = new ArrayList<DocumentForJSTL>();
        for (Document document : docsList) {
            List<String> imagesString = new ArrayList<String>();
            DocumentForJSTL documentForJSTL = new DocumentForJSTL();
            documentForJSTL.setDoc(document.getHtml());
            documentForJSTL.setDocName(document.getDocumentName());
            documentForJSTL.setDocId(document.getDocId());

            documentForJSTL.setDocRating(document.getDocRating());
            documentForJSTLs.add(documentForJSTL);

            model.addAttribute("docsfd", documentForJSTLs);
        }

        return "adminpanel";

    }


    @RequestMapping(value = "/addart", method = RequestMethod.POST)
    public String addart(HttpServletRequest request, HttpServletResponse response,
                         @RequestParam("sectionDrop") String sectionDrop,
                         @RequestParam("docName") String docName,
                         @RequestParam("doc") String doc,
                         @RequestParam("filesList") List<MultipartFile> files,
                         Model model, HttpSession session) {


        System.out.println(docName);
        for (MultipartFile file : files) {
            System.out.println(file.getOriginalFilename() + "=======================");

        }

        DocRating rating = new DocRating();
        documentsService.saveRating(rating);
        rating.setVoters(0);
        rating.setRating(0.0);


        Document document = new Document();
        document.setDocumentName(docName);
        document.setHtml(doc);
        document.setSection(DocumentSection.valueOf(sectionDrop));
        document.setDocRating(rating);

        List<Images> imagesList = new ArrayList<Images>();

        for (MultipartFile file : files) {

            Images image = new Images();


            try {
                byte[] bytes = file.getBytes();
                image.setBinaryImage(bytes);
                image.setFileName(file.getOriginalFilename());
                image.setFileType(file.getContentType());
                image.setFileSize(file.getSize());
            } catch (IOException e) {
                e.printStackTrace();
            }

            imagesList.add(image);
        }
        documentsService.addNewArticle(document, imagesList);


        return "adminpanel";
    }

    @RequestMapping(value = "/removeart", method = RequestMethod.GET)
    public ModelAndView removeart(HttpServletRequest request,
                            HttpServletResponse response,
                            Model model, HttpSession session){

        Document document;
        DocRating docRating;
        List<Images> images;


        if(request.getParameter("delete")!=null && request.getParameter("ratingId")!=null) {
            long docId=Long.parseLong(request.getParameter("delete"));
            document = documentsService.getDocById(docId);
            images = documentsService.getImages(document);
            docRating = documentsService.getRatingById(Long.parseLong(request.getParameter("ratingId")));

            for (Images image : images) {

               documentsService.deleteImage(image);


            }
            documentsService.deleteDocument(document);
            documentsService.deleteRating(docRating);

        }

        ModelAndView mv = new ModelAndView();

      mv.setView(new RedirectView("adminpanel#del", true));

        return mv;
    }

}
