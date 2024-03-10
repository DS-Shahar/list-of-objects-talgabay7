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
  public static void main(String[] args) {
    System.out.println("Hello World!");
  }
}
