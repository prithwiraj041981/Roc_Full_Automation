package javaexample;

class Sender{
    public void createAndSend(String r){
        String s="some data from Producer";
        r.recieve(s);
    }
}

class Reciever{
    public void recieve(String data){
        System.out.println("I recieved "+data);
    }
}


public class javaexample1 {

	public static void main(String[] args) {
		String r="prithvi";
		 Sender s=new Sender();
	       Reciever r1=new Reciever();
	        s.createAndSend(r);
		// TODO Auto-generated method stub

	}

}
