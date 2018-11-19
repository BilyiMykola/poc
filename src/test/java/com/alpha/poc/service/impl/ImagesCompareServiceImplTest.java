package com.alpha.poc.service.impl;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ImagesCompareServiceImplTest {

    private static final String IMAGE_GOOGLE = "google.png";
    private static final String RED_IMAGE_GOOGLE = "google_red.png";

    @Test
    public void shouldSuccessfullyCompareImages() {
        BufferedImage image = loadBufferedImage(IMAGE_GOOGLE);
        assertTrue(new ImageCompareServiceImpl().isSameImage(image, image));
    }

    @Test
    public void shouldFailCompareImages() {
        BufferedImage googleImage = loadBufferedImage(IMAGE_GOOGLE);
        BufferedImage redGoogleImage = loadBufferedImage(RED_IMAGE_GOOGLE);
        assertFalse(new ImageCompareServiceImpl().isSameImage(googleImage, redGoogleImage));
    }

    private BufferedImage loadBufferedImage(String image) {
        try {
            return ImageIO.read(
                    this.getClass().getClassLoader().getResourceAsStream(image));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
