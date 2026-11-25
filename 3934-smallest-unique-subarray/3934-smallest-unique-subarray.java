import java.util.*;

class Solution {
public int smallestUniqueSubarray(int[] nums) {
int n = nums.length;

    if (n == 1) return 1;
    int[] sorted = nums.clone();
    Arrays.sort(sorted);
    int m = 0;
    for (int x : sorted) {
        if (m == 0 || sorted[m - 1] != x) {
            sorted[m++] = x;
        }
    }
    int[] a = new int[n + 1];
    for (int i = 0; i < n; i++) {
        a[i] = Arrays.binarySearch(sorted, 0, m, nums[i]) + 1;
    }
    int N = n + 1;
    int[] p = new int[N];
    int[] c = new int[N];
    int[] cnt = new int[Math.max(N, m + 1)];
    for (int x : a) cnt[x]++;
    for (int i = 1; i <= m; i++) cnt[i] += cnt[i - 1];
    for (int i = N - 1; i >= 0; i--)
        p[--cnt[a[i]]] = i;
    int classes = 1;
    c[p[0]] = 0;
    for (int i = 1; i < N; i++) {
        if (a[p[i]] != a[p[i - 1]]) classes++;
        c[p[i]] = classes - 1;
    }
    int[] pn = new int[N];
    int[] cn = new int[N];
    for (int h = 0; (1 << h) < N; h++) {
        int len = 1 << h;
        for (int i = 0; i < N; i++) {
            pn[i] = p[i] - len;
            if (pn[i] < 0) pn[i] += N;
        }
        Arrays.fill(cnt, 0, classes, 0);
        for (int x : pn) cnt[c[x]]++;
        for (int i = 1; i < classes; i++)
            cnt[i] += cnt[i - 1];
        for (int i = N - 1; i >= 0; i--)
            p[--cnt[c[pn[i]]]] = pn[i];
        cn[p[0]] = 0;
        int newClasses = 1;
        for (int i = 1; i < N; i++) {
            int cur = p[i];
            int prev = p[i - 1];
            if (c[cur] != c[prev] ||
                c[(cur + len) % N] != c[(prev + len) % N]) {
                newClasses++;
            }
            cn[cur] = newClasses - 1;
        }
        int[] temp = c;
        c = cn;
        cn = temp;
        classes = newClasses;
    }
    int[] sa = new int[n];
    for (int i = 1; i < N; i++)
        sa[i - 1] = p[i];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++)
        rank[sa[i]] = i;
    int[] lcp = new int[n];
    int k = 0;
    for (int i = 0; i < n; i++) {
        int r = rank[i];
        if (r == 0) continue;
        int j = sa[r - 1];
        while (i + k < n && j + k < n &&
               nums[i + k] == nums[j + k]) {
            k++;
        }
        lcp[r] = k;
        if (k > 0) k--;
    }
    int ans = n;
    for (int r = 0; r < n; r++) {
        int maxLcp = lcp[r];
        if (r + 1 < n)
            maxLcp = Math.max(maxLcp, lcp[r + 1]);
        int length = maxLcp + 1;
        if (length <= n - sa[r])
            ans = Math.min(ans, length);
    }
    return ans;
}

}