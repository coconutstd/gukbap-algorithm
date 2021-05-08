function solution(weights, head2head) {
    let answer = [];
    const data = [];
    for(let i = 0; i < head2head.length; ++i){
        let rate = 0;
        let win = 0;
        let heavy = 0;
        for(let j = 0; j < head2head[i].length; ++j){
            if(i == j) continue;
            if(head2head[i][j] === 'W'){
                win += 1;
                if(weights[i] < weights[j]) heavy += 1;
            }
        }
        rate = win / (head2head[i].length - 1);
        data.push({number : i + 1, rate : rate, heavy : heavy, weight : weights[i]});
        console.log(i + 1, rate, heavy, weights[i]);
    }
    data.sort((a, b) => {
        if(a.rate === b.rate){
            if(a.heavy === b.heavy){
                if(a.weight === b.weight){
                    return a.number - b.number;
                }else return b.weight - a.weight;
            }else return b.heavy - a.heavy;
        } else return b.rate - a.rate;
    });
    answer = data;
    return answer;
}

solution([12,6,6,12,6,24,30,32,34,36,24,18,6,6,18,30,6]);
