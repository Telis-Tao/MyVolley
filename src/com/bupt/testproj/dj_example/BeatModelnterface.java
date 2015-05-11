package com.bupt.testproj.dj_example;

import java.util.Observer;

public interface BeatModelnterface {
	void init();
	void on();
	void off();
	void setBPM(int bpm);
	int getBPM();
	void registerBeatObserver(BeatObserver o);
	void removeBeatObserver(BeatObserver o);
	void registerBPMObserver(BPMObserver o);
	void removeBPMObserver(BPMObserver o);
}
