class Solution(object):
    def countStudents(self, students, sandwiches):
        """
        :type students: List[int]
        :type sandwiches: List[int]
        :rtype: int
        """
        queue = deque(students)  # Öğrencileri bir kuyrukta saklıyoruz.
        count = [0, 0]  # Her sandviç türü için tercih sayısını tutuyoruz.
        
        # Öğrenci tercihlerini sayıyoruz.
        for student in students:
            count[student] += 1
        
        i = 0
        while queue and count[sandwiches[i]] > 0:
            if queue[0] == sandwiches[i]:
                # Eğer kuyruğun başındaki öğrenci sandviçi yiyebiliyorsa
                count[queue.popleft()] -= 1
                i += 1
            else:
                # Eğer yiyemiyorsa, öğrenciyi kuyruğun sonuna ekliyoruz.
                queue.append(queue.popleft())
        
        # Yiyemeyen öğrencilerin sayısını döndürüyoruz.
        return len(queue)
