package com.bupt.testproj.dj_example;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.Sequencer;

public class BeatModel implements BeatModelnterface, MetaEventListener {
	Sequencer sequencer;
	List<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
	List<BPMObserver> BPMObservers = new ArrayList<BPMObserver>();
	int bpm = 90;

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("set up midi");
		System.out.println("build track and start!");
	}

	@Override
	public void on() {
		// TODO Auto-generated method stub
		sequencer.start();
		setBPM(90);
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		setBPM(0);
		sequencer.stop();
	}

	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;
		sequencer.setTempoInBPM(getBPM());
	}

	@Override
	public int getBPM() {
		// TODO Auto-generated method stub
		return bpm;
	}

	@Override
	public void registerBeatObserver(BeatObserver o) {
		// TODO Auto-generated method stub
		beatObservers.add(o);
	}

	@Override
	public void removeBeatObserver(BeatObserver o) {
		// TODO Auto-generated method stub
		beatObservers.remove(o);
	}

	@Override
	public void registerBPMObserver(BPMObserver o) {
		// TODO Auto-generated method stub
		BPMObservers.add(o);
	}

	@Override
	public void removeBPMObserver(BPMObserver o) {
		// TODO Auto-generated method stub
		BPMObservers.remove(o);
	}

	@Override
	public void meta(MetaMessage meta) {
		// TODO Auto-generated method stub

	}

}
