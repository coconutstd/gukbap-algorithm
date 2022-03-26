const inp_str = "AaTa+!12-3"
const inp_str2 = "aaaaZZZZ)"
const inp_str3 = "CaCbCgCdC888834A"
const inp_str4 = "UUUUU"
const inp_str5 = "ZzZz9Z824"

const upperCase = []
const lowerCase = []
const numbers = []
const special = ['~', '!', '@', '#', '$', '%', '^', '&', '*']
for(let i = 0; i < 26; ++i) {
  upperCase.push(String.fromCharCode('A'.charCodeAt(0) + i))
  lowerCase.push(String.fromCharCode('a'.charCodeAt(0) + i))
  if(i < 10) numbers.push('' + i)
}


function solution(inp_str) {
  const answer = []
  if(inp_str.length < 8 || inp_str.length > 15) answer.push(1)

  const category = []
  let isUpper = false
  let isLower = false
  let isNum = false
  let isSpe = false
  for(let i = 0; i < inp_str.length; ++i) {
    const upper = upperCase.includes(inp_str[i])
    const lower = lowerCase.includes(inp_str[i])
    const num = numbers.includes(inp_str[i])
    const spe = special.includes(inp_str[i])
    if(!upper && !lower && !num && !spe) {
      if (!answer.includes(2)) answer.push(2)
    }
    if(upper && !isUpper) {category.push(1); isUpper = true}
    if(lower && !isLower) {category.push(2); isLower = true}
    if(num && !isNum) {category.push(3); isNum = true}
    if(spe && !isSpe) {category.push(4); isSpe = true}
 }
 if(category.length < 3) answer.push(3)
 
 let checkFour = false
 for(let i = 0; i < inp_str.length; ++i){
  for(let j = i + 1; j < i + 4; ++j){
    if (j === inp_str.length - 1 && inp_str[i] !== inp_str[j]) break
    if (inp_str[i] !== inp_str[j]) break
    checkFour = true
  }
 }
 if(checkFour && !answer.includes[4]) answer.push(4)

 const characterSet = new Set(inp_str)
 for(const char of characterSet) {
   let index = inp_str.indexOf(char)
   let count = 1
    while(index !== -1){
      index = inp_str.indexOf(char, index + 1)
      if (index !== -1) count++
    }
   if (count >= 5) {
     if (!answer.includes(5)) answer.push(5)
   }
 }

 if(answer.length === 0) answer.push(0)
 console.log(answer)
}

solution(inp_str)
solution(inp_str2)
solution(inp_str3)
solution(inp_str4)
solution(inp_str5)