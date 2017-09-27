package model;

public class Payment {
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	private String cardType;
	private String cardNumber;
	private String securityCode;
	private String expirationDate;//month + year
	
	public Payment(String cardType, String cardNumber, String securityCode, String dxpirationDate) {
		super();
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
		this.expirationDate = dxpirationDate;
	}
	
	
	

}
