class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            robots.add(new int[] { positions[i], healths[i], directions.charAt(i), i });
        }

        Collections.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack = new Stack<>();

        for (int[] robot : robots) {
            if (robot[2] == 'R' || stack.isEmpty() || stack.peek()[2] == 'L') {
                stack.push(robot);
                continue;
            }

            if (robot[2] == 'L') {
                boolean add = true;
                while (!stack.isEmpty() && stack.peek()[2] == 'R' && add) {
                    int last_health = stack.peek()[1];
                    if (robot[1] > last_health) {
                        stack.pop();
                        robot[1] -= 1;
                    } else if (robot[1] < last_health) {
                        stack.peek()[1] -= 1;
                        add = false;
                    } else {
                        stack.pop();
                        add = false;
                    }
                }

                if (add) {
                    stack.push(robot);
                }
            }
        }

        List<int[]> resultList = new ArrayList<>(stack);
        resultList.sort(Comparator.comparingInt(a -> a[3]));

        List<Integer> result = new ArrayList<>();
        for (int[] robot : resultList) {
            result.add(robot[1]);
        }

        return result;
    }
}

/*
 * class Robot {
 * public int index;
 * public int position;
 * public int health;
 * public char direction;
 * public Robot(int index, int position, int health, char direction) {
 * this.index = index;
 * this.position = position;
 * this.health = health;
 * this.direction = direction;
 * }
 * }
 * 
 * class Solution {
 * public List<Integer> survivedRobotsHealths(int[] positions, int[] healths,
 * String directions) {
 * List<Integer> ans = new ArrayList<>();
 * Robot[] robots = new Robot[positions.length];
 * List<Robot> stack = new ArrayList<>(); // running robots
 * 
 * for (int i = 0; i < positions.length; ++i)
 * robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
 * 
 * Arrays.sort(robots, (a, b) -> a.position - b.position);
 * 
 * for (Robot robot : robots) {
 * if (robot.direction == 'R') {
 * stack.add(robot);
 * continue;
 * }
 * // Collide with robots going right if any.
 * while (!stack.isEmpty() && stack.get(stack.size() - 1).direction == 'R' &&
 * robot.health > 0) {
 * if (stack.get(stack.size() - 1).health == robot.health) {
 * stack.remove(stack.size() - 1);
 * robot.health = 0;
 * } else if (stack.get(stack.size() - 1).health < robot.health) {
 * stack.remove(stack.size() - 1);
 * robot.health -= 1;
 * } else { // stack[-1].health > robot.health
 * stack.get(stack.size() - 1).health -= 1;
 * robot.health = 0;
 * }
 * }
 * if (robot.health > 0)
 * stack.add(robot);
 * }
 * 
 * stack.sort((a, b) -> a.index - b.index);
 * 
 * for (Robot robot : stack)
 * ans.add(robot.health);
 * 
 * return ans;
 * }
 * }
 */
/*
 * class Solution {
 * public List<Integer> survivedRobotsHealths(int[] positions, int[] healths,
 * String directions) {
 * int n=positions.length;
 * int[] res=new int[n];
 * Arrays.fill(res, -1);
 * 
 * List<int[]> robots=new ArrayList<>();
 * for(int i=0;i<positions.length;i++) {
 * robots.add(new int[]{positions[i], healths[i], i});
 * }
 * Collections.sort(robots, (a,b)->a[0]-b[0]);
 * 
 * Deque<int[]> left=new ArrayDeque<>();
 * Deque<int[]> right=new ArrayDeque<>();
 * 
 * for(int[] robot:robots) {
 * if(directions.charAt(robot[2])=='R') {
 * right.push(robot);
 * } else {
 * while(!right.isEmpty()) {
 * int[] r=right.peek();
 * if(r[1]>robot[1]) {
 * r[1]--;
 * robot[1]=0;
 * break;
 * } else if(r[1]<robot[1]) {
 * r[1]=0;
 * robot[1]--;
 * right.pop();
 * } else {
 * r[1]=0;
 * robot[1]=0;
 * right.pop();
 * break;
 * }
 * }
 * if(robot[1]>0) {
 * left.push(robot);
 * }
 * }
 * }
 * while(!right.isEmpty()) {
 * int[] robot=right.pop();
 * res[robot[2]]=robot[1];
 * }
 * while(!left.isEmpty()) {
 * int[] robot=left.pop();
 * res[robot[2]]=robot[1];
 * }
 * List<Integer> resList=new ArrayList<>();
 * for(int h:res) {
 * if(h>0) {
 * resList.add(h);
 * }
 * }
 * return resList;
 * }
 * }
 */
/*
 * class Solution {
 * 
 * public List<Integer> survivedRobotsHealths(
 * int[] positions,
 * int[] healths,
 * String directions
 * ) {
 * int n = positions.length;
 * Integer[] indices = new Integer[n];
 * List<Integer> result = new ArrayList<>();
 * Stack<Integer> stack = new Stack<>();
 * 
 * for (int index = 0; index < n; ++index) {
 * indices[index] = index;
 * }
 * 
 * Arrays.sort(
 * indices,
 * (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs])
 * );
 * 
 * for (int currentIndex : indices) {
 * // Add right-moving robots to the stack
 * if (directions.charAt(currentIndex) == 'R') {
 * stack.push(currentIndex);
 * } else {
 * while (!stack.isEmpty() && healths[currentIndex] > 0) {
 * // Pop the top robot from the stack for collision check
 * int topIndex = stack.pop();
 * 
 * // Top robot survives, current robot is destroyed
 * if (healths[topIndex] > healths[currentIndex]) {
 * healths[topIndex] -= 1;
 * healths[currentIndex] = 0;
 * stack.push(topIndex);
 * } else if (healths[topIndex] < healths[currentIndex]) {
 * // Current robot survives, top robot is destroyed
 * healths[currentIndex] -= 1;
 * healths[topIndex] = 0;
 * } else {
 * // Both robots are destroyed
 * healths[currentIndex] = 0;
 * healths[topIndex] = 0;
 * }
 * }
 * }
 * }
 * 
 * // Collect surviving robots
 * for (int index = 0; index < n; ++index) {
 * if (healths[index] > 0) {
 * result.add(healths[index]);
 * }
 * }
 * return result;
 * }
 * }
 */