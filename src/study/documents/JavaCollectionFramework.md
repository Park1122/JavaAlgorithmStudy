# List
* ArrayList
  * Add : O(1)
  * Remove : O(n)
  * Get : O(1)
  * Contains : O(n)
* LinkedList
  * Add : O(1)
  * Remove : O(1)
  * Get : O(n)
  * Contains : O(n)

> LinkedList의 시간 복잡도에서 remove의 경우, 삭제 엘리먼트에 대한 레퍼런스를 알고 있다는 가정 하에 O(1)이다. 
> 탐색의 행위까지 remove에 포함해야 한다면, O(n)으로 바뀔 것이다.
***

# Set
* HashSet
  * Add : O(1)
  * Contains : O(1)
  * Next : O(h/n)

> Next의 시간 복잡도에서 h는 해시버킷의 숫자이고, n은 해시 테이블을 이용하는 엘리먼트의 개수다.
> 이렇게 나오는 이유는 엘리먼트에 비해 해시버킷의 수가 늘어나면 해시버킷으로 사용하는 배열의 대부분은 
> 비어있게 되고, 엘리먼트가 담겨 있는 해시버킷을 찾기 위해 매번 비어있는 해시버킷을 방문해야하기 때문에
> h가 들어가게 된다.   
> 또한, 엘리먼트의 숫자가 늘어나면 해시버킷이 비어있을 가능성이 줄어들고, O(1)에 근접하게 된다.
> 이런 의미로 O(h/n)이라는 시간복잡도를 써 놓은 것으로 보인다.
***

# Queue
* PriorityQueue
  * Offer : O(log n)
  * Peak : O(1)
  * Poll : O(log n)
  * Size : O(1)
* LinkedList
  * Offer : O(1)
  * Peak : O(1)
  * Poll : O(1)
  * Size : O(1)
* ArrayDeque
  * Offer : O(1)
  * Peak : O(1)
  * Poll : O(1)
  * Size : O(1)

>공간복잡도의 경우 LinkedList를 이용하는 것보다, ArrayDeque를 이용하는 것이 훨씬 적다.
***

# Map
* HashMap
  * Get : O(1)
  * ContainsKey : O(1)
  * Next : O(h/n)
* TreeMap
  * Get : O(log n)
  * ContainsKey : O(log n)
  * Next : O(log n)

***

> 참고로 위의 시간복잡도는 Worst Case에 대한 시간 복잡도가 아닌 Amortized Analysis가 적용된 
> 평균적인 값을 표현한다.   
> 예를 들어, ArrayList의 경우에는 add 연산은 배열이 꽉 차게 되면 두 배 더 큰 새로운 배열에 엘리먼트들을
> 복사하는 최악의 경우가 있어 O(n)으로 적어야한다. 그러나 해당 연산을 Amortize 하여 평균 O(1)이라고
> 할 수 있게 된다.

***

*참고*  
http://infotechgems.blogspot.com/2011/11/java-collections-performance-time.html  
https://soft.plusblog.co.kr/74