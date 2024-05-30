class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        int[] count = new int[2];
        for(int student:students){
            queue.offer(student);
            count[student]++;
        }

        int i=0;
        while(!queue.isEmpty()&&count[sandwiches[i]]>0){
            if (queue.peek()==sandwiches[i]){
                count[queue.poll()]--;
                i++;
            }else{
                queue.offer(queue.poll());
            }
        }
        return queue.size();
    }
}