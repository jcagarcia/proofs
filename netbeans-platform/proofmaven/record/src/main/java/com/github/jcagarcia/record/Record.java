/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jcagarcia.record;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.jcodec.api.awt.AWTSequenceEncoder;
import org.netbeans.api.progress.ProgressHandle;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Cancellable;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import org.openide.util.RequestProcessor;
import org.openide.util.Task;
import org.openide.util.TaskListener;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
        category = "Tools",
        id = "com.github.jcagarcia.record.Record"
)
@ActionRegistration(
        iconBase = "com/github/jcagarcia/record/record-button9.png",
        displayName = "#CTL_Record"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 1300)
    ,
  @ActionReference(path = "Toolbars/File", position = 300)
})
@Messages("CTL_Record=Record")
public final class Record implements ActionListener {

    TimerTask timerTask;
    Timer timer;

    List<BufferedImage> images = new ArrayList<>();
    String dir = "/tmp";

    private final static RequestProcessor RP = new RequestProcessor("interruptible tasks", 200, true);
    private final static Logger LOG = Logger.getLogger(Record.class.getName());

    private RequestProcessor.Task task = null;

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (timerTask != null) {

                final ProgressHandle ph = ProgressHandle.createHandle("Executing task", new Cancellable() {
                    public boolean cancel() {
                        return handleCancel();
                    }
                });

                // Create new task
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        try {
                            
                            ph.start(); //we must start the PH before we swith to determinate
                            // Stop the task
                            timer.cancel();
                            timer.purge();
                            timerTask = null;
                            timer = null;

                            String fileName = dir + "/recorded-" + new Date().getTime() + ".mp4";
                            ph.setDisplayName("Rendering movie to " + fileName);
                            AWTSequenceEncoder enc = AWTSequenceEncoder.createSequenceEncoder(new File(fileName), 2);
                            for (BufferedImage image : images) {
                                enc.encodeImage(image);
                            }

                            enc.finish();
                            dir = "/tmp";
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                };

                task = RP.create(runnable); //the task is not started yet

                task.addTaskListener(new TaskListener() {
                    public void taskFinished(Task task) {
                        ph.finish();
                    }
                });

                task.schedule(0); //start the task

            } else {

                JFileChooser fileChooser = new JFileChooser(".") {
                    public void approveSelection() {
                        if (getSelectedFile().isFile()) {
                            return;
                        } else {
                            super.approveSelection();
                        }
                    }
                };
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int returnVal = fileChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    dir = fileChooser.getSelectedFile().getPath();
                } else {
                    return;
                }

                images = new ArrayList<>();

                timerTask = new TimerTask() {

                    int count = 0;
                    TopComponent map = WindowManager.getDefault().findTopComponent("MapTopComponent");
                    Robot robot = null;
                    int width = map.getWidth() % 2 == 0 ? map.getWidth() : map.getWidth() - 1;
                    int height = map.getHeight() % 2 == 0 ? map.getHeight() : map.getHeight() - 1;
                    double x = map.getLocationOnScreen().getX();
                    double y = map.getLocationOnScreen().getY();
                    Rectangle area = new Rectangle((int) x, (int) y, width, height);

                    public void run() {
                        try {
                            robot = new Robot();
                            BufferedImage image = robot.createScreenCapture(area);
                            images.add(image);

                            count++;
                        } catch (Exception ex) {
                            Exceptions.printStackTrace(ex);
                        }
                    }
                };

                // Start timer each 500 milliseconds
                timer = new Timer();
                timer.scheduleAtFixedRate(timerTask, 500, 500);

            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
     /**
         * Cancel the task
         *
         * @return
         */
        private boolean handleCancel() {
            LOG.info("handleCancel");
            if (null == task) {
                return false;
            }

            return task.cancel();
        }

}
