package com.keer.multipartfiledemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @BelongsProject: spring-boot-study
 * @BelongsPackage: com.keer.multipartfiledemo.controller
 * @Author: keer
 * @CreateTime: 2020-03-26 14:45
 * @Description:
 */
@org.springframework.stereotype.Controller
public class Controller {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload")
    public String addPeopleInfo(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        logger.info("接收到请求：/upload");

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "上传文件为空，请重新选择文件");
            logger.info("上传文件为空");
            return "redirect:/uploadStauts";
        }

        String strPath = "multipartfiledemo/file/" + file.getOriginalFilename();
        File nfile = new File(strPath);
        File fileParent = nfile.getParentFile();
        if (!fileParent.exists()) {
            fileParent.mkdirs();
        }
        nfile.createNewFile();

        Path path = Paths.get(strPath);
        Files.write(path, file.getBytes());
        redirectAttributes.addFlashAttribute("message",
                "成功上传文件： '" + file.getOriginalFilename() + "'");
        logger.info("上传文件成功，文件名称：" + file.getOriginalFilename());
        return "redirect:/uploadStauts";
    }

    @GetMapping("/uploadStauts")
    public String uploadStatus() {
        return "uploadStauts";
    }
}
