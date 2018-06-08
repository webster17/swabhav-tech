(function(){
    
document.getElementById("range-bar").addEventListener("input", displayButtons);

displayButtons();

function displayButtons(){
    var buttonBox = document.getElementById('button-box');
    var range = document.getElementById("range-bar");
    var rangeValue = document.getElementById('range-value');
                
    var selectedRange = range.value;
    rangeValue.innerHTML = selectedRange;
    buttonBox.innerHTML = "";

    for(i=0; i<selectedRange; i++){
        var node = document.createElement("BUTTON");
        var textnode = document.createTextNode(i+1);
                    
        //node.className = "generatedButton";
        //node.id="button";
        node.value = i+1;
        node.addEventListener('click', dispalyConsole);
        node.appendChild(textnode);

        document.getElementById('button-box').append(node);
    }
}

function dispalyConsole(){
    console.log(this.value);
}
})();