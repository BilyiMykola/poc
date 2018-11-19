package com.alpha.poc;

import com.alpha.poc.service.impl.ImagesCompareServiceImpl;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ImageComparatorTest {

    @Test
    public void shouldSuccessfullyCompareSameImages() throws IOException {
        BufferedImage image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("google.png"));
        assertTrue(new ImagesCompareServiceImpl().isSameImage(image, image));
    }

    @Test
    public void shouldFailCompareImages() throws IOException {
        BufferedImage googleImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("google.png"));
        BufferedImage redGoogleImage = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("google_red.png"));
        assertFalse(new ImagesCompareServiceImpl().isSameImage(googleImage, redGoogleImage));
    }
}
