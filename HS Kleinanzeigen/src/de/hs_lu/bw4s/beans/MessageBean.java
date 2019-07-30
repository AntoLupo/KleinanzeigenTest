package de.hs_lu.bw4s.beans;

public class MessageBean {
	
	String infoMessage;
	String actionMessage;
	
	public MessageBean() {
		this.setGeneralWelcome();
	}

	public void setLogoutSuccessful() {
		this.infoMessage = "Sie haben sich erfolgreich angemeldet";
		this.actionMessage = "Bitte melden Sie sich wieder an";
	}
	public void setLoginSuccessful(String userid) {
		this.infoMessage = userid + ", Sie haben sich erfolgreich angemeldet";
		this.actionMessage = "Bitte waehlen Sie eine Anwendung";
	}
	public void setLoginFailed() {
		this.infoMessage = "Ihre Anmeldedaten waren nicht korrekt";
		this.actionMessage = "Bitte versuchen Sie es noch einmal";
	}
	public void setGeneralWelcome() {
		this.infoMessage = "Willkommen bei HWG Kleinanzeigen";
		this.actionMessage = "Bitte melden Sie sich an";
	}
	public void setRegWelcome() {
		this.infoMessage = "Willkommen zur HWG Kleinanzeigen Registrierung";
		this.actionMessage = "Bitte registrieren Sie sich";
	}
	public void setRegSuccessful(String userid) {
		this.infoMessage = "Account " + userid + " wurde registriert";
		this.actionMessage = "Bitte melden Sie sich jetzt an";
	}
	public void setAccountAlreadyExists(String userid) {
		this.infoMessage = "Nickname " + userid + " existiert schon";
		this.actionMessage = "Bitte verwenden Sie einen anderen Nickname";
	}
	public void setDBVerbindungKaputt() {
		this.infoMessage = "Sie sind nicht mit der Datenbank verbunden";
		this.actionMessage = "Bitte verständigen Sie Ihren Administrator";
	}
	public void setAllgemeinerDBFehler() {
		this.infoMessage = "Es ist ein Datenbankproblem aufgetreten";
		this.actionMessage = "Bitte verständigen Sie Ihren Administrator";
	}
	public void setAnyError() {
		this.infoMessage = "Oops, hier ist was schiefgelaufen";
		this.actionMessage = "Bitte verständigen Sie Ihren Administrator";
	}
	
	
	

	public String getInfoMessage() {
		return infoMessage;
	}
	public String getActionMessage() {
		return actionMessage;
	}
}
