rects = $('rect').sort(function(a,b) {
return parseInt(a.id) > parseInt(b.id) ? 1 : -1}
);

f = 90;
i = 40;

forVote = d3.selectAll(rects.slice(0,f)).remove();
ikkeVote = d3.selectAll(rects.slice(f, i+f)).remove();
motVote = d3.selectAll(rects.slice(i+f,169)).remove();

d3.select('#layer1').insert('g').attr('id', 'forVote');
d3.select('#layer1').insert('g').attr('id', 'ikkeVote');
d3.select('#layer1').insert('g').attr('id', 'motVote');

$('#layer1 #forVote').append(forVote.map($));
$('#layer1 #ikkeVote').append(ikkeVote.map($));
$('#layer1 #motVote').append(motVote.map($));

d3.selectAll('#forVote > rect')
    .transition()
    .style('fill', 'green');
d3.selectAll('#ikkeVote > rect')
    .transition()
    .style('fill', 'gray');
d3.selectAll('#motVote > rect')
    .transition()
    .style('fill', 'red');
