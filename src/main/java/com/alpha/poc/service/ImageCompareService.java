package com.alpha.poc.service;

import java.awt.image.BufferedImage;

public interface ImageCompareService {
    boolean isSameImage(BufferedImage firstImage, BufferedImage secondImage);
}
