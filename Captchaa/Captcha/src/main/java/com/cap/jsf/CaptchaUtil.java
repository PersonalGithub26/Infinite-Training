package com.cap.jsf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

import javax.imageio.ImageIO;

public class CaptchaUtil {
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final int WIDTH = 200;
    private static final int HEIGHT = 50;
    private static final int FONT_SIZE = 30;
    private static final int CHARACTERS_TO_SHOW = 5;
    

    public static String generateCaptchaImage() {
        StringBuilder captcha = new StringBuilder();

        // Create a new image
        BufferedImage captchaImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = captchaImage.createGraphics();

        // Set the background color
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Set the font and color for the captcha text
        g.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        g.setColor(Color.BLACK);

        // Generate random characters and draw them on the image
        Random random = new Random();
        for (int i = 0; i < CHARACTERS_TO_SHOW; i++) {
            char character = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
            captcha.append(character);
            int x = 20 + i * 30;
            int y = 35 + random.nextInt(15);
            g.drawString(Character.toString(character), x, y);
        }

        // Add noise to the image
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            g.fillOval(x, y, 2, 2);
        }

        StringBuilder imageString = new StringBuilder();
        imageString.append("data:image/png;base64,");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(captchaImage, "png", baos);
            byte[] bytes = baos.toByteArray();
            imageString.append(Base64.getEncoder().encodeToString(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageString.toString();
    }


}
