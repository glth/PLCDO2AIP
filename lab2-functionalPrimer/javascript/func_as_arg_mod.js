// Create a list of integers from a to b
function arrFunc(a, b) {
    let arr = [];

    for (let i = a; i <= b; i++) {
        arr.push(i);
    }

    return arr;
}

// Calculate the sum or average
function applicatorFunc(inpFunc, a, b, s) {
    const arr = inpFunc(a, b);

    // Calculate the sum of the array
    let sum = arr.reduce(
        (accumulator, currentValue) => accumulator + currentValue, 0
    );

    // Return the sum or average
    if (s == 's') {
        return sum;
    }
    else {
        return sum / arr.length;
    }
}

// Read command-line arguments
let a = Number(process.argv[2]);
let b = Number(process.argv[3]);
let s = process.argv[4];

// Calculate the result
let result = applicatorFunc(arrFunc, a, b, s);

// Display the result
console.log("result =", result);
