

function doCrypt(isDecrypt, passedMessage) {
	var shiftText = 13;
	var answer;

	var key = parseInt(shiftText, 10);

	if (key < 0 || key >= 26) {
		alert("Shift is out of range");
		return;
	}
	if (isDecrypt)
		key = (26 - key) % 26;
	
	answer = crypt(passedMessage, key, isDecrypt);
	
	return answer
}


/*
 * Returns the result of having each letter of the given text shifted forward by the given key, with wraparound. Case is preserved, and non-letters are unchanged.
 * Examples:
 *   crypt("abz", 1) = "bca"
 *   crypt("THe 123 !@#$", 13) = "GUr 123 !@#$"
 */
function crypt(input, key, isDecrypting) {

	var output = "";
	
		for (var i = 0; i < input.length; i++) {
		
		var c = input.charCodeAt(i);

        //console.log("WAS   " + input[i] + " charCode: " + c);


		if(!isDecrypting){

            if      (c >= 65 && c <=  90)
                output += String.fromCharCode((c - 65 + key) % 26 + 65);  // Uppercase

            else if (c >= 97 && c <= 122)
                output += String.fromCharCode((c - 97 + key) % 26 + 97);  // Lowercase

			else if ( c >= 48 && c <= 57)
				output += String.fromCharCode((c - 11)); //numbers

			else if ( c == 44)
				output += String.fromCharCode((33));//comma delimiter

            else
                output += input.charAt(i);  // Copy
		}
		
		else{

            if      (c >= 65 && c <=  90)
                output += String.fromCharCode((c - 65 + key) % 26 + 65);  // Uppercase

            else if (c >= 97 && c <= 122)
                output += String.fromCharCode((c - 97 + key) % 26 + 97);  // Lowercase

			else if(c >= 37 && c <= 46)
				output += String.fromCharCode((c + 11));//is a number
		
			else if (c == 33)
				output += String.fromCharCode(44); //comma delimiter
            else
                output += input.charAt(i);  // Copy
		}


        //console.log("IS    " + output[output.length -1] + " charCode: " + output.charCodeAt(output.length - 1) + "\n\n");
	
	    }
	return output;
}