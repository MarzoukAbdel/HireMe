package com.example.hireme.utils;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Data
@Component
public class imageUtils {


//    private BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
//        BufferedImage resizedImage = new BufferedImage(desiredWidth, desiredHeight, BufferedImage.TYPE_INT_RGB);
//        Graphics2D graphics2D = resizedImage.createGraphics();
//        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        graphics2D.drawImage(originalImage, 0, 0, desiredWidth, desiredHeight, null);
//        graphics2D.dispose();
//        return resizedImage;
//    }


    public Boolean checkImage(MultipartFile imageFile) {
        if (!imageFile.isEmpty()) {
            if (!imageFile.getContentType().equals("image/png") && !imageFile.getContentType().equals("image/jpeg") && !imageFile.getContentType().equals("image/jpg")) {
                throw new IllegalArgumentException("Only PNG,JPG and JPEG images are allowed");
            } else {
                return true;
            }
        }
        else return false;
    }


}
