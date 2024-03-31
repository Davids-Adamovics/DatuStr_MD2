package com.sandisedijs.zpus.controllers;

import com.sandisedijs.zpus.models.Author;
import com.sandisedijs.zpus.models.User;
import com.sandisedijs.zpus.repo.IUniversityPositionRepo;
import com.sandisedijs.zpus.services.IAttachmentsService;
import com.sandisedijs.zpus.services.IAuthorService;
import com.sandisedijs.zpus.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.*;
import java.util.Arrays;
import java.util.Set;

@Controller
public class UserController
{
    @Autowired
    IUserService userService;

    @Autowired
    IAuthorService authorService;

    @Autowired
    IUniversityPositionRepo universityPositionRepo; //TODO Edijs - vēlāk uz servisu

    @Autowired
    IAttachmentsService attachmentsService;

    @Autowired
    Validator validator;

    @GetMapping("/profile")
    public String viewProfile(User user, Model model)
    {
        String universityPositions;
        Author author = userService.getCurrentUser().getAuthor();
        String photo = "";

        if (author == null)
        {
        {

        {
            [
                {
                    {{{{{{{
            universityPositions = "";
        } else
        {
            universityPositions = Arrays.toString(author.getUniversityPositions().toArray()).replace("[", "").replace("]", "");
            if (author.getPhoto() != null && author.getPhoto() != "")
            {
                photo = author.getPhoto();
            }
        }
        System.out.println(photo);
        model.addAttribute("photo", photo);
        model.addAttribute("universityPositions", universityPositions);
        model.addAttribute("user", userService.getCurrentUser());

        return "profile";
    }

    @GetMapping("/profile/edit")
    public String viewProfileDetails(Author author, Model model)
    {
        Author userAuthor = (userService.getCurrentUser().getAuthor() != null) ? userService.getCurrentUser().getAuthor() : new Author("", "", false, false, userService.getCurrentUser(), null, null, null);
        userAuthor.setUser(userService.getCurrentUser());
        String photo = "";

        if (author.getPhoto() != null && author.getPhoto() != "")
        {
            photo = author.getPhoto();
        }
        System.out.println(photo);
        model.addAttribute("photo", photo);
        model.addAttribute("user", userService.getCurrentUser());
        model.addAttribute("universityPositions", universityPositionRepo.findAll());
        model.addAttribute("author", userAuthor);

        return "edit-profile";
    }

    @PostMapping("/profile/edit")
    public String saveProfileDetails(@Valid Author author, BindingResult result, @RequestParam("file") MultipartFile file, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("user", userService.getCurrentUser());
            return "edit-profile";
        }

        if (!file.isEmpty())
        {
            String filePath = attachmentsService.createFile(file);
            author.setCV(filePath);
        }

        author.setUser(userService.getCurrentUser());
        authorService.updateAuthor(author);

        return "redirect:/profile";
    }

    //TODO Edijs - pabeigt
    @PostMapping("/profile/upload-profile-image")
    public String uploadProfileImage(@RequestParam("image") MultipartFile file)
    {
        String filePath = attachmentsService.createFile(file);
        authorService.updateProfileImage(userService.getCurrentUser(), filePath);

        return "redirect:/profile/edit";
    }

    @GetMapping("/profile/change-password")
    public String viewPasswordChange(User user, Model model)
    {
        Author author = (userService.getCurrentUser().getAuthor() != null) ? userService.getCurrentUser().getAuthor() : new Author("", "", false, false, userService.getCurrentUser(), null, null, null);
        String photo = author.getPhoto();

        if (author.getPhoto() != null && author.getPhoto() != "")
        {
            photo = author.getPhoto();
        }

        model.addAttribute("user", userService.getCurrentUser());
        model.addAttribute("photo", photo);

        return "change-password";
    }

    @PostMapping("/profile/change-password")
    public String submitPasswordChange(User user, @RequestParam(value = "currentPassword") String currentPassword, @RequestParam(value = "repeatNewPassword") String repeatNewPassword, Model model)
    {
        String oldPasswordMatchError = (!userService.passwordsMatch(currentPassword)) ? "Nepareizi ievadīta parole" : "";
        String comparisonError = (!user.getPassword().equals(repeatNewPassword)) ? "Jaunā parole nesakrīt ar atkārtoti ievadīto" : "";
        String validationError = userService.validatePassword(user);

        if (!userService.passwordsMatch(currentPassword) || !validationError.equals("") || !user.getPassword().equals(repeatNewPassword))
        {
            Author author = (userService.getCurrentUser().getAuthor() != null) ? userService.getCurrentUser().getAuthor() : new Author("", "", false, false, userService.getCurrentUser(), null, null, null);
            String photo = author.getPhoto();

            if (author.getPhoto() != null && author.getPhoto() != "")
            {
                photo = author.getPhoto();
            }

            model.addAttribute("validationError", validationError);
            model.addAttribute("comparisonError", comparisonError);
            model.addAttribute("user", userService.getCurrentUser());
            model.addAttribute("photo", photo;
            model.addAttribute("oldPasswordMatchError", oldPasswordMatchError);

            return "change-password";
        }

        userService.changePassword(user.getPassword());

        return "redirect:/profile/edit";
    }

    // Choose publication type
    @GetMapping("/submit-publication")
    public String choosePublicationType(Model model)
    {
        model.addAttribute("user", userService.getCurrentUser());
        return "choose-publication-type";
    }

    // Submit new type book publication
    @GetMapping("/submit-book")
    public String submitBookGet(Model model)
    {
        model.addAttribute("user", userService.getCurrentUser());
        return "submit-book";
    }

    //TODO create POST for book /Sandis

    // Submit new type Publications in the collection of scientific articles
    @GetMapping("/submit-publications-in-the-collection-of-scientific-articles")
    public String submitScientificArticleGet(Model model)
    {
        model.addAttribute("user", userService.getCurrentUser());
        return "submit-scientific-article";
    }

    // TODO create POST for scientific article /Sandis

    // Submit new Chapter in a scientific monograph
    @GetMapping("/submit-chapter-in-scientific-monograph")
    public String submitChapterInMonographGet(Model model)
    {
        model.addAttribute("user", userService.getCurrentUser());
        return "submit-chapter-in-monograph";
    }

    //TODO create POST for chapter in monograph /Sandis

    // Submit new Scientific monograph
    @GetMapping("/submit-new-scientific-monograph")
    public String submitScientificMonographGet(Model model)
    {
        model.addAttribute("user", userService.getCurrentUser());
        return "submit-scientific-monograph";
    }

    // Submit new Scientific magazine
    @GetMapping("/submit-new-scientific-magazine")
    public String submitScientificMagazineGet(Model model)
    {
        model.addAttribute("user", userService.getCurrentUser());
        return "submit-scientific-magazine";
    }

    // Submit new Article in full-text conference proceedings
    @GetMapping("/submit-new-article-in-full-text-conference")
    public String submitArticleInFullTextConferenceGet(Model model)
    {
        model.addAttribute("user", userService.getCurrentUser());
        return "submit-article-in-full-text-conference";
    }

    // Submit new Article in the collection of conference theses
    @GetMapping("/article-in-collection-of-conference-theses")
    public String submitArticleInCollectionOfConferenceThesesGet(Model model)
    {
        model.addAttribute("user", userService.getCurrentUser());
        return "submit-article-in-collection-of-theses";
    }
}
