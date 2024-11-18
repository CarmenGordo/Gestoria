package modelos;
import java.awt.image.BufferedImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;

/**
 *
 * @author carmen_gordo
 */
public class CodifImagen {
    
    public static List<String> convertirImagenBase64(String carpetaRuta) {
        File carpeta = new File(carpetaRuta);
        List<String> base64Imagenes = new ArrayList<>();
        List<String> nombresImagenes = new ArrayList<>();

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            
            for (int i = 0; i < archivos.length; i++) {
                File archivo = archivos[i];
                if (archivo.isFile() && (archivo.getName().endsWith(".png") || archivo.getName().endsWith(".jpg") || archivo.getName().endsWith(".jpeg"))) {
                    try {
                        
                        BufferedImage imagenOriginal = ImageIO.read(archivo);
        
                        //error al leer img
                        if (imagenOriginal != null) {
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            String extension = archivo.getName().substring(archivo.getName().lastIndexOf('.') + 1);
                            
                            ImageIO.write(imagenOriginal, extension, baos);
                            byte[] imageBytes = baos.toByteArray();
                            String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                            base64Imagenes.add(base64Image);
                            nombresImagenes.add(archivo.getName());
                        } else {
                            System.err.println("No se pudo leer la imagen: " + archivo.getName());
                        }


                    } catch (IOException e) {
                        System.err.println("Ha habido un error con la imagen: " + archivo.getName());
                    }
                }
            }
        } else {
            System.err.println("La carpeta no existe");
        }

        for (int i = 0; i < nombresImagenes.size(); i++) {
            String nombreImagen = nombresImagenes.get(i);
            String base64 = base64Imagenes.get(i);
            System.out.println("Imagen: " + nombreImagen + "Base64: " + base64 + "\n");
        }
        
        return base64Imagenes;
    }
    
    public static void main(String[] args) {
        String rutaCarpeta = "src/main/resources/assets";
        
        List<String> base64Imagenes = convertirImagenBase64(rutaCarpeta);
    }
}
