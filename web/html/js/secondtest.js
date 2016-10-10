/**
 * Created by 7mu on 2016/8/30.
 */
function lazy_sum(arr) {
    var sum = function () {
        return arr.reduce(function (x, y) {
            return x + y;
        })
    };
    return sum;
}

var f = lazy_sum([1,2,3,4,5]);
console.log(f);
console.log(f());

function count() {
    var arr = [];
    for(var i=1;i<=3;i++){
        arr.push((function (n) {
            return function () {
                return n * n;
            };
        })(i));
    }
    return arr;
}

var result = count();
var f1 = result[0];
var f2 = result[1];
var f3 = result[2];
console.log(f1());
console.log(f2());
console.log(f3());

function create_counter(initial) {
    var x = initial || 0;
    return function () {
        x += 1;
        return x;
    }
}

var c1 = create_counter();
console.log(c1());

//x的y次方可以用Math.pow(x, y)函数
function make_pow(y) {
    return function (x) {
        return Math.pow(x, y);
    }
}

var pow2 = make_pow(2);
var pow3 = make_pow(3);

console.log(pow2(5));
console.log(pow3(7));