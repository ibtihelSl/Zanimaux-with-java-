/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.Zanimaux.entities;

/**
 *
 * @author ci
 */
public class FaqQuestions 
{
   public int id;
   public String question;
   public String reponse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public FaqQuestions() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "FaqQuestions{" + "id=" + id + ", question=" + question + ", reponse=" + reponse + '}';
    }

    public FaqQuestions(int id, String question, String reponse) {
        this.id = id;
        this.question = question;
        this.reponse = reponse;
    }

    public FaqQuestions(String question, String reponse) {
        this.question = question;
        this.reponse = reponse;
    }
    
    
    
    

   
}
