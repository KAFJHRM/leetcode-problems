/**
 * @param {*} obj
 * @param {*} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function(obj, classFunction) {
    // If obj is null/undefined or classFunction is not a valid function/class
    if (obj === null || obj === undefined || typeof classFunction !== 'function') {
        return false;
    }

    // Traverse the prototype chain of obj
    let currProto = Object.getPrototypeOf(obj);
    while (currProto !== null) {
        if (currProto === classFunction.prototype) {
            return true;
        }
        currProto = Object.getPrototypeOf(currProto);
    }

    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */
