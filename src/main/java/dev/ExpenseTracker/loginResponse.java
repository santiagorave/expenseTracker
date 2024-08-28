package dev.ExpenseTracker;

public class loginResponse {
	private String token;

    private long expiresIn;

    public String getToken() {
        return token;
    }
    
    public long getExpiresIn() {
    	return expiresIn;
    }
    
    public void setToken(String newToken) {
    	this.token = newToken;
    }
   public void setExpiresIn(long newExpire) {
	   this.expiresIn = newExpire;
   }
}
