function findMaxLength(calendar){
    let max = 0;
    let cur = 0;
    for(let i = 0; i < calendar.length - 1; ++i){
        if(calendar[i] === true && calendar[i] === calendar[i + 1]){
            cur = cur === 0 ? 2 : cur + 1;
            max = Math.max(cur, max);
        } else {
            cur = 0;
        }
    }
    return max;
}

function solution(leave, day, holidays){
    var answer = -1;
    let calendar = [];
    const week = ["MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"];
    let today = week.indexOf(day);
    for(let i = 0; i < 30; ++i){
        if(week[today] === "SAT" || week[today] === "SUN"){
            calendar.push(true);
        } else {
            calendar.push(false);
        }
        today = (today + 1) % 7;
    }
    holidays.forEach(a => calendar[a - 1] = true);
    for(let i = 0; i < 30; ++i){
        if(calendar[i] === false){
            let start = i;
            console.log(calendar);
            let copy = [...calendar];
            let remain = leave;
            while(remain != 0 && start < 30){
                if(copy[start] === false){
                    remain -= 1;
                    copy[start] = true;
                }
                start += 1;
            }
            answer = Math.max(answer, findMaxLength(copy));
        }
    }
}

solution(4, "FRI", [6, 21, 23, 27, 28]);
