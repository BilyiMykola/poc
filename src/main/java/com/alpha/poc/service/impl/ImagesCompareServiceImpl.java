package com.alpha.poc;

import java.awt.image.BufferedImage;

public class ImageComparator {

    public boolean isSameImage(BufferedImage previousImage, BufferedImage currentImage) {
        if (previousImage.getHeight() != currentImage.getHeight() ||
            previousImage.getWidth() != currentImage.getWidth()) {
            return false;
        }

        for (int heightIndex = 0; heightIndex < previousImage.getHeight(); heightIndex++) {
            for (int widthIndex = 0; widthIndex < previousImage.getWidth(); widthIndex++) {
                int rgb1 = previousImage.getRGB(widthIndex, heightIndex);

                int r1 = (rgb1 >> 16) & 0xff;
                int g1 = (rgb1 >> 8) & 0xff;
                int b1 = rgb1 & 0xff;

                int rgb2 = currentImage.getRGB(widthIndex, heightIndex);

                int r2 = (rgb2 >> 16) & 0xff;
                int g2 = (rgb2 >> 8) & 0xff;
                int b2 = rgb2 & 0xff;

                if (r1 != r2 || g1 != g2 || b1 != b2) {
                    return false;
                }
            }
        }

        return true;
    }
}
