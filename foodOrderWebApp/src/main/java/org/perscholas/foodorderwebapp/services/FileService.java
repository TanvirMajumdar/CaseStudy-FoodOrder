package org.perscholas.foodorderwebapp.services;

import org.perscholas.foodorderwebapp.dao.ImagesRepo;
import org.perscholas.foodorderwebapp.exceptions.FileStorageException;
import org.perscholas.foodorderwebapp.models.Images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class FileService {

    ImagesRepo imagesRepo;

    @Autowired
    public FileService(ImagesRepo imagesRepo) {
        this.imagesRepo = imagesRepo;
    }

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    public Long uploadFile(MultipartFile file) {

        Images img;
        try {
            String filename= StringUtils.cleanPath(file.getOriginalFilename());
            Path copayLocation = Paths.get(uploadDir + File.separator + filename);
            Files.copy(file.getInputStream(),copayLocation, StandardCopyOption.REPLACE_EXISTING);
            img =imagesRepo.save(new Images(filename));
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename() + ". Please try again.");
        }
        return img.getId();
    }

    public List<Images> getAllImages(){
        return imagesRepo.findAll();
    }
}
