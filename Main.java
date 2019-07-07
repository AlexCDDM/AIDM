/**
 * Methods:
 * !!!!!!!!!!!!!!Нумерация идёт с 1!!!!!!!!!!!!!!
 * .addList(int TableSize) Создаёт новую очередь. На вход идёт размер стола.
 * .deleteList(int ListNum) Удаляет очередь с выбранным номером. Возвращает значение true или false в зависимости от того, удалилась ли очерель или нет.
 * .numberList() Возращает int значение кол-ва очередей.
 * .add(int AmountPeople,long ChatID) Добавление в список. На вход идёт номер очереди(стола) и номер телефона.
 * .out(int numberList) Выводит список на экран. Возможна переработка. Если список пусто то выведет сообщение на экран.
 * .delete(int numberList,int Number) Удаляет элемент с таким же номером. На вход идёт номер.
 * .delete(int numberList, long ChatID) Удаление юзера из очереди. Возращает результат удаления.
 * .info(int numberList) Выводит на экран линейный список и состояние процессора.
 * .workerIsEmpty(int numberList) Возращает состояние процессора
 * .abort(int numberList) Прерывает выполнение процесса
 * .abort(int numberList, long ChatID) Прерывает процесс при совпадении номера телефона
 * .outQueue(int numberList, long ChatID) Принимает ChatID и вызвращает номер в очереди. 
 * .accessStatus(int numberList) Возращает значение параметра enable данного стола.
 * .accessSwitch(int numberList) Меняет значение параметра enable на противоположное.
 * TODO
 * -Перевод кол-ва мест в столе в String
 * -Информация о столе
 *
 * TODO 
 * -Перевод номера стола в string
 */
public class Main {

    public static void main(String[] args) throws InterruptedException
    {
        int Timer=2000;
        ListArray Queue=new ListArray(Timer);
        AltherThread NewThread=new AltherThread(Queue, 1000);
        NewThread.start();
        Queue.addList(6);
        for (int i=0;i<10;i++)
            Queue.add(1, 123);

        System.out.println(Queue.outQueue(1,3));
        while (!Queue.workerIsEmpty(1))
        {
//			AltherThread.sleep(500);
            Queue.info(1);
            Thread.sleep(1000);
        }
        System.exit(0);
    }

}