fs = require('fs')
log = console.log
ucFirst = s => s[0].toUpperCase() + s.slice(1)

file = 'src/org/usfirst/frc6442/Robot2018StartAgain/RobotValues.java'
re = /^\s*public\s+(\w+)\s+(\w+)(?:\s*=\s*([^;]+))?\s*;/
allowed = ['double', 'int', 'boolean']

content = fs.readFileSync(file, 'utf8')
lines = content.split('\n')

vars = lines.map(line => line.match(re)).filter(x => x).filter(x=>allowed.includes(x[1]))

outs = vars.map( ([l, type, name, value]) => 
  `${name} = get${ucFirst(type)}("${name}", ${value || 0});
  System.out.println("${name} = " + ${name});`
)

log(outs.join("\n"))