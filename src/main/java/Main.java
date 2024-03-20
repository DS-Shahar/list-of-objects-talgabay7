class Main {
  public static Node<Task> insertList(Node<Task> p,Task task) {
		Node<Task> taskNode=new Node<Task>(task);
		boolean flag=false;
		Node<Task> first=new Node<>(null,p);
		p=first;
		while(p.hasNext()) {
			if(task.getPriority()<p.getNext().getValue().getPriority()&&!flag) {
				flag=true;
				taskNode.setNext(p.getNext());
				p.setNext(taskNode);
			}
			p=p.getNext();
		}
		if(!flag)
			p.setNext(taskNode);
		return first.getNext();
	}
	public static Node<Task> updateList(Node<Task> p,boolean b,int c){
		Task task;
		if(b)
			return p.getNext();
		task=p.getValue();
		task.subCredit(c);
		if(task.getCredit()<10) {
			task.addCredit(100);
			task.decPriority();
		}
		insertList(p,task);
		return p;
	}
	public static Node<Range> createRangeList(Node<Integer> sourceList){
		Node<Integer> p=sourceList;
		Node<Range> ranges=new Node<>(null);
		Node<Range> first=ranges;
		Range range;
		int from=p.getValue();
		int count=0;
		while(p.hasNext()) {
			if(p.getNext().getValue()-p.getValue()==1)
				count++;
			else {
				range=new Range(from,from+count);
				ranges.setNext(new Node<>(range));
				ranges=ranges.getNext();
				from=p.getNext().getValue();
				count=0;
			}
			p=p.getNext();
		}
		range=new Range(from,from+count);
		ranges.setNext(new Node<>(range));
		return first.getNext();
	}
	public static Scanner input=new Scanner(System.in);
	public static int length(Node<TavPlace> p) {
		int count=0;
		while(p!=null) {
			count++;
			p=p.getNext();
		}
		return count;
	}
	public static Node<String> word(Node<TavPlace> p){
		int len=length(p);
		Node<TavPlace> firstT=p;
		Node<String> letters=new Node<>(null);
		Node<String> firstL=letters;
		for(int i=1;i<=len;i++) {
			while(p.getValue().getPlace()!=i)
				p=p.getNext();
			letters.setNext(new Node<String>(p.getValue().getTav()));
			letters=letters.getNext();
			p=firstT;
		}
		return firstL.getNext();
	}
	public static String makeSentence(Node<TavPlace>[] a) {
		String sentence="";
		Node<String> word;
		for(int i=0;i<a.length;i++) {
			word=word(a[i]);
			while(word!=null) {
				sentence+=word.getValue();
				word=word.getNext();
			}
			sentence+=" ";
		}
		return sentence;
	}
	public static int dis(Queue<Integer> q,int x) {
		boolean flag=false;
		int count=-1;
		int distance=0;
		q.insert(null);
		while(q.head()!=null) {
			if(flag)
				count++;
			if(q.head()==x)
				flag=!flag;
			q.insert(q.remove());
		}
		q.remove();
		return distance;
	}
	public static int minDis(Queue<Integer> q) {
		int min=dis(q,q.head());
		Queue<Integer> q2=new Queue<>();
		while(!q.isEmpty()) {
			if(min>dis(q,q.head()))
				min=dis(q,q.head());
			q2.insert(q.remove());
		}
		while(!q2.isEmpty())
			q.insert(q2.remove());
		return min;
	}
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
