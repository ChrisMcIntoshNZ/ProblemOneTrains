package KiwilandTrains;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;

public class KiwilandTrains {

	protected Shell shlKiwilandTrains;
	private Text txtGraph;
	private Text txtPath;
	private Text txtEdgesStartNode;
	private Text txtEdgesEndNode;
	private Text txtEdgesMinStops;
	private Text txtEdgesMaxStops;
	private Text txtDistStartNode;
	private Text txtDistEndNode;
	private Text txtDistUnder;
	private Text txtShortStartNode;
	private Text txtShortEndNode;
	private Graph graph = null;
	private Button btnLoadGraph;
	private Button btnGetRoutesNumStops;
	private Button btnShortGetRoute;
	private Button btnGetRoutesUnderDist;
	private Button btnGetDistance;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			KiwilandTrains window = new KiwilandTrains();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlKiwilandTrains.open();
		shlKiwilandTrains.layout();
		while (!shlKiwilandTrains.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlKiwilandTrains = new Shell();
		shlKiwilandTrains.setMinimumSize(new Point(450, 371));
		shlKiwilandTrains.setSize(450, 371);

		shlKiwilandTrains.setText("Kiwiland Trains");
		shlKiwilandTrains.setLayout(null);

		txtGraph = new Text(shlKiwilandTrains, SWT.BORDER);
		txtGraph.setBounds(81, 12, 262, 21);

		Label lblGraph = new Label(shlKiwilandTrains, SWT.NONE);
		lblGraph.setBounds(40, 15, 35, 15);
		lblGraph.setAlignment(SWT.RIGHT);
		lblGraph.setText("Graph:");

		btnLoadGraph = new Button(shlKiwilandTrains, SWT.NONE);

		btnLoadGraph.setBounds(349, 10, 75, 25);
		btnLoadGraph.setText("Load Graph");

		txtPath = new Text(shlKiwilandTrains, SWT.BORDER);
		txtPath.setEnabled(false);
		txtPath.setBounds(81, 64, 262, 21);

		Label lblNewLabel = new Label(shlKiwilandTrains, SWT.NONE);
		lblNewLabel.setBounds(40, 67, 35, 15);
		lblNewLabel.setAlignment(SWT.RIGHT);
		lblNewLabel.setText("Path:");

		btnGetDistance = new Button(shlKiwilandTrains, SWT.NONE);

		btnGetDistance.setEnabled(false);
		btnGetDistance.setBounds(349, 62, 75, 25);
		btnGetDistance.setText("Get Distance");

		txtEdgesStartNode = new Text(shlKiwilandTrains, SWT.BORDER);
		txtEdgesStartNode.setEnabled(false);
		txtEdgesStartNode.setBounds(81, 114, 35, 21);

		Label lblEdgesStartNode = new Label(shlKiwilandTrains, SWT.NONE);
		lblEdgesStartNode.setBounds(3, 117, 72, 15);
		lblEdgesStartNode.setAlignment(SWT.RIGHT);
		lblEdgesStartNode.setText("Start Node:");

		Label lblEndNode = new Label(shlKiwilandTrains, SWT.NONE);
		lblEndNode.setBounds(3, 144, 72, 15);
		lblEndNode.setText("End Node:");
		lblEndNode.setAlignment(SWT.RIGHT);

		txtEdgesEndNode = new Text(shlKiwilandTrains, SWT.BORDER);
		txtEdgesEndNode.setEnabled(false);
		txtEdgesEndNode.setBounds(81, 141, 35, 21);

		Label lblMinStops = new Label(shlKiwilandTrains, SWT.NONE);
		lblMinStops.setBounds(134, 117, 72, 15);
		lblMinStops.setText("Min Stops:");
		lblMinStops.setAlignment(SWT.RIGHT);

		txtEdgesMinStops = new Text(shlKiwilandTrains, SWT.BORDER);
		txtEdgesMinStops.setEnabled(false);
		txtEdgesMinStops.setBounds(212, 114, 35, 21);

		txtEdgesMaxStops = new Text(shlKiwilandTrains, SWT.BORDER);
		txtEdgesMaxStops.setEnabled(false);
		txtEdgesMaxStops.setBounds(212, 141, 35, 21);

		Label lblMaxStops = new Label(shlKiwilandTrains, SWT.NONE);
		lblMaxStops.setBounds(122, 144, 84, 15);
		lblMaxStops.setText("Max Stops:");
		lblMaxStops.setAlignment(SWT.RIGHT);

		btnGetRoutesNumStops = new Button(shlKiwilandTrains, SWT.NONE);

		btnGetRoutesNumStops.setEnabled(false);
		btnGetRoutesNumStops.setBounds(286, 123, 138, 25);
		btnGetRoutesNumStops.setText("Get Number of Routes");

		Label label = new Label(shlKiwilandTrains, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 46, 440, 2);

		Label label_1 = new Label(shlKiwilandTrains, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 103, 440, 2);

		Label label_2 = new Label(shlKiwilandTrains, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(0, 179, 440, 2);

		Label label_3 = new Label(shlKiwilandTrains, SWT.NONE);
		label_3.setBounds(3, 200, 72, 15);
		label_3.setText("Start Node:");
		label_3.setAlignment(SWT.RIGHT);

		Label label_4 = new Label(shlKiwilandTrains, SWT.NONE);
		label_4.setBounds(134, 200, 72, 15);
		label_4.setText("End Node:");
		label_4.setAlignment(SWT.RIGHT);

		txtDistStartNode = new Text(shlKiwilandTrains, SWT.BORDER);
		txtDistStartNode.setEnabled(false);
		txtDistStartNode.setBounds(81, 197, 35, 21);

		txtDistEndNode = new Text(shlKiwilandTrains, SWT.BORDER);
		txtDistEndNode.setEnabled(false);
		txtDistEndNode.setBounds(212, 197, 35, 21);

		Label lblUnderDistance = new Label(shlKiwilandTrains, SWT.NONE);
		lblUnderDistance.setBounds(117, 227, 89, 15);
		lblUnderDistance.setAlignment(SWT.RIGHT);
		lblUnderDistance.setText("Under Distance:");

		txtDistUnder = new Text(shlKiwilandTrains, SWT.BORDER);
		txtDistUnder.setEnabled(false);
		txtDistUnder.setBounds(212, 224, 35, 21);

		btnGetRoutesUnderDist = new Button(shlKiwilandTrains, SWT.NONE);
		btnGetRoutesUnderDist.setEnabled(false);
		btnGetRoutesUnderDist.setBounds(286, 200, 138, 25);
		btnGetRoutesUnderDist.setText("Get Number of Routes");

		Label label_5 = new Label(shlKiwilandTrains, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_5.setBounds(3, 261, 440, 2);

		Label label_6 = new Label(shlKiwilandTrains, SWT.NONE);
		label_6.setBounds(3, 279, 72, 15);
		label_6.setText("Start Node:");
		label_6.setAlignment(SWT.RIGHT);

		Label label_7 = new Label(shlKiwilandTrains, SWT.NONE);
		label_7.setBounds(3, 303, 72, 15);
		label_7.setText("End Node:");
		label_7.setAlignment(SWT.RIGHT);

		txtShortStartNode = new Text(shlKiwilandTrains, SWT.BORDER);
		txtShortStartNode.setEnabled(false);
		txtShortStartNode.setBounds(81, 273, 35, 21);

		txtShortEndNode = new Text(shlKiwilandTrains, SWT.BORDER);
		txtShortEndNode.setEnabled(false);
		txtShortEndNode.setBounds(81, 300, 35, 21);

		btnShortGetRoute = new Button(shlKiwilandTrains, SWT.NONE);

		btnShortGetRoute.setEnabled(false);
		btnShortGetRoute.setBounds(261, 286, 163, 25);
		btnShortGetRoute.setText("Get Shortest Route Lenght");

		btnLoadGraph.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if (graph == null) {
					try {
						graph = new Graph(txtGraph.getText());
						toggleControls(true);
						btnLoadGraph.setText("Edit Graph");
					} catch (Exception ex) {
						MessageBox m = new MessageBox(shlKiwilandTrains);
						m.setMessage("Invalid Graph");
						m.open();
					}
				} else {
					graph = null;
					toggleControls(false);
					btnLoadGraph.setText("Load Graph");
				}

			}
		});

