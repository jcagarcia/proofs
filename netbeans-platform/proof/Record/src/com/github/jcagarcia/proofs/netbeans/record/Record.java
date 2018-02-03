/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jcagarcia.proofs.netbeans.record;

import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.xuggler.ICodec;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import sun.nio.ch.IOUtil;

@ActionID(
        category = "Tools",
        id = "com.github.jcagarcia.proofs.netbeans.record.Record"
)
@ActionRegistration(
        iconBase = "com/github/jcagarcia/proofs/netbeans/record/record-button9.png",
        displayName = "#CTL_Record"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 1300)
    ,
  @ActionReference(path = "Toolbars/File", position = 300)
})
@Messages("CTL_Record=Record")
public final class Record implements ActionListener {

    private static final double FRAME_RATE = 50;

    private static final int SECONDS_TO_RUN_FOR = 20;

    private static final String outputFilename = "/tmp/mydesktop.mp4";

    private static Dimension screenBounds;

    @Override
    public void actionPerformed(ActionEvent e) {

        TopComponent map = WindowManager.getDefault().findTopComponent("MyMapTopComponent");

        try {
            Robot robot = new Robot();
            double x = map.getAlignmentX();
            double y = map.getAlignmentY();
            int width = map.getWidth();
            int height = map.getHeight();
            Rectangle area = new Rectangle((int) x, (int) y, width, height);

            // let's make a IMediaWriter to write the file.
            final IMediaWriter writer = ToolFactory.makeWriter(outputFilename);

            screenBounds = Toolkit.getDefaultToolkit().getScreenSize();

            // We tell it we're going to add one video stream, with id 0,
            // at position 0, and that it will have a fixed frame rate of FRAME_RATE.
            writer.addVideoStream(0, 0, ICodec.ID.CODEC_ID_MPEG4,
                    screenBounds.width / 2, screenBounds.height / 2);

            long startTime = System.nanoTime();

            for (int index = 0; index < SECONDS_TO_RUN_FOR * FRAME_RATE; index++) {

                // take the screen shot
                BufferedImage screen = getDesktopScreenshot();

                // convert to the right image type
                BufferedImage bgrScreen = convertToType(screen, BufferedImage.TYPE_3BYTE_BGR);

                // encode the image to stream #0
                writer.encodeVideo(0, bgrScreen, System.nanoTime() - startTime, TimeUnit.NANOSECONDS);

                // sleep for frame rate milliseconds
                Thread.sleep((long) (1000 / FRAME_RATE));

            }
            
            // tell the writer to close and write the trailer if  needed
            writer.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    

    

    public static BufferedImage convertToType(BufferedImage sourceImage, int targetType) {

        BufferedImage image;

        // if the source image is already the target type, return the source image
        if (sourceImage.getType() == targetType) {

            image = sourceImage;

        } // otherwise create a new image of the target type and draw the new image
        else {

            image = new BufferedImage(sourceImage.getWidth(),
                    sourceImage.getHeight(), targetType);

            image.getGraphics().drawImage(sourceImage, 0, 0, null);

        }

        return image;

    }

    private static BufferedImage getDesktopScreenshot() {

        try {

            Robot robot = new Robot();

            Rectangle captureSize = new Rectangle(screenBounds);

            return robot.createScreenCapture(captureSize);

        } catch (AWTException e) {

            e.printStackTrace();

            return null;

        }

    }

}
