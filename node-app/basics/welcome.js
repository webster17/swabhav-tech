// console.log("Hello, It is my first NodeJs App");
//console.log(process);
console.log("Hello, ");
process.argv.forEach(function (val, index, array) {
    if(index>1)
        console.log(index+': '+val);
});
// console.log('Hello,');
// for(i=2;i<process.argv.length;i++){
//     console.log('Args'+i+': '+process.argv[i]);
// }

var hours = new Date().getHours(); 
// console.log(hours);
if(hours>=5 && hours<11)
        console.log('Good Morning');
else if(hours>=11 && hours<16)
        console.log('Good Afternoon');
else if(hours>=16 && hours<20)
        console.log('Good Evening');
else if(hours>=20 || hours<5)
        console.log('Good Night');
