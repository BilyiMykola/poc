package com.alpha.poc.controller;

import com.alpha.poc.service.ImageCompareService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);

    @Autowired
    private ImageCompareService imageCompareService;

    @RequestMapping("/")
    public String main() {
        return "main";
    }

    @RequestMapping(path = "/compare", method = RequestMethod.POST)
    public String compareImages(Model model, @RequestParam("firstImage") MultipartFile firstImage,
                                 @RequestParam("secondImage") MultipartFile secondImage) {
        boolean res = imageCompareService.isSameImage(getBufferedImage(firstImage), getBufferedImage(secondImage));
        model.addAttribute("message", res ? "Loaded images are the same!" : "Loaded images are not the same!");
        return "main";
    }

    private BufferedImage getBufferedImage(MultipartFile file) {
        try {
            return ImageIO.read(file.getInputStream());
        } catch (IOException e) {
            logger.error(e);
        }

        return null;
    }
}
