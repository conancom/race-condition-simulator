package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

	@FXML
	TextField addValue;
	@FXML
	TextField subValue;
	@FXML
	TextField mulValue;
	@FXML
	TextField divValue;
	@FXML
	Button execAddButton;
	@FXML
	Button execSubButton;
	@FXML
	Button execMulButton;
	@FXML
	Button execDivButton;
	@FXML
	Button lockAddButton;
	@FXML
	Button lockSubButton;
	@FXML
	Button lockMulButton;
	@FXML
	Button lockDivButton;
	@FXML
	Button unlockAddButton;
	@FXML
	Button unlockSubButton;
	@FXML
	Button unlockMulButton;
	@FXML
	Button unlockDivButton;
	@FXML
	Text queueTextField;
	@FXML
	Text aluOpertationText;
	@FXML
	Text topStackValueText;
	@FXML
	Text aluTopStackValueText;
	@FXML
	Text aluSolutionValueText;
	@FXML
	Text p1StatusText;
	@FXML
	Text p2StatusText;
	@FXML
	Text p3StatusText;
	@FXML
	Text p4StatusText;
	@FXML
	ImageView arrowImageView;
	@FXML
	QuadCurve curve;
	@FXML
	Line line1;
	@FXML
	Line line2;
	@FXML
	QuadCurve curveun;
	@FXML
	Line line1un;
	@FXML
	Line line2un;
	@FXML
	Text petersonText;
	@FXML
	Text spinlockText;
	@FXML
	MenuItem petersonItem;
	@FXML
	MenuItem spinlockItem;

	@FXML
	Line queue1;
	@FXML
	Line queue2;
	@FXML
	Line queue3;

	@FXML
	QuadCurve dequeue1;
	@FXML
	Line dequeue2;
	@FXML
	Line dequeue3;

	@FXML
	MenuItem unprotectedItem;

	@FXML
	MenuItem protectedItem;

	String lockPeterson = "lock(for Process i):\n" + "	for(count = 0; count < (NUMPROCS-1); count++):\n"
			+ "       		flags[i] = count;\n" + "      		turn[count] = i \n"
			+ "     		wait until (for all k != i, flag[k] < count)\n" + "			or (turn[count] != i);\n";

	String unlockPeterson = "unlock(for Process i):\n" + "	flags[i] = -1\n";

	String spinlock =

			"public class SpinLock {\n" + "\n"
					+ "	private AtomicReferencec<Thread> owner = new AtomicReference<Thread>();\n" + "\n"
					+ "	public void lock() {\n" + "		Thread thread = Thread.currentThread();\n"
					+ "		while (!owner.compareAndSet(null, thread)) {\n" + "		}\n" + "	}\n" + "\n"
					+ "	public void unlock() {\n" + "		Thread thread = Thread.currentThread();\n"
					+ "		owner.compareAndSet(thread, null);\n" + "		}\n" + "}\n";

	@FXML
	Line queueuLine1;
	@FXML
	Line queueuLine2;
	@FXML
	Text queuewaitingText;

	@FXML
	QuadCurve addcurve;
	@FXML
	Line addLine1;
	@FXML
	Line addLine2;

	@FXML
	QuadCurve subcurve;
	@FXML
	Line subLine1;
	@FXML
	Line subLine2;

	@FXML
	QuadCurve mulcurve;
	@FXML
	Line mulLine1;
	@FXML
	Line mulLine2;

	@FXML
	QuadCurve divcurve;
	@FXML
	Line divLine1;
	@FXML
	Line divLine2;

	@FXML
	Text p1ReadValueText;
	@FXML
	Text p2ReadValueText;
	@FXML
	Text p3ReadValueText;
	@FXML
	Text p4ReadValueText;

	boolean prot = true;
	boolean error = false;

	FadeTransition transitioncurve = new FadeTransition(Duration.millis(500));
	FadeTransition transitionline1 = new FadeTransition(Duration.millis(500));
	FadeTransition transitionline2 = new FadeTransition(Duration.millis(500));

	FadeTransition transitioncurveout = new FadeTransition(Duration.millis(1000));
	FadeTransition transitionline1out = new FadeTransition(Duration.millis(1000));
	FadeTransition transitionline2out = new FadeTransition(Duration.millis(1000));

	FadeTransition transitioncurveun = new FadeTransition(Duration.millis(1000));
	FadeTransition transitionline1un = new FadeTransition(Duration.millis(1000));
	FadeTransition transitionline2un = new FadeTransition(Duration.millis(1000));

	FadeTransition transitioncurveoutun = new FadeTransition(Duration.millis(1000));
	FadeTransition transitionline1outun = new FadeTransition(Duration.millis(1000));
	FadeTransition transitionline2outun = new FadeTransition(Duration.millis(1000));

	FadeTransition transitionqueue1 = new FadeTransition(Duration.millis(500));
	FadeTransition transitionqueue2 = new FadeTransition(Duration.millis(500));
	FadeTransition transitionqueue3 = new FadeTransition(Duration.millis(500));

	FadeTransition transitionqueue1out = new FadeTransition(Duration.millis(500));
	FadeTransition transitionqueue2out = new FadeTransition(Duration.millis(500));
	FadeTransition transitionqueue3out = new FadeTransition(Duration.millis(500));

	FadeTransition transitiondequeue1 = new FadeTransition(Duration.millis(500));
	FadeTransition transitiondequeue2 = new FadeTransition(Duration.millis(500));
	FadeTransition transitiondequeue3 = new FadeTransition(Duration.millis(500));

	FadeTransition addTransition1 = new FadeTransition(Duration.millis(500));
	FadeTransition addTransition2 = new FadeTransition(Duration.millis(500));
	FadeTransition addTransition3 = new FadeTransition(Duration.millis(500));

	FadeTransition subTransition1 = new FadeTransition(Duration.millis(500));
	FadeTransition subTransition2 = new FadeTransition(Duration.millis(500));
	FadeTransition subTransition3 = new FadeTransition(Duration.millis(500));

	FadeTransition mulTransition1 = new FadeTransition(Duration.millis(500));
	FadeTransition mulTransition2 = new FadeTransition(Duration.millis(500));
	FadeTransition mulTransition3 = new FadeTransition(Duration.millis(500));

	FadeTransition divTransition1 = new FadeTransition(Duration.millis(500));
	FadeTransition divTransition2 = new FadeTransition(Duration.millis(500));
	FadeTransition divTransition3 = new FadeTransition(Duration.millis(500));

	ParallelTransition parallelTransitionIn = new ParallelTransition(transitioncurve, transitionline1, transitionline2);
	ParallelTransition parallelTransitionOut = new ParallelTransition(transitioncurveout, transitionline1out,
			transitionline2out);

	ParallelTransition parallelTransitionInun = new ParallelTransition(transitioncurveun, transitionline1un,
			transitionline2un);
	ParallelTransition parallelTransitionOutun = new ParallelTransition(transitioncurveoutun, transitionline1outun,
			transitionline2outun);

	ParallelTransition queueParallelTransition = new ParallelTransition(transitionqueue1, transitionqueue2,
			transitionqueue3);

	ParallelTransition dequeueParallelTransition = new ParallelTransition(transitiondequeue1, transitiondequeue2,
			transitiondequeue3);

	ParallelTransition addParallelTransition = new ParallelTransition(addTransition1, addTransition2, addTransition3);
	ParallelTransition subParallelTransition = new ParallelTransition(subTransition1, subTransition2, subTransition3);
	ParallelTransition mulParallelTransition = new ParallelTransition(mulTransition1, mulTransition2, mulTransition3);
	ParallelTransition divParallelTransition = new ParallelTransition(divTransition1, divTransition2, divTransition3);

	String arrayButtonExecNames[] = { "execAddButton", "execSubButton", "execMulButton", "execDivButton" };
	String arrayButtonLockNames[] = { "lockAddButton", "lockSubButton", "lockMulButton", "lockDivButton" };
	String arrayButtonUnlockcNames[] = { "unlockAddButton", "unlockSubButton", "unlockMulButton", "unlockDivButton" };
	Button arrayButtonExec[] = { execAddButton, execSubButton, execMulButton, execDivButton };
	Button arrayButtonLock[] = { lockAddButton, lockSubButton, lockMulButton, execDivButton };
	Button arrayButtonUnlock[] = { unlockAddButton, unlockSubButton, unlockMulButton, unlockDivButton };

	Boolean inExec = false;
	String textQueue = "";
	Button queue[] = new Button[4];
	Integer operationInteger;
	Integer answer;
	int p1topqueuenum;
	int p2topqueuenum;
	int p3topqueuenum;
	int p4topqueuenum;

	private Stage petersonStage;
	private Stage spinLockStage;

	public void initialize() {
		// Fade in
		transitioncurve.setNode(curve);

		transitioncurve.setFromValue(0.0);
		transitioncurve.setToValue(1.0);
		transitioncurve.setCycleCount(2);
		transitioncurve.setAutoReverse(true);

		transitionline1.setNode(line1);

		transitionline1.setFromValue(0.0);
		transitionline1.setToValue(1.0);
		transitionline1.setCycleCount(2);
		transitionline1.setAutoReverse(true);

		transitionline2.setNode(line2);

		transitionline2.setFromValue(0.0);
		transitionline2.setToValue(1.0);
		transitionline2.setCycleCount(2);
		transitionline2.setAutoReverse(true);

		// Fade Out
		transitioncurveout.setNode(curve);

		transitioncurveout.setFromValue(1.0);
		transitioncurveout.setToValue(0.0);
		transitioncurveout.setCycleCount(1);
		transitioncurveout.setAutoReverse(false);

		transitionline1out.setNode(line1);

		transitionline1out.setFromValue(1.0);
		transitionline1out.setToValue(0.0);
		transitionline1out.setCycleCount(1);
		transitionline1out.setAutoReverse(false);

		transitionline2out.setNode(line2);

		transitionline2out.setFromValue(1.0);
		transitionline2out.setToValue(0.0);
		transitionline2out.setCycleCount(1);
		transitionline2out.setAutoReverse(false);

		// Fade in
		transitioncurveun.setNode(curveun);

		transitioncurveun.setFromValue(0.0);
		transitioncurveun.setToValue(1.0);
		transitioncurveun.setCycleCount(1);
		transitioncurveun.setAutoReverse(false);

		transitionline1un.setNode(line1un);

		transitionline1un.setFromValue(0.0);
		transitionline1un.setToValue(1.0);
		transitionline1un.setCycleCount(1);
		transitionline1un.setAutoReverse(false);

		transitionline2un.setNode(line2un);

		transitionline2un.setFromValue(0.0);
		transitionline2un.setToValue(1.0);
		transitionline2un.setCycleCount(1);
		transitionline2un.setAutoReverse(false);

		// Fade Out
		transitioncurveoutun.setNode(curveun);

		transitioncurveoutun.setFromValue(1.0);
		transitioncurveoutun.setToValue(0.0);
		transitioncurveoutun.setCycleCount(1);
		transitioncurveoutun.setAutoReverse(false);

		transitionline1outun.setNode(line1un);

		transitionline1outun.setFromValue(1.0);
		transitionline1outun.setToValue(0.0);
		transitionline1outun.setCycleCount(1);
		transitionline1outun.setAutoReverse(false);

		transitionline2outun.setNode(line2un);

		transitionline2outun.setFromValue(1.0);
		transitionline2outun.setToValue(0.0);
		transitionline2outun.setCycleCount(1);
		transitionline2outun.setAutoReverse(false);

		// Fade in and out
		transitionqueue1.setNode(queue1);

		transitionqueue1.setFromValue(0.0);
		transitionqueue1.setToValue(1.0);
		transitionqueue1.setCycleCount(2);
		transitionqueue1.setAutoReverse(true);

		transitionqueue2.setNode(queue2);

		transitionqueue2.setFromValue(0.0);
		transitionqueue2.setToValue(1.0);
		transitionqueue2.setCycleCount(2);
		transitionqueue2.setAutoReverse(true);

		transitionqueue3.setNode(queue3);

		transitionqueue3.setFromValue(0.0);
		transitionqueue3.setToValue(1.0);
		transitionqueue3.setCycleCount(2);
		transitionqueue3.setAutoReverse(true);

		// Fade in and Out
		transitiondequeue1.setNode(dequeue1);

		transitiondequeue1.setFromValue(0.0);
		transitiondequeue1.setToValue(1.0);
		transitiondequeue1.setCycleCount(2);
		transitiondequeue1.setAutoReverse(true);

		transitiondequeue2.setNode(dequeue2);

		transitiondequeue2.setFromValue(0.0);
		transitiondequeue2.setToValue(1.0);
		transitiondequeue2.setCycleCount(2);
		transitiondequeue2.setAutoReverse(true);

		transitiondequeue3.setNode(dequeue3);

		transitiondequeue3.setFromValue(0.0);
		transitiondequeue3.setToValue(1.0);
		transitiondequeue3.setCycleCount(2);
		transitiondequeue3.setAutoReverse(true);

		// Fade in and Out
		addTransition1.setNode(addcurve);

		addTransition1.setFromValue(0.0);
		addTransition1.setToValue(1.0);
		addTransition1.setCycleCount(2);
		addTransition1.setAutoReverse(true);

		addTransition2.setNode(addLine1);

		addTransition2.setFromValue(0.0);
		addTransition2.setToValue(1.0);
		addTransition2.setCycleCount(2);
		addTransition2.setAutoReverse(true);

		addTransition3.setNode(addLine2);

		addTransition3.setFromValue(0.0);
		addTransition3.setToValue(1.0);
		addTransition3.setCycleCount(2);
		addTransition3.setAutoReverse(true);

		// Fade in and Out
		subTransition1.setNode(subcurve);

		subTransition1.setFromValue(0.0);
		subTransition1.setToValue(1.0);
		subTransition1.setCycleCount(2);
		subTransition1.setAutoReverse(true);

		subTransition2.setNode(subLine1);

		subTransition2.setFromValue(0.0);
		subTransition2.setToValue(1.0);
		subTransition2.setCycleCount(2);
		subTransition2.setAutoReverse(true);

		subTransition3.setNode(subLine2);

		subTransition3.setFromValue(0.0);
		subTransition3.setToValue(1.0);
		subTransition3.setCycleCount(2);
		subTransition3.setAutoReverse(true);

		// Fade in and Out
		mulTransition1.setNode(mulcurve);

		mulTransition1.setFromValue(0.0);
		mulTransition1.setToValue(1.0);
		mulTransition1.setCycleCount(2);
		mulTransition1.setAutoReverse(true);

		mulTransition2.setNode(mulLine1);

		mulTransition2.setFromValue(0.0);
		mulTransition2.setToValue(1.0);
		mulTransition2.setCycleCount(2);
		mulTransition2.setAutoReverse(true);

		mulTransition3.setNode(mulLine2);

		mulTransition3.setFromValue(0.0);
		mulTransition3.setToValue(1.0);
		mulTransition3.setCycleCount(2);
		mulTransition3.setAutoReverse(true);

		// Fade in and Out
		divTransition1.setNode(divcurve);

		divTransition1.setFromValue(0.0);
		divTransition1.setToValue(1.0);
		divTransition1.setCycleCount(2);
		divTransition1.setAutoReverse(true);

		divTransition2.setNode(divLine1);

		divTransition2.setFromValue(0.0);
		divTransition2.setToValue(1.0);
		divTransition2.setCycleCount(2);
		divTransition2.setAutoReverse(true);

		divTransition3.setNode(divLine2);

		divTransition3.setFromValue(0.0);
		divTransition3.setToValue(1.0);
		divTransition3.setCycleCount(2);
		divTransition3.setAutoReverse(true);
	}

	public void lockAddButton(ActionEvent e) {
		if (prot) {
			System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);
			lockAddButton.setDisable(true);
			if (!inExec) {
				inExec = true;
				execAddButton.setDisable(false);
				p1StatusText.setText("Status : Ready in Critical Section");

			} else {
				queue1.setVisible(true);
				queue2.setVisible(true);
				queue3.setVisible(true);
				queueParallelTransition.playFromStart();
				queueTextField.setText("P1   " + queueTextField.getText());
				p1StatusText.setText("Status : Waiting in Queue");
				for (int j = 0; j < queue.length; j++) {
					if (queue[j] == null) {
						queue[j] = execAddButton;
						break;
					}
				}
			}
		} else {

			addcurve.setVisible(true);
			addLine1.setVisible(true);
			addLine2.setVisible(true);

			addParallelTransition.playFromStart();

			lockAddButton.setDisable(true);
			p1topqueuenum = Integer.parseInt(topStackValueText.getText().substring(18));
			p1ReadValueText.setText("Read Value : " + p1topqueuenum);
			execAddButton.setDisable(false);
			p1StatusText.setText("Status : Ready to execute");

		}

	}

	public void lockSubButton(ActionEvent e) {

		if (prot) {
			System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);
			lockSubButton.setDisable(true);
			if (!inExec) {
				inExec = true;
				execSubButton.setDisable(false);
				p2StatusText.setText("Status : Ready in Critical Section");

			} else {
				queue1.setVisible(true);
				queue2.setVisible(true);
				queue3.setVisible(true);
				queueParallelTransition.playFromStart();
				queueTextField.setText("P2   " + queueTextField.getText());
				p2StatusText.setText("Status : Waiting in Queue");
				for (int j = 0; j < queue.length; j++) {
					if (queue[j] == null) {
						queue[j] = execSubButton;
						break;
					}
				}
			}

		} else {

			subcurve.setVisible(true);
			subLine1.setVisible(true);
			subLine2.setVisible(true);

			subParallelTransition.playFromStart();

			lockSubButton.setDisable(true);
			p2topqueuenum = Integer.parseInt(topStackValueText.getText().substring(18));
			p2ReadValueText.setText("Read Value : " + p2topqueuenum);
			execSubButton.setDisable(false);
			p2StatusText.setText("Status : Ready to execute");

		}
	}

	public void lockMulButton(ActionEvent e) {
		if (prot) {
			System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);
			lockMulButton.setDisable(true);
			if (!inExec) {
				inExec = true;
				execMulButton.setDisable(false);
				p3StatusText.setText("Status : Ready in Critical Section");

			} else {
				queue1.setVisible(true);
				queue2.setVisible(true);
				queue3.setVisible(true);
				queueParallelTransition.playFromStart();
				queueTextField.setText("P3   " + queueTextField.getText());
				p3StatusText.setText("Status : Waiting in Queue");
				for (int j = 0; j < queue.length; j++) {
					if (queue[j] == null) {
						queue[j] = execMulButton;
						break;
					}
				}
			}
		} else {
			
			mulcurve.setVisible(true);
			mulLine1.setVisible(true);
			mulLine2.setVisible(true);

			mulParallelTransition.playFromStart();
			lockMulButton.setDisable(true);
			p3topqueuenum = Integer.parseInt(topStackValueText.getText().substring(18));
			p3ReadValueText.setText("Read Value : " + p3topqueuenum);
			execMulButton.setDisable(false);
			p3StatusText.setText("Status : Ready to execute");

		}
	}

	public void lockDivButton(ActionEvent e) {
		if (prot) {
			System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);
			lockDivButton.setDisable(true);
			if (!inExec) {
				inExec = true;
				execDivButton.setDisable(false);
				p4StatusText.setText("Status : Ready in Critical Section");

			} else {
				queue1.setVisible(true);
				queue2.setVisible(true);
				queue3.setVisible(true);
				queueParallelTransition.playFromStart();
				queueTextField.setText("P4   " + queueTextField.getText());
				p4StatusText.setText("Status : Waiting in Queue");
				for (int j = 0; j < queue.length; j++) {
					if (queue[j] == null) {
						queue[j] = execDivButton;
						break;
					}
				}
			}
		} else {
			divcurve.setVisible(true);
			divLine1.setVisible(true);
			divLine2.setVisible(true);

			divParallelTransition.playFromStart();
			
			lockDivButton.setDisable(true);
			p4topqueuenum = Integer.parseInt(topStackValueText.getText().substring(18));
			p4ReadValueText.setText("Read Value : " + p4topqueuenum);
			execDivButton.setDisable(false);
			p4StatusText.setText("Status : Ready to execute");

		}
	}

	public void execAddButton(ActionEvent e) {
		error = false;
		try {
			operationInteger = Integer.parseInt(addValue.getText());

		} catch (Exception e2) {
			addValue.clear();
			addValue.setPromptText("Wrong Input");
			error = true;
		}

		if (prot) {

			System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);

			if (!error) {
				p1StatusText.setText("Status : In Critical Section");

				unlockAddButton.setDisable(false);
				execAddButton.setDisable(true);

				curve.setVisible(true);
				line1.setVisible(true);
				line2.setVisible(true);

				parallelTransitionIn.playFromStart();

				if (queueTextField.getText().contains("P1")) {
					dequeue1.setVisible(true);
					dequeue2.setVisible(true);
					dequeue3.setVisible(true);
					dequeueParallelTransition.playFromStart();
					queueTextField
							.setText(queueTextField.getText().substring(0, queueTextField.getText().length() - 5));
				}

				aluOpertationText.setText(operationInteger.toString());
				aluOpertationText.setVisible(true);
				aluTopStackValueText.setText(topStackValueText.getText().substring(18));
				aluTopStackValueText.setVisible(true);
				answer = operationInteger + Integer.parseInt(topStackValueText.getText().substring(18));
				aluSolutionValueText.setText(answer.toString());
				aluSolutionValueText.setVisible(true);
				addValue.clear();
				addValue.setPromptText("");
			}
		} else {

			if (!error) {

				p1StatusText.setText("Status : Ready to Write");

				unlockAddButton.setDisable(false);
				execAddButton.setDisable(true);

				execSubButton.setDisable(true);
				execMulButton.setDisable(true);
				execDivButton.setDisable(true);

				if (p2StatusText.getText().equals("Status : Ready to execute")) {
					p2StatusText.setText("Status : Waiting for ALU");
				}
				if (p3StatusText.getText().equals("Status : Ready to execute")) {
					p3StatusText.setText("Status : Waiting for ALU");
				}
				if (p4StatusText.getText().equals("Status : Ready to execute")) {
					p4StatusText.setText("Status : Waiting for ALU");
				}

				/*
				 * curve.setVisible(true); line1.setVisible(true); line2.setVisible(true);
				 * 
				 * parallelTransitionIn.playFromStart();
				 */

				aluOpertationText.setText(operationInteger.toString());
				aluOpertationText.setVisible(true);
				aluTopStackValueText.setText("" + p1topqueuenum);
				aluTopStackValueText.setVisible(true);
				answer = operationInteger + p1topqueuenum;
				aluSolutionValueText.setText(answer.toString());
				aluSolutionValueText.setVisible(true);
				addValue.clear();
				addValue.setPromptText("");

			}

		}

	}

	public void execSubButton(ActionEvent e) {
		error = false;
		try {
			operationInteger = Integer.parseInt(subValue.getText());
		} catch (Exception e2) {
			subValue.clear();
			subValue.setPromptText("Wrong Input");
			error = true;
		}
		if (prot) {

			if (!error) {
				System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);
				unlockSubButton.setDisable(false);
				execSubButton.setDisable(true);

				curve.setVisible(true);
				line1.setVisible(true);
				line2.setVisible(true);

				parallelTransitionIn.playFromStart();

				if (queueTextField.getText().contains("P2")) {
					dequeue1.setVisible(true);
					dequeue2.setVisible(true);
					dequeue3.setVisible(true);
					dequeueParallelTransition.playFromStart();
					queueTextField
							.setText(queueTextField.getText().substring(0, queueTextField.getText().length() - 5));
				}
				p2StatusText.setText("Status : In Critical Section");

				aluOpertationText.setText(operationInteger.toString());
				aluOpertationText.setVisible(true);
				aluTopStackValueText.setText(topStackValueText.getText().substring(18));
				aluTopStackValueText.setVisible(true);
				answer = Integer.parseInt(topStackValueText.getText().substring(18)) - operationInteger;
				aluSolutionValueText.setText(answer.toString());
				aluSolutionValueText.setVisible(true);
				subValue.clear();
				subValue.setPromptText("");
			}
		} else {
			if (!error) {

				p2StatusText.setText("Status : Ready to Write");

				unlockSubButton.setDisable(false);
				execSubButton.setDisable(true);

				execAddButton.setDisable(true);
				execMulButton.setDisable(true);
				execDivButton.setDisable(true);

				if (p1StatusText.getText().equals("Status : Ready to execute")) {
					p1StatusText.setText("Status : Waiting for ALU");
				}
				if (p3StatusText.getText().equals("Status : Ready to execute")) {
					p3StatusText.setText("Status : Waiting for ALU");
				}
				if (p4StatusText.getText().equals("Status : Ready to execute")) {
					p4StatusText.setText("Status : Waiting for ALU");
				}

				/*
				 * curve.setVisible(true); line1.setVisible(true); line2.setVisible(true);
				 * 
				 * parallelTransitionIn.playFromStart();
				 */

				aluOpertationText.setText(operationInteger.toString());
				aluOpertationText.setVisible(true);
				aluTopStackValueText.setText("" + p2topqueuenum);
				aluTopStackValueText.setVisible(true);
				answer = p2topqueuenum - operationInteger;
				aluSolutionValueText.setText(answer.toString());
				aluSolutionValueText.setVisible(true);
				subValue.clear();
				subValue.setPromptText("");

			}

		}
	}

	public void execMulButton(ActionEvent e) {
		error = false;
		System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);

		try {
			operationInteger = Integer.parseInt(mulValue.getText());
		} catch (Exception e2) {
			// TODO: handle exception
			mulValue.clear();
			mulValue.setPromptText("Wrong Input");
			error = true;
		}
		if (prot) {

			if (!error) {
				unlockMulButton.setDisable(false);
				execMulButton.setDisable(true);

				curve.setVisible(true);
				line1.setVisible(true);
				line2.setVisible(true);

				parallelTransitionIn.playFromStart();

				if (queueTextField.getText().contains("P3")) {
					dequeue1.setVisible(true);
					dequeue2.setVisible(true);
					dequeue3.setVisible(true);
					dequeueParallelTransition.playFromStart();
					queueTextField
							.setText(queueTextField.getText().substring(0, queueTextField.getText().length() - 5));
				}
				p3StatusText.setText("Status : In Critical Section");

				aluOpertationText.setText(operationInteger.toString());
				aluOpertationText.setVisible(true);
				aluTopStackValueText.setText(topStackValueText.getText().substring(18));
				aluTopStackValueText.setVisible(true);
				answer = operationInteger * Integer.parseInt(topStackValueText.getText().substring(18));
				aluSolutionValueText.setText(answer.toString());
				aluSolutionValueText.setVisible(true);
				mulValue.clear();
				mulValue.setPromptText("");
			}
		} else {
			if (!error) {

				p3StatusText.setText("Status : Ready to Write");

				unlockMulButton.setDisable(false);
				execMulButton.setDisable(true);

				execAddButton.setDisable(true);
				execSubButton.setDisable(true);
				execDivButton.setDisable(true);

				if (p1StatusText.getText().equals("Status : Ready to execute")) {
					p1StatusText.setText("Status : Waiting for ALU");
				}
				if (p2StatusText.getText().equals("Status : Ready to execute")) {
					p2StatusText.setText("Status : Waiting for ALU");
				}
				if (p4StatusText.getText().equals("Status : Ready to execute")) {
					p4StatusText.setText("Status : Waiting for ALU");
				}

				/*
				 * curve.setVisible(true); line1.setVisible(true); line2.setVisible(true);
				 * 
				 * parallelTransitionIn.playFromStart();
				 */

				aluOpertationText.setText(operationInteger.toString());
				aluOpertationText.setVisible(true);
				aluTopStackValueText.setText("" + p3topqueuenum);
				aluTopStackValueText.setVisible(true);
				answer = operationInteger * p3topqueuenum;
				aluSolutionValueText.setText(answer.toString());
				aluSolutionValueText.setVisible(true);
				mulValue.clear();
				mulValue.setPromptText("");

			}

		}
	}

	public void execDivButton(ActionEvent e) {
		error = false;
		try {
			operationInteger = Integer.parseInt(divValue.getText());
		} catch (Exception e2) {
			// TODO: handle exception
			divValue.clear();
			divValue.setPromptText("Wrong Input");
			error = true;
		}
		if (operationInteger == 0) {
			divValue.clear();
			divValue.setPromptText("Can't be 0");
			error = true;
		}
		if (prot) {
			System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);

			if (!error) {
				unlockDivButton.setDisable(false);
				execDivButton.setDisable(true);

				curve.setVisible(true);
				line1.setVisible(true);
				line2.setVisible(true);

				parallelTransitionIn.playFromStart();

				if (queueTextField.getText().contains("P4")) {
					dequeue1.setVisible(true);
					dequeue2.setVisible(true);
					dequeue3.setVisible(true);
					dequeueParallelTransition.playFromStart();
					queueTextField
							.setText(queueTextField.getText().substring(0, queueTextField.getText().length() - 5));
				}
				p4StatusText.setText("Status : In Critical Section");

				aluOpertationText.setText(operationInteger.toString());
				aluOpertationText.setVisible(true);
				aluTopStackValueText.setText(topStackValueText.getText().substring(18));
				aluTopStackValueText.setVisible(true);
				answer = Integer.parseInt(topStackValueText.getText().substring(18)) / operationInteger;
				aluSolutionValueText.setText(answer.toString());
				aluSolutionValueText.setVisible(true);
				divValue.clear();
				divValue.setPromptText("");
			}
		} else {
			if (!error) {

				p4StatusText.setText("Status : Ready to Write");

				unlockDivButton.setDisable(false);
				execDivButton.setDisable(true);

				execAddButton.setDisable(true);
				execSubButton.setDisable(true);
				execMulButton.setDisable(true);

				if (p1StatusText.getText().equals("Status : Ready to execute")) {
					p1StatusText.setText("Status : Waiting for ALU");
				}
				if (p2StatusText.getText().equals("Status : Ready to execute")) {
					p2StatusText.setText("Status : Waiting for ALU");
				}
				if (p3StatusText.getText().equals("Status : Ready to execute")) {
					p3StatusText.setText("Status : Waiting for ALU");
				}

				/*
				 * curve.setVisible(true); line1.setVisible(true); line2.setVisible(true);
				 * 
				 * parallelTransitionIn.playFromStart();
				 */

				aluOpertationText.setText(operationInteger.toString());
				aluOpertationText.setVisible(true);
				aluTopStackValueText.setText("" + p4topqueuenum);
				aluTopStackValueText.setVisible(true);
				answer = p4topqueuenum / operationInteger;
				aluSolutionValueText.setText(answer.toString());
				aluSolutionValueText.setVisible(true);
				divValue.clear();
				divValue.setPromptText("");

			}

		}
	}

	public void unlockAddButton(ActionEvent e) {
		if (prot) {
			System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);

			p1StatusText.setText("Status : Exiting Critical Section");

			curveun.setVisible(true);
			line1un.setVisible(true);
			line2un.setVisible(true);

			parallelTransitionInun.playFromStart();

			if (queue[0] != null) {
				queue[0].setDisable(false);
				queue[0] = queue[1];
				queue[1] = queue[2];
				queue[2] = queue[3];
				queue[3] = null;
			} else {
				inExec = false;
			}

			// dequeueoutParallelTransition.playFromStart();
			// parallelTransitionOut.playFromStart();

			Runnable task = () -> {
				try {
					Thread.sleep(1000);
					Platform.runLater(() -> {
						unlockAddButton.setDisable(true);
						lockAddButton.setDisable(false);
						aluOpertationText.setVisible(false);
						topStackValueText.setText("Top Stack Value = " + answer);
						aluTopStackValueText.setVisible(false);
						aluSolutionValueText.setVisible(false);
						p1StatusText.setText("Status : Idle");
						parallelTransitionOutun.playFromStart();
					});

				} catch (InterruptedException ee) {
					ee.printStackTrace();
				}
			};

			new Thread(task).start();
		} else {

			p1StatusText.setText("Status : Writing");

			curveun.setVisible(true);
			line1un.setVisible(true);
			line2un.setVisible(true);

			parallelTransitionInun.playFromStart();

			Runnable task = () -> {
				try {
					Thread.sleep(1000);
					Platform.runLater(() -> {
						unlockAddButton.setDisable(true);
						lockAddButton.setDisable(false);
						aluOpertationText.setVisible(false);
						topStackValueText.setText("Top Stack Value = " + answer);
						aluTopStackValueText.setVisible(false);
						aluSolutionValueText.setVisible(false);
						p1StatusText.setText("Status : Idle");
						parallelTransitionOutun.playFromStart();
					});

				} catch (InterruptedException ee) {
					ee.printStackTrace();
				}
			};

			new Thread(task).start();

			p1ReadValueText.setText("Read Value : ");

			if (p2StatusText.getText().equals("Status : Waiting for ALU")) {
				execSubButton.setDisable(false);
				p2StatusText.setText("Status : Ready to execute");
			}
			if (p3StatusText.getText().equals("Status : Waiting for ALU")) {
				execMulButton.setDisable(false);
				p3StatusText.setText("Status : Ready to execute");
			}
			if (p4StatusText.getText().equals("Status : Waiting for ALU")) {
				execDivButton.setDisable(false);
				p4StatusText.setText("Status : Ready to execute");
			}

		}
	}

	public void unlockSubButton(ActionEvent e) {
		if (prot) {
			System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);

			p2StatusText.setText("Status : Exiting Critical Section");

			curveun.setVisible(true);
			line1un.setVisible(true);
			line2un.setVisible(true);

			parallelTransitionInun.playFromStart();

			if (queue[0] != null) {
				queue[0].setDisable(false);
				queue[0] = queue[1];
				queue[1] = queue[2];
				queue[2] = queue[3];
				queue[3] = null;
			} else {
				inExec = false;
			}

			// parallelTransitionOut.playFromStart();

			Runnable task = () -> {
				try {
					Thread.sleep(1000);
					Platform.runLater(() -> {

						unlockSubButton.setDisable(true);
						lockSubButton.setDisable(false);
						aluOpertationText.setVisible(false);
						topStackValueText.setText("Top Stack Value = " + answer);
						aluTopStackValueText.setVisible(false);
						aluSolutionValueText.setVisible(false);
						p2StatusText.setText("Status : Idle");
						parallelTransitionOutun.playFromStart();
					});

				} catch (InterruptedException ee) {
					ee.printStackTrace();
				}
			};

			new Thread(task).start();
		} else {

			p2StatusText.setText("Status : Writing");

			curveun.setVisible(true);
			line1un.setVisible(true);
			line2un.setVisible(true);

			parallelTransitionInun.playFromStart();

			Runnable task = () -> {
				try {
					Thread.sleep(1000);
					Platform.runLater(() -> {
						unlockSubButton.setDisable(true);
						lockSubButton.setDisable(false);
						aluOpertationText.setVisible(false);
						topStackValueText.setText("Top Stack Value = " + answer);
						aluTopStackValueText.setVisible(false);
						aluSolutionValueText.setVisible(false);
						p2StatusText.setText("Status : Idle");
						parallelTransitionOutun.playFromStart();
					});

				} catch (InterruptedException ee) {
					ee.printStackTrace();
				}
			};

			new Thread(task).start();

			p2ReadValueText.setText("Read Value : ");

			if (p1StatusText.getText().equals("Status : Waiting for ALU")) {
				execAddButton.setDisable(false);
				p1StatusText.setText("Status : Ready to execute");
			}
			if (p3StatusText.getText().equals("Status : Waiting for ALU")) {
				execMulButton.setDisable(false);
				p3StatusText.setText("Status : Ready to execute");
			}
			if (p4StatusText.getText().equals("Status : Waiting for ALU")) {
				execDivButton.setDisable(false);
				p4StatusText.setText("Status : Ready to execute");
			}

		}
	}

	public void unlockMulButton(ActionEvent e) {
		if (prot) {
			System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);

			p3StatusText.setText("Status : Exiting Critical Section");

			curveun.setVisible(true);
			line1un.setVisible(true);
			line2un.setVisible(true);

			parallelTransitionInun.playFromStart();

			if (queue[0] != null) {
				queue[0].setDisable(false);
				queue[0] = queue[1];
				queue[1] = queue[2];
				queue[2] = queue[3];
				queue[3] = null;
			} else {
				inExec = false;
			}

			// parallelTransitionOut.playFromStart();

			Runnable task = () -> {
				try {
					Thread.sleep(1000);
					Platform.runLater(() -> {
						unlockMulButton.setDisable(true);
						lockMulButton.setDisable(false);
						aluOpertationText.setVisible(false);
						topStackValueText.setText("Top Stack Value = " + answer);
						aluTopStackValueText.setVisible(false);
						aluSolutionValueText.setVisible(false);
						p3StatusText.setText("Status : Idle");
						parallelTransitionOutun.playFromStart();
					});

				} catch (InterruptedException ee) {
					ee.printStackTrace();
				}
			};

			new Thread(task).start();
		} else {

			p3StatusText.setText("Status : Writing");

			curveun.setVisible(true);
			line1un.setVisible(true);
			line2un.setVisible(true);

			parallelTransitionInun.playFromStart();

			Runnable task = () -> {
				try {
					Thread.sleep(1000);
					Platform.runLater(() -> {
						unlockMulButton.setDisable(true);
						lockMulButton.setDisable(false);
						aluOpertationText.setVisible(false);
						topStackValueText.setText("Top Stack Value = " + answer);
						aluTopStackValueText.setVisible(false);
						aluSolutionValueText.setVisible(false);
						p3StatusText.setText("Status : Idle");
						parallelTransitionOutun.playFromStart();
					});

				} catch (InterruptedException ee) {
					ee.printStackTrace();
				}
			};

			new Thread(task).start();

			p3ReadValueText.setText("Read Value : ");

			if (p2StatusText.getText().equals("Status : Waiting for ALU")) {
				execSubButton.setDisable(false);
				p2StatusText.setText("Status : Ready to execute");
			}
			if (p1StatusText.getText().equals("Status : Waiting for ALU")) {
				execAddButton.setDisable(false);
				p1StatusText.setText("Status : Ready to execute");
			}
			if (p4StatusText.getText().equals("Status : Waiting for ALU")) {
				execDivButton.setDisable(false);
				p4StatusText.setText("Status : Ready to execute");
			}

		}
	}

	public void unlockDivButton(ActionEvent e) {
		if (prot) {
			System.out.println(e.getSource().toString().split("id=")[1].toString().split(", ")[0]);

			p4StatusText.setText("Status : Exiting Critical Section");

			curveun.setVisible(true);
			line1un.setVisible(true);
			line2un.setVisible(true);

			// parallelTransitionInun.playFromStart();

			if (queue[0] != null) {
				queue[0].setDisable(false);
				queue[0] = queue[1];
				queue[1] = queue[2];
				queue[2] = queue[3];
				queue[3] = null;
			} else {
				inExec = false;
			}

			parallelTransitionOut.playFromStart();

			Runnable task = () -> {
				try {
					Thread.sleep(1000);
					Platform.runLater(() -> {
						unlockDivButton.setDisable(true);
						lockDivButton.setDisable(false);
						aluOpertationText.setVisible(false);
						topStackValueText.setText("Top Stack Value = " + answer);
						aluTopStackValueText.setVisible(false);
						aluSolutionValueText.setVisible(false);
						p4StatusText.setText("Status : Idle");
						parallelTransitionOutun.playFromStart();
					});

				} catch (InterruptedException ee) {
					ee.printStackTrace();
				}
			};

			new Thread(task).start();
		} else {

			p4StatusText.setText("Status : Writing");

			curveun.setVisible(true);
			line1un.setVisible(true);
			line2un.setVisible(true);

			parallelTransitionInun.playFromStart();

			Runnable task = () -> {
				try {
					Thread.sleep(1000);
					Platform.runLater(() -> {
						unlockDivButton.setDisable(true);
						lockDivButton.setDisable(false);
						aluOpertationText.setVisible(false);
						topStackValueText.setText("Top Stack Value = " + answer);
						aluTopStackValueText.setVisible(false);
						aluSolutionValueText.setVisible(false);
						p4StatusText.setText("Status : Idle");
						parallelTransitionOutun.playFromStart();
					});

				} catch (InterruptedException ee) {
					ee.printStackTrace();
				}
			};

			new Thread(task).start();

			p4ReadValueText.setText("Read Value : ");

			if (p2StatusText.getText().equals("Status : Waiting for ALU")) {
				execSubButton.setDisable(false);
				p2StatusText.setText("Status : Ready to execute");
			}
			if (p3StatusText.getText().equals("Status : Waiting for ALU")) {
				execMulButton.setDisable(false);
				p3StatusText.setText("Status : Ready to execute");
			}
			if (p1StatusText.getText().equals("Status : Waiting for ALU")) {
				execAddButton.setDisable(false);
				p1StatusText.setText("Status : Ready to execute");
			}

		}
	}

	public void petersonButton(ActionEvent e) {

		if (petersonStage == null) {

			try {

				Parent root1 = FXMLLoader.load(getClass().getResource("petersonUI.fxml"));

				petersonStage = new Stage();
				petersonStage.setTitle("Peterson's Algorithm");
				petersonStage.setScene(new Scene(root1));

				petersonStage.show();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (petersonStage.isShowing()) {
			petersonStage.toFront();

		} else {
			petersonStage.show();
		}

	}

	public void spinlockButton(ActionEvent e) {

		if (spinLockStage == null) {

			try {
				Parent root1 = FXMLLoader.load(getClass().getResource("spinlockUI.fxml"));
				spinLockStage = new Stage();
				spinLockStage.setTitle("Spinlock Algorithm");
				spinLockStage.setScene(new Scene(root1));
				spinLockStage.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (spinLockStage.isShowing()) {
			spinLockStage.toFront();

		} else {
			spinLockStage.show();
		}
	}

	public void protectedmodePressed(ActionEvent e) {
		prot = true;

		clearScreen();

		lockAddButton.setText("Lock");
		lockSubButton.setText("Lock");
		lockMulButton.setText("Lock");
		lockDivButton.setText("Lock");

		unlockAddButton.setText("Unlock");
		unlockSubButton.setText("Unlock");
		unlockMulButton.setText("Unlock");
		unlockDivButton.setText("Unlock");

		queuewaitingText.setVisible(true);
		queueuLine1.setVisible(true);
		queueuLine2.setVisible(true);
		queueTextField.setVisible(true);

		aluTopStackValueText.setVisible(false);
		aluOpertationText.setVisible(false);
		aluSolutionValueText.setVisible(false);

		p1ReadValueText.setText("Read Value : ");
		p2ReadValueText.setText("Read Value : ");
		p3ReadValueText.setText("Read Value : ");
		p4ReadValueText.setText("Read Value : ");
		p1ReadValueText.setVisible(false);
		p2ReadValueText.setVisible(false);
		p3ReadValueText.setVisible(false);
		p4ReadValueText.setVisible(false);
	}

	public void unprotectedmodePressed(ActionEvent e) {

		prot = false;

		clearScreen();

		lockAddButton.setText("Read");
		lockSubButton.setText("Read");
		lockMulButton.setText("Read");
		lockDivButton.setText("Read");

		unlockAddButton.setText("Write");
		unlockSubButton.setText("Write");
		unlockMulButton.setText("Write");
		unlockDivButton.setText("Write");

		queuewaitingText.setVisible(false);
		queueuLine1.setVisible(false);
		queueuLine2.setVisible(false);
		queueTextField.setVisible(false);

		aluTopStackValueText.setVisible(false);
		aluOpertationText.setVisible(false);
		aluSolutionValueText.setVisible(false);

		p1ReadValueText.setText("Read Value : ");
		p2ReadValueText.setText("Read Value : ");
		p3ReadValueText.setText("Read Value : ");
		p4ReadValueText.setText("Read Value : ");
		p1ReadValueText.setVisible(true);
		p2ReadValueText.setVisible(true);
		p3ReadValueText.setVisible(true);
		p4ReadValueText.setVisible(true);

	}

	public void clearScreen() {

		addValue.clear();
		subValue.clear();
		mulValue.clear();
		divValue.clear();

		addValue.setPromptText("");
		subValue.setPromptText("");
		mulValue.setPromptText("");
		divValue.setPromptText("");

		lockAddButton.setDisable(false);
		lockSubButton.setDisable(false);
		lockMulButton.setDisable(false);
		lockDivButton.setDisable(false);

		execAddButton.setDisable(true);
		execSubButton.setDisable(true);
		execMulButton.setDisable(true);
		execDivButton.setDisable(true);

		unlockAddButton.setDisable(true);
		unlockSubButton.setDisable(true);
		unlockMulButton.setDisable(true);
		unlockDivButton.setDisable(true);

		p1StatusText.setText("Status : Idle");
		p2StatusText.setText("Status : Idle");
		p3StatusText.setText("Status : Idle");
		p4StatusText.setText("Status : Idle");

		topStackValueText.setText("Top Stack Value = 0");

		aluTopStackValueText.setVisible(false);
		aluOpertationText.setVisible(false);
	   

	}

}
