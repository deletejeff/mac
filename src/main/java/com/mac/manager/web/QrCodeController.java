package com.mac.manager.web;

import com.google.zxing.BarcodeFormat;
import com.mac.common.utils.QrPicUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by machao on 2015/3/31.
 */
@Controller
@RequestMapping("/qrcode")
public class QrCodeController {

    @RequestMapping("/indexQr.do")
    public void indexQr(String content, Integer width, HttpServletResponse response){
        int size = 120;
        if(width!=null){
            size = width;
        }
        try {
            content = URLDecoder.decode(content, "UTF-8");
            response.setContentType("image/jpg");
            BufferedImage qr_codeBufferedImage = QrPicUtil.getInstance().getQR_CODEBufferedImage(
                    content, BarcodeFormat.QR_CODE, size, size,
                    QrPicUtil.getInstance().getDecodeHintType());
            ServletOutputStream outputStream = response.getOutputStream();
            ImageIO.write(qr_codeBufferedImage, "jpeg", outputStream);
            outputStream.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
