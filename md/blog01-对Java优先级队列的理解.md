
java中的优先级队列的实现是`PriorityQueue`

它的默认构造方式是按照小顶堆的形式存储元素，且需要指定固定的容量k

它可以存储对象，但是必须实现`Comparator`，这样才能进行比较

```
Comparator<? super E> comparator
```

### `PriorityQueue`是如何存储的？

- transient Object[] queue; //用一个队列---对象数组

- 默认初始容量是11

-  int size = 0; //记录当前有多少元素


```
private static final int DEFAULT_INITIAL_CAPACITY = 11;
```
### `PriorityQueue`的构造方法
- PriorityQueue(int initialCapacity,Comparator<? super E> comparator) 
- PriorityQueue(Collection<? extends E> c) 
- PriorityQueue(PriorityQueue<? extends E> c) 
- PriorityQueue(SortedSet<? extends E> c) 


它有一个自定义比较器的构造方法
```
 public PriorityQueue(int initialCapacity,
                         Comparator<? super E> comparator) {
        // Note: This restriction of at least one is not actually needed,
        // but continues for 1.5 compatibility
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }
```

### 如何使用`PriorityQueue`呢？

```
PriorityQueue<Query> queue = new PriorityQueue<>(k,
                    (o1,o2) -> {
                    if(o1.time == o2.time){
                        return o1.id - o2.id;
                    }
                    return o1.time - o2.time;
                }
            );
```

### PriorityQueue是如何实现堆的呢？

- void initElementsFromCollection(Collection<? extends E> c)  `初始化数据`
- void heapify() `堆化`
    - void siftDown(int k, E x)  `堆化的核心要点`
- void grow(int minCapacity)
    - static int hugeCapacity(int minCapacity) 
- void siftUp(int k, E x)  `k:the position to fill; X:the item to insert`
    
    
#### 核心方法

- boolean offer(E e)
    - 如果offer超出了queue.length,`grow(size+1)`  
    - 如果队列是空的,直接`queue[0] = e`
    - 否则`siftUp(i, e)` //先放到尾部,然后从下往上比较,i是尾部,e是要插入的元素 
-  E poll() 
    -  如果队列是空的 `return null`  
    -  size--
    -  取queue第零个`E result = (E) queue[0];
    -  去除queue的尾部记为x,然后`siftDown(0, x)` //从头部往下层
