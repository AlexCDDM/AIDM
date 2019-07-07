public class List
{
    private int ListNum;
    private Info Begin;
    private Info End;
    private Processor Worker;
    private int timer;
    private int Number;
    private boolean enable;
    private int TableSize;
    private List next;

    List(int timer,int ListNum,int TableSize)
    {
        this.ListNum=ListNum;
        this.Number=1;
        this.timer=timer;
        this.Worker=new Processor(this.timer);
        this.enable=true;
        this.TableSize=TableSize;
    }

    public void add(long ChatID)
    {

        Info NewInfo=new Info();
        NewInfo.setChatID(ChatID);
        NewInfo.setNumber(Number);
        if (Begin==null&&End==null)
        {
            if (Worker.isEmpty())
            {
                Worker.fill(NewInfo);
            }
            else
            {
                Begin = NewInfo;
                End = NewInfo;
                End.setQueue(1);

            }
        }
        else
        {
            Info Prev=End;
            End.setNext(NewInfo);
            End=End.getNext();
            End.setPrev(Prev);
            End.setQueue(Prev.getQueue()+1);
        }
        Number++;
    }
    public void out()
    {
        Info pointer=Begin;
        if (Begin==null)
        {
            System.out.println("Queue is empty");

        }
        else
        {
            while (pointer != null)
            {
                System.out.println(pointer.getNumber() + " " + pointer.getQueue());
                pointer = pointer.getNext();
            }
        }
    }
    public void delete(int Number)
    {
        Info prev;
        Info pointer=Begin;
        if (Begin.getNumber()==Number)
        {
            Begin=Begin.getNext();
            pointer.setNext(null);
            this.fixQueue(Begin);
            return;
        }
        while (pointer!=null)
        {
            if (pointer.getNumber()==Number)
            {
                prev=pointer.getPrev();
                if (pointer.getNext()==null)
                {
                    prev.setNext(null);
                    pointer.setPrev(null);
                }
                else
                {
                    prev.setNext(pointer.getNext());
                    pointer.setNext(null);
                    pointer.setPrev(null);
                    this.fixQueue(prev.getNext());
                }
                return;
            }
            pointer=pointer.getNext();
        }
    }
    public void fixQueue(Info pointer)
    {
        while (pointer!=null)
        {
            pointer.setQueue(pointer.getQueue()-1);
            pointer=pointer.getNext();
        }
    }
    public boolean delete(long ChatID)
    {
        if (findNumber(ChatID)!=-1)
        {
            this.delete(findNumber(ChatID));
            return true;
        }
        return false;
    }

    public int findNumber(long ChatID)
    {
        Info pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getChatID()==ChatID)
                return pointer.getNumber();
            pointer=pointer.getNext();
        }
        return -1;
    }

    public void checker()
    {
        if (Worker.isEmpty() && Begin!=null)
        {
            Worker.fill(Begin);
            this.delete(Begin.getNumber());
        }
        else if (Worker.getReserved() < System.currentTimeMillis() && Begin!=null)
        {
            Worker.fill(Begin);
            this.delete(Begin.getNumber());
        }
        else if ((Worker.getReserved() < System.currentTimeMillis()) && Begin==null)
        {
            Worker.reset();
        }
    }
    public void info()
    {
        if (Worker.isEmpty())
            System.out.println("Worker is empty");
        else
            System.out.println("Worker under process ¹ "+Worker.getNumber());
        this.out();
    }
    public boolean workerIsEmpty()
    {
        return Worker.isEmpty();
    }
    public void abort()
    {
        Worker.reset();
    }
    public void abort(long ChatID)
    {
        Worker.reset(ChatID);
    }
    public int outQueue(long ChatID)
    {
        Info pointer=Begin;
        Number=findNumber(ChatID);
        while (pointer!=null)
        {
            if (pointer.getNumber() == Number)
                return pointer.getQueue();
            else
                pointer = pointer.getNext();
        }
        return -1;
    }

    public boolean userInQueue(long ChatID)
    {
        Info pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getChatID()==ChatID)
                return true;
            pointer=pointer.getNext();
        }
        return false;
    }

    public void accessSwitch()
    {
        if (enable==true)
            enable=false;
        else
            enable=true;
    }
    public boolean accessStatus()
    {
        return enable;
    }

    public List getNext() {
        return next;
    }

    public void setNext(List next) {
        this.next = next;
    }

    public int getListNum() {
        return ListNum;
    }

    public void setListNum(int listNum) {
        ListNum = listNum;
    }

    public int getTableSize() {
        return TableSize;
    }

    public void setTableSize(int tableSize) {
        TableSize = tableSize;
    }
    public List getThis()
    {
        return this;
    }

}