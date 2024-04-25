class Solution(object):
    def longestIdealString(self, s, k):
        dp = [0] * 26  # Her karakter için ideal dizinin uzunluğunu depolamak için dp dizisi
        ans = 1  # En az bir karakter olduğunu varsayarak cevabı 1 ile başlat
        for char in s:
            ele = ord(char) - ord('a')  # Karakteri dp dizisindeki indeksine dönüştür
            for j in range(ele, max(-1, ele - k - 1), -1):  # Burada -1 yerine -k-1 olmalı
                dp[ele] = max(dp[ele], dp[j] + 1)
            for j in range(ele + 1, min(26, ele + k + 1)):
                dp[ele] = max(dp[ele], dp[j] + 1)
            ans = max(ans, dp[ele])  # Şimdiye kadar karşılaşılan maksimum uzunlukla cevabı güncelle
        return ans
