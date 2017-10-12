document.write("1. Shapes");
document.write("<br>");


function printShape() {
    var shape = arguments[0];
    var height = arguments[1];
    var character = arguments[2];

    if(arguments.length > 3) {
        console.log("This is not right");
    }

    if(shape === "Square") {
        for(i = 0; i < height; i++) {
            str = "";
            for(j = 0; j < height; j++) {
                str += character;
            }
            str += '<br>';
            document.write(str);
        }
    } else if(shape === "Triangle") {
        for(i = 0; i < height; i++) {
            str = ""
            for(j = 0; j < j + i; i++) {
                str += character;
            }
            str += '<br>';
            document.write(str);
        }
    } else if(shape === "Diamond") {
        var mid = (height-1)/2;
            for (var i = 0; i < height; i++) {
                var str = "";
                var white = Math.abs(i - mid);
                for (var j = 0; j < height - white; j++) {
                    if (j < white) {
                        str += "&nbsp;&nbsp;";
                    } else {
                        str += character;
                    }
                }
                str += "<br>";
                document.write(str);
            }
            document.write("<br>");
    }
}
// document.write("1. Shapes<br>");
// printShape("Square", 3, "%");
// document.write('<br>');
// printShape("Triangle", 3, "$");
// document.write('<br>');
// printShape("Diamond", 5, "*");

document.write("2. Object literal");
document.write("<br>");

var superAwesomeObject = {
    name: "jay",
    major: "cs",
    age: 3
}

function traverseObject(randomStuff) {
    for( i in randomStuff) {
        document.write(i + " " + randomStuff[i] + "<br>");
    }
}

document.write("3. Delete Element");
document.write("<br>");

random = [1,2,3,4,5];

function deleteElement(randomStuff) {
    document.write("current length: " + randomStuff.length + "<br>");
    if(randomStuff.length > 2) {
        delete randomStuff[2];
    }
    document.write("current length: " + randomStuff.length + "<br>");
}

