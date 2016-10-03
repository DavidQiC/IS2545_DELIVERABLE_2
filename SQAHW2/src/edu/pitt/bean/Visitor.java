package edu.pitt.bean;

public enum Visitor {

	Student("a Student", 1, 3, 1), Professor("a Professor", 2, 4, 0), Business("a Business Person", 3, 2,
			2), Blogger("a Blogger", 4, 0, 4);
	private String name;
	private int index;
	private int likeMax;
	private int disLikeMax;

	private Visitor(String name, int index, int likeMax, int disLikeMax) {
		this.name = name;
		this.index = index;
		this.likeMax = likeMax;
		this.disLikeMax = disLikeMax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getLikeMax() {
		return likeMax;
	}

	public void setLikeMax(int likeMax) {
		this.likeMax = likeMax;
	}

	public int getDisLikeMax() {
		return disLikeMax;
	}

	public void setDisLikeMax(int disLikeMax) {
		this.disLikeMax = disLikeMax;
	}


}
