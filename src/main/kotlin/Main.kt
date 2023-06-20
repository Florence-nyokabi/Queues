fun main() {
    var q =  Queue(6)
    q.enqueue(3)
    q.enqueue(4)
    q.enqueue(7)
    q.enqueue(6)
    q.display()
    q.dequeue()
    q.dequeue()
    q.display()

}
class Queue(var capacity: Int){
    var data = IntArray(capacity)
    var front = 0
    var rear = 0

    fun enqueue(item: Int){
        if (isFull()){
            println("Queue is full.")
            return
        }
        data[rear] = item
        rear++
    }

    fun dequeue(): Int?{
        if(isEmpty()){
            println("Queue is empty.")
            return null
        }
        var removed = data[front]
        for (i in front until rear - 1){
            data[i] = data[i+1]
        }
        rear--
        return removed
    }

    fun isFull(): Boolean{
        return rear == capacity
    }

    fun isEmpty(): Boolean{
        return rear == front
    }

    fun display(){
        if (isEmpty()){
            println("Queue is empty")
            return
        }
        for (i in front until rear){
            println(data[i])
        }
    }

    fun peek():Int?{
        if (isEmpty()){
            println("Queue is empty")
            return null
        }
        for (i in front until rear){
            println(data[front])
        }
        return front
    }


}
// Notes:
// When rear == capacity: queue is full
// When rear == front : queue is empty