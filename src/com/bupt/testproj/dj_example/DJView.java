package com.bupt.testproj.dj_example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DJView implements ActionListener, BeatObserver, BPMObserver {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	BeatModelnterface model;
	JFrame viewFrame;
	JPanel viewPanel;
	BeatBar  beatBar;
	JLabel bpmOutputLabel;

	public DJView(BeatModelnterface model) {
		this.model = model;
		model.registerBeatObserver((BeatObserver) this);
		model.registerBPMObserver((BPMObserver) this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	public void updateBPM() {
		int bpm = model.getBPM();
		if (bpm == 0) {
			bpmOutputLabel.setText("Offline");
		} else {
			bpmOutputLabel.setText("Current BPM:" + model.getBPM());
		}
	}

	public void updateBeat() {
		beatBar.setValue(100);
	}
}
