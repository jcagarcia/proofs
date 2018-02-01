/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.jcagarcia.proofs.netbeans.map;

import com.bbn.openmap.LayerHandler;
import com.bbn.openmap.MapBean;
import com.bbn.openmap.MapHandler;
import com.bbn.openmap.MouseDelegator;
import com.bbn.openmap.MultipleSoloMapComponentException;
import com.bbn.openmap.event.MapMouseEvent;
import com.bbn.openmap.event.MapMouseListener;
import com.bbn.openmap.event.SelectMouseMode;
import com.bbn.openmap.geo.OMGeo;
import com.bbn.openmap.gui.BasicMapPanel;
import com.bbn.openmap.gui.MapPanel;
import com.bbn.openmap.layer.shape.ShapeLayer;
import com.bbn.openmap.omGraphics.OMPoint;
import com.bbn.openmap.proj.Projection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Properties;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.api.progress.ProgressHandle;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.StatusDisplayer;
import org.openide.awt.UndoRedo;
import org.openide.util.Cancellable;
import org.openide.util.RequestProcessor;
import org.openide.util.Task;
import org.openide.util.TaskListener;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.windows.TopComponent;

@TopComponent.Description(
        preferredID = "MyMapTopComponent",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(
        mode = "editor",
        openAtStartup = true)
@ActionID(
        category = "Window",
        id = "com.github.jcagarcia.proofs.netbeans.map.MyMapTopComponent")
@ActionReferences({
    @ActionReference(
            path = "Menu/Window",
            position = 0)
})
@TopComponent.OpenActionRegistration(
        displayName = "Map")
public class MyMapTopComponent extends TopComponent {

    private final InstanceContent ic = new InstanceContent();

    //The RequestProcessor has to have allowInterrupt set to true!!
    private final static RequestProcessor RP = new RequestProcessor("interruptible tasks", 200, true);
    private final static Logger LOG = Logger.getLogger(MyMapTopComponent.class.getName());

    private RequestProcessor.Task task = null;
    
    // Undo Redo manager
    private UndoRedo.Manager manager = new UndoRedo.Manager();

    @Override
    public UndoRedo getUndoRedo() {
        return manager;
    }
    
    

    public MyMapTopComponent() {
        setDisplayName("Map");

        setLayout(new BorderLayout());
        
                
        try {

            //MapPanel:
            MapPanel mapPanel = new BasicMapPanel();

            //MapHandler:
            MapHandler mapHandler = mapPanel.getMapHandler();
            mapHandler.add(new LayerHandler());
            mapHandler.add(this);

            //MapBean:
            MapBean mapBean = mapPanel.getMapBean();
            mapBean.setScale(120000000f);

            //Selection:
            MouseDelegator mouseDelegator = new MouseDelegator();
            mapHandler.add(mouseDelegator);
            SelectMouseMode selectMouseMode = new SelectMouseMode();
            mapHandler.add(selectMouseMode);
            mouseDelegator.setActive(selectMouseMode);

            //MapMouseListener:
            final MyMapMouseListener myMapMouseListener = new MyMapMouseListener();

            //ShapeLayer:
            ShapeLayer shapeLayer = new ShapeLayer() {
                @Override
                public synchronized MapMouseListener getMapMouseListener() {
                    return myMapMouseListener;
                }
            };

            //Properties:
            Properties shapeLayerProps = new Properties();
            shapeLayerProps.put("lineColor", "000000");
            shapeLayerProps.put("fillColor", "BDDE83");
            shapeLayerProps.put("shapeFile", "com/github/jcagarcia/proofs/netbeans/map/dcwpo-browse.shp");
            shapeLayerProps.put("spatialIndex", "com/github/jcagarcia/proofs/netbeans/map/dcwpo-browse.ssx");

            //Assign properties to ShapeLayer:
            shapeLayer.setProperties(shapeLayerProps);
            shapeLayer.setVisible(true);

            //Assign ShapeLayer to MapHandler:
            mapHandler.add(shapeLayer);

            add(mapPanel.getMapBean(), BorderLayout.CENTER);
            

        } catch (MultipleSoloMapComponentException msmce) {
        }

        associateLookup(new AbstractLookup(ic));

    }

    public class MyMapMouseListener implements MapMouseListener {

        @Override
        public String[] getMouseModeServiceList() {
            return new String[]{SelectMouseMode.modeID};
        }

        @Override
        public boolean mouseClicked(MouseEvent e) {
            
            MapMouseEvent mme = (MapMouseEvent) e;           
            MapBean mb = mme.getMap();       

            Projection proj=mb.getProjection();
            OMPoint pt=new OMPoint((float)mme.getLatLon().getY(),(float)mme.getLatLon().getX());
            Graphics2D g=(Graphics2D)mb.getGraphics(true);
            g.setPaintMode();
            g.setColor(Color.RED);
            g.setBackground(Color.RED);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
            pt.generate(proj);
            pt.render(g);


            final ProgressHandle ph = ProgressHandle.createHandle("Executing task", new Cancellable() {
                public boolean cancel() {
                    return handleCancel();
                }
            });

            // Create new task
            Runnable runnable = new Runnable() {

                private final int NUM = 10000;

                @Override
                public void run() {
                    try {
                        ph.start(); //we must start the PH before we swith to determinate
                        ph.switchToDeterminate(NUM);
                        for (int i = 0; i <= NUM; i++) {
                            showInfoInPanel(i);
                            ph.progress(i);
                            Thread.sleep(0); //throws InterruptedException is the task was cancelled

                        }
                    } catch (InterruptedException ex) {
                        LOG.info("the task was CANCELLED");
                        return;

                    }

                }

                private void showInfoInPanel(int i) {
                    // Show info in the panel
                    StatusDisplayer.getDefault().setStatusText("Loop " + i);
                    return;
                }
            };

            task = RP.create(runnable); //the task is not started yet

            task.addTaskListener(new TaskListener() {
                public void taskFinished(Task task) {
                    ph.finish();
                }
            });

            task.schedule(0); //start the task

            return true;
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

        @Override
        public boolean mousePressed(MouseEvent e) {
            return true;
        }

        @Override
        public boolean mouseReleased(MouseEvent e) {
            return true;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public boolean mouseDragged(MouseEvent e) {
            return true;
        }

        @Override
        public boolean mouseMoved(MouseEvent e) {
            return true;
        }

        @Override
        public void mouseMoved() {
        }
    }

}
