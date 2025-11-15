package Exam_33;

import Exam_33.vo.Client;

import java.util.Scanner;

public class Service {
    Client client;
    private Client[] clients = new Client[100];
    private int cnt  = 0;
    public Boolean checker(String csn){
        for (int i = 0; i < cnt; i++) {
            if(clients[i].getCsn().equals(csn)){
                return false;
            }
        }
        return  true;
    }
    public void addregister(String csn,String name
            ,double weight,double height){
        client = new Client(csn,name,weight,height);
        clients[cnt++] = client;
    }
    public void print(){
        for (int i = 0; i < cnt; i++) {

        System.out.println(clients[i].toString());
        }
    }

}
