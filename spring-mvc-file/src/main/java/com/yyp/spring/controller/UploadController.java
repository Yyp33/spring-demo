package com.yyp.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class UploadController {

    /**
     *  单文件上传
     * @return
     */
    public String upload01(MultipartFile myFile){
        System.out.println(myFile.getOriginalFilename());
        return null;
    }
}
