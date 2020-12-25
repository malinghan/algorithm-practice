Deque是java对于双端队列的定义，其中最直接的实现是LinkedList


http://fuseyism.com/classpath/doc/java/util/Deque-source.html


- void addFirst(E e);
-  void addLast(E e);
-  boolean offerFirst(E e);
-  boolean offerLast(E e);
-  E removeFirst();
-  E removeLast();
-  E pollFirst();
- E pollLast();


#### 什么场景下需要用到双端队列呢？？
- 滑动窗口
- 他是Stack的推荐实现 
   - `Deque<Integer> stack = new ArrayDeque<>();`
   - `class Stack<E> extends Vector<E>` Vector加了synchronized

