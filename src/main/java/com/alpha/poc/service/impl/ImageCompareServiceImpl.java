package com.alpha.poc.service.impl;

import com.alpha.poc.service.ImageCompareService;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class ImageCompareServiceImpl implements ImageCompareService {

    @Override
    public boolean isSameImage(BufferedImage firstImage, BufferedImage secondImage) {
        if (firstImage == null || secondImage == null) {
            throw new IllegalArgumentException("Input params can't be null.");
        }

        boolean isSame = isSameDimensions(firstImage, secondImage);

        for (int heightIndex = 0; heightIndex < firstImage.getHeight() && isSame; heightIndex++) {
            for (int widthIndex = 0; widthIndex < firstImage.getWidth() && isSame; widthIndex++) {

                int firstImagePointRgb = firstImage.getRGB(widthIndex, heightIndex);
                int secondImagePointRgb = secondImage.getRGB(widthIndex, heightIndex);

                isSame = isSameRgb(firstImagePointRgb, secondImagePointRgb);
            }
        }

        return isSame;
    }

    private boolean isSameRgb(int firstRgb, int secondRgb) {
        int r1 = (firstRgb >> 16) & 0xff;
        int g1 = (firstRgb >> 8) & 0xff;
        int b1 = firstRgb & 0xff;

        int r2 = (secondRgb >> 16) & 0xff;
        int g2 = (secondRgb >> 8) & 0xff;
        int b2 = secondRgb & 0xff;

        return r1 == r2 && g1 == g2 && b1 == b2;
    }

    private boolean isSameDimensions(BufferedImage firstImage, BufferedImage secondImage) {
        return firstImage.getHeight() == secondImage.getHeight() &&
                firstImage.getWidth() == secondImage.getWidth();
    }
}