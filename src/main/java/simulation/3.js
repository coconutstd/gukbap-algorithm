let Card = {};

function dfs(i, card){
    if(card.visitor.includes(i)) return;
    card.count += 1;
    card.visitor.push(i);
    card.next = Card[i].next;
    console.log(i, card);
    if(card.next !== 0){
        dfs(card.next, card);
    }

    // if(card.visitor.includes(i)) return;


}

function solution(next_student) {
    var answer = 0;
    for(let i = 0 ; i < next_student.length; ++i){
        Card[i + 1] = {"maker" : i + 1 ,"next" : next_student[i], "count" : 0, "visitor": []};
    }
    for(let i = 0; i < next_student.length; ++i){
        dfs(i + 1, Card[i + 1]);
    }

    return answer;
}

let next_student = [5, 9, 13, 1, 0, 0, 11, 1, 7, 12, 9, 9, 2];

solution(next_student);
