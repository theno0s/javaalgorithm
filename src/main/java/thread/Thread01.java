package thread;

// Thread 실행 메인 함수
public class Thread01 {

    public static void main(String[] args) {
        ThreadWithClass thread01 = new ThreadWithClass();   // Thread class 상속
        Thread thread02 = new Thread(new ThreadWithRunnable()); // Runnable interface 상속

        thread01.start();
        thread02.start();

        // 쓰레드 우선순위 확인

        System.out.println(thread01.getPriority());
        System.out.println(thread02.getPriority());
    }
}

// 쓰레드 직접 구현 클래스
class ThreadWithClass extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            // 실행 중인 쓰레드 이름 표시
            System.out.println(getName() + " :: ThreadWithClass"+i);
            try{
                // 0.01초간 쓰레드 멈춤
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

// Runnable 인터페이스 상속한 쓰레드 구현 클래스
class ThreadWithRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            // 실행 중인 쓰레드 이름 표시
            System.out.println(Thread.currentThread().getName() + " :: ThreadWithRunnable"+i);
            try {
                // 0.01초간 쓰레드 멈춤
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}