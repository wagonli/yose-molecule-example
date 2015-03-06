describe('minesweeper', function () {
    var mouse;

    beforeEach(function() {
        mouse = effroi.mouse;
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

    it('has no mine after load', function() {
        load();
        var trappedCell = document.getElementsByClassName('lost');
        assert.equal(trappedCell.length, 0);
    });

    it('has lost after click on trapped cell', function() {
        load();
        var trappedCell = document.getElementById('cell-3x6');
        mouse.click(trappedCell);
        assert.include(trappedCell.className, 'lost');
    });

    it('does not lose after click on safe cell', function() {
        load();
        var safeCell = document.getElementById('cell-2x5');
        mouse.click(safeCell);
        assert.notInclude(safeCell.className, 'lost');
    });

    it('mine does not change after click on safe cell', function() {
        load();
        var safeCell = document.getElementById('cell-2x5');
        mouse.click(safeCell);
        var trappedCell = document.getElementById('cell-3x6');
        assert.notInclude(trappedCell.className, 'lost');
    });

});