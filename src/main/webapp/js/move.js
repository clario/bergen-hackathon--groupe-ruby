rects = $('rect').sort(function(a,b) {return parseInt(a.id) > parseInt(b.id) ? 1 : -1});

trans1 = rects[99].transform;
trans2 = rects[100].transform;


forVoteringer = d3.selectAll(rects.slice(0,100)).remove();
motVoteringer = d3.selectAll(rects.slice(100)).remove();

d3.select('#layer1').insert('g').attr('id', 'forVoteringer');
d3.select('#layer1').insert('g').attr('id', 'motVoteringer');

$('#layer1 #forVoteringer').append(forVoteringer.map($));
$('#layer1 #motVoteringer').append(motVoteringer.map($));

d3.select('#forVoteringer')
    .transition()
    .attr('transform', 'translate(-20)');
d3.selectAll('#forVoteringer > rect')
    .transition()
    .style('fill', 'green');
d3.select('#motVoteringer')
    .transition()
    .attr('transform', 'translate(20)');
d3.selectAll('#motVoteringer > rect')
    .transition()
    .style('fill', 'red');
