/**
 * Created by 7mu on 2016/9/2.
 */
'use strict';
var a = [];
for(let i=0;i<10;i++){
    a[i] = function () {
        console.log(i);
    }
}
a[6]();
