/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.mail;

/**
 *
 * @author apasi
 */
public class Mail {
    String adress;
    String topic;
    String message;

    public Mail(String adress, String topic, String message) {
        this.adress = adress;
        //TODO - Topic Creator
        this.topic = topic;
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getFullMsg(){
        return this.adress + "/" + EMail.loggedUser + "/" + this.topic + "/" + this.message+"/";
    }
    
    @Override
    public String toString(){
        return this.topic;
    }
}
