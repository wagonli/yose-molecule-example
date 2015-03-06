document.grid = [
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'bomb' , 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
   ];

function load() {
    var cellId;

    for(var line = 0; line < 8; line++)  {
        for(var col = 0; col < 8; col++)  {
            if(document.grid[line][col] == 'bomb') {
                cellId = 'cell-' + (line + 1) + 'x' + (col + 1);

                document.getElementById(cellId).addEventListener('click', clickOnMine);
            }
        }
    }
}

function clickOnMine(event) {
    event.target.className = 'lost';
}