		btnGetDistance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					int distance;
					String message;
					distance = graph.getDistance(txtPath.getText());
					message = (distance == -1) ? "NO SUCH ROUTE"
							: "The Lenght of the path " + txtPath.getText() + " is " + distance;
					MessageBox m = new MessageBox(shlKiwilandTrains);
					m.setMessage(message);
					m.open();
				} catch (Exception ex) {
					MessageBox m = new MessageBox(shlKiwilandTrains);
					m.setMessage("Invalid Path");
					m.open();
				}
			}
		});

		btnGetRoutesNumStops.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				MessageBox m = new MessageBox(shlKiwilandTrains);

				String startNode = txtEdgesStartNode.getText();
				if (startNode.length() != 1) {
					m.setMessage("Invalid Start Node");
					m.open();
					return;
				}
				String endNode = txtEdgesEndNode.getText();
				if (endNode.length() != 1) {
					m.setMessage("Invalid End Node");
					m.open();
					return;
				}
				int minStops;
				if (txtEdgesMinStops.getText().matches("-?(0|[1-9]\\d*)")) {
					minStops = Integer.parseInt(txtEdgesMinStops.getText());
				} else {
					m.setMessage("Invalid Min Stops");
					m.open();
					return;
				}
				int maxStops;
				if (txtEdgesMaxStops.getText().matches("-?(0|[1-9]\\d*)")) {
					maxStops = Integer.parseInt(txtEdgesMaxStops.getText());
				} else {
					m.setMessage("Invalid Min Stops");
					m.open();
					return;
				}

				int numTrips = graph.getNumTrips(startNode, endNode, minStops, maxStops);

				m.setMessage(numTrips + " Trip(s)");
				m.open();

			}
		});

		btnGetRoutesUnderDist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				MessageBox m = new MessageBox(shlKiwilandTrains);

				String startNode = txtDistStartNode.getText();
				if (startNode.length() != 1) {
					m.setMessage("Invalid Start Node");
					m.open();
					return;
				}
				String endNode = txtDistEndNode.getText();
				if (endNode.length() != 1) {
					m.setMessage("Invalid End Node");
					m.open();
					return;
				}
				int dist;
				if (txtDistUnder.getText().matches("-?(0|[1-9]\\d*)")) {
					dist = Integer.parseInt(txtDistUnder.getText());
				} else {
					m.setMessage("Invalid Distance");
					m.open();
					return;
				}
				int numTrips = graph.getTripsUnderDistance(startNode, endNode, dist);
				m.setMessage(numTrips + " Trip(s)");
				m.open();

			}
		});

		btnShortGetRoute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				MessageBox m = new MessageBox(shlKiwilandTrains);

				String startNode = txtShortStartNode.getText();
				if (startNode.length() != 1) {
					m.setMessage("Invalid Start Node");
					m.open();
					return;
				}
				String endNode = txtShortEndNode.getText();
				if (endNode.length() != 1) {
					m.setMessage("Invalid End Node");
					m.open();
					return;
				}
				int dist = graph.getShortestRoute(startNode, endNode);
				String message = dist > 0
						? "The shortest route from " + startNode + " to " + endNode + " is " + dist + " long."
						: "NO SUCH ROUTE";
				m.setMessage(message);
				m.open();
			}

		});

	}

	private void toggleControls(boolean enabled) {
		txtPath.setEnabled(enabled);
		btnGetDistance.setEnabled(enabled);
		txtEdgesStartNode.setEnabled(enabled);
		txtEdgesEndNode.setEnabled(enabled);
		txtEdgesMinStops.setEnabled(enabled);
		txtEdgesMaxStops.setEnabled(enabled);
		btnGetRoutesNumStops.setEnabled(enabled);
		txtDistStartNode.setEnabled(enabled);
		txtDistEndNode.setEnabled(enabled);
		txtDistUnder.setEnabled(enabled);
		btnGetRoutesUnderDist.setEnabled(enabled);
		txtShortStartNode.setEnabled(enabled);
		txtShortEndNode.setEnabled(enabled);
		btnShortGetRoute.setEnabled(enabled);
		txtGraph.setEditable(!enabled);
	}
}
