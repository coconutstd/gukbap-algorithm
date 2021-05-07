function solution(participant, completion) {
    let answer = '';
    let list = new Map();
    participant.forEach(p => {
        if (list.has(p) === true){
            list.set(p, list.get(p) + 1);
        } else {
            list.set(p, 1);
        }
    });
    completion.forEach(c => {
       list.set(c, list.get(c) - 1);
    });
    list.forEach((k, v) => {
        if(k !== 0){
            answer = v;
        }
    });
    return answer;
}

solution(["leo", "kiki", "eden"], ["eden", "kiki"]);
