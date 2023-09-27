package model;

import java.sql.Date;
import java.util.ArrayList;

public class Item {
	private int itemId;
	private ArrayList<String> itemImg;
	private String itemTitle;
	private String itemState;
	private String itemExplanation;
	private int itemPrice;
	private boolean saleState;
	private Date dateTime;
	private String studentNumber;

	

	public Item() {}
	public Item(int itemId, ArrayList<String> itemImg, String itemTitle, String itemState,
			String itemExplanation, int itemPrice, boolean saleState, Date dateTime, String studentNumber) {
		this.itemId = itemId;
		this.itemImg = itemImg;
		this.itemTitle = itemTitle;
		this.itemState = itemState;
		this.itemExplanation = itemExplanation;
		this.itemPrice = itemPrice;
		this.saleState = saleState;
		this.dateTime = dateTime;
		this.studentNumber = studentNumber;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public ArrayList<String> getItemImg() {
		return itemImg;
	}

	public void setItemImg(ArrayList<String> itemImg) {
		this.itemImg = itemImg;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getItemState() {
		return itemState;
	}

	public void setItemState(String itemState) {
		this.itemState = itemState;
	}

	public String getItemExplanation() {
		return itemExplanation;
	}

	public void setItemExplanation(String itemExplanation) {
		this.itemExplanation = itemExplanation;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public boolean isSaleState() {
		return saleState;
	}

	public void setSaleState(boolean saleState) {
		this.saleState = saleState;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
}
