package InterfacesGraficas;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.geometry.ColorCube;
import javax.media.j3d.BranchGroup;

public class Java3DExample {

    public Java3DExample() {
        // Crear el universo 3D
        SimpleUniverse universe = new SimpleUniverse();

        // Crear la esfera
        BranchGroup group = createSceneGraph();
        universe.addBranchGraph(group);

        // Configurar la visualización del universo
        universe.getViewingPlatform().setNominalViewingTransform();

        // Configurar la ventana de visualización
        universe.getViewer().getView().setBackClipDistance(100.0);

        // Mostrar la ventana
        javax.swing.JFrame frame = new javax.swing.JFrame("Java 3D Example");
        frame.getContentPane().add(universe.getCanvas());
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private BranchGroup createSceneGraph() {
        // Crear un BranchGroup (grupo de nodos)
        BranchGroup group = new BranchGroup();

        // Añadir una esfera al grupo
        group.addChild(new ColorCube(0.3));

        return group;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Java3DExample();
            }
        });
    }
}
