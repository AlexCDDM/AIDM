public class ListArray
{
    private int numberList;
    private List Begin;
    private List End;
    private int timer;
    ListArray(int timer)
    {
        this.numberList=0;
        this.Begin=null;
        this.End=null;
        this.timer=timer;
    }

    public void addList(int tableSize)
    {
        numberList++;
        List NewList=new List(timer,numberList,tableSize);
        if (Begin==null&&End==null)
        {
            Begin = NewList;
            End = NewList;
        }
        else
        {
            End.setNext(NewList);
            End=End.getNext();
        }
    }
    public void fixList(List pointer)
    {
        while (pointer!=null)
        {
            pointer.setListNum(pointer.getListNum()-1);
            pointer=pointer.getNext();
        }

    }
    public boolean deleteList(int ListNum)
    {
        List pointer=Begin;
        List prev=Begin;
        numberList--;
        if (Begin.getListNum()==ListNum)
        {
            Begin=Begin.getNext();
            pointer.setNext(null);
            this.fixList(Begin);
            return true;
        }
        while (pointer!=null)
        {
            if (pointer.getListNum()==ListNum)
            {
                if (pointer.getNext()==null)
                {
                    prev.setNext(null);
                    End=prev;
                }
                else
                {
                    prev.setNext(pointer.getNext());
                    pointer.setNext(null);
                    fixList(prev.getNext());
                }
                return true;
            }
            prev=pointer;
            pointer=pointer.getNext();
        }
        numberList++;
        return false;
    }
    public int numberList()
    {
        int i=0;
        List pointer=Begin;
        while (pointer!=null)
        {
            i++;
            pointer=pointer.getNext();
        }
        return i;
    }
    public boolean add(int AmountPeople,long ChatID)
    {
        List pointer=Begin;
        if (this.userInQueue(ChatID)==-1)
        {
            while (pointer != null)
            {
                if (pointer.getTableSize() >= AmountPeople && pointer.accessStatus()==true)
                {
                    pointer.add(ChatID);
                    return true;
                }
                pointer = pointer.getNext();
            }
        }
        return false;
    }

    public void out(int numberList)
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getListNum()==numberList)
            {
                pointer.out();
                return;
            }
            pointer=pointer.getNext();
        }
    }

    public void delete(int numberList,int Number)
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getListNum()==numberList)
            {
                pointer.delete(Number);
                return;
            }
            pointer=pointer.getNext();
        }
    }
    public void delete(int numberList, long ChatID)
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getListNum()==numberList)
            {
                pointer.delete(ChatID);
                return;
            }
            pointer=pointer.getNext();
        }
    }

    public void checker()
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            pointer.checker();
            pointer=pointer.getNext();
        }
    }
    public void info(int numberList)
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getListNum()==numberList)
            {
                pointer.info();
                return;
            }
            pointer=pointer.getNext();
        }
    }
    public boolean workerIsEmpty(int numberList)
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getListNum()==numberList)
            {
                return pointer.workerIsEmpty();
            }
            pointer=pointer.getNext();
        }
        System.out.println("Î÷åðåäü ñ äàííûì íîìåðîì íå íàéäåíà.");
        return false;
    }

    public void abort(int numberList)
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getListNum()==numberList)
            {
                pointer.abort();
                return;
            }
            pointer=pointer.getNext();
        }
    }

    public void abort(int numberList, long ChatID)
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getListNum()==numberList)
            {
                pointer.abort(ChatID);
                return;
            }
            pointer=pointer.getNext();
        }
    }

    public int outQueue(int numberList, long ChatID)
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getListNum()==numberList)
            {
                return pointer.outQueue(ChatID);
            }
            pointer=pointer.getNext();
        }
        return -1;
    }

    public void accessSwitch(int numberList)
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getListNum()==numberList)
            {
                pointer.accessSwitch();
                return;
            }
            pointer=pointer.getNext();
        }
    }

    public boolean accessStatus(int numberList)
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.getListNum()==numberList)
            {
                return pointer.accessStatus();
            }
            pointer=pointer.getNext();
        }
        return false;
    }
    public int userInQueue(long ChatID)
    {
        List pointer=Begin;
        while (pointer!=null)
        {
            if (pointer.userInQueue(ChatID)==true)
            {
                return pointer.getListNum();
            }
            pointer=pointer.getNext();
        }
        return -1;
    }
}