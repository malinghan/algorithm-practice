
### HashSet vs TreeSet vs LinkedHashSet

https://zhuanlan.zhihu.com/p/29021276

HashSet底层声明了一个HashMap，HashSet做了一层包装，操作HashSet里的元素时其实是在操作HashMap里的元素。

TreeSet底层也是声明了一个TreeMap，操作TreeSet里的元素其实是操作TreeMap里的元素。

所以只需要比较HashMap&TreeMap difference
### HashMap vs TreeMap vs LinkedHashMap

https://zhuanlan.zhihu.com/p/44882350

TreeMap为增、删、改、查这些操作提供了log(N)的时间开销

- HashMap可实现快速存储和检索，但其缺点是其包含的元素是无序的，这导致它在存在大量迭代的情况下表现不佳。
- LinkedHashMap保留了HashMap的优势，且其包含的元素是有序的。它在有大量迭代的情况下表现更好。
- TreeMap能便捷的实现对其内部元素的各种排序，但其一般性能比前两种map差。(内存占用比`LinkedHashMap`少)

LinkedHashMap映射减少了HashMap排序中的混乱，且不会导致TreeMap的性能损失。




### TreeMap底层数据结构--红黑树

- [红黑树深入剖析及Java实现](https://zhuanlan.zhihu.com/p/24367771)