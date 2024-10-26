function mostPoints(questions: number[][]): number {
    const n = questions.length;
    const dp: number[] = new Array(n + 1).fill(0);

    for (let i = n - 1; i >= 0; i--) {
        const points = questions[i][0];
        const brainpower = questions[i][1];
        const nextIndex = i + brainpower + 1;

        const solve = points + (nextIndex < n ? dp[nextIndex] : 0);
        const skip = dp[i + 1];

        dp[i] = Math.max(solve, skip);
    }

    return dp[0];
}