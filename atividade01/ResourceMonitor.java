/*
 *  Learning Project.
 */
package atividade01;

import java.util.LinkedList;
import java.util.Queue;

public class ResourceMonitor {
    private static final int MAX_QUEUE_SIZE = 5;
    private Queue<String> buffer = new LinkedList<>();
    private boolean empty = true;
    private boolean full = false;

    /* thread consumidora executa */    
    public synchronized String take() {
        while (empty) { // Está vazio ? espera
            System.out.println("Thread consumidora bloqueada pq tá vazio.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(">>" + e.getMessage());
            }
        }
        // Não está vazio ? consome
        String message = buffer.poll();
        full = false;
        notifyAll();
        if (buffer.size() == 0 ){
            empty = true;
        }
        return message;
    }

    /* thread produtora executa */
    public synchronized void put(String message) {
        while (full) { // Está cheio ? espera
            System.out.println("Thread produtora bloqueada pq tá cheio a fila.");
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(">>" + e.getMessage());
            }
        }
        // Não está cheio ? adiciona
        buffer.add(message);
        empty = false;
        notifyAll();
        if ( buffer.size() >= MAX_QUEUE_SIZE){
            full = true;
        }

    }
}
