public class Solution {
    public ListNode doubleIt(ListNode head) {
        // Bağlı listeyi ters çevirme
        ListNode reversedList = reverseList(head);
        // Carry ve önceki düğümü takip etmek için değişkenleri başlatma
        int carry = 0;
        ListNode current = reversedList, previous = null;

        // Ters çevrilen bağlı listeyi tarayarak işlem yapma
        while (current != null) {
            // Geçerli düğüm için yeni değeri hesaplama
            int newValue = current.val * 2 + carry;
            // Geçerli düğümün değerini güncelleme
            current.val = newValue % 10;
            // Bir sonraki iterasyon için carry'yi güncelleme
            carry = (newValue > 9) ? 1 : 0;
            // Bir sonraki düğüme geçme
            previous = current;
            current = current.next;
        }

        // Döngüden sonra carry varsa ek bir düğüm ekleme
        if (carry != 0) {
            ListNode extraNode = new ListNode(carry);
            previous.next = extraNode;
        }

        // Orijinal sırayı elde etmek için listeyi tekrar ters çevirme
        ListNode result = reverseList(reversedList);

        return result;
    }

    // Bağlı listeyi ters çeviren metot
    public ListNode reverseList(ListNode node) {
        ListNode previous = null, current = node, nextNode;

        // Orijinal bağlı listeyi tarama
        while (current != null) {
            // Bir sonraki düğümü saklama
            nextNode = current.next;
            // Bağlantıyı tersine çevirme
            current.next = previous;
            // Bir sonraki düğümlere geçme
            previous = current;
            current = nextNode;
        }
        // previous, ters çevrilmiş listenin yeni başı olur
        return previous;
    }
}
