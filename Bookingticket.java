/*  Amar you are trying to book the ticket for PUSHPA 2
Amar Your ticket is booked for PUSHPA 2
star you are trying to book the ticket for PUSHPA 2
star Your ticket is booked for PUSHPA 2
mega you are trying to book the ticket for PUSHPA 2
mega Your ticket is booked for PUSHPA 2
charan you are trying to book the ticket for PUSHPA 2
charan Your ticket is booked for PUSHPA 2
Arjun you are trying to book the ticket for PUSHPA 2
Arjun Your ticket is booked for PUSHPA 2
ram you are trying to book the ticket for PUSHPA 2
ram Sorry Go and ask Allu arjun
Allu you are trying to book the ticket for PUSHPA 2
Allu Sorry Go and ask Allu arjun
vivek you are trying to book the ticket for PUSHPA 2
vivek Sorry Go and ask Allu arjun
Akash you are trying to book the ticket for PUSHPA 2
Akash Sorry Go and ask Allu arjun
Satheesh you are trying to book the ticket for PUSHPA 2
Satheesh Sorry Go and ask Allu arjun  */
class TBA implements Runnable{
    int avt=5;
    public void run()
    {
        String name = Thread.currentThread().getName();
        synchronized(this)
        {
            System.out.println(name+" you are trying to book the ticket for PUSHPA 2");
            if(avt>0)
            {
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e)
                {
                    System.out.println(name+" "+e);
                }
                avt--;
                System.out.println(name+" Your ticket is booked for PUSHPA 2");
            }else{
                System.out.println(name+" Sorry Go and ask Allu arjun ");
            }
        }
    }
}
class Bookingticket{
    public static void main(String args[])
    {
        TBA g = new TBA();
        Thread t1 = new Thread(g,"Amar");
        Thread t2 = new Thread(g,"Satheesh");
        Thread t3 = new Thread(g,"Akash");
        Thread t4 = new Thread(g,"vivek");
        Thread t5 = new Thread(g,"Allu");
        Thread t6 = new Thread(g,"Arjun");
        Thread t7 = new Thread(g,"ram");
        Thread t8 = new Thread(g,"charan");
        Thread t9 = new Thread(g,"mega");
        Thread t10 = new Thread(g,"star");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}