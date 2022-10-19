package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import rikkei.academy.model.DTO;
import rikkei.academy.model.Meo;
import rikkei.academy.service.IMeoService;

import java.io.File;

@Controller
public class MeoController {
@Autowired
IMeoService meoService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("listMeo",meoService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("meo",new DTO());
        return "create";
    }
    @Value("${chinh}")
    private String fileUpload;
    @PostMapping("/save")
    public String createMeo( @ModelAttribute("meo") DTO dto){
        MultipartFile multipartFile = dto.getImage();
        String nameImage = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(dto.getImage().getBytes(), new File(fileUpload + nameImage));
        }catch (Exception e){
            e.printStackTrace();
        }
        Meo meo = new Meo(dto.getId(), dto.getName(),dto.getAge(),nameImage);
        meoService.save(meo);
        System.out.println(meoService.findAll());
        return "redirect:/";

    }
}
