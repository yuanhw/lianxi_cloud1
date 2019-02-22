package lianxi.cloud.fileupload.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author: WangYuanHang
 * @Description:
 * @date: 2019/2/22 9:59
 */
@RestController
public class FileUploadController {
    @PostMapping(value = "upload")
    public String handleFileUpload(@RequestParam MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, fileToSave);
        return fileToSave.getAbsolutePath();
    }
}
