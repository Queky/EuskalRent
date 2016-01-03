import java.io.IOException;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Base64 {

    public static BufferedImage decodificar(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            /* Guardamos en la variable imageByte la imagen pasada a byte array */
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            /* Guardamos en la variable image la imagen */
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    public static String codificar(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            /* Guardamos en la variable imageByte la imagen convertida en un byte array */
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            /* Guardamos en la variable imageString el byte array codificado */
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static void main (String args[]) throws IOException {
        /* Guardamos en la variable img la imagen que queremos codificar */
        BufferedImage imagen = ImageIO.read(new File("/Users/Zigor/Desktop/Foto el 3-1-16 a las 14.43.jpg"));
        /* Guardamos en la variable imagenString la imagen ya codificada */
        String imagenString = codificar(imagen, "png");
        System.out.println(imagenString);
        /* Guardamos en la variable imagenDecodificada la imagen que antes hemos codificado ahora decodificada */
        BufferedImage imagenDecodificada = decodificar(imagenString);
        ImageIO.write(imagenDecodificada, "png", new File("/Users/Zigor/Desktop/Decodificada.jpg"));
    }
}