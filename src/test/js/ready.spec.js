describe('minesweeper', function () {
    var documentGrid = [
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'bomb' , 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
        ['empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty', 'empty'],
   ];

   beforeEach(function() {
        var htmlTable = '<table>';
        for(var line = 1; line <= 8; line ++) {
            htmlTable += '<tr>';
            for(var col = 1; col <= 8; col ++) {
                htmlTable += '<td id="cell-' + line + 'x' + col + '"></td>';
            }
            htmlTable += '</tr>';
        }
        htmlTable += '</table>';
        document.body.innerHTML = htmlTable;
   });

    it('has mine on trapped cell', function() {
        document.grid = documentGrid;
        load();
        var trappedCell = document.getElementById('cell-3x6');
        assert.equal(trappedCell.className, 'lost');
    });

    it('has no mine on not trapped cell', function() {
        document.grid = documentGrid;
        load();
        var trappedCell = document.getElementsByClassName('lost');
        assert.equal(trappedCell.length, 1);
        assert.equal(trappedCell[0].id, 'cell-3x6');
    });
});