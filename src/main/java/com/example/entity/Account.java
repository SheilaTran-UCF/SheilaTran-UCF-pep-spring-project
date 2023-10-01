package com.example.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * This is a class that models an Account.
 *
 * You should NOT make any modifications to this class.
 */
@Entity
public class Account {
    /**
     * An id for this Account. You should use this as the Entity's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer account_id;
    /**
     * A username for this Account (must be unique and not blank)
     */
    @NotBlank(message = "username not blank")
    private String username;
    /**
     * A password for this account (must be over 4 characters)
     */
    @NotBlank(message = "password not blank")
    private String password;
    /**
     * A default, no-args constructor, as well as correctly formatted getters and setters, are needed for
     * Jackson Objectmapper to work.
     */
    public Account(){

    }
    /**
     * When posting a new Account, the id can be generated by the database. In that case, a constructor without
     * account_id is needed.
     * @param username
     * @param password
     */
    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }
    /**
     * Whem retrieving an Account from the database, all fields will be needed. In that case, a constructor with all
     * fields is needed.
     * @param account_id
     * @param username
     * @param password
     */
    public Account(Integer account_id, String username, String password) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @return account_id
     */
    public Integer getAccount_id() {
        return account_id;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @param account_id
     */
    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @return username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Properly named getters and setters are necessary for Jackson ObjectMapper to work. You may use them as well.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Overriding the default equals() method adds functionality to tell when two objects are identical, allowing
     * Assert.assertEquals and List.contains to function.
     * @param o the other object.
     * @return true if o is equal to this object.
     */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (account_id == null) {
			if (other.account_id != null)
				return false;
		} else if (!account_id.equals(other.account_id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

    /**
     * Overriding the default toString() method allows for easy debugging.
     * @return a String representation of this class.
     */
    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
