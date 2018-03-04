function compile() {
  var code = document.getElementById("wingdings").value;
  xmlhttp = new XMLHttpRequest();

  var url = "compile";
  xmlhttp.open("POST", url, true);
  xmlhttp.onreadystatechange=function(){
    if (xmlhttp.readyState == 4){
        if(xmlhttp.status == 200){
            var compiledCodeTextbox = document.getElementById("compiledCode");
            compiledCodeTextbox.innerHTML = xmlhttp.responseText;
        }
    }
  };
  xmlhttp.setRequestHeader("Content-type", "text/plain");
  xmlhttp.send(code);
}

var textareas = document.getElementsByTagName('textarea');
var count = textareas.length;
for(var i=0;i<count;i++){
    textareas[i].onkeydown = function(e){
        if(e.keyCode==9 || e.which==9){
            e.preventDefault();
            var s = this.selectionStart;
            this.value = this.value.substring(0,this.selectionStart) + "\t" + this.value.substring(this.selectionEnd);
            this.selectionEnd = s+1;
        }
    }
}
