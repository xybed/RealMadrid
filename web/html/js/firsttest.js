/**
 * Created by 7mu on 2016/8/26.
 */
var isBlack = true;
var chessBoard = [];
for(var i=0;i<15;i++){
    chessBoard[i] = [];
    for(var j=0;j<15;j++){
        chessBoard[i][j] = 0;
    }
}
var chess = document.getElementById('chess');
var context = chess.getContext('2d');

context.strokeStyle = '#BFBFBF';

var drawChessBoard = function () {
    for(var i=0;i<15;i++){
        context.moveTo(15 + i * 30, 15);
        context.lineTo(15 + i * 30, 435);
        context.stroke();
        context.moveTo(15, 15 + i * 30);
        context.lineTo(435, 15 + i * 30);
        context.stroke();
    }
};

drawChessBoard();

var oneStep = function (i, j, isBlack) {
    context.beginPath();
    context.arc(15 + i * 30, 15 + j * 30, 13, 0, 2 * Math.PI);
    context.closePath();
    var gradient = context.createRadialGradient(15 + i * 30 + 2, 15 + j * 30 - 2, 13, 15 + i * 30 + 2, 15 + j * 30 - 2, 0);
    if(isBlack){
        gradient.addColorStop(0, '#0A0A0A');
        gradient.addColorStop(1, '#636363');
    }else{
        gradient.addColorStop(0, '#D1D1D1');
        gradient.addColorStop(1, '#F9F9F9');
    }
    context.fillStyle = gradient;
    context.fill();
};

chess.onclick = function (e) {
    var x = e.offsetX;
    var y = e.offsetY;
    var i = Math.floor(x / 30);
    var j = Math.floor(y / 30);
    if(chessBoard[i][j] === 0){
        oneStep(i, j, isBlack);
        if(isBlack){
            chessBoard[i][j] = 1;
        }else {
            chessBoard[i][j] = 2;
        }
        isBlack = !isBlack;
    }
};