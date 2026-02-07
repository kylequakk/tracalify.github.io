package com.caltracker;
//packages
import java.util.InputMismatchException;

/*
    USER CLASS
 */
public class User {
    //Instance Variables
    private int id; //token recognized by database
    private String username;
    private String password;

    public User(){}; //used for JSON library

    /*--------------------------------------------------------
        user Constructor returns parameters id and username
        @param int id returns database id of user
        @param String username returns name of user
        @throws InputMismatchException if @params null or empty
        @throws PasswordTooShortException if password <= 6
     --------------------------------------------------------*/
    public User(int id, String username, String password) throws PasswordTooShortException {
        setId(id);
        setUsername(username); //checks same exceptions
        setPassword(password); //checks same exceptions
    } //user constructor

    /*--------------------------------------------------------
        getId() returns user id
    --------------------------------------------------------*/
    public int getId(){
        return id;
    } //getId() method

    /*--------------------------------------------------------
        setId() sets user's id
        @param int id
        @throws
-   -------------------------------------------------------*/
    public void setId(int id){

        this.id = id;
    } //setId() method

    /*--------------------------------------------------------
        getUsername() returns user's name
     --------------------------------------------------------*/
    public String getUsername(){
        return username;
    } //getUsername method

    /*--------------------------------------------------------
        setUsername() sets user's name
        @param String username
        @throws InputMismatchException for null or blank values
     --------------------------------------------------------*/
    public void setUsername(String username){
        //Check if null or empty
        String usernameMsgErr = "Please enter a username";
        if ((username == null) || username.isBlank()){
            throw new InputMismatchException(usernameMsgErr);
        }
        this.username = username;
    } //setUsername method

    /*--------------------------------------------------------
        getPassword() gets user's password
     --------------------------------------------------------*/
    public String getPassword(){
        return password;
    } //getPassword method

    /*--------------------------------------------------------
        setPassword() sets user's password
        @param String password
        @throws passwordTooShortException if String password
        length isn't less than or equal to six characters
    --------------------------------------------------------*/
    public void setPassword(String password) throws PasswordTooShortException {
        String passwordMsgErr = "Password must have at least 6 characters";
        //Check if null
        if (password == null){
            throw new PasswordTooShortException(passwordMsgErr);
        }
        //Check if too short
        if (password.length() < 6) {
            throw new PasswordTooShortException(passwordMsgErr);
        }

        this.password = password;
    } //setPassword method

    /*--------------------------------------------------------
        getMeal() accesses current meal object
     --------------------------------------------------------*/


} //user class
