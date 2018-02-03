package com.rajeshpatkar;

public class Question
{
    String text;
    String opt1;
    String opt2;
    String opt3;
    String opt4;
    int ans; 
    void setAns(int i){
       ans = i;
    }
    int getAns(){
        return ans;
   }
    public Question()
    {
    }

    public Question(String question, String op1, String op2, String op3, String op4)
    {
        this.text = question;
        this.opt1 = op1;
        this.opt2 = op2;
        this.opt3 = op3;
        this.opt4 = op4;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String question)
    {
        this.text = question;
    }

    public String getOpt1()
    {
        return opt1;
    }

   
 public void setOpt1(String op1)
    {
        this.opt1 = op1;
    }

    public String getOpt2()
    {
        return opt2;
    }

    public void setOpt2(String op2)
    {
        this.opt2 = op2;
    }

    public String getOpt3()
    {
        return opt3;
    }

    public void setOpt3(String op3)
    {
        this.opt3 = op3;
    }

    public String getOpt4()
    {
        return opt4;
    }

    public void setOpt4(String op4)
    {
        this.opt4 = op4;
    }

    @Override
    public String toString()
    {
        return "Question{" + "question=" + text + ", opt1=" + opt1 + ", opt2=" + opt2 + ", opt3=" + opt3 + ", opt4=" + opt4 + '}';
    }
            
}