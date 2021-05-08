function solution(prices) {
    var answer = [];
    for(let i = 1; i < prices.length - 1; ++i){
        let left = prices[i - 1] - prices[i];
        let right = prices[i] - prices[i + 1];
        if(left * right < 0) {
            let width = 0;
            let from_left = 0;
            let from_right = 0;
            // 상봉이면
            if(left < 0){
                for(let j = i; j > 0; --j){
                    if(prices[j - 1] - prices[j] < 0){
                        from_left += 1;
                    } else break;
                }

                for(let j = i; j < prices.length - 1; ++j){
                    if(prices[j + 1] - prices[j] < 0){
                        from_right += 1;
                    } else break;
                }
                width = Math.min(from_left, from_right);
            }
            // 하봉이면
            else {
                for(let j = i; j > 0; --j){
                    if(prices[j - 1] - prices[j] > 0){
                        from_left += 1;
                    } else break;
                }

                for(let j = i; j < prices.length - 1; ++j){
                    if(prices[j + 1] - prices[j] > 0){
                        from_right += 1;
                    } else break;
                }
                width = Math.min(from_left, from_right);
                width = -1 * width;
            }
            answer.push(width);
        }
    }
    return answer;
}

console.log(solution([12,6,6,12,6,24,30,32,34,36,24,18,6,6,18,30,6]));
